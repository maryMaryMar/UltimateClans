package me.ulrich.clans.licensing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 * Orquestador del módulo de licencias.
 *
 * <p>Flujo de una comprobación:</p>
 * <ol>
 *   <li>Se lee la caché local y se detecta un posible retroceso del reloj.</li>
 *   <li>Si hay token guardado, se verifica su firma, producto y caducidad.</li>
 *   <li>Si no sirve, se pide uno nuevo al servidor.</li>
 *   <li>Si el servidor no responde y el token caducó hace poco, se entra en {@code GRACE}.</li>
 * </ol>
 *
 * <p>La clase no depende de Bukkit: recibe la carpeta de datos y un consumidor de log, así que
 * se puede probar sin servidor.</p>
 */
public final class LicenseManager implements AutoCloseable {

    /** Margen para no fallar por pequeñas diferencias de reloj entre arranques. */
    private static final long CLOCK_TOLERANCE_MILLIS = Duration.ofMinutes(10).toMillis();

    private final LicenseConfig config;
    private final Path cacheFile;
    private final String serverId;
    private final String serverName;
    private final String pluginVersion;
    private final Consumer<String> logger;
    private final AtomicReference<LicenseResult> lastResult = new AtomicReference<>();
    private final PublicKey publicKey;
    private final LicenseClient client;

    private ScheduledExecutorService scheduler;

    public LicenseManager(LicenseConfig config, Path dataDirectory, String serverId, String serverName,
                          String pluginVersion, Consumer<String> logger) {
        this.config = Objects.requireNonNull(config, "config");
        Objects.requireNonNull(dataDirectory, "dataDirectory");
        this.cacheFile = dataDirectory.resolve(config.cacheFileName());
        this.serverId = serverId == null ? "unknown" : serverId;
        this.serverName = serverName == null ? "" : serverName;
        this.pluginVersion = pluginVersion == null ? "" : pluginVersion;
        this.logger = logger == null ? text -> { } : logger;
        this.publicKey = config.enabled() && !config.publicKeyBase64().isBlank()
                ? LicenseSignature.decodePublicKey(config.publicKeyBase64())
                : null;
        this.client = config.mode() == LicenseMode.REMOTE ? new LicenseClient(config) : null;
        if (this.publicKey != null && !config.keyFingerprint().isEmpty()) {
            String actual = LicenseSignature.fingerprint(this.publicKey);
            if (!LicenseSignature.constantTimeEquals(actual, config.keyFingerprint())) {
                throw new LicenseException(LicenseStatus.CONFIGURATION_ERROR,
                        "La huella de la clave pública no coincide con licensing.key-fingerprint");
            }
        }
    }

    /**
     * Ejecuta una comprobación completa (bloqueante; pensada para onEnable o para el hilo
     * programado).
     */
    public synchronized LicenseResult checkNow() {
        if (!this.config.enabled()) {
            return this.record(LicenseResult.of(LicenseStatus.DISABLED, "Módulo de licencias desactivado"));
        }
        try {
            this.config.validate();
        } catch (RuntimeException error) {
            return this.record(LicenseResult.of(LicenseStatus.CONFIGURATION_ERROR, error.getMessage()));
        }

        if (this.config.mode() == LicenseMode.LOCAL) {
            return this.record(this.localCheck());
        }

        long now = System.currentTimeMillis();
        LicenseCache cache = LicenseCache.load(this.cacheFile);

        if (cache.lastSeen() > now + CLOCK_TOLERANCE_MILLIS) {
            return this.record(LicenseResult.of(LicenseStatus.CLOCK_ROLLBACK,
                    "El reloj del sistema retrocedió desde la última comprobación"));
        }

        LicenseResult cached = this.evaluate(cache.token(), now);
        if (cached.status() == LicenseStatus.VALID) {
            cache.lastSeen(now);
            cache.serverId(this.serverId);
            cache.save(this.cacheFile);
            return this.record(cached);
        }
        if (cached.status() == LicenseStatus.GRACE) {
            cache.lastSeen(now);
            cache.save(this.cacheFile);
            return this.record(cached);
        }

        try {
            LicenseToken token = this.client.request(this.serverId, this.serverName, this.pluginVersion);
            LicenseResult verified = this.verify(token, now);
            if (!verified.allowed()) {
                return this.record(verified);
            }
            cache.token(token.compact())
                    .lastCheck(now)
                    .lastSeen(now)
                    .serverId(this.serverId)
                    .save(this.cacheFile);
            return this.record(verified);
        } catch (LicenseException error) {
            LicenseResult fallback = this.offlineFallback(cache, now);
            if (fallback != null) {
                cache.lastSeen(now);
                cache.save(this.cacheFile);
                return this.record(fallback);
            }
            return this.record(LicenseResult.of(error.status(), error.getMessage()));
        } catch (RuntimeException error) {
            LicenseResult fallback = this.offlineFallback(cache, now);
            if (fallback != null) {
                return this.record(fallback);
            }
            return this.record(LicenseResult.of(LicenseStatus.SERVER_UNREACHABLE,
                    "Error inesperado al validar la licencia: " + error.getMessage()));
        }
    }

    /**
     * Arranca la revalidación periódica en un hilo daemon.
     *
     * <p>Queda <b>inerte</b> salvo que {@code periodic-validation} sea {@code true}: con el valor
     * por defecto no se programa nada y el plugin funciona como un puente entre la aprobación
     * guardada y la siguiente, sin backend ni peticiones de fondo.</p>
     */
    public synchronized void startScheduled() {
        if (this.config.mode() != LicenseMode.REMOTE || !this.config.periodicValidation() || this.scheduler != null) {
            return;
        }
        this.scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "UltimateClans-Licensing");
            thread.setDaemon(true);
            return thread;
        });
        long period = Math.max(60L, this.config.refreshInterval().toSeconds());
        this.scheduler.scheduleWithFixedDelay(this::checkNow, period, period, TimeUnit.SECONDS);
    }

    public LicenseResult lastResult() {
        LicenseResult result = this.lastResult.get();
        return result == null ? LicenseResult.of(LicenseStatus.NOT_CONFIGURED, "Sin comprobaciones todavía") : result;
    }

    public boolean allowed() {
        return this.lastResult().allowed();
    }

    public LicenseConfig config() {
        return this.config;
    }

    public Path dataDirectory() {
        return this.cacheFile.getParent();
    }

    /**
     * Indica si hay una revalidación periódica programada. En el modo puente (por defecto) es
     * {@code false}.
     */
    public synchronized boolean scheduled() {
        return this.scheduler != null;
    }

    /**
     * Autovalidación local: lee y verifica {@code license.key} sin tocar la red.
     *
     * <p>Si el archivo no existe, está caducado o la firma no cuadra, el plugin sigue arrancando:
     * el estado resultante es {@link LicenseStatus#LOCAL_ONLY}, que siempre permite el uso.</p>
     */
    private LicenseResult localCheck() {
        Path file = this.dataDirectory().resolve(this.config.localLicenseFile());
        if (!Files.isRegularFile(file)) {
            return LicenseResult.of(LicenseStatus.LOCAL_ONLY,
                    "Sin " + this.config.localLicenseFile() + "; el plugin arranca sin validación");
        }
        if (this.publicKey == null) {
            return LicenseResult.of(LicenseStatus.LOCAL_ONLY,
                    "Sin public-key configurada; se ignora la licencia local");
        }
        try {
            String compact = Files.readString(file, StandardCharsets.UTF_8).trim();
            LicenseToken token = LicenseToken.parse(compact);
            if (!LicenseSignature.verify(this.publicKey, token.payloadBytes(), token.signature())) {
                return LicenseResult.of(LicenseStatus.LOCAL_ONLY, "Firma local inválida; se ignora la licencia");
            }
            if (!this.config.productId().equals(token.productId())) {
                return LicenseResult.of(LicenseStatus.LOCAL_ONLY, "Licencia local de otro producto; se ignora");
            }
            if (token.expiredAt(Instant.now())) {
                return LicenseResult.of(LicenseStatus.LOCAL_ONLY, "Licencia local caducada; se ignora");
            }
            return new LicenseResult(LicenseStatus.VALID, "Licencia local verificada", token.expiresAt(), Instant.now());
        } catch (RuntimeException | java.io.IOException error) {
            return LicenseResult.of(LicenseStatus.LOCAL_ONLY, "Licencia local ilegible; se ignora");
        }
    }

    /**
     * Verifica un token contra la clave pública y las reglas del producto.
     */
    LicenseResult verify(LicenseToken token, long nowMillis) {
        if (!LicenseSignature.verify(this.publicKey, token.payloadBytes(), token.signature())) {
            return LicenseResult.of(LicenseStatus.BAD_SIGNATURE, "Firma del token inválida");
        }
        if (!this.config.productId().equals(token.productId())) {
            return LicenseResult.of(LicenseStatus.WRONG_PRODUCT,
                    "El token pertenece al producto '" + token.productId() + "'");
        }
        Instant expires = token.expiresAt();
        if (expires.isBefore(Instant.ofEpochMilli(nowMillis))) {
            return new LicenseResult(LicenseStatus.EXPIRED, "Token caducado", expires, Instant.now());
        }
        return new LicenseResult(LicenseStatus.VALID, "Licencia verificada", expires, Instant.now());
    }

    private LicenseResult evaluate(String cachedToken, long nowMillis) {
        if (cachedToken == null || cachedToken.isBlank()) {
            return LicenseResult.of(LicenseStatus.NOT_CONFIGURED, "Sin token en caché");
        }
        LicenseToken token;
        try {
            token = LicenseToken.parse(cachedToken);
        } catch (LicenseException error) {
            return LicenseResult.of(LicenseStatus.MALFORMED, error.getMessage());
        }
        LicenseResult result = this.verify(token, nowMillis);
        if (result.status() == LicenseStatus.EXPIRED) {
            return this.graceResult(token, nowMillis);
        }
        return result;
    }

    private LicenseResult graceResult(LicenseToken token, long nowMillis) {
        if (!this.config.allowOfflineGrace()) {
            return LicenseResult.of(LicenseStatus.EXPIRED, "Token caducado y gracia offline desactivada");
        }
        Instant graceEnd = token.expiresAt().plus(this.config.gracePeriod());
        if (Instant.ofEpochMilli(nowMillis).isAfter(graceEnd)) {
            return LicenseResult.of(LicenseStatus.EXPIRED, "Token caducado y periodo de gracia agotado");
        }
        return new LicenseResult(LicenseStatus.GRACE,
                "Servidor de licencias no disponible; usando gracia offline", graceEnd, Instant.now());
    }

    private LicenseResult offlineFallback(LicenseCache cache, long nowMillis) {
        if (cache.token() == null || cache.token().isBlank()) {
            return null;
        }
        try {
            LicenseToken token = LicenseToken.parse(cache.token());
            if (!LicenseSignature.verify(this.publicKey, token.payloadBytes(), token.signature())) {
                return null;
            }
            if (!this.config.productId().equals(token.productId())) {
                return null;
            }
            LicenseResult result = this.verify(token, nowMillis);
            if (result.allowed()) {
                return result;
            }
            return this.graceResult(token, nowMillis);
        } catch (RuntimeException ignored) {
            return null;
        }
    }

    private LicenseResult record(LicenseResult result) {
        LicenseResult previous = this.lastResult.getAndSet(result);
        if (previous == null || previous.status() != result.status()) {
            this.logger.accept("[Licencias] " + result.describe());
        }
        return result;
    }

    @Override
    public synchronized void close() {
        if (this.scheduler != null) {
            this.scheduler.shutdownNow();
            this.scheduler = null;
        }
    }
}

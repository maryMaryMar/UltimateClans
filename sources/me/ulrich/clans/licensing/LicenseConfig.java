package me.ulrich.clans.licensing;

import java.net.URI;
import java.time.Duration;
import java.util.Locale;
import java.util.Objects;

/**
 * Configuración del módulo de licencias.
 *
 * <p>Se construye con {@link Builder} y se valida al crear la instancia: si la licencia está
 * activada pero falta la clave pública o el endpoint, la validación falla en vez de permitir el
 * arranque por error.</p>
 */
public record LicenseConfig(
        LicenseMode mode,
        String productId,
        URI endpoint,
        String licenseKey,
        String publicKeyBase64,
        String keyFingerprint,
        Duration gracePeriod,
        Duration requestTimeout,
        Duration refreshInterval,
        boolean periodicValidation,
        boolean allowOfflineGrace,
        String cacheFileName,
        String localLicenseFile
) {

    public LicenseConfig {
        mode = mode == null ? LicenseMode.OFF : mode;
        productId = productId == null ? "" : productId.trim();
        licenseKey = licenseKey == null ? "" : licenseKey.trim();
        publicKeyBase64 = publicKeyBase64 == null ? "" : publicKeyBase64.trim();
        keyFingerprint = keyFingerprint == null ? "" : keyFingerprint.trim().toLowerCase(Locale.ROOT);
        gracePeriod = gracePeriod == null ? Duration.ofHours(48) : gracePeriod;
        requestTimeout = requestTimeout == null ? Duration.ofSeconds(8) : requestTimeout;
        refreshInterval = refreshInterval == null ? Duration.ofHours(6) : refreshInterval;
        cacheFileName = (cacheFileName == null || cacheFileName.isBlank()) ? "license-cache.json" : cacheFileName;
        localLicenseFile = (localLicenseFile == null || localLicenseFile.isBlank()) ? "license.key" : localLicenseFile;

        if (gracePeriod.isNegative() || requestTimeout.isZero() || requestTimeout.isNegative()) {
            throw new IllegalArgumentException("Los tiempos de licencia deben ser positivos");
        }
    }

    public boolean enabled() {
        return this.mode.enabled();
    }

    public static LicenseConfig disabled() {
        return builder().mode(LicenseMode.OFF).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Comprueba que la configuración es usable según el modo.
     */
    public void validate() {
        if (!this.enabled()) {
            return;
        }
        if (this.productId.isBlank()) {
            throw new IllegalStateException("licensing.product-id no puede estar vacío");
        }
        if (!this.keyFingerprint.isEmpty() && !this.keyFingerprint.matches("[0-9a-f]{64}")) {
            throw new IllegalStateException("licensing.key-fingerprint debe ser un SHA-256 hexadecimal de 64 caracteres");
        }
        if (this.mode == LicenseMode.REMOTE) {
            if (this.publicKeyBase64.isBlank()) {
                throw new IllegalStateException("licensing.public-key no puede estar vacío en modo REMOTE");
            }
            if (this.endpoint == null) {
                throw new IllegalStateException("licensing.endpoint no puede estar vacío en modo REMOTE");
            }
            String scheme = this.endpoint.getScheme() == null ? "" : this.endpoint.getScheme().toLowerCase(Locale.ROOT);
            String host = this.endpoint.getHost() == null ? "" : this.endpoint.getHost();
            boolean local = host.equals("127.0.0.1") || host.equals("localhost") || host.equals("::1");
            if (!scheme.equals("https") && !(scheme.equals("http") && local)) {
                throw new IllegalStateException("licensing.endpoint debe usar https (http solo para localhost)");
            }
            if (this.licenseKey.isBlank()) {
                throw new IllegalStateException("licensing.license-key no puede estar vacío en modo REMOTE");
            }
        }
    }

    public static final class Builder {
        private LicenseMode mode = LicenseMode.OFF;
        private String productId = "ultimateclans";
        private URI endpoint;
        private String licenseKey = "";
        private String publicKeyBase64 = "";
        private String keyFingerprint = "";
        private Duration gracePeriod = Duration.ofHours(48);
        private Duration requestTimeout = Duration.ofSeconds(8);
        private Duration refreshInterval = Duration.ofHours(6);
        private boolean periodicValidation = false;
        private boolean allowOfflineGrace = true;
        private String cacheFileName = "license-cache.json";
        private String localLicenseFile = "license.key";

        private Builder() {
        }

        public Builder mode(LicenseMode value) {
            this.mode = value == null ? LicenseMode.OFF : value;
            return this;
        }

        /**
         * Atajo compatible: {@code true} equivale a {@link LicenseMode#REMOTE}.
         */
        public Builder enabled(boolean value) {
            return this.mode(value ? LicenseMode.REMOTE : LicenseMode.OFF);
        }

        public Builder productId(String value) {
            this.productId = value;
            return this;
        }

        public Builder endpoint(String value) {
            this.endpoint = value == null || value.isBlank() ? null : URI.create(value.trim());
            return this;
        }

        public Builder licenseKey(String value) {
            this.licenseKey = value;
            return this;
        }

        public Builder publicKey(String value) {
            this.publicKeyBase64 = value;
            return this;
        }

        public Builder keyFingerprint(String value) {
            this.keyFingerprint = value;
            return this;
        }

        public Builder gracePeriod(Duration value) {
            this.gracePeriod = value;
            return this;
        }

        public Builder requestTimeout(Duration value) {
            this.requestTimeout = value;
            return this;
        }

        public Builder refreshInterval(Duration value) {
            this.refreshInterval = value;
            return this;
        }

        /**
         * Activa la revalidación periódica contra el servidor de licencias.
         *
         * <p>Desactivada por defecto: entre aprobación y aprobación el plugin funciona solo con
         * la caché local, sin necesitar backend ni web.</p>
         */
        public Builder periodicValidation(boolean value) {
            this.periodicValidation = value;
            return this;
        }

        public Builder allowOfflineGrace(boolean value) {
            this.allowOfflineGrace = value;
            return this;
        }

        public Builder cacheFileName(String value) {
            this.cacheFileName = value;
            return this;
        }

        public Builder localLicenseFile(String value) {
            this.localLicenseFile = value;
            return this;
        }

        public LicenseConfig build() {
            LicenseConfig config = new LicenseConfig(this.mode, this.productId, this.endpoint, this.licenseKey,
                    this.publicKeyBase64, this.keyFingerprint, this.gracePeriod, this.requestTimeout,
                    this.refreshInterval, this.periodicValidation, this.allowOfflineGrace, this.cacheFileName,
                    this.localLicenseFile);
            Objects.requireNonNull(config);
            return config;
        }
    }
}

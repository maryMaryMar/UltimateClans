package me.ulrich.clans.licensing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

/**
 * Caché local del token y de las marcas de tiempo.
 *
 * <p>Se guarda en un JSON dentro de la carpeta de datos del plugin. La escritura es atómica
 * (archivo temporal + move) para no dejar el archivo corrupto si el servidor se apaga a mitad.</p>
 */
public final class LicenseCache {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private String token = "";
    private long lastCheck;
    private long lastSeen;
    private String serverId = "";

    public static LicenseCache load(Path file) {
        LicenseCache cache = new LicenseCache();
        if (file == null || !Files.isRegularFile(file)) {
            return cache;
        }
        try {
            String raw = Files.readString(file, StandardCharsets.UTF_8);
            JsonObject json = JsonParser.parseString(raw).getAsJsonObject();
            cache.token = json.has("token") ? json.get("token").getAsString() : "";
            cache.lastCheck = json.has("lastCheck") ? json.get("lastCheck").getAsLong() : 0L;
            cache.lastSeen = json.has("lastSeen") ? json.get("lastSeen").getAsLong() : 0L;
            cache.serverId = json.has("serverId") ? json.get("serverId").getAsString() : "";
        } catch (IOException | RuntimeException ignored) {
            // Caché ilegible: se trata como si no existiera.
        }
        return cache;
    }

    public void save(Path file) {
        if (file == null) {
            return;
        }
        JsonObject json = new JsonObject();
        json.addProperty("token", this.token);
        json.addProperty("lastCheck", this.lastCheck);
        json.addProperty("lastSeen", this.lastSeen);
        json.addProperty("serverId", this.serverId);
        try {
            Files.createDirectories(file.getParent());
            Path temporary = file.resolveSibling(file.getFileName() + ".tmp");
            Files.writeString(temporary, GSON.toJson(json), StandardCharsets.UTF_8);
            try {
                Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (IOException atomicUnsupported) {
                Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ignored) {
            // Sin caché se sigue funcionando: solo se pierde la gracia offline.
        }
    }

    public String token() {
        return this.token;
    }

    public LicenseCache token(String value) {
        this.token = value == null ? "" : value;
        return this;
    }

    public long lastCheck() {
        return this.lastCheck;
    }

    public LicenseCache lastCheck(long value) {
        this.lastCheck = value;
        return this;
    }

    public long lastSeen() {
        return this.lastSeen;
    }

    public LicenseCache lastSeen(long value) {
        this.lastSeen = value;
        return this;
    }

    public String serverId() {
        return this.serverId;
    }

    public LicenseCache serverId(String value) {
        this.serverId = value == null ? "" : value;
        return this;
    }

    public Instant lastCheckInstant() {
        return this.lastCheck <= 0 ? Instant.EPOCH : Instant.ofEpochMilli(this.lastCheck);
    }
}

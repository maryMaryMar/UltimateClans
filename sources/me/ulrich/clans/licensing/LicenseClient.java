package me.ulrich.clans.licensing;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * Cliente HTTP del servidor de licencias.
 *
 * <p>El plugin nunca guarda la clave privada: solo envía la clave de licencia del cliente y
 * recibe un token firmado que puede verificar por su cuenta.</p>
 */
public final class LicenseClient {

    private static final int MAX_RESPONSE_BYTES = 64 * 1024;

    private final LicenseConfig config;
    private final HttpClient http;

    public LicenseClient(LicenseConfig config) {
        this.config = config;
        Duration timeout = config.requestTimeout();
        this.http = HttpClient.newBuilder()
                .connectTimeout(timeout)
                .followRedirects(HttpClient.Redirect.NEVER)
                .build();
    }

    /**
     * Solicita un token nuevo al servidor de licencias.
     *
     * @throws LicenseException con el estado adecuado si el servidor rechaza o no responde.
     */
    public LicenseToken request(String serverId, String serverName, String pluginVersion) {
        JsonObject body = new JsonObject();
        body.addProperty("product", this.config.productId());
        body.addProperty("key", this.config.licenseKey());
        body.addProperty("serverId", serverId);
        body.addProperty("serverName", serverName);
        body.addProperty("version", pluginVersion);

        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(this.config.endpoint())
                    .timeout(this.config.requestTimeout())
                    .header("Content-Type", "application/json; charset=utf-8")
                    .header("Accept", "application/json")
                    .header("User-Agent", "UltimateClans-Licensing/1.0")
                    .POST(HttpRequest.BodyPublishers.ofString(body.toString(), StandardCharsets.UTF_8))
                    .build();
        } catch (IllegalArgumentException error) {
            throw new LicenseException(LicenseStatus.CONFIGURATION_ERROR, "Endpoint de licencias inválido", error);
        }

        HttpResponse<String> response;
        try {
            response = this.http.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        } catch (IOException error) {
            throw new LicenseException(LicenseStatus.SERVER_UNREACHABLE, "No se pudo contactar con el servidor de licencias", error);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            throw new LicenseException(LicenseStatus.SERVER_UNREACHABLE, "Comprobación de licencia interrumpida", error);
        }

        int status = response.statusCode();
        String responseBody = response.body() == null ? "" : response.body();
        if (responseBody.length() > MAX_RESPONSE_BYTES) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Respuesta del servidor de licencias demasiado grande");
        }
        if (status == 429) {
            throw new LicenseException(LicenseStatus.SERVER_UNREACHABLE, "El servidor de licencias limitó las peticiones (429)");
        }
        if (status == 401 || status == 403) {
            throw new LicenseException(LicenseStatus.REJECTED, this.message(responseBody, "Clave de licencia rechazada"));
        }
        if (status == 404) {
            throw new LicenseException(LicenseStatus.CONFIGURATION_ERROR, "Endpoint de licencias no encontrado (404)");
        }
        if (status < 200 || status >= 300) {
            throw new LicenseException(LicenseStatus.SERVER_UNREACHABLE, "El servidor de licencias respondió " + status);
        }

        JsonObject json;
        try {
            json = JsonParser.parseString(responseBody).getAsJsonObject();
        } catch (RuntimeException error) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Respuesta del servidor no es JSON válido", error);
        }

        if (json.has("valid") && json.get("valid").isJsonPrimitive() && !json.get("valid").getAsBoolean()) {
            throw new LicenseException(LicenseStatus.REJECTED, this.message(responseBody, "Licencia no válida"));
        }
        if (json.has("error")) {
            throw new LicenseException(LicenseStatus.REJECTED, this.message(responseBody, "Licencia rechazada"));
        }
        if (!json.has("token") || !json.get("token").isJsonPrimitive()) {
            throw new LicenseException(LicenseStatus.MALFORMED, "La respuesta no contiene un token");
        }
        return LicenseToken.parse(json.get("token").getAsString());
    }

    private String message(String body, String fallback) {
        try {
            JsonObject json = JsonParser.parseString(body).getAsJsonObject();
            if (json.has("message") && json.get("message").isJsonPrimitive()) {
                return json.get("message").getAsString();
            }
            if (json.has("error") && json.get("error").isJsonPrimitive()) {
                return json.get("error").getAsString();
            }
        } catch (RuntimeException ignored) {
            // Se usa el mensaje por defecto.
        }
        return fallback;
    }

    public URI endpoint() {
        return this.config.endpoint();
    }
}

package me.ulrich.clans.licensing;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Objects;

/**
 * Token compacto firmado con Ed25519.
 *
 * <p>Formato: {@code base64url(payloadJson) + "." + base64url(firma)}. La firma cubre los bytes
 * exactos del payload, así que no hace falta canonicalizar el JSON.</p>
 */
public final class LicenseToken {

    private final byte[] payload;
    private final byte[] signature;
    private final JsonObject json;

    private LicenseToken(byte[] payload, byte[] signature, JsonObject json) {
        this.payload = payload;
        this.signature = signature;
        this.json = json;
    }

    public static LicenseToken parse(String compact) {
        if (compact == null || compact.isBlank()) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Token vacío");
        }
        int separator = compact.indexOf('.');
        if (separator <= 0 || separator == compact.length() - 1 || compact.indexOf('.', separator + 1) >= 0) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Formato de token inválido");
        }
        byte[] payload;
        byte[] signature;
        try {
            payload = Base64.getUrlDecoder().decode(compact.substring(0, separator));
            signature = Base64.getUrlDecoder().decode(compact.substring(separator + 1));
        } catch (IllegalArgumentException error) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Token con codificación Base64 inválida", error);
        }
        JsonObject json;
        try {
            json = JsonParser.parseString(new String(payload, StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (RuntimeException error) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Payload del token no es JSON válido", error);
        }
        return new LicenseToken(payload, signature, json);
    }

    public byte[] payloadBytes() {
        return this.payload.clone();
    }

    public byte[] signature() {
        return this.signature.clone();
    }

    public String compact() {
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(this.payload) + "." + encoder.encodeToString(this.signature);
    }

    public String productId() {
        return this.string("product");
    }

    public String licenseKey() {
        return this.string("key");
    }

    public String subject() {
        return this.string("subject");
    }

    public String nonce() {
        return this.string("nonce");
    }

    public Instant issuedAt() {
        return Instant.ofEpochSecond(this.number("iat"));
    }

    public Instant expiresAt() {
        return Instant.ofEpochSecond(this.number("exp"));
    }

    public boolean expiredAt(Instant moment) {
        return !this.expiresAt().isAfter(moment);
    }

    private String string(String field) {
        return this.json.has(field) && this.json.get(field).isJsonPrimitive() ? this.json.get(field).getAsString() : "";
    }

    private long number(String field) {
        if (!this.json.has(field) || !this.json.get(field).isJsonPrimitive()) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Al token le falta el campo '" + field + "'");
        }
        try {
            return this.json.get(field).getAsLong();
        } catch (RuntimeException error) {
            throw new LicenseException(LicenseStatus.MALFORMED, "Campo '" + field + "' no numérico", error);
        }
    }

    @Override
    public String toString() {
        return "LicenseToken[" + this.productId() + ", " + this.subject() + ", exp=" + this.expiresAt() + ']';
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof LicenseToken token && Objects.equals(this.compact(), token.compact());
    }

    @Override
    public int hashCode() {
        return this.compact().hashCode();
    }
}

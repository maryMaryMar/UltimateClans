package me.ulrich.clans.licensing;

import java.time.Instant;
import java.util.Objects;

/**
 * Resultado inmutable de una comprobación, con el detalle suficiente para el log.
 */
public record LicenseResult(LicenseStatus status, String message, Instant expiresAt, Instant checkedAt) {

    public LicenseResult {
        Objects.requireNonNull(status, "status");
        message = message == null ? "" : message;
        checkedAt = checkedAt == null ? Instant.now() : checkedAt;
    }

    public static LicenseResult of(LicenseStatus status, String message) {
        return new LicenseResult(status, message, null, Instant.now());
    }

    public static LicenseResult valid(Instant expiresAt) {
        return new LicenseResult(LicenseStatus.VALID, "Licencia verificada", expiresAt, Instant.now());
    }

    public boolean allowed() {
        return this.status.allowsUsage();
    }

    public String describe() {
        StringBuilder text = new StringBuilder(this.status.name());
        if (!this.message.isBlank()) {
            text.append(": ").append(this.message);
        }
        if (this.expiresAt != null) {
            text.append(" (caduca ").append(this.expiresAt).append(')');
        }
        return text.toString();
    }
}

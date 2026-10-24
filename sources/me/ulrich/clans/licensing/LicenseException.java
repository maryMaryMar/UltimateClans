package me.ulrich.clans.licensing;

/**
 * Error de licencia con su estado asociado.
 */
public final class LicenseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final LicenseStatus status;

    public LicenseException(LicenseStatus status, String message) {
        super(message);
        this.status = status;
    }

    public LicenseException(LicenseStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public LicenseStatus status() {
        return this.status;
    }
}

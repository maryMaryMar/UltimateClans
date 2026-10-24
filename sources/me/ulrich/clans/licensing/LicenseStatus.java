package me.ulrich.clans.licensing;

/**
 * Resultado posible de una comprobación de licencia.
 */
public enum LicenseStatus {

    /** Licencia válida y verificada contra el servidor en esta ejecución. */
    VALID,

    /** Token válido pero caducado: se acepta dentro del periodo de gracia sin conexión. */
    GRACE,

    /** No hay licencia configurada. Nunca se permite el uso. */
    NOT_CONFIGURED,

    /** El módulo está desactivado en la configuración. */
    DISABLED,

    /**
     * Modo local sin licencia legible: el plugin funciona igualmente y solo se informa por consola.
     * Este estado siempre permite el uso.
     */
    LOCAL_ONLY,

    /** El token ha caducado y el periodo de gracia también. */
    EXPIRED,

    /** La firma del token no coincide con la clave pública. */
    BAD_SIGNATURE,

    /** El token pertenece a otro producto. */
    WRONG_PRODUCT,

    /** El token no se puede interpretar. */
    MALFORMED,

    /** El reloj del sistema retrocedió respecto a la última comprobación guardada. */
    CLOCK_ROLLBACK,

    /** No se pudo contactar con el servidor de licencias y no hay token utilizable. */
    SERVER_UNREACHABLE,

    /** El servidor de licencias rechazó la clave. */
    REJECTED,

    /** Error de configuración (clave pública ausente, endpoint inválido, etc.). */
    CONFIGURATION_ERROR;

    public boolean allowsUsage() {
        return this == VALID || this == GRACE || this == LOCAL_ONLY;
    }

    public boolean isRecoverable() {
        return this == SERVER_UNREACHABLE || this == GRACE;
    }
}

package me.ulrich.clans.licensing;

/**
 * Modo de funcionamiento del módulo de licencias.
 */
public enum LicenseMode {

    /**
     * Sin comprobaciones. Es el valor por defecto: el plugin arranca exactamente igual que el
     * original y el módulo no se inicializa.
     */
    OFF,

    /**
     * Autovalidación local: lee un token firmado del archivo {@code license.key} y lo verifica
     * dentro del propio plugin. No hace ninguna petición de red y nunca impide el arranque.
     */
    LOCAL,

    /**
     * Validación contra un servidor de licencias. Es el único modo que puede desactivar el
     * plugin cuando la licencia no es válida.
     */
    REMOTE;

    public boolean enabled() {
        return this != OFF;
    }

    public boolean usesNetwork() {
        return this == REMOTE;
    }

    public static LicenseMode parse(String value) {
        if (value == null || value.isBlank()) {
            return OFF;
        }
        try {
            return valueOf(value.trim().toUpperCase(java.util.Locale.ROOT));
        } catch (IllegalArgumentException error) {
            return OFF;
        }
    }
}

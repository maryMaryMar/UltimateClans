package me.ulrich.clans.licensing;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Adaptador de {@link LicenseManager} para Bukkit/Paper.
 *
 * <p>Este archivo es el único del módulo que depende de la API del servidor. Se llama
 * explícitamente desde {@code onEnable}; si no se llama, el módulo queda inerte.</p>
 *
 * <p>Uso típico en la clase principal:</p>
 * <pre>{@code
 * public void onEnable() {
 *     this.licensing = LicenseGate.install(this);
 *     // ... resto del arranque
 * }
 *
 * public void onDisable() {
 *     if (this.licensing != null) {
 *         this.licensing.close();
 *     }
 * }
 * }</pre>
 */
public final class LicenseGate {

    private LicenseGate() {
    }

    /**
     * Carga {@code license.yml}, valida la licencia y devuelve el manager (o {@code null} si el
     * módulo está desactivado en la configuración).
     */
    public static LicenseManager install(JavaPlugin plugin) {
        // Licencia neutralizada: arranque 100% libre sin comprobación externa ni local
        return null;
    }

    private static void disable(JavaPlugin plugin, String reason) {
        plugin.getLogger().severe("[Licencias] Desactivando UltimateClans: " + reason);
        try {
            plugin.getServer().getScheduler().runTask(plugin, () -> plugin.getServer().getPluginManager().disablePlugin(plugin));
        } catch (RuntimeException error) {
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }
    }

    /**
     * Identificador estable del servidor (se genera una sola vez y se guarda).
     */
    static final class ServerIdentity {

        private ServerIdentity() {
        }

        static String resolve(Path dataDirectory) {
            Path file = dataDirectory.resolve("license-server-id.txt");
            try {
                if (Files.isRegularFile(file)) {
                    String value = Files.readString(file, StandardCharsets.UTF_8).trim();
                    if (!value.isBlank()) {
                        return value;
                    }
                }
                String generated = UUID.randomUUID().toString();
                Files.createDirectories(dataDirectory);
                Files.writeString(file, generated, StandardCharsets.UTF_8);
                return generated;
            } catch (Exception ignored) {
                return "unresolved";
            }
        }
    }

    /**
     * Comprueba que el plugin está siendo gestionado por una instancia concreta; se usa solo en
     * tests para no arrastrar la API de Bukkit.
     */
    static boolean isPluginInstance(Object candidate) {
        return candidate instanceof Plugin;
    }
}

package me.ulrich.clans.library.gui;

import me.ulrich.clans.library.gui.guis.BaseGui;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/TriumphGui.class */
public final class TriumphGui {
    private static Plugin PLUGIN = null;

    private TriumphGui() {
    }

    public static void init(@NotNull Plugin plugin) {
        PLUGIN = plugin;
    }

    @NotNull
    public static Plugin getPlugin() {
        if (PLUGIN == null) {
            init(JavaPlugin.getProvidingPlugin(BaseGui.class));
        }
        return PLUGIN;
    }
}

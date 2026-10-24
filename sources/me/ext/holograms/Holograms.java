package me.ext.holograms;

import java.util.logging.Logger;
import me.ext.holograms.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holograms.jar:me/ext/holograms/Holograms.class */
public class Holograms extends Extension {
    private static Holograms extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private TaskScheduler scheduler;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        this.scheduler = clanCore.getLibAPI().getScheduler();
        if (Bukkit.getPluginManager().isPluginEnabled("Holograms")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("Holograms");
            if (this.pluginImp != null) {
                Implementation impl = new Implementation();
                clanCore.getIntegrationAPI().registerHologramAPI("Holograms", impl);
                clanCore.getLogger().info(" - Hologram implementation: Holograms (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterHologramAPI("Holograms");
    }

    public static Holograms getExtensionCore() {
        return extensionCore;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public static Clans getClanCore() {
        return clanCore;
    }

    public Plugin getPluginImp() {
        return this.pluginImp;
    }

    public TaskScheduler getScheduler() {
        return this.scheduler;
    }
}

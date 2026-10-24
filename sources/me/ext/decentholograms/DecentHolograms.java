package me.ext.decentholograms;

import java.util.logging.Logger;
import me.ext.decentholograms.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Decentholograms.jar:me/ext/decentholograms/DecentHolograms.class */
public class DecentHolograms extends Extension {
    private static DecentHolograms extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private Implementation impl = null;
    private TaskScheduler scheduler;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        this.scheduler = clanCore.getLibAPI().getScheduler();
        if (Bukkit.getPluginManager().isPluginEnabled("DecentHolograms")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("DecentHolograms");
            if (this.pluginImp != null) {
                this.impl = new Implementation();
                clanCore.getIntegrationAPI().registerHologramAPI("DecentHolograms", this.impl);
                clanCore.getLogger().info(" - Hologram implementation: DecentHolograms (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        if (this.impl != null) {
            this.impl.deleteAll();
            this.impl = null;
        }
        clanCore.getIntegrationAPI().unregisterHologramAPI("DecentHolograms");
    }

    public static DecentHolograms getExtensionCore() {
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

    public Implementation getImpl() {
        return this.impl;
    }

    public TaskScheduler getScheduler() {
        return this.scheduler;
    }
}

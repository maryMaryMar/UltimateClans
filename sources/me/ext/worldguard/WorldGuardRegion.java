package me.ext.worldguard;

import java.util.logging.Logger;
import me.ext.worldguard.manager.Implementation;
import me.ext.worldguard.manager.WorldGuardManager;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Worldguard.jar:me/ext/worldguard/WorldGuardRegion.class */
public class WorldGuardRegion extends Extension {
    private static WorldGuardRegion extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("WorldGuard")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("WorldGuard");
            if (this.pluginImp != null) {
                WorldGuardManager rg = new WorldGuardManager();
                rg.initializeWg(clanCore);
                rg.setEnabled(true);
                if (rg.isEnabled()) {
                    Implementation implementation = new Implementation(rg);
                    clanCore.getIntegrationAPI().registerRegionAPI("WorldGuard", implementation);
                    clanCore.getLogger().info(" - Region implementation: WorldGuard" + (rg.isLegacy() ? " Legacy" : "") + " (" + this.pluginImp.getDescription().getVersion() + ")");
                    clanCore.getExtensionEnabledList().put(this, true);
                    return;
                }
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterRegionAPI("WorldGuard");
    }

    public static WorldGuardRegion getExtensionCore() {
        return extensionCore;
    }

    public static Clans getClanCore() {
        return clanCore;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public Plugin getPluginImp() {
        return this.pluginImp;
    }
}

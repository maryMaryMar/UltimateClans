package me.ext.griefdefender;

import java.util.logging.Logger;
import me.ext.griefdefender.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Griefdefender.jar:me/ext/griefdefender/GriefDefender.class */
public class GriefDefender extends Extension implements Listener {
    private static GriefDefender extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private boolean dynmap = false;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("GriefDefender")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("GriefDefender");
            if (this.pluginImp != null) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerClaimAPI("GriefDefender", implementation);
                clanCore.getLogger().info(" - Claim implementation: GriefDefender (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterClaimAPI("GriefDefender");
    }

    public static GriefDefender getExtensionCore() {
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

    public boolean isDynmap() {
        return this.dynmap;
    }
}

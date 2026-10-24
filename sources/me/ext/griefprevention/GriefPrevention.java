package me.ext.griefprevention;

import java.util.logging.Logger;
import me.ext.griefprevention.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Griefprevention.jar:me/ext/griefprevention/GriefPrevention.class */
public class GriefPrevention extends Extension {
    private static GriefPrevention extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private boolean dynmap = false;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("GriefPrevention")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("GriefPrevention");
            if (this.pluginImp != null) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerClaimAPI("GriefPrevention", implementation);
                clanCore.getLogger().info(" - Claim implementation: GriefPrevention (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterClaimAPI("GriefPrevention");
    }

    public static GriefPrevention getExtensionCore() {
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

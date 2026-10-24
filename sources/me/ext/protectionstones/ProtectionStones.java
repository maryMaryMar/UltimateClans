package me.ext.protectionstones;

import java.util.logging.Logger;
import me.ext.protectionstones.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Protectionstones.jar:me/ext/protectionstones/ProtectionStones.class */
public class ProtectionStones extends Extension {
    private static ProtectionStones extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private boolean dynmap = false;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("ProtectionStones")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("ProtectionStones");
            if (this.pluginImp != null) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerClaimAPI("ProtectionStones", implementation);
                clanCore.getLogger().info(" - Claim implementation: ProtectionStones (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterClaimAPI("ProtectionStones");
    }

    public static ProtectionStones getExtensionCore() {
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

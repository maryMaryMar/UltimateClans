package me.ext.playerpoints;

import java.util.logging.Logger;
import me.ext.playerpoints.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Playerpoints.jar:me/ext/playerpoints/PlayerPoints.class */
public class PlayerPoints extends Extension {
    private static PlayerPoints extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private org.black_ixx.playerpoints.PlayerPoints playerPointsCast;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("PlayerPoints");
            if (this.pluginImp != null && setupPlayerPoints(this.pluginImp)) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerMoneyAPI("PlayerPoints", implementation);
                clanCore.getLogger().info(" - Money implementation: PlayerPoints (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    private boolean setupPlayerPoints(Plugin plugin) {
        this.playerPointsCast = (org.black_ixx.playerpoints.PlayerPoints) org.black_ixx.playerpoints.PlayerPoints.class.cast(plugin);
        return this.playerPointsCast != null;
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMoneyAPI("PlayerPoints");
    }

    public static PlayerPoints getExtensionCore() {
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

    public org.black_ixx.playerpoints.PlayerPoints getPlayerPointsCast() {
        return this.playerPointsCast;
    }
}

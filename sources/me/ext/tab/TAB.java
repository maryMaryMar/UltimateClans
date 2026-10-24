package me.ext.tab;

import java.util.logging.Logger;
import me.ext.tab.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Tab.jar:me/ext/tab/TAB.class */
public class TAB extends Extension {
    private static TAB extensionCore;
    private static Clans clansCore;
    private Logger logger = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        Plugin tab;
        extensionCore = this;
        clansCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("TAB") && (tab = Bukkit.getPluginManager().getPlugin("TAB")) != null) {
            Implementation impl = new Implementation(tab);
            clansCore.getIntegrationAPI().registerScoreboardAPI("TAB", impl);
            clansCore.getLogger().info(" - TAB (" + tab.getDescription().getVersion() + ") [USING]");
            clansCore.getExtensionEnabledList().put(this, true);
            return;
        }
        clansCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clansCore.getIntegrationAPI().unregisterScoreboardAPI("TAB");
    }

    public static TAB getExtensionCore() {
        return extensionCore;
    }

    public static Clans getClansCore() {
        return clansCore;
    }

    public Logger getLogger() {
        return this.logger;
    }
}

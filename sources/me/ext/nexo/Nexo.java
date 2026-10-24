package me.ext.nexo;

import java.util.logging.Logger;
import me.ext.nexo.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Nexo.jar:me/ext/nexo/Nexo.class */
public class Nexo extends Extension {
    private static Nexo extensionCore;
    private static Clans clanCore;
    private Logger logger = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("Nexo")) {
            Implementation implementation = new Implementation();
            clanCore.getIntegrationAPI().registerItemParseAPI("nexo", implementation);
            clanCore.getLogger().info(" - Item implementation: Nexo (" + Bukkit.getPluginManager().getPlugin("Nexo").getDescription().getVersion() + ")");
            clanCore.getExtensionEnabledList().put(this, true);
            return;
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterItemParseAPI("nexo");
    }

    public static Nexo getExtensionCore() {
        return extensionCore;
    }

    public static Clans getClanCore() {
        return clanCore;
    }

    public Logger getLogger() {
        return this.logger;
    }
}

package me.ext.eco;

import java.util.logging.Logger;
import me.ext.eco.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Eco.jar:me/ext/eco/Eco.class */
public class Eco extends Extension {
    private static Eco extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("eco")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("eco");
            if (this.pluginImp != null) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerMoneyAPI("Eco", implementation);
                clanCore.getLogger().info(" - Money implementation: Eco (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMoneyAPI("Eco");
    }

    public static Eco getExtensionCore() {
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

package me.ext.elementalgems;

import java.util.logging.Logger;
import me.ext.elementalgems.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Elementalgems.jar:me/ext/elementalgems/ElementalGems.class */
public class ElementalGems extends Extension {
    private static ElementalGems extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("ElementalGems")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("ElementalGems");
            if (this.pluginImp != null) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerMoneyAPI("ElementalGems", implementation);
                clanCore.getLogger().info(" - Money implementation: ElementalGems (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMoneyAPI("ElementalGems");
    }

    public static ElementalGems getExtensionCore() {
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

package me.ext.fancyholograms;

import java.util.logging.Logger;
import me.ext.fancyholograms.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Fancyholograms.jar:me/ext/fancyholograms/FancyHolograms.class */
public class FancyHolograms extends Extension {
    private static FancyHolograms extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("FancyHolograms")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("FancyHolograms");
            if (this.pluginImp != null) {
                Implementation impl = new Implementation();
                clanCore.getIntegrationAPI().registerHologramAPI("FancyHolograms", impl);
                clanCore.getLogger().info(" - Hologram implementation: FancyHolograms (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterHologramAPI("FancyHolograms");
    }

    public static FancyHolograms getExtensionCore() {
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
}

package me.ext.dynmap;

import java.util.logging.Logger;
import me.ext.dynmap.manager.DynManager;
import me.ext.dynmap.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.dynmap.DynmapAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Dynmap.jar:me/ext/dynmap/Dynmap.class */
public class Dynmap extends Extension {
    private static Dynmap extensionCore;
    private static Clans clanCore;
    private DynManager dynManager;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private DynmapAPI dapi = null;
    private boolean dynmap = false;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        DynmapAPI din;
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("dynmap")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("dynmap");
            if (this.pluginImp != null && (din = setupDyn(this.pluginImp)) != null) {
                this.dapi = din;
                this.dynmap = true;
                this.dynManager = new DynManager();
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerMapAPI("dynmap", implementation);
                clanCore.getLogger().info(" - Map implementation: dynmap (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMapAPI("dynmap");
    }

    private DynmapAPI setupDyn(Plugin plugin) {
        try {
            DynmapAPI dim = (DynmapAPI) plugin;
            if (dim != null) {
                return dim;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Dynmap getExtensionCore() {
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

    public DynManager getDynManager() {
        return this.dynManager;
    }

    public DynmapAPI getDapi() {
        return this.dapi;
    }

    public boolean isDynmap() {
        return this.dynmap;
    }
}

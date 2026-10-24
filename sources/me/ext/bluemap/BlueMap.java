package me.ext.bluemap;

import de.bluecolored.bluemap.api.BlueMapAPI;
import java.util.Optional;
import java.util.logging.Logger;
import me.ext.bluemap.manager.BlueManager;
import me.ext.bluemap.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Bluemap.jar:me/ext/bluemap/BlueMap.class */
public class BlueMap extends Extension {
    private static BlueMap extensionCore;
    private static Clans clanCore;
    private BlueManager blueManager;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private boolean bluemap = false;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("BlueMap")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("BlueMap");
            if (this.pluginImp != null) {
                Optional<BlueMapAPI> optionalApi = BlueMapAPI.getInstance();
                optionalApi.ifPresent(api -> {
                    BlueMapAPI.onEnable(enable -> {
                        this.bluemap = true;
                        this.blueManager = new BlueManager();
                        Implementation implementation = new Implementation();
                        clanCore.getIntegrationAPI().registerMapAPI("BlueMap", implementation);
                        clanCore.getLogger().info(" - Map implementation: BlueMap (" + this.pluginImp.getDescription().getVersion() + ")");
                        setEnabled(true);
                        clanCore.getExtensionEnabledList().put(this, true);
                    });
                });
            }
        }
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMapAPI("BlueMap");
    }

    public static BlueMap getExtensionCore() {
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

    public boolean isBluemap() {
        return this.bluemap;
    }

    public BlueManager getBlueManager() {
        return this.blueManager;
    }
}

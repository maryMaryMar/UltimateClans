package me.ext.itemsadder;

import java.util.logging.Logger;
import me.ext.itemsadder.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Itemsadder.jar:me/ext/itemsadder/ItemsAdder.class */
public class ItemsAdder extends Extension {
    private static ItemsAdder extensionCore;
    private static Clans clanCore;
    private Logger logger = null;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("ItemsAdder")) {
            Implementation implementation = new Implementation();
            clanCore.getIntegrationAPI().registerItemParseAPI("ItemsAdder", implementation);
            clanCore.getLogger().info(" - Item implementation: ItemsAdder (" + Bukkit.getPluginManager().getPlugin("ItemsAdder").getDescription().getVersion() + ")");
            clanCore.getExtensionEnabledList().put(this, true);
            return;
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterItemParseAPI("ItemsAdder");
    }

    public static ItemsAdder getExtensionCore() {
        return extensionCore;
    }

    public static Clans getClanCore() {
        return clanCore;
    }

    public Logger getLogger() {
        return this.logger;
    }
}

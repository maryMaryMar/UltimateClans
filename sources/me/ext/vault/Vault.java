package me.ext.vault;

import java.util.logging.Logger;
import me.ext.vault.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.manager.utils.VersionComparer;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Vault.jar:me/ext/vault/Vault.class */
public class Vault extends Extension {
    private static Vault extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private Economy econ;
    private Implementation implementation;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (new VersionComparer(clanCore.getDescription().getVersion()).compareTo(new VersionComparer("9.0.0")) < 0) {
            getInstance().getLogger().warning(" ! " + getName() + ", Reason: Need Ultimate Clans 9.0.0+");
            clanCore.getExtensionEnabledList().put(this, false);
            setEnabled(false);
            onDisable();
            return;
        }
        if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("Vault");
            if (this.pluginImp != null && setupVault()) {
                this.implementation = new Implementation();
                clanCore.getIntegrationAPI().registerMoneyAPI("Vault", this.implementation);
                clanCore.getLogger().info(" - Money implementation: Vault (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    private boolean setupVault() {
        RegisteredServiceProvider<Economy> rsp = clanCore.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        this.econ = (Economy) rsp.getProvider();
        return getEcon() != null;
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMoneyAPI("Vault");
    }

    public static Vault getExtensionCore() {
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

    public Economy getEcon() {
        return this.econ;
    }
}

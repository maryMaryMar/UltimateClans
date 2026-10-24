package me.ext.tokenenchant;

import com.vk2gpz.tokenenchant.api.TokenEnchantAPI;
import java.util.logging.Logger;
import me.ext.tokenenchant.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Extension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Tokenenchant.jar:me/ext/tokenenchant/TokenEnchantMoney.class */
public class TokenEnchantMoney extends Extension {
    private static TokenEnchantMoney extensionCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Plugin pluginImp = null;
    private TokenEnchantAPI tokenEnchantAPI;

    @Override // me.ulrich.clans.data.Extension
    public void onEnable() {
        extensionCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (Bukkit.getPluginManager().isPluginEnabled("TokenEnchant")) {
            this.pluginImp = Bukkit.getPluginManager().getPlugin("TokenEnchant");
            if (this.pluginImp != null && setupTokenEnchant()) {
                Implementation implementation = new Implementation();
                clanCore.getIntegrationAPI().registerMoneyAPI("TokenEnchant", implementation);
                clanCore.getLogger().info(" - Money implementation: TokenEnchant (" + this.pluginImp.getDescription().getVersion() + ")");
                clanCore.getExtensionEnabledList().put(this, true);
                return;
            }
        }
        clanCore.getExtensionEnabledList().put(this, false);
    }

    private boolean setupTokenEnchant() {
        TokenEnchantAPI teAPI = TokenEnchantAPI.getInstance();
        if (teAPI != null) {
            this.tokenEnchantAPI = teAPI;
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.data.Extension
    public void onDisable() {
        clanCore.getIntegrationAPI().unregisterMoneyAPI("TokenEnchant");
    }

    public static TokenEnchantMoney getExtensionCore() {
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

    public TokenEnchantAPI getTokenEnchantAPI() {
        return this.tokenEnchantAPI;
    }
}

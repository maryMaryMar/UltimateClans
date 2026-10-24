package me.ext.tokenenchant.manager;

import java.util.Optional;
import me.ext.tokenenchant.TokenEnchantMoney;
import me.ulrich.clans.interfaces.MoneyImplement;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Tokenenchant.jar:me/ext/tokenenchant/manager/Implementation.class */
public final class Implementation implements MoneyImplement {
    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginName() {
        return Optional.of(TokenEnchantMoney.getExtensionCore().getPluginImp().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(TokenEnchantMoney.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean hasMoney(Player player, double amount) {
        if (TokenEnchantMoney.getExtensionCore().getTokenEnchantAPI().getTokens(player) >= amount) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean addMoney(Player player, double amount) {
        TokenEnchantMoney.getExtensionCore().getTokenEnchantAPI().addTokens(player, amount);
        return true;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean withdrawMoney(Player player, double amount) {
        if (TokenEnchantMoney.getExtensionCore().getTokenEnchantAPI().getTokens(player) >= amount) {
            TokenEnchantMoney.getExtensionCore().getTokenEnchantAPI().removeTokens(player, amount);
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public double getMoney(Player player, boolean inDouble) {
        return TokenEnchantMoney.getExtensionCore().getTokenEnchantAPI().getTokens(player);
    }
}

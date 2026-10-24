package me.ext.vault.manager;

import java.util.Optional;
import me.ext.vault.Vault;
import me.ulrich.clans.interfaces.MoneyImplement;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Vault.jar:me/ext/vault/manager/Implementation.class */
public final class Implementation implements MoneyImplement {
    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginName() {
        return Optional.of(Vault.getExtensionCore().getPluginImp().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(Vault.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean hasMoney(Player player, double amount) {
        if (Vault.getExtensionCore().getEcon().has(player, amount)) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean addMoney(Player player, double amount) {
        if (Vault.getExtensionCore().getEcon().depositPlayer(player, amount).transactionSuccess()) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean withdrawMoney(Player player, double amount) {
        if (Vault.getExtensionCore().getEcon().withdrawPlayer(player, amount).transactionSuccess()) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public double getMoney(Player player, boolean inDouble) {
        return Vault.getExtensionCore().getEcon().getBalance(player);
    }
}

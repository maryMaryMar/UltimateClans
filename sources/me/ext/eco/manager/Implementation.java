package me.ext.eco.manager;

import com.willfp.eco.core.integrations.economy.EconomyManager;
import java.util.Optional;
import me.ext.eco.Eco;
import me.ulrich.clans.interfaces.MoneyImplement;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Eco.jar:me/ext/eco/manager/Implementation.class */
public final class Implementation implements MoneyImplement {
    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginName() {
        return Optional.of(Eco.getExtensionCore().getPluginImp().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(Eco.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean hasMoney(Player player, double amount) {
        return EconomyManager.hasAmount(player, amount);
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean addMoney(Player player, double amount) {
        return EconomyManager.giveMoney(player, amount);
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean withdrawMoney(Player player, double amount) {
        return EconomyManager.removeMoney(player, amount);
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public double getMoney(Player player, boolean inDouble) {
        return (int) EconomyManager.getBalance(player);
    }
}

package me.ext.elementalgems.manager;

import java.util.Optional;
import me.elementalgaming.ElementalGems.GemAPI;
import me.ext.elementalgems.ElementalGems;
import me.ulrich.clans.interfaces.MoneyImplement;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Elementalgems.jar:me/ext/elementalgems/manager/Implementation.class */
public final class Implementation implements MoneyImplement {
    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean hasMoney(Player player, double amount) {
        if (GemAPI.getGems(player.getUniqueId()) >= amount) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean addMoney(Player player, double amount) {
        GemAPI.addGems(player.getUniqueId(), amount);
        return true;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean withdrawMoney(Player player, double amount) {
        if (GemAPI.getGems(player.getUniqueId()) >= amount) {
            GemAPI.removeGems(player.getUniqueId(), amount);
            return false;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public double getMoney(Player player, boolean inDouble) {
        return GemAPI.getGems(player.getUniqueId());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginName() {
        return Optional.of(ElementalGems.getExtensionCore().getPluginImp().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(ElementalGems.getExtensionCore().getPluginImp().getDescription().getVersion());
    }
}

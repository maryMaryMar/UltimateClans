package me.ext.playerpoints.manager;

import java.util.Optional;
import me.ext.playerpoints.PlayerPoints;
import me.ulrich.clans.interfaces.MoneyImplement;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Playerpoints.jar:me/ext/playerpoints/manager/Implementation.class */
public final class Implementation implements MoneyImplement {
    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginName() {
        return Optional.of(PlayerPoints.getExtensionCore().getPluginImp().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(PlayerPoints.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean hasMoney(Player player, double amount) {
        if (PlayerPoints.getExtensionCore().getPlayerPointsCast().getAPI().look(player.getUniqueId()) >= amount) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean addMoney(Player player, double amount) {
        if (PlayerPoints.getExtensionCore().getPlayerPointsCast().getAPI().give(player.getUniqueId(), (int) amount)) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public boolean withdrawMoney(Player player, double amount) {
        if (PlayerPoints.getExtensionCore().getPlayerPointsCast().getAPI().take(player.getUniqueId(), (int) amount)) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.MoneyImplement
    public double getMoney(Player player, boolean inDouble) {
        return PlayerPoints.getExtensionCore().getPlayerPointsCast().getAPI().look(player.getUniqueId());
    }
}

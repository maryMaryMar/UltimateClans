package me.ulrich.clans.interfaces;

import java.util.Optional;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/MoneyImplement.class */
public interface MoneyImplement {
    boolean hasMoney(Player player, double d);

    boolean addMoney(Player player, double d);

    boolean withdrawMoney(Player player, double d);

    double getMoney(Player player, boolean z);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

package me.ulrich.clans.interfaces;

import java.util.UUID;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/BankAddonAPI.class */
public interface BankAddonAPI {
    String parseText(UUID uuid, String str);

    boolean hasMoney(Player player, double d);

    boolean withdrawMoney(Player player, double d);

    boolean addMoney(Player player, double d);

    double getMoney(Player player);

    double clanBalance(UUID uuid);

    boolean hasClanBank(UUID uuid, Double d);

    boolean addClanBank(UUID uuid, Double d, Player player);

    boolean withdrawClanBank(UUID uuid, Double d, Player player);

    boolean setClanBank(UUID uuid, Double d, Player player);

    String clanBalanceFormated(UUID uuid);

    Double clanBankLimit(UUID uuid);
}

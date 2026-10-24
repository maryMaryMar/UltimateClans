package me.ulrich.clans.interfaces;

import java.util.UUID;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/HooksAPI.class */
public interface HooksAPI {
    boolean isInDuel(Player player);

    Player getEnemyCombat(Player player);

    boolean removeCombat(Player player);

    boolean isInCombat(Player player);

    boolean isFloodgate();

    String getPlayerName(Player player);

    String parsePapi(Player player, String str);

    String parsePapi(UUID uuid, String str);
}

package me.ulrich.clans.interfaces;

import java.util.Optional;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ScoreboardImplement.class */
public interface ScoreboardImplement {
    boolean hidePluginScoreboard(Player player);

    boolean showPluginScoreboard(Player player);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

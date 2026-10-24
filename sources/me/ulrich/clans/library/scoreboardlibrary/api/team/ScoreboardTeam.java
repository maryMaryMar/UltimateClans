package me.ulrich.clans.library.scoreboardlibrary.api.team;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/team/ScoreboardTeam.class */
public interface ScoreboardTeam {
    @NotNull
    TeamManager teamManager();

    @NotNull
    String name();

    @NotNull
    TeamDisplay defaultDisplay();

    @NotNull
    TeamDisplay display(@NotNull Player player);

    void display(@NotNull Player player, @NotNull TeamDisplay teamDisplay);

    @NotNull
    TeamDisplay createDisplay();
}

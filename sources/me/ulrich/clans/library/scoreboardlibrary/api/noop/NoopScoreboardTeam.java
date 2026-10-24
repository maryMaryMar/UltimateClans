package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopScoreboardTeam.class */
class NoopScoreboardTeam implements ScoreboardTeam {
    private final NoopTeamManager teamManager;
    private final String name;
    private final Map<Player, TeamDisplay> displayMap = new HashMap();
    private final NoopTeamDisplay defaultDisplay = new NoopTeamDisplay(this);

    NoopScoreboardTeam(@NotNull NoopTeamManager noopTeamManager, String str) {
        this.teamManager = noopTeamManager;
        this.name = str;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public TeamManager teamManager() {
        return this.teamManager;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public String name() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public NoopTeamDisplay defaultDisplay() {
        return this.defaultDisplay;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public TeamDisplay display(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        if (this.teamManager.players().contains(player)) {
            return (TeamDisplay) Objects.requireNonNull(this.displayMap.get(player));
        }
        throw new IllegalArgumentException("player not in TeamManager");
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    public void display(@NotNull Player player, @NotNull TeamDisplay teamDisplay) {
        Preconditions.checkNotNull(player);
        Preconditions.checkNotNull(teamDisplay);
        if (!this.teamManager.players().contains(player)) {
            throw new IllegalArgumentException("player not in TeamManager");
        }
        if (teamDisplay.team() != this || !(teamDisplay instanceof NoopTeamDisplay)) {
            throw new IllegalArgumentException("invalid TeamDisplay");
        }
        this.displayMap.put(player, teamDisplay);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public TeamDisplay createDisplay() {
        return new NoopTeamDisplay(this);
    }

    @NotNull
    Map<Player, TeamDisplay> displayMap() {
        return this.displayMap;
    }
}

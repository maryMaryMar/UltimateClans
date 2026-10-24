package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopTeamManager.class */
class NoopTeamManager implements TeamManager {
    private final Set<Player> players = new HashSet();
    private final Map<String, NoopScoreboardTeam> teams = new HashMap();
    private boolean closed;

    NoopTeamManager() {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public void close() {
        this.closed = true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean closed() {
        return this.closed;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    @NotNull
    public Collection<Player> players() {
        return this.closed ? Collections.emptySet() : Collections.unmodifiableSet(this.players);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean removePlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.remove(player)) {
            return false;
        }
        Iterator<NoopScoreboardTeam> it = this.teams.values().iterator();
        while (it.hasNext()) {
            it.next().displayMap().remove(player);
        }
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public CompletableFuture<Void> removePlayerFuture(@NotNull Player player) {
        removePlayer(player);
        return CompletableFuture.completedFuture(null);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    @NotNull
    public Collection<ScoreboardTeam> teams() {
        return this.closed ? Collections.emptySet() : Collections.unmodifiableCollection(this.teams.values());
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    @Nullable
    public ScoreboardTeam team(@NotNull String str) {
        return this.teams.get(str.toLowerCase());
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean teamExists(@NotNull String str) {
        return this.teams.containsKey(str.toLowerCase());
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    @NotNull
    public ScoreboardTeam createIfAbsent(@NotNull String str, @Nullable BiFunction<Player, ScoreboardTeam, TeamDisplay> biFunction) {
        Preconditions.checkNotNull(str);
        checkClosed();
        String lowerCase = str.toLowerCase();
        NoopScoreboardTeam noopScoreboardTeam = this.teams.get(lowerCase);
        if (noopScoreboardTeam != null) {
            return noopScoreboardTeam;
        }
        NoopScoreboardTeam noopScoreboardTeam2 = new NoopScoreboardTeam(this, lowerCase);
        for (Player player : this.players) {
            TeamDisplay teamDisplayDefaultDisplay = biFunction == null ? noopScoreboardTeam2.defaultDisplay() : biFunction.apply(player, noopScoreboardTeam2);
            validateTeamDisplay(noopScoreboardTeam2, teamDisplayDefaultDisplay);
            noopScoreboardTeam2.displayMap().put(player, teamDisplayDefaultDisplay);
        }
        this.teams.put(lowerCase, noopScoreboardTeam2);
        return noopScoreboardTeam2;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean removeTeam(@NotNull String str) {
        Preconditions.checkNotNull(str);
        checkClosed();
        return this.teams.remove(str.toLowerCase()) != null;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public void removeTeam(@NotNull ScoreboardTeam scoreboardTeam) {
        Preconditions.checkNotNull(scoreboardTeam);
        Preconditions.checkArgument(scoreboardTeam.teamManager() == this);
        checkClosed();
        this.teams.remove(scoreboardTeam.name(), (NoopScoreboardTeam) scoreboardTeam);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean addPlayer(@NotNull Player player, @Nullable Function<ScoreboardTeam, TeamDisplay> function) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.add(player)) {
            return false;
        }
        for (NoopScoreboardTeam noopScoreboardTeam : this.teams.values()) {
            TeamDisplay teamDisplayDefaultDisplay = function == null ? noopScoreboardTeam.defaultDisplay() : function.apply(noopScoreboardTeam);
            validateTeamDisplay(noopScoreboardTeam, teamDisplayDefaultDisplay);
            noopScoreboardTeam.displayMap().put(player, teamDisplayDefaultDisplay);
        }
        return true;
    }

    private void validateTeamDisplay(@NotNull ScoreboardTeam scoreboardTeam, @Nullable TeamDisplay teamDisplay) {
        if (teamDisplay == null || teamDisplay.team() != scoreboardTeam) {
            throw new IllegalArgumentException("invalid TeamDisplay");
        }
        if (!(teamDisplay instanceof NoopTeamDisplay)) {
            throw new IllegalArgumentException("must be TeamDisplayImpl");
        }
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("NoopTeamManager is closed");
        }
    }
}

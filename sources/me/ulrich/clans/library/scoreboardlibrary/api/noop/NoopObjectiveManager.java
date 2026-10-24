package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopObjectiveManager.class */
class NoopObjectiveManager implements ObjectiveManager {
    private final Map<String, ScoreboardObjective> objectives = new HashMap();
    private final Set<Player> players = new HashSet();
    private boolean isClosed = true;

    NoopObjectiveManager() {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    @NotNull
    public ScoreboardObjective create(@NotNull String str) {
        return this.objectives.computeIfAbsent(str, str2 -> {
            return new NoopScoreboardObjective();
        });
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public void remove(@NotNull ScoreboardObjective scoreboardObjective) {
        this.objectives.values().remove(scoreboardObjective);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public void display(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot, @NotNull ScoreboardObjective scoreboardObjective) {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    @NotNull
    public Collection<Player> players() {
        return Collections.unmodifiableSet(this.players);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public boolean addPlayer(@NotNull Player player) {
        return this.players.add(player);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public boolean removePlayer(@NotNull Player player) {
        return this.players.remove(player);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public CompletableFuture<Void> removePlayerFuture(@NotNull Player player) {
        this.players.remove(player);
        return CompletableFuture.completedFuture(null);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public void close() {
        this.isClosed = true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public boolean closed() {
        return this.isClosed;
    }
}

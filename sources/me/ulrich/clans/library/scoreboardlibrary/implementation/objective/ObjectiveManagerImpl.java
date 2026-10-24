package me.ulrich.clans.library.scoreboardlibrary.implementation.objective;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveScore;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.ScoreboardLibraryPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerImpl.class */
public final class ObjectiveManagerImpl implements ObjectiveManager, PlayerDisplayable {
    private final ScoreboardLibraryImpl library;
    private final Map<String, ScoreboardObjectiveImpl> objectives = new ConcurrentHashMap();
    private final Map<ObjectiveDisplaySlot, ScoreboardObjectiveImpl> displaySlots = new HashMap();
    private final Set<Player> players = new HashSet(8);
    private final Set<Player> displayingPlayers = new HashSet(8);
    private final Queue<ObjectiveManagerTask> taskQueue = new ConcurrentLinkedQueue();
    private boolean closed;

    public ObjectiveManagerImpl(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl) {
        this.library = scoreboardLibraryImpl;
    }

    @NotNull
    public Queue<ObjectiveManagerTask> taskQueue() {
        return this.taskQueue;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    @NotNull
    public ScoreboardObjective create(@NotNull String str) {
        Preconditions.checkNotNull(str);
        checkClosed();
        return this.objectives.computeIfAbsent(str, str2 -> {
            ScoreboardObjectiveImpl scoreboardObjectiveImpl = new ScoreboardObjectiveImpl(this.library.packetAdapter().createObjectiveAdapter(str), this.taskQueue, str);
            this.taskQueue.add(new ObjectiveManagerTask.AddObjective(scoreboardObjectiveImpl));
            return scoreboardObjectiveImpl;
        });
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public void remove(@NotNull ScoreboardObjective scoreboardObjective) {
        Preconditions.checkNotNull(scoreboardObjective);
        checkClosed();
        if (scoreboardObjective instanceof ScoreboardObjectiveImpl) {
            ScoreboardObjectiveImpl scoreboardObjectiveImpl = (ScoreboardObjectiveImpl) scoreboardObjective;
            if (this.objectives.values().remove(scoreboardObjectiveImpl)) {
                this.displaySlots.values().removeIf(scoreboardObjectiveImpl2 -> {
                    return scoreboardObjectiveImpl2 == scoreboardObjectiveImpl;
                });
                scoreboardObjectiveImpl.close();
                this.taskQueue.add(new ObjectiveManagerTask.RemoveObjective(scoreboardObjectiveImpl));
            }
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public void display(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot, @NotNull ScoreboardObjective scoreboardObjective) {
        Preconditions.checkNotNull(objectiveDisplaySlot);
        Preconditions.checkNotNull(scoreboardObjective);
        checkClosed();
        if (!(scoreboardObjective instanceof ScoreboardObjectiveImpl)) {
            throw new IllegalArgumentException("Invalid objective implementation");
        }
        ScoreboardObjectiveImpl scoreboardObjectiveImpl = (ScoreboardObjectiveImpl) scoreboardObjective;
        if (this.objectives.get(scoreboardObjectiveImpl.name()) != scoreboardObjectiveImpl) {
            throw new IllegalArgumentException("Objective is from a different manager");
        }
        this.displaySlots.put(objectiveDisplaySlot, scoreboardObjectiveImpl);
        this.taskQueue.add(new ObjectiveManagerTask.UpdateDisplaySlot(objectiveDisplaySlot, scoreboardObjectiveImpl));
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    @NotNull
    public Collection<Player> players() {
        return Collections.unmodifiableSet(this.players);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public boolean addPlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.add(player)) {
            return false;
        }
        this.taskQueue.add(new ObjectiveManagerTask.AddPlayer(player));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public boolean removePlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.remove(player)) {
            return false;
        }
        this.taskQueue.add(new ObjectiveManagerTask.RemovePlayer(player, null));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public CompletableFuture<Void> removePlayerFuture(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.remove(player)) {
            return CompletableFuture.completedFuture(null);
        }
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        this.taskQueue.add(new ObjectiveManagerTask.RemovePlayer(player, completableFuture));
        return completableFuture;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.taskQueue.add(ObjectiveManagerTask.Close.INSTANCE);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager
    public boolean closed() {
        return this.closed;
    }

    public boolean tick() {
        while (true) {
            ObjectiveManagerTask objectiveManagerTaskPoll = this.taskQueue.poll();
            if (objectiveManagerTaskPoll == null) {
                return true;
            }
            if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.Close) {
                Iterator<ScoreboardObjectiveImpl> it = this.objectives.values().iterator();
                while (it.hasNext()) {
                    it.next().packetAdapter().remove(this.displayingPlayers);
                }
                Iterator<Player> it2 = this.players.iterator();
                while (it2.hasNext()) {
                    ((ScoreboardLibraryPlayer) Objects.requireNonNull(this.library.getPlayer(it2.next()))).objectiveManagerQueue().remove(this);
                }
                return false;
            }
            if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.AddPlayer) {
                this.library.getOrCreatePlayer(((ObjectiveManagerTask.AddPlayer) objectiveManagerTaskPoll).player()).objectiveManagerQueue().add(this);
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.RemovePlayer) {
                ObjectiveManagerTask.RemovePlayer removePlayer = (ObjectiveManagerTask.RemovePlayer) objectiveManagerTaskPoll;
                Set setSingleton = Collections.singleton(removePlayer.player());
                Iterator<ScoreboardObjectiveImpl> it3 = this.objectives.values().iterator();
                while (it3.hasNext()) {
                    it3.next().packetAdapter().remove(setSingleton);
                }
                this.displayingPlayers.remove(removePlayer.player());
                ((ScoreboardLibraryPlayer) Objects.requireNonNull(this.library.getPlayer(removePlayer.player()))).objectiveManagerQueue().remove(this);
                if (removePlayer.future() != null) {
                    removePlayer.future().complete(null);
                }
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.ReloadPlayer) {
                Set setSingleton2 = Collections.singleton(((ObjectiveManagerTask.ReloadPlayer) objectiveManagerTaskPoll).player());
                for (ScoreboardObjectiveImpl scoreboardObjectiveImpl : this.objectives.values()) {
                    scoreboardObjectiveImpl.sendProperties(setSingleton2, PropertiesPacketType.UPDATE);
                    for (Map.Entry<String, ObjectiveScore> entry : scoreboardObjectiveImpl.scores().entrySet()) {
                        ObjectiveScore value = entry.getValue();
                        scoreboardObjectiveImpl.packetAdapter().sendScore(setSingleton2, entry.getKey(), value.value(), value.displayName(), value.format());
                    }
                }
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.AddObjective) {
                ScoreboardObjectiveImpl scoreboardObjectiveImplObjective = ((ObjectiveManagerTask.AddObjective) objectiveManagerTaskPoll).objective();
                scoreboardObjectiveImplObjective.sendProperties(this.displayingPlayers, PropertiesPacketType.CREATE);
                scoreboardObjectiveImplObjective.wasDisplayed(true);
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.RemoveObjective) {
                ((ObjectiveManagerTask.RemoveObjective) objectiveManagerTaskPoll).objective().packetAdapter().remove(this.displayingPlayers);
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.UpdateObjective) {
                ((ObjectiveManagerTask.UpdateObjective) objectiveManagerTaskPoll).objective().sendProperties(this.displayingPlayers, PropertiesPacketType.UPDATE);
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.UpdateScore) {
                ObjectiveManagerTask.UpdateScore updateScore = (ObjectiveManagerTask.UpdateScore) objectiveManagerTaskPoll;
                ScoreboardObjectiveImpl scoreboardObjectiveImplObjective2 = updateScore.objective();
                String strEntry = updateScore.entry();
                ObjectiveScore objectiveScoreScore = updateScore.score();
                if (objectiveScoreScore != null) {
                    scoreboardObjectiveImplObjective2.packetAdapter().sendScore(this.displayingPlayers, strEntry, objectiveScoreScore.value(), objectiveScoreScore.displayName(), objectiveScoreScore.format());
                } else {
                    scoreboardObjectiveImplObjective2.packetAdapter().removeScore(this.displayingPlayers, strEntry);
                }
            } else if (objectiveManagerTaskPoll instanceof ObjectiveManagerTask.UpdateDisplaySlot) {
                ObjectiveManagerTask.UpdateDisplaySlot updateDisplaySlot = (ObjectiveManagerTask.UpdateDisplaySlot) objectiveManagerTaskPoll;
                updateDisplaySlot.objective().packetAdapter().display(this.displayingPlayers, updateDisplaySlot.displaySlot());
            }
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable
    public void display(@NotNull Player player) {
        this.displayingPlayers.add(player);
        Set setSingleton = Collections.singleton(player);
        for (ScoreboardObjectiveImpl scoreboardObjectiveImpl : this.objectives.values()) {
            if (scoreboardObjectiveImpl.wasDisplayed()) {
                scoreboardObjectiveImpl.sendProperties(setSingleton, PropertiesPacketType.CREATE);
                for (Map.Entry<String, ObjectiveScore> entry : scoreboardObjectiveImpl.scores().entrySet()) {
                    ObjectiveScore value = entry.getValue();
                    scoreboardObjectiveImpl.packetAdapter().sendScore(setSingleton, entry.getKey(), value.value(), value.displayName(), value.format());
                }
            }
        }
        for (Map.Entry<ObjectiveDisplaySlot, ScoreboardObjectiveImpl> entry2 : this.displaySlots.entrySet()) {
            if (entry2.getValue().wasDisplayed()) {
                entry2.getValue().packetAdapter().display(setSingleton, entry2.getKey());
            }
        }
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("ObjectiveManager is closed");
        }
    }
}

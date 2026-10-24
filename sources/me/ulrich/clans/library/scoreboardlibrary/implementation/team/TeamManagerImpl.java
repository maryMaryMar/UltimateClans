package me.ulrich.clans.library.scoreboardlibrary.implementation.team;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.ScoreboardLibraryPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerImpl.class */
public final class TeamManagerImpl implements TeamManager, PlayerDisplayable {
    private final ScoreboardLibraryImpl scoreboardLibrary;
    private final Set<Player> players = new HashSet(8);
    private final List<Player> internalPlayers = new ArrayList(8);
    private final Map<String, ScoreboardTeamImpl> teams = new ConcurrentHashMap();
    private final Queue<TeamManagerTask> taskQueue = new ConcurrentLinkedQueue();
    private boolean closed;

    public TeamManagerImpl(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl) {
        this.scoreboardLibrary = scoreboardLibraryImpl;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.taskQueue.add(TeamManagerTask.Close.INSTANCE);
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
        ScoreboardTeamImpl scoreboardTeamImpl = this.teams.get(lowerCase);
        if (scoreboardTeamImpl != null) {
            return scoreboardTeamImpl;
        }
        ScoreboardTeamImpl scoreboardTeamImpl2 = new ScoreboardTeamImpl(this, lowerCase);
        this.teams.put(lowerCase, scoreboardTeamImpl2);
        for (Player player : this.players) {
            TeamDisplay teamDisplayDefaultDisplay = biFunction == null ? scoreboardTeamImpl2.defaultDisplay() : biFunction.apply(player, scoreboardTeamImpl2);
            validateTeamDisplay(scoreboardTeamImpl2, teamDisplayDefaultDisplay);
            scoreboardTeamImpl2.displayMap().put(player, (TeamDisplayImpl) teamDisplayDefaultDisplay);
        }
        this.taskQueue.add(new TeamManagerTask.AddTeam(scoreboardTeamImpl2));
        return scoreboardTeamImpl2;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean removeTeam(@NotNull String str) {
        Preconditions.checkNotNull(str);
        checkClosed();
        ScoreboardTeamImpl scoreboardTeamImplRemove = this.teams.remove(str.toLowerCase());
        if (scoreboardTeamImplRemove == null) {
            return false;
        }
        this.taskQueue.add(new TeamManagerTask.RemoveTeam(scoreboardTeamImplRemove));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public void removeTeam(@NotNull ScoreboardTeam scoreboardTeam) {
        Preconditions.checkNotNull(scoreboardTeam);
        Preconditions.checkArgument(scoreboardTeam.teamManager() == this);
        checkClosed();
        if (this.teams.remove(scoreboardTeam.name(), (ScoreboardTeamImpl) scoreboardTeam)) {
            this.taskQueue.add(new TeamManagerTask.RemoveTeam((ScoreboardTeamImpl) scoreboardTeam));
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean addPlayer(@NotNull Player player, @Nullable Function<ScoreboardTeam, TeamDisplay> function) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.add(player)) {
            return false;
        }
        for (ScoreboardTeamImpl scoreboardTeamImpl : this.teams.values()) {
            TeamDisplay teamDisplayDefaultDisplay = function == null ? scoreboardTeamImpl.defaultDisplay() : function.apply(scoreboardTeamImpl);
            validateTeamDisplay(scoreboardTeamImpl, teamDisplayDefaultDisplay);
            scoreboardTeamImpl.displayMap().put(player, (TeamDisplayImpl) teamDisplayDefaultDisplay);
        }
        this.taskQueue.add(new TeamManagerTask.AddPlayer(player));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public boolean removePlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.remove(player)) {
            return false;
        }
        this.taskQueue.add(new TeamManagerTask.RemovePlayer(player, null));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager
    public CompletableFuture<Void> removePlayerFuture(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.remove(player)) {
            return CompletableFuture.completedFuture(null);
        }
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        this.taskQueue.add(new TeamManagerTask.RemovePlayer(player, completableFuture));
        return completableFuture;
    }

    @NotNull
    public ScoreboardLibraryImpl scoreboardLibrary() {
        return this.scoreboardLibrary;
    }

    @NotNull
    public Queue<TeamManagerTask> taskQueue() {
        return this.taskQueue;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable
    public void display(@NotNull Player player) {
        Iterator<ScoreboardTeamImpl> it = this.teams.values().iterator();
        while (it.hasNext()) {
            it.next().addPlayer(player);
        }
    }

    public boolean tick() {
        while (true) {
            TeamManagerTask teamManagerTaskPoll = this.taskQueue.poll();
            if (teamManagerTaskPoll == null) {
                return true;
            }
            if (teamManagerTaskPoll instanceof TeamManagerTask.Close) {
                Iterator<ScoreboardTeamImpl> it = this.teams.values().iterator();
                while (it.hasNext()) {
                    for (TeamDisplayImpl teamDisplayImpl : it.next().displayMap().values()) {
                        teamDisplayImpl.packetAdapter().removeTeam(teamDisplayImpl.players());
                    }
                }
                Iterator<Player> it2 = this.internalPlayers.iterator();
                while (it2.hasNext()) {
                    ((ScoreboardLibraryPlayer) Objects.requireNonNull(this.scoreboardLibrary.getPlayer(it2.next()))).teamManagerQueue().remove(this);
                }
                return false;
            }
            if (teamManagerTaskPoll instanceof TeamManagerTask.AddPlayer) {
                TeamManagerTask.AddPlayer addPlayer = (TeamManagerTask.AddPlayer) teamManagerTaskPoll;
                this.scoreboardLibrary.getOrCreatePlayer(addPlayer.player()).teamManagerQueue().add(this);
                this.internalPlayers.add(addPlayer.player());
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.RemovePlayer) {
                TeamManagerTask.RemovePlayer removePlayer = (TeamManagerTask.RemovePlayer) teamManagerTaskPoll;
                Iterator<ScoreboardTeamImpl> it3 = this.teams.values().iterator();
                while (it3.hasNext()) {
                    it3.next().removePlayer(removePlayer.player());
                }
                this.internalPlayers.remove(removePlayer.player());
                ((ScoreboardLibraryPlayer) Objects.requireNonNull(this.scoreboardLibrary.getPlayer(removePlayer.player()))).teamManagerQueue().remove(this);
                if (removePlayer.future() != null) {
                    removePlayer.future().complete(null);
                }
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.ReloadPlayer) {
                TeamManagerTask.ReloadPlayer reloadPlayer = (TeamManagerTask.ReloadPlayer) teamManagerTaskPoll;
                Iterator<ScoreboardTeamImpl> it4 = this.teams.values().iterator();
                while (it4.hasNext()) {
                    TeamDisplayImpl teamDisplayImpl2 = it4.next().displayMap().get(reloadPlayer.player());
                    if (teamDisplayImpl2 != null) {
                        teamDisplayImpl2.packetAdapter().sendProperties(PropertiesPacketType.UPDATE, Collections.singleton(reloadPlayer.player()));
                    }
                }
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.AddTeam) {
                ScoreboardTeamImpl scoreboardTeamImplTeam = ((TeamManagerTask.AddTeam) teamManagerTaskPoll).team();
                for (Player player : scoreboardTeamImplTeam.displayMap().keySet()) {
                    ScoreboardLibraryPlayer player2 = this.scoreboardLibrary.getPlayer(player);
                    if (player2 != null && player2.teamManagerQueue().current() == this) {
                        scoreboardTeamImplTeam.addPlayer(player);
                    }
                }
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.RemoveTeam) {
                for (TeamDisplayImpl teamDisplayImpl3 : ((TeamManagerTask.RemoveTeam) teamManagerTaskPoll).team().displayMap().values()) {
                    teamDisplayImpl3.packetAdapter().removeTeam(teamDisplayImpl3.players());
                }
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.UpdateTeamDisplay) {
                ((TeamManagerTask.UpdateTeamDisplay) teamManagerTaskPoll).teamDisplay().handleUpdateDisplay();
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.AddEntries) {
                TeamManagerTask.AddEntries addEntries = (TeamManagerTask.AddEntries) teamManagerTaskPoll;
                addEntries.teamDisplay().handleAddEntries(addEntries.entries());
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.RemoveEntries) {
                TeamManagerTask.RemoveEntries removeEntries = (TeamManagerTask.RemoveEntries) teamManagerTaskPoll;
                removeEntries.teamDisplay().handleRemoveEntries(removeEntries.entries());
            } else if (teamManagerTaskPoll instanceof TeamManagerTask.ChangeTeamDisplay) {
                TeamManagerTask.ChangeTeamDisplay changeTeamDisplay = (TeamManagerTask.ChangeTeamDisplay) teamManagerTaskPoll;
                changeTeamDisplay.team().changeTeamDisplay(changeTeamDisplay.player(), changeTeamDisplay.oldTeamDisplay(), changeTeamDisplay.newTeamDisplay());
            }
        }
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("TeamManager is closed");
        }
    }

    private void validateTeamDisplay(@NotNull ScoreboardTeam scoreboardTeam, @Nullable TeamDisplay teamDisplay) {
        if (teamDisplay == null || teamDisplay.team() != scoreboardTeam) {
            throw new IllegalArgumentException("invalid TeamDisplay");
        }
        if (!(teamDisplay instanceof TeamDisplayImpl)) {
            throw new IllegalArgumentException("must be TeamDisplayImpl");
        }
    }
}

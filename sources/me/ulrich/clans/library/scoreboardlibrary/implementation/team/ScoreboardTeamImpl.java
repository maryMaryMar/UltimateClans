package me.ulrich.clans.library.scoreboardlibrary.implementation.team;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.EntriesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/ScoreboardTeamImpl.class */
public final class ScoreboardTeamImpl implements ScoreboardTeam {
    private final TeamManagerImpl teamManager;
    private final String name;
    private final TeamsPacketAdapter packetAdapter;
    private final Map<Player, TeamDisplayImpl> displayMap = new ConcurrentHashMap();
    private final TeamDisplayImpl defaultDisplay = new TeamDisplayImpl(this);

    public ScoreboardTeamImpl(@NotNull TeamManagerImpl teamManagerImpl, @NotNull String str) {
        this.teamManager = teamManagerImpl;
        this.name = str;
        this.packetAdapter = teamManagerImpl.scoreboardLibrary().packetAdapter().createTeamPacketAdapter(str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public TeamManagerImpl teamManager() {
        return this.teamManager;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public String name() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public TeamDisplayImpl defaultDisplay() {
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
        if (teamDisplay.team() != this || !(teamDisplay instanceof TeamDisplayImpl)) {
            throw new IllegalArgumentException("invalid TeamDisplay");
        }
        TeamDisplayImpl teamDisplayImpl = (TeamDisplayImpl) Objects.requireNonNull(this.displayMap.put(player, (TeamDisplayImpl) teamDisplay));
        if (teamDisplayImpl == teamDisplay) {
            return;
        }
        this.teamManager.taskQueue().add(new TeamManagerTask.ChangeTeamDisplay(player, this, teamDisplayImpl, (TeamDisplayImpl) teamDisplay));
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam
    @NotNull
    public TeamDisplay createDisplay() {
        return new TeamDisplayImpl(this);
    }

    @NotNull
    public TeamsPacketAdapter packetAdapter() {
        return this.packetAdapter;
    }

    @NotNull
    public Map<Player, TeamDisplayImpl> displayMap() {
        return this.displayMap;
    }

    public void addPlayer(@NotNull Player player) {
        TeamDisplayImpl teamDisplayImpl = (TeamDisplayImpl) Objects.requireNonNull(this.displayMap.get(player));
        if (teamDisplayImpl.players().add(player)) {
            teamDisplayImpl.packetAdapter().sendProperties(PropertiesPacketType.CREATE, Collections.singleton(player));
        }
    }

    public void removePlayer(@NotNull Player player) {
        TeamDisplayImpl teamDisplayImpl = (TeamDisplayImpl) Objects.requireNonNull(this.displayMap.remove(player));
        if (teamDisplayImpl.players().remove(player)) {
            teamDisplayImpl.packetAdapter().removeTeam(Collections.singleton(player));
        }
    }

    public void changeTeamDisplay(@NotNull Player player, @NotNull TeamDisplayImpl teamDisplayImpl, @NotNull TeamDisplayImpl teamDisplayImpl2) {
        if (teamDisplayImpl.players().remove(player)) {
            teamDisplayImpl2.players().add(player);
            Set setSingleton = Collections.singleton(player);
            teamDisplayImpl2.packetAdapter().sendProperties(PropertiesPacketType.UPDATE, setSingleton);
            Collection<String> collectionSyncedEntries = teamDisplayImpl.syncedEntries();
            Collection<String> collectionSyncedEntries2 = teamDisplayImpl2.syncedEntries();
            if (collectionSyncedEntries.isEmpty()) {
                teamDisplayImpl2.packetAdapter().sendEntries(EntriesPacketType.ADD, setSingleton, collectionSyncedEntries2);
                return;
            }
            ArrayList arrayList = new ArrayList(collectionSyncedEntries);
            arrayList.removeAll(collectionSyncedEntries2);
            if (!arrayList.isEmpty()) {
                teamDisplayImpl2.packetAdapter().sendEntries(EntriesPacketType.REMOVE, setSingleton, arrayList);
            }
            ArrayList arrayList2 = new ArrayList(collectionSyncedEntries2);
            arrayList2.removeAll(collectionSyncedEntries);
            if (arrayList2.isEmpty()) {
                return;
            }
            teamDisplayImpl2.packetAdapter().sendEntries(EntriesPacketType.ADD, setSingleton, arrayList2);
        }
    }
}

package me.ulrich.clans.library.scoreboardlibrary.implementation.player;

import java.util.UUID;
import me.ulrich.clans.library.scoreboardlibrary.implementation.objective.ObjectiveManagerImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar;
import me.ulrich.clans.library.scoreboardlibrary.implementation.team.TeamManagerImpl;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/player/ScoreboardLibraryPlayer.class */
public final class ScoreboardLibraryPlayer {
    private final DisplayableQueue<TeamManagerImpl> teamManagerQueue;
    private final DisplayableQueue<ObjectiveManagerImpl> objectiveManagerQueue;
    private final DisplayableQueue<AbstractSidebar> sidebarQueue;

    public ScoreboardLibraryPlayer(@NotNull Player player) {
        UUID uniqueId = player.getUniqueId();
        this.teamManagerQueue = new DisplayableQueue<>(uniqueId);
        this.objectiveManagerQueue = new DisplayableQueue<>(uniqueId);
        this.sidebarQueue = new DisplayableQueue<>(uniqueId);
    }

    @NotNull
    public DisplayableQueue<TeamManagerImpl> teamManagerQueue() {
        return this.teamManagerQueue;
    }

    @NotNull
    public DisplayableQueue<ObjectiveManagerImpl> objectiveManagerQueue() {
        return this.objectiveManagerQueue;
    }

    @NotNull
    public DisplayableQueue<AbstractSidebar> sidebarQueue() {
        return this.sidebarQueue;
    }
}

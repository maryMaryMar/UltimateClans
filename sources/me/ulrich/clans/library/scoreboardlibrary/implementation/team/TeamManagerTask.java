package me.ulrich.clans.library.scoreboardlibrary.implementation.team;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask.class */
public class TeamManagerTask {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$AddEntries.class */
    public static final class AddEntries extends TeamManagerTask {
        private final TeamDisplayImpl teamDisplay;
        private final Collection<String> entry;

        public AddEntries(@NotNull TeamDisplayImpl teamDisplayImpl, @NotNull Collection<String> collection) {
            super();
            this.teamDisplay = teamDisplayImpl;
            this.entry = collection;
        }

        @NotNull
        public TeamDisplayImpl teamDisplay() {
            return this.teamDisplay;
        }

        @NotNull
        public Collection<String> entries() {
            return this.entry;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$AddPlayer.class */
    public static final class AddPlayer extends TeamManagerTask {
        private final Player player;

        public AddPlayer(@NotNull Player player) {
            super();
            this.player = player;
        }

        @NotNull
        public Player player() {
            return this.player;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$AddTeam.class */
    public static final class AddTeam extends TeamManagerTask {
        private final ScoreboardTeamImpl team;

        public AddTeam(@NotNull ScoreboardTeamImpl scoreboardTeamImpl) {
            super();
            this.team = scoreboardTeamImpl;
        }

        @NotNull
        public ScoreboardTeamImpl team() {
            return this.team;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$ChangeTeamDisplay.class */
    public static final class ChangeTeamDisplay extends TeamManagerTask {
        private final Player player;
        private final ScoreboardTeamImpl team;
        private final TeamDisplayImpl oldTeamDisplay;
        private final TeamDisplayImpl newTeamDisplay;

        public ChangeTeamDisplay(@NotNull Player player, @NotNull ScoreboardTeamImpl scoreboardTeamImpl, @NotNull TeamDisplayImpl teamDisplayImpl, @NotNull TeamDisplayImpl teamDisplayImpl2) {
            super();
            this.player = player;
            this.team = scoreboardTeamImpl;
            this.oldTeamDisplay = teamDisplayImpl;
            this.newTeamDisplay = teamDisplayImpl2;
        }

        @NotNull
        public Player player() {
            return this.player;
        }

        @NotNull
        public ScoreboardTeamImpl team() {
            return this.team;
        }

        @NotNull
        public TeamDisplayImpl oldTeamDisplay() {
            return this.oldTeamDisplay;
        }

        @NotNull
        public TeamDisplayImpl newTeamDisplay() {
            return this.newTeamDisplay;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$Close.class */
    public static final class Close extends TeamManagerTask {
        public static final Close INSTANCE = new Close();

        private Close() {
            super();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$ReloadPlayer.class */
    public static final class ReloadPlayer extends TeamManagerTask {
        private final Player player;

        public ReloadPlayer(@NotNull Player player) {
            super();
            this.player = player;
        }

        @NotNull
        public Player player() {
            return this.player;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$RemoveEntries.class */
    public static final class RemoveEntries extends TeamManagerTask {
        private final TeamDisplayImpl teamDisplay;
        private final Collection<String> entry;

        public RemoveEntries(@NotNull TeamDisplayImpl teamDisplayImpl, @NotNull Collection<String> collection) {
            super();
            this.teamDisplay = teamDisplayImpl;
            this.entry = collection;
        }

        @NotNull
        public TeamDisplayImpl teamDisplay() {
            return this.teamDisplay;
        }

        @NotNull
        public Collection<String> entries() {
            return this.entry;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$RemovePlayer.class */
    public static final class RemovePlayer extends TeamManagerTask {
        private final Player player;
        private final CompletableFuture<Void> future;

        public RemovePlayer(@NotNull Player player, @Nullable CompletableFuture<Void> completableFuture) {
            super();
            this.player = player;
            this.future = completableFuture;
        }

        @NotNull
        public Player player() {
            return this.player;
        }

        @Nullable
        public CompletableFuture<Void> future() {
            return this.future;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$RemoveTeam.class */
    public static final class RemoveTeam extends TeamManagerTask {
        private final ScoreboardTeamImpl team;

        public RemoveTeam(@NotNull ScoreboardTeamImpl scoreboardTeamImpl) {
            super();
            this.team = scoreboardTeamImpl;
        }

        @NotNull
        public ScoreboardTeamImpl team() {
            return this.team;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamManagerTask$UpdateTeamDisplay.class */
    public static final class UpdateTeamDisplay extends TeamManagerTask {
        private final TeamDisplayImpl teamDisplay;

        public UpdateTeamDisplay(@NotNull TeamDisplayImpl teamDisplayImpl) {
            super();
            this.teamDisplay = teamDisplayImpl;
        }

        @NotNull
        public TeamDisplayImpl teamDisplay() {
            return this.teamDisplay;
        }
    }

    private TeamManagerTask() {
    }
}

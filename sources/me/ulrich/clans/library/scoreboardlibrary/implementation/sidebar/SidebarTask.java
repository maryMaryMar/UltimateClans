package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask.class */
public class SidebarTask {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$AddPlayer.class */
    public static final class AddPlayer extends SidebarTask {
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

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$Close.class */
    public static final class Close extends SidebarTask {
        public static final Close INSTANCE = new Close();

        private Close() {
            super();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$ReloadPlayer.class */
    public static final class ReloadPlayer extends SidebarTask {
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

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$RemovePlayer.class */
    public static final class RemovePlayer extends SidebarTask {
        private final Player player;

        public RemovePlayer(@NotNull Player player) {
            super();
            this.player = player;
        }

        @NotNull
        public Player player() {
            return this.player;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$UpdateLine.class */
    public static final class UpdateLine extends SidebarTask {
        private final int line;
        private final boolean updateValue;
        private final boolean updateScore;

        public UpdateLine(int i, boolean z, boolean z2) {
            super();
            this.line = i;
            this.updateValue = z;
            this.updateScore = z2;
        }

        public int line() {
            return this.line;
        }

        public boolean updateValue() {
            return this.updateValue;
        }

        public boolean updateScore() {
            return this.updateScore;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$UpdateScores.class */
    public static final class UpdateScores extends SidebarTask {
        public static final UpdateScores INSTANCE = new UpdateScores();

        private UpdateScores() {
            super();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarTask$UpdateTitle.class */
    public static final class UpdateTitle extends SidebarTask {
        public static final UpdateTitle INSTANCE = new UpdateTitle();

        private UpdateTitle() {
            super();
        }
    }

    private SidebarTask() {
    }
}

package me.ulrich.clans.library.scoreboardlibrary.implementation.objective;

import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveScore;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask.class */
public class ObjectiveManagerTask {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$AddObjective.class */
    public static final class AddObjective extends ObjectiveManagerTask {
        private final ScoreboardObjectiveImpl objective;

        public AddObjective(@NotNull ScoreboardObjectiveImpl scoreboardObjectiveImpl) {
            super();
            this.objective = scoreboardObjectiveImpl;
        }

        @NotNull
        public ScoreboardObjectiveImpl objective() {
            return this.objective;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$AddPlayer.class */
    public static final class AddPlayer extends ObjectiveManagerTask {
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

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$Close.class */
    public static final class Close extends ObjectiveManagerTask {
        public static final Close INSTANCE = new Close();

        private Close() {
            super();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$ReloadPlayer.class */
    public static final class ReloadPlayer extends ObjectiveManagerTask {
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

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$RemoveObjective.class */
    public static final class RemoveObjective extends ObjectiveManagerTask {
        private final ScoreboardObjectiveImpl objective;

        public RemoveObjective(@NotNull ScoreboardObjectiveImpl scoreboardObjectiveImpl) {
            super();
            this.objective = scoreboardObjectiveImpl;
        }

        @NotNull
        public ScoreboardObjectiveImpl objective() {
            return this.objective;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$RemovePlayer.class */
    public static final class RemovePlayer extends ObjectiveManagerTask {
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

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$UpdateDisplaySlot.class */
    public static final class UpdateDisplaySlot extends ObjectiveManagerTask {
        private final ObjectiveDisplaySlot displaySlot;
        private final ScoreboardObjectiveImpl objective;

        public UpdateDisplaySlot(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot, @NotNull ScoreboardObjectiveImpl scoreboardObjectiveImpl) {
            super();
            this.displaySlot = objectiveDisplaySlot;
            this.objective = scoreboardObjectiveImpl;
        }

        @NotNull
        public ObjectiveDisplaySlot displaySlot() {
            return this.displaySlot;
        }

        @NotNull
        public ScoreboardObjectiveImpl objective() {
            return this.objective;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$UpdateObjective.class */
    public static final class UpdateObjective extends ObjectiveManagerTask {
        private final ScoreboardObjectiveImpl objective;

        public UpdateObjective(@NotNull ScoreboardObjectiveImpl scoreboardObjectiveImpl) {
            super();
            this.objective = scoreboardObjectiveImpl;
        }

        @NotNull
        public ScoreboardObjectiveImpl objective() {
            return this.objective;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveManagerTask$UpdateScore.class */
    public static final class UpdateScore extends ObjectiveManagerTask {
        private final ScoreboardObjectiveImpl objective;
        private final String entry;
        private final ObjectiveScore score;

        public UpdateScore(@NotNull ScoreboardObjectiveImpl scoreboardObjectiveImpl, @NotNull String str, @Nullable ObjectiveScore objectiveScore) {
            super();
            this.objective = scoreboardObjectiveImpl;
            this.entry = str;
            this.score = objectiveScore;
        }

        @NotNull
        public ScoreboardObjectiveImpl objective() {
            return this.objective;
        }

        @NotNull
        public String entry() {
            return this.entry;
        }

        @Nullable
        public ObjectiveScore score() {
            return this.score;
        }
    }

    private ObjectiveManagerTask() {
    }
}

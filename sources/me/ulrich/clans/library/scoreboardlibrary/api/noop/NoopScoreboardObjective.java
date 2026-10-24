package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import java.util.HashMap;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveScore;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopScoreboardObjective.class */
public class NoopScoreboardObjective implements ScoreboardObjective {
    private final Map<String, ObjectiveScore> scores = new HashMap();
    private Component value = Component.empty();
    private ObjectiveRenderType renderType;
    private ScoreFormat defaultScoreFormat;

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public Component value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective value(@NotNull ComponentLike componentLike) {
        this.value = componentLike.asComponent();
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ObjectiveRenderType renderType() {
        return this.renderType;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective renderType(@NotNull ObjectiveRenderType objectiveRenderType) {
        this.renderType = objectiveRenderType;
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @Nullable
    public ScoreFormat defaultScoreFormat() {
        return this.defaultScoreFormat;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    public void defaultScoreFormat(@Nullable ScoreFormat scoreFormat) {
        this.defaultScoreFormat = scoreFormat;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    public void refreshProperties() {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @Nullable
    public ObjectiveScore scoreInfo(@NotNull String str) {
        return this.scores.get(str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective score(@NotNull String str, ObjectiveScore objectiveScore) {
        this.scores.put(str, objectiveScore);
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective removeScore(@NotNull String str) {
        this.scores.remove(str);
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    public void refreshScore(@NotNull String str) {
    }
}

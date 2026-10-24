package me.ulrich.clans.library.scoreboardlibrary.api.objective;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ScoreboardObjective.class */
public interface ScoreboardObjective {
    @NotNull
    Component value();

    @NotNull
    ScoreboardObjective value(@NotNull ComponentLike componentLike);

    @NotNull
    ObjectiveRenderType renderType();

    @NotNull
    ScoreboardObjective renderType(@NotNull ObjectiveRenderType objectiveRenderType);

    @Nullable
    ScoreFormat defaultScoreFormat();

    void defaultScoreFormat(@Nullable ScoreFormat scoreFormat);

    void refreshProperties();

    @Nullable
    ObjectiveScore scoreInfo(@NotNull String str);

    @Deprecated
    @Nullable
    default Integer score(@NotNull String str) {
        ObjectiveScore objectiveScoreScoreInfo = scoreInfo(str);
        if (objectiveScoreScoreInfo == null) {
            return null;
        }
        return Integer.valueOf(objectiveScoreScoreInfo.value());
    }

    @NotNull
    ScoreboardObjective score(@NotNull String str, ObjectiveScore objectiveScore);

    @NotNull
    default ScoreboardObjective score(@NotNull String str, int i) {
        return score(str, new ObjectiveScore(i, null, null));
    }

    @NotNull
    default ScoreboardObjective score(@NotNull String str, int i, @Nullable ComponentLike componentLike, @Nullable ScoreFormat scoreFormat) {
        return score(str, new ObjectiveScore(i, componentLike, scoreFormat));
    }

    @NotNull
    default ScoreboardObjective score(@NotNull String str, int i, @Nullable ComponentLike componentLike) {
        return score(str, new ObjectiveScore(i, componentLike, null));
    }

    @NotNull
    default ScoreboardObjective score(@NotNull String str, int i, @Nullable ScoreFormat scoreFormat) {
        return score(str, new ObjectiveScore(i, null, scoreFormat));
    }

    @NotNull
    ScoreboardObjective removeScore(@NotNull String str);

    void refreshScore(@NotNull String str);
}

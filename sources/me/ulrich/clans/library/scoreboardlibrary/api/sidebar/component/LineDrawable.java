package me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component;

import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/LineDrawable.class */
@ApiStatus.NonExtendable
public interface LineDrawable {
    default void drawLine(@NotNull ComponentLike componentLike) {
        drawLine(componentLike, null);
    }

    void drawLine(@NotNull ComponentLike componentLike, @Nullable ScoreFormat scoreFormat);
}

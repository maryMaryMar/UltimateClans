package me.ulrich.clans.library.kyori.adventure.text.flattener;

import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/FlattenerListener.class */
@FunctionalInterface
public interface FlattenerListener {
    default void pushStyle(@NotNull Style style) {
    }

    void component(@NotNull String str);

    default boolean shouldContinue() {
        return true;
    }

    default void popStyle(@NotNull Style style) {
    }
}

package me.ulrich.clans.library.kyori.adventure.key;

import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/KeyedValue.class */
public interface KeyedValue<T> extends Keyed {
    @NotNull
    static <T> KeyedValue<T> keyedValue(@NotNull Key key, @NotNull T t) {
        return new KeyedValueImpl(key, Objects.requireNonNull(t, "value"));
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static <T> KeyedValue<T> of(@NotNull Key key, @NotNull T t) {
        return new KeyedValueImpl(key, Objects.requireNonNull(t, "value"));
    }

    @NotNull
    T value();
}

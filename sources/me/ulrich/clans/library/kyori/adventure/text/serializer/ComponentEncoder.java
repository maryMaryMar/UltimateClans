package me.ulrich.clans.library.kyori.adventure.text.serializer;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/ComponentEncoder.class */
public interface ComponentEncoder<I extends Component, R> {
    @NotNull
    R serialize(@NotNull I i);

    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Nullable
    default R serializeOrNull(@Nullable I i) {
        return serializeOr(i, null);
    }

    @Contract(value = "!null, _ -> !null; null, _ -> param2", pure = true)
    @Nullable
    default R serializeOr(@Nullable I i, @Nullable R r) {
        return i == null ? r : serialize(i);
    }
}

package me.ulrich.clans.library.kyori.adventure.text.serializer;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/ComponentSerializer.class */
public interface ComponentSerializer<I extends Component, O extends Component, R> extends ComponentDecoder<R, O>, ComponentEncoder<I, R> {
    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    O deserialize(@NotNull R r);

    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Deprecated
    @Nullable
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default O deseializeOrNull(@Nullable R r) {
        return (O) super.deserializeOrNull(r);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Nullable
    default O deserializeOrNull(@Nullable R r) {
        return (O) super.deserializeOr(r, null);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @Contract(value = "!null, _ -> !null; null, _ -> param2", pure = true)
    @Nullable
    default O deserializeOr(@Nullable R r, @Nullable O o) {
        return (O) super.deserializeOr(r, o);
    }

    @NotNull
    R serialize(@NotNull I i);

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Nullable
    default R serializeOrNull(@Nullable I i) {
        return serializeOr(i, null);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @Contract(value = "!null, _ -> !null; null, _ -> param2", pure = true)
    @Nullable
    default R serializeOr(@Nullable I i, @Nullable R r) {
        return i == null ? r : serialize(i);
    }
}

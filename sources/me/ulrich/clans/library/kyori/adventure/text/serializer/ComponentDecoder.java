package me.ulrich.clans.library.kyori.adventure.text.serializer;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/ComponentDecoder.class */
public interface ComponentDecoder<S, O extends Component> {
    @NotNull
    O deserialize(@NotNull S s);

    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Nullable
    default O deserializeOrNull(@Nullable S s) {
        return (O) deserializeOr(s, null);
    }

    @Contract(value = "!null, _ -> !null; null, _ -> param2", pure = true)
    @Nullable
    default O deserializeOr(@Nullable S s, @Nullable O o) {
        return s == null ? o : (O) deserialize(s);
    }
}

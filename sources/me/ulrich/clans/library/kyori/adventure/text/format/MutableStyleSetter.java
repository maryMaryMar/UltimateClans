package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/MutableStyleSetter.class */
@ApiStatus.NonExtendable
public interface MutableStyleSetter<T extends MutableStyleSetter<?>> extends StyleSetter<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    default T decorate(@NotNull TextDecoration... textDecorationArr) {
        for (TextDecoration textDecoration : textDecorationArr) {
            decorate(textDecoration);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    default T decorations(@NotNull Map<TextDecoration, TextDecoration.State> map) {
        Objects.requireNonNull(map, "decorations");
        for (Map.Entry<TextDecoration, TextDecoration.State> entry : map.entrySet()) {
            decoration(entry.getKey(), entry.getValue());
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_, _ -> this")
    @NotNull
    default T decorations(@NotNull Set<TextDecoration> set, boolean z) {
        TextDecoration.State stateByBoolean = TextDecoration.State.byBoolean(z);
        set.forEach(textDecoration -> {
            decoration(textDecoration, stateByBoolean);
        });
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_, _ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Set set, boolean z) {
        return decorations((Set<TextDecoration>) set, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }
}

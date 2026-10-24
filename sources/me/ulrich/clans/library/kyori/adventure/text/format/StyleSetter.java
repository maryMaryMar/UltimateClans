package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter;
import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/StyleSetter.class */
@ApiStatus.NonExtendable
public interface StyleSetter<T extends StyleSetter<?>> {
    @NotNull
    T font(@Nullable Key key);

    @NotNull
    T color(@Nullable TextColor textColor);

    @NotNull
    T colorIfAbsent(@Nullable TextColor textColor);

    @NotNull
    T shadowColor(@Nullable ARGBLike aRGBLike);

    @NotNull
    T shadowColorIfAbsent(@Nullable ARGBLike aRGBLike);

    @NotNull
    default T decorate(@NotNull TextDecoration textDecoration) {
        return (T) decoration(textDecoration, TextDecoration.State.TRUE);
    }

    @NotNull
    default T decorate(@NotNull TextDecoration... textDecorationArr) {
        EnumMap enumMap = new EnumMap(TextDecoration.class);
        for (TextDecoration textDecoration : textDecorationArr) {
            enumMap.put(textDecoration, TextDecoration.State.TRUE);
        }
        return (T) decorations(enumMap);
    }

    @NotNull
    default T decoration(@NotNull TextDecoration textDecoration, boolean z) {
        return (T) decoration(textDecoration, TextDecoration.State.byBoolean(z));
    }

    @NotNull
    T decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state);

    @NotNull
    T decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state);

    @NotNull
    T decorations(@NotNull Map<TextDecoration, TextDecoration.State> map);

    @NotNull
    default T decorations(@NotNull Set<TextDecoration> set, boolean z) {
        return (T) decorations((Map) set.stream().collect(Collectors.toMap(Function.identity(), textDecoration -> {
            return TextDecoration.State.byBoolean(z);
        })));
    }

    @NotNull
    T clickEvent(@Nullable ClickEvent clickEvent);

    @NotNull
    T hoverEvent(@Nullable HoverEventSource<?> hoverEventSource);

    @NotNull
    T insertion(@Nullable String str);
}

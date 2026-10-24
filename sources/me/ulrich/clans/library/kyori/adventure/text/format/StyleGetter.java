package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.EnumMap;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/StyleGetter.class */
@ApiStatus.NonExtendable
public interface StyleGetter {
    @Nullable
    Key font();

    @Nullable
    TextColor color();

    @Nullable
    ShadowColor shadowColor();

    default boolean hasDecoration(@NotNull TextDecoration textDecoration) {
        return decoration(textDecoration) == TextDecoration.State.TRUE;
    }

    TextDecoration.State decoration(@NotNull TextDecoration textDecoration);

    @NotNull
    default Map<TextDecoration, TextDecoration.State> decorations() {
        EnumMap enumMap = new EnumMap(TextDecoration.class);
        int length = DecorationMap.DECORATIONS.length;
        for (int i = 0; i < length; i++) {
            TextDecoration textDecoration = DecorationMap.DECORATIONS[i];
            enumMap.put(textDecoration, decoration(textDecoration));
        }
        return enumMap;
    }

    @Nullable
    ClickEvent clickEvent();

    @Nullable
    HoverEvent<?> hoverEvent();

    @Nullable
    String insertion();
}

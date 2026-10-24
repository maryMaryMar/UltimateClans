package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.HashMap;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/ColorTagResolver.class */
final class ColorTagResolver implements SerializableResolver.Single, TagResolver {
    private static final String COLOR_3 = "c";
    private static final String COLOR_2 = "colour";
    private static final String COLOR = "color";
    static final TagResolver INSTANCE = new ColorTagResolver();
    private static final StyleClaim<TextColor> STYLE = StyleClaim.claim("color", (v0) -> {
        return v0.color();
    }, (textColor, tokenEmitter) -> {
        if (textColor instanceof NamedTextColor) {
            tokenEmitter.tag(NamedTextColor.NAMES.key((NamedTextColor) textColor));
        } else {
            tokenEmitter.tag(textColor.asHexString());
        }
    });
    private static final Map<String, TextColor> COLOR_ALIASES = new HashMap();

    private static boolean isColorOrAbbreviation(String str) {
        return str.equals("color") || str.equals(COLOR_2) || str.equals(COLOR_3);
    }

    ColorTagResolver() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    @Nullable
    public Tag resolve(@NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
        if (has(str)) {
            return Tag.styling(resolveColor(isColorOrAbbreviation(str) ? argumentQueue.popOr("Expected to find a color parameter: <name>|#RRGGBB").lowerValue() : str, context));
        }
        return null;
    }

    @Nullable
    static TextColor resolveColorOrNull(String str) {
        TextColor textColorFromHexString;
        if (COLOR_ALIASES.containsKey(str)) {
            textColorFromHexString = COLOR_ALIASES.get(str);
        } else {
            textColorFromHexString = str.charAt(0) == '#' ? TextColor.fromHexString(str) : NamedTextColor.NAMES.value(str);
        }
        return textColorFromHexString;
    }

    @NotNull
    static TextColor resolveColor(@NotNull String str, @NotNull Context context) {
        TextColor textColorResolveColorOrNull = resolveColorOrNull(str);
        if (textColorResolveColorOrNull == null) {
            throw context.newException(String.format("Unable to parse a color from '%s'. Please use named colours or hex (#RRGGBB) colors.", str));
        }
        return textColorResolveColorOrNull;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return isColorOrAbbreviation(str) || NamedTextColor.NAMES.value(str) != null || COLOR_ALIASES.containsKey(str) || TextColor.fromHexString(str) != null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver.Single
    @Nullable
    public StyleClaim<?> claimStyle() {
        return STYLE;
    }

    static {
        COLOR_ALIASES.put("dark_grey", NamedTextColor.DARK_GRAY);
        COLOR_ALIASES.put("grey", NamedTextColor.GRAY);
    }
}

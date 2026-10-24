package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.ShadowColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/ShadowColorTag.class */
final class ShadowColorTag {
    private static final float DEFAULT_ALPHA = 0.25f;
    private static final String SHADOW_COLOR = "shadow";
    private static final String SHADOW_NONE = "!shadow";
    static final TagResolver RESOLVER = TagResolver.resolver(SerializableResolver.claimingStyle(SHADOW_COLOR, (BiFunction<ArgumentQueue, Context, Tag>) ShadowColorTag::create, (StyleClaim<?>) StyleClaim.claim(SHADOW_COLOR, (v0) -> {
        return v0.shadowColor();
    }, ShadowColorTag::emit)), TagResolver.resolver(SHADOW_NONE, Tag.styling(ShadowColor.none())));

    static Tag create(@NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
        ShadowColor shadowColor;
        String strLowerValue = argumentQueue.popOr("Expected to find a color parameter: #RRGGBBAA").lowerValue();
        if (strLowerValue.startsWith(TextColor.HEX_PREFIX) && strLowerValue.length() == 9) {
            shadowColor = ShadowColor.fromHexString(strLowerValue);
            if (shadowColor == null) {
                throw context.newException(String.format("Unable to parse a shadow color from '%s'. Please use #RRGGBBAA formatting.", strLowerValue));
            }
        } else {
            shadowColor = ShadowColor.shadowColor(ColorTagResolver.resolveColor(strLowerValue, context), (int) ((argumentQueue.hasNext() ? (float) argumentQueue.pop().asDouble().orElseThrow(() -> {
                return context.newException("Number was expected to be a double");
            }) : DEFAULT_ALPHA) * 255.0f));
        }
        return Tag.styling(shadowColor);
    }

    static void emit(@NotNull ShadowColor shadowColor, @NotNull TokenEmitter tokenEmitter) {
        if (ShadowColor.none().equals(shadowColor)) {
            tokenEmitter.tag(SHADOW_NONE);
            return;
        }
        tokenEmitter.tag(SHADOW_COLOR);
        NamedTextColor namedTextColorNamedColor = NamedTextColor.namedColor(TextColor.color(shadowColor).value());
        if (namedTextColorNamedColor != null) {
            tokenEmitter.argument(NamedTextColor.NAMES.key(namedTextColorNamedColor)).argument(Float.toString(shadowColor.alpha() / 255.0f));
        } else {
            tokenEmitter.argument(shadowColor.asHexString());
        }
    }

    private ShadowColorTag() {
    }
}

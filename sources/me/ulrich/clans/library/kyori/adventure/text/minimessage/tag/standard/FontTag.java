package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.key.InvalidKeyException;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/FontTag.class */
final class FontTag {
    static final String FONT = "font";
    static final TagResolver RESOLVER = SerializableResolver.claimingStyle("font", (BiFunction<ArgumentQueue, Context, Tag>) FontTag::create, (StyleClaim<?>) StyleClaim.claim("font", (v0) -> {
        return v0.font();
    }, FontTag::emit));

    private FontTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        String strValue = argumentQueue.popOr("A font tag must have either arguments of either <value> or <namespace:value>").value();
        try {
            Key key = !argumentQueue.hasNext() ? Key.key(strValue) : Key.key(strValue, argumentQueue.pop().value());
            return Tag.styling((Consumer<Style.Builder>) builder -> {
                builder.font(key);
            });
        } catch (InvalidKeyException e) {
            throw context.newException(e.getMessage(), argumentQueue);
        }
    }

    static void emit(Key key, TokenEmitter tokenEmitter) {
        tokenEmitter.tag("font");
        if (key.namespace().equals(Key.MINECRAFT_NAMESPACE)) {
            tokenEmitter.argument(key.value());
        } else {
            tokenEmitter.arguments(key.namespace(), key.value());
        }
    }
}

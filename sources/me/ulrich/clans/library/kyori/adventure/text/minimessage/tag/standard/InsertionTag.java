package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/InsertionTag.class */
final class InsertionTag {
    private static final String INSERTION = "insert";
    static final TagResolver RESOLVER = SerializableResolver.claimingStyle(INSERTION, (BiFunction<ArgumentQueue, Context, Tag>) InsertionTag::create, (StyleClaim<?>) StyleClaim.claim(INSERTION, (v0) -> {
        return v0.insertion();
    }, InsertionTag::emit));

    private InsertionTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        String strValue = argumentQueue.popOr("A value is required to produce an insertion component").value();
        return Tag.styling((Consumer<Style.Builder>) builder -> {
            builder.insertion(strValue);
        });
    }

    static void emit(String str, TokenEmitter tokenEmitter) {
        tokenEmitter.tag(INSERTION).argument(str);
    }
}

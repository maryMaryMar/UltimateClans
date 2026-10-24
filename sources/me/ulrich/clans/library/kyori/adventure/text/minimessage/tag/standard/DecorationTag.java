package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/DecorationTag.class */
final class DecorationTag {
    public static final String REVERT = "!";
    private static final String OBF = "obf";
    private static final String B = "b";
    private static final String ST = "st";
    private static final String U = "u";
    private static final String EM = "em";
    private static final String I = "i";
    static final Map<TextDecoration, TagResolver> RESOLVERS = (Map) Stream.of((Object[]) new Map.Entry[]{resolvers(TextDecoration.OBFUSCATED, OBF, new String[0]), resolvers(TextDecoration.BOLD, B, new String[0]), resolvers(TextDecoration.STRIKETHROUGH, ST, new String[0]), resolvers(TextDecoration.UNDERLINED, U, new String[0]), resolvers(TextDecoration.ITALIC, EM, I)}).collect(Collectors.toMap((v0) -> {
        return v0.getKey();
    }, entry -> {
        return (TagResolver) ((Stream) entry.getValue()).collect(TagResolver.toTagResolver());
    }, (tagResolver, tagResolver2) -> {
        return TagResolver.builder().resolver(tagResolver).resolver(tagResolver2).build();
    }, LinkedHashMap::new));
    static final TagResolver RESOLVER = TagResolver.resolver(RESOLVERS.values());

    static Map.Entry<TextDecoration, Stream<TagResolver>> resolvers(TextDecoration textDecoration, @Nullable String str, @NotNull String... strArr) {
        String strKey = TextDecoration.NAMES.key(textDecoration);
        HashSet hashSet = new HashSet();
        hashSet.add(strKey);
        if (str != null) {
            hashSet.add(str);
        }
        Collections.addAll(hashSet, strArr);
        return new AbstractMap.SimpleImmutableEntry(textDecoration, Stream.concat(Stream.of(SerializableResolver.claimingStyle(hashSet, (BiFunction<ArgumentQueue, Context, Tag>) (argumentQueue, context) -> {
            return create(textDecoration, argumentQueue, context);
        }, claim(textDecoration, (state, tokenEmitter) -> {
            emit(strKey, str == null ? strKey : str, state, tokenEmitter);
        }))), hashSet.stream().map(str2 -> {
            return TagResolver.resolver(REVERT + str2, createNegated(textDecoration));
        })));
    }

    private DecorationTag() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Tag create(TextDecoration textDecoration, ArgumentQueue argumentQueue, Context context) {
        return Tag.styling(textDecoration.withState((argumentQueue.hasNext() && argumentQueue.pop().isFalse()) ? false : true));
    }

    static Tag createNegated(TextDecoration textDecoration) {
        return Tag.styling(textDecoration.withState(false));
    }

    @NotNull
    static StyleClaim<TextDecoration.State> claim(@NotNull TextDecoration textDecoration, @NotNull BiConsumer<TextDecoration.State, TokenEmitter> biConsumer) {
        Objects.requireNonNull(textDecoration, "decoration");
        return StyleClaim.claim("decoration_" + TextDecoration.NAMES.key(textDecoration), style -> {
            return style.decoration(textDecoration);
        }, state -> {
            return state != TextDecoration.State.NOT_SET;
        }, biConsumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void emit(@NotNull String str, @NotNull String str2, TextDecoration.State state, @NotNull TokenEmitter tokenEmitter) {
        if (state == TextDecoration.State.FALSE) {
            tokenEmitter.tag(REVERT + str);
        } else {
            tokenEmitter.tag(str);
        }
    }
}

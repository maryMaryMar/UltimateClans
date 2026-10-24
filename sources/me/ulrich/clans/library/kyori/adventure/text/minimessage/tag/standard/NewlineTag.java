package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/NewlineTag.class */
final class NewlineTag {
    private static final String NEWLINE = "newline";
    private static final String BR = "br";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(StandardTags.names(NEWLINE, BR), (BiFunction<ArgumentQueue, Context, Tag>) NewlineTag::create, (Function<Component, Emitable>) NewlineTag::claimComponent);

    private NewlineTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        return Tag.selfClosingInserting((Component) Component.newline());
    }

    @Nullable
    static Emitable claimComponent(Component component) {
        if (Component.newline().equals(component)) {
            return tokenEmitter -> {
                tokenEmitter.selfClosingTag(BR);
            };
        }
        return null;
    }
}

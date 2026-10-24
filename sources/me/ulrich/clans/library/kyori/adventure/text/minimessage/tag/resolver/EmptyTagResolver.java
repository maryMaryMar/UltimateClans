package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/EmptyTagResolver.class */
final class EmptyTagResolver implements SerializableResolver, MappableResolver, TagResolver {
    static final EmptyTagResolver INSTANCE = new EmptyTagResolver();

    private EmptyTagResolver() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    @Nullable
    public Tag resolve(@NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.MappableResolver
    public boolean contributeToMap(@NotNull Map<String, Tag> map) {
        return true;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver
    public void handle(@NotNull Component component, @NotNull ClaimConsumer claimConsumer) {
    }
}

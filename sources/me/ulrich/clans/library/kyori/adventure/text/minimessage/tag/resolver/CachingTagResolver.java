package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/CachingTagResolver.class */
final class CachingTagResolver implements SerializableResolver, MappableResolver, TagResolver.WithoutArguments {
    private static final Tag NULL_REPLACEMENT = () -> {
        throw new UnsupportedOperationException("no-op null tag");
    };
    private final Map<String, Tag> cache = new HashMap();
    private final TagResolver.WithoutArguments resolver;

    CachingTagResolver(TagResolver.WithoutArguments withoutArguments) {
        this.resolver = withoutArguments;
    }

    private Tag query(@NotNull String str) {
        return this.cache.computeIfAbsent(str, str2 -> {
            Tag tagResolve = this.resolver.resolve(str2);
            return tagResolve == null ? NULL_REPLACEMENT : tagResolve;
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments
    @Nullable
    public Tag resolve(@NotNull String str) {
        Tag tagQuery = query(str);
        if (tagQuery == NULL_REPLACEMENT) {
            return null;
        }
        return tagQuery;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return query(str) != NULL_REPLACEMENT;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.MappableResolver
    public boolean contributeToMap(@NotNull Map<String, Tag> map) {
        if (this.resolver instanceof MappableResolver) {
            return ((MappableResolver) this.resolver).contributeToMap(map);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver
    public void handle(@NotNull Component component, @NotNull ClaimConsumer claimConsumer) {
        if (this.resolver instanceof SerializableResolver) {
            ((SerializableResolver) this.resolver).handle(component, claimConsumer);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachingTagResolver) {
            return Objects.equals(this.resolver, ((CachingTagResolver) obj).resolver);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.resolver);
    }
}

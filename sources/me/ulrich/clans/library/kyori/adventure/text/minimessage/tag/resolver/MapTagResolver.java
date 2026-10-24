package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Map;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/MapTagResolver.class */
final class MapTagResolver implements MappableResolver, TagResolver.WithoutArguments {
    private final Map<String, ? extends Tag> tagMap;

    MapTagResolver(@NotNull Map<String, ? extends Tag> map) {
        this.tagMap = map;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments
    @Nullable
    public Tag resolve(@NotNull String str) {
        return this.tagMap.get(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return this.tagMap.containsKey(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.MappableResolver
    public boolean contributeToMap(@NotNull Map<String, Tag> map) {
        map.putAll(this.tagMap);
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapTagResolver) {
            return Objects.equals(this.tagMap, ((MapTagResolver) obj).tagMap);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.tagMap);
    }
}

package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Map;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/SingleResolver.class */
final class SingleResolver implements MappableResolver, TagResolver.Single {
    private final String key;
    private final Tag tag;

    SingleResolver(String str, Tag tag) {
        this.key = str;
        this.tag = tag;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Single
    @NotNull
    public String key() {
        return this.key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Single
    @NotNull
    public Tag tag() {
        return this.tag;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Single, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return this.key.equals(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.MappableResolver
    public boolean contributeToMap(@NotNull Map<String, Tag> map) {
        map.put(this.key, this.tag);
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.key, this.tag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SingleResolver singleResolver = (SingleResolver) obj;
        return Objects.equals(this.key, singleResolver.key) && Objects.equals(this.tag, singleResolver.tag);
    }
}

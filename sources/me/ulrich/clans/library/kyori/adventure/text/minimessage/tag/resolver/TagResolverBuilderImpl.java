package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/TagResolverBuilderImpl.class */
final class TagResolverBuilderImpl implements TagResolver.Builder {
    static final Collector<TagResolver, TagResolver.Builder, TagResolver> COLLECTOR = Collector.of(TagResolver::builder, (v0, v1) -> {
        v0.resolver(v1);
    }, (builder, builder2) -> {
        return TagResolver.builder().resolvers(builder.build(), builder2.build());
    }, (v0) -> {
        return v0.build();
    }, new Collector.Characteristics[0]);
    private final Map<String, Tag> replacements = new HashMap();
    private final List<TagResolver> resolvers = new ArrayList();

    TagResolverBuilderImpl() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Builder
    public TagResolver.Builder tag(@NotNull String str, @NotNull Tag tag) {
        TagInternals.assertValidTagName((String) Objects.requireNonNull(str, "name"));
        this.replacements.put(str, (Tag) Objects.requireNonNull(tag, "tag"));
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Builder
    public TagResolver.Builder resolver(@NotNull TagResolver tagResolver) {
        if (tagResolver instanceof SequentialTagResolver) {
            resolvers(((SequentialTagResolver) tagResolver).resolvers, false);
        } else if (!consumePotentialMappable(tagResolver)) {
            popMap();
            this.resolvers.add((TagResolver) Objects.requireNonNull(tagResolver, "resolver"));
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Builder
    public TagResolver.Builder resolvers(@NotNull TagResolver... tagResolverArr) {
        return resolvers(tagResolverArr, true);
    }

    private TagResolver.Builder resolvers(@NotNull TagResolver[] tagResolverArr, boolean z) {
        boolean zSingle = false;
        Objects.requireNonNull(tagResolverArr, "resolvers");
        if (z) {
            for (TagResolver tagResolver : tagResolverArr) {
                zSingle = single(tagResolver, zSingle);
            }
        } else {
            for (int length = tagResolverArr.length - 1; length >= 0; length--) {
                zSingle = single(tagResolverArr[length], zSingle);
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Builder
    public TagResolver.Builder resolvers(@NotNull Iterable<? extends TagResolver> iterable) {
        boolean zSingle = false;
        Iterator it = ((Iterable) Objects.requireNonNull(iterable, "resolvers")).iterator();
        while (it.hasNext()) {
            zSingle = single((TagResolver) it.next(), zSingle);
        }
        return this;
    }

    private boolean single(TagResolver tagResolver, boolean z) {
        if (tagResolver instanceof SequentialTagResolver) {
            resolvers(((SequentialTagResolver) tagResolver).resolvers, false);
            return false;
        }
        if (consumePotentialMappable(tagResolver)) {
            return false;
        }
        if (!z) {
            popMap();
        }
        this.resolvers.add((TagResolver) Objects.requireNonNull(tagResolver, "resolvers[?]"));
        return true;
    }

    private void popMap() {
        if (this.replacements.isEmpty()) {
            return;
        }
        this.resolvers.add(new MapTagResolver(new HashMap(this.replacements)));
        this.replacements.clear();
    }

    private boolean consumePotentialMappable(TagResolver tagResolver) {
        if (tagResolver instanceof MappableResolver) {
            return ((MappableResolver) tagResolver).contributeToMap(this.replacements);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Builder
    @NotNull
    public TagResolver build() {
        popMap();
        if (this.resolvers.size() == 0) {
            return EmptyTagResolver.INSTANCE;
        }
        if (this.resolvers.size() == 1) {
            return this.resolvers.get(0);
        }
        TagResolver[] tagResolverArr = (TagResolver[]) this.resolvers.toArray(new TagResolver[0]);
        Collections.reverse(Arrays.asList(tagResolverArr));
        return new SequentialTagResolver(tagResolverArr);
    }
}

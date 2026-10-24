package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.TagPattern;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.StandardTags;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/TagResolver.class */
public interface TagResolver {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/TagResolver$Builder.class */
    public interface Builder {
        @NotNull
        Builder tag(@TagPattern @NotNull String str, @NotNull Tag tag);

        @NotNull
        default Builder tag(@TagPattern @NotNull String str, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction) {
            return tag(Collections.singleton(str), biFunction);
        }

        @NotNull
        default Builder tag(@NotNull Set<String> set, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction) {
            return resolver(TagResolver.resolver(set, biFunction));
        }

        @NotNull
        Builder resolver(@NotNull TagResolver tagResolver);

        @NotNull
        Builder resolvers(@NotNull TagResolver... tagResolverArr);

        @NotNull
        Builder resolvers(@NotNull Iterable<? extends TagResolver> iterable);

        @NotNull
        default Builder caching(WithoutArguments withoutArguments) {
            return resolver(TagResolver.caching(withoutArguments));
        }

        @NotNull
        TagResolver build();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/TagResolver$Single.class */
    @ApiStatus.NonExtendable
    public interface Single extends WithoutArguments {
        @NotNull
        String key();

        @NotNull
        Tag tag();

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments
        @Nullable
        default Tag resolve(@TagPattern @NotNull String str) {
            if (has(str)) {
                return tag();
            }
            return null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.WithoutArguments, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
        default boolean has(@NotNull String str) {
            return str.equalsIgnoreCase(key());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/TagResolver$WithoutArguments.class */
    @FunctionalInterface
    public interface WithoutArguments extends TagResolver {
        @Nullable
        Tag resolve(@TagPattern @NotNull String str);

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
        default boolean has(@NotNull String str) {
            return resolve(str) != null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
        @Nullable
        default Tag resolve(@TagPattern @NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
            Tag tagResolve = resolve(str);
            if (tagResolve == null || !argumentQueue.hasNext()) {
                return tagResolve;
            }
            throw context.newException("Tag '<" + str + ">' does not accept any arguments");
        }
    }

    @NotNull
    static Builder builder() {
        return new TagResolverBuilderImpl();
    }

    @NotNull
    static TagResolver standard() {
        return StandardTags.defaults();
    }

    @NotNull
    static TagResolver empty() {
        return EmptyTagResolver.INSTANCE;
    }

    static Single resolver(@TagPattern @NotNull String str, @NotNull Tag tag) {
        TagInternals.assertValidTagName(str);
        return new SingleResolver(str, (Tag) Objects.requireNonNull(tag, "tag"));
    }

    @NotNull
    static TagResolver resolver(@TagPattern @NotNull String str, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction) {
        return resolver((Set<String>) Collections.singleton(str), biFunction);
    }

    @NotNull
    static TagResolver resolver(@NotNull final Set<String> set, @NotNull final BiFunction<ArgumentQueue, Context, Tag> biFunction) {
        Iterator it = new HashSet(set).iterator();
        while (it.hasNext()) {
            TagInternals.assertValidTagName((String) it.next());
        }
        Objects.requireNonNull(biFunction, "handler");
        return new TagResolver() { // from class: me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver.1
            @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
            @Nullable
            public Tag resolve(@NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
                if (set.contains(str)) {
                    return (Tag) biFunction.apply(argumentQueue, context);
                }
                return null;
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
            public boolean has(@NotNull String str) {
                return set.contains(str);
            }
        };
    }

    @NotNull
    static TagResolver resolver(@NotNull TagResolver... tagResolverArr) {
        return ((TagResolver[]) Objects.requireNonNull(tagResolverArr, "resolvers")).length == 1 ? (TagResolver) Objects.requireNonNull(tagResolverArr[0], "resolvers must not contain null elements") : builder().resolvers(tagResolverArr).build();
    }

    @NotNull
    static TagResolver resolver(@NotNull Iterable<? extends TagResolver> iterable) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (size == 0) {
                return empty();
            }
            if (size == 1) {
                return (TagResolver) Objects.requireNonNull(iterable.iterator().next(), "resolvers must not contain null elements");
            }
        }
        return builder().resolvers(iterable).build();
    }

    @NotNull
    static TagResolver caching(WithoutArguments withoutArguments) {
        return withoutArguments instanceof CachingTagResolver ? withoutArguments : new CachingTagResolver((WithoutArguments) Objects.requireNonNull(withoutArguments, "resolver"));
    }

    @NotNull
    static Collector<TagResolver, ?, TagResolver> toTagResolver() {
        return TagResolverBuilderImpl.COLLECTOR;
    }

    @Nullable
    Tag resolve(@TagPattern @NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context);

    boolean has(@NotNull String str);
}

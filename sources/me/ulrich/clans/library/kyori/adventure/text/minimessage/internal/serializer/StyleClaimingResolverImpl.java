package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import java.util.Set;
import java.util.function.BiFunction;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/StyleClaimingResolverImpl.class */
final class StyleClaimingResolverImpl implements SerializableResolver.Single, TagResolver {

    @NotNull
    private final Set<String> names;

    @NotNull
    private final BiFunction<ArgumentQueue, Context, Tag> handler;

    @NotNull
    private final StyleClaim<?> styleClaim;

    StyleClaimingResolverImpl(@NotNull Set<String> set, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction, @NotNull StyleClaim<?> styleClaim) {
        this.names = set;
        this.handler = biFunction;
        this.styleClaim = styleClaim;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    @Nullable
    public Tag resolve(@NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
        if (this.names.contains(str)) {
            return this.handler.apply(argumentQueue, context);
        }
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return this.names.contains(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver.Single
    @Nullable
    public StyleClaim<?> claimStyle() {
        return this.styleClaim;
    }
}

package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/SerializableResolver.class */
public interface SerializableResolver {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/SerializableResolver$Single.class */
    public interface Single extends SerializableResolver {
        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver
        default void handle(@NotNull Component component, @NotNull ClaimConsumer claimConsumer) {
            Emitable emitableClaimComponent;
            Emitable emitableApply;
            StyleClaim<?> styleClaimClaimStyle = claimStyle();
            if (styleClaimClaimStyle != null && !claimConsumer.styleClaimed(styleClaimClaimStyle.claimKey()) && (emitableApply = styleClaimClaimStyle.apply(component.style())) != null) {
                claimConsumer.style(styleClaimClaimStyle.claimKey(), emitableApply);
            }
            if (claimConsumer.componentClaimed() || (emitableClaimComponent = claimComponent(component)) == null) {
                return;
            }
            claimConsumer.component(emitableClaimComponent);
        }

        @Nullable
        default StyleClaim<?> claimStyle() {
            return null;
        }

        @Nullable
        default Emitable claimComponent(@NotNull Component component) {
            return null;
        }
    }

    @NotNull
    static TagResolver claimingComponent(@NotNull String str, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction, @NotNull Function<Component, Emitable> function) {
        return claimingComponent((Set<String>) Collections.singleton(str), biFunction, function);
    }

    @NotNull
    static TagResolver claimingComponent(@NotNull Set<String> set, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction, @NotNull Function<Component, Emitable> function) {
        HashSet hashSet = new HashSet(set);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            TagInternals.assertValidTagName((String) it.next());
        }
        Objects.requireNonNull(biFunction, "handler");
        return new ComponentClaimingResolverImpl(hashSet, biFunction, function);
    }

    @NotNull
    static TagResolver claimingStyle(@NotNull String str, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction, @NotNull StyleClaim<?> styleClaim) {
        return claimingStyle((Set<String>) Collections.singleton(str), biFunction, styleClaim);
    }

    @NotNull
    static TagResolver claimingStyle(@NotNull Set<String> set, @NotNull BiFunction<ArgumentQueue, Context, Tag> biFunction, @NotNull StyleClaim<?> styleClaim) {
        HashSet hashSet = new HashSet(set);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            TagInternals.assertValidTagName((String) it.next());
        }
        Objects.requireNonNull(biFunction, "handler");
        return new StyleClaimingResolverImpl(hashSet, biFunction, styleClaim);
    }

    void handle(@NotNull Component component, @NotNull ClaimConsumer claimConsumer);
}

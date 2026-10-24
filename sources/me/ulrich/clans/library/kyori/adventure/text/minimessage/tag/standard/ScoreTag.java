package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ScoreComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/ScoreTag.class */
final class ScoreTag {
    public static final String SCORE = "score";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent("score", (BiFunction<ArgumentQueue, Context, Tag>) ScoreTag::create, (Function<Component, Emitable>) ScoreTag::emit);

    private ScoreTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        return Tag.inserting((Component) Component.score(argumentQueue.popOr("A scoreboard member name is required").value(), argumentQueue.popOr("An objective name is required").value()));
    }

    @Nullable
    static Emitable emit(Component component) {
        if (!(component instanceof ScoreComponent)) {
            return null;
        }
        ScoreComponent scoreComponent = (ScoreComponent) component;
        return tokenEmitter -> {
            tokenEmitter.tag("score").argument(scoreComponent.name()).argument(scoreComponent.objective());
        };
    }
}

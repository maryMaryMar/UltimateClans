package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.adventure.util.IntFunction2;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementConfig.class */
public interface TextReplacementConfig extends Buildable<TextReplacementConfig, Builder>, Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementConfig$Builder.class */
    public interface Builder extends AbstractBuilder<TextReplacementConfig>, Buildable.Builder<TextReplacementConfig> {
        @Contract("_ -> this")
        default Builder matchLiteral(String str) {
            return match(Pattern.compile(str, 16));
        }

        @Contract("_ -> this")
        @NotNull
        default Builder match(@RegExp @NotNull String str) {
            return match(Pattern.compile(str));
        }

        @Contract("_ -> this")
        @NotNull
        Builder match(@NotNull Pattern pattern);

        @NotNull
        default Builder once() {
            return times(1);
        }

        @Contract("_ -> this")
        @NotNull
        default Builder times(int i) {
            return condition((i2, i3) -> {
                return i3 < i ? PatternReplacementResult.REPLACE : PatternReplacementResult.STOP;
            });
        }

        @Contract("_ -> this")
        @NotNull
        default Builder condition(@NotNull IntFunction2<PatternReplacementResult> intFunction2) {
            return condition((matchResult, i, i2) -> {
                return (PatternReplacementResult) intFunction2.apply(i, i2);
            });
        }

        @Contract("_ -> this")
        @NotNull
        Builder condition(@NotNull Condition condition);

        @Contract("_ -> this")
        @NotNull
        default Builder replacement(@NotNull String str) {
            Objects.requireNonNull(str, "replacement");
            return replacement(builder -> {
                return builder.content(str);
            });
        }

        @Contract("_ -> this")
        @NotNull
        default Builder replacement(@Nullable ComponentLike componentLike) {
            Component componentUnbox = ComponentLike.unbox(componentLike);
            return replacement((matchResult, builder) -> {
                return componentUnbox;
            });
        }

        @Contract("_ -> this")
        @NotNull
        default Builder replacement(@NotNull Function<TextComponent.Builder, ComponentLike> function) {
            Objects.requireNonNull(function, "replacement");
            return replacement((matchResult, builder) -> {
                return (ComponentLike) function.apply(builder);
            });
        }

        @Contract("_ -> this")
        @NotNull
        Builder replacement(@NotNull BiFunction<MatchResult, TextComponent.Builder, ComponentLike> biFunction);

        @Contract("_ -> this")
        @NotNull
        Builder replaceInsideHoverEvents(boolean z);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementConfig$Condition.class */
    @FunctionalInterface
    public interface Condition {
        @NotNull
        PatternReplacementResult shouldReplace(@NotNull MatchResult matchResult, int i, int i2);
    }

    @NotNull
    static Builder builder() {
        return new TextReplacementConfigImpl.Builder();
    }

    @NotNull
    Pattern matchPattern();
}

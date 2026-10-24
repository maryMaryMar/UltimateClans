package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementConfigImpl.class */
final class TextReplacementConfigImpl implements TextReplacementConfig {
    private final Pattern matchPattern;
    private final BiFunction<MatchResult, TextComponent.Builder, ComponentLike> replacement;
    private final TextReplacementConfig.Condition continuer;
    private final boolean replaceInsideHoverEvents;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementConfigImpl$Builder.class */
    static final class Builder implements TextReplacementConfig.Builder {

        @Nullable
        Pattern matchPattern;

        @Nullable
        BiFunction<MatchResult, TextComponent.Builder, ComponentLike> replacement;
        TextReplacementConfig.Condition continuer;
        boolean replaceInsideHoverEvents;

        Builder() {
            this.continuer = (matchResult, i, i2) -> {
                return PatternReplacementResult.REPLACE;
            };
            this.replaceInsideHoverEvents = true;
        }

        Builder(TextReplacementConfigImpl textReplacementConfigImpl) {
            this.continuer = (matchResult, i, i2) -> {
                return PatternReplacementResult.REPLACE;
            };
            this.replaceInsideHoverEvents = true;
            this.matchPattern = textReplacementConfigImpl.matchPattern;
            this.replacement = textReplacementConfigImpl.replacement;
            this.continuer = textReplacementConfigImpl.continuer;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig.Builder
        @NotNull
        public Builder match(@NotNull Pattern pattern) {
            this.matchPattern = (Pattern) Objects.requireNonNull(pattern, "pattern");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig.Builder
        @NotNull
        public Builder condition(TextReplacementConfig.Condition condition) {
            this.continuer = (TextReplacementConfig.Condition) Objects.requireNonNull(condition, "continuation");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig.Builder
        @NotNull
        public Builder replacement(@NotNull BiFunction<MatchResult, TextComponent.Builder, ComponentLike> biFunction) {
            this.replacement = (BiFunction) Objects.requireNonNull(biFunction, "replacement");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig.Builder
        public TextReplacementConfig.Builder replaceInsideHoverEvents(boolean z) {
            this.replaceInsideHoverEvents = z;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public TextReplacementConfig build2() {
            if (this.matchPattern == null) {
                throw new IllegalStateException("A pattern must be provided to match against");
            }
            if (this.replacement == null) {
                throw new IllegalStateException("A replacement action must be provided");
            }
            return new TextReplacementConfigImpl(this);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig.Builder
        @NotNull
        public /* bridge */ /* synthetic */ TextReplacementConfig.Builder replacement(@NotNull BiFunction biFunction) {
            return replacement((BiFunction<MatchResult, TextComponent.Builder, ComponentLike>) biFunction);
        }
    }

    TextReplacementConfigImpl(Builder builder) {
        this.matchPattern = builder.matchPattern;
        this.replacement = builder.replacement;
        this.continuer = builder.continuer;
        this.replaceInsideHoverEvents = builder.replaceInsideHoverEvents;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig
    @NotNull
    public Pattern matchPattern() {
        return this.matchPattern;
    }

    TextReplacementRenderer.State createState() {
        return new TextReplacementRenderer.State(this.matchPattern, this.replacement, this.continuer, this.replaceInsideHoverEvents);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public TextReplacementConfig.Builder mo683toBuilder() {
        return new Builder(this);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("matchPattern", this.matchPattern), ExaminableProperty.of("replacement", this.replacement), ExaminableProperty.of("continuer", this.continuer)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}

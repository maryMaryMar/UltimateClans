package me.ulrich.clans.library.kyori.adventure.text.event;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallbackOptionsImpl.class */
final class ClickCallbackOptionsImpl implements ClickCallback.Options {
    static final ClickCallback.Options DEFAULT = new BuilderImpl().build2();
    private final int uses;
    private final Duration lifetime;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallbackOptionsImpl$BuilderImpl.class */
    static final class BuilderImpl implements ClickCallback.Options.Builder {
        private static final int DEFAULT_USES = 1;
        private int uses;
        private Duration lifetime;

        BuilderImpl() {
            this.uses = 1;
            this.lifetime = ClickCallback.DEFAULT_LIFETIME;
        }

        BuilderImpl(ClickCallback.Options options) {
            this.uses = options.uses();
            this.lifetime = options.lifetime();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        /* JADX INFO: renamed from: build */
        public ClickCallback.Options build2() {
            return new ClickCallbackOptionsImpl(this.uses, this.lifetime);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickCallback.Options.Builder
        @NotNull
        public ClickCallback.Options.Builder uses(int i) {
            this.uses = i;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickCallback.Options.Builder
        @NotNull
        public ClickCallback.Options.Builder lifetime(@NotNull TemporalAmount temporalAmount) {
            this.lifetime = temporalAmount instanceof Duration ? (Duration) temporalAmount : Duration.from((TemporalAmount) Objects.requireNonNull(temporalAmount, "lifetime"));
            return this;
        }
    }

    ClickCallbackOptionsImpl(int i, Duration duration) {
        this.uses = i;
        this.lifetime = duration;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickCallback.Options
    public int uses() {
        return this.uses;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickCallback.Options
    @NotNull
    public Duration lifetime() {
        return this.lifetime;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("uses", this.uses), ExaminableProperty.of("expiration", this.lifetime)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}

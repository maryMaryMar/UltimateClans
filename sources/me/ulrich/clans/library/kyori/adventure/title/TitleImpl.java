package me.ulrich.clans.library.kyori.adventure.title;

import java.time.Duration;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/title/TitleImpl.class */
final class TitleImpl implements Title {
    private final Component title;
    private final Component subtitle;

    @Nullable
    private final Title.Times times;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/title/TitleImpl$TimesImpl.class */
    static class TimesImpl implements Title.Times {
        private final Duration fadeIn;
        private final Duration stay;
        private final Duration fadeOut;

        TimesImpl(@NotNull Duration duration, @NotNull Duration duration2, @NotNull Duration duration3) {
            this.fadeIn = (Duration) Objects.requireNonNull(duration, "fadeIn");
            this.stay = (Duration) Objects.requireNonNull(duration2, "stay");
            this.fadeOut = (Duration) Objects.requireNonNull(duration3, "fadeOut");
        }

        @Override // me.ulrich.clans.library.kyori.adventure.title.Title.Times
        @NotNull
        public Duration fadeIn() {
            return this.fadeIn;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.title.Title.Times
        @NotNull
        public Duration stay() {
            return this.stay;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.title.Title.Times
        @NotNull
        public Duration fadeOut() {
            return this.fadeOut;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimesImpl)) {
                return false;
            }
            TimesImpl timesImpl = (TimesImpl) obj;
            return this.fadeIn.equals(timesImpl.fadeIn) && this.stay.equals(timesImpl.stay) && this.fadeOut.equals(timesImpl.fadeOut);
        }

        public int hashCode() {
            return (31 * ((31 * this.fadeIn.hashCode()) + this.stay.hashCode())) + this.fadeOut.hashCode();
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("fadeIn", this.fadeIn), ExaminableProperty.of("stay", this.stay), ExaminableProperty.of("fadeOut", this.fadeOut)});
        }

        public String toString() {
            return Internals.toString(this);
        }
    }

    TitleImpl(@NotNull Component component, @NotNull Component component2, @Nullable Title.Times times) {
        this.title = (Component) Objects.requireNonNull(component, "title");
        this.subtitle = (Component) Objects.requireNonNull(component2, "subtitle");
        this.times = times;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.title.Title
    @NotNull
    public Component title() {
        return this.title;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.title.Title
    @NotNull
    public Component subtitle() {
        return this.subtitle;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.title.Title
    @Nullable
    public Title.Times times() {
        return this.times;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.title.Title
    public <T> T part(@NotNull TitlePart<T> titlePart) {
        Objects.requireNonNull(titlePart, "part");
        if (titlePart == TitlePart.TITLE) {
            return (T) this.title;
        }
        if (titlePart == TitlePart.SUBTITLE) {
            return (T) this.subtitle;
        }
        if (titlePart == TitlePart.TIMES) {
            return (T) this.times;
        }
        throw new IllegalArgumentException("Don't know what " + titlePart + " is.");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TitleImpl titleImpl = (TitleImpl) obj;
        return this.title.equals(titleImpl.title) && this.subtitle.equals(titleImpl.subtitle) && Objects.equals(this.times, titleImpl.times);
    }

    public int hashCode() {
        return (31 * ((31 * this.title.hashCode()) + this.subtitle.hashCode())) + Objects.hashCode(this.times);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("title", this.title), ExaminableProperty.of("subtitle", this.subtitle), ExaminableProperty.of("times", this.times)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}

package me.ulrich.clans.library.kyori.adventure.title;

import java.time.Duration;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.util.Ticks;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/title/Title.class */
@ApiStatus.NonExtendable
public interface Title extends Examinable {
    public static final Times DEFAULT_TIMES = Times.times(Ticks.duration(10), Ticks.duration(70), Ticks.duration(20));

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/title/Title$Times.class */
    @ApiStatus.NonExtendable
    public interface Times extends Examinable {
        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        static Times of(@NotNull Duration duration, @NotNull Duration duration2, @NotNull Duration duration3) {
            return times(duration, duration2, duration3);
        }

        @NotNull
        static Times times(@NotNull Duration duration, @NotNull Duration duration2, @NotNull Duration duration3) {
            return new TitleImpl.TimesImpl(duration, duration2, duration3);
        }

        @NotNull
        Duration fadeIn();

        @NotNull
        Duration stay();

        @NotNull
        Duration fadeOut();
    }

    @NotNull
    static Title title(@NotNull Component component, @NotNull Component component2) {
        return title(component, component2, DEFAULT_TIMES);
    }

    @NotNull
    static Title title(@NotNull Component component, @NotNull Component component2, @Nullable Times times) {
        return new TitleImpl(component, component2, times);
    }

    @NotNull
    static Title title(@NotNull Component component, @NotNull Component component2, int i, int i2, int i3) {
        return new TitleImpl(component, component2, Times.times(Ticks.duration(i), Ticks.duration(i2), Ticks.duration(i3)));
    }

    @NotNull
    Component title();

    @NotNull
    Component subtitle();

    @Nullable
    Times times();

    <T> T part(@NotNull TitlePart<T> titlePart);
}

package me.ulrich.clans.library.kyori.adventure.text.event;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.function.Consumer;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.permission.PermissionChecker;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallback.class */
@FunctionalInterface
public interface ClickCallback<T extends Audience> {
    public static final Duration DEFAULT_LIFETIME = Duration.ofHours(12);
    public static final int UNLIMITED_USES = -1;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallback$Options.class */
    @ApiStatus.NonExtendable
    public interface Options extends Examinable {

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallback$Options$Builder.class */
        @ApiStatus.NonExtendable
        public interface Builder extends AbstractBuilder<Options> {
            @NotNull
            Builder uses(int i);

            @NotNull
            Builder lifetime(@NotNull TemporalAmount temporalAmount);
        }

        @NotNull
        static Builder builder() {
            return new ClickCallbackOptionsImpl.BuilderImpl();
        }

        @NotNull
        static Builder builder(@NotNull Options options) {
            return new ClickCallbackOptionsImpl.BuilderImpl(options);
        }

        int uses();

        @NotNull
        Duration lifetime();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallback$Provider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface Provider {
        @NotNull
        ClickEvent create(@NotNull ClickCallback<Audience> clickCallback, @NotNull Options options);
    }

    @CheckReturnValue
    @Contract(pure = true)
    @NotNull
    static <W extends Audience, N extends W> ClickCallback<W> widen(@NotNull ClickCallback<N> clickCallback, @NotNull Class<N> cls, @Nullable Consumer<? super Audience> consumer) {
        return audience -> {
            if (cls.isInstance(audience)) {
                clickCallback.accept((Audience) cls.cast(audience));
            } else if (consumer != null) {
                consumer.accept(audience);
            }
        };
    }

    @CheckReturnValue
    @Contract(pure = true)
    @NotNull
    static <W extends Audience, N extends W> ClickCallback<W> widen(@NotNull ClickCallback<N> clickCallback, @NotNull Class<N> cls) {
        return widen(clickCallback, cls, null);
    }

    void accept(@NotNull T t);

    @CheckReturnValue
    @Contract(pure = true)
    @NotNull
    default ClickCallback<T> filter(@NotNull Predicate<T> predicate) {
        return filter(predicate, null);
    }

    @CheckReturnValue
    @Contract(pure = true)
    @NotNull
    default ClickCallback<T> filter(@NotNull Predicate<T> predicate, @Nullable Consumer<? super Audience> consumer) {
        return audience -> {
            if (predicate.test(audience)) {
                accept(audience);
            } else if (consumer != null) {
                consumer.accept(audience);
            }
        };
    }

    @CheckReturnValue
    @Contract(pure = true)
    @NotNull
    default ClickCallback<T> requiringPermission(@NotNull String str) {
        return requiringPermission(str, null);
    }

    @CheckReturnValue
    @Contract(pure = true)
    @NotNull
    default ClickCallback<T> requiringPermission(@NotNull String str, @Nullable Consumer<? super Audience> consumer) {
        return filter(audience -> {
            return ((PermissionChecker) audience.getOrDefault(PermissionChecker.POINTER, ClickCallbackInternals.ALWAYS_FALSE)).test(str);
        }, consumer);
    }
}

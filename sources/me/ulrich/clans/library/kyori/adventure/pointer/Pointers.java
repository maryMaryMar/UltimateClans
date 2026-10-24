package me.ulrich.clans.library.kyori.adventure.pointer;

import java.util.Optional;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/Pointers.class */
@ApiStatus.NonExtendable
public interface Pointers extends Buildable<Pointers, Builder> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/Pointers$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder extends AbstractBuilder<Pointers>, Buildable.Builder<Pointers> {
        @Contract("_, _ -> this")
        @NotNull
        default <T> Builder withStatic(@NotNull Pointer<T> pointer, @Nullable T t) {
            return withDynamic(pointer, () -> {
                return t;
            });
        }

        @Contract("_, _ -> this")
        @NotNull
        <T> Builder withDynamic(@NotNull Pointer<T> pointer, @NotNull Supplier<T> supplier);
    }

    @Contract(pure = true)
    @NotNull
    static Pointers empty() {
        return PointersImpl.EMPTY;
    }

    @Contract(pure = true)
    @NotNull
    static Builder builder() {
        return new PointersImpl.BuilderImpl();
    }

    @NotNull
    <T> Optional<T> get(@NotNull Pointer<T> pointer);

    @Contract("_, null -> _; _, !null -> !null")
    @Nullable
    default <T> T getOrDefault(@NotNull Pointer<T> pointer, @Nullable T t) {
        return get(pointer).orElse(t);
    }

    default <T> T getOrDefaultFrom(@NotNull Pointer<T> pointer, @NotNull Supplier<? extends T> supplier) {
        return get(pointer).orElseGet(supplier);
    }

    <T> boolean supports(@NotNull Pointer<T> pointer);
}

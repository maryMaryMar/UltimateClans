package me.ulrich.clans.library.kyori.adventure.pointer;

import java.util.Optional;
import java.util.function.Supplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/Pointered.class */
public interface Pointered {
    @NotNull
    default <T> Optional<T> get(@NotNull Pointer<T> pointer) {
        return pointers().get(pointer);
    }

    @Contract("_, null -> _; _, !null -> !null")
    @Nullable
    default <T> T getOrDefault(@NotNull Pointer<T> pointer, @Nullable T t) {
        return (T) pointers().getOrDefault(pointer, t);
    }

    default <T> T getOrDefaultFrom(@NotNull Pointer<T> pointer, @NotNull Supplier<? extends T> supplier) {
        return (T) pointers().getOrDefaultFrom(pointer, supplier);
    }

    @NotNull
    default Pointers pointers() {
        return Pointers.empty();
    }
}

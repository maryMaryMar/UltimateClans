package me.ulrich.clans.library.kyori.adventure.pointer;

import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersSupplier.class */
@ApiStatus.NonExtendable
public interface PointersSupplier<T> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersSupplier$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder<T> extends AbstractBuilder<PointersSupplier<T>> {
        @Contract("_ -> this")
        @NotNull
        Builder<T> parent(@Nullable PointersSupplier<? super T> pointersSupplier);

        @Contract("_, _ -> this")
        @NotNull
        <P> Builder<T> resolving(@NotNull Pointer<P> pointer, @NotNull Function<T, P> function);
    }

    @NotNull
    static <T> Builder<T> builder() {
        return new PointersSupplierImpl.BuilderImpl();
    }

    @NotNull
    Pointers view(@NotNull T t);

    <P> boolean supports(@NotNull Pointer<P> pointer);

    @Nullable
    <P> Function<? super T, P> resolver(@NotNull Pointer<P> pointer);
}

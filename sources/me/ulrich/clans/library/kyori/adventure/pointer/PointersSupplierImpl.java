package me.ulrich.clans.library.kyori.adventure.pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersSupplierImpl.class */
final class PointersSupplierImpl<T> implements PointersSupplier<T> {

    @Nullable
    private final PointersSupplier<? super T> parent;
    private final Map<Pointer<?>, Function<T, ?>> resolvers;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersSupplierImpl$BuilderImpl.class */
    static final class BuilderImpl<T> implements PointersSupplier.Builder<T> {

        @Nullable
        private PointersSupplier<? super T> parent = null;
        private final Map<Pointer<?>, Function<T, ?>> resolvers = new HashMap();

        BuilderImpl() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.PointersSupplier.Builder
        @NotNull
        public PointersSupplier.Builder<T> parent(@Nullable PointersSupplier<? super T> pointersSupplier) {
            this.parent = pointersSupplier;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.PointersSupplier.Builder
        @NotNull
        public <P> PointersSupplier.Builder<T> resolving(@NotNull Pointer<P> pointer, @NotNull Function<T, P> function) {
            this.resolvers.put(pointer, function);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public PointersSupplier<T> build2() {
            return new PointersSupplierImpl(this);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersSupplierImpl$ForwardingPointers.class */
    static final class ForwardingPointers<U> implements Pointers {
        private final U instance;
        private final PointersSupplierImpl<U> supplier;

        ForwardingPointers(@NotNull U u, @NotNull PointersSupplierImpl<U> pointersSupplierImpl) {
            this.instance = u;
            this.supplier = pointersSupplierImpl;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers
        @NotNull
        public <T> Optional<T> get(@NotNull Pointer<T> pointer) {
            PointersSupplier pointersSupplier;
            Function functionResolver = (Function) ((PointersSupplierImpl) this.supplier).resolvers.get(Objects.requireNonNull(pointer, "pointer"));
            if (functionResolver == null && (pointersSupplier = ((PointersSupplierImpl) this.supplier).parent) != null) {
                functionResolver = pointersSupplier.resolver(pointer);
            }
            return functionResolver == null ? Optional.empty() : Optional.ofNullable(functionResolver.apply(this.instance));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers
        public <T> boolean supports(@NotNull Pointer<T> pointer) {
            return this.supplier.supports(pointer);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
        /* JADX INFO: renamed from: toBuilder */
        public Pointers.Builder mo683toBuilder() {
            Pointers.Builder builder = ((PointersSupplierImpl) this.supplier).parent == null ? Pointers.builder() : ((PointersSupplierImpl) this.supplier).parent.view(this.instance).mo683toBuilder();
            for (Map.Entry entry : ((PointersSupplierImpl) this.supplier).resolvers.entrySet()) {
                builder.withDynamic((Pointer) entry.getKey(), () -> {
                    return ((Function) entry.getValue()).apply(this.instance);
                });
            }
            return builder;
        }
    }

    PointersSupplierImpl(@NotNull BuilderImpl<T> builderImpl) {
        this.parent = ((BuilderImpl) builderImpl).parent;
        this.resolvers = new HashMap(((BuilderImpl) builderImpl).resolvers);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.PointersSupplier
    @NotNull
    public Pointers view(@NotNull T t) {
        return new ForwardingPointers(t, this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.PointersSupplier
    public <P> boolean supports(@NotNull Pointer<P> pointer) {
        if (this.resolvers.containsKey(Objects.requireNonNull(pointer, "pointer"))) {
            return true;
        }
        if (this.parent == null) {
            return false;
        }
        return this.parent.supports(pointer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.PointersSupplier
    @Nullable
    public <P> Function<? super T, P> resolver(@NotNull Pointer<P> pointer) {
        Function<T, ?> function = this.resolvers.get(Objects.requireNonNull(pointer, "pointer"));
        if (function != null) {
            return function;
        }
        if (this.parent == null) {
            return null;
        }
        return this.parent.resolver(pointer);
    }
}

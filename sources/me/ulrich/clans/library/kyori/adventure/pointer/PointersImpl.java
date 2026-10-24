package me.ulrich.clans.library.kyori.adventure.pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersImpl.class */
final class PointersImpl implements Pointers {
    static final Pointers EMPTY = new Pointers() { // from class: me.ulrich.clans.library.kyori.adventure.pointer.PointersImpl.1
        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers
        @NotNull
        public <T> Optional<T> get(@NotNull Pointer<T> pointer) {
            return Optional.empty();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers
        public <T> boolean supports(@NotNull Pointer<T> pointer) {
            return false;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
        /* JADX INFO: renamed from: toBuilder */
        public Pointers.Builder mo683toBuilder() {
            return new BuilderImpl();
        }

        public String toString() {
            return "EmptyPointers";
        }
    };
    private final Map<Pointer<?>, Supplier<?>> pointers;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointersImpl$BuilderImpl.class */
    static final class BuilderImpl implements Pointers.Builder {
        private final Map<Pointer<?>, Supplier<?>> pointers;

        BuilderImpl() {
            this.pointers = new HashMap();
        }

        BuilderImpl(@NotNull PointersImpl pointersImpl) {
            this.pointers = new HashMap(pointersImpl.pointers);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers.Builder
        @NotNull
        public <T> Pointers.Builder withDynamic(@NotNull Pointer<T> pointer, @NotNull Supplier<T> supplier) {
            this.pointers.put((Pointer) Objects.requireNonNull(pointer, "pointer"), (Supplier) Objects.requireNonNull(supplier, "value"));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public Pointers build2() {
            return new PointersImpl(this);
        }
    }

    PointersImpl(@NotNull BuilderImpl builderImpl) {
        this.pointers = new HashMap(builderImpl.pointers);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers
    @NotNull
    public <T> Optional<T> get(@NotNull Pointer<T> pointer) {
        Objects.requireNonNull(pointer, "pointer");
        Supplier<?> supplier = this.pointers.get(pointer);
        return supplier == null ? Optional.empty() : Optional.ofNullable(supplier.get());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointers
    public <T> boolean supports(@NotNull Pointer<T> pointer) {
        Objects.requireNonNull(pointer, "pointer");
        return this.pointers.containsKey(pointer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public Pointers.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }
}

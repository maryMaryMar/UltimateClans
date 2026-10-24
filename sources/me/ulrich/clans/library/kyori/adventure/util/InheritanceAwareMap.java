package me.ulrich.clans.library.kyori.adventure.util;

import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/InheritanceAwareMap.class */
public interface InheritanceAwareMap<C, V> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/InheritanceAwareMap$Builder.class */
    public interface Builder<C, V> extends AbstractBuilder<InheritanceAwareMap<C, V>> {
        @NotNull
        Builder<C, V> strict(boolean z);

        @NotNull
        Builder<C, V> put(@NotNull Class<? extends C> cls, @NotNull V v);

        @NotNull
        Builder<C, V> remove(@NotNull Class<? extends C> cls);

        @NotNull
        Builder<C, V> putAll(@NotNull InheritanceAwareMap<? extends C, ? extends V> inheritanceAwareMap);
    }

    @NotNull
    static <K, E> InheritanceAwareMap<K, E> empty() {
        return InheritanceAwareMapImpl.EMPTY;
    }

    static <K, E> Builder<K, E> builder() {
        return new InheritanceAwareMapImpl.BuilderImpl();
    }

    static <K, E> Builder<K, E> builder(InheritanceAwareMap<? extends K, ? extends E> inheritanceAwareMap) {
        return new InheritanceAwareMapImpl.BuilderImpl().putAll(inheritanceAwareMap);
    }

    boolean containsKey(@NotNull Class<? extends C> cls);

    @Nullable
    V get(@NotNull Class<? extends C> cls);

    @CheckReturnValue
    @NotNull
    InheritanceAwareMap<C, V> with(@NotNull Class<? extends C> cls, @NotNull V v);

    @CheckReturnValue
    @NotNull
    InheritanceAwareMap<C, V> without(@NotNull Class<? extends C> cls);
}

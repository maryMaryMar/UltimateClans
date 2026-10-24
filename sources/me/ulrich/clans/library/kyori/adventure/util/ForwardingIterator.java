package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/ForwardingIterator.class */
public final class ForwardingIterator<T> implements Iterable<T> {
    private final Supplier<Iterator<T>> iterator;
    private final Supplier<Spliterator<T>> spliterator;

    public ForwardingIterator(@NotNull Supplier<Iterator<T>> supplier, @NotNull Supplier<Spliterator<T>> supplier2) {
        this.iterator = (Supplier) Objects.requireNonNull(supplier, "iterator");
        this.spliterator = (Supplier) Objects.requireNonNull(supplier2, "spliterator");
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return this.iterator.get();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Spliterator<T> spliterator() {
        return this.spliterator.get();
    }
}

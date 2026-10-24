package me.ulrich.clans.library.nbtapi.iface;

import java.util.Collection;
import java.util.ListIterator;
import java.util.function.Predicate;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/ReadWriteNBTList.class */
public interface ReadWriteNBTList<T> extends ReadableNBTList<T> {
    boolean add(T t);

    void add(int i, T t);

    T set(int i, T t);

    T remove(int i);

    void clear();

    boolean addAll(Collection<? extends T> collection);

    boolean addAll(int i, Collection<? extends T> collection);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    boolean removeIf(Predicate<? super T> predicate);

    boolean remove(Object obj);

    ListIterator<T> listIterator(int i);
}

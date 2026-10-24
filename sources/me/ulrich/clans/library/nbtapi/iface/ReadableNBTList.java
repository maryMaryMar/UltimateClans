package me.ulrich.clans.library.nbtapi.iface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.nbtapi.NBTType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/ReadableNBTList.class */
public interface ReadableNBTList<T> extends Iterable<T> {
    T get(int i);

    int size();

    NBTType getType();

    boolean isEmpty();

    boolean contains(Object obj);

    int indexOf(Object obj);

    boolean containsAll(Collection<?> collection);

    int lastIndexOf(Object obj);

    Object[] toArray();

    <E> E[] toArray(E[] eArr);

    List<T> subList(int i, int i2);

    default List<T> toListCopy() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterator();
        Objects.requireNonNull(arrayList);
        it.forEachRemaining(arrayList::add);
        return arrayList;
    }
}

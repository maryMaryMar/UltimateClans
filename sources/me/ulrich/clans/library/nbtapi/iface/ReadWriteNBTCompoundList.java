package me.ulrich.clans.library.nbtapi.iface;

import java.util.function.Predicate;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/ReadWriteNBTCompoundList.class */
public interface ReadWriteNBTCompoundList extends ReadableNBTList<ReadWriteNBT> {
    ReadWriteNBT addCompound();

    ReadWriteNBT addCompound(ReadableNBT readableNBT);

    ReadWriteNBT remove(int i);

    void clear();

    boolean removeIf(Predicate<? super ReadWriteNBT> predicate);
}

package me.ulrich.clans.library.nbtapi.iface;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/NBTHandler.class */
public interface NBTHandler<T> {
    default boolean fuzzyMatch(Object obj) {
        return false;
    }

    void set(@Nonnull ReadWriteNBT readWriteNBT, @Nonnull String str, @Nonnull T t);

    T get(@Nonnull ReadableNBT readableNBT, @Nonnull String str);
}

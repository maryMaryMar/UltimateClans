package me.ulrich.clans.library.nbtapi.iface;

import java.util.function.BiConsumer;
import org.bukkit.inventory.meta.ItemMeta;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/ReadWriteItemNBT.class */
public interface ReadWriteItemNBT extends ReadWriteNBT, ReadableItemNBT {
    boolean hasCustomNbtData();

    void clearCustomNBT();

    void modifyMeta(BiConsumer<ReadableNBT, ItemMeta> biConsumer);

    <T extends ItemMeta> void modifyMeta(Class<T> cls, BiConsumer<ReadableNBT, T> biConsumer);
}

package me.ulrich.clans.library.nbtapi.iface;

import java.util.UUID;
import javax.annotation.Nullable;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/ReadWriteNBT.class */
public interface ReadWriteNBT extends ReadableNBT {
    void mergeCompound(ReadableNBT readableNBT);

    void setString(String str, String str2);

    void setInteger(String str, Integer num);

    void setDouble(String str, Double d);

    void setByte(String str, Byte b);

    void setShort(String str, Short sh);

    void setLong(String str, Long l);

    void setFloat(String str, Float f);

    void setByteArray(String str, byte[] bArr);

    void setIntArray(String str, int[] iArr);

    void setLongArray(String str, long[] jArr);

    void setBoolean(String str, Boolean bool);

    void setItemStack(String str, ItemStack itemStack);

    void setItemStackArray(String str, ItemStack[] itemStackArr);

    void setUUID(String str, UUID uuid);

    void removeKey(String str);

    ReadWriteNBT getOrCreateCompound(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    @Nullable
    ReadWriteNBT getCompound(String str);

    ReadWriteNBT resolveOrCreateCompound(String str);

    <T> void set(String str, T t, NBTHandler<T> nBTHandler);

    <E extends Enum<?>> void setEnum(String str, E e);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<String> getStringList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<Integer> getIntegerList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<int[]> getIntArrayList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<UUID> getUUIDList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<Float> getFloatList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<Double> getDoubleList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTList<Long> getLongList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    ReadWriteNBTCompoundList getCompoundList(String str);

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    @Nullable
    ReadWriteNBT resolveCompound(String str);

    void clearNBT();
}

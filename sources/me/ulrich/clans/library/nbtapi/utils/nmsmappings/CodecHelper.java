package me.ulrich.clans.library.nbtapi.utils.nmsmappings;

import com.mojang.serialization.DataResult;
import java.util.Objects;
import java.util.Optional;
import me.ulrich.clans.library.nbtapi.NBTReflectionUtil;
import me.ulrich.clans.library.nbtapi.NbtApiException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/nmsmappings/CodecHelper.class */
public class CodecHelper {
    public static Object convertItemStackToNbt(Object obj) {
        DataResult dataResultEncodeStart = null;
        try {
            dataResultEncodeStart = NBTReflectionUtil.itemstack_codec.encodeStart(NBTReflectionUtil.nbtRegistryOps, obj);
            Objects.requireNonNull(dataResultEncodeStart);
            return ((Optional) dataResultEncodeStart.getClass().getMethod("result", new Class[0]).invoke(dataResultEncodeStart, new Object[0])).get();
        } catch (Exception e) {
            throw new NbtApiException("Failed to convert ItemStack to NBT. " + dataResultEncodeStart + " " + obj, e);
        }
    }

    public static Object convertNbtToItemStack(Object obj) {
        DataResult dataResult = null;
        try {
            dataResult = NBTReflectionUtil.itemstack_codec.parse(NBTReflectionUtil.nbtRegistryOps, obj);
            Objects.requireNonNull(dataResult);
            return ((Optional) dataResult.getClass().getMethod("result", new Class[0]).invoke(dataResult, new Object[0])).get();
        } catch (Exception e) {
            throw new NbtApiException("Failed to convert NBT to ItemStack. " + dataResult + " " + obj, e);
        }
    }
}

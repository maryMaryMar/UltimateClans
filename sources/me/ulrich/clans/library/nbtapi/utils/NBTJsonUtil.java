package me.ulrich.clans.library.nbtapi.utils;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import java.util.Optional;
import me.ulrich.clans.library.nbtapi.NbtApiException;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.MojangToMapping;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/NBTJsonUtil.class */
public class NBTJsonUtil {
    public static JsonElement itemStackToJson(ItemStack itemStack) {
        try {
            DataResult dataResultEncode = ((Codec) ClassWrapper.NMS_ITEMSTACK.getClazz().getField(MojangToMapping.getMapping().get("net.minecraft.world.item.ItemStack#CODEC")).get(null)).encode(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, itemStack), JsonOps.INSTANCE, (JsonElement) JsonOps.INSTANCE.emptyMap());
            return (JsonElement) ((Optional) dataResultEncode.getClass().getMethod("result", new Class[0]).invoke(dataResultEncode, new Object[0])).orElse(null);
        } catch (Exception e) {
            throw new NbtApiException("Error trying to get Json of an ItemStack.", e);
        }
    }
}

package me.ulrich.clans.library.nbtapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import me.ulrich.clans.library.nbtapi.utils.UUIDUtil;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTUUIDList.class */
public class NBTUUIDList extends NBTList<UUID> {
    private final NBTContainer tmpContainer;

    protected NBTUUIDList(NBTCompound nBTCompound, String str, NBTType nBTType, Object obj) {
        super(nBTCompound, str, nBTType, obj);
        this.tmpContainer = new NBTContainer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.ulrich.clans.library.nbtapi.NBTList
    public Object asTag(UUID uuid) {
        try {
            Constructor<?> declaredConstructor = ClassWrapper.NMS_NBTTAGINTARRAY.getClazz().getDeclaredConstructor(int[].class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(UUIDUtil.uuidToIntArray(uuid));
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new NbtApiException("Error while wrapping the Object " + uuid + " to it's NMS object!", e);
        }
    }

    @Override // java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadableNBTList
    public UUID get(int i) {
        try {
            ReflectionMethod.COMPOUND_SET.run(this.tmpContainer.getCompound(), "tmp", ReflectionMethod.LIST_GET.run(this.listObject, Integer.valueOf(i)));
            int[] intArray = this.tmpContainer.getIntArray("tmp");
            this.tmpContainer.removeKey("tmp");
            return UUIDUtil.uuidFromIntArray(intArray);
        } catch (NumberFormatException e) {
            return null;
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }
}

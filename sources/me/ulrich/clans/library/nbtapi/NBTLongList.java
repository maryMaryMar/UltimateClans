package me.ulrich.clans.library.nbtapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTLongList.class */
public class NBTLongList extends NBTList<Long> {
    protected NBTLongList(NBTCompound nBTCompound, String str, NBTType nBTType, Object obj) {
        super(nBTCompound, str, nBTType, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.ulrich.clans.library.nbtapi.NBTList
    public Object asTag(Long l) {
        try {
            Constructor<?> declaredConstructor = ClassWrapper.NMS_NBTTAGLONG.getClazz().getDeclaredConstructor(Long.TYPE);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(l);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new NbtApiException("Error while wrapping the Object " + l + " to it's NMS object!", e);
        }
    }

    @Override // java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadableNBTList
    public Long get(int i) {
        try {
            return Long.valueOf(ReflectionMethod.LIST_GET.run(this.listObject, Integer.valueOf(i)).toString().replace("L", ""));
        } catch (NumberFormatException e) {
            return 0L;
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }
}

package me.ulrich.clans.library.nbtapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTIntegerList.class */
public class NBTIntegerList extends NBTList<Integer> {
    protected NBTIntegerList(NBTCompound nBTCompound, String str, NBTType nBTType, Object obj) {
        super(nBTCompound, str, nBTType, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.ulrich.clans.library.nbtapi.NBTList
    public Object asTag(Integer num) {
        try {
            Constructor<?> declaredConstructor = ClassWrapper.NMS_NBTTAGINT.getClazz().getDeclaredConstructor(Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(num);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new NbtApiException("Error while wrapping the Object " + num + " to it's NMS object!", e);
        }
    }

    @Override // java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadableNBTList
    public Integer get(int i) {
        try {
            return Integer.valueOf(ReflectionMethod.LIST_GET.run(this.listObject, Integer.valueOf(i)).toString());
        } catch (NumberFormatException e) {
            return 0;
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }
}

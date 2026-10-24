package me.ulrich.clans.library.nbtapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTFloatList.class */
public class NBTFloatList extends NBTList<Float> {
    protected NBTFloatList(NBTCompound nBTCompound, String str, NBTType nBTType, Object obj) {
        super(nBTCompound, str, nBTType, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.ulrich.clans.library.nbtapi.NBTList
    public Object asTag(Float f) {
        try {
            Constructor<?> declaredConstructor = ClassWrapper.NMS_NBTTAGFLOAT.getClazz().getDeclaredConstructor(Float.TYPE);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(f);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new NbtApiException("Error while wrapping the Object " + f + " to it's NMS object!", e);
        }
    }

    @Override // java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadableNBTList
    public Float get(int i) {
        try {
            return Float.valueOf(ReflectionMethod.LIST_GET.run(this.listObject, Integer.valueOf(i)).toString());
        } catch (NumberFormatException e) {
            return Float.valueOf(0.0f);
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }
}

package me.ulrich.clans.library.nbtapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTDoubleList.class */
public class NBTDoubleList extends NBTList<Double> {
    protected NBTDoubleList(NBTCompound nBTCompound, String str, NBTType nBTType, Object obj) {
        super(nBTCompound, str, nBTType, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.ulrich.clans.library.nbtapi.NBTList
    public Object asTag(Double d) {
        try {
            Constructor<?> declaredConstructor = ClassWrapper.NMS_NBTTAGDOUBLE.getClazz().getDeclaredConstructor(Double.TYPE);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(d);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new NbtApiException("Error while wrapping the Object " + d + " to it's NMS object!", e);
        }
    }

    @Override // java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadableNBTList
    public Double get(int i) {
        try {
            return Double.valueOf(ReflectionMethod.LIST_GET.run(this.listObject, Integer.valueOf(i)).toString());
        } catch (NumberFormatException e) {
            return Double.valueOf(0.0d);
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }
}

package me.ulrich.clans.library.nbtapi.utils.nmsmappings;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import me.ulrich.clans.library.nbtapi.NbtApiException;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/nmsmappings/ObjectCreator.class */
public enum ObjectCreator {
    NMS_NBTTAGCOMPOUND(null, null, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[0]),
    NMS_CUSTOMDATA(MinecraftVersion.MC1_20_R4, null, ClassWrapper.NMS_CUSTOMDATA.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()),
    NMS_BLOCKPOSITION(null, null, ClassWrapper.NMS_BLOCKPOSITION.getClazz(), Integer.TYPE, Integer.TYPE, Integer.TYPE),
    NMS_COMPOUNDFROMITEM(MinecraftVersion.MC1_11_R1, MinecraftVersion.MC1_20_R3, ClassWrapper.NMS_ITEMSTACK.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz());

    private Constructor<?> construct;
    private Class<?> targetClass;

    ObjectCreator(MinecraftVersion minecraftVersion, MinecraftVersion minecraftVersion2, Class cls, Class... clsArr) {
        if (cls == null) {
            return;
        }
        if (minecraftVersion == null || MinecraftVersion.getVersion().getVersionId() >= minecraftVersion.getVersionId()) {
            if (minecraftVersion2 == null || MinecraftVersion.getVersion().getVersionId() <= minecraftVersion2.getVersionId()) {
                try {
                    this.targetClass = cls;
                    this.construct = cls.getDeclaredConstructor(clsArr);
                    this.construct.setAccessible(true);
                } catch (Exception e) {
                    MinecraftVersion.getLogger().log(Level.SEVERE, "Unable to find the constructor for the class '" + cls.getName() + "'", (Throwable) e);
                }
            }
        }
    }

    public Object getInstance(Object... objArr) {
        try {
            return this.construct.newInstance(objArr);
        } catch (Exception e) {
            throw new NbtApiException("Exception while creating a new instance of '" + this.targetClass + "'", e);
        }
    }
}

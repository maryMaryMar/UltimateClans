package me.ulrich.clans.library.nbtapi.utils;

import java.lang.reflect.Field;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.nbtapi.NbtApiException;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.MojangToMapping;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/ReflectionUtil.class */
public final class ReflectionUtil {
    public static Field getMappedField(Class<?> cls, String str) {
        try {
            return cls.getField(str.split(TextColor.HEX_PREFIX)[1]);
        } catch (NoSuchFieldException | SecurityException e) {
            try {
                return cls.getDeclaredField(MojangToMapping.getMapping().get(str));
            } catch (Exception e2) {
                throw new NbtApiException("Unable to find field " + str + " in class " + cls.getName(), e2);
            }
        }
    }
}

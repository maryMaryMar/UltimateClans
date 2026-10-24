package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/MinecraftReflection.class */
final class MinecraftReflection {
    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    private static final String PREFIX_NMS = "net.minecraft.server";
    private static final String PREFIX_MC = "net.minecraft.";
    private static final String PREFIX_CRAFTBUKKIT = "org.bukkit.craftbukkit";
    private static final String CRAFT_SERVER = "CraftServer";

    @Nullable
    private static final String VERSION;

    private MinecraftReflection() {
    }

    @Nullable
    public static Class<?> findClass(@Nullable String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException e) {
                }
            }
        }
        return null;
    }

    @NotNull
    public static Class<?> needClass(@Nullable String... strArr) {
        return (Class) Objects.requireNonNull(findClass(strArr), "Could not find class from candidates" + Arrays.toString(strArr));
    }

    public static boolean hasClass(@NotNull String... strArr) {
        return findClass(strArr) != null;
    }

    @Nullable
    public static MethodHandle findMethod(@Nullable Class<?> cls, String str, @Nullable Class<?> cls2, Class<?>... clsArr) {
        return findMethod(cls, new String[]{str}, cls2, clsArr);
    }

    @Nullable
    public static MethodHandle findMethod(@Nullable Class<?> cls, @Nullable String[] strArr, @Nullable Class<?> cls2, Class<?>... clsArr) {
        if (cls == null || cls2 == null) {
            return null;
        }
        for (Class<?> cls3 : clsArr) {
            if (cls3 == null) {
                return null;
            }
        }
        for (String str : strArr) {
            if (str != null) {
                try {
                    return LOOKUP.findVirtual(cls, str, MethodType.methodType(cls2, clsArr));
                } catch (IllegalAccessException | NoSuchMethodException e) {
                }
            }
        }
        return null;
    }

    public static MethodHandle searchMethod(@Nullable Class<?> cls, @Nullable Integer num, String str, @Nullable Class<?> cls2, Class<?>... clsArr) {
        return searchMethod(cls, num, new String[]{str}, cls2, clsArr);
    }

    public static MethodHandle searchMethod(@Nullable Class<?> cls, @Nullable Integer num, @Nullable String[] strArr, @Nullable Class<?> cls2, Class<?>... clsArr) {
        if (cls == null || cls2 == null) {
            return null;
        }
        for (Class<?> cls3 : clsArr) {
            if (cls3 == null) {
                return null;
            }
        }
        for (String str : strArr) {
            if (str != null) {
                if (num != null) {
                    try {
                        if (Modifier.isStatic(num.intValue())) {
                            return LOOKUP.findStatic(cls, str, MethodType.methodType(cls2, clsArr));
                        }
                    } catch (IllegalAccessException | NoSuchMethodException e) {
                    }
                }
                return LOOKUP.findVirtual(cls, str, MethodType.methodType(cls2, clsArr));
            }
        }
        for (Method method : cls.getDeclaredMethods()) {
            if (num != null && (method.getModifiers() & num.intValue()) != 0 && Arrays.equals(method.getParameterTypes(), clsArr)) {
                try {
                    return Modifier.isStatic(num.intValue()) ? LOOKUP.findStatic(cls, method.getName(), MethodType.methodType(cls2, clsArr)) : LOOKUP.findVirtual(cls, method.getName(), MethodType.methodType(cls2, clsArr));
                } catch (IllegalAccessException | NoSuchMethodException e2) {
                }
            }
        }
        return null;
    }

    @Nullable
    public static MethodHandle findStaticMethod(@Nullable Class<?> cls, String str, @Nullable Class<?> cls2, Class<?>... clsArr) {
        return findStaticMethod(cls, new String[]{str}, cls2, clsArr);
    }

    @Nullable
    public static MethodHandle findStaticMethod(@Nullable Class<?> cls, String[] strArr, @Nullable Class<?> cls2, Class<?>... clsArr) {
        if (cls == null || cls2 == null) {
            return null;
        }
        for (Class<?> cls3 : clsArr) {
            if (cls3 == null) {
                return null;
            }
        }
        for (String str : strArr) {
            try {
                return LOOKUP.findStatic(cls, str, MethodType.methodType(cls2, clsArr));
            } catch (IllegalAccessException | NoSuchMethodException e) {
            }
        }
        return null;
    }

    public static boolean hasField(@Nullable Class<?> cls, Class<?> cls2, String... strArr) {
        if (cls == null) {
            return false;
        }
        for (String str : strArr) {
            try {
                if (cls.getDeclaredField(str).getType() == cls2) {
                    return true;
                }
            } catch (NoSuchFieldException e) {
            }
        }
        return false;
    }

    public static boolean hasMethod(@Nullable Class<?> cls, String str, Class<?>... clsArr) {
        return hasMethod(cls, new String[]{str}, clsArr);
    }

    public static boolean hasMethod(@Nullable Class<?> cls, String[] strArr, Class<?>... clsArr) {
        if (cls == null) {
            return false;
        }
        for (Class<?> cls2 : clsArr) {
            if (cls2 == null) {
                return false;
            }
        }
        for (String str : strArr) {
            try {
                cls.getMethod(str, clsArr);
                return true;
            } catch (NoSuchMethodException e) {
            }
        }
        return false;
    }

    @Nullable
    public static MethodHandle findConstructor(@Nullable Class<?> cls, @Nullable Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        for (Class<?> cls2 : clsArr) {
            if (cls2 == null) {
                return null;
            }
        }
        try {
            return LOOKUP.findConstructor(cls, MethodType.methodType((Class<?>) Void.TYPE, clsArr));
        } catch (IllegalAccessException | NoSuchMethodException e) {
            return null;
        }
    }

    @NotNull
    public static Field needField(@NotNull Class<?> cls, @NotNull String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    @Nullable
    public static Field findField(@Nullable Class<?> cls, @NotNull String... strArr) {
        return findField(cls, null, strArr);
    }

    @Nullable
    public static Field findField(@Nullable Class<?> cls, @Nullable Class<?> cls2, @NotNull String... strArr) {
        if (cls == null) {
            return null;
        }
        for (String str : strArr) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                if (cls2 == null || cls2.isAssignableFrom(declaredField.getType())) {
                    return declaredField;
                }
            } catch (NoSuchFieldException e) {
            }
        }
        return null;
    }

    @Nullable
    public static MethodHandle findSetterOf(@Nullable Field field) {
        if (field == null) {
            return null;
        }
        try {
            return LOOKUP.unreflectSetter(field);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    @Nullable
    public static MethodHandle findGetterOf(@Nullable Field field) {
        if (field == null) {
            return null;
        }
        try {
            return LOOKUP.unreflectGetter(field);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    @Nullable
    public static Object findEnum(@Nullable Class<?> cls, @NotNull String str) {
        return findEnum(cls, str, Integer.MAX_VALUE);
    }

    @Nullable
    public static Object findEnum(@Nullable Class<?> cls, @NotNull String str, int i) {
        if (cls == null || !Enum.class.isAssignableFrom(cls)) {
            return null;
        }
        try {
            return Enum.valueOf(cls.asSubclass(Enum.class), str);
        } catch (IllegalArgumentException e) {
            Object[] enumConstants = cls.getEnumConstants();
            if (enumConstants.length > i) {
                return enumConstants[i];
            }
            return null;
        }
    }

    public static boolean isCraftBukkit() {
        return VERSION != null;
    }

    @Nullable
    public static String findCraftClassName(@NotNull String str) {
        if (isCraftBukkit()) {
            return PREFIX_CRAFTBUKKIT + VERSION + str;
        }
        return null;
    }

    @Nullable
    public static Class<?> findCraftClass(@NotNull String str) {
        String strFindCraftClassName = findCraftClassName(str);
        if (strFindCraftClassName == null) {
            return null;
        }
        return findClass(strFindCraftClassName);
    }

    @Nullable
    public static <T> Class<? extends T> findCraftClass(@NotNull String str, @NotNull Class<T> cls) {
        Class<?> clsFindCraftClass = findCraftClass(str);
        if (clsFindCraftClass == null || !((Class) Objects.requireNonNull(cls, "superClass")).isAssignableFrom(clsFindCraftClass)) {
            return null;
        }
        return (Class<? extends T>) clsFindCraftClass.asSubclass(cls);
    }

    @NotNull
    public static Class<?> needCraftClass(@NotNull String str) {
        return (Class) Objects.requireNonNull(findCraftClass(str), "Could not find org.bukkit.craftbukkit class " + str);
    }

    @Nullable
    public static String findNmsClassName(@NotNull String str) {
        if (isCraftBukkit()) {
            return PREFIX_NMS + VERSION + str;
        }
        return null;
    }

    @Nullable
    public static Class<?> findNmsClass(@NotNull String str) {
        String strFindNmsClassName = findNmsClassName(str);
        if (strFindNmsClassName == null) {
            return null;
        }
        return findClass(strFindNmsClassName);
    }

    @NotNull
    public static Class<?> needNmsClass(@NotNull String str) {
        return (Class) Objects.requireNonNull(findNmsClass(str), "Could not find net.minecraft.server class " + str);
    }

    @Nullable
    public static String findMcClassName(@NotNull String str) {
        if (isCraftBukkit()) {
            return PREFIX_MC + str;
        }
        return null;
    }

    @Nullable
    public static Class<?> findMcClass(@NotNull String... strArr) {
        Class<?> clsFindClass;
        for (String str : strArr) {
            String strFindMcClassName = findMcClassName(str);
            if (strFindMcClassName != null && (clsFindClass = findClass(strFindMcClassName)) != null) {
                return clsFindClass;
            }
        }
        return null;
    }

    @NotNull
    public static Class<?> needMcClass(@NotNull String... strArr) {
        return (Class) Objects.requireNonNull(findMcClass(strArr), "Could not find net.minecraft class from candidates" + Arrays.toString(strArr));
    }

    public static MethodHandles.Lookup lookup() {
        return LOOKUP;
    }

    static {
        Class<?> cls = Bukkit.getServer().getClass();
        if (!cls.getSimpleName().equals(CRAFT_SERVER)) {
            VERSION = null;
        } else if (cls.getName().equals("org.bukkit.craftbukkit.CraftServer")) {
            VERSION = ".";
        } else {
            String strSubstring = cls.getName().substring(PREFIX_CRAFTBUKKIT.length());
            VERSION = strSubstring.substring(0, strSubstring.length() - CRAFT_SERVER.length());
        }
    }
}

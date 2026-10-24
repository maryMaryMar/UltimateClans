package me.module.discord.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/reflect/NMSUtils.class */
public class NMSUtils {
    private static Method varHandleSet = null;
    private static Object modifiersVarHandle = null;
    private static Field modifiersField = null;
    private static Map<Class<?>, Method> handleMethods = new HashMap();
    private static String version = getVersion();

    public NMSUtils() {
        try {
            Class.forName("java.lang.invoke.VarHandle");
            Class<?> cls = getClass("java.lang.invoke.MethodHandles");
            Class<?> innerClass = getInnerClass(cls, "Lookup");
            modifiersVarHandle = getMethod(innerClass, "findVarHandle", (Class<?>[]) new Class[]{Class.class, String.class, Class.class}).invoke(getMethod(cls, "privateLookupIn", (Class<?>[]) new Class[]{Class.class, innerClass}).invoke(null, Field.class, getMethod(cls, "lookup", (Class<?>[]) new Class[0]).invoke(null, new Object[0])), Field.class, "modifiers", Integer.TYPE);
        } catch (Exception e) {
        }
        try {
            varHandleSet = getMethod(Class.forName("java.lang.invoke.VarHandle"), "set", (Class<?>[]) new Class[]{Object[].class});
        } catch (Exception e2) {
        }
        try {
            modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
        } catch (Exception e3) {
        }
    }

    public static String getVersion() {
        if (version != null) {
            return version;
        }
        String name = Bukkit.getServer().getClass().getPackage().getName();
        String str = name.substring(name.lastIndexOf(46) + 1) + ".";
        return "v" + getCurrentVersion() + ".";
    }

    private static String getCurrentVersion() {
        Matcher matcher = Pattern.compile("(?<version>\\d+\\.\\d+)(?<patch>\\.\\d+)?").matcher(Bukkit.getBukkitVersion());
        StringBuilder sb = new StringBuilder();
        if (matcher.find()) {
            sb.append(matcher.group("version").replace(".", "_"));
            String strGroup = matcher.group("patch");
            if (strGroup == null) {
                sb.append("0");
            } else {
                sb.append("_R");
                sb.append(strGroup.replace(".", ""));
            }
        }
        String string = sb.toString();
        return string == null ? "0" : string;
    }

    public static Class<?> getClassWithException(String str) {
        return Class.forName(str);
    }

    public static Class<?> getClass(String str) {
        try {
            return getClassWithException(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<?> getClassSilent(String str) {
        try {
            return getClassWithException(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Class<?> getPossibleClass(String... strArr) {
        for (String str : strArr) {
            try {
                return getClassWithException(str);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Class<?> getNMSClassWithException(String str) {
        return Class.forName("net.minecraft.server." + getVersion() + str);
    }

    public static Class<?> getNMSClass(String str) {
        try {
            return getNMSClassWithException(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<?> getNMSClassSilent(String str) {
        try {
            return getNMSClassWithException(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Class<?> getNMSClass(String str, String str2) {
        try {
            return getNMSClassWithException(str);
        } catch (Exception e) {
            return getInnerClassSilent(getNMSClassSilent(str2), str);
        }
    }

    public static Class<?> getNMSClassSilent(String str, String str2) {
        try {
            return getNMSClassWithException(str);
        } catch (Exception e) {
            return getInnerClassSilent(getNMSClassSilent(str2), str);
        }
    }

    public static Class<?> getNMSInnerClassSilent(String str, String str2) {
        try {
            return getInnerClassSilent(getNMSClassSilent(str2), str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Class<?> getOBCClassWithException(String str) {
        return Class.forName("org.bukkit.craftbukkit." + getVersion() + str);
    }

    public static Class<?> getOBCClass(String str) {
        try {
            return getOBCClassWithException(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<?> getOBCClassSilent(String str) {
        try {
            return getOBCClassWithException(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object getHandle(Object obj) {
        try {
            return getHandleWithException(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getHandleWithException(Object obj) {
        return handleMethods.computeIfAbsent(obj.getClass(), cls -> {
            return getMethod((Class<?>) cls, "getHandle", (Class<?>[]) new Class[0]);
        }).invoke(obj, new Object[0]);
    }

    public static Object getHandleSilent(Object obj) {
        try {
            return getHandleWithException(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static Field setAccessible(Field field) {
        return setAccessible(field, false);
    }

    public static Field setAccessible(Field field, boolean z) {
        return setAccessible(field, z, false);
    }

    private static Field setAccessible(Field field, boolean z, boolean z2) {
        try {
            field.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
            if (!z2) {
                return (Field) AccessController.doPrivileged(() -> {
                    try {
                        return setAccessible(field, z, true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return field;
                    }
                });
            }
        }
        if (z) {
            return field;
        }
        removeFinal(field, z2);
        return field;
    }

    private static void removeFinal(Field field, boolean z) {
        if (Modifier.isFinal(field.getModifiers())) {
            try {
                removeFinalSimple(field);
            } catch (Exception e) {
                try {
                    removeFinalVarHandle(field);
                } catch (Exception e2) {
                    try {
                        removeFinalNativeDeclaredFields(field);
                    } catch (Exception e3) {
                        if (z) {
                            return;
                        }
                        AccessController.doPrivileged(() -> {
                            try {
                                setAccessible(field, false, true);
                                return null;
                            } catch (Exception e4) {
                                e.printStackTrace();
                                return null;
                            }
                        });
                    }
                }
            }
        }
    }

    private static void removeFinalSimple(Field field) throws IllegalAccessException, NoSuchFieldException {
        int modifiers = field.getModifiers();
        Field declaredField = Field.class.getDeclaredField("modifiers");
        declaredField.setAccessible(true);
        declaredField.setInt(field, modifiers & (-17));
    }

    private static void removeFinalVarHandle(Field field) throws IllegalAccessException, InvocationTargetException {
        int modifiers = field.getModifiers() & (-17);
        if (modifiersVarHandle != null) {
            varHandleSet.invoke(modifiersVarHandle, field, Integer.valueOf(modifiers));
        } else {
            modifiersField.setInt(field, modifiers);
        }
    }

    private static void removeFinalNativeDeclaredFields(Field field) throws IllegalAccessException, NoSuchMethodException {
        removeFinalNativeDeclaredFields(field, false);
    }

    private static void removeFinalNativeDeclaredFields(Field field, boolean z) throws IllegalAccessException, NoSuchMethodException {
        int modifiers = field.getModifiers();
        Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredFields0", Boolean.TYPE);
        declaredMethod.setAccessible(true);
        for (Field field2 : (Field[]) declaredMethod.invoke(Field.class, false)) {
            if ("modifiers".equals(field2.getName())) {
                field2.setAccessible(true);
                field2.set(field, Integer.valueOf(modifiers & (-17)));
                return;
            }
        }
    }

    public static List<Field> getDirectFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field accessible : cls.getDeclaredFields()) {
            try {
                accessible = setAccessible(accessible);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!Modifier.isStatic(accessible.getModifiers())) {
                arrayList.add(accessible);
            }
        }
        return arrayList;
    }

    public static List<Field> getFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            arrayList.add(setAccessible(field));
        }
        return arrayList;
    }

    public static List<Field> getFieldsIncludingUpper(Class<?> cls) {
        Class<? super Object> superclass;
        ArrayList arrayList = new ArrayList();
        do {
            for (Field field : cls.getDeclaredFields()) {
                arrayList.add(setAccessible(field));
            }
            superclass = cls.getSuperclass();
            cls = superclass;
        } while (superclass != null);
        return arrayList;
    }

    public static Field getFieldWithException(Class<?> cls, String str) throws Exception {
        for (Field field : cls.getDeclaredFields()) {
            if (field.getName().equals(str)) {
                return setAccessible(field);
            }
        }
        throw new Exception("Field Not Found");
    }

    public static Field getField(Class<?> cls, String str) {
        try {
            return getFieldWithException(cls, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getFieldSilent(Class<?> cls, String str) {
        try {
            return getFieldWithException(cls, str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object getFieldValueWithException(Field field, Object obj) {
        return field.get(obj);
    }

    public static Object getFieldValueSilent(Field field, Object obj) {
        try {
            return getFieldValueWithException(field, obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return getFieldValueWithException(field, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getPossibleField(Class<?> cls, String... strArr) {
        for (String str : strArr) {
            try {
                return getFieldWithException(cls, str);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Field getFieldOfTypeWithException(Class<?> cls, Class<?> cls2, String str) throws Exception {
        for (Field field : cls.getDeclaredFields()) {
            if (field.getName().equals(str) && field.getType().equals(cls2)) {
                return setAccessible(field);
            }
        }
        throw new Exception("Field Not Found");
    }

    public static Field getFieldOfType(Class<?> cls, Class<?> cls2, String str) {
        try {
            return getFieldOfTypeWithException(cls, cls2, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getFirstFieldOfTypeWithException(Class<?> cls, Class<?> cls2) throws Exception {
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType().equals(cls2)) {
                return setAccessible(field);
            }
        }
        throw new Exception("Field Not Found");
    }

    public static Field getFirstFieldOfTypeSilent(Class<?> cls, Class<?> cls2) {
        try {
            return getFirstFieldOfTypeWithException(cls, cls2);
        } catch (Exception e) {
            return null;
        }
    }

    public static Field getFirstNonStaticFieldOfTypeWithException(Class<?> cls, Class<?> cls2) throws Exception {
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType().equals(cls2) && !Modifier.isStatic(field.getModifiers())) {
                return setAccessible(field);
            }
        }
        throw new Exception("Field Not Found");
    }

    public static Field getFirstNonStaticFieldOfTypeSilent(Class<?> cls, Class<?> cls2) {
        try {
            return getFirstNonStaticFieldOfTypeWithException(cls, cls2);
        } catch (Exception e) {
            return null;
        }
    }

    public static Field getFirstFieldOfType(Class<?> cls, Class<?> cls2) {
        try {
            return getFirstFieldOfTypeWithException(cls, cls2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Field> getFieldsOfTypeWithException(Class<?> cls, Class<?> cls2) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            if (cls2.isAssignableFrom(field.getType())) {
                arrayList.add(setAccessible(field));
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        throw new Exception("Fields Not Found");
    }

    public static List<Field> getFieldsOfType(Class<?> cls, Class<?> cls2) {
        try {
            return getFieldsOfTypeWithException(cls, cls2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getLastFieldOfTypeWithException(Class<?> cls, Class<?> cls2) throws Exception {
        Field field = null;
        for (Field field2 : cls.getDeclaredFields()) {
            if (field2.getType().equals(cls2)) {
                field = field2;
            }
        }
        if (field == null) {
            throw new Exception("Field Not Found");
        }
        return setAccessible(field);
    }

    public static Field getLastFieldOfType(Class<?> cls, Class<?> cls2) {
        try {
            return getLastFieldOfTypeWithException(cls, cls2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str) && ((clsArr.length == 0 && method.getParameterTypes().length == 0) || ClassListEqual(clsArr, method.getParameterTypes()))) {
                method.setAccessible(true);
                return method;
            }
        }
        for (Method method2 : cls.getMethods()) {
            if (method2.getName().equals(str) && ((clsArr.length == 0 && method2.getParameterTypes().length == 0) || ClassListEqual(clsArr, method2.getParameterTypes()))) {
                method2.setAccessible(true);
                return method2;
            }
        }
        return null;
    }

    public static Method getMethod(Class<?> cls, String[] strArr, Class<?>... clsArr) {
        for (String str : strArr) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(str) && ((clsArr.length == 0 && method.getParameterTypes().length == 0) || ClassListEqual(clsArr, method.getParameterTypes()))) {
                    method.setAccessible(true);
                    return method;
                }
            }
            for (Method method2 : cls.getMethods()) {
                if (method2.getName().equals(str) && ((clsArr.length == 0 && method2.getParameterTypes().length == 0) || ClassListEqual(clsArr, method2.getParameterTypes()))) {
                    method2.setAccessible(true);
                    return method2;
                }
            }
        }
        return null;
    }

    public static Method getMethodSilent(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getMethod(cls, str, clsArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Method getMethodSilent(Class<?> cls, String[] strArr, Class<?>... clsArr) {
        try {
            return getMethod(cls, strArr, clsArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Method getMethodWithReturnTypeAndArgs(Class<?> cls, Class<?> cls2, Class<?>... clsArr) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getReturnType().equals(cls2) && ((clsArr.length == 0 && method.getParameterTypes().length == 0) || ClassListEqual(clsArr, method.getParameterTypes()))) {
                method.setAccessible(true);
                return method;
            }
        }
        for (Method method2 : cls.getMethods()) {
            if (method2.getReturnType().equals(cls2) && ((clsArr.length == 0 && method2.getParameterTypes().length == 0) || ClassListEqual(clsArr, method2.getParameterTypes()))) {
                method2.setAccessible(true);
                return method2;
            }
        }
        return null;
    }

    public static Method getMethodReturnWithException(Class<?> cls, Class<?> cls2) throws Exception {
        for (Method method : cls.getDeclaredMethods()) {
            if (cls2 == method.getReturnType()) {
                method.setAccessible(true);
                return method;
            }
        }
        for (Method method2 : cls.getMethods()) {
            if (cls2 == method2.getReturnType()) {
                method2.setAccessible(true);
                return method2;
            }
        }
        throw new Exception("Method Not Found");
    }

    public static Method getMethodReturn(Class<?> cls, Class<?> cls2) {
        try {
            return getMethodReturnWithException(cls, cls2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getMethodReturnSilent(Class<?> cls, Class<?> cls2) {
        try {
            return getMethodReturnWithException(cls, cls2);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Method> getAllMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Method method : cls.getDeclaredMethods()) {
                method.setAccessible(true);
                arrayList.add(method);
            }
            for (Method method2 : cls.getMethods()) {
                method2.setAccessible(true);
                arrayList.add(method2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static boolean ClassListEqual(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i] != clsArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static Class<?> getInnerClassWithException(Class<?> cls, String str) {
        for (Class<?> cls2 : cls.getDeclaredClasses()) {
            if (cls2.getSimpleName().equals(str)) {
                return cls2;
            }
        }
        return null;
    }

    public static Class<?> getInnerClass(Class<?> cls, String str) {
        try {
            return getInnerClassWithException(cls, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<?> getInnerClassSilent(Class<?> cls, String str) {
        try {
            return getInnerClassWithException(cls, str);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> Constructor<T> getConstructorWithException(Class<T> cls, Class<?>... clsArr) throws Exception {
        for (Object obj : cls.getDeclaredConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if ((clsArr.length == 0 && constructor.getParameterTypes().length == 0) || ClassListEqual(clsArr, constructor.getParameterTypes())) {
                constructor.setAccessible(true);
                return constructor;
            }
        }
        for (Object obj2 : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) obj2;
            if ((clsArr.length == 0 && constructor2.getParameterTypes().length == 0) || ClassListEqual(clsArr, constructor2.getParameterTypes())) {
                constructor2.setAccessible(true);
                return constructor2;
            }
        }
        throw new Exception("Constructor Not Found");
    }

    public static <T> Constructor<T> getConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            return getConstructorWithException(cls, clsArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Constructor<T> getConstructorSilent(Class<T> cls, Class<?>... clsArr) {
        try {
            return getConstructorWithException(cls, clsArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Enum<?> getEnum(String str, Class cls) {
        return Enum.valueOf(cls, str);
    }

    public static <E extends Enum<E>> E getEnum(int i, Class cls) {
        return (E) cls.getEnumConstants()[i];
    }

    public static Object newInstance(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            return null;
        }
    }
}

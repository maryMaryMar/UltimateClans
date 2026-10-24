package me.ulrich.clans.library.nbtapi.wrapper;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import me.ulrich.clans.library.nbtapi.NbtApiException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/DefaultMethodInvoker.class */
class DefaultMethodInvoker {
    private static Method invokeDefaultMethod;

    DefaultMethodInvoker() {
    }

    public static Object invokeDefault(Class<?> cls, Object obj, Method method, Object[] objArr) {
        if (invokeDefaultMethod != null) {
            try {
                return invokeDefaultMethod.invoke(null, obj, method, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new NbtApiException("Error while trying to invoke a default method for Java 9+. " + obj + " " + method + " " + Arrays.toString(objArr), e);
            }
        }
        try {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls)).in(cls).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        } catch (Throwable th) {
            throw new NbtApiException("Error while trying to invoke a default method for Java 8. " + obj + " " + method + " " + Arrays.toString(objArr), th);
        }
    }

    static {
        try {
            invokeDefaultMethod = InvocationHandler.class.getDeclaredMethod("invokeDefault", Object.class, Method.class, Object[].class);
            invokeDefaultMethod.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
        }
    }
}

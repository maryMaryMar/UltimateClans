package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/util/reflect/ReflectUtil.class */
public final class ReflectUtil {
    private static final Object UNSAFE;
    private static final MethodHandles.Lookup LOOKUP;
    private static final MethodHandle ALLOCATE_INSTANCE_HANDLE;
    private static final MethodType VOID_METHOD_TYPE = MethodType.methodType(Void.TYPE);
    private static final MethodType VIRTUAL_FIELD_SETTER = MethodType.methodType(Void.TYPE, Object.class, Object.class);

    private ReflectUtil() {
    }

    @NotNull
    public static Class<?> getClassOrThrow(String... strArr) {
        Class<?> optionalClass = getOptionalClass(strArr);
        if (optionalClass == null) {
            throw new IllegalStateException("Class with names either of " + String.join(", ", strArr) + " not found");
        }
        return optionalClass;
    }

    @Nullable
    public static Class<?> getOptionalClass(String... strArr) {
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
    public static Object getEnumInstance(@NotNull Class<?> cls, @NotNull String... strArr) {
        for (String str : strArr) {
            try {
                return Enum.valueOf(cls, str);
            } catch (IllegalArgumentException e) {
            }
        }
        throw new IllegalStateException("Enum " + cls.getName() + " instance with names either of " + String.join(",", strArr) + " not found");
    }

    @NotNull
    public static <T, V> FieldAccessor<T, V> findFieldUnchecked(@NotNull Class<?> cls, int i, @NotNull Class<?> cls2) {
        return findFieldUnchecked(cls, i, cls2, false);
    }

    @NotNull
    public static <T, V> FieldAccessor<T, V> findFieldUnchecked(@NotNull Class<?> cls, int i, @NotNull Class<?> cls2, boolean z) {
        int i2 = 0;
        for (Field field : cls.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) == z && field.getType() == cls2) {
                if (i2 == i) {
                    try {
                        return new FieldAccessor<>(LOOKUP.unreflectGetter(field), (z && Modifier.isFinal(field.getModifiers())) ? null : LOOKUP.unreflectSetter(field).asType(VIRTUAL_FIELD_SETTER));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("failed to unreflect field setter", e);
                    }
                }
                i2++;
            }
        }
        throw new IllegalStateException("couldn't find field with class " + cls2.getSimpleName() + " on " + cls.getSimpleName() + " at index " + i);
    }

    @Nullable
    public static <T> ConstructorAccessor<T> findOptionalConstructor(@NotNull Class<T> cls, @NotNull Class<?>... clsArr) {
        try {
            final MethodHandle methodHandleConvertToGeneric = convertToGeneric(LOOKUP.findConstructor(cls, MethodType.methodType((Class<?>) Void.TYPE, clsArr)));
            return new ConstructorAccessor<T>() { // from class: me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil.1
                @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ConstructorAccessor
                public T invoke(Object... objArr) {
                    try {
                        return (T) (Object) methodHandleConvertToGeneric.invokeExact(objArr);
                    } catch (Throwable th) {
                        throw new IllegalStateException("couldn't instantiate constructor", th);
                    }
                }
            };
        } catch (IllegalAccessException | NoSuchMethodException e) {
            return null;
        }
    }

    @NotNull
    public static <T> ConstructorAccessor<T> findConstructor(@NotNull Class<T> cls, @NotNull Class<?>... clsArr) {
        ConstructorAccessor<T> constructorAccessorFindOptionalConstructor = findOptionalConstructor(cls, clsArr);
        if (constructorAccessorFindOptionalConstructor == null) {
            throw new RuntimeException("Constructor for class " + cls.getName() + " not found");
        }
        return constructorAccessorFindOptionalConstructor;
    }

    @NotNull
    public static <T> ConstructorAccessor<T> getEmptyConstructor(@NotNull Class<T> cls) {
        try {
            MethodHandle methodHandleFindConstructor = LOOKUP.findConstructor(cls, VOID_METHOD_TYPE);
            return objArr -> {
                if (objArr.length != 0) {
                    throw new IllegalStateException("empty constructor expected no args, but got " + Arrays.toString(objArr));
                }
                try {
                    return (Object) methodHandleFindConstructor.invoke();
                } catch (Throwable th) {
                    throw new IllegalStateException("couldn't create packet instance", th);
                }
            };
        } catch (IllegalAccessException | NoSuchMethodException e) {
            return objArr2 -> {
                try {
                    return (Object) ALLOCATE_INSTANCE_HANDLE.invoke(UNSAFE, cls);
                } catch (Throwable th) {
                    throw new IllegalStateException("couldn't allocate packet instance using Unsafe", th);
                }
            };
        }
    }

    @NotNull
    public static MethodAccessor findMethod(@NotNull Class<?> cls, boolean z, @NotNull MethodType methodType, @NotNull String... strArr) {
        MethodAccessor methodAccessorFindOptionalMethod = findOptionalMethod(cls, z, methodType, strArr);
        if (methodAccessorFindOptionalMethod == null) {
            throw new RuntimeException("Method with the names either of " + String.join(",", strArr) + " for class " + cls.getName() + " not found");
        }
        return methodAccessorFindOptionalMethod;
    }

    @Nullable
    public static <T> MethodAccessor findOptionalMethod(@NotNull Class<T> cls, boolean z, @NotNull MethodType methodType, @NotNull String... strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("no method names passed");
        }
        for (String str : strArr) {
            try {
                return new MethodAccessor(convertToGeneric(z ? LOOKUP.findStatic(cls, str, methodType) : LOOKUP.findVirtual(cls, str, methodType)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
            }
        }
        return null;
    }

    @NotNull
    private static MethodHandle convertToGeneric(@NotNull MethodHandle methodHandle) {
        MethodHandle methodHandleAsFixedArity = methodHandle.asFixedArity();
        return methodHandleAsFixedArity.asSpreader(Object[].class, methodHandle.type().parameterCount()).asType(MethodType.genericMethodType(0, true));
    }

    public static boolean hasClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    static {
        MethodHandles.Lookup lookupInvoke;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            Field declaredField = Class.forName("sun.misc.Unsafe").getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            UNSAFE = declaredField.get(null);
            ALLOCATE_INSTANCE_HANDLE = lookup.findVirtual(UNSAFE.getClass(), "allocateInstance", MethodType.methodType((Class<?>) Object.class, (Class<?>) Class.class));
            try {
                MethodHandle methodHandleFindVirtual = lookup.findVirtual(UNSAFE.getClass(), "staticFieldOffset", MethodType.methodType((Class<?>) Long.TYPE, (Class<?>) Field.class));
                MethodHandle methodHandleFindVirtual2 = lookup.findVirtual(UNSAFE.getClass(), "staticFieldBase", MethodType.methodType((Class<?>) Object.class, (Class<?>) Field.class));
                MethodHandle methodHandleFindVirtual3 = lookup.findVirtual(UNSAFE.getClass(), "getObject", MethodType.methodType(Object.class, Object.class, Long.TYPE));
                Field declaredField2 = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupInvoke = (MethodHandles.Lookup) methodHandleFindVirtual3.invoke(UNSAFE, (Object) methodHandleFindVirtual2.invoke(UNSAFE, declaredField2), (long) methodHandleFindVirtual.invoke(UNSAFE, declaredField2));
            } catch (Throwable th) {
                th.printStackTrace();
                lookupInvoke = lookup;
            }
            LOOKUP = lookupInvoke;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}

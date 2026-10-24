package a.a.b.b;

import a.a.b.x;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a.class */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, a.a.b.h<?>> f3a;
    private final boolean b;
    private final List<x> c;
    private static byte[] __aes_key_zXLg0Mor = {(byte) 91, (byte) 106, (byte) 186, (byte) 190, (byte) 184, (byte) 167, (byte) 137, (byte) 143, (byte) 66, (byte) 248, (byte) 11, (byte) 151, (byte) 186, (byte) 192, (byte) 39, (byte) 158, (byte) 212, (byte) 253, (byte) 220, (byte) 10, (byte) 81, (byte) 113, (byte) 182, (byte) 150, (byte) 75, (byte) 42, (byte) 204, (byte) 237, (byte) 142, (byte) 126, (byte) 131, (byte) 122};
    private static byte[] __aes_iv_NdwQfX5D = {(byte) 13, (byte) 137, (byte) 195, (byte) 231, (byte) 159, (byte) 205, (byte) 75, (byte) 84, (byte) 252, (byte) 166, (byte) 143, (byte) 23, (byte) 174, (byte) 236, (byte) 242, (byte) 128};
    private static String __s_cache_lR1GlFGD_0;
    private static String __s_cache_mLknTjHv_1;
    private static String __s_cache_AM3Q3WVP_2;
    private static String __s_cache_iYU5HutU_3;
    private static String __s_cache_Kgao4qKL_4;
    private static String __s_cache_1FwRSjru_5;
    private static String __s_cache_grtcfnZU_6;
    private static String __s_cache_APmgl0I4_7;
    private static String __s_cache_v8yi97iw_8;
    private static String __s_cache_iE5sErdE_9;
    private static String __s_cache_mCG3FgjI_10;
    private static String __s_cache_QQEomcV3_11;
    private static String __s_cache_EaFcVM3V_12;
    private static String __s_cache_vH0VM1xr_13;
    private static String __s_cache_8daOBGgk_14;
    private static String __s_cache_s9kB34GK_15;
    private static String __s_cache_iKWLo24z_16;
    private static String __s_cache_oC4kiv81_17;
    private static String __s_cache_bkTtIpQA_18;
    private static String __s_cache_wYqQ1uVb_19;
    private static String __s_cache_ws6ZmL9A_20;
    private static String __s_cache_UuMy5NGT_21;
    private static String __s_cache_Vs1EMXtp_22;

    public a(Map<Type, a.a.b.h<?>> map, boolean z, List<x> list) {
        this.f3a = map;
        this.b = z;
        this.c = list;
    }

    static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + p.a("r8-abstract-class");
        }
        return null;
    }

    public <T> k<T> a(a.a.b.c.a<T> aVar) {
        return a((a.a.b.c.a) aVar, true);
    }

    public <T> k<T> a(a.a.b.c.a<T> aVar, boolean z) {
        Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        a.a.b.h<?> hVar = this.f3a.get(typeB);
        if (hVar != null) {
            return () -> {
                return hVar.a(typeB);
            };
        }
        a.a.b.h<?> hVar2 = this.f3a.get(clsA);
        if (hVar2 != null) {
            return () -> {
                return hVar2.a(typeB);
            };
        }
        k<T> kVarA = a(typeB, clsA);
        if (kVarA != null) {
            return kVarA;
        }
        x.a aVarA = n.a(this.c, clsA);
        k<T> kVarA2 = a(clsA, aVarA);
        if (kVarA2 != null) {
            return kVarA2;
        }
        k<T> kVarB = b(typeB, clsA);
        if (kVarB != null) {
            return kVarB;
        }
        String strA = a((Class<?>) clsA);
        if (strA != null) {
            return () -> {
                throw new a.a.b.m(strA);
            };
        }
        if (!z) {
            String str = "Unable to create instance of " + clsA + "; Register an InstanceCreator or a TypeAdapter for this type.";
            return () -> {
                throw new a.a.b.m(str);
            };
        }
        if (aVarA == x.a.f95a) {
            return c((Class) clsA);
        }
        String str2 = "Unable to create instance of " + clsA + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return () -> {
            throw new a.a.b.m(str2);
        };
    }

    private static <T> k<T> a(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return () -> {
                if (!(type instanceof ParameterizedType)) {
                    throw new a.a.b.m("Invalid EnumSet type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new a.a.b.m("Invalid EnumSet type: " + type.toString());
            };
        }
        if (cls == EnumMap.class) {
            return () -> {
                if (!(type instanceof ParameterizedType)) {
                    throw new a.a.b.m("Invalid EnumMap type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new a.a.b.m("Invalid EnumMap type: " + type.toString());
            };
        }
        return null;
    }

    private static <T> k<T> a(Class<? super T> cls, x.a aVar) {
        String strB;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (aVar == x.a.f95a || (n.a(declaredConstructor, (Object) null) && (aVar != x.a.d || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (aVar != x.a.f95a || (strB = a.a.b.b.b.a.b(declaredConstructor)) == null) ? () -> {
                    try {
                        return declaredConstructor.newInstance(new Object[0]);
                    } catch (IllegalAccessException e) {
                        throw a.a.b.b.b.a.a(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke constructor '" + a.a.b.b.b.a.a((Constructor<?>) declaredConstructor) + "' with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke constructor '" + a.a.b.b.b.a.a((Constructor<?>) declaredConstructor) + "' with no args", e3.getCause());
                    }
                } : () -> {
                    throw new a.a.b.m(strB);
                };
            }
            String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return () -> {
                throw new a.a.b.m(str);
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static <T> k<T> b(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return (k<T>) b((Class<?>) cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return (k<T>) c(type, cls);
        }
        return null;
    }

    private static k<? extends Collection<? extends Object>> b(Class<?> cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return () -> {
                return new ArrayList();
            };
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return () -> {
                return new LinkedHashSet();
            };
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return () -> {
                return new TreeSet();
            };
        }
        if (cls.isAssignableFrom(ArrayDeque.class)) {
            return () -> {
                return new ArrayDeque();
            };
        }
        return null;
    }

    private static boolean a(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return true;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        return actualTypeArguments.length != 0 && d.e(actualTypeArguments[0]) == String.class;
    }

    private static k<? extends Map<? extends Object, Object>> c(Type type, Class<?> cls) {
        if (cls.isAssignableFrom(h.class) && a(type)) {
            return () -> {
                return new h();
            };
        }
        if (cls.isAssignableFrom(LinkedHashMap.class)) {
            return () -> {
                return new LinkedHashMap();
            };
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return () -> {
                return new TreeMap();
            };
        }
        if (cls.isAssignableFrom(ConcurrentHashMap.class)) {
            return () -> {
                return new ConcurrentHashMap();
            };
        }
        if (cls.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return () -> {
                return new ConcurrentSkipListMap();
            };
        }
        return null;
    }

    private <T> k<T> c(Class<? super T> cls) {
        if (this.b) {
            return () -> {
                try {
                    return q.f71a.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
                }
            };
        }
        String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        String str2 = str;
        return () -> {
            throw new a.a.b.m(str2);
        };
    }

    public String toString() {
        return this.f3a.toString();
    }

    private static String __unused_2022() {
        return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
    }

    private static String __unused_2023() {
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: ";
    }

    private static String __unused_2024() {
        return "\nSee ";
    }

    private static String __unused_2025() {
        return "r8-abstract-class";
    }

    private static String __unused_2026() {
        return "Unable to create instance of ";
    }

    private static String __unused_2027() {
        return "; Register an InstanceCreator or a TypeAdapter for this type.";
    }

    private static String __unused_2028() {
        return "Unable to create instance of ";
    }

    private static String __unused_2029() {
        return "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
    }

    private static String __unused_2030() {
        return "Unable to invoke no-args constructor of ";
    }

    private static String __unused_2031() {
        return "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
    }

    private static String __unused_2032() {
        return "Unable to create instance of ";
    }

    private static String __unused_2033() {
        return "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
    }

    private static String __unused_2034() {
        return " Or adjust your R8 configuration to keep the no-args constructor of the class.";
    }

    private static String __unused_2035() {
        return "Unable to create instance of ";
    }

    private static String __unused_2036() {
        return ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.";
    }

    private static String __unused_2037() {
        return "Failed to invoke constructor '";
    }

    private static String __unused_2038() {
        return "' with no args";
    }

    private static String __unused_2039() {
        return "Failed to invoke constructor '";
    }

    private static String __unused_2040() {
        return "' with no args";
    }

    private static String __unused_2041() {
        return "Invalid EnumMap type: ";
    }

    private static String __unused_2042() {
        return "Invalid EnumMap type: ";
    }

    private static String __unused_2043() {
        return "Invalid EnumSet type: ";
    }

    private static String __unused_2044() {
        return "Invalid EnumSet type: ";
    }
}

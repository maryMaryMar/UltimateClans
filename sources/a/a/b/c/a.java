package a.a.b.c;

import a.a.b.b.d;
import a.a.b.b.p;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/c/a.class */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? super T> f73a;
    private final Type b;
    private final int c;
    private static byte[] __aes_key_nticZNjd = {(byte) 206, (byte) 77, (byte) 43, (byte) 35, (byte) 54, (byte) 196, (byte) 117, (byte) 182, (byte) 185, (byte) 41, (byte) 193, (byte) 158, (byte) 142, (byte) 3, (byte) 226, (byte) 64, (byte) 160, (byte) 77, (byte) 22, (byte) 16, (byte) 137, (byte) 164, (byte) 129, (byte) 228, (byte) 184, (byte) 153, (byte) 60, (byte) 14, (byte) 209, (byte) 103, (byte) 244, (byte) 66};
    private static byte[] __aes_iv_O9PBGlWz = {(byte) 54, (byte) 141, (byte) 37, (byte) 131, (byte) 8, (byte) 210, (byte) 51, (byte) 112, (byte) 237, (byte) 146, (byte) 237, (byte) 90, (byte) 168, (byte) 149, (byte) 110, (byte) 133};
    private static String __s_cache_Lgo4Jw56_0;
    private static String __s_cache_9IpvEmXA_1;
    private static String __s_cache_MpCe0uNg_2;
    private static String __s_cache_zI5JtmSl_3;
    private static String __s_cache_85KEqCvd_4;
    private static String __s_cache_UyEEglH9_5;
    private static String __s_cache_cKIf8Ird_6;
    private static String __s_cache_PaBhUWWT_7;
    private static String __s_cache_QcVNxDCC_8;
    private static String __s_cache_FDQwKR4z_9;
    private static String __s_cache_9Q38RTAO_10;
    private static String __s_cache_ANQroNWt_11;
    private static String __s_cache_JTfKeFWv_12;
    private static String __s_cache_qikY8uS5_13;
    private static String __s_cache_YBlitOpa_14;
    private static String __s_cache_JfxvZC3s_15;
    private static String __s_cache_JIeRkw8A_16;
    private static String __s_cache_RpFqQ9vI_17;
    private static String __s_cache_HLIAgFYL_18;
    private static String __s_cache_QSPSD6n7_19;
    private static String __s_cache_OkQKvCkv_20;
    private static String __s_cache_izcFHegx_21;
    private static String __s_cache_NDLPNMb2_22;

    protected a() {
        this.b = d();
        this.f73a = (Class<? super T>) d.e(this.b);
        this.c = this.b.hashCode();
    }

    private a(Type type) {
        this.b = d.d((Type) Objects.requireNonNull(type));
        this.f73a = (Class<? super T>) d.e(this.b);
        this.c = this.b.hashCode();
    }

    private static boolean c() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    private Type d() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                Type typeD = d.d(parameterizedType.getActualTypeArguments()[0]);
                if (c()) {
                    d(typeD);
                }
                return typeD;
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + p.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    private static void d(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + p.a("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            d(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                d(ownerType);
            }
            for (Type type2 : parameterizedType.getActualTypeArguments()) {
                d(type2);
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type3 : wildcardType.getLowerBounds()) {
            d(type3);
        }
        for (Type type4 : wildcardType.getUpperBounds()) {
            d(type4);
        }
    }

    public final Class<? super T> a() {
        return this.f73a;
    }

    public final Type b() {
        return this.b;
    }

    @Deprecated
    public boolean a(Class<?> cls) {
        return a((Type) cls);
    }

    @Deprecated
    public boolean a(Type type) {
        if (type == null) {
            return false;
        }
        if (this.b.equals(type)) {
            return true;
        }
        if (this.b instanceof Class) {
            return this.f73a.isAssignableFrom(d.e(type));
        }
        if (this.b instanceof ParameterizedType) {
            return a(type, (ParameterizedType) this.b, (Map<String, Type>) new HashMap());
        }
        if (this.b instanceof GenericArrayType) {
            return this.f73a.isAssignableFrom(d.e(type)) && a(type, (GenericArrayType) this.b);
        }
        throw a(this.b, (Class<?>[]) new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    @Deprecated
    public boolean a(a<?> aVar) {
        return a(aVar.b());
    }

    private static boolean a(Type type, GenericArrayType genericArrayType) {
        Class<?> cls;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        Type genericComponentType2 = type;
        if (type instanceof GenericArrayType) {
            genericComponentType2 = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            Class<?> componentType = (Class) type;
            while (true) {
                cls = componentType;
                if (!cls.isArray()) {
                    break;
                }
                componentType = cls.getComponentType();
            }
            genericComponentType2 = cls;
        }
        return a(genericComponentType2, (ParameterizedType) genericComponentType, (Map<String, Type>) new HashMap());
    }

    private static boolean a(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> clsE = d.e(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeParameters = clsE.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable<Class<?>> typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (a(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type type3 : clsE.getGenericInterfaces()) {
            if (a(type3, parameterizedType, (Map<String, Type>) new HashMap(map))) {
                return true;
            }
        }
        return a(clsE.getGenericSuperclass(), parameterizedType, (Map<String, Type>) new HashMap(map));
    }

    private static boolean a(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!a(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    private static IllegalArgumentException a(Type type, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("Unsupported type, expected one of: ");
        for (Class<?> cls : clsArr) {
            sb.append(cls.getName()).append(", ");
        }
        sb.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString());
        return new IllegalArgumentException(sb.toString());
    }

    private static boolean a(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && d.a(this.b, ((a) obj).b);
    }

    public final String toString() {
        return d.f(this.b);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> a(Type type, Type... typeArr) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArr);
        if (!(type instanceof Class)) {
            throw new IllegalArgumentException("rawType must be of type Class, but was " + type);
        }
        Class cls = (Class) type;
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        int length = typeParameters.length;
        int length2 = typeArr.length;
        if (length2 != length) {
            throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        if (typeArr.length == 0) {
            return b(cls);
        }
        if (d.i(type)) {
            throw new IllegalArgumentException("Raw type " + cls.getName() + " is not supported because it requires specifying an owner type");
        }
        for (int i = 0; i < length; i++) {
            Type type2 = (Type) Objects.requireNonNull(typeArr[i], "Type argument must not be null");
            Class<?> clsE = d.e(type2);
            TypeVariable<Class<T>> typeVariable = typeParameters[i];
            for (Type type3 : typeVariable.getBounds()) {
                if (!d.e(type3).isAssignableFrom(clsE)) {
                    throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
                }
            }
        }
        return new a<>(d.a((Type) null, (Class<?>) cls, typeArr));
    }

    public static a<?> c(Type type) {
        return new a<>(d.a(type));
    }

    private static String __unused_2053() {
        return "gson.allowCapturingTypeVariables";
    }

    private static String __unused_2054() {
        return "true";
    }

    private static String __unused_2055() {
        return "TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee ";
    }

    private static String __unused_2056() {
        return "type-token-raw";
    }

    private static String __unused_2057() {
        return "Must only create direct subclasses of TypeToken";
    }

    private static String __unused_2058() {
        return "TypeToken type argument must not contain a type variable; captured type variable ";
    }

    private static String __unused_2059() {
        return " declared by ";
    }

    private static String __unused_2060() {
        return "\nSee ";
    }

    private static String __unused_2061() {
        return "typetoken-type-variable";
    }

    private static String __unused_2062() {
        return "TypeToken captured `null` as type argument; probably a compiler / runtime bug";
    }

    private static String __unused_2063() {
        return "Unsupported type, expected one of: ";
    }

    private static String __unused_2064() {
        return ", ";
    }

    private static String __unused_2065() {
        return "but got: ";
    }

    private static String __unused_2066() {
        return ", for type token: ";
    }

    private static String __unused_2067() {
        return "rawType must be of type Class, but was ";
    }

    private static String __unused_2068() {
        return " requires ";
    }

    private static String __unused_2069() {
        return " type arguments, but got ";
    }

    private static String __unused_2070() {
        return "Raw type ";
    }

    private static String __unused_2071() {
        return " is not supported because it requires specifying an owner type";
    }

    private static String __unused_2072() {
        return "Type argument must not be null";
    }

    private static String __unused_2073() {
        return "Type argument ";
    }

    private static String __unused_2074() {
        return " does not satisfy bounds for type variable ";
    }

    private static String __unused_2075() {
        return " declared by ";
    }
}

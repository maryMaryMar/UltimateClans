package a.a.b.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/d.class */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f53a;
    static final /* synthetic */ boolean b;
    private static byte[] __aes_key_HDhHdgdm = {(byte) 2, (byte) 156, (byte) 81, (byte) 154, (byte) 219, (byte) 239, (byte) 65, (byte) 56, (byte) 117, (byte) 122, (byte) 206, (byte) 221, (byte) 32, (byte) 122, (byte) 203, (byte) 116, (byte) 159, (byte) 242, (byte) 171, (byte) 113, (byte) 142, (byte) 226, (byte) 35, (byte) 49, (byte) 173, (byte) 29, (byte) 90, (byte) 64, (byte) 67, (byte) 158, (byte) 223, (byte) 147};
    private static byte[] __aes_iv_ZmtRQCF5 = {(byte) 20, (byte) 157, (byte) 35, (byte) 192, (byte) 44, (byte) 132, (byte) 52, (byte) 14, (byte) 20, (byte) 19, (byte) 16, (byte) 140, (byte) 253, (byte) 160, (byte) 73, (byte) 21};
    private static String __s_cache_EaVVZf8M_0;
    private static String __s_cache_lEFeaujG_1;
    private static String __s_cache_dkPUrHnd_2;
    private static String __s_cache_keNT8bww_3;
    private static String __s_cache_oEg73Tv6_4;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/d$a.class */
    private static final class a implements Serializable, GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f54a;
        private static final long b = 0;
        private static byte[] __aes_key_Ec5GaRQW = {(byte) 174, (byte) 204, (byte) 145, (byte) 121, (byte) 149, (byte) 79, (byte) 116, (byte) 248, (byte) 203, (byte) 29, (byte) 129, (byte) 234, (byte) 126, (byte) 143, (byte) 224, (byte) 139, (byte) 22, (byte) 108, (byte) 5, (byte) 82, (byte) 160, (byte) 235, (byte) 184, (byte) 56, (byte) 233, (byte) 214, (byte) 17, (byte) 94, (byte) 211, (byte) 32, (byte) 31, (byte) 46};
        private static byte[] __aes_iv_l4Xal6Nq = {(byte) 30, (byte) 70, (byte) 77, (byte) 189, (byte) 85, (byte) 65, (byte) 105, (byte) 228, (byte) 138, (byte) 161, (byte) 216, (byte) 97, (byte) 143, (byte) 119, (byte) 10, (byte) 252};
        private static String __s_cache_qxd2ZxWF_0;

        a(Type type) {
            Objects.requireNonNull(type);
            this.f54a = d.d(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f54a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && d.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return this.f54a.hashCode();
        }

        public String toString() {
            return d.f(this.f54a) + "[]";
        }

        private static String __unused_1984() {
        return "[]";
    }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/d$b.class */
    private static final class b implements Serializable, ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f55a;
        private final Type b;
        private final Type[] c;
        private static final long d = 0;
        private static byte[] __aes_key_Q7q9OXWo = {(byte) 247, (byte) 187, (byte) 184, (byte) 58, (byte) 38, (byte) 205, (byte) 195, (byte) 140, (byte) 239, (byte) 111, (byte) 103, (byte) 15, (byte) 137, (byte) 56, (byte) 207, (byte) 141, (byte) 155, (byte) 95, (byte) 14, (byte) 207, (byte) 113, (byte) 178, (byte) 63, (byte) 85, (byte) 231, (byte) 13, (byte) 113, (byte) 164, (byte) 206, (byte) 149, (byte) 221, (byte) 38};
        private static byte[] __aes_iv_kUD2liTc = {(byte) 44, (byte) 53, (byte) 36, (byte) 72, (byte) 140, (byte) 202, (byte) 31, (byte) 176, (byte) 169, (byte) 159, (byte) 115, (byte) 194, (byte) 207, (byte) 1, (byte) 107, (byte) 18};
        private static String __s_cache_LiXENV6K_0;
        private static String __s_cache_leGDaH32_1;
        private static String __s_cache_QTkKdWaJ_2;
        private static String __s_cache_nj5MHsDr_3;

        b(Type type, Class<?> cls, Type... typeArr) {
            Objects.requireNonNull(cls);
            if (type == null && d.i(cls)) {
                throw new IllegalArgumentException("Must specify owner type for " + cls);
            }
            this.f55a = type == null ? null : d.d(type);
            this.b = d.d(cls);
            this.c = (Type[]) typeArr.clone();
            int length = this.c.length;
            for (int i = 0; i < length; i++) {
                Objects.requireNonNull(this.c[i]);
                d.h(this.c[i]);
                this.c[i] = d.d(this.c[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f55a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && d.a((Type) this, (Type) obj);
        }

        private static int a(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ a(this.f55a);
        }

        public String toString() {
            int length = this.c.length;
            if (length == 0) {
                return d.f(this.b);
            }
            StringBuilder sb = new StringBuilder(30 * (length + 1));
            sb.append(d.f(this.b)).append(__getString_Q4bHtw02_1()).append(d.f(this.c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(__getString_pPuP1Bry_2()).append(d.f(this.c[i]));
            }
            return sb.append(__getString_gUSwEdHp_3()).toString();
        }

        private static String __unused_1985() {
        return "Must specify owner type for ";
    }

        private static String __getString_Q4bHtw02_1() {
        return "<";
    }

        private static String __getString_pPuP1Bry_2() {
        return ", ";
    }

        private static String __getString_gUSwEdHp_3() {
        return ">";
    }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/d$c.class */
    private static final class c implements Serializable, WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f56a;
        private final Type b;
        private static final long c = 0;
        private static byte[] __aes_key_Wm6KxEwF = {(byte) 230, (byte) 110, (byte) 222, (byte) 77, (byte) 116, (byte) 178, (byte) 158, (byte) 140, (byte) 194, (byte) 230, (byte) 87, (byte) 29, (byte) 79, (byte) 228, (byte) 7, (byte) 123, (byte) 0, (byte) 20, (byte) 215, (byte) 113, (byte) 224, (byte) 161, (byte) 111, (byte) 221, (byte) 72, (byte) 85, (byte) 177, (byte) 211, (byte) 47, (byte) 1, (byte) 50, (byte) 150};
        private static byte[] __aes_iv_chruCh1J = {(byte) 134, (byte) 154, (byte) 120, (byte) 93, (byte) 50, (byte) 27, (byte) 89, (byte) 212, (byte) 95, (byte) 213, (byte) 126, (byte) 159, (byte) 69, (byte) 252, (byte) 32, (byte) 212};
        private static String __s_cache_nFZ04ROg_0;
        private static String __s_cache_HWMPJvRV_1;
        private static String __s_cache_GZtxTssq_2;
        private static String __s_cache_Fwix6Mkc_3;
        private static String __s_cache_9CimWIcm_4;
        private static String __s_cache_ClJnwNFv_5;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException("At most one lower bound is supported");
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException(__getString_A5CaIcq8_1());
            }
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                d.h(typeArr[0]);
                this.b = null;
                this.f56a = d.d(typeArr[0]);
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            d.h(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException(__getString_nIhGAu0d_2());
            }
            this.b = d.d(typeArr2[0]);
            this.f56a = Object.class;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f56a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return this.b != null ? new Type[]{this.b} : d.f53a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && d.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (this.b != null ? 31 + this.b.hashCode() : 1) ^ (31 + this.f56a.hashCode());
        }

        public String toString() {
            if (this.b != null) {
                return __getString_HrBtRFAL_3() + d.f(this.b);
            }
            return this.f56a == Object.class ? __getString_xEO7DFE6_4() : __getString_LQShxbfk_5() + d.f(this.f56a);
        }

        private static String __unused_1986() {
        return "At most one lower bound is supported";
    }

        private static String __getString_A5CaIcq8_1() {
        return "Exactly one upper bound must be specified";
    }

        private static String __getString_nIhGAu0d_2() {
        return "When lower bound is specified, upper bound must be Object";
    }

        private static String __getString_HrBtRFAL_3() {
        return "? super ";
    }

        private static String __getString_xEO7DFE6_4() {
        return "?";
    }

        private static String __getString_LQShxbfk_5() {
        return "? extends ";
    }
    }

    private d() {
        throw new UnsupportedOperationException();
    }

    public static ParameterizedType a(Type type, Class<?> cls, Type... typeArr) {
        return new b(type, cls, typeArr);
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static WildcardType b(Type type) {
        return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f53a);
    }

    public static WildcardType c(Type type) {
        return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(d(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (!(type instanceof WildcardType)) {
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (b || upperBounds.length == 1) {
            return e(upperBounds[0]);
        }
        throw new AssertionError();
    }

    private static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return Objects.equals(typeVariable.getGenericDeclaration(), typeVariable2.getGenericDeclaration()) && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    private static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (!b && upperBounds.length != 1) {
                throw new AssertionError();
            }
            type = upperBounds[0];
        }
        if (cls2.isAssignableFrom(cls)) {
            return a(type, cls, a(type, cls, cls2));
        }
        throw new IllegalArgumentException(cls + " is not the same as or a subtype of " + cls2);
    }

    public static Type g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Type a(Type type, Class<?> cls) {
        Type typeB = b(type, cls, Collection.class);
        return typeB instanceof ParameterizedType ? ((ParameterizedType) typeB).getActualTypeArguments()[0] : Object.class;
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (Properties.class.isAssignableFrom(cls)) {
            return new Type[]{String.class, String.class};
        }
        Type typeB = b(type, cls, Map.class);
        return typeB instanceof ParameterizedType ? ((ParameterizedType) typeB).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashMap());
    }

    /* JADX WARN: Code duplicated, block: B:71:0x01e7 A[EDGE_INSN: B:71:0x01e7->B:72:0x01ed BREAK  A[LOOP:0: B:3:0x0003->B:80:?]] */
    private static Type a(Type type, Class<?> cls, Type type2, Map<TypeVariable<?>, Type> map) {
        Type typeA;
        TypeVariable<?> typeVariable;
        TypeVariable<?> typeVariable2 = null;
        do {
            if (!(type2 instanceof TypeVariable)) {
                if (!(type2 instanceof Class) || !((Class) type2).isArray()) {
                    if (!(type2 instanceof GenericArrayType)) {
                        if (!(type2 instanceof ParameterizedType)) {
                            if (!(type2 instanceof WildcardType)) {
                                break;
                            }
                            WildcardType wildcardType = (WildcardType) type2;
                            Type[] lowerBounds = wildcardType.getLowerBounds();
                            Type[] upperBounds = wildcardType.getUpperBounds();
                            if (lowerBounds.length != 1) {
                                if (upperBounds.length == 1 && (typeA = a(type, cls, upperBounds[0], map)) != upperBounds[0]) {
                                    type2 = b(typeA);
                                    break;
                                }
                                type2 = wildcardType;
                                break;
                            }
                            Type typeA2 = a(type, cls, lowerBounds[0], map);
                            if (typeA2 == lowerBounds[0]) {
                                type2 = wildcardType;
                                break;
                            }
                            type2 = c(typeA2);
                            break;
                        }
                        ParameterizedType parameterizedType = (ParameterizedType) type2;
                        Type ownerType = parameterizedType.getOwnerType();
                        Type typeA3 = a(type, cls, ownerType, map);
                        boolean z = !a((Object) typeA3, (Object) ownerType);
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        boolean z2 = false;
                        int length = actualTypeArguments.length;
                        for (int i = 0; i < length; i++) {
                            Type typeA4 = a(type, cls, actualTypeArguments[i], map);
                            if (!a((Object) typeA4, (Object) actualTypeArguments[i])) {
                                if (!z2) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z2 = true;
                                }
                                actualTypeArguments[i] = typeA4;
                            }
                        }
                        type2 = (z || z2) ? a(typeA3, (Class<?>) parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                        break;
                    }
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeA5 = a(type, cls, genericComponentType, map);
                    type2 = a((Object) genericComponentType, (Object) typeA5) ? genericArrayType : a(typeA5);
                    break;
                }
                Class cls2 = (Class) type2;
                Class<?> componentType = cls2.getComponentType();
                Type typeA6 = a(type, cls, componentType, map);
                type2 = a((Object) componentType, (Object) typeA6) ? cls2 : a(typeA6);
                break;
            }
            typeVariable = (TypeVariable) type2;
            Type type3 = map.get(typeVariable);
            if (type3 != null) {
                return type3 == Void.TYPE ? type2 : type3;
            }
            map.put(typeVariable, Void.TYPE);
            if (typeVariable2 == null) {
                typeVariable2 = typeVariable;
            }
            type2 = a(type, cls, typeVariable);
        } while (type2 != typeVariable);
        if (typeVariable2 != null) {
            map.put(typeVariable2, type2);
        }
        return type2;
    }

    private static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsA = a(typeVariable);
        if (clsA == null) {
            return typeVariable;
        }
        Type typeA = a(type, cls, clsA);
        if (!(typeA instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeA).getActualTypeArguments()[a((Object[]) clsA.getTypeParameters(), (Object) typeVariable)];
    }

    private static int a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void h(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Primitive type is not allowed");
        }
    }

    public static boolean i(Type type) {
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) type;
        return (Modifier.isStatic(cls.getModifiers()) || cls.getDeclaringClass() == null) ? false : true;
    }

    static {
        b = !d.class.desiredAssertionStatus();
        f53a = new Type[0];
    }

    private static String __unused_1987() {
        return "null";
    }

    private static String __unused_1988() {
        return "Expected a Class, ParameterizedType, or GenericArrayType, but <";
    }

    private static String __unused_1989() {
        return "> is of type ";
    }

    private static String __unused_1990() {
        return " is not the same as or a subtype of ";
    }

    private static String __unused_1991() {
        return "Primitive type is not allowed";
    }
}

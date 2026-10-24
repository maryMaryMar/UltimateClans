package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import a.a.b.InterfaceC0011d;
import a.a.b.v;
import a.a.b.x;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/l.class */
public final class l implements C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.b.b.a f24a;
    private final InterfaceC0011d b;
    private final a.a.b.b.b c;
    private final a.a.b.b.a.e d;
    private final List<x> e;
    private static byte[] __aes_key_whMfGGP4 = {(byte) 161, (byte) 33, (byte) 79, (byte) 191, (byte) 88, (byte) 177, (byte) 33, (byte) 26, (byte) 59, (byte) 195, (byte) 183, (byte) 220, (byte) 88, (byte) 153, (byte) 96, (byte) 24, (byte) 102, (byte) 193, (byte) 174, (byte) 2, (byte) 76, (byte) 42, (byte) 226, (byte) 143, (byte) 132, (byte) 165, (byte) 36, (byte) 141, (byte) 197, (byte) 149, (byte) 105, (byte) 65};
    private static byte[] __aes_iv_uW0lNy3P = {(byte) 214, (byte) 190, (byte) 74, (byte) 150, (byte) 99, (byte) 210, (byte) 134, (byte) 147, (byte) 162, (byte) 228, (byte) 162, (byte) 75, (byte) 35, (byte) 217, (byte) 223, (byte) 144};
    private static String __s_cache_aDg6PWip_0;
    private static String __s_cache_6BuKAzFY_1;
    private static String __s_cache_HCdzQdfV_2;
    private static String __s_cache_rJ1RP68o_3;
    private static String __s_cache_6qhFLLtT_4;
    private static String __s_cache_aYxfmCda_5;
    private static String __s_cache_h4QXK0of_6;
    private static String __s_cache_YcyH8iVu_7;
    private static String __s_cache_ANkHbZHj_8;
    private static String __s_cache_spX0TSbF_9;
    private static String __s_cache_dwLXXxvp_10;
    private static String __s_cache_uQIzXx8b_11;
    private static String __s_cache_tNl21fAr_12;
    private static String __s_cache_gD3sFu3H_13;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/l$a.class */
    public static abstract class a<T, A> extends B<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f27a;

        a(d dVar) {
            this.f27a = dVar;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, T t) throws IOException {
            if (t == null) {
                dVar.f();
                return;
            }
            dVar.d();
            try {
                Iterator<b> it = this.f27a.c.iterator();
                while (it.hasNext()) {
                    it.next().a(dVar, t);
                }
                dVar.e();
            } catch (IllegalAccessException e) {
                throw a.a.b.b.b.a.a(e);
            }
        }

        @Override // a.a.b.B
        public T b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            A a2 = a();
            Map<String, b> map = this.f27a.b;
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = map.get(aVar.g());
                    if (bVar == null) {
                        aVar.o();
                    } else {
                        a(a2, aVar, bVar);
                    }
                }
                aVar.d();
                return c(a2);
            } catch (IllegalAccessException e) {
                throw a.a.b.b.b.a.a(e);
            } catch (IllegalStateException e2) {
                throw new v(e2);
            }
        }

        abstract A a();

        abstract void a(A a2, a.a.b.d.a aVar, b bVar);

        abstract T c(A a2);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/l$b.class */
    static abstract class b {
        final String h;
        final Field i;
        final String j;

        protected b(String str, Field field) {
            this.h = str;
            this.i = field;
            this.j = field.getName();
        }

        abstract void a(a.a.b.d.d dVar, Object obj);

        abstract void a(a.a.b.d.a aVar, int i, Object[] objArr);

        abstract void a(a.a.b.d.a aVar, Object obj);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/l$c.class */
    private static final class c<T> extends a<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a.a.b.b.k<T> f28a;

        c(a.a.b.b.k<T> kVar, d dVar) {
            super(dVar);
            this.f28a = kVar;
        }

        @Override // a.a.b.b.a.l.a
        T a() {
            return this.f28a.construct();
        }

        @Override // a.a.b.b.a.l.a
        void a(T t, a.a.b.d.a aVar, b bVar) {
            bVar.a(aVar, t);
        }

        @Override // a.a.b.b.a.l.a
        T c(T t) {
            return t;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/l$d.class */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f29a = new d(Collections.emptyMap(), Collections.emptyList());
        final Map<String, b> b;
        final List<b> c;

        d(Map<String, b> map, List<b> list) {
            this.b = map;
            this.c = list;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/l$e.class */
    private static final class e<T> extends a<T, Object[]> {
        private final Constructor<T> b;
        private final Object[] c;
        private final Map<String, Integer> d;
        private static String __s_cache_EuOdPNjM_0;
        private static String __s_cache_hmArdhOE_1;
        private static String __s_cache_3iVuSbWt_2;
        private static String __s_cache_KTj0UNX9_3;
        private static String __s_cache_ikacE5H3_4;
        private static String __s_cache_NwqaWDVA_5;
        private static String __s_cache_8WBob9NZ_6;
        private static byte[] __aes_key_Lg5J2QG2 = {(byte) 3, (byte) 40, (byte) 8, (byte) 129, (byte) 214, (byte) 0, (byte) 49, (byte) 56, (byte) 93, (byte) 70, (byte) 228, (byte) 93, (byte) 217, (byte) 232, (byte) 211, (byte) 63, (byte) 65, (byte) 229, (byte) 53, (byte) 250, (byte) 103, (byte) 233, (byte) 123, (byte) 67, (byte) 39, (byte) 35, (byte) 199, (byte) 22, (byte) 165, (byte) 147, (byte) 79, (byte) 133};
        private static byte[] __aes_iv_SJO59z17 = {(byte) 214, (byte) 209, (byte) 234, (byte) 148, (byte) 30, (byte) 54, (byte) 175, (byte) 136, (byte) 182, (byte) 15, (byte) 121, (byte) 108, (byte) 239, (byte) 74, (byte) 22, (byte) 189};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Map<Class<?>, Object> f30a = d();

        e(Class<T> cls, d dVar, boolean z) {
            super(dVar);
            this.d = new HashMap();
            this.b = a.a.b.b.b.a.e(cls);
            if (z) {
                l.b(null, this.b);
            } else {
                a.a.b.b.b.a.a(this.b);
            }
            String[] strArrD = a.a.b.b.b.a.d(cls);
            for (int i = 0; i < strArrD.length; i++) {
                this.d.put(strArrD[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.b.getParameterTypes();
            this.c = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                this.c[i2] = f30a.get(parameterTypes[i2]);
            }
        }

        private static Map<Class<?>, Object> d() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, false);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a.a.b.b.a.l.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object[] a() {
            return (Object[]) this.c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a.a.b.b.a.l.a
        public void a(Object[] objArr, a.a.b.d.a aVar, b bVar) {
            Integer num = this.d.get(bVar.j);
            if (num == null) {
                throw new IllegalStateException("Could not find the index in the constructor '" + a.a.b.b.b.a.a((Constructor<?>) this.b) + __getString_6wObqLuM_1() + bVar.j + __getString_VDw1BYyk_2());
            }
            bVar.a(aVar, num.intValue(), objArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a.a.b.b.a.l.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public T c(Object[] objArr) {
            try {
                return this.b.newInstance(objArr);
            } catch (IllegalAccessException e) {
                throw a.a.b.b.b.a.a(e);
            } catch (IllegalArgumentException | InstantiationException e2) {
                throw new RuntimeException(__getString_72J1VHqu_3() + a.a.b.b.b.a.a((Constructor<?>) this.b) + __getString_lBtee0vk_4() + Arrays.toString(objArr), e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(__getString_XdYwuKlM_5() + a.a.b.b.b.a.a((Constructor<?>) this.b) + __getString_OpHsYUuV_6() + Arrays.toString(objArr), e3.getCause());
            }
        }

        private static String __unused_2137() {
        return "Could not find the index in the constructor '";
    }

        private static String __getString_6wObqLuM_1() {
        return "' for field with name '";
    }

        private static String __getString_VDw1BYyk_2() {
        return "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.";
    }

        private static String __getString_72J1VHqu_3() {
        return "Failed to invoke constructor '";
    }

        private static String __getString_lBtee0vk_4() {
        return "' with args ";
    }

        private static String __getString_XdYwuKlM_5() {
        return "Failed to invoke constructor '";
    }

        private static String __getString_OpHsYUuV_6() {
        return "' with args ";
    }
    }

    public l(a.a.b.b.a aVar, InterfaceC0011d interfaceC0011d, a.a.b.b.b bVar, a.a.b.b.a.e eVar, List<x> list) {
        this.f24a = aVar;
        this.b = interfaceC0011d;
        this.c = bVar;
        this.d = eVar;
        this.e = list;
    }

    private boolean a(Field field, boolean z) {
        return !this.c.a(field, z);
    }

    private List<String> a(Field field) {
        String strA;
        List<String> listAsList;
        a.a.b.a.c cVar = (a.a.b.a.c) field.getAnnotation(a.a.b.a.c.class);
        if (cVar == null) {
            strA = this.b.a(field);
            listAsList = this.b.b(field);
        } else {
            strA = cVar.a();
            listAsList = Arrays.asList(cVar.b());
        }
        if (listAsList.isEmpty()) {
            return Collections.singletonList(strA);
        }
        ArrayList arrayList = new ArrayList(listAsList.size() + 1);
        arrayList.add(strA);
        arrayList.addAll(listAsList);
        return arrayList;
    }

    @Override // a.a.b.C
    public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        if (!Object.class.isAssignableFrom(clsA)) {
            return null;
        }
        if (a.a.b.b.b.a.b(clsA)) {
            return new B<T>() { // from class: a.a.b.b.a.l.1
                private static byte[] __aes_key_8stmTidI = {(byte) 133, (byte) 37, (byte) 6, (byte) 76, (byte) 238, (byte) 46, (byte) 207, (byte) 226, (byte) 151, (byte) 218, (byte) 47, (byte) 34, (byte) 141, (byte) 19, (byte) 185, (byte) 201, (byte) 164, (byte) 86, (byte) 66, (byte) 195, (byte) 225, (byte) 2, (byte) 211, (byte) 186, (byte) 133, (byte) 111, (byte) 19, (byte) 6, (byte) 224, (byte) 3, (byte) 132, (byte) 169};
                private static byte[] __aes_iv_GQasiMYH = {(byte) 29, (byte) 39, (byte) 139, (byte) 161, (byte) 24, (byte) 32, (byte) 101, (byte) 255, (byte) 40, (byte) 130, (byte) 138, (byte) 78, (byte) 237, (byte) 122, (byte) 41, (byte) 137};
                private static String __s_cache_x5QD3dDT_0;

                @Override // a.a.b.B
                public T b(a.a.b.d.a aVar2) throws IOException {
                    aVar2.o();
                    return null;
                }

                @Override // a.a.b.B
                public void a(a.a.b.d.d dVar, T t) throws IOException {
                    dVar.f();
                }

                public String toString() {
                    return "AnonymousOrNonStaticLocalClassAdapter";
                }

                private static String __unused_2138() {
        return "AnonymousOrNonStaticLocalClassAdapter";
    }
            };
        }
        x.a aVarA = a.a.b.b.n.a(this.e, clsA);
        if (aVarA == x.a.d) {
            throw new a.a.b.m("ReflectionAccessFilter does not permit using reflection for " + clsA + ". Register a TypeAdapter for this type or adjust the access filter.");
        }
        boolean z = aVarA == x.a.c;
        return a.a.b.b.b.a.c(clsA) ? new e(clsA, a(fVar, aVar, clsA, z, true), z) : new c(this.f24a.a((a.a.b.c.a) aVar, true), a(fVar, aVar, clsA, z, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void b(Object obj, M m) {
        if (a.a.b.b.n.a(m, Modifier.isStatic(m.getModifiers()) ? null : obj)) {
        } else {
            throw new a.a.b.m(a.a.b.b.b.a.a((AccessibleObject) m, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private b a(a.a.b.f fVar, Field field, final Method method, String str, a.a.b.c.a<?> aVar, boolean z, final boolean z2) {
        B<?> oVar;
        final boolean zA = a.a.b.b.m.a((Type) aVar.a());
        int modifiers = field.getModifiers();
        final boolean z3 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        a.a.b.a.b bVar = (a.a.b.a.b) field.getAnnotation(a.a.b.a.b.class);
        B<?> bA = null;
        if (bVar != null) {
            bA = this.d.a(this.f24a, fVar, aVar, bVar, false);
        }
        boolean z4 = bA != null;
        if (bA == null) {
            bA = fVar.a((a.a.b.c.a) aVar);
        }
        final B<?> b2 = bA;
        if (z) {
            oVar = z4 ? b2 : new o<>(fVar, b2, aVar.b());
        } else {
            oVar = b2;
        }
        final B<?> b3 = oVar;
        return new b(str, field) { // from class: a.a.b.b.a.l.2
            private static byte[] __aes_key_uaZFYrie = {(byte) 204, (byte) 97, (byte) 89, (byte) 58, (byte) 68, (byte) 192, (byte) 41, (byte) 103, (byte) 136, (byte) 113, (byte) 102, (byte) 248, (byte) 211, (byte) 102, (byte) 57, (byte) 72, (byte) 238, (byte) 20, (byte) 138, (byte) 123, (byte) 201, (byte) 218, (byte) 41, (byte) 176, (byte) 16, (byte) 154, (byte) 211, (byte) 210, (byte) 205, (byte) 223, (byte) 235, (byte) 109};
            private static byte[] __aes_iv_x3rlGfXh = {(byte) 220, (byte) 65, (byte) 119, (byte) 47, (byte) 131, (byte) 96, (byte) 76, (byte) 83, (byte) 187, (byte) 211, (byte) 67, (byte) 29, (byte) 104, (byte) 165, (byte) 226, (byte) 27};
            private static String __s_cache_APH9m1Jk_0;
            private static String __s_cache_yr4jUWqM_1;
            private static String __s_cache_dJ1LQmqZ_2;
            private static String __s_cache_V1jTgmGJ_3;
            private static String __s_cache_pHha3wrp_4;

            @Override // a.a.b.b.a.l.b
            void a(a.a.b.d.d dVar, Object obj) throws IllegalAccessException {
                Object objInvoke;
                if (z2) {
                    if (method == null) {
                        l.b(obj, this.i);
                    } else {
                        l.b(obj, method);
                    }
                }
                if (method != null) {
                    try {
                        objInvoke = method.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e2) {
                        throw new a.a.b.m("Accessor " + a.a.b.b.b.a.a((AccessibleObject) method, false) + __getString_IxHEzKgI_1(), e2.getCause());
                    }
                } else {
                    objInvoke = this.i.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                dVar.a(this.h);
                b3.a(dVar, objInvoke);
            }

            @Override // a.a.b.b.a.l.b
            void a(a.a.b.d.a aVar2, int i, Object[] objArr) {
                Object objB = b2.b(aVar2);
                if (objB == null && zA) {
                    throw new a.a.b.p(__getString_QAaE9gpy_2() + this.j + __getString_73s5IH1v_3() + aVar2.q());
                }
                objArr[i] = objB;
            }

            @Override // a.a.b.b.a.l.b
            void a(a.a.b.d.a aVar2, Object obj) throws IllegalAccessException {
                Object objB = b2.b(aVar2);
                if (objB == null && zA) {
                    return;
                }
                if (z2) {
                    l.b(obj, this.i);
                } else if (z3) {
                    throw new a.a.b.m(__getString_MkoHfMh3_4() + a.a.b.b.b.a.a((AccessibleObject) this.i, false));
                }
                this.i.set(obj, objB);
            }

            private static String __unused_2139() {
        return "Accessor ";
    }

            private static String __getString_IxHEzKgI_1() {
        return " threw exception";
    }

            private static String __getString_QAaE9gpy_2() {
        return "null is not allowed as value for record component '";
    }

            private static String __getString_73s5IH1v_3() {
        return "' of primitive type; at path ";
    }

            private static String __getString_MkoHfMh3_4() {
        return "Cannot set value of 'static final' ";
    }
        };
    }

    private static IllegalArgumentException a(Class<?> cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + a.a.b.b.b.a.a(field) + " and " + a.a.b.b.b.a.a(field2) + "\nSee " + a.a.b.b.p.a("duplicate-fields"));
    }

    private d a(a.a.b.f fVar, a.a.b.c.a<?> aVar, Class<?> cls, boolean z, boolean z2) {
        b bVar;
        if (cls.isInterface()) {
            return d.f29a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        while (cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (cls != cls && declaredFields.length > 0) {
                x.a aVarA = a.a.b.b.n.a(this.e, cls);
                if (aVarA == x.a.d) {
                    throw new a.a.b.m("ReflectionAccessFilter does not permit using reflection for " + cls + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z = aVarA == x.a.c;
            }
            for (Field field : declaredFields) {
                boolean zA = a(field, true);
                boolean zA2 = a(field, false);
                if (zA || zA2) {
                    Method methodA = null;
                    if (z2) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            zA2 = false;
                        } else {
                            methodA = a.a.b.b.b.a.a(cls, field);
                            if (!z) {
                                a.a.b.b.b.a.a(methodA);
                            }
                            if (methodA.getAnnotation(a.a.b.a.c.class) != null && field.getAnnotation(a.a.b.a.c.class) == null) {
                                throw new a.a.b.m("@SerializedName on " + a.a.b.b.b.a.a((AccessibleObject) methodA, false) + " is not supported");
                            }
                        }
                    }
                    if (!z && methodA == null) {
                        a.a.b.b.b.a.a((AccessibleObject) field);
                    }
                    Type typeA = a.a.b.b.d.a(aVar.b(), cls, field.getGenericType());
                    List<String> listA = a(field);
                    String str = listA.get(0);
                    b bVarA = a(fVar, field, methodA, str, a.a.b.c.a.b(typeA), zA, z);
                    if (zA2) {
                        for (String str2 : listA) {
                            b bVar2 = (b) linkedHashMap.put(str2, bVarA);
                            if (bVar2 != null) {
                                throw a(cls, str2, bVar2.i, field);
                            }
                        }
                    }
                    if (zA && (bVar = (b) linkedHashMap2.put(str, bVarA)) != null) {
                        throw a(cls, str, bVar.i, field);
                    }
                }
            }
            aVar = a.a.b.c.a.b(a.a.b.b.d.a(aVar.b(), cls, cls.getGenericSuperclass()));
            cls = aVar.a();
        }
        return new d(linkedHashMap, new ArrayList(linkedHashMap2.values()));
    }

    private static String __unused_2140() {
        return "ReflectionAccessFilter does not permit using reflection for ";
    }

    private static String __unused_2141() {
        return ". Register a TypeAdapter for this type or adjust the access filter.";
    }

    private static String __unused_2142() {
        return " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.";
    }

    private static String __unused_2143() {
        return "Class ";
    }

    private static String __unused_2144() {
        return " declares multiple JSON fields named '";
    }

    private static String __unused_2145() {
        return "'; conflict is caused by fields ";
    }

    private static String __unused_2146() {
        return " and ";
    }

    private static String __unused_2147() {
        return "\nSee ";
    }

    private static String __unused_2148() {
        return "duplicate-fields";
    }

    private static String __unused_2149() {
        return "ReflectionAccessFilter does not permit using reflection for ";
    }

    private static String __unused_2150() {
        return " (supertype of ";
    }

    private static String __unused_2151() {
        return "). Register a TypeAdapter for this type or adjust the access filter.";
    }

    private static String __unused_2152() {
        return "@SerializedName on ";
    }

    private static String __unused_2153() {
        return " is not supported";
    }
}

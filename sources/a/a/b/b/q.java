package a.a.b.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/q.class */
public abstract class q {
    private static String __s_cache_dfPdmalb_0;
    private static String __s_cache_tJbWxyXi_1;
    private static String __s_cache_UeCMWStZ_2;
    private static String __s_cache_Tk9DUcvD_3;
    private static String __s_cache_LKm0OplG_4;
    private static String __s_cache_kcSbCSKp_5;
    private static String __s_cache_97jGDek7_6;
    private static byte[] __aes_key_AVLC9BBt = {(byte) 223, (byte) 186, (byte) 251, (byte) 159, (byte) 247, (byte) 124, (byte) 240, (byte) 223, (byte) 192, (byte) 248, (byte) 49, (byte) 228, (byte) 65, (byte) 144, (byte) 176, (byte) 141, (byte) 48, (byte) 113, (byte) 197, (byte) 39, (byte) 160, (byte) 228, (byte) 226, (byte) 153, (byte) 15, (byte) 221, (byte) 248, (byte) 71, (byte) 120, (byte) 244, (byte) 90, (byte) 57};
    private static byte[] __aes_iv_5abvnJNm = {(byte) 122, (byte) 164, (byte) 143, (byte) 112, (byte) 127, (byte) 98, (byte) 174, (byte) 118, (byte) 109, (byte) 18, (byte) 141, (byte) 195, (byte) 114, (byte) 92, (byte) 87, (byte) 71};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f71a = a();

    public abstract <T> T a(Class<T> cls);

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Class<?> cls) {
        String strA = a.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
        }
    }

    private static q a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new q() { // from class: a.a.b.b.q.1
                @Override // a.a.b.b.q
                public <T> T a(Class<T> cls2) {
                    q.c(cls2);
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                final int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new q() { // from class: a.a.b.b.q.2
                    @Override // a.a.b.b.q
                    public <T> T a(Class<T> cls2) {
                        q.c(cls2);
                        return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(iIntValue));
                    }
                };
            } catch (Exception e2) {
                try {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new q() { // from class: a.a.b.b.q.3
                        @Override // a.a.b.b.q
                        public <T> T a(Class<T> cls2) {
                            q.c(cls2);
                            return (T) declaredMethod3.invoke(null, cls2, Object.class);
                        }
                    };
                } catch (Exception e3) {
                    return new q() { // from class: a.a.b.b.q.4
                        private static byte[] __aes_key_1DQ5RLuf = {(byte) 140, (byte) 221, (byte) 163, (byte) 96, (byte) 223, (byte) 155, (byte) 86, (byte) 241, (byte) 110, (byte) 57, (byte) 201, (byte) 57, (byte) 27, (byte) 251, (byte) 41, (byte) 10, (byte) 244, (byte) 186, (byte) 241, (byte) 116, (byte) 238, (byte) 21, (byte) 17, (byte) 2, (byte) 187, (byte) 110, (byte) 38, (byte) 191, (byte) 252, (byte) 117, (byte) 54, (byte) 21};
                        private static byte[] __aes_iv_WqFnF7v9 = {(byte) 84, (byte) 5, (byte) 194, (byte) 199, (byte) 46, (byte) 38, (byte) 203, (byte) 132, (byte) 35, (byte) 225, (byte) 42, (byte) 4, (byte) 94, (byte) 221, (byte) 75, (byte) 207};
                        private static String __s_cache_6ix8FQd5_0;
                        private static String __s_cache_0Lg7DgJa_1;

                        @Override // a.a.b.b.q
                        public <T> T a(Class<T> cls2) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls2 + __getString_5ccOqBdh_1());
                        }

                        private static String __unused_2045() {
        return "Cannot allocate ";
    }

                        private static String __getString_5ccOqBdh_1() {
        return ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.";
    }
                    };
                }
            }
        }
    }

    private static String __unused_2046() {
        return "UnsafeAllocator is used for non-instantiable type: ";
    }

    private static String __unused_2047() {
        return "sun.misc.Unsafe";
    }

    private static String __unused_2048() {
        return "theUnsafe";
    }

    private static String __unused_2049() {
        return "allocateInstance";
    }

    private static String __unused_2050() {
        return "getConstructorId";
    }

    private static String __unused_2051() {
        return "newInstance";
    }

    private static String __unused_2052() {
        return "newInstance";
    }
}

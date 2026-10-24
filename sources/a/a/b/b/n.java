package a.a.b.b;

import a.a.b.x;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/n.class */
public class n {
    private static byte[] __aes_key_jWhNVZhR = {(byte) 190, (byte) 142, (byte) 130, (byte) 52, (byte) 101, (byte) 18, (byte) 0, (byte) 168, (byte) 50, (byte) 244, (byte) 86, (byte) 167, (byte) 237, (byte) 73, (byte) 148, (byte) 209, (byte) 209, (byte) 60, (byte) 145, (byte) 150, (byte) 174, (byte) 22, (byte) 89, (byte) 77, (byte) 131, (byte) 30, (byte) 131, (byte) 235, (byte) 26, (byte) 230, (byte) 130, (byte) 188};
    private static byte[] __aes_iv_2jwGSVsI = {(byte) 20, (byte) 124, (byte) 251, (byte) 23, (byte) 242, (byte) 241, (byte) 253, (byte) 91, (byte) 10, (byte) 16, (byte) 0, (byte) 14, (byte) 59, (byte) 238, (byte) 199, (byte) 130};
    private static String __s_cache_HJFg2dIC_0;
    private static String __s_cache_iaxn6SIb_1;
    private static String __s_cache_dEdRbQq7_2;
    private static String __s_cache_gR4jBpSn_3;
    private static String __s_cache_jfgnyBU5_4;
    private static String __s_cache_r2ipMnok_5;
    private static String __s_cache_DEnLVN4B_6;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/n$a.class */
    private static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f68a;
        private static byte[] __aes_key_Xy8bwJRu = {(byte) 217, (byte) 111, (byte) 91, (byte) 244, (byte) 141, (byte) 161, (byte) 243, (byte) 59, (byte) 249, (byte) 192, (byte) 119, (byte) 213, (byte) 237, (byte) 195, (byte) 14, (byte) 199, (byte) 114, (byte) 113, (byte) 34, (byte) 105, (byte) 113, (byte) 229, (byte) 112, (byte) 200, (byte) 82, (byte) 116, (byte) 172, (byte) 204, (byte) 228, (byte) 165, (byte) 203, (byte) 108};
        private static byte[] __aes_iv_v6Ps12T1 = {(byte) 72, (byte) 171, (byte) 247, (byte) 250, (byte) 108, (byte) 161, (byte) 236, (byte) 200, (byte) 247, (byte) 102, (byte) 226, (byte) 161, (byte) 231, (byte) 23, (byte) 179, (byte) 99};
        private static String __s_cache_osA41yv5_0;

        private a() {
        }

        abstract boolean a(AccessibleObject accessibleObject, Object obj);

        static {
            a aVar = null;
            if (e.b()) {
                try {
                    final Method declaredMethod = AccessibleObject.class.getDeclaredMethod(__getString_AsiqSzqI_0(), Object.class);
                    aVar = new a() { // from class: a.a.b.b.n.a.1
                        private static byte[] __aes_key_EA1LKkI6 = {(byte) 70, (byte) 125, (byte) 207, (byte) 122, (byte) 130, (byte) 178, (byte) 236, (byte) 233, (byte) 72, (byte) 53, (byte) 166, (byte) 62, (byte) 141, (byte) 190, (byte) 217, (byte) 172, (byte) 15, (byte) 6, (byte) 240, (byte) 141, (byte) 240, (byte) 76, (byte) 66, (byte) 20, (byte) 212, (byte) 252, (byte) 97, (byte) 176, (byte) 22, (byte) 100, (byte) 156, (byte) 194};
                        private static byte[] __aes_iv_wmHYZMAa = {(byte) 109, (byte) 211, (byte) 126, (byte) 105, (byte) 74, (byte) 187, (byte) 251, (byte) 210, (byte) 145, (byte) 109, (byte) 81, (byte) 183, (byte) 24, (byte) 99, (byte) 188, (byte) 63};
                        private static String __s_cache_Y0nRAciC_0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super();
                        }

                        @Override // a.a.b.b.n.a
                        public boolean a(AccessibleObject accessibleObject, Object obj) {
                            try {
                                return ((Boolean) declaredMethod.invoke(accessibleObject, obj)).booleanValue();
                            } catch (Exception e) {
                                throw new RuntimeException("Failed invoking canAccess", e);
                            }
                        }

                        private static String __unused_2014() {
        return "Failed invoking canAccess";
    }
                    };
                } catch (NoSuchMethodException e) {
                }
            }
            if (aVar == null) {
                aVar = new a() { // from class: a.a.b.b.n.a.2
                    @Override // a.a.b.b.n.a
                    public boolean a(AccessibleObject accessibleObject, Object obj) {
                        return true;
                    }
                };
            }
            f68a = aVar;
        }

        private static String __getString_AsiqSzqI_0() {
        return "canAccess";
    }
    }

    private n() {
    }

    public static boolean a(Class<?> cls) {
        return a(cls.getName());
    }

    private static boolean a(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }

    public static boolean b(Class<?> cls) {
        return b(cls.getName());
    }

    private static boolean b(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || a(str);
    }

    public static boolean c(Class<?> cls) {
        String name = cls.getName();
        return b(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static x.a a(List<x> list, Class<?> cls) {
        Iterator<x> it = list.iterator();
        while (it.hasNext()) {
            x.a aVarA = it.next().a(cls);
            if (aVarA != x.a.b) {
                return aVarA;
            }
        }
        return x.a.f95a;
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return a.f68a.a(accessibleObject, obj);
    }

    private static String __unused_2015() {
        return "java.";
    }

    private static String __unused_2016() {
        return "javax.";
    }

    private static String __unused_2017() {
        return "android.";
    }

    private static String __unused_2018() {
        return "androidx.";
    }

    private static String __unused_2019() {
        return "kotlin.";
    }

    private static String __unused_2020() {
        return "kotlinx.";
    }

    private static String __unused_2021() {
        return "scala.";
    }
}

package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import a.a.b.v;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/p.class */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B<Class> f35a = new B<Class>() { // from class: a.a.b.b.a.p.1
        private static byte[] __aes_key_g0Ct957Z = {(byte) 28, (byte) 36, (byte) 53, (byte) 2, (byte) 150, (byte) 85, (byte) 226, (byte) 113, (byte) 56, (byte) 25, (byte) 151, (byte) 209, (byte) 252, (byte) 236, (byte) 110, (byte) 207, (byte) 248, (byte) 92, (byte) 247, (byte) 146, (byte) 14, (byte) 228, (byte) 188, (byte) 144, (byte) 192, (byte) 92, (byte) 34, (byte) 162, (byte) 124, (byte) 103, (byte) 58, (byte) 39};
        private static byte[] __aes_iv_wy6ilHeL = {(byte) 110, (byte) 189, (byte) 216, (byte) 90, (byte) 25, (byte) 43, (byte) 102, (byte) 223, (byte) 10, (byte) 101, (byte) 123, (byte) 227, (byte) 109, (byte) 228, (byte) 190, (byte) 249};
        private static String __s_cache_U9UbKSp4_0;
        private static String __s_cache_pVZwuZfv_1;
        private static String __s_cache_9GD2TaVr_2;
        private static String __s_cache_bKZJGsiD_3;
        private static String __s_cache_7DjiJLDo_4;

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + __getString_mLsxuFND_1() + a.a.b.b.p.a(__getString_hYiZZt17_2()));
        }

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class b(a.a.b.d.a aVar) {
            throw new UnsupportedOperationException(__getString_04ENxm8p_3() + a.a.b.b.p.a(__getString_uopI8Rim_4()));
        }

        private static String __unused_2118() {
        return "Attempted to serialize java.lang.Class: ";
    }

        private static String __getString_mLsxuFND_1() {
        return ". Forgot to register a type adapter?\nSee ";
    }

        private static String __getString_hYiZZt17_2() {
        return "java-lang-class-unsupported";
    }

        private static String __getString_04ENxm8p_3() {
        return "Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee ";
    }

        private static String __getString_uopI8Rim_4() {
        return "java-lang-class-unsupported";
    }
    }.b();
    public static final C b = a(Class.class, f35a);
    public static final B<BitSet> c = new B<BitSet>() { // from class: a.a.b.b.a.p.12
        private static byte[] __aes_key_TJObgvIk = {(byte) 5, (byte) 173, (byte) 103, (byte) 69, (byte) 83, (byte) 228, (byte) 4, (byte) 118, (byte) 112, (byte) 101, (byte) 111, (byte) 49, (byte) 36, (byte) 56, (byte) 7, (byte) 112, (byte) 129, (byte) 6, (byte) 172, (byte) 84, (byte) 132, (byte) 251, (byte) 51, (byte) 96, (byte) 70, (byte) 221, (byte) 78, (byte) 132, (byte) 74, (byte) 175, (byte) 10, (byte) 62};
        private static byte[] __aes_iv_VUdsGLK6 = {(byte) 62, (byte) 44, (byte) 20, (byte) 91, (byte) 195, (byte) 224, (byte) 175, (byte) 147, (byte) 28, (byte) 90, (byte) 151, (byte) 200, (byte) 139, (byte) 113, (byte) 248, (byte) 188};
        private static String __s_cache_RvgmegAs_0;
        private static String __s_cache_p66F7FTA_1;
        private static String __s_cache_inDGOyRF_2;
        private static String __s_cache_TbALRtiR_3;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BitSet b(a.a.b.d.a aVar) throws IOException {
            boolean zI;
            BitSet bitSet = new BitSet();
            aVar.a();
            int i2 = 0;
            a.a.b.d.c cVarF = aVar.f();
            while (true) {
                a.a.b.d.c cVar = cVarF;
                if (cVar == a.a.b.d.c.b) {
                    aVar.b();
                    return bitSet;
                }
                switch (AnonymousClass27.f43a[cVar.ordinal()]) {
                    case 1:
                    case 2:
                        int iM = aVar.m();
                        if (iM == 0) {
                            zI = false;
                        } else {
                            if (iM != 1) {
                                throw new v("Invalid bitset value " + iM + __getString_kNdDSXzh_1() + aVar.r());
                            }
                            zI = true;
                        }
                        break;
                    case 3:
                        zI = aVar.i();
                        break;
                    default:
                        throw new v(__getString_mLvfcrmR_2() + cVar + __getString_uKwwXbxZ_3() + aVar.q());
                }
                if (zI) {
                    bitSet.set(i2);
                }
                i2++;
                cVarF = aVar.f();
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, BitSet bitSet) throws IOException {
            dVar.b();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                dVar.a(bitSet.get(i2) ? 1 : 0);
            }
            dVar.c();
        }

        private static String __unused_2119() {
        return "Invalid bitset value ";
    }

        private static String __getString_kNdDSXzh_1() {
        return ", expected 0 or 1; at path ";
    }

        private static String __getString_mLvfcrmR_2() {
        return "Invalid bitset value type: ";
    }

        private static String __getString_uKwwXbxZ_3() {
        return "; at path ";
    }
    }.b();
    public static final C d = a(BitSet.class, c);
    public static final B<Boolean> e = new B<Boolean>() { // from class: a.a.b.b.a.p.23
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(a.a.b.d.a aVar) throws IOException {
            a.a.b.d.c cVarF = aVar.f();
            if (cVarF != a.a.b.d.c.i) {
                return cVarF == a.a.b.d.c.f ? Boolean.valueOf(Boolean.parseBoolean(aVar.h())) : Boolean.valueOf(aVar.i());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Boolean bool) throws IOException {
            dVar.a(bool);
        }
    };
    public static final B<Boolean> f = new B<Boolean>() { // from class: a.a.b.b.a.p.28
        private static byte[] __aes_key_UOdvVcEw = {(byte) 34, (byte) 117, (byte) 39, (byte) 149, (byte) 232, (byte) 124, (byte) 68, (byte) 144, (byte) 168, (byte) 66, (byte) 145, (byte) 27, (byte) 1, (byte) 45, (byte) 214, (byte) 238, (byte) 249, (byte) 236, (byte) 49, (byte) 174, (byte) 45, (byte) 115, (byte) 14, (byte) 148, (byte) 165, (byte) 226, (byte) 206, (byte) 28, (byte) 91, (byte) 209, (byte) 52, (byte) 133};
        private static byte[] __aes_iv_ieiICFHe = {(byte) 67, (byte) 125, (byte) 121, (byte) 100, (byte) 151, (byte) 243, (byte) 240, (byte) 80, (byte) 147, (byte) 223, (byte) 145, (byte) 87, (byte) 17, (byte) 198, (byte) 34, (byte) 54};
        private static String __s_cache_8Ea2sJgC_0;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return Boolean.valueOf(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Boolean bool) throws IOException {
            dVar.b(bool == null ? "null" : bool.toString());
        }

        private static String __unused_2120() {
        return "null";
    }
    };
    public static final C g = a(Boolean.TYPE, Boolean.class, e);
    public static final B<Number> h = new B<Number>() { // from class: a.a.b.b.a.p.29
        private static byte[] __aes_key_j7ueqARj = {(byte) 169, (byte) 47, (byte) 182, (byte) 244, (byte) 177, (byte) 95, (byte) 41, (byte) 151, (byte) 207, (byte) 225, (byte) 114, (byte) 199, (byte) 211, (byte) 101, (byte) 212, (byte) 65, (byte) 243, (byte) 23, (byte) 33, (byte) 46, (byte) 213, (byte) 48, (byte) 105, (byte) 250, (byte) 243, (byte) 57, (byte) 119, (byte) 153, (byte) 182, (byte) 181, (byte) 63, (byte) 22};
        private static byte[] __aes_iv_FyZFJ4ic = {(byte) 198, (byte) 1, (byte) 118, (byte) 53, (byte) 246, (byte) 144, (byte) 200, (byte) 146, (byte) 202, (byte) 96, (byte) 181, (byte) 72, (byte) 196, (byte) 35, (byte) 107, (byte) 2};
        private static String __s_cache_fO6iI9yz_0;
        private static String __s_cache_YsbN8iw9_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            try {
                int iM = aVar.m();
                if (iM > 255 || iM < -128) {
                    throw new v("Lossy conversion from " + iM + __getString_Apr1asK4_1() + aVar.r());
                }
                return Byte.valueOf((byte) iM);
            } catch (NumberFormatException e2) {
                throw new v(e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.f();
            } else {
                dVar.a(number.byteValue());
            }
        }

        private static String __unused_2121() {
        return "Lossy conversion from ";
    }

        private static String __getString_Apr1asK4_1() {
        return " to byte; at path ";
    }
    };
    public static final C i = a(Byte.TYPE, Byte.class, h);
    public static final B<Number> j = new B<Number>() { // from class: a.a.b.b.a.p.30
        private static byte[] __aes_key_rETFCqjJ = {(byte) 24, (byte) 229, (byte) 103, (byte) 134, (byte) 168, (byte) 117, (byte) 243, (byte) 12, (byte) 178, (byte) 37, (byte) 4, (byte) 105, (byte) 250, (byte) 192, (byte) 163, (byte) 222, (byte) 141, (byte) 87, (byte) 215, (byte) 245, (byte) 76, (byte) 183, (byte) 199, (byte) 190, (byte) 33, (byte) 131, (byte) 51, (byte) 212, (byte) 249, (byte) 139, (byte) 243, (byte) 119};
        private static byte[] __aes_iv_DYJbY7Cg = {(byte) 88, (byte) 123, (byte) 93, (byte) 4, (byte) 31, (byte) 82, (byte) 135, (byte) 183, (byte) 118, (byte) 31, (byte) 168, (byte) 145, (byte) 50, (byte) 116, (byte) 197, (byte) 95};
        private static String __s_cache_mGBE8LXA_0;
        private static String __s_cache_50YMeEaA_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            try {
                int iM = aVar.m();
                if (iM > 65535 || iM < -32768) {
                    throw new v("Lossy conversion from " + iM + __getString_NAihfKW2_1() + aVar.r());
                }
                return Short.valueOf((short) iM);
            } catch (NumberFormatException e2) {
                throw new v(e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.f();
            } else {
                dVar.a(number.shortValue());
            }
        }

        private static String __unused_2122() {
        return "Lossy conversion from ";
    }

        private static String __getString_NAihfKW2_1() {
        return " to short; at path ";
    }
    };
    public static final C k = a(Short.TYPE, Short.class, j);
    public static final B<Number> l = new B<Number>() { // from class: a.a.b.b.a.p.31
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new v(e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.f();
            } else {
                dVar.a(number.intValue());
            }
        }
    };
    public static final C m = a(Integer.TYPE, Integer.class, l);
    public static final B<AtomicInteger> n = new B<AtomicInteger>() { // from class: a.a.b.b.a.p.32
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(a.a.b.d.a aVar) {
            try {
                return new AtomicInteger(aVar.m());
            } catch (NumberFormatException e2) {
                throw new v(e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, AtomicInteger atomicInteger) throws IOException {
            dVar.a(atomicInteger.get());
        }
    }.b();
    public static final C o = a(AtomicInteger.class, n);
    public static final B<AtomicBoolean> p = new B<AtomicBoolean>() { // from class: a.a.b.b.a.p.33
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(a.a.b.d.a aVar) {
            return new AtomicBoolean(aVar.i());
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, AtomicBoolean atomicBoolean) throws IOException {
            dVar.a(atomicBoolean.get());
        }
    }.b();
    public static final C q = a(AtomicBoolean.class, p);
    public static final B<AtomicIntegerArray> r = new B<AtomicIntegerArray>() { // from class: a.a.b.b.a.p.2
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(a.a.b.d.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.m()));
                } catch (NumberFormatException e2) {
                    throw new v(e2);
                }
            }
            aVar.b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            dVar.b();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                dVar.a(atomicIntegerArray.get(i2));
            }
            dVar.c();
        }
    }.b();
    public static final C s = a(AtomicIntegerArray.class, r);
    public static final B<Number> t = new B<Number>() { // from class: a.a.b.b.a.p.3
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (NumberFormatException e2) {
                throw new v(e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.f();
            } else {
                dVar.a(number.longValue());
            }
        }
    };
    public static final B<Number> u = new B<Number>() { // from class: a.a.b.b.a.p.4
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return Float.valueOf((float) aVar.k());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.f();
            } else {
                dVar.a(number instanceof Float ? number : Float.valueOf(number.floatValue()));
            }
        }
    };
    public static final B<Number> v = new B<Number>() { // from class: a.a.b.b.a.p.5
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return Double.valueOf(aVar.k());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.f();
            } else {
                dVar.a(number.doubleValue());
            }
        }
    };
    public static final B<Character> w = new B<Character>() { // from class: a.a.b.b.a.p.6
        private static byte[] __aes_key_VnjJzfMA = {(byte) 187, (byte) 135, (byte) 89, (byte) 75, (byte) 167, (byte) 16, (byte) 122, (byte) 156, (byte) 83, (byte) 224, (byte) 134, (byte) 209, (byte) 83, (byte) 243, (byte) 224, (byte) 125, (byte) 130, (byte) 243, (byte) 141, (byte) 79, (byte) 93, (byte) 247, (byte) 116, (byte) 224, (byte) 64, (byte) 63, (byte) 143, (byte) 244, (byte) 26, (byte) 237, (byte) 138, (byte) 238};
        private static byte[] __aes_iv_TBlF0f2x = {(byte) 24, (byte) 71, (byte) 222, (byte) 16, (byte) 173, (byte) 72, (byte) 113, (byte) 85, (byte) 170, (byte) 82, (byte) 217, (byte) 175, (byte) 146, (byte) 54, (byte) 215, (byte) 76};
        private static String __s_cache_lGa9kstO_0;
        private static String __s_cache_iXOhSuBo_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            if (strH.length() != 1) {
                throw new v("Expecting character, got: " + strH + __getString_XutafVz0_1() + aVar.r());
            }
            return Character.valueOf(strH.charAt(0));
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Character ch) throws IOException {
            dVar.b(ch == null ? null : String.valueOf(ch));
        }

        private static String __unused_2123() {
        return "Expecting character, got: ";
    }

        private static String __getString_XutafVz0_1() {
        return "; at ";
    }
    };
    public static final C x = a(Character.TYPE, Character.class, w);
    public static final B<String> y = new B<String>() { // from class: a.a.b.b.a.p.7
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String b(a.a.b.d.a aVar) throws IOException {
            a.a.b.d.c cVarF = aVar.f();
            if (cVarF != a.a.b.d.c.i) {
                return cVarF == a.a.b.d.c.h ? Boolean.toString(aVar.i()) : aVar.h();
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, String str) throws IOException {
            dVar.b(str);
        }
    };
    public static final B<BigDecimal> z = new B<BigDecimal>() { // from class: a.a.b.b.a.p.8
        private static byte[] __aes_key_jsKc9pdT = {(byte) 212, (byte) 169, (byte) 143, (byte) 221, (byte) 30, (byte) 235, (byte) 233, (byte) 181, (byte) 109, (byte) 60, (byte) 50, (byte) 123, (byte) 168, (byte) 217, (byte) 109, (byte) 226, (byte) 135, (byte) 186, (byte) 224, (byte) 131, (byte) 131, (byte) 89, (byte) 230, (byte) 225, (byte) 174, (byte) 213, (byte) 157, (byte) 103, (byte) 250, (byte) 205, (byte) 153, (byte) 41};
        private static byte[] __aes_iv_aGQGABU2 = {(byte) 213, (byte) 54, (byte) 75, (byte) 228, (byte) 230, (byte) 67, (byte) 239, (byte) 5, (byte) 98, (byte) 0, (byte) 254, (byte) 139, (byte) 195, (byte) 252, (byte) 3, (byte) 200};
        private static String __s_cache_pJD3elIO_0;
        private static String __s_cache_lDN05BhN_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            try {
                return a.a.b.b.j.a(strH);
            } catch (NumberFormatException e2) {
                throw new v("Failed parsing '" + strH + __getString_lAPMYlDg_1() + aVar.r(), e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, BigDecimal bigDecimal) throws IOException {
            dVar.a(bigDecimal);
        }

        private static String __unused_2124() {
        return "Failed parsing '";
    }

        private static String __getString_lAPMYlDg_1() {
        return "' as BigDecimal; at path ";
    }
    };
    public static final B<BigInteger> A = new B<BigInteger>() { // from class: a.a.b.b.a.p.9
        private static byte[] __aes_key_gFWpqO3B = {(byte) 141, (byte) 45, (byte) 134, (byte) 255, (byte) 136, (byte) 165, (byte) 148, (byte) 132, (byte) 46, (byte) 113, (byte) 114, (byte) 39, (byte) 42, (byte) 34, (byte) 250, (byte) 60, (byte) 214, (byte) 71, (byte) 81, (byte) 143, (byte) 84, (byte) 115, (byte) 8, (byte) 157, (byte) 153, (byte) 70, (byte) 104, (byte) 211, (byte) 156, (byte) 197, (byte) 150, (byte) 44};
        private static byte[] __aes_iv_bciAw1oh = {(byte) 46, (byte) 224, (byte) 220, (byte) 172, (byte) 90, (byte) 176, (byte) 38, (byte) 181, (byte) 14, (byte) 248, (byte) 236, (byte) 225, (byte) 0, (byte) 70, (byte) 6, (byte) 113};
        private static String __s_cache_nId9EQKv_0;
        private static String __s_cache_5pCt3Ilx_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            try {
                return a.a.b.b.j.b(strH);
            } catch (NumberFormatException e2) {
                throw new v("Failed parsing '" + strH + __getString_ULrrl2my_1() + aVar.r(), e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, BigInteger bigInteger) throws IOException {
            dVar.a(bigInteger);
        }

        private static String __unused_2125() {
        return "Failed parsing '";
    }

        private static String __getString_ULrrl2my_1() {
        return "' as BigInteger; at path ";
    }
    };
    public static final B<a.a.b.b.g> B = new B<a.a.b.b.g>() { // from class: a.a.b.b.a.p.10
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a.a.b.b.g b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return new a.a.b.b.g(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, a.a.b.b.g gVar) throws IOException {
            dVar.a(gVar);
        }
    };
    public static final C C = a(String.class, y);
    public static final B<StringBuilder> D = new B<StringBuilder>() { // from class: a.a.b.b.a.p.11
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return new StringBuilder(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, StringBuilder sb) throws IOException {
            dVar.b(sb == null ? null : sb.toString());
        }
    };
    public static final C E = a(StringBuilder.class, D);
    public static final B<StringBuffer> F = new B<StringBuffer>() { // from class: a.a.b.b.a.p.13
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return new StringBuffer(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, StringBuffer stringBuffer) throws IOException {
            dVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final C G = a(StringBuffer.class, F);
    public static final B<URL> H = new B<URL>() { // from class: a.a.b.b.a.p.14
        private static byte[] __aes_key_H9mGi9ul = {(byte) 49, (byte) 125, (byte) 74, (byte) 76, (byte) 119, (byte) 206, (byte) 189, (byte) 5, (byte) 22, (byte) 138, (byte) 86, (byte) 7, (byte) 227, (byte) 198, (byte) 238, (byte) 5, (byte) 71, (byte) 146, (byte) 128, (byte) 115, (byte) 127, (byte) 123, (byte) 26, (byte) 110, (byte) 4, (byte) 238, (byte) 205, (byte) 52, (byte) 83, (byte) 113, (byte) 115, (byte) 129};
        private static byte[] __aes_iv_c0mzvuw6 = {(byte) 19, (byte) 95, (byte) 109, (byte) 36, (byte) 55, (byte) 218, (byte) 67, (byte) 154, (byte) 150, (byte) 27, (byte) 62, (byte) 34, (byte) 232, (byte) 169, (byte) 28, (byte) 127};
        private static String __s_cache_BTgzhfuh_0;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            if (strH.equals("null")) {
                return null;
            }
            return new URL(strH);
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, URL url) throws IOException {
            dVar.b(url == null ? null : url.toExternalForm());
        }

        private static String __unused_2126() {
        return "null";
    }
    };
    public static final C I = a(URL.class, H);
    public static final B<URI> J = new B<URI>() { // from class: a.a.b.b.a.p.15
        private static byte[] __aes_key_VCh0cUG4 = {(byte) 108, (byte) 9, (byte) 57, (byte) 115, (byte) 206, (byte) 158, (byte) 131, (byte) 179, (byte) 24, (byte) 236, (byte) 235, (byte) 95, (byte) 66, (byte) 135, (byte) 186, (byte) 67, (byte) 63, (byte) 245, (byte) 177, (byte) 107, (byte) 213, (byte) 68, (byte) 37, (byte) 206, (byte) 67, (byte) 227, (byte) 200, (byte) 132, (byte) 89, (byte) 82, (byte) 247, (byte) 35};
        private static byte[] __aes_iv_aCvCp0or = {(byte) 149, (byte) 104, (byte) 223, (byte) 155, (byte) 103, (byte) 143, (byte) 235, (byte) 98, (byte) 218, (byte) 103, (byte) 0, (byte) 34, (byte) 164, (byte) 119, (byte) 219, (byte) 64};
        private static String __s_cache_urz8wpAX_0;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            try {
                String strH = aVar.h();
                if (strH.equals("null")) {
                    return null;
                }
                return new URI(strH);
            } catch (URISyntaxException e2) {
                throw new a.a.b.m(e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, URI uri) throws IOException {
            dVar.b(uri == null ? null : uri.toASCIIString());
        }

        private static String __unused_2127() {
        return "null";
    }
    };
    public static final C K = a(URI.class, J);
    public static final B<InetAddress> L = new B<InetAddress>() { // from class: a.a.b.b.a.p.16
        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return InetAddress.getByName(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, InetAddress inetAddress) throws IOException {
            dVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final C M = b(InetAddress.class, L);
    public static final B<UUID> N = new B<UUID>() { // from class: a.a.b.b.a.p.17
        private static byte[] __aes_key_bG9VX6J9 = {(byte) 4, (byte) 119, (byte) 162, (byte) 101, (byte) 91, (byte) 246, (byte) 52, (byte) 164, (byte) 111, (byte) 18, (byte) 254, (byte) 63, (byte) 197, (byte) 206, (byte) 235, (byte) 167, (byte) 44, (byte) 98, (byte) 27, (byte) 49, (byte) 78, (byte) 111, (byte) 192, (byte) 176, (byte) 240, (byte) 13, (byte) 98, (byte) 102, (byte) 138, (byte) 45, (byte) 188, (byte) 3};
        private static byte[] __aes_iv_1jbOT9Vz = {(byte) 116, (byte) 90, (byte) 219, (byte) 248, (byte) 209, (byte) 222, (byte) 23, (byte) 0, (byte) 124, (byte) 229, (byte) 214, (byte) 244, (byte) 42, (byte) 243, (byte) 128, (byte) 96};
        private static String __s_cache_B9QjSK9b_0;
        private static String __s_cache_ZCrpIN7d_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            try {
                return UUID.fromString(strH);
            } catch (IllegalArgumentException e2) {
                throw new v("Failed parsing '" + strH + __getString_tXtPRiQo_1() + aVar.r(), e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, UUID uuid) throws IOException {
            dVar.b(uuid == null ? null : uuid.toString());
        }

        private static String __unused_2128() {
        return "Failed parsing '";
    }

        private static String __getString_tXtPRiQo_1() {
        return "' as UUID; at path ";
    }
    };
    public static final C O = a(UUID.class, N);
    public static final B<Currency> P = new B<Currency>() { // from class: a.a.b.b.a.p.18
        private static byte[] __aes_key_YMXF5619 = {(byte) 55, (byte) 85, (byte) 82, (byte) 150, (byte) 111, (byte) 173, (byte) 105, (byte) 175, (byte) 252, (byte) 78, (byte) 17, (byte) 169, (byte) 46, (byte) 28, (byte) 154, (byte) 29, (byte) 12, (byte) 164, (byte) 218, (byte) 164, (byte) 143, (byte) 185, (byte) 154, (byte) 37, (byte) 192, (byte) 191, (byte) 117, (byte) 69, (byte) 201, (byte) 176, (byte) 171, (byte) 26};
        private static byte[] __aes_iv_dmeJbGxC = {(byte) 132, (byte) 6, (byte) 182, (byte) 146, (byte) 225, (byte) 232, (byte) 230, (byte) 202, (byte) 226, (byte) 4, (byte) 136, (byte) 115, (byte) 84, (byte) 2, (byte) 231, (byte) 38};
        private static String __s_cache_Ujs5Du5L_0;
        private static String __s_cache_jdNuFwmb_1;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Currency b(a.a.b.d.a aVar) throws IOException {
            String strH = aVar.h();
            try {
                return Currency.getInstance(strH);
            } catch (IllegalArgumentException e2) {
                throw new v("Failed parsing '" + strH + __getString_PQ1RMH0J_1() + aVar.r(), e2);
            }
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Currency currency) throws IOException {
            dVar.b(currency.getCurrencyCode());
        }

        private static String __unused_2129() {
        return "Failed parsing '";
    }

        private static String __getString_PQ1RMH0J_1() {
        return "' as Currency; at path ";
    }
    }.b();
    public static final C Q = a(Currency.class, P);
    public static final B<Calendar> R = new B<Calendar>() { // from class: a.a.b.b.a.p.19

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f36a = "year";
        private static final String b = "month";
        private static final String c = "dayOfMonth";
        private static final String d = "hourOfDay";
        private static final String e = "minute";
        private static final String f = "second";
        private static byte[] __aes_key_K1WtKZcJ = {(byte) 113, (byte) 3, (byte) 54, (byte) 146, (byte) 217, (byte) 14, (byte) 224, (byte) 154, (byte) 96, (byte) 75, (byte) 86, (byte) 249, (byte) 226, (byte) 152, (byte) 142, (byte) 6, (byte) 110, (byte) 179, (byte) 29, (byte) 210, (byte) 100, (byte) 98, (byte) 241, (byte) 100, (byte) 194, (byte) 188, (byte) 223, (byte) 234, (byte) 170, (byte) 171, (byte) 108, (byte) 196};
        private static byte[] __aes_iv_0kui5Qwb = {(byte) 230, (byte) 236, (byte) 202, (byte) 71, (byte) 180, (byte) 243, (byte) 77, (byte) 225, (byte) 68, (byte) 209, (byte) 41, (byte) 57, (byte) 182, (byte) 7, (byte) 63, (byte) 124};
        private static String __s_cache_BaoOf8Vq_0;
        private static String __s_cache_c6bAd10J_1;
        private static String __s_cache_nImi0d9S_2;
        private static String __s_cache_KTFbljHQ_3;
        private static String __s_cache_QUMimbFv_4;
        private static String __s_cache_FrADsnsA_5;
        private static String __s_cache_D2sLu2g9_6;
        private static String __s_cache_K05lSl2E_7;
        private static String __s_cache_vgpDVPQv_8;
        private static String __s_cache_rZUhCIDO_9;
        private static String __s_cache_OZ8OVYEM_10;
        private static String __s_cache_Kb6hcemS_11;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.f() != a.a.b.d.c.d) {
                String strG = aVar.g();
                int iM = aVar.m();
                byte b2 = -1;
                switch (strG.hashCode()) {
                    case -1181204563:
                        if (strG.equals(__getString_WGtxEcqt_2())) {
                            b2 = 2;
                        }
                        break;
                    case -1074026988:
                        if (strG.equals(__getString_WZ5sTfU4_4())) {
                            b2 = 4;
                        }
                        break;
                    case -906279820:
                        if (strG.equals(__getString_CadH79w6_5())) {
                            b2 = 5;
                        }
                        break;
                    case 3704893:
                        if (strG.equals("year")) {
                            b2 = 0;
                        }
                        break;
                    case 104080000:
                        if (strG.equals(__getString_w1smSWCU_1())) {
                            b2 = 1;
                        }
                        break;
                    case 985252545:
                        if (strG.equals(__getString_ULvvfJWc_3())) {
                            b2 = 3;
                        }
                        break;
                }
                switch (b2) {
                    case 0:
                        i2 = iM;
                        break;
                    case 1:
                        i3 = iM;
                        break;
                    case 2:
                        i4 = iM;
                        break;
                    case 3:
                        i5 = iM;
                        break;
                    case 4:
                        i6 = iM;
                        break;
                    case 5:
                        i7 = iM;
                        break;
                }
            }
            aVar.d();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                dVar.f();
                return;
            }
            dVar.d();
            dVar.a(__getString_MKe0OJ5U_6());
            dVar.a(calendar.get(1));
            dVar.a(__getString_FIMe0B26_7());
            dVar.a(calendar.get(2));
            dVar.a(__getString_2MxmfLao_8());
            dVar.a(calendar.get(5));
            dVar.a(__getString_MuuJN33k_9());
            dVar.a(calendar.get(11));
            dVar.a(__getString_H07oS4WE_10());
            dVar.a(calendar.get(12));
            dVar.a(__getString_QogMUSRr_11());
            dVar.a(calendar.get(13));
            dVar.e();
        }

        private static String __unused_2130() {
        return "year";
    }

        private static String __getString_w1smSWCU_1() {
        return "month";
    }

        private static String __getString_WGtxEcqt_2() {
        return "dayOfMonth";
    }

        private static String __getString_ULvvfJWc_3() {
        return "hourOfDay";
    }

        private static String __getString_WZ5sTfU4_4() {
        return "minute";
    }

        private static String __getString_CadH79w6_5() {
        return "second";
    }

        private static String __getString_MKe0OJ5U_6() {
        return "year";
    }

        private static String __getString_FIMe0B26_7() {
        return "month";
    }

        private static String __getString_2MxmfLao_8() {
        return "dayOfMonth";
    }

        private static String __getString_MuuJN33k_9() {
        return "hourOfDay";
    }

        private static String __getString_H07oS4WE_10() {
        return "minute";
    }

        private static String __getString_QogMUSRr_11() {
        return "second";
    }
    };
    public static final C S = b(Calendar.class, GregorianCalendar.class, R);
    public static final B<Locale> T = new B<Locale>() { // from class: a.a.b.b.a.p.20
        private static byte[] __aes_key_IqP2VK1y = {(byte) 229, (byte) 88, (byte) 123, (byte) 199, (byte) 91, (byte) 161, (byte) 112, (byte) 140, (byte) 75, (byte) 127, (byte) 47, (byte) 30, (byte) 87, (byte) 137, (byte) 196, (byte) 228, (byte) 176, (byte) 212, (byte) 167, (byte) 37, (byte) 71, (byte) 219, (byte) 157, (byte) 221, (byte) 207, (byte) 1, (byte) 95, (byte) 107, (byte) 4, (byte) 95, (byte) 190, (byte) 150};
        private static byte[] __aes_iv_npKwlc92 = {(byte) 215, (byte) 214, (byte) 237, (byte) 153, (byte) 223, (byte) 44, (byte) 28, (byte) 151, (byte) 225, (byte) 58, (byte) 168, (byte) 154, (byte) 248, (byte) 72, (byte) 118, (byte) 102};
        private static String __s_cache_MQAXAGRs_0;

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
            String strNextToken = null;
            String strNextToken2 = null;
            String strNextToken3 = null;
            if (stringTokenizer.hasMoreElements()) {
                strNextToken = stringTokenizer.nextToken();
            }
            if (stringTokenizer.hasMoreElements()) {
                strNextToken2 = stringTokenizer.nextToken();
            }
            if (stringTokenizer.hasMoreElements()) {
                strNextToken3 = stringTokenizer.nextToken();
            }
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Locale locale) throws IOException {
            dVar.b(locale == null ? null : locale.toString());
        }

        private static String __unused_2131() {
        return "_";
    }
    };
    public static final C U = a(Locale.class, T);
    public static final B<a.a.b.l> V = f.f12a;
    public static final C W = b(a.a.b.l.class, V);
    public static final C X = d.f10a;

    /* JADX INFO: renamed from: a.a.b.b.a.p$27, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/p$27.class */
    static /* synthetic */ class AnonymousClass27 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43a = new int[a.a.b.d.c.values().length];

        static {
            try {
                f43a[a.a.b.d.c.g.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f43a[a.a.b.d.c.f.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f43a[a.a.b.d.c.h.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private p() {
        throw new UnsupportedOperationException();
    }

    public static <TT> C a(final a.a.b.c.a<TT> aVar, final B<TT> b2) {
        return new C() { // from class: a.a.b.b.a.p.21
            @Override // a.a.b.C
            public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return b2;
                }
                return null;
            }
        };
    }

    public static <TT> C a(final Class<TT> cls, final B<TT> b2) {
        return new C() { // from class: a.a.b.b.a.p.22
            private static byte[] __aes_key_eV0xlrIA = {(byte) 195, (byte) 3, (byte) 161, (byte) 24, (byte) 211, (byte) 52, (byte) 94, (byte) 151, (byte) 87, (byte) 211, (byte) 49, (byte) 164, (byte) 175, (byte) 50, (byte) 226, (byte) 244, (byte) 61, (byte) 73, (byte) 94, (byte) 115, (byte) 106, (byte) 196, (byte) 138, (byte) 210, (byte) 157, (byte) 78, (byte) 132, (byte) 169, (byte) 18, (byte) 3, (byte) 16, (byte) 65};
            private static byte[] __aes_iv_SaI6yWGP = {(byte) 147, (byte) 107, (byte) 23, (byte) 46, (byte) 226, (byte) 205, (byte) 146, (byte) 53, (byte) 6, (byte) 85, (byte) 150, (byte) 218, (byte) 123, (byte) 171, (byte) 14, (byte) 172};
            private static String __s_cache_rPQD66Mf_0;
            private static String __s_cache_HbZ52dQH_1;
            private static String __s_cache_NeJlUt8m_2;

            @Override // a.a.b.C
            public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return b2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + __getString_fhIrfhCZ_1() + b2 + __getString_hhLfwm13_2();
            }

            private static String __unused_2132() {
        return "Factory[type=";
    }

            private static String __getString_fhIrfhCZ_1() {
        return ",adapter=";
    }

            private static String __getString_hhLfwm13_2() {
        return "]";
    }
        };
    }

    public static <TT> C a(final Class<TT> cls, final Class<TT> cls2, final B<? super TT> b2) {
        return new C() { // from class: a.a.b.b.a.p.24
            private static byte[] __aes_key_0uUe3jgt = {(byte) 171, (byte) 209, (byte) 90, (byte) 191, (byte) 54, (byte) 181, (byte) 81, (byte) 240, (byte) 28, (byte) 130, (byte) 45, (byte) 193, (byte) 195, (byte) 230, (byte) 76, (byte) 12, (byte) 120, (byte) 128, (byte) 81, (byte) 230, (byte) 22, (byte) 244, (byte) 244, (byte) 85, (byte) 18, (byte) 55, (byte) 238, (byte) 187, (byte) 43, (byte) 16, (byte) 151, (byte) 206};
            private static byte[] __aes_iv_c8p4pVSa = {(byte) 149, (byte) 49, (byte) 22, (byte) 155, (byte) 44, (byte) 252, (byte) 221, (byte) 190, (byte) 11, (byte) 103, (byte) 81, (byte) 15, (byte) 6, (byte) 49, (byte) 90, (byte) 156};
            private static String __s_cache_CN905lfW_0;
            private static String __s_cache_C5Ue8DoP_1;
            private static String __s_cache_cxWfmBOs_2;
            private static String __s_cache_erz7YAYR_3;

            @Override // a.a.b.C
            public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return b2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + __getString_8nNghiCI_1() + cls.getName() + __getString_iOQOLA1p_2() + b2 + __getString_Wynh9NS3_3();
            }

            private static String __unused_2133() {
        return "Factory[type=";
    }

            private static String __getString_8nNghiCI_1() {
        return "+";
    }

            private static String __getString_iOQOLA1p_2() {
        return ",adapter=";
    }

            private static String __getString_Wynh9NS3_3() {
        return "]";
    }
        };
    }

    public static <TT> C b(final Class<TT> cls, final Class<? extends TT> cls2, final B<? super TT> b2) {
        return new C() { // from class: a.a.b.b.a.p.25
            private static byte[] __aes_key_WTRgDmBa = {(byte) 203, (byte) 78, (byte) 204, (byte) 240, (byte) 55, (byte) 207, (byte) 232, (byte) 255, (byte) 73, (byte) 102, (byte) 47, (byte) 67, (byte) 222, (byte) 248, (byte) 167, (byte) 205, (byte) 227, (byte) 42, (byte) 38, (byte) 15, (byte) 233, (byte) 29, (byte) 39, (byte) 145, (byte) 126, (byte) 238, (byte) 68, (byte) 46, (byte) 88, (byte) 224, (byte) 16, (byte) 207};
            private static byte[] __aes_iv_P6IDUwhL = {(byte) 214, (byte) 28, (byte) 187, (byte) 1, (byte) 55, (byte) 240, (byte) 103, (byte) 44, (byte) 129, (byte) 195, (byte) 160, (byte) 228, (byte) 225, (byte) 176, (byte) 162, (byte) 6};
            private static String __s_cache_LhWDbs6i_0;
            private static String __s_cache_BcMf8JLC_1;
            private static String __s_cache_puQaiLHC_2;
            private static String __s_cache_kuGM5msZ_3;

            @Override // a.a.b.C
            public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return b2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + __getString_NYYmECVz_1() + cls2.getName() + __getString_Cbq636hX_2() + b2 + __getString_jsmF0ZVf_3();
            }

            private static String __unused_2134() {
        return "Factory[type=";
    }

            private static String __getString_NYYmECVz_1() {
        return "+";
    }

            private static String __getString_Cbq636hX_2() {
        return ",adapter=";
    }

            private static String __getString_jsmF0ZVf_3() {
        return "]";
    }
        };
    }

    public static <T1> C b(final Class<T1> cls, final B<T1> b2) {
        return new C() { // from class: a.a.b.b.a.p.26
            private static byte[] __aes_key_V072s206 = {(byte) 192, (byte) 198, (byte) 110, (byte) 81, (byte) 75, (byte) 14, (byte) 47, (byte) 213, (byte) 180, (byte) 61, (byte) 231, (byte) 173, (byte) 22, (byte) 107, (byte) 185, (byte) 0, (byte) 60, (byte) 213, (byte) 144, (byte) 183, (byte) 23, (byte) 223, (byte) 133, (byte) 18, (byte) 178, (byte) 101, (byte) 184, (byte) 231, (byte) 235, (byte) 223, (byte) 46, (byte) 121};
            private static byte[] __aes_iv_fw4bBt0O = {(byte) 24, (byte) 203, (byte) 217, (byte) 114, (byte) 65, (byte) 202, (byte) 173, (byte) 14, (byte) 140, (byte) 10, (byte) 131, (byte) 43, (byte) 119, (byte) 159, (byte) 154, (byte) 136};
            private static String __s_cache_NH6sgSrk_0;
            private static String __s_cache_RZ69FXQn_1;
            private static String __s_cache_HNMf3MFP_2;

            @Override // a.a.b.C
            public <T2> B<T2> a(a.a.b.f fVar, a.a.b.c.a<T2> aVar) {
                final Class<? super T2> clsA = aVar.a();
                if (cls.isAssignableFrom(clsA)) {
                    return (B<T2>) new B<T1>() { // from class: a.a.b.b.a.p.26.1
                        private static byte[] __aes_key_42ACLvCn = {(byte) 205, (byte) 84, (byte) 70, (byte) 178, (byte) 140, (byte) 96, (byte) 36, (byte) 197, (byte) 154, (byte) 225, (byte) 255, (byte) 218, (byte) 29, (byte) 171, (byte) 82, (byte) 170, (byte) 117, (byte) 115, (byte) 154, (byte) 250, (byte) 174, (byte) 223, (byte) 35, (byte) 8, (byte) 12, (byte) 196, (byte) 13, (byte) 251, (byte) 81, (byte) 60, (byte) 197, (byte) 21};
                        private static byte[] __aes_iv_rreSZalt = {(byte) 51, (byte) 250, (byte) 83, (byte) 203, (byte) 211, (byte) 100, (byte) 158, (byte) 183, (byte) 113, (byte) 167, (byte) 84, (byte) 42, (byte) 255, (byte) 22, (byte) 161, (byte) 195};
                        private static String __s_cache_5Ka7LagX_0;
                        private static String __s_cache_kECmKONp_1;
                        private static String __s_cache_6lQmAtA6_2;

                        @Override // a.a.b.B
                        public void a(a.a.b.d.d dVar, T1 t1) {
                            b2.a(dVar, t1);
                        }

                        @Override // a.a.b.B
                        public T1 b(a.a.b.d.a aVar2) {
                            T1 t1 = (T1) b2.b(aVar2);
                            if (t1 == null || clsA.isInstance(t1)) {
                                return t1;
                            }
                            throw new v("Expected a " + clsA.getName() + __getString_CBhAB7EH_1() + t1.getClass().getName() + __getString_9q1WFRDG_2() + aVar2.r());
                        }

                        private static String __unused_2135() {
        return "Expected a ";
    }

                        private static String __getString_CBhAB7EH_1() {
        return " but was ";
    }

                        private static String __getString_9q1WFRDG_2() {
        return "; at path ";
    }
                    };
                }
                return null;
            }

            public String toString() {
                return __getString_hFUq7HfY_0() + cls.getName() + __getString_CafO3ux8_1() + b2 + __getString_YkoIDe5A_2();
            }

            private static String __getString_hFUq7HfY_0() {
        return "Factory[typeHierarchy=";
    }

            private static String __getString_CafO3ux8_1() {
        return ",adapter=";
    }

            private static String __getString_YkoIDe5A_2() {
        return "]";
    }
        };
    }
}

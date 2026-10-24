package a.a.b;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/z.class */
public enum z implements A {
    f97a { // from class: a.a.b.z.1
        @Override // a.a.b.A
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double b(a.a.b.d.a aVar) {
            return Double.valueOf(aVar.k());
        }
    },
    b { // from class: a.a.b.z.2
        @Override // a.a.b.A
        public Number b(a.a.b.d.a aVar) {
            return new a.a.b.b.g(aVar.h());
        }
    },
    c { // from class: a.a.b.z.3
        private static byte[] __aes_key_hO4PLPa5 = {(byte) 249, (byte) 100, (byte) 62, (byte) 152, (byte) 184, (byte) 186, (byte) 7, (byte) 4, (byte) 68, (byte) 101, (byte) 161, (byte) 87, (byte) 103, (byte) 25, (byte) 60, (byte) 242, (byte) 42, (byte) 240, (byte) 34, (byte) 42, (byte) 45, (byte) 255, (byte) 181, (byte) 202, (byte) 41, (byte) 177, (byte) 56, (byte) 24, (byte) 53, (byte) 246, (byte) 186, (byte) 180};
        private static byte[] __aes_iv_vRPTE5eR = {(byte) 247, (byte) 214, (byte) 47, (byte) 152, (byte) 210, (byte) 46, (byte) 163, (byte) 22, (byte) 128, (byte) 24, (byte) 37, (byte) 19, (byte) 16, (byte) 142, (byte) 83, (byte) 172};
        private static String __s_cache_jE61cgbg_0;
        private static String __s_cache_42Fo4xHz_1;
        private static String __s_cache_Gmd3aOg4_2;
        private static String __s_cache_rfJJJKIV_3;

        @Override // a.a.b.A
        public Number b(a.a.b.d.a aVar) throws IOException {
            String strH = aVar.h();
            if (strH.indexOf(46) >= 0) {
                return a(strH, aVar);
            }
            try {
                return Long.valueOf(Long.parseLong(strH));
            } catch (NumberFormatException e) {
                return a(strH, aVar);
            }
        }

        private Number a(String str, a.a.b.d.a aVar) throws a.a.b.d.e {
            try {
                Double dValueOf = Double.valueOf(str);
                if ((dValueOf.isInfinite() || dValueOf.isNaN()) && !aVar.s()) {
                    throw new a.a.b.d.e("JSON forbids NaN and infinities: " + dValueOf + __getString_Du0nuAhp_1() + aVar.r());
                }
                return dValueOf;
            } catch (NumberFormatException e) {
                throw new p(__getString_t059n8OY_2() + str + __getString_6IpyDFki_3() + aVar.r(), e);
            }
        }

        private static String __unused_1850() {
        return "JSON forbids NaN and infinities: ";
    }

        private static String __getString_Du0nuAhp_1() {
        return "; at path ";
    }

        private static String __getString_t059n8OY_2() {
        return "Cannot parse ";
    }

        private static String __getString_6IpyDFki_3() {
        return "; at path ";
    }
    },
    d { // from class: a.a.b.z.4
        private static byte[] __aes_key_k5JX2vd7 = {(byte) 234, (byte) 247, (byte) 187, (byte) 106, (byte) 91, (byte) 65, (byte) 152, (byte) 150, (byte) 145, (byte) 214, (byte) 82, (byte) 205, (byte) 113, (byte) 53, (byte) 252, (byte) 59, (byte) 188, (byte) 106, (byte) 94, (byte) 198, (byte) 149, (byte) 23, (byte) 92, (byte) 3, (byte) 244, (byte) 41, (byte) 65, (byte) 124, (byte) 38, (byte) 83, (byte) 53, (byte) 10};
        private static byte[] __aes_iv_LVOHXgV8 = {(byte) 203, (byte) 210, (byte) 236, (byte) 140, (byte) 151, (byte) 235, (byte) 63, (byte) 37, (byte) 141, (byte) 200, (byte) 83, (byte) 92, (byte) 168, (byte) 85, (byte) 107, (byte) 133};
        private static String __s_cache_b1Rjl4i3_0;
        private static String __s_cache_tHU1sDKd_1;

        @Override // a.a.b.A
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(a.a.b.d.a aVar) throws IOException {
            String strH = aVar.h();
            try {
                return a.a.b.b.j.a(strH);
            } catch (NumberFormatException e) {
                throw new p("Cannot parse " + strH + __getString_dBGOkM5z_1() + aVar.r(), e);
            }
        }

        private static String __unused_1851() {
        return "Cannot parse ";
    }

        private static String __getString_dBGOkM5z_1() {
        return "; at path ";
    }
    };

    private static byte[] __aes_key_qGWyIUcd = {(byte) 67, (byte) 239, (byte) 67, (byte) 86, (byte) 59, (byte) 78, (byte) 193, (byte) 155, (byte) 148, (byte) 86, (byte) 76, (byte) 143, (byte) 25, (byte) 160, (byte) 93, (byte) 174, (byte) 173, (byte) 24, (byte) 12, (byte) 5, (byte) 199, (byte) 131, (byte) 244, (byte) 206, (byte) 70, (byte) 195, (byte) 241, (byte) 64, (byte) 187, (byte) 59, (byte) 225, (byte) 49};
    private static byte[] __aes_iv_jMp1JKIr = {(byte) 172, (byte) 192, (byte) 59, (byte) 111, (byte) 228, (byte) 174, (byte) 175, (byte) 36, (byte) 40, (byte) 176, (byte) 47, (byte) 177, (byte) 167, (byte) 134, (byte) 254, (byte) 186};
    private static String __s_cache_QH3wWN8J_0;
    private static String __s_cache_cBG9vmeb_1;
    private static String __s_cache_GZEEy5Ig_2;
    private static String __s_cache_0Kcpmr0k_3;

    private static String __unused_1852() {
        return "DOUBLE";
    }

    private static String __unused_1853() {
        return "LAZILY_PARSED_NUMBER";
    }

    private static String __unused_1854() {
        return "LONG_OR_DOUBLE";
    }

    private static String __unused_1855() {
        return "BIG_DECIMAL";
    }
}

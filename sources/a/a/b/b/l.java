package a.a.b.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/l.class */
public class l {
    private static byte[] __aes_key_TddTBToW = {(byte) 198, (byte) 229, (byte) 219, (byte) 125, (byte) 115, (byte) 84, (byte) 128, (byte) 224, (byte) 200, (byte) 76, (byte) 83, (byte) 19, (byte) 123, (byte) 222, (byte) 207, (byte) 87, (byte) 201, (byte) 231, (byte) 72, (byte) 120, (byte) 16, (byte) 49, (byte) 129, (byte) 237, (byte) 102, (byte) 96, (byte) 242, (byte) 78, (byte) 13, (byte) 201, (byte) 113, (byte) 5};
    private static byte[] __aes_iv_lgv2NQVG = {(byte) 157, (byte) 230, (byte) 23, (byte) 34, (byte) 89, (byte) 10, (byte) 24, (byte) 61, (byte) 112, (byte) 30, (byte) 254, (byte) 22, (byte) 79, (byte) 228, (byte) 38, (byte) 71};
    private static String __s_cache_vsoVFlWq_0;
    private static String __s_cache_JxDX4gWK_1;
    private static String __s_cache_RGwU4pKk_2;
    private static String __s_cache_YQEUGLOw_3;
    private static String __s_cache_WHGztCdg_4;
    private static String __s_cache_rOJrdk1S_5;
    private static String __s_cache_l3CClKeU_6;
    private static String __s_cache_xEkWuGRD_7;
    private static String __s_cache_GKuU1G7t_8;

    private l() {
    }

    public static DateFormat a(int i, int i2) {
        return new SimpleDateFormat(a(i) + " " + b(i2), Locale.US);
    }

    private static String a(int i) {
        switch (i) {
            case 0:
                return "EEEE, MMMM d, yyyy";
            case 1:
                return "MMMM d, yyyy";
            case 2:
                return "MMM d, yyyy";
            case 3:
                return "M/d/yy";
            default:
                throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
    }

    private static String b(int i) {
        switch (i) {
            case 0:
            case 1:
                return "h:mm:ss a z";
            case 2:
                return "h:mm:ss a";
            case 3:
                return "h:mm a";
            default:
                throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
    }

    private static String __unused_1999() {
        return "M/d/yy";
    }

    private static String __unused_2000() {
        return "MMM d, yyyy";
    }

    private static String __unused_2001() {
        return "MMMM d, yyyy";
    }

    private static String __unused_2002() {
        return "EEEE, MMMM d, yyyy";
    }

    private static String __unused_2003() {
        return "Unknown DateFormat style: ";
    }

    private static String __unused_2004() {
        return "h:mm a";
    }

    private static String __unused_2005() {
        return "h:mm:ss a";
    }

    private static String __unused_2006() {
        return "h:mm:ss a z";
    }

    private static String __unused_2007() {
        return "Unknown DateFormat style: ";
    }
}

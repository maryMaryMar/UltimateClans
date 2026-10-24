package a.a.b.b;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/j.class */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f67a = 10000;
    private static byte[] __aes_key_5Z0NLdBr = {(byte) 140, (byte) 200, (byte) 70, (byte) 156, (byte) 30, (byte) 12, (byte) 3, (byte) 190, (byte) 208, (byte) 186, (byte) 164, (byte) 41, (byte) 183, (byte) 224, (byte) 35, (byte) 117, (byte) 172, (byte) 214, (byte) 152, (byte) 134, (byte) 169, (byte) 69, (byte) 196, (byte) 115, (byte) 28, (byte) 4, (byte) 49, (byte) 245, (byte) 24, (byte) 144, (byte) 239, (byte) 122};
    private static byte[] __aes_iv_lqGBz6FP = {(byte) 63, (byte) 237, (byte) 195, (byte) 79, (byte) 23, (byte) 252, (byte) 198, (byte) 187, (byte) 234, (byte) 76, (byte) 120, (byte) 82, (byte) 177, (byte) 249, (byte) 70, (byte) 151};
    private static String __s_cache_fpWzngnb_0;
    private static String __s_cache_XHTJhm4H_1;
    private static String __s_cache_sD1UPnHe_2;

    private j() {
    }

    private static void c(String str) {
        if (str.length() > f67a) {
            throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
        }
    }

    public static BigDecimal a(String str) {
        c(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) >= BaseObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS) {
            throw new NumberFormatException("Number has unsupported scale: " + str);
        }
        return bigDecimal;
    }

    public static BigInteger b(String str) {
        c(str);
        return new BigInteger(str);
    }

    private static String __unused_1995() {
        return "Number string too large: ";
    }

    private static String __unused_1996() {
        return "...";
    }

    private static String __unused_1997() {
        return "Number has unsupported scale: ";
    }
}

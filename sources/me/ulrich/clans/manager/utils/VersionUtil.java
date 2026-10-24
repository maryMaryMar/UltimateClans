package me.ulrich.clans.manager.utils;

import com.google.common.primitives.Ints;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/VersionUtil.class */
public class VersionUtil {
    public static Integer BUILD_VERSION;
    private static String PGw5JiUGpgOGRUxwt;
    private static volatile String YYLKzPFoYNGF7mYM;
    private static volatile String bT3m42Duo4mzpG6vDCe;
    private static String PCpIZkxjtOWd9wiyamH4qH;
    private static volatile String aTSaga1lrfRn7iDTL9;
    private static volatile String kooRBZh0rp5BK2cS;
    private static String Zl61oVmhlWJL6IbVfzG5NS;
    private static final byte[] zJTWP2nQNhrIdNKfTRQH = {(byte) 166, (byte) 145, (byte) 12, (byte) 219, (byte) 180, (byte) 172, (byte) 123, (byte) 122, (byte) 61, (byte) 110, (byte) 78, (byte) 165, (byte) 117, (byte) 102, (byte) 164, (byte) 34, (byte) 111, (byte) 157, (byte) 166, (byte) 139, (byte) 165, (byte) 22, (byte) 38, (byte) 157, (byte) 192, (byte) 191, (byte) 4, (byte) 40, (byte) 236, (byte) 250, (byte) 210, (byte) 153};
    private static final byte[] gCz4ynBjnvA7XIqCyQp = {(byte) 153, (byte) 100, (byte) 161, (byte) 100, (byte) 221, (byte) 233, (byte) 186, (byte) 81, (byte) 250, (byte) 255, (byte) 158, (byte) 2, (byte) 39, (byte) 59, (byte) 64, (byte) 115};
    private static final byte[] HOHMN2us4yNFe1b = {(byte) 219, (byte) 90, (byte) 34, (byte) 12, (byte) 9, (byte) 221, (byte) 2, (byte) 214, (byte) 118, (byte) 144, (byte) 147, (byte) 109, (byte) 0, (byte) 161, (byte) 81, (byte) 190};
    private static final byte[] i3zqKg5928ke4J6idC = {(byte) 146, (byte) 150, (byte) 114, (byte) 77, (byte) 22, (byte) 23, (byte) 103, (byte) 210, (byte) 187, (byte) 228, (byte) 192, (byte) 220, (byte) 24, (byte) 141, (byte) 39, (byte) 178, (byte) 98, (byte) 193, (byte) 236, (byte) 183, (byte) 43, (byte) 31, (byte) 59, (byte) 202, (byte) 183, (byte) 162, (byte) 22, (byte) 234, (byte) 187, (byte) 245, (byte) 156, (byte) 45};
    private static final byte[] Ttsm9Jksn5SyvIyjs = {(byte) 37, (byte) 214, (byte) 40, (byte) 47, (byte) 248, (byte) 137, (byte) 235, (byte) 90, (byte) 140, (byte) 235, (byte) 20, (byte) 98, (byte) 55, (byte) 45, (byte) 87, (byte) 75};
    public static String VERSION = "v" + String.valueOf(getCurrentVersion());
    public static String CLEAN_VERSION = VERSION.substring(0, VERSION.length() - 1);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/VersionUtil$VersionEnum.class */
    public enum VersionEnum {
        V17(0),
        V18(1),
        V19(2),
        V110(3),
        V111(4),
        V112(5),
        V113(6),
        V114(7),
        V115(8),
        V116(9),
        V117(10),
        V118(11),
        V119(12),
        V120(13),
        V121(14),
        V1211(15),
        V26(16),
        V261(17),
        V262(18),
        V263(19);

        private final int order;
        private static String OV8wHdOgTcnsz4BA8;
        private static String HIQ3CKfMY1tJZGX3bih;
        private static volatile String tFjsviI2e9e6r59r6Ed;
        private static volatile String HBoCJRm8ANxU3ZK;
        private static volatile String egBCBsyxsOENUqrWi1UFz3;
        private static String plj16DpJDynmmLsaE;
        private static String PxwHcRYTd2B1bCacbz2;
        private static String n1kgoTG5eWqE24Ix6E6X;
        private static String hgE8gM7V6kbJI7yx;
        private static String RiKYQ9i2K5vXlw;
        private static String yrB0lREEOCcOw83lzAhUG;
        private static volatile String MEX9rkGwkxMvupBw;
        private static volatile String Fa5Rgf2cNi5IxD;
        private static String GlyYYmXGiI8qY91Lm1I;
        private static String UFRqaTGg4RL51Q4hx;
        private static String acE8uZkJeQ7YHIveXLg;
        private static String aFvihEvT47Q1WCEB9;
        private static volatile String SNY4WTQn7CxIQVRgUGooi;
        private static String qwIVeK5rChpGpYxxt5;
        private static String dJs4vqF6YHf52jvdL;
        private static final byte[] DoIQBwOR7QjoAFGTeX = {(byte) 157, (byte) 24, (byte) 192, (byte) 140, (byte) 24, (byte) 81, (byte) 37, (byte) 239, (byte) 189, (byte) 90, (byte) 214, (byte) 124, (byte) 228, (byte) 18, (byte) 50, (byte) 109};
        private static final byte[] b8yfDvRaUVRfMhvKmsJ = {(byte) 104, (byte) 58, (byte) 123, (byte) 180, (byte) 247, (byte) 77, (byte) 34, (byte) 155, (byte) 149, (byte) 140, (byte) 188, (byte) 75, (byte) 226, (byte) 99, (byte) 16, (byte) 252};
        private static final byte[] p6fdkw3wqZgP1v = {(byte) 227, (byte) 254, (byte) 73, (byte) 237, (byte) 205, (byte) 236, (byte) 135, (byte) 207, (byte) 250, (byte) 105, (byte) 134, (byte) 61, (byte) 88, (byte) 29, (byte) 101, (byte) 200};
        private static final byte[] sQB0dYdS16Cjp7qlP = {(byte) 35, (byte) 6, (byte) 32, (byte) 178, (byte) 41, (byte) 54, (byte) 124, (byte) 222, (byte) 92, (byte) 120, (byte) 156, (byte) 44, (byte) 100, (byte) 63, (byte) 215, (byte) 8};
        private static final byte[] QLncgEYfZ1AL9NA = {(byte) 47, (byte) 163, (byte) 208, (byte) 57, (byte) 21, (byte) 183, (byte) 196, (byte) 183, (byte) 44, (byte) 94, (byte) 14, (byte) 136, (byte) 211, (byte) 164, (byte) 36, (byte) 191};
        private static final byte[] K23BkXbvXcOj0tf1ElGE = {(byte) 179, (byte) 132, (byte) 185, (byte) 194, (byte) 70, (byte) 1, (byte) 107, (byte) 158, (byte) 226, (byte) 199, (byte) 134, (byte) 45, (byte) 63, (byte) 217, (byte) 153, (byte) 165};
        private static final byte[] mSacQ9mAbkUcyZDP1F = {(byte) 130, (byte) 212, (byte) 86, (byte) 124, (byte) 162, (byte) 152, (byte) 63, (byte) 87, (byte) 150, (byte) 11, (byte) 80, (byte) 86, (byte) 159, (byte) 140, (byte) 139, (byte) 123};
        private static final byte[] iQl3sqRZyYUWBZtH9Z = {(byte) 43, (byte) 136, (byte) 143, (byte) 242, (byte) 34, (byte) 5, (byte) 204, (byte) 250, (byte) 42, (byte) 12, (byte) 109, (byte) 208, (byte) 92, (byte) 0, (byte) 80, (byte) 85};
        private static final byte[] i6FehckZAhxRbVg2pZIh = {(byte) 2, (byte) 106, (byte) 110, (byte) 74, (byte) 171, (byte) 204, (byte) 176, (byte) 58, (byte) 197, (byte) 148, (byte) 184, (byte) 124, (byte) 166, (byte) 120, (byte) 53, (byte) 171};
        private static final byte[] nR6gbctbuGLJACE9pG5MI = {(byte) 211, (byte) 90, (byte) 102, (byte) 244, (byte) 83, (byte) 79, (byte) 189, (byte) 72, (byte) 210, (byte) 28, (byte) 201, (byte) 56, (byte) 200, (byte) 156, (byte) 190, (byte) 37};
        private static final byte[] uLMrxTa7LL6kDUE = {(byte) 73, (byte) 217, (byte) 174, (byte) 33, (byte) 187, (byte) 93, (byte) 250, (byte) 112, (byte) 40, (byte) 251, (byte) 216, (byte) 69, (byte) 167, (byte) 178, (byte) 3, (byte) 114, (byte) 102, (byte) 128, (byte) 192, (byte) 232, (byte) 172, (byte) 240, (byte) 45, (byte) 240, (byte) 143, (byte) 96, (byte) 255, (byte) 1, (byte) 205, (byte) 52, (byte) 94, (byte) 129};
        private static final byte[] U1EgiG6rrBtt2n7fpfS = {(byte) 184, (byte) 158, (byte) 125, (byte) 123, (byte) 44, (byte) 130, (byte) 56, (byte) 120, (byte) 81, (byte) 204, (byte) 202, (byte) 102, (byte) 74, (byte) 154, (byte) 203, (byte) 195};

        VersionEnum(int i) {
            this.order = i;
        }

        public int getOrder() {
            return this.order;
        }

        private static String YDWa6U19xIRjpcszyrx() {
        return "V17";
    }

        private static String ILKt6dVB79hfzCBYCcbk() {
        return "V18";
    }

        private static String eS5NVMhtal3mSarDs2Mv() {
        return "V19";
    }

        private static String oyg4zGKnS6dtTTFL() {
        return "V110";
    }

        private static String nupS3athql2JSs6yAnDQ4() {
        return "V111";
    }

        private static String fj4pkn0JxziJUkiOZ() {
        return "V112";
    }

        private static String JTZC1ZKVwjQW0J() {
        return "V113";
    }

        private static String iMM7n6m4DompgF3HWB() {
        return "V114";
    }

        private static String Gp95jjaBAm0s5gfBH() {
        return "V115";
    }

        private static String agH0hrJ7OMWk0d8BMns() {
        return "V116";
    }

        private static String UrNMHkBNBY7th5TI() {
        return "V117";
    }

        private static String lNnrKtniNnGAcJM() {
        return "V118";
    }

        private static String rgNXQ8zwSezxpQtK() {
        return "V119";
    }

        private static String zx3Md21TOWE9OHO9TnK() {
        return "V120";
    }

        private static String Q8KhADDQhfqxVZ72QrIJID() {
        return "V121";
    }

        private static String ibnsPRd9cKT27JX() {
        return "V1211";
    }

        private static String L6bp0BhbImRMYX() {
        return "V26";
    }

        private static String UUs9X2VJuhjXijE() {
        return "V261";
    }

        private static String CsmvhKmZAaxPU47fAWM() {
        return "V262";
    }

        private static String EKyHGO84vh1Yvw1CFp() {
        return "V263";
    }
    }

    private static int getCurrentVersion() {
        Matcher matcher = Pattern.compile(tIZAQzjQdfP5lUJ8fgA()).matcher(Bukkit.getBukkitVersion());
        StringBuilder sb = new StringBuilder();
        if (matcher.find()) {
            sb.append(matcher.group(UTCvtzjdYDqDRo3HtzA()).replace(eE7P1sHBvuZsfq2Op9(), ""));
            String strGroup = matcher.group(RxWyFoejLjcPsdB());
            if (strGroup == null) {
                sb.append(xihedZJjIWgvAI());
            } else {
                sb.append(strGroup.replace(JpjmQ7jaUkMqU7BdUY(), ""));
            }
        }
        Integer numTryParse = Ints.tryParse(sb.toString());
        if (numTryParse == null) {
            return 0;
        }
        return numTryParse.intValue();
    }

    public static boolean is(@NotNull VersionEnum versionEnum) {
        return versionEnum.getOrder() == VersionEnum.valueOf(CLEAN_VERSION.toUpperCase()).getOrder();
    }

    public static boolean isCompatible(@NotNull VersionEnum versionEnum) {
        return VERSION.toLowerCase().contains(versionEnum.toString().toLowerCase());
    }

    public static boolean isAbove(@NotNull VersionEnum versionEnum) {
        return VersionEnum.valueOf(CLEAN_VERSION.toUpperCase()).getOrder() >= versionEnum.getOrder();
    }

    public static boolean isBelow(@NotNull VersionEnum versionEnum) {
        return VersionEnum.valueOf(CLEAN_VERSION.toUpperCase()).getOrder() <= versionEnum.getOrder();
    }

    public static boolean isBetween(@NotNull VersionEnum versionEnum, @NotNull VersionEnum versionEnum2) {
        return isAbove(versionEnum) && isBelow(versionEnum2);
    }

    public static boolean isMinecraftFamily(@NotNull VersionEnum versionEnum) {
        String str;
        String str2;
        Matcher matcher = Pattern.compile(HI1QHJRT3j68dveh9zrN()).matcher(Bukkit.getBukkitVersion());
        if (!matcher.find()) {
            return false;
        }
        int i = Integer.parseInt(matcher.group(1));
        int i2 = Integer.parseInt(matcher.group(2));
        String strGroup = matcher.group(3);
        int i3 = strGroup != null ? Integer.parseInt(strGroup) : 0;
        if (i == 1) {
            str = "V1" + i2;
            str2 = i3 > 0 ? "V1" + i2 + i3 : str;
        } else {
            str = "V" + i;
            str2 = i3 > 0 ? "V" + i + i3 : str;
        }
        return versionEnum.name().equalsIgnoreCase(str) || versionEnum.name().equalsIgnoreCase(str2);
    }

    static {
        BUILD_VERSION = 0;
        BUILD_VERSION = Ints.tryParse(VERSION.substring(VERSION.length() - 1, VERSION.length()));
        if (BUILD_VERSION == null) {
            BUILD_VERSION = 0;
        }
    }

    private static String tIZAQzjQdfP5lUJ8fgA() {
        return "(?<version>\\d+\\.\\d+)(?<patch>\\.\\d+)?";
    }

    private static String UTCvtzjdYDqDRo3HtzA() {
        return "version";
    }

    private static String eE7P1sHBvuZsfq2Op9() {
        return ".";
    }

    private static String RxWyFoejLjcPsdB() {
        return "patch";
    }

    private static String xihedZJjIWgvAI() {
        return "0";
    }

    private static String JpjmQ7jaUkMqU7BdUY() {
        return ".";
    }

    private static String HI1QHJRT3j68dveh9zrN() {
        return "^(\\d+)\\.(\\d+)(?:\\.(\\d+))?";
    }
}

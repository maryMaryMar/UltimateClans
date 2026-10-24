package me.ulrich.clans.manager.utils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/FormatNumber.class */
public class FormatNumber {
    private static volatile String N9vKJSaJCBADn5IqiqqKU;
    private static volatile String zqRfu4MOG5nnEc;
    private static volatile String o7gGMjwXbOZclpPw9DfBKt;
    private static volatile String V7uuUdXjCPRVc1MYTwjaV1;
    private static String pkXMDFVZtfrvkwJhG;
    private static String nWPWTB7WrBuQ9fX6LYuF6w;
    private static volatile String sBd9ViMKhLPBX6;
    private static volatile String ZsLoYXB45Q2U5th49Rx;
    private static String b8rCYNTuMTOc1N;
    private static volatile String lNm0pOw0LLccPo47;
    private static String ywTc2pK5Y7MWqb;
    private static volatile String auP1anTvhDaLaZY;
    private static final byte[] AFS5M8Qu5nIZYVU1e = {(byte) 146, (byte) 26, (byte) 231, (byte) 201, (byte) 55, (byte) 173, (byte) 247, (byte) 155, (byte) 187, (byte) 163, (byte) 13, (byte) 174, (byte) 178, (byte) 98, (byte) 1, (byte) 253};
    private static final byte[] HSiBuCkEE8gTLbZS = {(byte) 32, (byte) 119, (byte) 97, (byte) 103, (byte) 251, (byte) 154, (byte) 92, (byte) 206, (byte) 3, (byte) 27, (byte) 175, (byte) 231, (byte) 244, (byte) 229, (byte) 216, (byte) 215};
    private static final byte[] uf4wifQA7Diu5YZjeh = {(byte) 109, (byte) 147, (byte) 61, (byte) 76, (byte) 191, (byte) 193, (byte) 101, (byte) 7, (byte) 152, (byte) 108, (byte) 15, (byte) 92, (byte) 4, (byte) 61, (byte) 131, (byte) 185};
    private static final byte[] POcG6l8VXRGttJx2apE = {(byte) 133, (byte) 26, (byte) 170, (byte) 34, (byte) 187, (byte) 197, (byte) 212, (byte) 55, (byte) 99, (byte) 102, (byte) 129, (byte) 238, (byte) 24, (byte) 170, (byte) 65, (byte) 118};
    private static final byte[] wGR3O0jhKFRMGvQit608o = {(byte) 249, (byte) 251, (byte) 67, (byte) 93, (byte) 232, (byte) 187, (byte) 114, (byte) 72, (byte) 79, (byte) 54, (byte) 71, (byte) 63, (byte) 251, (byte) 67, (byte) 141, (byte) 97};
    private static final byte[] kWTafjeAq5D7TV6LJ5QE = {(byte) 33, (byte) 92, (byte) 99, (byte) 81, (byte) 99, (byte) 16, (byte) 62, (byte) 82, (byte) 34, (byte) 68, (byte) 114, (byte) 34, (byte) 75, (byte) 38, (byte) 141, (byte) 242, (byte) 170, (byte) 60, (byte) 209, (byte) 233, (byte) 157, (byte) 191, (byte) 163, (byte) 139, (byte) 192, (byte) 146, (byte) 13, (byte) 28, (byte) 226, (byte) 13, (byte) 107, (byte) 40};
    private static final byte[] dxfIuayoyF99pWwYlNeM = {(byte) 230, (byte) 29, (byte) 241, (byte) 175, (byte) 34, (byte) 173, (byte) 228, (byte) 200, (byte) 89, (byte) 17, (byte) 142, (byte) 207, (byte) 225, (byte) 125, (byte) 118, (byte) 156};
    private static final NavigableMap<Long, String> suffixes = new TreeMap();

    public static String format(long j) {
        if (j == Long.MIN_VALUE) {
            return format(-9223372036854775807L);
        }
        if (j < 0) {
            return "-" + format(-j);
        }
        if (j < 1000) {
            return Long.toString(j);
        }
        Map.Entry<Long, String> entryFloorEntry = suffixes.floorEntry(Long.valueOf(j));
        Long key = entryFloorEntry.getKey();
        String value = entryFloorEntry.getValue();
        long jLongValue = j / (key.longValue() / 10);
        if (jLongValue < 100 && ((double) jLongValue) / 10.0d != ((double) (jLongValue / 10))) {
            double d = jLongValue / 10.0d;
            return d + value;
        }
        long j2 = jLongValue / 10;
        return j2 + value;
    }

    public static String formatDouble(double d) {
        if (d >= 1.0E15d) {
            return String.format(Tl1NGDJ6l3YcEwUUBnz(), Double.valueOf(d / 1.0E15d));
        }
        if (d >= 1.0E12d) {
            return String.format(caupA5v2clrdXZp(), Double.valueOf(d / 1.0E12d));
        }
        if (d >= 1.0E9d) {
            return String.format(z4Rqk1PayoiYg6n(), Double.valueOf(d / 1.0E9d));
        }
        if (d >= 1000000.0d) {
            return String.format(F6Oiyg2bLKKEOCerZ(), Double.valueOf(d / 1000000.0d));
        }
        return d >= 1000.0d ? String.format(oyd0Pc7nvheQ69x(), Double.valueOf(d / 1000.0d)) : String.format(J0yxQcCoZ9ZKlJH3oqcFvx(), Double.valueOf(d));
    }

    static {
        suffixes.put(1000L, n9a4qYiC0s1SY380A38ydT());
        suffixes.put(1000000L, lgV7GADTgptHB69CHtrXHN());
        suffixes.put(1000000000L, rKka9Ix0A6TrEFxieesr());
        suffixes.put(1000000000000L, ziGKPyMsRAduyOo9j());
        suffixes.put(1000000000000000L, uGt6B2vPGdelv2iHU());
        suffixes.put(1000000000000000000L, DGsnDMTfp8B4z8());
    }

    private static String LTEGm8JKrTYHZSXlc5M(byte[] bArr) {
        return "";
    }

    private static String Tl1NGDJ6l3YcEwUUBnz() {
        return "%.2fQ";
    }

    private static String caupA5v2clrdXZp() {
        return "%.2fT";
    }

    private static String z4Rqk1PayoiYg6n() {
        return "%.2fB";
    }

    private static String F6Oiyg2bLKKEOCerZ() {
        return "%.2fM";
    }

    private static String oyd0Pc7nvheQ69x() {
        return "%.2fK";
    }

    private static String J0yxQcCoZ9ZKlJH3oqcFvx() {
        return "%.2f";
    }

    private static String n9a4qYiC0s1SY380A38ydT() {
        return "k";
    }

    private static String lgV7GADTgptHB69CHtrXHN() {
        return "M";
    }

    private static String rKka9Ix0A6TrEFxieesr() {
        return "G";
    }

    private static String ziGKPyMsRAduyOo9j() {
        return "T";
    }

    private static String uGt6B2vPGdelv2iHU() {
        return "P";
    }

    private static String DGsnDMTfp8B4z8() {
        return "E";
    }
}

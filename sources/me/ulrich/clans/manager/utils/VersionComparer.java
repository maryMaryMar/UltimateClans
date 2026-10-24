package me.ulrich.clans.manager.utils;

import java.util.ArrayList;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/VersionComparer.class */
public class VersionComparer implements Comparable<VersionComparer> {
    private final String version;
    private static String G2rVuO0iD528Iq;
    private static String tGO7GgQa4IinkIn9szkYw;
    private static volatile String owbSFkArD8u4FgFvVZ1N;
    private static String nFwcjnk79n03LB5wkiWb;
    private static volatile String du20benFXpr4Jlo6;
    private static final byte[] LYWRKhK6Zd2x1laiZGrZ4N = {(byte) 54, (byte) 107, (byte) 81, (byte) 176, (byte) 157, (byte) 201, (byte) 148, (byte) 146, (byte) 104, (byte) 193, (byte) 121, (byte) 102, (byte) 76, (byte) 30, (byte) 102, (byte) 243};
    private static final byte[] fMivhA3RNtIS4Pi = {(byte) 8, (byte) 105, (byte) 126, (byte) 134, (byte) 6, (byte) 149, (byte) 9, (byte) 123, (byte) 140, (byte) 246, (byte) 63, (byte) 153, (byte) 171, (byte) 17, (byte) 104, (byte) 166};
    private static final byte[] sTFWxbjHuiV9QqJJhXwq = {(byte) 31, (byte) 134, (byte) 135, (byte) 251, (byte) 170, (byte) 229, (byte) 94, (byte) 170, (byte) 143, (byte) 81, (byte) 74, (byte) 137, (byte) 194, (byte) 179, (byte) 244, (byte) 94, (byte) 37, (byte) 66, (byte) 70, (byte) 79, (byte) 168, (byte) 121, (byte) 33, (byte) 44, (byte) 6, (byte) 27, (byte) 91, (byte) 84, (byte) 91, (byte) 142, (byte) 236, (byte) 69, (byte) 23, (byte) 154, (byte) 193, (byte) 104, (byte) 214, (byte) 17, (byte) 244, (byte) 230, (byte) 27, (byte) 86, (byte) 252, (byte) 138, (byte) 230, (byte) 125, (byte) 5, (byte) 147};
    private static final byte[] QkuxWB1dAkMCra = {(byte) 86, (byte) 87, (byte) 134, (byte) 225, (byte) 216, (byte) 20, (byte) 146, (byte) 58, (byte) 212, (byte) 7, (byte) 218, (byte) 133, (byte) 59, (byte) 103, (byte) 137, (byte) 163, (byte) 110, (byte) 124, (byte) 52, (byte) 105, (byte) 194, (byte) 174, (byte) 54, (byte) 185, (byte) 174, (byte) 196, (byte) 119, (byte) 17, (byte) 44, (byte) 220, (byte) 106, (byte) 55};
    private static final byte[] QrnOdIXRGy2csNpx = {(byte) 26, (byte) 65, (byte) 197, (byte) 16, (byte) 146, (byte) 141, (byte) 174, (byte) 216, (byte) 234, (byte) 190, (byte) 167, (byte) 29, (byte) 173, (byte) 193, (byte) 211, (byte) 118};

    public String get() {
        return this.version;
    }

    public VersionComparer(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(udK7IJHQLDCNKgnTlt());
        }
        this.version = str.trim().toUpperCase();
    }

    @Override // java.lang.Comparable
    public int compareTo(VersionComparer versionComparer) {
        if (versionComparer == null) {
            return 1;
        }
        String[] strArrSplit = this.version.split(gdzgBOIjGHpkPQKUye6Klm(), 2);
        String[] strArrSplit2 = versionComparer.version.split(oslgAUWMNgPO6H6M(), 2);
        int[] iArrExtractMainVersionNumbers = extractMainVersionNumbers(strArrSplit[0]);
        int[] iArrExtractMainVersionNumbers2 = extractMainVersionNumbers(strArrSplit2[0]);
        int iMax = Math.max(iArrExtractMainVersionNumbers.length, iArrExtractMainVersionNumbers2.length);
        int i = 0;
        while (i < iMax) {
            int i2 = i < iArrExtractMainVersionNumbers.length ? iArrExtractMainVersionNumbers[i] : 0;
            int i3 = i < iArrExtractMainVersionNumbers2.length ? iArrExtractMainVersionNumbers2[i] : 0;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            i++;
        }
        String str = strArrSplit.length > 1 ? strArrSplit[1] : "";
        String str2 = strArrSplit2.length > 1 ? strArrSplit2[1] : "";
        if (str.isEmpty() && !str2.isEmpty()) {
            return 1;
        }
        if (str.isEmpty() || !str2.isEmpty()) {
            return str.compareTo(str2);
        }
        return -1;
    }

    private int[] extractMainVersionNumbers(String str) {
        String[] strArrSplit = str.split(RrnbHWeLmHZyGtqZ());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str2 : strArrSplit) {
            String strReplaceAll = str2.replaceAll(gQ4NwOzOZsjeTn2N(), "");
            if (!strReplaceAll.isEmpty()) {
                arrayList.add(Integer.valueOf(Integer.parseInt(strReplaceAll)));
            }
        }
        return arrayList.stream().mapToInt(num -> {
            return num.intValue();
        }).toArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VersionComparer) && compareTo((VersionComparer) obj) == 0;
    }

    private static String udK7IJHQLDCNKgnTlt() {
        return "Version can not be null or empty";
    }

    private static String gdzgBOIjGHpkPQKUye6Klm() {
        return "-";
    }

    private static String oslgAUWMNgPO6H6M() {
        return "-";
    }

    private static String RrnbHWeLmHZyGtqZ() {
        return "\\.";
    }

    private static String gQ4NwOzOZsjeTn2N() {
        return "\\D+";
    }
}

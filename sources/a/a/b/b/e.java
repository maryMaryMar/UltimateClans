package a.a.b.b;


/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/e.class */
public final class e {
    private static String __s_cache_iI3D6pYl_0;
    private static String __s_cache_pjZnSlKA_1;
    private static byte[] __aes_key_fbOz3sje = {(byte) 176, (byte) 251, (byte) 175, (byte) 186, (byte) 195, (byte) 210, (byte) 175, (byte) 63, (byte) 233, (byte) 135, (byte) 53, (byte) 83, (byte) 47, (byte) 48, (byte) 43, (byte) 132, (byte) 78, (byte) 221, (byte) 136, (byte) 41, (byte) 27, (byte) 26, (byte) 66, (byte) 72, (byte) 94, (byte) 143, (byte) 23, (byte) 45, (byte) 95, (byte) 224, (byte) 196, (byte) 159};
    private static byte[] __aes_iv_GHmk4G2u = {(byte) 17, (byte) 249, (byte) 175, (byte) 12, (byte) 108, (byte) 71, (byte) 62, (byte) 166, (byte) 74, (byte) 60, (byte) 242, (byte) 56, (byte) 78, (byte) 124, (byte) 57, (byte) 63};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f57a = c();

    private static int c() {
        return a(System.getProperty("java.version"));
    }

    static int a(String str) {
        int iB = b(str);
        if (iB == -1) {
            iB = c(str);
        }
        if (iB == -1) {
            return 6;
        }
        return iB;
    }

    private static int b(String str) {
        try {
            String[] strArrSplit = str.split("[._]", 3);
            int i = Integer.parseInt(strArrSplit[0]);
            return (i != 1 || strArrSplit.length <= 1) ? i : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int c(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int a() {
        return f57a;
    }

    public static boolean b() {
        return f57a >= 9;
    }

    private e() {
    }

    private static String __unused_1992() {
        return "java.version";
    }

    private static String __unused_1993() {
        return "[._]";
    }
}

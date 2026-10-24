package a.a.b;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: renamed from: a.a.b.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/c.class */
public enum EnumC0010c implements InterfaceC0011d {
    f72a { // from class: a.a.b.c.1
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return field.getName();
        }
    },
    b { // from class: a.a.b.c.2
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return a(field.getName());
        }
    },
    c { // from class: a.a.b.c.3
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return a(a(field.getName(), ' '));
        }
    },
    d { // from class: a.a.b.c.4
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return a(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    },
    e { // from class: a.a.b.c.5
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return a(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    },
    f { // from class: a.a.b.c.6
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return a(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    },
    g { // from class: a.a.b.c.7
        @Override // a.a.b.InterfaceC0011d
        public String a(Field field) {
            return a(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    private static byte[] __aes_key_lkdxk87D = {(byte) 198, (byte) 220, (byte) 226, (byte) 255, (byte) 135, (byte) 186, (byte) 164, (byte) 228, (byte) 16, (byte) 9, (byte) 40, (byte) 222, (byte) 210, (byte) 210, (byte) 167, (byte) 72, (byte) 41, (byte) 69, (byte) 52, (byte) 145, (byte) 139, (byte) 115, (byte) 122, (byte) 65, (byte) 128, (byte) 249, (byte) 186, (byte) 197, (byte) 12, (byte) 68, (byte) 227, (byte) 47};
    private static byte[] __aes_iv_t0jV2N0I = {(byte) 241, (byte) 13, (byte) 123, (byte) 43, (byte) 170, (byte) 80, (byte) 253, (byte) 254, (byte) 88, (byte) 52, (byte) 190, (byte) 100, (byte) 185, (byte) 109, (byte) 165, (byte) 229};
    private static String __s_cache_Y6dlb66g_0;
    private static String __s_cache_RDzvzCED_1;
    private static String __s_cache_U9hnbAQ0_2;
    private static String __s_cache_Om0aH59p_3;
    private static String __s_cache_d7hMdbYQ_4;
    private static String __s_cache_qBPTS2ha_5;
    private static String __s_cache_Q8rPcYnt_6;

    static String a(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                return i == 0 ? upperCase + str.substring(1) : str.substring(0, i) + upperCase + str.substring(i + 1);
            }
            i++;
        }
        return str;
    }

    private static String __unused_1828() {
        return "IDENTITY";
    }

    private static String __unused_1829() {
        return "UPPER_CAMEL_CASE";
    }

    private static String __unused_1830() {
        return "UPPER_CAMEL_CASE_WITH_SPACES";
    }

    private static String __unused_1831() {
        return "UPPER_CASE_WITH_UNDERSCORES";
    }

    private static String __unused_1832() {
        return "LOWER_CASE_WITH_UNDERSCORES";
    }

    private static String __unused_1833() {
        return "LOWER_CASE_WITH_DASHES";
    }

    private static String __unused_1834() {
        return "LOWER_CASE_WITH_DOTS";
    }
}

package a.a.b.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/a/a.class */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5a = "UTC";
    private static String __s_cache_vpnvLzDo_0;
    private static String __s_cache_jcRB9xLE_1;
    private static String __s_cache_1YFX6cJ0_2;
    private static String __s_cache_0S9VJkxT_3;
    private static String __s_cache_DVxl7eyT_4;
    private static String __s_cache_1PJNXtPD_5;
    private static String __s_cache_Y6VwTc6U_6;
    private static String __s_cache_e45iskgC_7;
    private static String __s_cache_GeAOGged_8;
    private static String __s_cache_7K64NcVc_9;
    private static String __s_cache_f9uZvy8f_10;
    private static String __s_cache_yd5rUy0D_11;
    private static String __s_cache_DwrHDcNV_12;
    private static String __s_cache_jsP1YyRb_13;
    private static String __s_cache_vMjyeJAx_14;
    private static String __s_cache_ytMUjgN8_15;
    private static String __s_cache_rhrdnUDs_16;
    private static String __s_cache_54TwcTwC_17;
    private static String __s_cache_flf7dy9x_18;
    private static String __s_cache_KUiynvIE_19;
    private static String __s_cache_iWl49bUx_20;
    private static String __s_cache_q6JPpzLO_21;
    private static String __s_cache_qMxnG1Y0_22;
    private static String __s_cache_qOeAuy6z_23;
    private static String __s_cache_Perjp2L7_24;
    private static String __s_cache_bBkIY7OA_25;
    private static String __s_cache_bjYGJWTA_26;
    private static String __s_cache_Gc9F9NgH_27;
    private static String __s_cache_KgYTr0D7_28;
    private static String __s_cache_Es9pp7s9_29;
    private static byte[] __aes_key_eb6TeTSC = {(byte) 191, (byte) 111, (byte) 69, (byte) 20, (byte) 178, (byte) 25, (byte) 81, (byte) 47, (byte) 25, (byte) 185, (byte) 255, (byte) 24, (byte) 163, (byte) 135, (byte) 43, (byte) 58, (byte) 41, (byte) 196, (byte) 161, (byte) 127, (byte) 249, (byte) 164, (byte) 230, (byte) 123, (byte) 75, (byte) 105, (byte) 32, (byte) 129, (byte) 170, (byte) 97, (byte) 31, (byte) 253};
    private static byte[] __aes_iv_DehnR2I4 = {(byte) 172, (byte) 74, (byte) 101, (byte) 218, (byte) 248, (byte) 75, (byte) 253, (byte) 13, (byte) 144, (byte) 250, (byte) 69, (byte) 223, (byte) 104, (byte) 49, (byte) 103, (byte) 215};
    private static final TimeZone b = TimeZone.getTimeZone("UTC");

    private a() {
    }

    public static String a(Date date) {
        return a(date, false, b);
    }

    public static String a(Date date, boolean z) {
        return a(date, z, b);
    }

    public static String a(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder("yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0) + (timeZone.getRawOffset() == 0 ? "Z".length() : "+hh:mm".length()));
        a(sb, gregorianCalendar.get(1), "yyyy".length());
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, "MM".length());
        sb.append('-');
        a(sb, gregorianCalendar.get(5), "dd".length());
        sb.append('T');
        a(sb, gregorianCalendar.get(11), "hh".length());
        sb.append(':');
        a(sb, gregorianCalendar.get(12), "mm".length());
        sb.append(':');
        a(sb, gregorianCalendar.get(13), "ss".length());
        if (z) {
            sb.append('.');
            a(sb, gregorianCalendar.get(14), "sss".length());
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int iAbs = Math.abs((offset / 60000) / 60);
            int iAbs2 = Math.abs((offset / 60000) % 60);
            sb.append(offset < 0 ? '-' : '+');
            a(sb, iAbs, "hh".length());
            sb.append(':');
            a(sb, iAbs2, "mm".length());
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i = index + 4;
            int iA = a(str, index, i);
            if (a(str, i, '-')) {
                i++;
            }
            int i2 = i;
            int i3 = i + 2;
            int iA2 = a(str, i2, i3);
            if (a(str, i3, '-')) {
                i3++;
            }
            int i4 = i3;
            int i5 = i3 + 2;
            int iA3 = a(str, i4, i5);
            int iA4 = 0;
            int iA5 = 0;
            int iA6 = 0;
            int i6 = 0;
            boolean zA = a(str, i5, 'T');
            if (!zA && str.length() <= i5) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iA, iA2 - 1, iA3);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i5);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i7 = i5 + 1;
                int i8 = i7 + 2;
                iA4 = a(str, i7, i8);
                if (a(str, i8, ':')) {
                    i8++;
                }
                int i9 = i8;
                i5 = i8 + 2;
                iA5 = a(str, i9, i5);
                if (a(str, i5, ':')) {
                    i5++;
                }
                if (str.length() > i5 && (cCharAt = str.charAt(i5)) != 'Z' && cCharAt != '+' && cCharAt != '-') {
                    int i10 = i5;
                    i5 += 2;
                    iA6 = a(str, i10, i5);
                    if (iA6 > 59 && iA6 < 63) {
                        iA6 = 59;
                    }
                    if (a(str, i5, '.')) {
                        int i11 = i5 + 1;
                        int iA7 = a(str, i11 + 1);
                        int iMin = Math.min(iA7, i11 + 3);
                        int iA8 = a(str, i11, iMin);
                        switch (iMin - i11) {
                            case 1:
                                i6 = iA8 * 100;
                                break;
                            case 2:
                                i6 = iA8 * 10;
                                break;
                            default:
                                i6 = iA8;
                                break;
                        }
                        i5 = iA7;
                    }
                }
            }
            if (str.length() <= i5) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 == 'Z') {
                timeZone = b;
                length = i5 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i5);
                String str2 = strSubstring.length() >= 5 ? strSubstring : strSubstring + "00";
                length = i5 + str2.length();
                if (str2.equals("+0000") || str2.equals("+00:00")) {
                    timeZone = b;
                } else {
                    String str3 = "GMT" + str2;
                    timeZone = TimeZone.getTimeZone(str3);
                    String id = timeZone.getID();
                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone.getID());
                    }
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iA);
            gregorianCalendar2.set(2, iA2 - 1);
            gregorianCalendar2.set(5, iA3);
            gregorianCalendar2.set(11, iA4);
            gregorianCalendar2.set(12, iA5);
            gregorianCalendar2.set(13, iA6);
            gregorianCalendar2.set(14, i6);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            String str4 = str == null ? null : '\"' + str + '\"';
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str4 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int a(String str, int i, int i2) {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3 = i;
        int i4 = 0;
        if (i3 < i2) {
            i3++;
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -iDigit;
        }
        while (i3 < i2) {
            int i5 = i3;
            i3++;
            int iDigit2 = Character.digit(str.charAt(i5), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - iDigit2;
        }
        return -i4;
    }

    private static void a(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int a(String str, int i) {
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                return i2;
            }
        }
        return str.length();
    }

    private static String __unused_2184() {
        return "yyyy-MM-ddThh:mm:ss";
    }

    private static String __unused_2185() {
        return ".sss";
    }

    private static String __unused_2186() {
        return "Z";
    }

    private static String __unused_2187() {
        return "+hh:mm";
    }

    private static String __unused_2188() {
        return "yyyy";
    }

    private static String __unused_2189() {
        return "MM";
    }

    private static String __unused_2190() {
        return "dd";
    }

    private static String __unused_2191() {
        return "hh";
    }

    private static String __unused_2192() {
        return "mm";
    }

    private static String __unused_2193() {
        return "ss";
    }

    private static String __unused_2194() {
        return "sss";
    }

    private static String __unused_2195() {
        return "hh";
    }

    private static String __unused_2196() {
        return "mm";
    }

    private static String __unused_2197() {
        return "No time zone indicator";
    }

    private static String __unused_2198() {
        return "00";
    }

    private static String __unused_2199() {
        return "+0000";
    }

    private static String __unused_2200() {
        return "+00:00";
    }

    private static String __unused_2201() {
        return "GMT";
    }

    private static String __unused_2202() {
        return ":";
    }

    private static String __unused_2203() {
        return "Mismatching time zone indicator: ";
    }

    private static String __unused_2204() {
        return " given, resolves to ";
    }

    private static String __unused_2205() {
        return "Invalid time zone indicator '";
    }

    private static String __unused_2206() {
        return "'";
    }

    private static String __unused_2207() {
        return "(";
    }

    private static String __unused_2208() {
        return ")";
    }

    private static String __unused_2209() {
        return "Failed to parse date [";
    }

    private static String __unused_2210() {
        return "]: ";
    }

    private static String __unused_2211() {
        return "Invalid number: ";
    }

    private static String __unused_2212() {
        return "Invalid number: ";
    }

    private static String __unused_2213() {
        return "UTC";
    }
}

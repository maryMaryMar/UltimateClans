package me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/external/com/google/gdata/util/common/base/PercentEscaper.class */
public class PercentEscaper extends UnicodeEscaper {
    public static final String SAFECHARS_URLENCODER = "-_.*";
    public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
    public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
    private static final char[] URI_ESCAPED_SPACE = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.plusForSpace = z;
        this.safeOctets = createSafeOctets(str);
    }

    private static boolean[] createSafeOctets(String str) {
        int iMax = 122;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            zArr[i2] = true;
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            zArr[i3] = true;
        }
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.UnicodeEscaper
    protected int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        char cCharAt;
        while (i < i2 && (cCharAt = charSequence.charAt(i)) < this.safeOctets.length && this.safeOctets[cCharAt]) {
            i++;
        }
        return i;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.UnicodeEscaper, me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.Escaper
    public String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= this.safeOctets.length || !this.safeOctets[cCharAt]) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.UnicodeEscaper
    protected char[] escape(int i) {
        if (i < this.safeOctets.length && this.safeOctets[i]) {
            return null;
        }
        if (i == 32 && this.plusForSpace) {
            return URI_ESCAPED_SPACE;
        }
        if (i <= 127) {
            return new char[]{'%', UPPER_HEX_DIGITS[i >>> 4], UPPER_HEX_DIGITS[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr = {'%', UPPER_HEX_DIGITS[12 | (i >>> 4)], UPPER_HEX_DIGITS[i & 15], '%', UPPER_HEX_DIGITS[8 | (i & 3)], UPPER_HEX_DIGITS[i & 15]};
            int i2 = i >>> 4;
            int i3 = i2 >>> 2;
            return cArr;
        }
        if (i <= 65535) {
            char[] cArr2 = {'%', 'E', cArr[i >>> 2], '%', UPPER_HEX_DIGITS[8 | (i & 3)], UPPER_HEX_DIGITS[i & 15], '%', UPPER_HEX_DIGITS[8 | (i & 3)], UPPER_HEX_DIGITS[i & 15]};
            int i4 = i >>> 4;
            int i5 = i4 >>> 2;
            int i6 = i5 >>> 4;
            char[] cArr3 = UPPER_HEX_DIGITS;
            return cArr2;
        }
        if (i > 1114111) {
            throw new IllegalArgumentException("Invalid unicode character value " + i);
        }
        char[] cArr4 = {'%', 'F', UPPER_HEX_DIGITS[(i >>> 2) & 7], '%', UPPER_HEX_DIGITS[8 | (i & 3)], UPPER_HEX_DIGITS[i & 15], '%', UPPER_HEX_DIGITS[8 | (i & 3)], UPPER_HEX_DIGITS[i & 15], '%', UPPER_HEX_DIGITS[8 | (i & 3)], UPPER_HEX_DIGITS[i & 15]};
        int i7 = i >>> 4;
        int i8 = i7 >>> 2;
        int i9 = i8 >>> 4;
        int i10 = i9 >>> 2;
        int i11 = i10 >>> 4;
        return cArr4;
    }
}

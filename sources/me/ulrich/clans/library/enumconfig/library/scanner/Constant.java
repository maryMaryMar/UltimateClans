package me.ulrich.clans.library.enumconfig.library.scanner;

import java.util.Arrays;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/scanner/Constant.class */
public final class Constant {
    private static final String FULL_LINEBR_S = "\r\n\u0085\u2028\u2029";
    private String content;
    boolean[] contains = new boolean[128];
    boolean noASCII;
    private static final String LINEBR_S = "\n\u0085\u2028\u2029";
    public static final Constant LINEBR = new Constant(LINEBR_S);
    private static final String NULL_OR_LINEBR_S = "\u0000\r\n\u0085\u2028\u2029";
    public static final Constant NULL_OR_LINEBR = new Constant(NULL_OR_LINEBR_S);
    private static final String NULL_BL_LINEBR_S = " \u0000\r\n\u0085\u2028\u2029";
    public static final Constant NULL_BL_LINEBR = new Constant(NULL_BL_LINEBR_S);
    private static final String NULL_BL_T_LINEBR_S = "\t \u0000\r\n\u0085\u2028\u2029";
    public static final Constant NULL_BL_T_LINEBR = new Constant(NULL_BL_T_LINEBR_S);
    private static final String NULL_BL_T_S = "\u0000 \t";
    public static final Constant NULL_BL_T = new Constant(NULL_BL_T_S);
    private static final String URI_CHARS_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%";
    public static final Constant URI_CHARS = new Constant(URI_CHARS_S);
    private static final String ALPHA_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    public static final Constant ALPHA = new Constant(ALPHA_S);

    private Constant(String str) {
        this.noASCII = false;
        Arrays.fill(this.contains, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt < 128) {
                this.contains[iCodePointAt] = true;
            } else {
                sb.appendCodePoint(iCodePointAt);
            }
        }
        if (sb.length() > 0) {
            this.noASCII = true;
            this.content = sb.toString();
        }
    }

    public boolean has(int i) {
        if (i < 128) {
            return this.contains[i];
        }
        return this.noASCII && this.content.indexOf(i) != -1;
    }

    public boolean hasNo(int i) {
        return !has(i);
    }

    public boolean has(int i, String str) {
        return has(i) || str.indexOf(i) != -1;
    }

    public boolean hasNo(int i, String str) {
        return !has(i, str);
    }
}

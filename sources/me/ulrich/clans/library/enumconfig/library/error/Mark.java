package me.ulrich.clans.library.enumconfig.library.error;

import java.io.Serializable;
import me.ulrich.clans.library.enumconfig.library.scanner.Constant;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/error/Mark.class */
public final class Mark implements Serializable {
    private final String name;
    private final int index;
    private final int line;
    private final int column;
    private final int[] buffer;
    private final int pointer;

    private static int[] toCodePoints(char[] cArr) {
        int[] iArr = new int[Character.codePointCount(cArr, 0, cArr.length)];
        int iCharCount = 0;
        int i = 0;
        while (iCharCount < cArr.length) {
            int iCodePointAt = Character.codePointAt(cArr, iCharCount);
            iArr[i] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i++;
        }
        return iArr;
    }

    public Mark(String str, int i, int i2, int i3, char[] cArr, int i4) {
        this(str, i, i2, i3, toCodePoints(cArr), i4);
    }

    public Mark(String str, int i, int i2, int i3, int[] iArr, int i4) {
        this.name = str;
        this.index = i;
        this.line = i2;
        this.column = i3;
        this.buffer = iArr;
        this.pointer = i4;
    }

    private boolean isLineBreak(int i) {
        return Constant.NULL_OR_LINEBR.has(i);
    }

    public String get_snippet(int i, int i2) {
        float f = (i2 / 2.0f) - 1.0f;
        int i3 = this.pointer;
        String str = "";
        while (i3 > 0 && !isLineBreak(this.buffer[i3 - 1])) {
            i3--;
            if (this.pointer - i3 > f) {
                str = " ... ";
                i3 += 5;
                break;
            }
        }
        String str2 = "";
        int i4 = this.pointer;
        while (i4 < this.buffer.length && !isLineBreak(this.buffer[i4])) {
            i4++;
            if (i4 - this.pointer > f) {
                str2 = " ... ";
                i4 -= 5;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i; i5++) {
            sb.append(" ");
        }
        sb.append(str);
        for (int i6 = i3; i6 < i4; i6++) {
            sb.appendCodePoint(this.buffer[i6]);
        }
        sb.append(str2);
        sb.append("\n");
        for (int i7 = 0; i7 < ((i + this.pointer) - i3) + str.length(); i7++) {
            sb.append(" ");
        }
        sb.append("^");
        return sb.toString();
    }

    public String get_snippet() {
        return get_snippet(4, 75);
    }

    public String toString() {
        return " in " + this.name + ", line " + (this.line + 1) + ", column " + (this.column + 1) + ":\n" + get_snippet();
    }

    public String getName() {
        return this.name;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public int getPointer() {
        return this.pointer;
    }
}

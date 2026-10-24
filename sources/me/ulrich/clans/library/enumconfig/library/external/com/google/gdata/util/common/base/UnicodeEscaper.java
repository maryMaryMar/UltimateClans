package me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base;

import java.io.IOException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/external/com/google/gdata/util/common/base/UnicodeEscaper.class */
public abstract class UnicodeEscaper implements Escaper {
    private static final int DEST_PAD = 32;
    private static final ThreadLocal<char[]> DEST_TL;
    static final /* synthetic */ boolean $assertionsDisabled;

    protected abstract char[] escape(int i);

    protected int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        int i3;
        int iCodePointAt;
        int i4 = i;
        while (true) {
            i3 = i4;
            if (i3 >= i2 || (iCodePointAt = codePointAt(charSequence, i3, i2)) < 0 || escape(iCodePointAt) != null) {
                break;
            }
            i4 = i3 + (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1);
        }
        return i3;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.Escaper
    public String escape(String str) {
        int length = str.length();
        int iNextEscapeIndex = nextEscapeIndex(str, 0, length);
        return iNextEscapeIndex == length ? str : escapeSlow(str, iNextEscapeIndex);
    }

    protected final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrGrowBuffer = DEST_TL.get();
        int length2 = 0;
        int i2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            if (cArrEscape != null) {
                int i3 = i - i2;
                int length3 = length2 + i3 + cArrEscape.length;
                if (cArrGrowBuffer.length < length3) {
                    cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, length3 + (length - i) + 32);
                }
                if (i3 > 0) {
                    str.getChars(i2, i, cArrGrowBuffer, length2);
                    length2 += i3;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrGrowBuffer, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
            }
            i2 = i + (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1);
            i = nextEscapeIndex(str, i2, length);
        }
        int i4 = length - i2;
        if (i4 > 0) {
            int i5 = length2 + i4;
            if (cArrGrowBuffer.length < i5) {
                cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, i5);
            }
            str.getChars(i2, length, cArrGrowBuffer, length2);
            length2 = i5;
        }
        return new String(cArrGrowBuffer, 0, length2);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.Escaper
    public Appendable escape(final Appendable appendable) {
        if ($assertionsDisabled || appendable != null) {
            return new Appendable() { // from class: me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.UnicodeEscaper.1
                int pendingHighSurrogate = -1;
                final char[] decodedChars = new char[2];

                @Override // java.lang.Appendable
                public Appendable append(CharSequence charSequence) {
                    return append(charSequence, 0, charSequence.length());
                }

                @Override // java.lang.Appendable
                public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
                    int i3 = i;
                    if (i3 < i2) {
                        int i4 = i3;
                        if (this.pendingHighSurrogate != -1) {
                            i3++;
                            char cCharAt = charSequence.charAt(i3);
                            if (!Character.isLowSurrogate(cCharAt)) {
                                throw new IllegalArgumentException("Expected low surrogate character but got " + cCharAt);
                            }
                            char[] cArrEscape = UnicodeEscaper.this.escape(Character.toCodePoint((char) this.pendingHighSurrogate, cCharAt));
                            if (cArrEscape != null) {
                                outputChars(cArrEscape, cArrEscape.length);
                                i4++;
                            } else {
                                appendable.append((char) this.pendingHighSurrogate);
                            }
                            this.pendingHighSurrogate = -1;
                        }
                        while (true) {
                            int iNextEscapeIndex = UnicodeEscaper.this.nextEscapeIndex(charSequence, i3, i2);
                            if (iNextEscapeIndex > i4) {
                                appendable.append(charSequence, i4, iNextEscapeIndex);
                            }
                            if (iNextEscapeIndex == i2) {
                                break;
                            }
                            int iCodePointAt = UnicodeEscaper.codePointAt(charSequence, iNextEscapeIndex, i2);
                            if (iCodePointAt < 0) {
                                this.pendingHighSurrogate = -iCodePointAt;
                                break;
                            }
                            char[] cArrEscape2 = UnicodeEscaper.this.escape(iCodePointAt);
                            if (cArrEscape2 != null) {
                                outputChars(cArrEscape2, cArrEscape2.length);
                            } else {
                                outputChars(this.decodedChars, Character.toChars(iCodePointAt, this.decodedChars, 0));
                            }
                            i3 = iNextEscapeIndex + (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1);
                            i4 = i3;
                        }
                    }
                    return this;
                }

                @Override // java.lang.Appendable
                public Appendable append(char c) throws IOException {
                    if (this.pendingHighSurrogate != -1) {
                        if (!Character.isLowSurrogate(c)) {
                            throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + ((int) c));
                        }
                        char[] cArrEscape = UnicodeEscaper.this.escape(Character.toCodePoint((char) this.pendingHighSurrogate, c));
                        if (cArrEscape != null) {
                            outputChars(cArrEscape, cArrEscape.length);
                        } else {
                            appendable.append((char) this.pendingHighSurrogate);
                            appendable.append(c);
                        }
                        this.pendingHighSurrogate = -1;
                    } else if (Character.isHighSurrogate(c)) {
                        this.pendingHighSurrogate = c;
                    } else {
                        if (Character.isLowSurrogate(c)) {
                            throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + ((int) c));
                        }
                        char[] cArrEscape2 = UnicodeEscaper.this.escape(c);
                        if (cArrEscape2 != null) {
                            outputChars(cArrEscape2, cArrEscape2.length);
                        } else {
                            appendable.append(c);
                        }
                    }
                    return this;
                }

                private void outputChars(char[] cArr, int i) throws IOException {
                    for (int i2 = 0; i2 < i; i2++) {
                        appendable.append(cArr[i2]);
                    }
                }
            };
        }
        throw new AssertionError();
    }

    protected static final int codePointAt(CharSequence charSequence, int i, int i2) {
        if (i >= i2) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i3 = i + 1;
        char cCharAt = charSequence.charAt(i);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + (i3 - 1));
        }
        if (i3 == i2) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i3);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i3);
    }

    private static final char[] growBuffer(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    static {
        $assertionsDisabled = !UnicodeEscaper.class.desiredAssertionStatus();
        DEST_TL = new ThreadLocal<char[]>() { // from class: me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.UnicodeEscaper.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public char[] initialValue() {
                return new char[1024];
            }
        };
    }
}

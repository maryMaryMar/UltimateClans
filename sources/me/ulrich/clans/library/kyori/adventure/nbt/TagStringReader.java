package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.apache.commons.pool2.impl.BaseGenericObjectPool;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/TagStringReader.class */
final class TagStringReader {
    private static final int MAX_DEPTH = 512;
    private static final int HEX_RADIX = 16;
    private static final int BINARY_RADIX = 2;
    private static final int DECIMAL_RADIX = 10;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private final CharBuffer buffer;
    private boolean acceptLegacy;
    private boolean acceptHeterogenousLists;
    private int depth;

    TagStringReader(CharBuffer charBuffer) {
        this.buffer = charBuffer;
    }

    public CompoundBinaryTag compound() throws StringTagParseException {
        this.buffer.expect('{');
        if (this.buffer.takeIf('}')) {
            return CompoundBinaryTag.empty();
        }
        CompoundBinaryTag.Builder builder = CompoundBinaryTag.builder();
        while (this.buffer.hasMore()) {
            builder.put(key(), tag());
            if (separatorOrCompleteWith('}')) {
                return builder.build();
            }
        }
        throw this.buffer.makeError("Unterminated compound tag!");
    }

    public ListBinaryTag list() throws StringTagParseException {
        ListBinaryTag.Builder<BinaryTag> builder = ListBinaryTag.builder();
        this.buffer.expect('[');
        boolean z = this.acceptLegacy && this.buffer.peek() == '0' && this.buffer.peek(1) == ':';
        if (!z && this.buffer.takeIf(']')) {
            return ListBinaryTag.empty();
        }
        while (this.buffer.hasMore()) {
            if (z) {
                this.buffer.takeUntil(':');
            }
            builder.add(tag());
            if (separatorOrCompleteWith(']')) {
                return builder.build();
            }
        }
        throw this.buffer.makeError("Reached end of file without end of list tag!");
    }

    public BinaryTag array(char c) throws StringTagParseException {
        this.buffer.expect('[').expect(c).expect(';');
        char lowerCase = Character.toLowerCase(c);
        if (lowerCase == 'b') {
            return ByteArrayBinaryTag.byteArrayBinaryTag(byteArray());
        }
        if (lowerCase == 'i') {
            return IntArrayBinaryTag.intArrayBinaryTag(intArray());
        }
        if (lowerCase == 'l') {
            return LongArrayBinaryTag.longArrayBinaryTag(longArray());
        }
        throw this.buffer.makeError("Type " + lowerCase + " is not a valid element type in an array!");
    }

    private byte[] byteArray() throws StringTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_BYTE_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        while (this.buffer.hasMore()) {
            try {
                arrayList.add(Byte.valueOf(this.buffer.skipWhitespace().takeUntil('b').toString()));
                if (separatorOrCompleteWith(']')) {
                    byte[] bArr = new byte[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        bArr[i] = ((Byte) arrayList.get(i)).byteValue();
                    }
                    return bArr;
                }
            } catch (NumberFormatException e) {
                throw this.buffer.makeError("All elements of a byte array must be bytes!");
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    private int[] intArray() throws StringTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_INT_ARRAY;
        }
        IntStream.Builder builder = IntStream.builder();
        while (this.buffer.hasMore()) {
            BinaryTag binaryTagTag = tag();
            if (!(binaryTagTag instanceof IntBinaryTag)) {
                throw this.buffer.makeError("All elements of an int array must be ints!");
            }
            builder.add(((IntBinaryTag) binaryTagTag).intValue());
            if (separatorOrCompleteWith(']')) {
                return builder.build().toArray();
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    private long[] longArray() throws StringTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_LONG_ARRAY;
        }
        LongStream.Builder builder = LongStream.builder();
        while (this.buffer.hasMore()) {
            try {
                builder.add(Long.parseLong(this.buffer.skipWhitespace().takeUntil('l').toString()));
                if (separatorOrCompleteWith(']')) {
                    return builder.build().toArray();
                }
            } catch (NumberFormatException e) {
                throw this.buffer.makeError("All elements of a long array must be longs!");
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    public String key() throws StringTagParseException {
        this.buffer.skipWhitespace();
        char cPeek = this.buffer.peek();
        try {
            if (cPeek == '\'' || cPeek == '\"') {
                String strUnescape = unescape(this.buffer.takeUntil(this.buffer.take()).toString());
                this.buffer.expect(':');
                return strUnescape;
            }
            StringBuilder sb = new StringBuilder();
            while (this.buffer.hasMore()) {
                char cPeek2 = this.buffer.peek();
                if (!Tokens.id(cPeek2)) {
                    if (!this.acceptLegacy) {
                        break;
                    }
                    if (cPeek2 != '\\') {
                        if (cPeek2 == ':') {
                            break;
                        }
                        sb.append(this.buffer.take());
                    } else {
                        this.buffer.take();
                    }
                } else {
                    sb.append(this.buffer.take());
                }
            }
            String string = sb.toString();
            this.buffer.expect(':');
            return string;
        } catch (Throwable th) {
            this.buffer.expect(':');
            throw th;
        }
    }

    public BinaryTag tag() throws StringTagParseException {
        int i = this.depth;
        this.depth = i + 1;
        if (i > 512) {
            throw this.buffer.makeError("Exceeded maximum allowed depth of 512 when reading tag");
        }
        try {
            char cPeek = this.buffer.skipWhitespace().peek();
            switch (cPeek) {
                case '\"':
                case '\'':
                    this.buffer.advance();
                    return StringBinaryTag.stringBinaryTag(unescape(this.buffer.takeUntil(cPeek).toString()));
                case '[':
                    return (this.buffer.hasMore(2) && this.buffer.peek(2) == ';') ? array(this.buffer.peek(1)) : list();
                case '{':
                    return compound();
                default:
                    return scalar();
            }
        } finally {
            this.depth--;
        }
    }

    private BinaryTag scalar() throws StringTagParseException {
        char cCharAt;
        StringBuilder sb = new StringBuilder();
        while (this.buffer.hasMore()) {
            char cPeek = this.buffer.peek();
            if (cPeek != '\\') {
                if (!Tokens.id(cPeek)) {
                    break;
                }
                this.buffer.advance();
            } else {
                this.buffer.advance();
                cPeek = this.buffer.take();
            }
            sb.append(cPeek);
        }
        if (sb.length() == 0) {
            throw this.buffer.makeError("Expected a value but got nothing");
        }
        String string = sb.toString();
        int iExtractRadix = extractRadix(sb, string);
        char cCharAt2 = sb.charAt(sb.length() - 1);
        boolean z = false;
        boolean z2 = iExtractRadix != 16;
        if (sb.length() > 2 && ((cCharAt = sb.charAt(sb.length() - 2)) == 's' || cCharAt == 'u')) {
            z = true;
            z2 = cCharAt == 's';
            sb.deleteCharAt(sb.length() - 2);
        }
        boolean z3 = false;
        char lowerCase = 'i';
        if (Tokens.numericType(cCharAt2) && (z || iExtractRadix != 16)) {
            z3 = true;
            lowerCase = Character.toLowerCase(cCharAt2);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (!z2 && (lowerCase == 'f' || lowerCase == 'd')) {
            throw this.buffer.makeError("Cannot create unsigned floating point numbers");
        }
        String strReplace = sb.toString().replace("_", "");
        if (z3) {
            try {
                NumberBinaryTag numberTag = parseNumberTag(strReplace, lowerCase, iExtractRadix, z2);
                if (numberTag != null) {
                    return numberTag;
                }
            } catch (NumberFormatException e) {
            }
        } else {
            try {
                return IntBinaryTag.intBinaryTag(parseInt(strReplace, iExtractRadix, z2));
            } catch (NumberFormatException e2) {
                if (strReplace.indexOf(46) != -1) {
                    try {
                        return DoubleBinaryTag.doubleBinaryTag(Double.parseDouble(strReplace));
                    } catch (NumberFormatException e3) {
                    }
                }
            }
        }
        if (string.equalsIgnoreCase("true")) {
            return ByteBinaryTag.ONE;
        }
        return string.equalsIgnoreCase("false") ? ByteBinaryTag.ZERO : StringBinaryTag.stringBinaryTag(string);
    }

    private int extractRadix(StringBuilder sb, String str) {
        int i;
        int i2 = 0;
        char cCharAt = sb.charAt(0);
        if (cCharAt == '+' || cCharAt == '-') {
            i2 = 1;
        }
        if (str.startsWith("0b", i2) || str.startsWith("0B", i2)) {
            i = 2;
        } else {
            i = (str.startsWith("0x", i2) || str.startsWith("0X", i2)) ? 16 : 10;
        }
        if (i != 10) {
            sb.delete(i2, 2 + i2);
        }
        return i;
    }

    @Nullable
    private NumberBinaryTag parseNumberTag(String str, char c, int i, boolean z) {
        switch (c) {
            case 'b':
                return ByteBinaryTag.byteBinaryTag(parseByte(str, i, z));
            case 'c':
            case 'e':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            default:
                return null;
            case BaseGenericObjectPool.MEAN_TIMING_STATS_CACHE_SIZE /* 100 */:
                double d = Double.parseDouble(str);
                if (Double.isFinite(d)) {
                    return DoubleBinaryTag.doubleBinaryTag(d);
                }
                return null;
            case 'f':
                float f = Float.parseFloat(str);
                if (Float.isFinite(f)) {
                    return FloatBinaryTag.floatBinaryTag(f);
                }
                return null;
            case 'i':
                return IntBinaryTag.intBinaryTag(parseInt(str, i, z));
            case 'l':
                return LongBinaryTag.longBinaryTag(parseLong(str, i, z));
            case 's':
                return ShortBinaryTag.shortBinaryTag(parseShort(str, i, z));
        }
    }

    private byte parseByte(String str, int i, boolean z) {
        if (z) {
            return Byte.parseByte(str, i);
        }
        int i2 = Integer.parseInt(str, i);
        if ((i2 >> 8) == 0) {
            return (byte) i2;
        }
        throw new NumberFormatException();
    }

    private short parseShort(String str, int i, boolean z) {
        if (z) {
            return Short.parseShort(str, i);
        }
        int i2 = Integer.parseInt(str, i);
        if ((i2 >> 16) == 0) {
            return (short) i2;
        }
        throw new NumberFormatException();
    }

    private int parseInt(String str, int i, boolean z) {
        return z ? Integer.parseInt(str, i) : Integer.parseUnsignedInt(str, i);
    }

    private long parseLong(String str, int i, boolean z) {
        return z ? Long.parseLong(str, i) : Long.parseUnsignedLong(str, i);
    }

    private boolean separatorOrCompleteWith(char c) throws StringTagParseException {
        if (this.buffer.takeIf(c)) {
            return true;
        }
        this.buffer.expect(',');
        return this.buffer.takeIf(c);
    }

    private static String unescape(String str) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf(92);
        if (iIndexOf2 == -1) {
            return str;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder(str.length());
        do {
            sb.append((CharSequence) str, i, iIndexOf2);
            i = iIndexOf2 + 1;
            iIndexOf = str.indexOf(92, i + 1);
            iIndexOf2 = iIndexOf;
        } while (iIndexOf != -1);
        sb.append(str.substring(i));
        return sb.toString();
    }

    public void legacy(boolean z) {
        this.acceptLegacy = z;
    }
}

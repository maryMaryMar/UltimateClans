package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/TagStringWriter.class */
final class TagStringWriter implements AutoCloseable {
    private final Appendable out;
    private final String indent;
    private int level;
    private boolean needsSeparator;
    private boolean legacy;

    TagStringWriter(Appendable appendable, String str) {
        this.out = appendable;
        this.indent = str;
    }

    public TagStringWriter legacy(boolean z) {
        this.legacy = z;
        return this;
    }

    public TagStringWriter writeTag(BinaryTag binaryTag) throws IOException {
        BinaryTagType<? extends BinaryTag> binaryTagTypeType = binaryTag.type();
        if (binaryTagTypeType == BinaryTagTypes.COMPOUND) {
            return writeCompound((CompoundBinaryTag) binaryTag);
        }
        if (binaryTagTypeType == BinaryTagTypes.LIST) {
            return writeList((ListBinaryTag) binaryTag);
        }
        if (binaryTagTypeType == BinaryTagTypes.BYTE_ARRAY) {
            return writeByteArray((ByteArrayBinaryTag) binaryTag);
        }
        if (binaryTagTypeType == BinaryTagTypes.INT_ARRAY) {
            return writeIntArray((IntArrayBinaryTag) binaryTag);
        }
        if (binaryTagTypeType == BinaryTagTypes.LONG_ARRAY) {
            return writeLongArray((LongArrayBinaryTag) binaryTag);
        }
        if (binaryTagTypeType == BinaryTagTypes.STRING) {
            return value(((StringBinaryTag) binaryTag).value(), (char) 0);
        }
        if (binaryTagTypeType == BinaryTagTypes.BYTE) {
            return value(Byte.toString(((ByteBinaryTag) binaryTag).value()), 'b');
        }
        if (binaryTagTypeType == BinaryTagTypes.SHORT) {
            return value(Short.toString(((ShortBinaryTag) binaryTag).value()), 's');
        }
        if (binaryTagTypeType == BinaryTagTypes.INT) {
            return value(Integer.toString(((IntBinaryTag) binaryTag).value()), 'i');
        }
        if (binaryTagTypeType == BinaryTagTypes.LONG) {
            return value(Long.toString(((LongBinaryTag) binaryTag).value()), Character.toUpperCase('l'));
        }
        if (binaryTagTypeType == BinaryTagTypes.FLOAT) {
            return value(Float.toString(((FloatBinaryTag) binaryTag).value()), 'f');
        }
        if (binaryTagTypeType == BinaryTagTypes.DOUBLE) {
            return value(Double.toString(((DoubleBinaryTag) binaryTag).value()), 'd');
        }
        throw new IOException("Unknown tag type: " + binaryTagTypeType);
    }

    private TagStringWriter writeCompound(CompoundBinaryTag compoundBinaryTag) throws IOException {
        beginCompound();
        for (Map.Entry<String, ? extends BinaryTag> entry : compoundBinaryTag) {
            key(entry.getKey());
            writeTag(entry.getValue());
        }
        endCompound();
        return this;
    }

    private TagStringWriter writeList(ListBinaryTag listBinaryTag) throws IOException {
        beginList();
        int i = 0;
        boolean z = prettyPrinting() && breakListElement(listBinaryTag.elementType());
        for (BinaryTag binaryTag : listBinaryTag) {
            printAndResetSeparator(!z);
            if (z) {
                newlineIndent();
            }
            if (this.legacy) {
                int i2 = i;
                i++;
                this.out.append(String.valueOf(i2));
                appendSeparator(':');
            }
            writeTag(binaryTag);
        }
        endList(z);
        return this;
    }

    private TagStringWriter writeByteArray(ByteArrayBinaryTag byteArrayBinaryTag) throws IOException {
        if (this.legacy) {
            throw new IOException("Legacy Mojangson only supports integer arrays!");
        }
        beginArray('b');
        char upperCase = Character.toUpperCase('b');
        for (byte b : ByteArrayBinaryTagImpl.value(byteArrayBinaryTag)) {
            printAndResetSeparator(true);
            value(Byte.toString(b), upperCase);
        }
        endArray();
        return this;
    }

    private TagStringWriter writeIntArray(IntArrayBinaryTag intArrayBinaryTag) throws IOException {
        if (this.legacy) {
            beginList();
        } else {
            beginArray('i');
        }
        for (int i : IntArrayBinaryTagImpl.value(intArrayBinaryTag)) {
            printAndResetSeparator(true);
            value(Integer.toString(i), 'i');
        }
        endArray();
        return this;
    }

    private TagStringWriter writeLongArray(LongArrayBinaryTag longArrayBinaryTag) throws IOException {
        if (this.legacy) {
            throw new IOException("Legacy Mojangson only supports integer arrays!");
        }
        beginArray('l');
        for (long j : LongArrayBinaryTagImpl.value(longArrayBinaryTag)) {
            printAndResetSeparator(true);
            value(Long.toString(j), 'l');
        }
        endArray();
        return this;
    }

    public TagStringWriter beginCompound() throws IOException {
        printAndResetSeparator(false);
        this.level++;
        this.out.append('{');
        return this;
    }

    public TagStringWriter endCompound() throws IOException {
        this.level--;
        newlineIndent();
        this.out.append('}');
        this.needsSeparator = true;
        return this;
    }

    public TagStringWriter key(String str) throws IOException {
        printAndResetSeparator(false);
        newlineIndent();
        writeMaybeQuoted(str, false);
        appendSeparator(':');
        return this;
    }

    public TagStringWriter value(String str, char c) throws IOException {
        if (c == 0) {
            writeMaybeQuoted(str, true);
        } else {
            this.out.append(str);
            if (c != 'i') {
                this.out.append(c);
            }
        }
        this.needsSeparator = true;
        return this;
    }

    public TagStringWriter beginList() throws IOException {
        printAndResetSeparator(false);
        this.level++;
        this.out.append('[');
        return this;
    }

    public TagStringWriter endList(boolean z) throws IOException {
        this.level--;
        if (z) {
            newlineIndent();
        }
        this.out.append(']');
        this.needsSeparator = true;
        return this;
    }

    private TagStringWriter beginArray(char c) throws IOException {
        beginList().out.append(Character.toUpperCase(c)).append(';');
        if (prettyPrinting()) {
            this.out.append(' ');
        }
        return this;
    }

    private TagStringWriter endArray() {
        return endList(false);
    }

    private void writeMaybeQuoted(String str, boolean z) throws IOException {
        if (!z) {
            for (int i = 0; i < str.length(); i++) {
                if (!Tokens.id(str.charAt(i))) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            this.out.append(str);
            return;
        }
        this.out.append('\"');
        this.out.append(escape(str, '\"'));
        this.out.append('\"');
    }

    private static String escape(String str, char c) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == c || cCharAt == '\\') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private void printAndResetSeparator(boolean z) throws IOException {
        if (this.needsSeparator) {
            this.out.append(',');
            if (z && prettyPrinting()) {
                this.out.append(' ');
            }
            this.needsSeparator = false;
        }
    }

    private boolean breakListElement(BinaryTagType<?> binaryTagType) {
        return binaryTagType == BinaryTagTypes.COMPOUND || binaryTagType == BinaryTagTypes.LIST || binaryTagType == BinaryTagTypes.BYTE_ARRAY || binaryTagType == BinaryTagTypes.INT_ARRAY || binaryTagType == BinaryTagTypes.LONG_ARRAY;
    }

    private boolean prettyPrinting() {
        return this.indent.length() > 0;
    }

    private void newlineIndent() throws IOException {
        if (prettyPrinting()) {
            this.out.append(Tokens.NEWLINE);
            for (int i = 0; i < this.level; i++) {
                this.out.append(this.indent);
            }
        }
    }

    private Appendable appendSeparator(char c) throws IOException {
        this.out.append(c);
        if (prettyPrinting()) {
            this.out.append(' ');
        }
        return this.out;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.level != 0) {
            throw new IllegalStateException("Document finished with unbalanced start and end objects");
        }
        if (this.out instanceof Writer) {
            ((Writer) this.out).flush();
        }
    }
}

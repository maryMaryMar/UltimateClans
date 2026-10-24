package org.json;

import java.io.Writer;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/StringBuilderWriter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/StringBuilderWriter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/StringBuilderWriter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/StringBuilderWriter.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/StringBuilderWriter.class */
public class StringBuilderWriter extends Writer {
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
        this.lock = this.builder;
    }

    public StringBuilderWriter(int i) {
        this.builder = new StringBuilder(i);
        this.lock = this.builder;
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.builder.append((char) i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        if (i < 0 || i > cArr.length || i2 < 0 || i + i2 > cArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        this.builder.append(cArr, i, i2);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.builder.append(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.builder.append((CharSequence) str, i, i + i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringBuilderWriter append(CharSequence charSequence) {
        write(String.valueOf(charSequence));
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringBuilderWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        return append(charSequence.subSequence(i, i2));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringBuilderWriter append(char c) {
        write(c);
        return this;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}

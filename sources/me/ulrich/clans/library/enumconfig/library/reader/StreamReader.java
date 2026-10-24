package me.ulrich.clans.library.enumconfig.library.reader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.scanner.Constant;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/reader/StreamReader.class */
public class StreamReader {
    private String name;
    private final Reader stream;
    private int[] dataWindow;
    private int dataLength;
    private int pointer;
    private boolean eof;
    private int index;
    private int documentIndex;
    private int line;
    private int column;
    private final char[] buffer;

    public StreamReader(String str) {
        this(new StringReader(str));
        this.name = "'string'";
    }

    public StreamReader(Reader reader) {
        this.pointer = 0;
        this.index = 0;
        this.documentIndex = 0;
        this.line = 0;
        this.column = 0;
        if (reader == null) {
            throw new NullPointerException("Reader must be provided.");
        }
        this.name = "'reader'";
        this.dataWindow = new int[0];
        this.dataLength = 0;
        this.stream = reader;
        this.eof = false;
        this.buffer = new char[1024];
    }

    public static boolean isPrintable(String str) {
        int length = str.length();
        int iCharCount = 0;
        while (true) {
            int i = iCharCount;
            if (i >= length) {
                return true;
            }
            int iCodePointAt = str.codePointAt(i);
            if (!isPrintable(iCodePointAt)) {
                return false;
            }
            iCharCount = i + Character.charCount(iCodePointAt);
        }
    }

    public static boolean isPrintable(int i) {
        return (i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133 || (i >= 160 && i <= 55295) || ((i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111));
    }

    public Mark getMark() {
        return new Mark(this.name, this.index, this.line, this.column, this.dataWindow, this.pointer);
    }

    public void forward() {
        forward(1);
    }

    public void forward(int i) {
        for (int i2 = 0; i2 < i && ensureEnoughData(); i2++) {
            int[] iArr = this.dataWindow;
            int i3 = this.pointer;
            this.pointer = i3 + 1;
            int i4 = iArr[i3];
            moveIndices(1);
            if (Constant.LINEBR.has(i4) || (i4 == 13 && ensureEnoughData() && this.dataWindow[this.pointer] != 10)) {
                this.line++;
                this.column = 0;
            } else if (i4 != 65279) {
                this.column++;
            }
        }
    }

    public int peek() {
        if (ensureEnoughData()) {
            return this.dataWindow[this.pointer];
        }
        return 0;
    }

    public int peek(int i) {
        if (ensureEnoughData(i)) {
            return this.dataWindow[this.pointer + i];
        }
        return 0;
    }

    public String prefix(int i) {
        if (i == 0) {
            return "";
        }
        return ensureEnoughData(i) ? new String(this.dataWindow, this.pointer, i) : new String(this.dataWindow, this.pointer, Math.min(i, this.dataLength - this.pointer));
    }

    public String prefixForward(int i) {
        String strPrefix = prefix(i);
        this.pointer += i;
        moveIndices(i);
        this.column += i;
        return strPrefix;
    }

    private boolean ensureEnoughData() {
        return ensureEnoughData(0);
    }

    private boolean ensureEnoughData(int i) {
        if (!this.eof && this.pointer + i >= this.dataLength) {
            update();
        }
        return this.pointer + i < this.dataLength;
    }

    private void update() {
        try {
            int i = this.stream.read(this.buffer, 0, this.buffer.length - 1);
            if (i > 0) {
                int i2 = this.dataLength - this.pointer;
                this.dataWindow = Arrays.copyOfRange(this.dataWindow, this.pointer, this.dataLength + i);
                if (Character.isHighSurrogate(this.buffer[i - 1])) {
                    if (this.stream.read(this.buffer, i, 1) == -1) {
                        throw new ReaderException(this.name, this.index + i, this.buffer[i - 1], "The last char is HighSurrogate (no LowSurrogate detected).");
                    }
                    i++;
                }
                int i3 = 32;
                int iCharCount = 0;
                while (iCharCount < i) {
                    int iCodePointAt = Character.codePointAt(this.buffer, iCharCount);
                    this.dataWindow[i2] = iCodePointAt;
                    if (isPrintable(iCodePointAt)) {
                        iCharCount += Character.charCount(iCodePointAt);
                    } else {
                        i3 = iCodePointAt;
                        iCharCount = i;
                    }
                    i2++;
                }
                this.dataLength = i2;
                this.pointer = 0;
                if (i3 != 32) {
                    throw new ReaderException(this.name, (this.index + i2) - 1, i3, "special characters are not allowed");
                }
            } else {
                this.eof = true;
            }
        } catch (IOException e) {
            throw new YAMLException(e);
        }
    }

    public int getColumn() {
        return this.column;
    }

    private void moveIndices(int i) {
        this.index += i;
        this.documentIndex += i;
    }

    public int getDocumentIndex() {
        return this.documentIndex;
    }

    public void resetDocumentIndex() {
        this.documentIndex = 0;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }
}

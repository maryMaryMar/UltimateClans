package me.ulrich.clans.library.enumconfig.library.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/reader/UnicodeReader.class */
public class UnicodeReader extends Reader {
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Charset UTF16BE = StandardCharsets.UTF_16BE;
    private static final Charset UTF16LE = StandardCharsets.UTF_16LE;
    PushbackInputStream internalIn;
    InputStreamReader internalIn2 = null;
    private static final int BOM_SIZE = 3;

    public UnicodeReader(InputStream inputStream) {
        this.internalIn = new PushbackInputStream(inputStream, 3);
    }

    public String getEncoding() {
        return this.internalIn2.getEncoding();
    }

    protected void init() throws IOException {
        Charset charset;
        int i;
        if (this.internalIn2 != null) {
            return;
        }
        byte[] bArr = new byte[3];
        int i2 = this.internalIn.read(bArr, 0, bArr.length);
        if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            charset = UTF8;
            i = i2 - 3;
        } else if (bArr[0] == -2 && bArr[1] == -1) {
            charset = UTF16BE;
            i = i2 - 2;
        } else if (bArr[0] == -1 && bArr[1] == -2) {
            charset = UTF16LE;
            i = i2 - 2;
        } else {
            charset = UTF8;
            i = i2;
        }
        if (i > 0) {
            this.internalIn.unread(bArr, i2 - i, i);
        }
        this.internalIn2 = new InputStreamReader(this.internalIn, charset.newDecoder().onUnmappableCharacter(CodingErrorAction.REPORT));
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        init();
        this.internalIn2.close();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        init();
        return this.internalIn2.read(cArr, i, i2);
    }
}

package me.module.multiserver.library.redis.jedis.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/RedisOutputStream.class */
public final class RedisOutputStream extends FilterOutputStream {
    protected final byte[] buf;
    protected int count;
    private static final int OUTPUT_BUFFER_SIZE = Integer.parseInt(System.getProperty("jedis.bufferSize.output", System.getProperty("jedis.bufferSize", "8192")));
    private static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    private static final byte[] DigitTens = {(byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 48, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 49, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 50, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 51, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 52, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 53, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 54, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 55, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 56, (byte) 57, (byte) 57, (byte) 57, (byte) 57, (byte) 57, (byte) 57, (byte) 57, (byte) 57, (byte) 57, (byte) 57};
    private static final byte[] DigitOnes = {(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57};
    private static final byte[] digits = {(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122};

    public RedisOutputStream(OutputStream outputStream) {
        this(outputStream, OUTPUT_BUFFER_SIZE);
    }

    public RedisOutputStream(OutputStream outputStream, int i) {
        super(outputStream);
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.buf = new byte[i];
    }

    private void flushBuffer() throws IOException {
        if (this.count > 0) {
            this.out.write(this.buf, 0, this.count);
            this.count = 0;
        }
    }

    public void write(byte b) throws IOException {
        if (this.count == this.buf.length) {
            flushBuffer();
        }
        byte[] bArr = this.buf;
        int i = this.count;
        this.count = i + 1;
        bArr[i] = b;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 >= this.buf.length) {
            flushBuffer();
            this.out.write(bArr, i, i2);
        } else {
            if (i2 >= this.buf.length - this.count) {
                flushBuffer();
            }
            System.arraycopy(bArr, i, this.buf, this.count, i2);
            this.count += i2;
        }
    }

    public void writeCrLf() throws IOException {
        if (2 >= this.buf.length - this.count) {
            flushBuffer();
        }
        byte[] bArr = this.buf;
        int i = this.count;
        this.count = i + 1;
        bArr[i] = 13;
        byte[] bArr2 = this.buf;
        int i2 = this.count;
        this.count = i2 + 1;
        bArr2[i2] = 10;
    }

    public void writeIntCrLf(int i) throws IOException {
        if (i < 0) {
            write((byte) 45);
            i = -i;
        }
        int i2 = 0;
        while (i > sizeTable[i2]) {
            i2++;
        }
        int i3 = i2 + 1;
        if (i3 >= this.buf.length - this.count) {
            flushBuffer();
        }
        int i4 = this.count + i3;
        while (i >= 65536) {
            int i5 = i / 100;
            int i6 = i - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            i = i5;
            int i7 = i4 - 1;
            this.buf[i7] = DigitOnes[i6];
            i4 = i7 - 1;
            this.buf[i4] = DigitTens[i6];
        }
        do {
            int i8 = (i * 52429) >>> 19;
            i4--;
            this.buf[i4] = digits[i - ((i8 << 3) + (i8 << 1))];
            i = i8;
        } while (i != 0);
        this.count += i3;
        writeCrLf();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }
}

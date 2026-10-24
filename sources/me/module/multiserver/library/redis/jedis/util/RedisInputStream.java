package me.module.multiserver.library.redis.jedis.util;

import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/RedisInputStream.class */
public class RedisInputStream extends FilterInputStream {
    private static final int INPUT_BUFFER_SIZE = Integer.parseInt(System.getProperty("jedis.bufferSize.input", System.getProperty("jedis.bufferSize", "8192")));
    protected final byte[] buf;
    protected int count;
    protected int limit;

    public RedisInputStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.buf = new byte[i];
    }

    public RedisInputStream(InputStream inputStream) {
        this(inputStream, INPUT_BUFFER_SIZE);
    }

    public byte readByte() {
        ensureFill();
        byte[] bArr = this.buf;
        int i = this.count;
        this.count = i + 1;
        return bArr[i];
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            ensureFill();
            byte[] bArr = this.buf;
            int i = this.count;
            this.count = i + 1;
            byte b = bArr[i];
            if (b == 13) {
                ensureFill();
                byte[] bArr2 = this.buf;
                int i2 = this.count;
                this.count = i2 + 1;
                byte b2 = bArr2[i2];
                if (b2 == 10) {
                    break;
                }
                sb.append((char) b);
                sb.append((char) b2);
            } else {
                sb.append((char) b);
            }
        }
        String string = sb.toString();
        if (string.length() == 0) {
            throw new JedisConnectionException("It seems like server has closed the connection.");
        }
        return string;
    }

    public byte[] readLineBytes() {
        ensureFill();
        int i = this.count;
        byte[] bArr = this.buf;
        while (i != this.limit) {
            int i2 = i;
            i++;
            if (bArr[i2] == 13) {
                if (i == this.limit) {
                    return readLineBytesSlowly();
                }
                i++;
                if (bArr[i] == 10) {
                    int i3 = (i - this.count) - 2;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, this.count, bArr2, 0, i3);
                    this.count = i;
                    return bArr2;
                }
            }
        }
        return readLineBytesSlowly();
    }

    private byte[] readLineBytesSlowly() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        while (true) {
            ensureFill();
            byte[] bArr = this.buf;
            int i = this.count;
            this.count = i + 1;
            byte b = bArr[i];
            if (b == 13) {
                ensureFill();
                byte[] bArr2 = this.buf;
                int i2 = this.count;
                this.count = i2 + 1;
                byte b2 = bArr2[i2];
                if (b2 == 10) {
                    break;
                }
                if (byteArrayOutputStream == null) {
                    byteArrayOutputStream = new ByteArrayOutputStream(16);
                }
                byteArrayOutputStream.write(b);
                byteArrayOutputStream.write(b2);
            } else {
                if (byteArrayOutputStream == null) {
                    byteArrayOutputStream = new ByteArrayOutputStream(16);
                }
                byteArrayOutputStream.write(b);
            }
        }
        return byteArrayOutputStream == null ? new byte[0] : byteArrayOutputStream.toByteArray();
    }

    public int readIntCrLf() {
        return (int) readLongCrLf();
    }

    public long readLongCrLf() {
        long j;
        byte[] bArr = this.buf;
        ensureFill();
        boolean z = bArr[this.count] == 45;
        if (z) {
            this.count++;
        }
        long j2 = 0;
        while (true) {
            j = j2;
            ensureFill();
            int i = this.count;
            this.count = i + 1;
            byte b = bArr[i];
            if (b == 13) {
                break;
            }
            j2 = ((j * 10) + ((long) b)) - 48;
        }
        ensureFill();
        int i2 = this.count;
        this.count = i2 + 1;
        if (bArr[i2] != 10) {
            throw new JedisConnectionException("Unexpected character!");
        }
        return z ? -j : j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        ensureFill();
        int iMin = Math.min(this.limit - this.count, i2);
        System.arraycopy(this.buf, this.count, bArr, i, iMin);
        this.count += iMin;
        return iMin;
    }

    private void ensureFill() {
        if (this.count >= this.limit) {
            try {
                this.limit = this.in.read(this.buf);
                this.count = 0;
                if (this.limit == -1) {
                    throw new JedisConnectionException("Unexpected end of stream.");
                }
            } catch (IOException e) {
                throw new JedisConnectionException(e);
            }
        }
    }
}

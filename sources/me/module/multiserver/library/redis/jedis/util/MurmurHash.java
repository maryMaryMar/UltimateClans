package me.module.multiserver.library.redis.jedis.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/MurmurHash.class */
public class MurmurHash implements Hashing {
    public static int hash(byte[] bArr, int i) {
        return hash(ByteBuffer.wrap(bArr), i);
    }

    public static int hash(byte[] bArr, int i, int i2, int i3) {
        return hash(ByteBuffer.wrap(bArr, i, i2), i3);
    }

    public static int hash(ByteBuffer byteBuffer, int i) {
        int i2;
        ByteOrder byteOrderOrder = byteBuffer.order();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        int i3 = i;
        int iRemaining = byteBuffer.remaining();
        while (true) {
            i2 = i3 ^ iRemaining;
            if (byteBuffer.remaining() < 4) {
                break;
            }
            int i4 = byteBuffer.getInt() * 1540483477;
            int i5 = (i4 ^ (i4 >>> 24)) * 1540483477;
            i3 = i2 * 1540483477;
            iRemaining = i5;
        }
        if (byteBuffer.remaining() > 0) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put(byteBuffer).rewind();
            i2 = (i2 ^ byteBufferOrder.getInt()) * 1540483477;
        }
        int i6 = (i2 ^ (i2 >>> 13)) * 1540483477;
        int i7 = i6 ^ (i6 >>> 15);
        byteBuffer.order(byteOrderOrder);
        return i7;
    }

    public static long hash64A(byte[] bArr, int i) {
        return hash64A(ByteBuffer.wrap(bArr), i);
    }

    public static long hash64A(byte[] bArr, int i, int i2, int i3) {
        return hash64A(ByteBuffer.wrap(bArr, i, i2), i3);
    }

    public static long hash64A(ByteBuffer byteBuffer, int i) {
        long j;
        ByteOrder byteOrderOrder = byteBuffer.order();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jRemaining = ((long) i) ^ (((long) byteBuffer.remaining()) * (-4132994306676758123L));
        while (true) {
            j = jRemaining;
            if (byteBuffer.remaining() < 8) {
                break;
            }
            long j2 = byteBuffer.getLong() * (-4132994306676758123L);
            jRemaining = (j ^ ((j2 ^ (j2 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        if (byteBuffer.remaining() > 0) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put(byteBuffer).rewind();
            j = (j ^ byteBufferOrder.getLong()) * (-4132994306676758123L);
        }
        long j3 = (j ^ (j >>> 47)) * (-4132994306676758123L);
        long j4 = j3 ^ (j3 >>> 47);
        byteBuffer.order(byteOrderOrder);
        return j4;
    }

    @Override // me.module.multiserver.library.redis.jedis.util.Hashing
    public long hash(byte[] bArr) {
        return hash64A(bArr, 305441741);
    }

    @Override // me.module.multiserver.library.redis.jedis.util.Hashing
    public long hash(String str) {
        return hash(SafeEncoder.encode(str));
    }
}

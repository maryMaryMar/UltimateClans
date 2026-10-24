package me.module.multiserver.library.redis.jedis.util;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/ByteArrayComparator.class */
public final class ByteArrayComparator {
    private ByteArrayComparator() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static int compare(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        int iMin = Math.min(length, length2);
        for (int i = 0; i < iMin; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b < b2) {
                return -1;
            }
            if (b > b2) {
                return 1;
            }
        }
        if (length < length2) {
            return -1;
        }
        return length > length2 ? 1 : 0;
    }
}

package me.module.multiserver.library.redis.jedis.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/SafeEncoder.class */
public final class SafeEncoder {
    public static volatile Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private SafeEncoder() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static byte[][] encodeMany(String... strArr) {
        byte[][] bArr = new byte[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = encode(strArr[i]);
        }
        return bArr;
    }

    public static byte[] encode(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null value cannot be sent to redis");
        }
        return str.getBytes(DEFAULT_CHARSET);
    }

    public static String encode(byte[] bArr) {
        return new String(bArr, DEFAULT_CHARSET);
    }

    public static Object encodeObject(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(encodeObject(it.next()));
        }
        return arrayList;
    }
}

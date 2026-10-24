package me.module.multiserver.library.redis.jedis.resps;

import me.module.multiserver.library.redis.jedis.util.KeyValue;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/KeyedListElement.class */
@Deprecated
public class KeyedListElement extends KeyValue<String, String> {
    public KeyedListElement(byte[] bArr, byte[] bArr2) {
        this(SafeEncoder.encode(bArr), SafeEncoder.encode(bArr2));
    }

    public KeyedListElement(String str, String str2) {
        super(str, str2);
    }

    @Deprecated
    public String getElement() {
        return (String) getValue();
    }
}

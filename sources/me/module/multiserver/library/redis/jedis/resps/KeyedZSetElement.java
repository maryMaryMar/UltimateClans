package me.module.multiserver.library.redis.jedis.resps;

import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/KeyedZSetElement.class */
public class KeyedZSetElement extends Tuple {
    private final String key;

    public KeyedZSetElement(byte[] bArr, byte[] bArr2, Double d) {
        super(bArr2, d);
        this.key = SafeEncoder.encode(bArr);
    }

    public KeyedZSetElement(String str, String str2, Double d) {
        super(str2, d);
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    @Override // me.module.multiserver.library.redis.jedis.resps.Tuple
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof KeyedZSetElement) && this.key.equals(((KeyedZSetElement) obj).key)) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // me.module.multiserver.library.redis.jedis.resps.Tuple
    public int hashCode() {
        return (31 * this.key.hashCode()) + super.hashCode();
    }

    @Override // me.module.multiserver.library.redis.jedis.resps.Tuple
    public String toString() {
        return "KeyedZSetElement{key=" + this.key + ", element='" + getElement() + "', score=" + getScore() + "} ";
    }
}

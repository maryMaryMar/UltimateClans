package me.module.multiserver.library.redis.jedis.args;

import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/args/RawableFactory.class */
public final class RawableFactory {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/args/RawableFactory$Raw.class */
    public static class Raw implements Rawable {
        private final byte[] raw;

        public Raw(byte[] bArr) {
            this.raw = bArr;
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/args/RawableFactory$RawString.class */
    public static class RawString extends Raw {
        public RawString(String str) {
            super(SafeEncoder.encode(str));
        }
    }

    public static Rawable from(int i) {
        return from(Protocol.toByteArray(i));
    }

    public static Rawable from(double d) {
        return from(Protocol.toByteArray(d));
    }

    public static Rawable from(byte[] bArr) {
        return new Raw(bArr);
    }

    public static Rawable from(String str) {
        return new RawString(str);
    }

    private RawableFactory() {
        throw new InstantiationError();
    }
}

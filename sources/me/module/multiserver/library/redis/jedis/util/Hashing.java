package me.module.multiserver.library.redis.jedis.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/Hashing.class */
public interface Hashing {
    public static final Hashing MURMUR_HASH = new MurmurHash();
    public static final ThreadLocal<MessageDigest> md5Holder = new ThreadLocal<>();
    public static final Hashing MD5 = new Hashing() { // from class: me.module.multiserver.library.redis.jedis.util.Hashing.1
        @Override // me.module.multiserver.library.redis.jedis.util.Hashing
        public long hash(String str) {
            return hash(SafeEncoder.encode(str));
        }

        @Override // me.module.multiserver.library.redis.jedis.util.Hashing
        public long hash(byte[] bArr) {
            try {
                if (md5Holder.get() == null) {
                    md5Holder.set(MessageDigest.getInstance("MD5"));
                }
                MessageDigest messageDigest = md5Holder.get();
                messageDigest.reset();
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                return (((long) (bArrDigest[3] & 255)) << 24) | (((long) (bArrDigest[2] & 255)) << 16) | (((long) (bArrDigest[1] & 255)) << 8) | ((long) (bArrDigest[0] & 255));
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("++++ no md5 algorithm found");
            }
        }
    };

    long hash(String str);

    long hash(byte[] bArr);
}

package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisException.class */
public class JedisException extends RuntimeException {
    private static final long serialVersionUID = -2946266495682282677L;

    public JedisException(String str) {
        super(str);
    }

    public JedisException(Throwable th) {
        super(th);
    }

    public JedisException(String str, Throwable th) {
        super(str, th);
    }
}

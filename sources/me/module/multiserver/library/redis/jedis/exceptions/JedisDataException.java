package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisDataException.class */
public class JedisDataException extends JedisException {
    private static final long serialVersionUID = 3878126572474819403L;

    public JedisDataException(String str) {
        super(str);
    }

    public JedisDataException(Throwable th) {
        super(th);
    }

    public JedisDataException(String str, Throwable th) {
        super(str, th);
    }
}

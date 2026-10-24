package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisClusterException.class */
public class JedisClusterException extends JedisDataException {
    private static final long serialVersionUID = 3878126572474819403L;

    public JedisClusterException(Throwable th) {
        super(th);
    }

    public JedisClusterException(String str, Throwable th) {
        super(str, th);
    }

    public JedisClusterException(String str) {
        super(str);
    }
}

package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisClusterOperationException.class */
public class JedisClusterOperationException extends JedisException {
    private static final long serialVersionUID = 8124535086306604887L;

    public JedisClusterOperationException(String str) {
        super(str);
    }

    public JedisClusterOperationException(Throwable th) {
        super(th);
    }

    public JedisClusterOperationException(String str, Throwable th) {
        super(str, th);
    }
}

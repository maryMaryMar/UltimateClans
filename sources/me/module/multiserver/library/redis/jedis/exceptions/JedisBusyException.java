package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisBusyException.class */
public class JedisBusyException extends JedisDataException {
    private static final long serialVersionUID = 3992655220229243478L;

    public JedisBusyException(String str) {
        super(str);
    }

    public JedisBusyException(Throwable th) {
        super(th);
    }

    public JedisBusyException(String str, Throwable th) {
        super(str, th);
    }
}

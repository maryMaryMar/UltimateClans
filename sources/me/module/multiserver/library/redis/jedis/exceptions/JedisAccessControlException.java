package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisAccessControlException.class */
public class JedisAccessControlException extends JedisDataException {
    public JedisAccessControlException(String str) {
        super(str);
    }

    public JedisAccessControlException(Throwable th) {
        super(th);
    }

    public JedisAccessControlException(String str, Throwable th) {
        super(str, th);
    }
}

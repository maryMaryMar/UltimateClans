package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/InvalidURIException.class */
public class InvalidURIException extends JedisException {
    private static final long serialVersionUID = -781691993326357802L;

    public InvalidURIException(String str) {
        super(str);
    }

    public InvalidURIException(Throwable th) {
        super(th);
    }

    public InvalidURIException(String str, Throwable th) {
        super(str, th);
    }
}

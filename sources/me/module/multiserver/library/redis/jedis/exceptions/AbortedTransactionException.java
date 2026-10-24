package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/AbortedTransactionException.class */
public class AbortedTransactionException extends JedisDataException {
    public AbortedTransactionException(String str) {
        super(str);
    }

    public AbortedTransactionException(Throwable th) {
        super(th);
    }

    public AbortedTransactionException(String str, Throwable th) {
        super(str, th);
    }
}

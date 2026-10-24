package me.module.multiserver.library.redis.jedis.exceptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisNoScriptException.class */
public class JedisNoScriptException extends JedisDataException {
    private static final long serialVersionUID = 4674378093072060731L;

    public JedisNoScriptException(String str) {
        super(str);
    }

    public JedisNoScriptException(Throwable th) {
        super(th);
    }

    public JedisNoScriptException(String str, Throwable th) {
        super(str, th);
    }
}

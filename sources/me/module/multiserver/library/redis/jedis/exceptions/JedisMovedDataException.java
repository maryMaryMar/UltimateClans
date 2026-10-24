package me.module.multiserver.library.redis.jedis.exceptions;

import me.module.multiserver.library.redis.jedis.HostAndPort;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisMovedDataException.class */
public class JedisMovedDataException extends JedisRedirectionException {
    private static final long serialVersionUID = 3878126572474819403L;

    public JedisMovedDataException(String str, HostAndPort hostAndPort, int i) {
        super(str, hostAndPort, i);
    }

    public JedisMovedDataException(Throwable th, HostAndPort hostAndPort, int i) {
        super(th, hostAndPort, i);
    }

    public JedisMovedDataException(String str, Throwable th, HostAndPort hostAndPort, int i) {
        super(str, th, hostAndPort, i);
    }
}

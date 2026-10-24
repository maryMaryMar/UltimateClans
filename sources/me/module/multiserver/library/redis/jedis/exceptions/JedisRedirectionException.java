package me.module.multiserver.library.redis.jedis.exceptions;

import me.module.multiserver.library.redis.jedis.HostAndPort;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/exceptions/JedisRedirectionException.class */
public class JedisRedirectionException extends JedisDataException {
    private static final long serialVersionUID = 3878126572474819403L;
    private final HostAndPort targetNode;
    private final int slot;

    public JedisRedirectionException(String str, HostAndPort hostAndPort, int i) {
        super(str);
        this.targetNode = hostAndPort;
        this.slot = i;
    }

    public JedisRedirectionException(Throwable th, HostAndPort hostAndPort, int i) {
        super(th);
        this.targetNode = hostAndPort;
        this.slot = i;
    }

    public JedisRedirectionException(String str, Throwable th, HostAndPort hostAndPort, int i) {
        super(str, th);
        this.targetNode = hostAndPort;
        this.slot = i;
    }

    public final HostAndPort getTargetNode() {
        return this.targetNode;
    }

    public final int getSlot() {
        return this.slot;
    }
}

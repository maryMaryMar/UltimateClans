package me.module.multiserver.library.redis.jedis;

import java.io.Serializable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/HostAndPort.class */
public class HostAndPort implements Serializable {
    private static final long serialVersionUID = -519876229978427751L;
    private final String host;
    private final int port;

    public HostAndPort(String str, int i) {
        this.host = str;
        this.port = i;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return this.port == hostAndPort.port && this.host.equals(hostAndPort.host);
    }

    public int hashCode() {
        return (31 * this.host.hashCode()) + this.port;
    }

    public String toString() {
        return this.host + ":" + this.port;
    }

    public static HostAndPort from(String str) {
        int iLastIndexOf = str.lastIndexOf(":");
        return new HostAndPort(str.substring(0, iLastIndexOf), Integer.parseInt(str.substring(iLastIndexOf + 1)));
    }
}

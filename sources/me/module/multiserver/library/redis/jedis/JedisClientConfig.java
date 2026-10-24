package me.module.multiserver.library.redis.jedis;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisClientConfig.class */
public interface JedisClientConfig {
    default int getConnectionTimeoutMillis() {
        return 2000;
    }

    default int getSocketTimeoutMillis() {
        return 2000;
    }

    default int getBlockingSocketTimeoutMillis() {
        return 0;
    }

    default String getUser() {
        return null;
    }

    default String getPassword() {
        return null;
    }

    default void updatePassword(String str) {
    }

    default int getDatabase() {
        return 0;
    }

    default String getClientName() {
        return null;
    }

    default boolean isSsl() {
        return false;
    }

    default SSLSocketFactory getSslSocketFactory() {
        return null;
    }

    default SSLParameters getSslParameters() {
        return null;
    }

    default HostnameVerifier getHostnameVerifier() {
        return null;
    }

    default HostAndPortMapper getHostAndPortMapper() {
        return null;
    }
}

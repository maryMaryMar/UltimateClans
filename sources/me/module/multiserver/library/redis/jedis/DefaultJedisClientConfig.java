package me.module.multiserver.library.redis.jedis;

import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/DefaultJedisClientConfig.class */
public final class DefaultJedisClientConfig implements JedisClientConfig {
    private final int connectionTimeoutMillis;
    private final int socketTimeoutMillis;
    private final int blockingSocketTimeoutMillis;
    private final String user;
    private volatile String password;
    private final int database;
    private final String clientName;
    private final boolean ssl;
    private final SSLSocketFactory sslSocketFactory;
    private final SSLParameters sslParameters;
    private final HostnameVerifier hostnameVerifier;
    private final HostAndPortMapper hostAndPortMapper;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/DefaultJedisClientConfig$Builder.class */
    public static class Builder {
        private int connectionTimeoutMillis;
        private int socketTimeoutMillis;
        private int blockingSocketTimeoutMillis;
        private String user;
        private String password;
        private int database;
        private String clientName;
        private boolean ssl;
        private SSLSocketFactory sslSocketFactory;
        private SSLParameters sslParameters;
        private HostnameVerifier hostnameVerifier;
        private HostAndPortMapper hostAndPortMapper;

        private Builder() {
            this.connectionTimeoutMillis = 2000;
            this.socketTimeoutMillis = 2000;
            this.blockingSocketTimeoutMillis = 0;
            this.user = null;
            this.password = null;
            this.database = 0;
            this.clientName = null;
            this.ssl = false;
            this.sslSocketFactory = null;
            this.sslParameters = null;
            this.hostnameVerifier = null;
            this.hostAndPortMapper = null;
        }

        public DefaultJedisClientConfig build() {
            return new DefaultJedisClientConfig(this.connectionTimeoutMillis, this.socketTimeoutMillis, this.blockingSocketTimeoutMillis, this.user, this.password, this.database, this.clientName, this.ssl, this.sslSocketFactory, this.sslParameters, this.hostnameVerifier, this.hostAndPortMapper);
        }

        public Builder timeoutMillis(int i) {
            this.connectionTimeoutMillis = i;
            this.socketTimeoutMillis = i;
            return this;
        }

        public Builder connectionTimeoutMillis(int i) {
            this.connectionTimeoutMillis = i;
            return this;
        }

        public Builder socketTimeoutMillis(int i) {
            this.socketTimeoutMillis = i;
            return this;
        }

        public Builder blockingSocketTimeoutMillis(int i) {
            this.blockingSocketTimeoutMillis = i;
            return this;
        }

        public Builder user(String str) {
            this.user = str;
            return this;
        }

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder database(int i) {
            this.database = i;
            return this;
        }

        public Builder clientName(String str) {
            this.clientName = str;
            return this;
        }

        public Builder ssl(boolean z) {
            this.ssl = z;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public Builder sslParameters(SSLParameters sSLParameters) {
            this.sslParameters = sSLParameters;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder hostAndPortMapper(HostAndPortMapper hostAndPortMapper) {
            this.hostAndPortMapper = hostAndPortMapper;
            return this;
        }
    }

    private DefaultJedisClientConfig(int i, int i2, int i3, String str, String str2, int i4, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier, HostAndPortMapper hostAndPortMapper) {
        this.connectionTimeoutMillis = i;
        this.socketTimeoutMillis = i2;
        this.blockingSocketTimeoutMillis = i3;
        this.user = str;
        this.password = str2;
        this.database = i4;
        this.clientName = str3;
        this.ssl = z;
        this.sslSocketFactory = sSLSocketFactory;
        this.sslParameters = sSLParameters;
        this.hostnameVerifier = hostnameVerifier;
        this.hostAndPortMapper = hostAndPortMapper;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public int getSocketTimeoutMillis() {
        return this.socketTimeoutMillis;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public int getBlockingSocketTimeoutMillis() {
        return this.blockingSocketTimeoutMillis;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public String getUser() {
        return this.user;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public String getPassword() {
        return this.password;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public synchronized void updatePassword(String str) {
        if (Objects.equals(this.password, str)) {
            return;
        }
        this.password = str;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public int getDatabase() {
        return this.database;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public String getClientName() {
        return this.clientName;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public boolean isSsl() {
        return this.ssl;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public SSLParameters getSslParameters() {
        return this.sslParameters;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisClientConfig
    public HostAndPortMapper getHostAndPortMapper() {
        return this.hostAndPortMapper;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static DefaultJedisClientConfig create(int i, int i2, int i3, String str, String str2, int i4, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier, HostAndPortMapper hostAndPortMapper) {
        return new DefaultJedisClientConfig(i, i2, i3, str, str2, i4, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier, hostAndPortMapper);
    }

    public static DefaultJedisClientConfig copyConfig(JedisClientConfig jedisClientConfig) {
        return new DefaultJedisClientConfig(jedisClientConfig.getConnectionTimeoutMillis(), jedisClientConfig.getSocketTimeoutMillis(), jedisClientConfig.getBlockingSocketTimeoutMillis(), jedisClientConfig.getUser(), jedisClientConfig.getPassword(), jedisClientConfig.getDatabase(), jedisClientConfig.getClientName(), jedisClientConfig.isSsl(), jedisClientConfig.getSslSocketFactory(), jedisClientConfig.getSslParameters(), jedisClientConfig.getHostnameVerifier(), jedisClientConfig.getHostAndPortMapper());
    }
}

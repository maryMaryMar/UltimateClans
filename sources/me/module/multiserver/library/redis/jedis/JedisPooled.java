package me.module.multiserver.library.redis.jedis;

import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import me.module.multiserver.library.redis.jedis.providers.PooledConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.JedisURIHelper;
import me.module.multiserver.library.redis.jedis.util.Pool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisPooled.class */
public class JedisPooled extends UnifiedJedis {
    public JedisPooled() {
        this(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
    }

    public JedisPooled(String str) {
        this(URI.create(str));
    }

    public JedisPooled(String str, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(URI.create(str), sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(String str, int i) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), str, i);
    }

    public JedisPooled(String str, int i, boolean z) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), str, i, z);
    }

    public JedisPooled(String str, int i, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), str, i, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(String str, int i, String str2, String str3) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), str, i, str2, str3);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(genericObjectPoolConfig, Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str) {
        this(genericObjectPoolConfig, URI.create(str));
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i) {
        this(genericObjectPoolConfig, str, i, 2000);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, boolean z) {
        this(genericObjectPoolConfig, str, i, 2000, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, 2000, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, String str2, String str3) {
        this(genericObjectPoolConfig, str, i, 2000, str2, str3, 0);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2) {
        this(genericObjectPoolConfig, str, i, i2, (String) null);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, (String) null, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, (String) null, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2) {
        this(genericObjectPoolConfig, str, i, i2, str2, 0);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, 0, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, str2, 0, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, 0);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, 0, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3) {
        this(genericObjectPoolConfig, str, i, i2, str2, i3, (String) null);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, i3, (String) null, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, str2, i3, null, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, i3, (String) null);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, i3, (String) null, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, String str3) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, i3, str3);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, String str3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, i3, str3, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, i3, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3, String str4) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, str3, i3, str4);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3, String str4, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, str3, i3, str4, z);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, int i4, String str3) {
        this(genericObjectPoolConfig, str, i, i2, i3, (String) null, str2, i4, str3);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, int i4, String str3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i3, str2, i4, str3, z, null, null, null);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, int i4, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i3, (String) null, str2, i4, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4) {
        this(genericObjectPoolConfig, str, i, i2, i3, 0, str2, str3, i4, str4);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i3, str2, str3, i4, str4, z, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i3, 0, str2, str3, i4, str4, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, int i4, String str2, int i5, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i3, i4, null, str2, i5, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4) {
        this(new HostAndPort(str, i), DefaultJedisClientConfig.create(i2, i3, i4, str2, str3, i5, str4, false, null, null, null, null), genericObjectPoolConfig);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(new HostAndPort(str, i), DefaultJedisClientConfig.create(i2, i3, i4, str2, str3, i5, str4, z, sSLSocketFactory, sSLParameters, hostnameVerifier, null));
    }

    public JedisPooled(URI uri) {
        super(uri);
    }

    public JedisPooled(URI uri, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), uri, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(URI uri, int i) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), uri, i);
    }

    public JedisPooled(URI uri, int i, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig(), uri, i, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri) {
        this(genericObjectPoolConfig, uri, 2000);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, uri, 2000, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri, int i) {
        this(genericObjectPoolConfig, uri, i, i);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri, int i, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, uri, i, i, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri, int i, int i2) {
        this(genericObjectPoolConfig, uri, i, i2, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri, int i, int i2, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, uri, i, i2, 0, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, URI uri, int i, int i2, int i3, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(new HostAndPort(uri.getHost(), uri.getPort()), DefaultJedisClientConfig.create(i, i2, i3, JedisURIHelper.getUser(uri), JedisURIHelper.getPassword(uri), JedisURIHelper.getDBIndex(uri), null, JedisURIHelper.isRedisSSLScheme(uri), sSLSocketFactory, sSLParameters, hostnameVerifier, null));
    }

    public JedisPooled(HostAndPort hostAndPort) {
        this(new PooledConnectionProvider(hostAndPort));
    }

    public JedisPooled(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(new PooledConnectionProvider(hostAndPort, jedisClientConfig));
    }

    public JedisPooled(HostAndPort hostAndPort, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new ConnectionFactory(hostAndPort), genericObjectPoolConfig);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(hostAndPort, jedisClientConfig, genericObjectPoolConfig);
    }

    public JedisPooled(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new ConnectionFactory(hostAndPort, jedisClientConfig), genericObjectPoolConfig);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, JedisSocketFactory jedisSocketFactory, JedisClientConfig jedisClientConfig) {
        this(new ConnectionFactory(jedisSocketFactory, jedisClientConfig), genericObjectPoolConfig);
    }

    public JedisPooled(GenericObjectPoolConfig<Connection> genericObjectPoolConfig, PooledObjectFactory<Connection> pooledObjectFactory) {
        this(pooledObjectFactory, genericObjectPoolConfig);
    }

    public JedisPooled(PooledObjectFactory<Connection> pooledObjectFactory, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new PooledConnectionProvider(pooledObjectFactory, genericObjectPoolConfig));
    }

    public JedisPooled(PooledConnectionProvider pooledConnectionProvider) {
        super(pooledConnectionProvider);
    }

    public final Pool<Connection> getPool() {
        return ((PooledConnectionProvider) this.provider).getPool();
    }
}

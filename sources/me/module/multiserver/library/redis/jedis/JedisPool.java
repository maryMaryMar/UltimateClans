package me.module.multiserver.library.redis.jedis;

import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import me.module.multiserver.library.redis.jedis.util.Pool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisPool.class */
public class JedisPool extends Pool<Jedis> {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) JedisPool.class);

    public JedisPool() {
        this(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
    }

    public JedisPool(String str) {
        this(URI.create(str));
    }

    public JedisPool(String str, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), new JedisFactory(URI.create(str), 2000, 2000, (String) null, sSLSocketFactory, sSLParameters, hostnameVerifier));
    }

    public JedisPool(String str, int i) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), str, i);
    }

    public JedisPool(String str, int i, boolean z) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), str, i, z);
    }

    public JedisPool(String str, int i, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), str, i, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(String str, int i, String str2, String str3) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), str, i, str2, str3);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig) {
        this(genericObjectPoolConfig, Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str) {
        this(genericObjectPoolConfig, URI.create(str));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i) {
        this(genericObjectPoolConfig, str, i, 2000);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, boolean z) {
        this(genericObjectPoolConfig, str, i, 2000, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, 2000, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, String str2, String str3) {
        this(genericObjectPoolConfig, str, i, 2000, str2, str3, 0);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2) {
        this(genericObjectPoolConfig, str, i, i2, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, (String) null, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, (String) null, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2) {
        this(genericObjectPoolConfig, str, i, i2, str2, 0);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, 0, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, str2, 0, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, 0);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, 0, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3) {
        this(genericObjectPoolConfig, str, i, i2, str2, i3, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, i3, (String) null, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, str2, i3, null, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, i3, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, str2, str3, i3, (String) null, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, String str3) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, i3, str3);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, String str3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, i3, str3, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, int i3, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, i3, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3, String str4) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, str3, i3, str4);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, String str2, String str3, int i3, String str4, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i2, str2, str3, i3, str4, z);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, int i4, String str3) {
        this(genericObjectPoolConfig, new JedisFactory(str, i, i2, i3, str2, i4, str3));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, int i4, String str3, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i3, str2, i4, str3, z, null, null, null);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, int i4, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, new JedisFactory(str, i, i2, i3, str2, i4, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4) {
        this(genericObjectPoolConfig, new JedisFactory(str, i, i2, i3, str2, str3, i4, str4));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4, boolean z) {
        this(genericObjectPoolConfig, str, i, i2, i3, str2, str3, i4, str4, z, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i3, 0, str2, str3, i4, str4, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, int i4, String str2, int i5, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, str, i, i2, i3, i4, null, str2, i5, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4) {
        this(genericObjectPoolConfig, new JedisFactory(str, i, i2, i3, i4, str2, str3, i5, str4));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, new JedisFactory(str, i, i2, i3, i4, str2, str3, i5, str4, z, sSLSocketFactory, sSLParameters, hostnameVerifier));
    }

    public JedisPool(URI uri) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), uri);
    }

    public JedisPool(URI uri, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), uri, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(URI uri, int i) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), uri, i);
    }

    public JedisPool(URI uri, int i, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), uri, i, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri) {
        this(genericObjectPoolConfig, uri, 2000);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, uri, 2000, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri, int i) {
        this(genericObjectPoolConfig, uri, i, i);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri, int i, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, uri, i, i, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri, int i, int i2) {
        this(genericObjectPoolConfig, uri, i, i2, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri, int i, int i2, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, new JedisFactory(uri, i, i2, (String) null, sSLSocketFactory, sSLParameters, hostnameVerifier));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, URI uri, int i, int i2, int i3, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(genericObjectPoolConfig, new JedisFactory(uri, i, i2, i3, (String) null, sSLSocketFactory, sSLParameters, hostnameVerifier));
    }

    public JedisPool(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this((GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), hostAndPort, jedisClientConfig);
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(genericObjectPoolConfig, new JedisFactory(hostAndPort, jedisClientConfig));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, JedisSocketFactory jedisSocketFactory, JedisClientConfig jedisClientConfig) {
        this(genericObjectPoolConfig, new JedisFactory(jedisSocketFactory, jedisClientConfig));
    }

    public JedisPool(GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, PooledObjectFactory<Jedis> pooledObjectFactory) {
        super(genericObjectPoolConfig, pooledObjectFactory);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.module.multiserver.library.redis.jedis.util.Pool
    public Jedis getResource() {
        Jedis jedis = (Jedis) super.getResource();
        jedis.setDataSource(this);
        return jedis;
    }

    @Override // me.module.multiserver.library.redis.jedis.util.Pool
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            try {
                jedis.resetState();
                super.returnResource(jedis);
            } catch (RuntimeException e) {
                super.returnBrokenResource(jedis);
                log.warn("Resource is returned to the pool as broken", (Throwable) e);
            }
        }
    }
}

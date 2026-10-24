package me.module.multiserver.library.redis.jedis;

import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import me.module.multiserver.library.redis.jedis.exceptions.InvalidURIException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.JedisURIHelper;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisFactory.class */
public class JedisFactory implements PooledObjectFactory<Jedis> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) JedisFactory.class);
    private final JedisSocketFactory jedisSocketFactory;
    private final JedisClientConfig clientConfig;

    protected JedisFactory(String str, int i, int i2, int i3, String str2, int i4, String str3) {
        this(str, i, i2, i3, str2, i4, str3, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    protected JedisFactory(String str, int i, int i2, int i3, String str2, String str3, int i4, String str4) {
        this(str, i, i2, i3, 0, str2, str3, i4, str4);
    }

    protected JedisFactory(String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4) {
        this(str, i, i2, i3, i4, str2, str3, i5, str4, false, null, null, null);
    }

    JedisFactory(int i, int i2, int i3, String str, String str2, int i4, String str3) {
        this(i, i2, i3, str, str2, i4, str3, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    protected JedisFactory(String str, int i, int i2, int i3, String str2, int i4, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(str, i, i2, i3, null, str2, i4, str3, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    protected JedisFactory(String str, int i, int i2, int i3, String str2, String str3, int i4, String str4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(str, i, i2, i3, 0, str2, str3, i4, str4, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    protected JedisFactory(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this.clientConfig = DefaultJedisClientConfig.copyConfig(jedisClientConfig);
        this.jedisSocketFactory = new DefaultJedisSocketFactory(hostAndPort, this.clientConfig);
    }

    protected JedisFactory(String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this.clientConfig = DefaultJedisClientConfig.builder().connectionTimeoutMillis(i2).socketTimeoutMillis(i3).blockingSocketTimeoutMillis(i4).user(str2).password(str3).database(i5).clientName(str4).ssl(z).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build();
        this.jedisSocketFactory = new DefaultJedisSocketFactory(new HostAndPort(str, i), this.clientConfig);
    }

    protected JedisFactory(JedisSocketFactory jedisSocketFactory, JedisClientConfig jedisClientConfig) {
        this.clientConfig = DefaultJedisClientConfig.copyConfig(jedisClientConfig);
        this.jedisSocketFactory = jedisSocketFactory;
    }

    JedisFactory(int i, int i2, int i3, String str, String str2, int i4, String str3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).blockingSocketTimeoutMillis(i3).user(str).password(str2).database(i4).clientName(str3).ssl(z).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    JedisFactory(JedisClientConfig jedisClientConfig) {
        this.clientConfig = jedisClientConfig;
        this.jedisSocketFactory = new DefaultJedisSocketFactory(jedisClientConfig);
    }

    protected JedisFactory(URI uri, int i, int i2, String str) {
        this(uri, i, i2, str, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    protected JedisFactory(URI uri, int i, int i2, String str, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(uri, i, i2, 0, str, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    protected JedisFactory(URI uri, int i, int i2, int i3, String str, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        if (!JedisURIHelper.isValid(uri)) {
            throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", uri.toString()));
        }
        this.clientConfig = DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).blockingSocketTimeoutMillis(i3).user(JedisURIHelper.getUser(uri)).password(JedisURIHelper.getPassword(uri)).database(JedisURIHelper.getDBIndex(uri)).clientName(str).ssl(JedisURIHelper.isRedisSSLScheme(uri)).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build();
        this.jedisSocketFactory = new DefaultJedisSocketFactory(new HostAndPort(uri.getHost(), uri.getPort()), this.clientConfig);
    }

    void setHostAndPort(HostAndPort hostAndPort) {
        if (!(this.jedisSocketFactory instanceof DefaultJedisSocketFactory)) {
            throw new IllegalStateException("setHostAndPort method has limited capability.");
        }
        ((DefaultJedisSocketFactory) this.jedisSocketFactory).updateHostAndPort(hostAndPort);
    }

    public void setPassword(String str) {
        this.clientConfig.updatePassword(str);
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void activateObject(PooledObject<Jedis> pooledObject) {
        Jedis object = pooledObject.getObject();
        if (object.getDB() != this.clientConfig.getDatabase()) {
            object.select(this.clientConfig.getDatabase());
        }
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void destroyObject(PooledObject<Jedis> pooledObject) {
        Jedis object = pooledObject.getObject();
        if (object.isConnected()) {
            try {
                if (!object.isBroken()) {
                    object.quit();
                }
            } catch (RuntimeException e) {
                logger.debug("Error while QUIT", (Throwable) e);
            }
            try {
                object.close();
            } catch (RuntimeException e2) {
                logger.debug("Error while close", (Throwable) e2);
            }
        }
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public PooledObject<Jedis> makeObject() {
        Jedis jedis = null;
        try {
            jedis = new Jedis(this.jedisSocketFactory, this.clientConfig);
            jedis.connect();
            return new DefaultPooledObject(jedis);
        } catch (JedisException e) {
            if (jedis != null) {
                try {
                    jedis.quit();
                } catch (RuntimeException e2) {
                    logger.debug("Error while QUIT", (Throwable) e2);
                }
                try {
                    jedis.close();
                } catch (RuntimeException e3) {
                    logger.debug("Error while close", (Throwable) e3);
                }
            }
            throw e;
        }
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void passivateObject(PooledObject<Jedis> pooledObject) {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public boolean validateObject(PooledObject<Jedis> pooledObject) {
        Jedis object = pooledObject.getObject();
        try {
            boolean z = true;
            if (this.jedisSocketFactory instanceof DefaultJedisSocketFactory) {
                HostAndPort hostAndPort = ((DefaultJedisSocketFactory) this.jedisSocketFactory).getHostAndPort();
                HostAndPort hostAndPort2 = object.getConnection().getHostAndPort();
                z = hostAndPort.getHost().equals(hostAndPort2.getHost()) && hostAndPort.getPort() == hostAndPort2.getPort();
            }
            return z && object.getConnection().isConnected() && object.ping().equals("PONG");
        } catch (Exception e) {
            logger.error("Error while validating pooled Jedis object.", (Throwable) e);
            return false;
        }
    }
}

package me.module.multiserver.library.redis.jedis;

import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ConnectionFactory.class */
public class ConnectionFactory implements PooledObjectFactory<Connection> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ConnectionFactory.class);
    private final JedisSocketFactory jedisSocketFactory;
    private final JedisClientConfig clientConfig;

    public ConnectionFactory(HostAndPort hostAndPort) {
        this.clientConfig = DefaultJedisClientConfig.builder().build();
        this.jedisSocketFactory = new DefaultJedisSocketFactory(hostAndPort);
    }

    public ConnectionFactory(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this.clientConfig = DefaultJedisClientConfig.copyConfig(jedisClientConfig);
        this.jedisSocketFactory = new DefaultJedisSocketFactory(hostAndPort, this.clientConfig);
    }

    public ConnectionFactory(JedisSocketFactory jedisSocketFactory, JedisClientConfig jedisClientConfig) {
        this.clientConfig = DefaultJedisClientConfig.copyConfig(jedisClientConfig);
        this.jedisSocketFactory = jedisSocketFactory;
    }

    public void setPassword(String str) {
        this.clientConfig.updatePassword(str);
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void activateObject(PooledObject<Connection> pooledObject) {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void destroyObject(PooledObject<Connection> pooledObject) {
        Connection object = pooledObject.getObject();
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
    public PooledObject<Connection> makeObject() {
        Connection connection = null;
        try {
            connection = new Connection(this.jedisSocketFactory, this.clientConfig);
            connection.connect();
            return new DefaultPooledObject(connection);
        } catch (JedisException e) {
            if (connection != null) {
                try {
                    connection.quit();
                } catch (RuntimeException e2) {
                    logger.debug("Error while QUIT", (Throwable) e2);
                }
                try {
                    connection.close();
                } catch (RuntimeException e3) {
                    logger.debug("Error while close", (Throwable) e3);
                }
            }
            throw e;
        }
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void passivateObject(PooledObject<Connection> pooledObject) {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public boolean validateObject(PooledObject<Connection> pooledObject) {
        Connection object = pooledObject.getObject();
        try {
            return object.isConnected() && object.ping();
        } catch (Exception e) {
            logger.error("Error while validating pooled Connection object.", (Throwable) e);
            return false;
        }
    }
}

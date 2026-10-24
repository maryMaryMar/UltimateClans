package me.module.multiserver.library.redis.jedis;

import me.module.multiserver.library.redis.jedis.util.Pool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ConnectionPool.class */
public class ConnectionPool extends Pool<Connection> {
    public ConnectionPool(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new ConnectionFactory(hostAndPort, jedisClientConfig), genericObjectPoolConfig);
    }

    public ConnectionPool(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(new ConnectionFactory(hostAndPort, jedisClientConfig));
    }

    public ConnectionPool(PooledObjectFactory<Connection> pooledObjectFactory) {
        this(pooledObjectFactory, (GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig());
    }

    public ConnectionPool(PooledObjectFactory<Connection> pooledObjectFactory, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        super(pooledObjectFactory, genericObjectPoolConfig);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.module.multiserver.library.redis.jedis.util.Pool
    public Connection getResource() {
        Connection connection = (Connection) super.getResource();
        connection.setHandlingPool(this);
        return connection;
    }
}

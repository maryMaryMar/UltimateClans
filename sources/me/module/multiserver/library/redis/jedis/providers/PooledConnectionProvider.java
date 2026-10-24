package me.module.multiserver.library.redis.jedis.providers;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.ConnectionFactory;
import me.module.multiserver.library.redis.jedis.ConnectionPool;
import me.module.multiserver.library.redis.jedis.HostAndPort;
import me.module.multiserver.library.redis.jedis.JedisClientConfig;
import me.module.multiserver.library.redis.jedis.util.Pool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/providers/PooledConnectionProvider.class */
public class PooledConnectionProvider implements ConnectionProvider {
    private final Pool<Connection> pool;

    public PooledConnectionProvider(HostAndPort hostAndPort) {
        this(new ConnectionFactory(hostAndPort));
    }

    public PooledConnectionProvider(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(new ConnectionFactory(hostAndPort, jedisClientConfig));
    }

    public PooledConnectionProvider(PooledObjectFactory<Connection> pooledObjectFactory) {
        this(pooledObjectFactory, (GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig());
    }

    public PooledConnectionProvider(PooledObjectFactory<Connection> pooledObjectFactory, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new ConnectionPool(pooledObjectFactory, genericObjectPoolConfig));
    }

    private PooledConnectionProvider(Pool<Connection> pool) {
        this.pool = pool;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.pool.close();
    }

    public final Pool<Connection> getPool() {
        return this.pool;
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public Connection getConnection() {
        return this.pool.getResource();
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public Connection getConnection(CommandArguments commandArguments) {
        return this.pool.getResource();
    }
}

package me.module.multiserver.library.redis.jedis.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.ConnectionPool;
import me.module.multiserver.library.redis.jedis.DefaultJedisClientConfig;
import me.module.multiserver.library.redis.jedis.HostAndPort;
import me.module.multiserver.library.redis.jedis.JedisClientConfig;
import me.module.multiserver.library.redis.jedis.ShardedCommandArguments;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.Hashing;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/providers/ShardedConnectionProvider.class */
public class ShardedConnectionProvider implements ConnectionProvider {
    private final TreeMap<Long, HostAndPort> nodes;
    private final Map<String, ConnectionPool> resources;
    private final JedisClientConfig clientConfig;
    private final GenericObjectPoolConfig<Connection> poolConfig;
    private final Hashing algo;

    public ShardedConnectionProvider(List<HostAndPort> list) {
        this(list, DefaultJedisClientConfig.builder().build());
    }

    public ShardedConnectionProvider(List<HostAndPort> list, JedisClientConfig jedisClientConfig) {
        this(list, jedisClientConfig, (GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig());
    }

    public ShardedConnectionProvider(List<HostAndPort> list, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(list, jedisClientConfig, genericObjectPoolConfig, Hashing.MURMUR_HASH);
    }

    public ShardedConnectionProvider(List<HostAndPort> list, JedisClientConfig jedisClientConfig, Hashing hashing) {
        this(list, jedisClientConfig, new GenericObjectPoolConfig(), hashing);
    }

    public ShardedConnectionProvider(List<HostAndPort> list, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, Hashing hashing) {
        this.nodes = new TreeMap<>();
        this.resources = new HashMap();
        this.clientConfig = jedisClientConfig;
        this.poolConfig = genericObjectPoolConfig;
        this.algo = hashing;
        initialize(list);
    }

    private void initialize(List<HostAndPort> list) {
        for (int i = 0; i < list.size(); i++) {
            HostAndPort hostAndPort = list.get(i);
            for (int i2 = 0; i2 < 160; i2++) {
                this.nodes.put(Long.valueOf(this.algo.hash("SHARD-" + i + "-NODE-" + i2)), hostAndPort);
                setupNodeIfNotExist(hostAndPort);
            }
        }
    }

    private ConnectionPool setupNodeIfNotExist(HostAndPort hostAndPort) {
        String string = hostAndPort.toString();
        ConnectionPool connectionPool = this.resources.get(string);
        if (connectionPool != null) {
            return connectionPool;
        }
        ConnectionPool connectionPool2 = new ConnectionPool(hostAndPort, this.clientConfig, this.poolConfig);
        this.resources.put(string, connectionPool2);
        return connectionPool2;
    }

    public Hashing getHashingAlgo() {
        return this.algo;
    }

    private void reset() {
        for (ConnectionPool connectionPool : this.resources.values()) {
            if (connectionPool != null) {
                try {
                    connectionPool.destroy();
                } catch (RuntimeException e) {
                }
            }
        }
        this.resources.clear();
        this.nodes.clear();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        reset();
    }

    public HostAndPort getNode(Long l) {
        if (l != null) {
            return getNodeFromHash(l);
        }
        return null;
    }

    public Connection getConnection(HostAndPort hostAndPort) {
        return hostAndPort != null ? setupNodeIfNotExist(hostAndPort).getResource() : getConnection();
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public Connection getConnection(CommandArguments commandArguments) {
        Long keyHash = ((ShardedCommandArguments) commandArguments).getKeyHash();
        return keyHash != null ? getConnection(getNodeFromHash(keyHash)) : getConnection();
    }

    private List<ConnectionPool> getShuffledNodesPool() {
        ArrayList arrayList = new ArrayList(this.resources.values());
        Collections.shuffle(arrayList);
        return arrayList;
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public Connection getConnection() {
        JedisException jedisException = null;
        Iterator<ConnectionPool> it = getShuffledNodesPool().iterator();
        while (it.hasNext()) {
            Connection resource = null;
            try {
                resource = it.next().getResource();
                if (resource != null) {
                    resource.ping();
                    return resource;
                }
            } catch (JedisException e) {
                if (jedisException == null) {
                    jedisException = e;
                }
                if (resource != null) {
                    resource.close();
                }
            }
        }
        JedisException jedisException2 = new JedisException("No reachable shard.");
        if (jedisException != null) {
            jedisException2.addSuppressed(jedisException);
        }
        throw jedisException2;
    }

    private HostAndPort getNodeFromHash(Long l) {
        SortedMap<Long, HostAndPort> sortedMapTailMap = this.nodes.tailMap(l);
        return sortedMapTailMap.isEmpty() ? this.nodes.get(this.nodes.firstKey()) : sortedMapTailMap.get(sortedMapTailMap.firstKey());
    }
}

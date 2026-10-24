package me.module.multiserver.library.redis.jedis.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.ClusterCommandArguments;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.ConnectionPool;
import me.module.multiserver.library.redis.jedis.HostAndPort;
import me.module.multiserver.library.redis.jedis.JedisClientConfig;
import me.module.multiserver.library.redis.jedis.JedisClusterInfoCache;
import me.module.multiserver.library.redis.jedis.exceptions.JedisClusterOperationException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/providers/ClusterConnectionProvider.class */
public class ClusterConnectionProvider implements ConnectionProvider {
    protected final JedisClusterInfoCache cache;

    public ClusterConnectionProvider(Set<HostAndPort> set, JedisClientConfig jedisClientConfig) {
        this.cache = new JedisClusterInfoCache(jedisClientConfig, set);
        initializeSlotsCache(set, jedisClientConfig);
    }

    public ClusterConnectionProvider(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this.cache = new JedisClusterInfoCache(jedisClientConfig, genericObjectPoolConfig, set);
        initializeSlotsCache(set, jedisClientConfig);
    }

    private void initializeSlotsCache(Set<HostAndPort> set, JedisClientConfig jedisClientConfig) {
        ArrayList arrayList = new ArrayList(set);
        Collections.shuffle(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                Connection connection = new Connection((HostAndPort) it.next(), jedisClientConfig);
                Throwable th = null;
                try {
                    try {
                        continue;
                        this.cache.discoverClusterNodesAndSlots(connection);
                        if (connection != null) {
                            if (0 == 0) {
                                connection.close();
                                return;
                            }
                            try {
                                connection.close();
                                return;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        throw th3;
                    }
                } catch (Throwable th4) {
                    if (connection != null) {
                        if (th != null) {
                            try {
                                connection.close();
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                            }
                        } else {
                            connection.close();
                        }
                    }
                    throw th4;
                }
            } catch (JedisConnectionException e) {
            }
        }
        throw new JedisClusterOperationException("Could not initialize cluster slots cache.");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.cache.reset();
    }

    public void renewSlotCache() {
        this.cache.renewClusterSlots(null);
    }

    public void renewSlotCache(Connection connection) {
        this.cache.renewClusterSlots(connection);
    }

    public Map<String, ConnectionPool> getNodes() {
        return this.cache.getNodes();
    }

    public HostAndPort getNode(int i) {
        if (i >= 0) {
            return this.cache.getSlotNode(i);
        }
        return null;
    }

    public Connection getConnection(HostAndPort hostAndPort) {
        return hostAndPort != null ? this.cache.setupNodeIfNotExist(hostAndPort).getResource() : getConnection();
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public Connection getConnection(CommandArguments commandArguments) {
        int commandHashSlot = ((ClusterCommandArguments) commandArguments).getCommandHashSlot();
        return commandHashSlot >= 0 ? getConnectionFromSlot(commandHashSlot) : getConnection();
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public Connection getConnection() {
        JedisException jedisException = null;
        Iterator<ConnectionPool> it = this.cache.getShuffledNodesPool().iterator();
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
        JedisClusterOperationException jedisClusterOperationException = new JedisClusterOperationException("No reachable node in cluster.");
        if (jedisException != null) {
            jedisClusterOperationException.addSuppressed(jedisException);
        }
        throw jedisClusterOperationException;
    }

    public Connection getConnectionFromSlot(int i) {
        ConnectionPool slotPool = this.cache.getSlotPool(i);
        if (slotPool != null) {
            return slotPool.getResource();
        }
        renewSlotCache();
        ConnectionPool slotPool2 = this.cache.getSlotPool(i);
        return slotPool2 != null ? slotPool2.getResource() : getConnection();
    }
}

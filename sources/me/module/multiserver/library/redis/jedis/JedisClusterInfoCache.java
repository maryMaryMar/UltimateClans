package me.module.multiserver.library.redis.jedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisClusterInfoCache.class */
public class JedisClusterInfoCache {
    private final Map<String, ConnectionPool> nodes;
    private final Map<Integer, ConnectionPool> slots;
    private final Map<Integer, HostAndPort> slotNodes;
    private final ReentrantReadWriteLock rwl;
    private final Lock r;
    private final Lock w;
    private final Lock rediscoverLock;
    private final GenericObjectPoolConfig<Connection> poolConfig;
    private final JedisClientConfig clientConfig;
    private final Set<HostAndPort> startNodes;
    private static final int MASTER_NODE_INDEX = 2;

    @Deprecated
    public JedisClusterInfoCache(JedisClientConfig jedisClientConfig) {
        this(jedisClientConfig, (GenericObjectPoolConfig<Connection>) new GenericObjectPoolConfig());
    }

    @Deprecated
    public JedisClusterInfoCache(JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(jedisClientConfig, genericObjectPoolConfig, null);
    }

    public JedisClusterInfoCache(JedisClientConfig jedisClientConfig, Set<HostAndPort> set) {
        this(jedisClientConfig, new GenericObjectPoolConfig(), set);
    }

    public JedisClusterInfoCache(JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, Set<HostAndPort> set) {
        this.nodes = new HashMap();
        this.slots = new HashMap();
        this.slotNodes = new HashMap();
        this.rwl = new ReentrantReadWriteLock();
        this.r = this.rwl.readLock();
        this.w = this.rwl.writeLock();
        this.rediscoverLock = new ReentrantLock();
        this.poolConfig = genericObjectPoolConfig;
        this.clientConfig = jedisClientConfig;
        this.startNodes = set;
    }

    public void discoverClusterNodesAndSlots(Connection connection) {
        List<Object> listExecuteClusterSlots = executeClusterSlots(connection);
        this.w.lock();
        try {
            reset();
            Iterator<Object> it = listExecuteClusterSlots.iterator();
            while (it.hasNext()) {
                List<Object> list = (List) it.next();
                if (list.size() > 2) {
                    List<Integer> assignedSlotArray = getAssignedSlotArray(list);
                    int size = list.size();
                    for (int i = 2; i < size; i++) {
                        List<Object> list2 = (List) list.get(i);
                        if (!list2.isEmpty()) {
                            HostAndPort hostAndPortGenerateHostAndPort = generateHostAndPort(list2);
                            setupNodeIfNotExist(hostAndPortGenerateHostAndPort);
                            if (i == 2) {
                                assignSlotsToNode(assignedSlotArray, hostAndPortGenerateHostAndPort);
                            }
                        }
                    }
                }
            }
        } finally {
            this.w.unlock();
        }
    }

    public void renewClusterSlots(Connection connection) {
        if (this.rediscoverLock.tryLock()) {
            if (connection != null) {
                try {
                    try {
                        discoverClusterSlots(connection);
                        this.rediscoverLock.unlock();
                        return;
                    } catch (JedisException e) {
                    }
                } catch (Throwable th) {
                    this.rediscoverLock.unlock();
                    throw th;
                }
            }
            if (this.startNodes != null) {
                Iterator<HostAndPort> it = this.startNodes.iterator();
                while (it.hasNext()) {
                    try {
                        Connection connection2 = new Connection(it.next(), this.clientConfig);
                        Throwable th2 = null;
                        try {
                            try {
                                discoverClusterSlots(connection2);
                                if (connection2 != null) {
                                    if (0 != 0) {
                                        try {
                                            connection2.close();
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                        }
                                    } else {
                                        connection2.close();
                                    }
                                }
                                this.rediscoverLock.unlock();
                                return;
                            } catch (Throwable th4) {
                                th2 = th4;
                                throw th4;
                            }
                        } catch (Throwable th5) {
                            if (connection2 != null) {
                                if (th2 != null) {
                                    try {
                                        connection2.close();
                                    } catch (Throwable th6) {
                                        th2.addSuppressed(th6);
                                    }
                                } else {
                                    connection2.close();
                                }
                            }
                            throw th5;
                        }
                    } catch (JedisConnectionException e2) {
                    }
                }
            }
            Iterator<ConnectionPool> it2 = getShuffledNodesPool().iterator();
            while (it2.hasNext()) {
                try {
                    Connection resource = it2.next().getResource();
                    Throwable th7 = null;
                    try {
                        try {
                            if (this.startNodes == null || !this.startNodes.contains(resource.getHostAndPort())) {
                                discoverClusterSlots(resource);
                                if (resource != null) {
                                    if (0 != 0) {
                                        try {
                                            resource.close();
                                        } catch (Throwable th8) {
                                            th7.addSuppressed(th8);
                                        }
                                    } else {
                                        resource.close();
                                    }
                                }
                                this.rediscoverLock.unlock();
                                return;
                            }
                            if (resource != null) {
                                if (0 != 0) {
                                    try {
                                        resource.close();
                                    } catch (Throwable th9) {
                                        th7.addSuppressed(th9);
                                    }
                                } else {
                                    resource.close();
                                }
                            }
                        } catch (Throwable th10) {
                            th7 = th10;
                            throw th10;
                        }
                    } catch (Throwable th11) {
                        if (resource != null) {
                            if (th7 != null) {
                                try {
                                    resource.close();
                                } catch (Throwable th12) {
                                    th7.addSuppressed(th12);
                                }
                            } else {
                                resource.close();
                            }
                        }
                        throw th11;
                    }
                } catch (JedisConnectionException e3) {
                }
            }
            this.rediscoverLock.unlock();
        }
    }

    private void discoverClusterSlots(Connection connection) {
        List<Object> listExecuteClusterSlots = executeClusterSlots(connection);
        this.w.lock();
        try {
            this.slots.clear();
            this.slotNodes.clear();
            HashSet hashSet = new HashSet();
            Iterator<Object> it = listExecuteClusterSlots.iterator();
            while (it.hasNext()) {
                List<Object> list = (List) it.next();
                if (list.size() > 2) {
                    List<Integer> assignedSlotArray = getAssignedSlotArray(list);
                    int size = list.size();
                    for (int i = 2; i < size; i++) {
                        List<Object> list2 = (List) list.get(i);
                        if (!list2.isEmpty()) {
                            HostAndPort hostAndPortGenerateHostAndPort = generateHostAndPort(list2);
                            hashSet.add(getNodeKey(hostAndPortGenerateHostAndPort));
                            setupNodeIfNotExist(hostAndPortGenerateHostAndPort);
                            if (i == 2) {
                                assignSlotsToNode(assignedSlotArray, hostAndPortGenerateHostAndPort);
                            }
                        }
                    }
                }
            }
            Iterator<Map.Entry<String, ConnectionPool>> it2 = this.nodes.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, ConnectionPool> next = it2.next();
                if (!hashSet.contains(next.getKey())) {
                    ConnectionPool value = next.getValue();
                    if (value != null) {
                        try {
                            value.destroy();
                        } catch (Exception e) {
                        }
                    }
                    it2.remove();
                }
            }
        } finally {
            this.w.unlock();
        }
    }

    private HostAndPort generateHostAndPort(List<Object> list) {
        return new HostAndPort(SafeEncoder.encode((byte[]) list.get(0)), ((Long) list.get(1)).intValue());
    }

    public ConnectionPool setupNodeIfNotExist(HostAndPort hostAndPort) {
        this.w.lock();
        try {
            String nodeKey = getNodeKey(hostAndPort);
            ConnectionPool connectionPool = this.nodes.get(nodeKey);
            if (connectionPool != null) {
                return connectionPool;
            }
            ConnectionPool connectionPool2 = new ConnectionPool(hostAndPort, this.clientConfig, this.poolConfig);
            this.nodes.put(nodeKey, connectionPool2);
            return connectionPool2;
        } finally {
            this.w.unlock();
        }
    }

    public void assignSlotToNode(int i, HostAndPort hostAndPort) {
        this.w.lock();
        try {
            this.slots.put(Integer.valueOf(i), setupNodeIfNotExist(hostAndPort));
            this.slotNodes.put(Integer.valueOf(i), hostAndPort);
        } finally {
            this.w.unlock();
        }
    }

    public void assignSlotsToNode(List<Integer> list, HostAndPort hostAndPort) {
        this.w.lock();
        try {
            ConnectionPool connectionPool = setupNodeIfNotExist(hostAndPort);
            for (Integer num : list) {
                this.slots.put(num, connectionPool);
                this.slotNodes.put(num, hostAndPort);
            }
            this.w.unlock();
        } catch (Throwable th) {
            this.w.unlock();
            throw th;
        }
    }

    public ConnectionPool getNode(String str) {
        this.r.lock();
        try {
            return this.nodes.get(str);
        } finally {
            this.r.unlock();
        }
    }

    public ConnectionPool getNode(HostAndPort hostAndPort) {
        return getNode(getNodeKey(hostAndPort));
    }

    public ConnectionPool getSlotPool(int i) {
        this.r.lock();
        try {
            return this.slots.get(Integer.valueOf(i));
        } finally {
            this.r.unlock();
        }
    }

    public HostAndPort getSlotNode(int i) {
        this.r.lock();
        try {
            return this.slotNodes.get(Integer.valueOf(i));
        } finally {
            this.r.unlock();
        }
    }

    public Map<String, ConnectionPool> getNodes() {
        this.r.lock();
        try {
            return new HashMap(this.nodes);
        } finally {
            this.r.unlock();
        }
    }

    public List<ConnectionPool> getShuffledNodesPool() {
        this.r.lock();
        try {
            ArrayList arrayList = new ArrayList(this.nodes.values());
            Collections.shuffle(arrayList);
            return arrayList;
        } finally {
            this.r.unlock();
        }
    }

    public void reset() {
        this.w.lock();
        try {
            for (ConnectionPool connectionPool : this.nodes.values()) {
                if (connectionPool != null) {
                    try {
                        connectionPool.destroy();
                    } catch (RuntimeException e) {
                    }
                }
            }
            this.nodes.clear();
            this.slots.clear();
            this.slotNodes.clear();
        } finally {
            this.w.unlock();
        }
    }

    public static String getNodeKey(HostAndPort hostAndPort) {
        return hostAndPort.toString();
    }

    private List<Object> executeClusterSlots(Connection connection) {
        connection.sendCommand(Protocol.Command.CLUSTER, "SLOTS");
        return connection.getObjectMultiBulkReply();
    }

    private List<Integer> getAssignedSlotArray(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (int iIntValue = ((Long) list.get(0)).intValue(); iIntValue <= ((Long) list.get(1)).intValue(); iIntValue++) {
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }
}

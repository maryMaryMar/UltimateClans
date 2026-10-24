package me.module.multiserver.library.redis.jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.Pool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisSentinelPool.class */
public class JedisSentinelPool extends Pool<Jedis> {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) JedisSentinelPool.class);
    private final JedisFactory factory;
    private final JedisClientConfig sentinelClientConfig;
    protected final Collection<MasterListener> masterListeners;
    private volatile HostAndPort currentHostMaster;
    private final Object initPoolLock;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisSentinelPool$MasterListener.class */
    protected class MasterListener extends Thread {
        protected String masterName;
        protected String host;
        protected int port;
        protected long subscribeRetryWaitTimeMillis;
        protected volatile Jedis j;
        protected AtomicBoolean running;

        protected MasterListener() {
            this.subscribeRetryWaitTimeMillis = 5000L;
            this.running = new AtomicBoolean(false);
        }

        public MasterListener(String str, String str2, int i) {
            super(String.format("MasterListener-%s-[%s:%d]", str, str2, Integer.valueOf(i)));
            this.subscribeRetryWaitTimeMillis = 5000L;
            this.running = new AtomicBoolean(false);
            this.masterName = str;
            this.host = str2;
            this.port = i;
        }

        public MasterListener(JedisSentinelPool jedisSentinelPool, String str, String str2, int i, long j) {
            this(str, str2, i);
            this.subscribeRetryWaitTimeMillis = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.running.set(true);
            while (this.running.get()) {
                try {
                    try {
                        if (!this.running.get()) {
                            if (this.j != null) {
                                this.j.close();
                                return;
                            }
                            return;
                        }
                        final HostAndPort hostAndPort = new HostAndPort(this.host, this.port);
                        this.j = new Jedis(hostAndPort, JedisSentinelPool.this.sentinelClientConfig);
                        List<String> listSentinelGetMasterAddrByName = this.j.sentinelGetMasterAddrByName(this.masterName);
                        if (listSentinelGetMasterAddrByName == null || listSentinelGetMasterAddrByName.size() != 2) {
                            JedisSentinelPool.LOG.warn("Can not get master addr, master name: {}. Sentinel: {}.", this.masterName, hostAndPort);
                        } else {
                            JedisSentinelPool.this.initMaster(JedisSentinelPool.this.toHostAndPort(listSentinelGetMasterAddrByName));
                        }
                        this.j.subscribe(new JedisPubSub() { // from class: me.module.multiserver.library.redis.jedis.JedisSentinelPool.MasterListener.1
                            @Override // me.module.multiserver.library.redis.jedis.JedisPubSub
                            public void onMessage(String str, String str2) {
                                JedisSentinelPool.LOG.debug("Sentinel {} published: {}.", hostAndPort, str2);
                                String[] strArrSplit = str2.split(" ");
                                if (strArrSplit.length <= 3) {
                                    JedisSentinelPool.LOG.error("Invalid message received on Sentinel {} on channel +switch-master: {}", hostAndPort, str2);
                                } else if (MasterListener.this.masterName.equals(strArrSplit[0])) {
                                    JedisSentinelPool.this.initMaster(JedisSentinelPool.this.toHostAndPort(Arrays.asList(strArrSplit[3], strArrSplit[4])));
                                } else {
                                    JedisSentinelPool.LOG.debug("Ignoring message on +switch-master for master name {}, our master name is {}", strArrSplit[0], MasterListener.this.masterName);
                                }
                            }
                        }, "+switch-master");
                        if (this.j != null) {
                            this.j.close();
                        }
                    } catch (JedisException e) {
                        if (this.running.get()) {
                            JedisSentinelPool.LOG.error("Lost connection to Sentinel at {}:{}. Sleeping 5000ms and retrying.", this.host, Integer.valueOf(this.port), e);
                            try {
                                Thread.sleep(this.subscribeRetryWaitTimeMillis);
                            } catch (InterruptedException e2) {
                                JedisSentinelPool.LOG.error("Sleep interrupted: ", (Throwable) e2);
                            }
                        } else {
                            JedisSentinelPool.LOG.debug("Unsubscribing from Sentinel at {}:{}", this.host, Integer.valueOf(this.port));
                        }
                        if (this.j != null) {
                            this.j.close();
                        }
                    }
                } catch (Throwable th) {
                    if (this.j != null) {
                        this.j.close();
                    }
                    throw th;
                }
            }
        }

        public void shutdown() {
            try {
                JedisSentinelPool.LOG.debug("Shutting down listener on {}:{}", this.host, Integer.valueOf(this.port));
                this.running.set(false);
                if (this.j != null) {
                    this.j.close();
                }
            } catch (RuntimeException e) {
                JedisSentinelPool.LOG.error("Caught exception while shutting down: ", (Throwable) e);
            }
        }
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig) {
        this(str, set, genericObjectPoolConfig, 2000, null, 0);
    }

    public JedisSentinelPool(String str, Set<String> set) {
        this(str, set, new GenericObjectPoolConfig(), 2000, null, 0);
    }

    public JedisSentinelPool(String str, Set<String> set, String str2) {
        this(str, set, (GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), 2000, str2);
    }

    public JedisSentinelPool(String str, Set<String> set, String str2, String str3) {
        this(str, set, new GenericObjectPoolConfig(), 2000, 2000, str2, 0, null, 2000, 2000, str3, null);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, String str2) {
        this(str, set, genericObjectPoolConfig, i, str2, 0);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i) {
        this(str, set, genericObjectPoolConfig, i, null, 0);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, String str2) {
        this(str, set, genericObjectPoolConfig, 2000, str2);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, String str2, int i2) {
        this(str, set, genericObjectPoolConfig, i, i, (String) null, str2, i2);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, String str2, String str3, int i2) {
        this(str, set, genericObjectPoolConfig, i, i, str2, str3, i2);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, String str2, int i2, String str3) {
        this(str, set, genericObjectPoolConfig, i, i, str2, i2, str3);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, String str2, String str3, int i2, String str4) {
        this(str, set, genericObjectPoolConfig, i, i, str2, str3, i2, str4);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, String str2, int i3) {
        this(str, set, genericObjectPoolConfig, i, i2, null, str2, i3, null);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, String str2, String str3, int i3) {
        this(str, set, genericObjectPoolConfig, i, i2, str2, str3, i3, null);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, String str2, int i3, String str3) {
        this(str, set, genericObjectPoolConfig, i, i2, null, str2, i3, str3);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, String str2, String str3, int i3, String str4) {
        this(str, set, genericObjectPoolConfig, i, i2, str2, str3, i3, str4, 2000, 2000, null, null, null);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, int i3, String str2, String str3, int i4, String str4) {
        this(str, set, genericObjectPoolConfig, i, i2, i3, str2, str3, i4, str4, 2000, 2000, null, null, null);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, String str2, int i3, String str3, int i4, int i5, String str4, String str5) {
        this(str, set, genericObjectPoolConfig, i, i2, null, str2, i3, str3, i4, i5, null, str4, str5);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, String str2, String str3, int i3, String str4, int i4, int i5, String str5, String str6, String str7) {
        this(str, set, genericObjectPoolConfig, i, i2, 0, str2, str3, i3, str4, i4, i5, str5, str6, str7);
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, int i, int i2, int i3, String str2, String str3, int i4, String str4, int i5, int i6, String str5, String str6, String str7) {
        this(str, parseHostAndPorts(set), genericObjectPoolConfig, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).blockingSocketTimeoutMillis(i3).user(str2).password(str3).database(i4).clientName(str4).build(), DefaultJedisClientConfig.builder().connectionTimeoutMillis(i5).socketTimeoutMillis(i6).user(str5).password(str6).clientName(str7).build());
    }

    public JedisSentinelPool(String str, Set<String> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, JedisFactory jedisFactory) {
        this(str, parseHostAndPorts(set), genericObjectPoolConfig, jedisFactory, DefaultJedisClientConfig.builder().build());
    }

    public JedisSentinelPool(String str, Set<HostAndPort> set, JedisClientConfig jedisClientConfig, JedisClientConfig jedisClientConfig2) {
        this(str, set, (GenericObjectPoolConfig<Jedis>) new GenericObjectPoolConfig(), jedisClientConfig, jedisClientConfig2);
    }

    public JedisSentinelPool(String str, Set<HostAndPort> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, JedisClientConfig jedisClientConfig, JedisClientConfig jedisClientConfig2) {
        this(str, set, genericObjectPoolConfig, new JedisFactory(jedisClientConfig), jedisClientConfig2);
    }

    public JedisSentinelPool(String str, Set<HostAndPort> set, GenericObjectPoolConfig<Jedis> genericObjectPoolConfig, JedisFactory jedisFactory, JedisClientConfig jedisClientConfig) {
        super(genericObjectPoolConfig, jedisFactory);
        this.masterListeners = new ArrayList();
        this.initPoolLock = new Object();
        this.factory = jedisFactory;
        this.sentinelClientConfig = jedisClientConfig;
        initMaster(initSentinels(set, str));
    }

    private static Set<HostAndPort> parseHostAndPorts(Set<String> set) {
        return (Set) set.stream().map(HostAndPort::from).collect(Collectors.toSet());
    }

    @Override // me.module.multiserver.library.redis.jedis.util.Pool
    public void destroy() {
        Iterator<MasterListener> it = this.masterListeners.iterator();
        while (it.hasNext()) {
            it.next().shutdown();
        }
        super.destroy();
    }

    public HostAndPort getCurrentHostMaster() {
        return this.currentHostMaster;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMaster(HostAndPort hostAndPort) {
        synchronized (this.initPoolLock) {
            if (!hostAndPort.equals(this.currentHostMaster)) {
                this.currentHostMaster = hostAndPort;
                this.factory.setHostAndPort(this.currentHostMaster);
                super.clear();
                LOG.info("Created JedisSentinelPool to master at {}", hostAndPort);
            }
        }
    }

    private HostAndPort initSentinels(Set<HostAndPort> set, String str) {
        HostAndPort hostAndPort = null;
        boolean z = false;
        LOG.info("Trying to find master from available Sentinels...");
        for (HostAndPort hostAndPort2 : set) {
            LOG.debug("Connecting to Sentinel {}", hostAndPort2);
            try {
                Jedis jedis = new Jedis(hostAndPort2, this.sentinelClientConfig);
                Throwable th = null;
                try {
                    try {
                        List<String> listSentinelGetMasterAddrByName = jedis.sentinelGetMasterAddrByName(str);
                        z = true;
                        if (listSentinelGetMasterAddrByName != null && listSentinelGetMasterAddrByName.size() == 2) {
                            hostAndPort = toHostAndPort(listSentinelGetMasterAddrByName);
                            LOG.debug("Found Redis master at {}", hostAndPort);
                            if (jedis != null) {
                                if (0 != 0) {
                                    try {
                                        jedis.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                } else {
                                    jedis.close();
                                }
                            }
                            break;
                        }
                        LOG.warn("Can not get master addr, master name: {}. Sentinel: {}", str, hostAndPort2);
                        if (jedis != null) {
                            if (0 != 0) {
                                try {
                                    jedis.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            } else {
                                jedis.close();
                            }
                        }
                    } catch (Throwable th4) {
                        if (jedis != null) {
                            if (th != null) {
                                try {
                                    jedis.close();
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                }
                            } else {
                                jedis.close();
                            }
                        }
                        throw th4;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    throw th6;
                }
            } catch (JedisException e) {
                LOG.warn("Cannot get master address from sentinel running @ {}. Reason: {}. Trying next one.", hostAndPort2, e);
            }
            LOG.warn("Cannot get master address from sentinel running @ {}. Reason: {}. Trying next one.", hostAndPort2, e);
        }
        if (hostAndPort == null) {
            if (z) {
                throw new JedisException("Can connect to sentinel, but " + str + " seems to be not monitored...");
            }
            throw new JedisConnectionException("All sentinels down, cannot determine where is " + str + " master is running...");
        }
        LOG.info("Redis master running at {}, starting Sentinel listeners...", hostAndPort);
        for (HostAndPort hostAndPort3 : set) {
            MasterListener masterListener = new MasterListener(str, hostAndPort3.getHost(), hostAndPort3.getPort());
            masterListener.setDaemon(true);
            this.masterListeners.add(masterListener);
            masterListener.start();
        }
        return hostAndPort;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HostAndPort toHostAndPort(List<String> list) {
        return new HostAndPort(list.get(0), Integer.parseInt(list.get(1)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.module.multiserver.library.redis.jedis.util.Pool
    public Jedis getResource() {
        while (true) {
            Jedis jedis = (Jedis) super.getResource();
            jedis.setDataSource(this);
            if (this.currentHostMaster.equals(jedis.getClient().getHostAndPort())) {
                return jedis;
            }
            returnBrokenResource(jedis);
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.util.Pool
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            try {
                jedis.resetState();
                super.returnResource(jedis);
            } catch (RuntimeException e) {
                returnBrokenResource(jedis);
                LOG.debug("Resource is returned to the pool as broken", (Throwable) e);
            }
        }
    }
}

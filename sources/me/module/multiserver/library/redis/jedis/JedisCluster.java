package me.module.multiserver.library.redis.jedis;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.executors.ClusterCommandExecutor;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisCluster.class */
public class JedisCluster extends UnifiedJedis {
    public static final int DEFAULT_TIMEOUT = 2000;
    public static final int DEFAULT_MAX_ATTEMPTS = 5;

    public JedisCluster(HostAndPort hostAndPort) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort));
    }

    public JedisCluster(HostAndPort hostAndPort, int i) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2);
    }

    public JedisCluster(HostAndPort hostAndPort, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, int i3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, i3, genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, int i3, String str, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, i3, str, genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, int i3, String str, String str2, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, i3, str, str2, genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, int i3, String str, String str2, String str3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, i3, str, str2, str3, genericObjectPoolConfig);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, int i3, String str, String str2, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, boolean z) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, i3, str, str2, genericObjectPoolConfig, z);
    }

    public JedisCluster(HostAndPort hostAndPort, int i, int i2, int i3, String str, String str2, String str3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, boolean z) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), i, i2, i3, str, str2, str3, genericObjectPoolConfig, z);
    }

    public JedisCluster(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig, int i, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this((Set<HostAndPort>) Collections.singleton(hostAndPort), jedisClientConfig, i, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set) {
        this(set, 2000);
    }

    public JedisCluster(Set<HostAndPort> set, int i) {
        this(set, DefaultJedisClientConfig.builder().timeoutMillis(i).build());
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2) {
        this(set, DefaultJedisClientConfig.builder().timeoutMillis(i).build(), i2);
    }

    public JedisCluster(Set<HostAndPort> set, String str, String str2) {
        this(set, DefaultJedisClientConfig.builder().user(str).password(str2).build());
    }

    public JedisCluster(Set<HostAndPort> set, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, 2000, 5, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, i, 5, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, i, i, i2, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, i, i2, i3, (String) null, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, String str, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, i, i2, i3, str, (String) null, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, String str, String str2, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, i, i2, i3, (String) null, str, str2, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, String str, String str2, String str3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).user(str).password(str2).clientName(str3).build(), i3, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, int i4, String str, String str2, String str3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).blockingSocketTimeoutMillis(i3).user(str).password(str2).clientName(str3).build(), i4, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, String str, String str2, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, boolean z) {
        this(set, i, i2, i3, (String) null, str, str2, genericObjectPoolConfig, z);
    }

    public JedisCluster(Set<HostAndPort> set, int i, int i2, int i3, String str, String str2, String str3, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, boolean z) {
        this(set, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).user(str).password(str2).clientName(str3).ssl(z).build(), i3, genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, int i, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(set, jedisClientConfig, i, Duration.ofMillis(((long) jedisClientConfig.getSocketTimeoutMillis()) * ((long) i)), genericObjectPoolConfig);
    }

    public JedisCluster(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, int i, Duration duration, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        super(set, jedisClientConfig, genericObjectPoolConfig, i, duration);
    }

    public JedisCluster(Set<HostAndPort> set, JedisClientConfig jedisClientConfig) {
        this(set, jedisClientConfig, 5);
    }

    public JedisCluster(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, int i) {
        super(set, jedisClientConfig, i);
    }

    public JedisCluster(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, int i, Duration duration) {
        super(set, jedisClientConfig, i, duration);
    }

    public Map<String, ConnectionPool> getClusterNodes() {
        return ((ClusterCommandExecutor) this.executor).provider.getNodes();
    }

    public Connection getConnectionFromSlot(int i) {
        return ((ClusterCommandExecutor) this.executor).provider.getConnectionFromSlot(i);
    }
}

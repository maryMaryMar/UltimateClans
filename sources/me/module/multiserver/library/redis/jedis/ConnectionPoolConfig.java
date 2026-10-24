package me.module.multiserver.library.redis.jedis;

import java.time.Duration;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ConnectionPoolConfig.class */
public class ConnectionPoolConfig extends GenericObjectPoolConfig<Connection> {
    public ConnectionPoolConfig() {
        setTestWhileIdle(true);
        setMinEvictableIdleTime(Duration.ofMillis(60000L));
        setTimeBetweenEvictionRuns(Duration.ofMillis(30000L));
        setNumTestsPerEvictionRun(-1);
    }
}

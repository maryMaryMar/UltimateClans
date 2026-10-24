package me.module.multiserver.library.redis.jedis.executors;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import me.module.multiserver.library.redis.jedis.CommandObject;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.exceptions.JedisAskDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisClusterOperationException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisMovedDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisRedirectionException;
import me.module.multiserver.library.redis.jedis.providers.ClusterConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/executors/ClusterCommandExecutor.class */
public class ClusterCommandExecutor implements CommandExecutor {
    private final Logger log = LoggerFactory.getLogger(getClass());
    public final ClusterConnectionProvider provider;
    protected final int maxAttempts;
    protected final Duration maxTotalRetriesDuration;

    public ClusterCommandExecutor(ClusterConnectionProvider clusterConnectionProvider, int i, Duration duration) {
        this.provider = clusterConnectionProvider;
        this.maxAttempts = i;
        this.maxTotalRetriesDuration = duration;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.provider.close();
    }

    @Override // me.module.multiserver.library.redis.jedis.executors.CommandExecutor
    public final <T> T executeCommand(CommandObject<T> commandObject) {
        Instant instantPlus = Instant.now().plus((TemporalAmount) this.maxTotalRetriesDuration);
        JedisRedirectionException jedisRedirectionException = null;
        int i = 0;
        Throwable th = null;
        for (int i2 = this.maxAttempts; i2 > 0; i2--) {
            Connection connection = null;
            try {
                if (jedisRedirectionException != null) {
                    try {
                        try {
                            connection = this.provider.getConnection(jedisRedirectionException.getTargetNode());
                            if (jedisRedirectionException instanceof JedisAskDataException) {
                                connection.executeCommand(Protocol.Command.ASKING);
                            }
                        } catch (JedisRedirectionException e) {
                            if (th == null || (th instanceof JedisRedirectionException)) {
                                th = e;
                            }
                            this.log.debug("Redirected by server to {}", e.getTargetNode());
                            i = 0;
                            jedisRedirectionException = e;
                            if (e instanceof JedisMovedDataException) {
                                this.provider.renewSlotCache(connection);
                            }
                            IOUtils.closeQuietly(connection);
                            if (Instant.now().isAfter(instantPlus)) {
                                throw new JedisClusterOperationException("Cluster retry deadline exceeded.");
                            }
                        }
                    } catch (JedisClusterOperationException e2) {
                        throw e2;
                    }
                } else {
                    connection = this.provider.getConnection(commandObject.getArguments());
                }
                T t = (T) execute(connection, commandObject);
                IOUtils.closeQuietly(connection);
                return t;
            } catch (JedisConnectionException e3) {
                try {
                    th = e3;
                    i++;
                    this.log.debug("Failed connecting to Redis: {}", connection, e3);
                    if (handleConnectionProblem(i2 - 1, i, instantPlus)) {
                        i = 0;
                        jedisRedirectionException = null;
                    }
                    IOUtils.closeQuietly(connection);
                } catch (Throwable th2) {
                    IOUtils.closeQuietly(connection);
                    throw th2;
                }
            }
        }
        JedisClusterOperationException jedisClusterOperationException = new JedisClusterOperationException("No more cluster attempts left.");
        jedisClusterOperationException.addSuppressed(th);
        throw jedisClusterOperationException;
    }

    protected <T> T execute(Connection connection, CommandObject<T> commandObject) {
        return (T) connection.executeCommand(commandObject);
    }

    private boolean handleConnectionProblem(int i, int i2, Instant instant) {
        if (this.maxAttempts < 3) {
            if (i != 0) {
                return false;
            }
            this.provider.renewSlotCache();
            return true;
        }
        if (i2 < 2) {
            return false;
        }
        sleep(getBackoffSleepMillis(i, instant));
        this.provider.renewSlotCache();
        return true;
    }

    private static long getBackoffSleepMillis(int i, Instant instant) {
        if (i <= 0) {
            return 0L;
        }
        long millis = Duration.between(Instant.now(), instant).toMillis();
        if (millis < 0) {
            throw new JedisClusterOperationException("Cluster retry deadline exceeded.");
        }
        return ThreadLocalRandom.current().nextLong((millis / ((long) (i * i))) + 1);
    }

    protected void sleep(long j) {
        try {
            TimeUnit.MILLISECONDS.sleep(j);
        } catch (InterruptedException e) {
            throw new JedisClusterOperationException(e);
        }
    }
}

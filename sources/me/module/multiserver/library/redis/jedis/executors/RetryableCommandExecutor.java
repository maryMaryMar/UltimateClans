package me.module.multiserver.library.redis.jedis.executors;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.TimeUnit;
import me.module.multiserver.library.redis.jedis.CommandObject;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.providers.ConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/executors/RetryableCommandExecutor.class */
public class RetryableCommandExecutor implements CommandExecutor {
    private final Logger log = LoggerFactory.getLogger(getClass());
    protected final ConnectionProvider provider;
    protected final int maxAttempts;
    protected final Duration maxTotalRetriesDuration;

    public RetryableCommandExecutor(ConnectionProvider connectionProvider, int i, Duration duration) {
        this.provider = connectionProvider;
        this.maxAttempts = i;
        this.maxTotalRetriesDuration = duration;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.provider);
    }

    @Override // me.module.multiserver.library.redis.jedis.executors.CommandExecutor
    public final <T> T executeCommand(CommandObject<T> commandObject) {
        Instant instantPlus = Instant.now().plus((TemporalAmount) this.maxTotalRetriesDuration);
        int i = 0;
        JedisConnectionException jedisConnectionException = null;
        for (int i2 = this.maxAttempts; i2 > 0; i2--) {
            Connection connection = null;
            try {
                connection = this.provider.getConnection(commandObject.getArguments());
                T t = (T) execute(connection, commandObject);
                if (connection != null) {
                    connection.close();
                }
                return t;
            } catch (JedisConnectionException e) {
                try {
                    jedisConnectionException = e;
                    i++;
                    this.log.debug("Failed connecting to Redis: {}", connection, e);
                    if (handleConnectionProblem(i2 - 1, i, instantPlus)) {
                        i = 0;
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    if (Instant.now().isAfter(instantPlus)) {
                        throw new JedisException("Retry deadline exceeded.");
                    }
                } catch (Throwable th) {
                    if (connection != null) {
                        connection.close();
                    }
                    throw th;
                }
            }
        }
        JedisException jedisException = new JedisException("No more attempts left.");
        jedisException.addSuppressed(jedisConnectionException);
        throw jedisException;
    }

    protected <T> T execute(Connection connection, CommandObject<T> commandObject) {
        return (T) connection.executeCommand(commandObject);
    }

    private boolean handleConnectionProblem(int i, int i2, Instant instant) {
        if (i2 < 2) {
            return false;
        }
        sleep(getBackoffSleepMillis(i, instant));
        return true;
    }

    private static long getBackoffSleepMillis(int i, Instant instant) {
        if (i <= 0) {
            return 0L;
        }
        long millis = Duration.between(Instant.now(), instant).toMillis();
        if (millis < 0) {
            throw new JedisException("Retry deadline exceeded.");
        }
        return millis / ((long) (i * (i + 1)));
    }

    protected void sleep(long j) {
        try {
            TimeUnit.MILLISECONDS.sleep(j);
        } catch (InterruptedException e) {
            throw new JedisException(e);
        }
    }
}

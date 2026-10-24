package me.ulrich.clans.library.hikari.metrics.dropwizard;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.pool.HikariPool;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/CodahaleHealthChecker.class */
public final class CodahaleHealthChecker {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/CodahaleHealthChecker$Connection99Percent.class */
    private static class Connection99Percent extends HealthCheck {
        private final Timer waitTimer;
        private final long expected99thPercentile;

        Connection99Percent(Timer timer, long j) {
            this.waitTimer = timer;
            this.expected99thPercentile = j;
        }

        protected HealthCheck.Result check() {
            long millis = TimeUnit.NANOSECONDS.toMillis(Math.round(this.waitTimer.getSnapshot().get99thPercentile()));
            return millis <= this.expected99thPercentile ? HealthCheck.Result.healthy() : HealthCheck.Result.unhealthy("99th percentile connection wait time of %dms exceeds the threshold %dms", new Object[]{Long.valueOf(millis), Long.valueOf(this.expected99thPercentile)});
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/CodahaleHealthChecker$ConnectivityHealthCheck.class */
    private static class ConnectivityHealthCheck extends HealthCheck {
        private final HikariPool pool;
        private final long checkTimeoutMs;

        ConnectivityHealthCheck(HikariPool hikariPool, long j) {
            this.pool = hikariPool;
            this.checkTimeoutMs = (j <= 0 || j == 2147483647L) ? TimeUnit.SECONDS.toMillis(10L) : j;
        }

        protected HealthCheck.Result check() {
            try {
                Connection connection = this.pool.getConnection(this.checkTimeoutMs);
                try {
                    HealthCheck.Result resultHealthy = HealthCheck.Result.healthy();
                    if (connection != null) {
                        connection.close();
                    }
                    return resultHealthy;
                } catch (Throwable th) {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (SQLException e) {
                return HealthCheck.Result.unhealthy(e);
            }
        }
    }

    public static void registerHealthChecks(HikariPool hikariPool, HikariConfig hikariConfig, HealthCheckRegistry healthCheckRegistry) {
        Properties healthCheckProperties = hikariConfig.getHealthCheckProperties();
        healthCheckRegistry.register(MetricRegistry.name(hikariConfig.getPoolName(), new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectivityCheck"}), new ConnectivityHealthCheck(hikariPool, Long.parseLong(healthCheckProperties.getProperty("connectivityCheckTimeoutMs", String.valueOf(hikariConfig.getConnectionTimeout())))));
        long j = Long.parseLong(healthCheckProperties.getProperty("expected99thPercentileMs", "0"));
        Object metricRegistry = hikariConfig.getMetricRegistry();
        if (j <= 0 || !(metricRegistry instanceof MetricRegistry)) {
            return;
        }
        SortedMap timers = ((MetricRegistry) metricRegistry).getTimers((str, metric) -> {
            return str.equals(MetricRegistry.name(hikariConfig.getPoolName(), new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Wait"}));
        });
        if (timers.isEmpty()) {
            return;
        }
        healthCheckRegistry.register(MetricRegistry.name(hikariConfig.getPoolName(), new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Connection99Percent"}), new Connection99Percent((Timer) ((Map.Entry) timers.entrySet().iterator().next()).getValue(), j));
    }

    private CodahaleHealthChecker() {
    }
}

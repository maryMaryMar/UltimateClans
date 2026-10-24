package me.ulrich.clans.library.hikari.metrics.dropwizard;

import io.dropwizard.metrics5.Histogram;
import io.dropwizard.metrics5.Meter;
import io.dropwizard.metrics5.MetricName;
import io.dropwizard.metrics5.MetricRegistry;
import io.dropwizard.metrics5.Timer;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.PoolStats;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/Dropwizard5MetricsTracker.class */
public class Dropwizard5MetricsTracker implements IMetricsTracker {
    private final String poolName;
    private final Timer connectionObtainTimer;
    private final Histogram connectionUsage;
    private final Histogram connectionCreation;
    private final Meter connectionTimeoutMeter;
    private final MetricRegistry registry;

    Dropwizard5MetricsTracker(String str, PoolStats poolStats, MetricRegistry metricRegistry) {
        this.poolName = str;
        this.registry = metricRegistry;
        this.connectionObtainTimer = metricRegistry.timer(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Wait"}));
        this.connectionUsage = metricRegistry.histogram(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Usage"}));
        this.connectionCreation = metricRegistry.histogram(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectionCreation"}));
        this.connectionTimeoutMeter = metricRegistry.meter(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectionTimeoutRate"}));
        MetricName metricNameName = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "TotalConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(metricNameName, poolStats::getTotalConnections);
        MetricName metricNameName2 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "IdleConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(metricNameName2, poolStats::getIdleConnections);
        MetricName metricNameName3 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ActiveConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(metricNameName3, poolStats::getActiveConnections);
        MetricName metricNameName4 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "PendingConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(metricNameName4, poolStats::getPendingThreads);
        MetricName metricNameName5 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "MaxConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(metricNameName5, poolStats::getMaxConnections);
        MetricName metricNameName6 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "MinConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(metricNameName6, poolStats::getMinConnections);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker, java.lang.AutoCloseable
    public void close() {
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Wait"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Usage"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectionCreation"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectionTimeoutRate"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "TotalConnections"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "IdleConnections"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ActiveConnections"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "PendingConnections"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "MaxConnections"}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "MinConnections"}));
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionAcquiredNanos(long j) {
        this.connectionObtainTimer.update(j, TimeUnit.NANOSECONDS);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionUsageMillis(long j) {
        this.connectionUsage.update(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionTimeout() {
        this.connectionTimeoutMeter.mark();
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionCreatedMillis(long j) {
        this.connectionCreation.update(j);
    }

    public Timer getConnectionAcquisitionTimer() {
        return this.connectionObtainTimer;
    }

    public Histogram getConnectionDurationHistogram() {
        return this.connectionUsage;
    }

    public Histogram getConnectionCreationHistogram() {
        return this.connectionCreation;
    }
}

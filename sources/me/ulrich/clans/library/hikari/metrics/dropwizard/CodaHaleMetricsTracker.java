package me.ulrich.clans.library.hikari.metrics.dropwizard;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.PoolStats;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/CodaHaleMetricsTracker.class */
public final class CodaHaleMetricsTracker implements IMetricsTracker {
    private final String poolName;
    private final Timer connectionObtainTimer;
    private final Histogram connectionUsage;
    private final Histogram connectionCreation;
    private final Meter connectionTimeoutMeter;
    private final MetricRegistry registry;

    CodaHaleMetricsTracker(String str, PoolStats poolStats, MetricRegistry metricRegistry) {
        this.poolName = str;
        this.registry = metricRegistry;
        this.connectionObtainTimer = metricRegistry.timer(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Wait"}));
        this.connectionUsage = metricRegistry.histogram(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "Usage"}));
        this.connectionCreation = metricRegistry.histogram(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectionCreation"}));
        this.connectionTimeoutMeter = metricRegistry.meter(MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ConnectionTimeoutRate"}));
        String strName = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "TotalConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(strName, poolStats::getTotalConnections);
        String strName2 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "IdleConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(strName2, poolStats::getIdleConnections);
        String strName3 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "ActiveConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(strName3, poolStats::getActiveConnections);
        String strName4 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "PendingConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(strName4, poolStats::getPendingThreads);
        String strName5 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "MaxConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(strName5, poolStats::getMaxConnections);
        String strName6 = MetricRegistry.name(str, new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX, "MinConnections"});
        Objects.requireNonNull(poolStats);
        metricRegistry.register(strName6, poolStats::getMinConnections);
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

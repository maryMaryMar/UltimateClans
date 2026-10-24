package me.ulrich.clans.library.hikari.metrics.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.PoolStats;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/micrometer/MicrometerMetricsTracker.class */
public class MicrometerMetricsTracker implements IMetricsTracker {
    public static final String HIKARI_METRIC_NAME_PREFIX = "hikaricp";
    private static final String METRIC_CATEGORY = "pool";
    private static final String METRIC_NAME_WAIT = "hikaricp.connections.acquire";
    private static final String METRIC_NAME_USAGE = "hikaricp.connections.usage";
    private static final String METRIC_NAME_CONNECT = "hikaricp.connections.creation";
    private static final String METRIC_NAME_TIMEOUT_RATE = "hikaricp.connections.timeout";
    private static final String METRIC_NAME_TOTAL_CONNECTIONS = "hikaricp.connections";
    private static final String METRIC_NAME_IDLE_CONNECTIONS = "hikaricp.connections.idle";
    private static final String METRIC_NAME_ACTIVE_CONNECTIONS = "hikaricp.connections.active";
    private static final String METRIC_NAME_PENDING_CONNECTIONS = "hikaricp.connections.pending";
    private static final String METRIC_NAME_MAX_CONNECTIONS = "hikaricp.connections.max";
    private static final String METRIC_NAME_MIN_CONNECTIONS = "hikaricp.connections.min";
    private final Timer connectionObtainTimer;
    private final Counter connectionTimeoutCounter;
    private final Timer connectionUsage;
    private final Timer connectionCreation;
    private final Gauge totalConnectionGauge;
    private final Gauge idleConnectionGauge;
    private final Gauge activeConnectionGauge;
    private final Gauge pendingConnectionGauge;
    private final Gauge maxConnectionGauge;
    private final Gauge minConnectionGauge;
    private final MeterRegistry meterRegistry;
    private final PoolStats poolStats;

    MicrometerMetricsTracker(String str, PoolStats poolStats, MeterRegistry meterRegistry) {
        this.poolStats = poolStats;
        this.meterRegistry = meterRegistry;
        this.connectionObtainTimer = Timer.builder(METRIC_NAME_WAIT).description("Connection acquire time").tags(new String[]{"pool", str}).register(meterRegistry);
        this.connectionCreation = Timer.builder(METRIC_NAME_CONNECT).description("Connection creation time").tags(new String[]{"pool", str}).register(meterRegistry);
        this.connectionUsage = Timer.builder(METRIC_NAME_USAGE).description("Connection usage time").tags(new String[]{"pool", str}).register(meterRegistry);
        this.connectionTimeoutCounter = Counter.builder(METRIC_NAME_TIMEOUT_RATE).description("Connection timeout total count").tags(new String[]{"pool", str}).register(meterRegistry);
        this.totalConnectionGauge = Gauge.builder(METRIC_NAME_TOTAL_CONNECTIONS, poolStats, (v0) -> {
            return v0.getTotalConnections();
        }).description("Total connections").tags(new String[]{"pool", str}).register(meterRegistry);
        this.idleConnectionGauge = Gauge.builder(METRIC_NAME_IDLE_CONNECTIONS, poolStats, (v0) -> {
            return v0.getIdleConnections();
        }).description("Idle connections").tags(new String[]{"pool", str}).register(meterRegistry);
        this.activeConnectionGauge = Gauge.builder(METRIC_NAME_ACTIVE_CONNECTIONS, poolStats, (v0) -> {
            return v0.getActiveConnections();
        }).description("Active connections").tags(new String[]{"pool", str}).register(meterRegistry);
        this.pendingConnectionGauge = Gauge.builder(METRIC_NAME_PENDING_CONNECTIONS, poolStats, (v0) -> {
            return v0.getPendingThreads();
        }).description("Pending threads").tags(new String[]{"pool", str}).register(meterRegistry);
        this.maxConnectionGauge = Gauge.builder(METRIC_NAME_MAX_CONNECTIONS, poolStats, (v0) -> {
            return v0.getMaxConnections();
        }).description("Max connections").tags(new String[]{"pool", str}).register(meterRegistry);
        this.minConnectionGauge = Gauge.builder(METRIC_NAME_MIN_CONNECTIONS, poolStats, (v0) -> {
            return v0.getMinConnections();
        }).description("Min connections").tags(new String[]{"pool", str}).register(meterRegistry);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionAcquiredNanos(long j) {
        this.connectionObtainTimer.record(j, TimeUnit.NANOSECONDS);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionUsageMillis(long j) {
        this.connectionUsage.record(j, TimeUnit.MILLISECONDS);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionTimeout() {
        this.connectionTimeoutCounter.increment();
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionCreatedMillis(long j) {
        this.connectionCreation.record(j, TimeUnit.MILLISECONDS);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker, java.lang.AutoCloseable
    public void close() {
        this.meterRegistry.remove(this.connectionObtainTimer);
        this.meterRegistry.remove(this.connectionTimeoutCounter);
        this.meterRegistry.remove(this.connectionUsage);
        this.meterRegistry.remove(this.connectionCreation);
        this.meterRegistry.remove(this.totalConnectionGauge);
        this.meterRegistry.remove(this.idleConnectionGauge);
        this.meterRegistry.remove(this.activeConnectionGauge);
        this.meterRegistry.remove(this.pendingConnectionGauge);
        this.meterRegistry.remove(this.maxConnectionGauge);
        this.meterRegistry.remove(this.minConnectionGauge);
    }
}

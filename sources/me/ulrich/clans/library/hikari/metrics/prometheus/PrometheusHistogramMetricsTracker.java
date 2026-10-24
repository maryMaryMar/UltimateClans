package me.ulrich.clans.library.hikari.metrics.prometheus;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/prometheus/PrometheusHistogramMetricsTracker.class */
class PrometheusHistogramMetricsTracker implements IMetricsTracker {
    private final Counter.Child connectionTimeoutCounterChild;
    private final String poolName;
    private final HikariCPCollector hikariCPCollector;
    private final Histogram.Child elapsedAcquiredHistogramChild;
    private final Histogram.Child elapsedBorrowedHistogramChild;
    private final Histogram.Child elapsedCreationHistogramChild;
    private static final Counter CONNECTION_TIMEOUT_COUNTER = Counter.build().name("hikaricp_connection_timeout_total").labelNames(new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX}).help("Connection timeout total count").create();
    private static final Histogram ELAPSED_ACQUIRED_HISTOGRAM = registerHistogram("hikaricp_connection_acquired_nanos", "Connection acquired time (ns)", 1000.0d);
    private static final Histogram ELAPSED_BORROWED_HISTOGRAM = registerHistogram("hikaricp_connection_usage_millis", "Connection usage (ms)", 1.0d);
    private static final Histogram ELAPSED_CREATION_HISTOGRAM = registerHistogram("hikaricp_connection_creation_millis", "Connection creation (ms)", 1.0d);
    private static final Map<CollectorRegistry, PrometheusMetricsTrackerFactory.RegistrationStatus> registrationStatuses = new ConcurrentHashMap();

    private static Histogram registerHistogram(String str, String str2, double d) {
        return Histogram.build().name(str).labelNames(new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX}).help(str2).exponentialBuckets(d, 2.0d, 11).create();
    }

    PrometheusHistogramMetricsTracker(String str, CollectorRegistry collectorRegistry, HikariCPCollector hikariCPCollector) {
        registerMetrics(collectorRegistry);
        this.poolName = str;
        this.hikariCPCollector = hikariCPCollector;
        this.connectionTimeoutCounterChild = (Counter.Child) CONNECTION_TIMEOUT_COUNTER.labels(new String[]{str});
        this.elapsedAcquiredHistogramChild = (Histogram.Child) ELAPSED_ACQUIRED_HISTOGRAM.labels(new String[]{str});
        this.elapsedBorrowedHistogramChild = (Histogram.Child) ELAPSED_BORROWED_HISTOGRAM.labels(new String[]{str});
        this.elapsedCreationHistogramChild = (Histogram.Child) ELAPSED_CREATION_HISTOGRAM.labels(new String[]{str});
    }

    private void registerMetrics(CollectorRegistry collectorRegistry) {
        if (registrationStatuses.putIfAbsent(collectorRegistry, PrometheusMetricsTrackerFactory.RegistrationStatus.REGISTERED) == null) {
            CONNECTION_TIMEOUT_COUNTER.register(collectorRegistry);
            ELAPSED_ACQUIRED_HISTOGRAM.register(collectorRegistry);
            ELAPSED_BORROWED_HISTOGRAM.register(collectorRegistry);
            ELAPSED_CREATION_HISTOGRAM.register(collectorRegistry);
        }
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionAcquiredNanos(long j) {
        this.elapsedAcquiredHistogramChild.observe(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionUsageMillis(long j) {
        this.elapsedBorrowedHistogramChild.observe(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionCreatedMillis(long j) {
        this.elapsedCreationHistogramChild.observe(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionTimeout() {
        this.connectionTimeoutCounterChild.inc();
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker, java.lang.AutoCloseable
    public void close() {
        this.hikariCPCollector.remove(this.poolName);
        CONNECTION_TIMEOUT_COUNTER.remove(new String[]{this.poolName});
        ELAPSED_ACQUIRED_HISTOGRAM.remove(new String[]{this.poolName});
        ELAPSED_BORROWED_HISTOGRAM.remove(new String[]{this.poolName});
        ELAPSED_CREATION_HISTOGRAM.remove(new String[]{this.poolName});
    }
}

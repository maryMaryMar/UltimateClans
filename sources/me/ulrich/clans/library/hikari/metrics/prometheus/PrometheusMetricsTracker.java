package me.ulrich.clans.library.hikari.metrics.prometheus;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Summary;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/prometheus/PrometheusMetricsTracker.class */
class PrometheusMetricsTracker implements IMetricsTracker {
    private static final Counter CONNECTION_TIMEOUT_COUNTER = Counter.build().name("hikaricp_connection_timeout_total").labelNames(new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX}).help("Connection timeout total count").create();
    private static final Summary ELAPSED_ACQUIRED_SUMMARY = createSummary("hikaricp_connection_acquired_nanos", "Connection acquired time (ns)");
    private static final Summary ELAPSED_USAGE_SUMMARY = createSummary("hikaricp_connection_usage_millis", "Connection usage (ms)");
    private static final Summary ELAPSED_CREATION_SUMMARY = createSummary("hikaricp_connection_creation_millis", "Connection creation (ms)");
    private static final Map<CollectorRegistry, PrometheusMetricsTrackerFactory.RegistrationStatus> registrationStatuses = new ConcurrentHashMap();
    private final String poolName;
    private final HikariCPCollector hikariCPCollector;
    private final Counter.Child connectionTimeoutCounterChild;
    private final Summary.Child elapsedAcquiredSummaryChild;
    private final Summary.Child elapsedUsageSummaryChild;
    private final Summary.Child elapsedCreationSummaryChild;

    PrometheusMetricsTracker(String str, CollectorRegistry collectorRegistry, HikariCPCollector hikariCPCollector) {
        registerMetrics(collectorRegistry);
        this.poolName = str;
        this.hikariCPCollector = hikariCPCollector;
        this.connectionTimeoutCounterChild = (Counter.Child) CONNECTION_TIMEOUT_COUNTER.labels(new String[]{str});
        this.elapsedAcquiredSummaryChild = (Summary.Child) ELAPSED_ACQUIRED_SUMMARY.labels(new String[]{str});
        this.elapsedUsageSummaryChild = (Summary.Child) ELAPSED_USAGE_SUMMARY.labels(new String[]{str});
        this.elapsedCreationSummaryChild = (Summary.Child) ELAPSED_CREATION_SUMMARY.labels(new String[]{str});
    }

    private void registerMetrics(CollectorRegistry collectorRegistry) {
        if (registrationStatuses.putIfAbsent(collectorRegistry, PrometheusMetricsTrackerFactory.RegistrationStatus.REGISTERED) == null) {
            CONNECTION_TIMEOUT_COUNTER.register(collectorRegistry);
            ELAPSED_ACQUIRED_SUMMARY.register(collectorRegistry);
            ELAPSED_USAGE_SUMMARY.register(collectorRegistry);
            ELAPSED_CREATION_SUMMARY.register(collectorRegistry);
        }
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionAcquiredNanos(long j) {
        this.elapsedAcquiredSummaryChild.observe(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionUsageMillis(long j) {
        this.elapsedUsageSummaryChild.observe(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionCreatedMillis(long j) {
        this.elapsedCreationSummaryChild.observe(j);
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker
    public void recordConnectionTimeout() {
        this.connectionTimeoutCounterChild.inc();
    }

    private static Summary createSummary(String str, String str2) {
        return Summary.build().name(str).labelNames(new String[]{BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX}).help(str2).quantile(0.5d, 0.05d).quantile(0.95d, 0.01d).quantile(0.99d, 0.001d).maxAgeSeconds(TimeUnit.MINUTES.toSeconds(5L)).ageBuckets(5).create();
    }

    @Override // me.ulrich.clans.library.hikari.metrics.IMetricsTracker, java.lang.AutoCloseable
    public void close() {
        this.hikariCPCollector.remove(this.poolName);
        CONNECTION_TIMEOUT_COUNTER.remove(new String[]{this.poolName});
        ELAPSED_ACQUIRED_SUMMARY.remove(new String[]{this.poolName});
        ELAPSED_USAGE_SUMMARY.remove(new String[]{this.poolName});
        ELAPSED_CREATION_SUMMARY.remove(new String[]{this.poolName});
    }
}

package me.ulrich.clans.library.hikari.metrics.prometheus;

import io.prometheus.client.Collector;
import io.prometheus.client.CollectorRegistry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory;
import me.ulrich.clans.library.hikari.metrics.PoolStats;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/prometheus/PrometheusMetricsTrackerFactory.class */
public class PrometheusMetricsTrackerFactory implements MetricsTrackerFactory {
    private static final Map<CollectorRegistry, RegistrationStatus> registrationStatuses = new ConcurrentHashMap();
    private final HikariCPCollector collector;
    private final CollectorRegistry collectorRegistry;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/prometheus/PrometheusMetricsTrackerFactory$RegistrationStatus.class */
    enum RegistrationStatus {
        REGISTERED
    }

    public PrometheusMetricsTrackerFactory() {
        this(CollectorRegistry.defaultRegistry);
    }

    public PrometheusMetricsTrackerFactory(CollectorRegistry collectorRegistry) {
        this.collector = new HikariCPCollector();
        this.collectorRegistry = collectorRegistry;
    }

    @Override // me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory
    public IMetricsTracker create(String str, PoolStats poolStats) {
        registerCollector(this.collector, this.collectorRegistry);
        this.collector.add(str, poolStats);
        return new PrometheusMetricsTracker(str, this.collectorRegistry, this.collector);
    }

    private void registerCollector(Collector collector, CollectorRegistry collectorRegistry) {
        if (registrationStatuses.putIfAbsent(collectorRegistry, RegistrationStatus.REGISTERED) == null) {
            collector.register(collectorRegistry);
        }
    }
}

package me.ulrich.clans.library.hikari.metrics.dropwizard;

import com.codahale.metrics.MetricRegistry;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory;
import me.ulrich.clans.library.hikari.metrics.PoolStats;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/CodahaleMetricsTrackerFactory.class */
public final class CodahaleMetricsTrackerFactory implements MetricsTrackerFactory {
    private final MetricRegistry registry;

    public CodahaleMetricsTrackerFactory(MetricRegistry metricRegistry) {
        this.registry = metricRegistry;
    }

    public MetricRegistry getRegistry() {
        return this.registry;
    }

    @Override // me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory
    public IMetricsTracker create(String str, PoolStats poolStats) {
        return new CodaHaleMetricsTracker(str, poolStats, this.registry);
    }
}

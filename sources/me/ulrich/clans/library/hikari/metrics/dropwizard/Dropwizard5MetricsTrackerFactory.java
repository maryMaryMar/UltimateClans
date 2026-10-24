package me.ulrich.clans.library.hikari.metrics.dropwizard;

import io.dropwizard.metrics5.MetricRegistry;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory;
import me.ulrich.clans.library.hikari.metrics.PoolStats;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/dropwizard/Dropwizard5MetricsTrackerFactory.class */
public class Dropwizard5MetricsTrackerFactory implements MetricsTrackerFactory {
    private final MetricRegistry registry;

    public Dropwizard5MetricsTrackerFactory(MetricRegistry metricRegistry) {
        this.registry = metricRegistry;
    }

    public MetricRegistry getRegistry() {
        return this.registry;
    }

    @Override // me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory
    public IMetricsTracker create(String str, PoolStats poolStats) {
        return new Dropwizard5MetricsTracker(str, poolStats, this.registry);
    }
}

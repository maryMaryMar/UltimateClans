package me.ulrich.clans.library.hikari.metrics.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory;
import me.ulrich.clans.library.hikari.metrics.PoolStats;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/micrometer/MicrometerMetricsTrackerFactory.class */
public class MicrometerMetricsTrackerFactory implements MetricsTrackerFactory {
    private final MeterRegistry registry;

    public MicrometerMetricsTrackerFactory(MeterRegistry meterRegistry) {
        this.registry = meterRegistry;
    }

    @Override // me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory
    public IMetricsTracker create(String str, PoolStats poolStats) {
        return new MicrometerMetricsTracker(str, poolStats, this.registry);
    }
}

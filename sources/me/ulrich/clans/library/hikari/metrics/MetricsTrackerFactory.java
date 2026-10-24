package me.ulrich.clans.library.hikari.metrics;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/MetricsTrackerFactory.class */
public interface MetricsTrackerFactory {
    IMetricsTracker create(String str, PoolStats poolStats);
}

package me.ulrich.clans.library.hikari.metrics;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/IMetricsTracker.class */
public interface IMetricsTracker extends AutoCloseable {
    default void recordConnectionCreatedMillis(long j) {
    }

    default void recordConnectionAcquiredNanos(long j) {
    }

    default void recordConnectionUsageMillis(long j) {
    }

    default void recordConnectionTimeout() {
    }

    @Override // java.lang.AutoCloseable
    default void close() {
    }
}

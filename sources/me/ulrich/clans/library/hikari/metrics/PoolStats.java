package me.ulrich.clans.library.hikari.metrics;

import java.util.concurrent.atomic.AtomicLong;
import me.ulrich.clans.library.hikari.util.ClockSource;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/PoolStats.class */
public abstract class PoolStats {
    private final AtomicLong reloadAt = new AtomicLong();
    private final long timeoutMs;
    protected volatile int totalConnections;
    protected volatile int idleConnections;
    protected volatile int activeConnections;
    protected volatile int pendingThreads;
    protected volatile int maxConnections;
    protected volatile int minConnections;

    public PoolStats(long j) {
        this.timeoutMs = j;
    }

    public int getTotalConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.totalConnections;
    }

    public int getIdleConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.idleConnections;
    }

    public int getActiveConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.activeConnections;
    }

    public int getPendingThreads() {
        if (shouldLoad()) {
            update();
        }
        return this.pendingThreads;
    }

    public int getMaxConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.maxConnections;
    }

    public int getMinConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.minConnections;
    }

    protected abstract void update();

    private boolean shouldLoad() {
        long jCurrentTime;
        long j;
        do {
            jCurrentTime = ClockSource.currentTime();
            j = this.reloadAt.get();
            if (j > jCurrentTime) {
                return false;
            }
        } while (!this.reloadAt.compareAndSet(j, ClockSource.plusMillis(jCurrentTime, this.timeoutMs)));
        return true;
    }
}

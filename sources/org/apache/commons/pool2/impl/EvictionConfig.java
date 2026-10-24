package org.apache.commons.pool2.impl;

import java.time.Duration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/EvictionConfig.class */
public class EvictionConfig {
    private static final Duration MAX_DURATION = Duration.ofMillis(Long.MAX_VALUE);
    private final Duration idleEvictDuration;
    private final Duration idleSoftEvictDuration;
    private final int minIdle;

    public EvictionConfig(Duration duration, Duration duration2, int i) {
        this.idleEvictDuration = PoolImplUtils.isPositive(duration) ? duration : MAX_DURATION;
        this.idleSoftEvictDuration = PoolImplUtils.isPositive(duration2) ? duration2 : MAX_DURATION;
        this.minIdle = i;
    }

    @Deprecated
    public EvictionConfig(long j, long j2, int i) {
        this(Duration.ofMillis(j), Duration.ofMillis(j2), i);
    }

    public Duration getIdleEvictDuration() {
        return this.idleEvictDuration;
    }

    @Deprecated
    public long getIdleEvictTime() {
        return this.idleEvictDuration.toMillis();
    }

    @Deprecated
    public Duration getIdleEvictTimeDuration() {
        return this.idleEvictDuration;
    }

    public Duration getIdleSoftEvictDuration() {
        return this.idleSoftEvictDuration;
    }

    @Deprecated
    public long getIdleSoftEvictTime() {
        return this.idleSoftEvictDuration.toMillis();
    }

    @Deprecated
    public Duration getIdleSoftEvictTimeDuration() {
        return this.idleSoftEvictDuration;
    }

    public int getMinIdle() {
        return this.minIdle;
    }

    public String toString() {
        return "EvictionConfig [idleEvictDuration=" + this.idleEvictDuration + ", idleSoftEvictDuration=" + this.idleSoftEvictDuration + ", minIdle=" + this.minIdle + "]";
    }
}

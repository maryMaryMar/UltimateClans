package org.apache.commons.pool2.impl;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.Duration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/AbandonedConfig.class */
public class AbandonedConfig {
    private static final Duration DEFAULT_REMOVE_ABANDONED_TIMEOUT_DURATION = Duration.ofMinutes(5);
    private boolean removeAbandonedOnBorrow;
    private boolean removeAbandonedOnMaintenance;
    private boolean logAbandoned;
    private boolean useUsageTracking;
    private Duration removeAbandonedTimeoutDuration = DEFAULT_REMOVE_ABANDONED_TIMEOUT_DURATION;
    private boolean requireFullStackTrace = true;
    private PrintWriter logWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));

    public static AbandonedConfig copy(AbandonedConfig abandonedConfig) {
        if (abandonedConfig == null) {
            return null;
        }
        return new AbandonedConfig(abandonedConfig);
    }

    public AbandonedConfig() {
    }

    private AbandonedConfig(AbandonedConfig abandonedConfig) {
        setLogAbandoned(abandonedConfig.getLogAbandoned());
        setLogWriter(abandonedConfig.getLogWriter());
        setRemoveAbandonedOnBorrow(abandonedConfig.getRemoveAbandonedOnBorrow());
        setRemoveAbandonedOnMaintenance(abandonedConfig.getRemoveAbandonedOnMaintenance());
        setRemoveAbandonedTimeout(abandonedConfig.getRemoveAbandonedTimeoutDuration());
        setUseUsageTracking(abandonedConfig.getUseUsageTracking());
        setRequireFullStackTrace(abandonedConfig.getRequireFullStackTrace());
    }

    public boolean getLogAbandoned() {
        return this.logAbandoned;
    }

    public PrintWriter getLogWriter() {
        return this.logWriter;
    }

    public boolean getRemoveAbandonedOnBorrow() {
        return this.removeAbandonedOnBorrow;
    }

    public boolean getRemoveAbandonedOnMaintenance() {
        return this.removeAbandonedOnMaintenance;
    }

    @Deprecated
    public int getRemoveAbandonedTimeout() {
        return (int) this.removeAbandonedTimeoutDuration.getSeconds();
    }

    public Duration getRemoveAbandonedTimeoutDuration() {
        return this.removeAbandonedTimeoutDuration;
    }

    public boolean getRequireFullStackTrace() {
        return this.requireFullStackTrace;
    }

    public boolean getUseUsageTracking() {
        return this.useUsageTracking;
    }

    public void setLogAbandoned(boolean z) {
        this.logAbandoned = z;
    }

    public void setLogWriter(PrintWriter printWriter) {
        this.logWriter = printWriter;
    }

    public void setRemoveAbandonedOnBorrow(boolean z) {
        this.removeAbandonedOnBorrow = z;
    }

    public void setRemoveAbandonedOnMaintenance(boolean z) {
        this.removeAbandonedOnMaintenance = z;
    }

    public void setRemoveAbandonedTimeout(Duration duration) {
        this.removeAbandonedTimeoutDuration = PoolImplUtils.nonNull(duration, DEFAULT_REMOVE_ABANDONED_TIMEOUT_DURATION);
    }

    @Deprecated
    public void setRemoveAbandonedTimeout(int i) {
        setRemoveAbandonedTimeout(Duration.ofSeconds(i));
    }

    public void setRequireFullStackTrace(boolean z) {
        this.requireFullStackTrace = z;
    }

    public void setUseUsageTracking(boolean z) {
        this.useUsageTracking = z;
    }

    public String toString() {
        return "AbandonedConfig [removeAbandonedOnBorrow=" + this.removeAbandonedOnBorrow + ", removeAbandonedOnMaintenance=" + this.removeAbandonedOnMaintenance + ", removeAbandonedTimeoutDuration=" + this.removeAbandonedTimeoutDuration + ", logAbandoned=" + this.logAbandoned + ", logWriter=" + this.logWriter + ", useUsageTracking=" + this.useUsageTracking + "]";
    }
}

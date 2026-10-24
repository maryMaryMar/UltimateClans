package org.apache.commons.pool2.impl;

import java.time.Duration;
import org.apache.commons.pool2.BaseObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/BaseObjectPoolConfig.class */
public abstract class BaseObjectPoolConfig<T> extends BaseObject implements Cloneable {
    public static final boolean DEFAULT_LIFO = true;
    public static final boolean DEFAULT_FAIRNESS = false;

    @Deprecated
    public static final long DEFAULT_MAX_WAIT_MILLIS = -1;

    @Deprecated
    public static final long DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS = -1;
    public static final int DEFAULT_NUM_TESTS_PER_EVICTION_RUN = 3;
    public static final boolean DEFAULT_TEST_ON_CREATE = false;
    public static final boolean DEFAULT_TEST_ON_BORROW = false;
    public static final boolean DEFAULT_TEST_ON_RETURN = false;
    public static final boolean DEFAULT_TEST_WHILE_IDLE = false;

    @Deprecated
    public static final long DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS = -1;
    public static final boolean DEFAULT_BLOCK_WHEN_EXHAUSTED = true;
    public static final boolean DEFAULT_JMX_ENABLE = true;
    public static final String DEFAULT_JMX_NAME_PREFIX = "pool";
    private EvictionPolicy<T> evictionPolicy;
    public static final Duration DEFAULT_MAX_WAIT = Duration.ofMillis(-1);

    @Deprecated
    public static final long DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS = 1800000;
    public static final Duration DEFAULT_MIN_EVICTABLE_IDLE_DURATION = Duration.ofMillis(DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS);

    @Deprecated
    public static final Duration DEFAULT_MIN_EVICTABLE_IDLE_TIME = Duration.ofMillis(DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS);

    @Deprecated
    public static final Duration DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME = Duration.ofMillis(-1);
    public static final Duration DEFAULT_SOFT_MIN_EVICTABLE_IDLE_DURATION = Duration.ofMillis(-1);

    @Deprecated
    public static final long DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS = 10000;
    public static final Duration DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT = Duration.ofMillis(DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS);
    public static final Duration DEFAULT_TIME_BETWEEN_EVICTION_RUNS = Duration.ofMillis(-1);
    public static final String DEFAULT_JMX_NAME_BASE = null;
    public static final String DEFAULT_EVICTION_POLICY_CLASS_NAME = DefaultEvictionPolicy.class.getName();
    private boolean lifo = true;
    private boolean fairness = false;
    private Duration maxWaitDuration = DEFAULT_MAX_WAIT;
    private Duration minEvictableIdleDuration = DEFAULT_MIN_EVICTABLE_IDLE_TIME;
    private Duration evictorShutdownTimeoutDuration = DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT;
    private Duration softMinEvictableIdleDuration = DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME;
    private int numTestsPerEvictionRun = 3;
    private String evictionPolicyClassName = DEFAULT_EVICTION_POLICY_CLASS_NAME;
    private boolean testOnCreate = false;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
    private boolean testWhileIdle = false;
    private Duration durationBetweenEvictionRuns = DEFAULT_TIME_BETWEEN_EVICTION_RUNS;
    private boolean blockWhenExhausted = true;
    private boolean jmxEnabled = true;
    private String jmxNamePrefix = DEFAULT_JMX_NAME_PREFIX;
    private String jmxNameBase = DEFAULT_JMX_NAME_BASE;

    public boolean getBlockWhenExhausted() {
        return this.blockWhenExhausted;
    }

    public EvictionPolicy<T> getEvictionPolicy() {
        return this.evictionPolicy;
    }

    public String getEvictionPolicyClassName() {
        return this.evictionPolicyClassName;
    }

    @Deprecated
    public Duration getEvictorShutdownTimeout() {
        return this.evictorShutdownTimeoutDuration;
    }

    public Duration getEvictorShutdownTimeoutDuration() {
        return this.evictorShutdownTimeoutDuration;
    }

    @Deprecated
    public long getEvictorShutdownTimeoutMillis() {
        return this.evictorShutdownTimeoutDuration.toMillis();
    }

    public boolean getFairness() {
        return this.fairness;
    }

    public boolean getJmxEnabled() {
        return this.jmxEnabled;
    }

    public String getJmxNameBase() {
        return this.jmxNameBase;
    }

    public String getJmxNamePrefix() {
        return this.jmxNamePrefix;
    }

    public boolean getLifo() {
        return this.lifo;
    }

    public Duration getMaxWaitDuration() {
        return this.maxWaitDuration;
    }

    @Deprecated
    public long getMaxWaitMillis() {
        return this.maxWaitDuration.toMillis();
    }

    public Duration getMinEvictableIdleDuration() {
        return this.minEvictableIdleDuration;
    }

    @Deprecated
    public Duration getMinEvictableIdleTime() {
        return this.minEvictableIdleDuration;
    }

    @Deprecated
    public long getMinEvictableIdleTimeMillis() {
        return this.minEvictableIdleDuration.toMillis();
    }

    public int getNumTestsPerEvictionRun() {
        return this.numTestsPerEvictionRun;
    }

    public Duration getSoftMinEvictableIdleDuration() {
        return this.softMinEvictableIdleDuration;
    }

    @Deprecated
    public Duration getSoftMinEvictableIdleTime() {
        return this.softMinEvictableIdleDuration;
    }

    @Deprecated
    public long getSoftMinEvictableIdleTimeMillis() {
        return this.softMinEvictableIdleDuration.toMillis();
    }

    public boolean getTestOnBorrow() {
        return this.testOnBorrow;
    }

    public boolean getTestOnCreate() {
        return this.testOnCreate;
    }

    public boolean getTestOnReturn() {
        return this.testOnReturn;
    }

    public boolean getTestWhileIdle() {
        return this.testWhileIdle;
    }

    public Duration getDurationBetweenEvictionRuns() {
        return this.durationBetweenEvictionRuns;
    }

    @Deprecated
    public Duration getTimeBetweenEvictionRuns() {
        return this.durationBetweenEvictionRuns;
    }

    @Deprecated
    public long getTimeBetweenEvictionRunsMillis() {
        return this.durationBetweenEvictionRuns.toMillis();
    }

    public void setBlockWhenExhausted(boolean z) {
        this.blockWhenExhausted = z;
    }

    public void setEvictionPolicy(EvictionPolicy<T> evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public void setEvictionPolicyClassName(String str) {
        this.evictionPolicyClassName = str;
    }

    @Deprecated
    public void setEvictorShutdownTimeoutMillis(Duration duration) {
        setEvictorShutdownTimeout(duration);
    }

    public void setEvictorShutdownTimeout(Duration duration) {
        this.evictorShutdownTimeoutDuration = PoolImplUtils.nonNull(duration, DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT);
    }

    @Deprecated
    public void setEvictorShutdownTimeoutMillis(long j) {
        setEvictorShutdownTimeout(Duration.ofMillis(j));
    }

    public void setFairness(boolean z) {
        this.fairness = z;
    }

    public void setJmxEnabled(boolean z) {
        this.jmxEnabled = z;
    }

    public void setJmxNameBase(String str) {
        this.jmxNameBase = str;
    }

    public void setJmxNamePrefix(String str) {
        this.jmxNamePrefix = str;
    }

    public void setLifo(boolean z) {
        this.lifo = z;
    }

    @Deprecated
    public void setMaxWaitMillis(long j) {
        setMaxWait(Duration.ofMillis(j));
    }

    public void setMaxWait(Duration duration) {
        this.maxWaitDuration = PoolImplUtils.nonNull(duration, DEFAULT_MAX_WAIT);
    }

    public void setMinEvictableIdleTime(Duration duration) {
        this.minEvictableIdleDuration = PoolImplUtils.nonNull(duration, DEFAULT_MIN_EVICTABLE_IDLE_TIME);
    }

    @Deprecated
    public void setMinEvictableIdleTimeMillis(long j) {
        this.minEvictableIdleDuration = Duration.ofMillis(j);
    }

    public void setNumTestsPerEvictionRun(int i) {
        this.numTestsPerEvictionRun = i;
    }

    public void setSoftMinEvictableIdleTime(Duration duration) {
        this.softMinEvictableIdleDuration = PoolImplUtils.nonNull(duration, DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME);
    }

    @Deprecated
    public void setSoftMinEvictableIdleTimeMillis(long j) {
        setSoftMinEvictableIdleTime(Duration.ofMillis(j));
    }

    public void setTestOnBorrow(boolean z) {
        this.testOnBorrow = z;
    }

    public void setTestOnCreate(boolean z) {
        this.testOnCreate = z;
    }

    public void setTestOnReturn(boolean z) {
        this.testOnReturn = z;
    }

    public void setTestWhileIdle(boolean z) {
        this.testWhileIdle = z;
    }

    public void setTimeBetweenEvictionRuns(Duration duration) {
        this.durationBetweenEvictionRuns = PoolImplUtils.nonNull(duration, DEFAULT_TIME_BETWEEN_EVICTION_RUNS);
    }

    @Deprecated
    public void setTimeBetweenEvictionRunsMillis(long j) {
        setTimeBetweenEvictionRuns(Duration.ofMillis(j));
    }

    @Override // org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        sb.append("lifo=");
        sb.append(this.lifo);
        sb.append(", fairness=");
        sb.append(this.fairness);
        sb.append(", maxWaitDuration=");
        sb.append(this.maxWaitDuration);
        sb.append(", minEvictableIdleTime=");
        sb.append(this.minEvictableIdleDuration);
        sb.append(", softMinEvictableIdleTime=");
        sb.append(this.softMinEvictableIdleDuration);
        sb.append(", numTestsPerEvictionRun=");
        sb.append(this.numTestsPerEvictionRun);
        sb.append(", evictionPolicyClassName=");
        sb.append(this.evictionPolicyClassName);
        sb.append(", testOnCreate=");
        sb.append(this.testOnCreate);
        sb.append(", testOnBorrow=");
        sb.append(this.testOnBorrow);
        sb.append(", testOnReturn=");
        sb.append(this.testOnReturn);
        sb.append(", testWhileIdle=");
        sb.append(this.testWhileIdle);
        sb.append(", timeBetweenEvictionRuns=");
        sb.append(this.durationBetweenEvictionRuns);
        sb.append(", blockWhenExhausted=");
        sb.append(this.blockWhenExhausted);
        sb.append(", jmxEnabled=");
        sb.append(this.jmxEnabled);
        sb.append(", jmxNamePrefix=");
        sb.append(this.jmxNamePrefix);
        sb.append(", jmxNameBase=");
        sb.append(this.jmxNameBase);
    }
}

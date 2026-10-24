package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import org.apache.commons.pool2.BaseObject;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.SwallowedExceptionListener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/BaseGenericObjectPool.class */
public abstract class BaseGenericObjectPool<T> extends BaseObject {
    public static final int MEAN_TIMING_STATS_CACHE_SIZE = 100;
    private static final String EVICTION_POLICY_TYPE_NAME = EvictionPolicy.class.getName();
    private static final Duration DEFAULT_REMOVE_ABANDONED_TIMEOUT = Duration.ofSeconds(2147483647L);
    private final boolean fairness;
    private volatile EvictionPolicy<T> evictionPolicy;
    volatile boolean closed;
    private BaseGenericObjectPool<T>.Evictor evictor;
    BaseGenericObjectPool<T>.EvictionIterator evictionIterator;
    private final WeakReference<ClassLoader> factoryClassLoader;
    private final ObjectName objectName;
    private final String creationStackTrace;
    private volatile SwallowedExceptionListener swallowedExceptionListener;
    private volatile boolean messageStatistics;
    protected volatile AbandonedConfig abandonedConfig;
    private volatile int maxTotal = -1;
    private volatile boolean blockWhenExhausted = true;
    private volatile Duration maxWaitDuration = BaseObjectPoolConfig.DEFAULT_MAX_WAIT;
    private volatile boolean lifo = true;
    private volatile boolean testOnCreate = false;
    private volatile boolean testOnBorrow = false;
    private volatile boolean testOnReturn = false;
    private volatile boolean testWhileIdle = false;
    private volatile Duration durationBetweenEvictionRuns = BaseObjectPoolConfig.DEFAULT_TIME_BETWEEN_EVICTION_RUNS;
    private volatile int numTestsPerEvictionRun = 3;
    private volatile Duration minEvictableIdleDuration = BaseObjectPoolConfig.DEFAULT_MIN_EVICTABLE_IDLE_DURATION;
    private volatile Duration softMinEvictableIdleDuration = BaseObjectPoolConfig.DEFAULT_SOFT_MIN_EVICTABLE_IDLE_DURATION;
    private volatile Duration evictorShutdownTimeoutDuration = BaseObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT;
    final Object closeLock = new Object();
    final Object evictionLock = new Object();
    private final AtomicLong borrowedCount = new AtomicLong();
    private final AtomicLong returnedCount = new AtomicLong();
    final AtomicLong createdCount = new AtomicLong();
    final AtomicLong destroyedCount = new AtomicLong();
    final AtomicLong destroyedByEvictorCount = new AtomicLong();
    final AtomicLong destroyedByBorrowValidationCount = new AtomicLong();
    private final BaseGenericObjectPool<T>.StatsStore activeTimes = new StatsStore(100);
    private final BaseGenericObjectPool<T>.StatsStore idleTimes = new StatsStore(100);
    private final BaseGenericObjectPool<T>.StatsStore waitTimes = new StatsStore(100);
    private final AtomicReference<Duration> maxBorrowWaitDuration = new AtomicReference<>(Duration.ZERO);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/BaseGenericObjectPool$EvictionIterator.class */
    class EvictionIterator implements Iterator<PooledObject<T>> {
        private final Deque<PooledObject<T>> idleObjects;
        private final Iterator<PooledObject<T>> idleObjectIterator;

        EvictionIterator(Deque<PooledObject<T>> deque) {
            this.idleObjects = deque;
            if (BaseGenericObjectPool.this.getLifo()) {
                this.idleObjectIterator = deque.descendingIterator();
            } else {
                this.idleObjectIterator = deque.iterator();
            }
        }

        public Deque<PooledObject<T>> getIdleObjects() {
            return this.idleObjects;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.idleObjectIterator.hasNext();
        }

        @Override // java.util.Iterator
        public PooledObject<T> next() {
            return this.idleObjectIterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.idleObjectIterator.remove();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/BaseGenericObjectPool$Evictor.class */
    class Evictor implements Runnable {
        private ScheduledFuture<?> scheduledFuture;

        Evictor() {
        }

        void cancel() {
            this.scheduledFuture.cancel(false);
        }

        @Override // java.lang.Runnable
        public void run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            try {
                if (BaseGenericObjectPool.this.factoryClassLoader != null) {
                    ClassLoader classLoader = (ClassLoader) BaseGenericObjectPool.this.factoryClassLoader.get();
                    if (classLoader == null) {
                        cancel();
                        Thread.currentThread().setContextClassLoader(contextClassLoader);
                        return;
                    }
                    Thread.currentThread().setContextClassLoader(classLoader);
                }
                try {
                    BaseGenericObjectPool.this.evict();
                } catch (Exception e) {
                    BaseGenericObjectPool.this.swallowException(e);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace(System.err);
                }
                try {
                    BaseGenericObjectPool.this.ensureMinIdle();
                } catch (Exception e3) {
                    BaseGenericObjectPool.this.swallowException(e3);
                }
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            } catch (Throwable th) {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
                throw th;
            }
        }

        void setScheduledFuture(ScheduledFuture<?> scheduledFuture) {
            this.scheduledFuture = scheduledFuture;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/BaseGenericObjectPool$IdentityWrapper.class */
    static class IdentityWrapper<T> {
        private final T instance;

        public IdentityWrapper(T t) {
            this.instance = t;
        }

        public boolean equals(Object obj) {
            return (obj instanceof IdentityWrapper) && ((IdentityWrapper) obj).instance == this.instance;
        }

        public T getObject() {
            return this.instance;
        }

        public int hashCode() {
            return System.identityHashCode(this.instance);
        }

        public String toString() {
            return "IdentityWrapper [instance=" + this.instance + "]";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/BaseGenericObjectPool$StatsStore.class */
    private class StatsStore {
        private static final int NULL = -1;
        private final AtomicLong[] values;
        private final int size;
        private int index;

        StatsStore(int i) {
            this.size = i;
            this.values = new AtomicLong[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.values[i2] = new AtomicLong(-1L);
            }
        }

        void add(Duration duration) {
            add(duration.toMillis());
        }

        synchronized void add(long j) {
            this.values[this.index].set(j);
            this.index++;
            if (this.index == this.size) {
                this.index = 0;
            }
        }

        synchronized List<AtomicLong> getCurrentValues() {
            return (List) Arrays.stream(this.values, 0, this.index).collect(Collectors.toList());
        }

        public long getMean() {
            double d = 0.0d;
            int i = 0;
            for (int i2 = 0; i2 < this.size; i2++) {
                long j = this.values[i2].get();
                if (j != -1) {
                    i++;
                    d = (d * (((double) (i - 1)) / ((double) i))) + (j / ((double) i));
                }
            }
            return (long) d;
        }

        public String toString() {
            return "StatsStore [" + getCurrentValues() + "], size=" + this.size + ", index=" + this.index + "]";
        }
    }

    public BaseGenericObjectPool(BaseObjectPoolConfig<T> baseObjectPoolConfig, String str, String str2) {
        if (baseObjectPoolConfig.getJmxEnabled()) {
            this.objectName = jmxRegister(baseObjectPoolConfig, str, str2);
        } else {
            this.objectName = null;
        }
        this.creationStackTrace = getStackTrace(new Exception());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            this.factoryClassLoader = null;
        } else {
            this.factoryClassLoader = new WeakReference<>(contextClassLoader);
        }
        this.fairness = baseObjectPoolConfig.getFairness();
    }

    String appendStats(String str) {
        return this.messageStatistics ? str + ", " + getStatsString() : str;
    }

    final void assertOpen() {
        if (isClosed()) {
            throw new IllegalStateException("Pool not open");
        }
    }

    public abstract void close();

    ArrayList<PooledObject<T>> createRemoveList(AbandonedConfig abandonedConfig, Map<IdentityWrapper<T>, PooledObject<T>> map) {
        Instant instantMinus = Instant.now().minus((TemporalAmount) abandonedConfig.getRemoveAbandonedTimeoutDuration());
        ArrayList<PooledObject<T>> arrayList = new ArrayList<>();
        map.values().forEach(pooledObject -> {
            synchronized (pooledObject) {
                if (pooledObject.getState() == PooledObjectState.ALLOCATED && pooledObject.getLastUsedInstant().compareTo(instantMinus) <= 0) {
                    pooledObject.markAbandoned();
                    arrayList.add(pooledObject);
                }
            }
        });
        return arrayList;
    }

    abstract void ensureMinIdle();

    public abstract void evict();

    public final boolean getBlockWhenExhausted() {
        return this.blockWhenExhausted;
    }

    public final long getBorrowedCount() {
        return this.borrowedCount.get();
    }

    public final long getCreatedCount() {
        return this.createdCount.get();
    }

    public final String getCreationStackTrace() {
        return this.creationStackTrace;
    }

    public final long getDestroyedByBorrowValidationCount() {
        return this.destroyedByBorrowValidationCount.get();
    }

    public final long getDestroyedByEvictorCount() {
        return this.destroyedByEvictorCount.get();
    }

    public final long getDestroyedCount() {
        return this.destroyedCount.get();
    }

    public EvictionPolicy<T> getEvictionPolicy() {
        return this.evictionPolicy;
    }

    public final String getEvictionPolicyClassName() {
        return this.evictionPolicy.getClass().getName();
    }

    @Deprecated
    public final Duration getEvictorShutdownTimeout() {
        return this.evictorShutdownTimeoutDuration;
    }

    public final Duration getEvictorShutdownTimeoutDuration() {
        return this.evictorShutdownTimeoutDuration;
    }

    @Deprecated
    public final long getEvictorShutdownTimeoutMillis() {
        return this.evictorShutdownTimeoutDuration.toMillis();
    }

    public final boolean getFairness() {
        return this.fairness;
    }

    public final ObjectName getJmxName() {
        return this.objectName;
    }

    public final boolean getLifo() {
        return this.lifo;
    }

    public boolean getLogAbandoned() {
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        return abandonedConfig != null && abandonedConfig.getLogAbandoned();
    }

    public final long getMaxBorrowWaitTimeMillis() {
        return this.maxBorrowWaitDuration.get().toMillis();
    }

    public final int getMaxTotal() {
        return this.maxTotal;
    }

    public final Duration getMaxWaitDuration() {
        return this.maxWaitDuration;
    }

    @Deprecated
    public final long getMaxWaitMillis() {
        return this.maxWaitDuration.toMillis();
    }

    public final long getMeanActiveTimeMillis() {
        return this.activeTimes.getMean();
    }

    public final long getMeanBorrowWaitTimeMillis() {
        return this.waitTimes.getMean();
    }

    public final long getMeanIdleTimeMillis() {
        return this.idleTimes.getMean();
    }

    public boolean getMessageStatistics() {
        return this.messageStatistics;
    }

    public final Duration getMinEvictableIdleDuration() {
        return this.minEvictableIdleDuration;
    }

    @Deprecated
    public final Duration getMinEvictableIdleTime() {
        return this.minEvictableIdleDuration;
    }

    @Deprecated
    public final long getMinEvictableIdleTimeMillis() {
        return this.minEvictableIdleDuration.toMillis();
    }

    public abstract int getNumIdle();

    public final int getNumTestsPerEvictionRun() {
        return this.numTestsPerEvictionRun;
    }

    public boolean getRemoveAbandonedOnBorrow() {
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        return abandonedConfig != null && abandonedConfig.getRemoveAbandonedOnBorrow();
    }

    public boolean getRemoveAbandonedOnMaintenance() {
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        return abandonedConfig != null && abandonedConfig.getRemoveAbandonedOnMaintenance();
    }

    @Deprecated
    public int getRemoveAbandonedTimeout() {
        return (int) getRemoveAbandonedTimeoutDuration().getSeconds();
    }

    public Duration getRemoveAbandonedTimeoutDuration() {
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        return abandonedConfig != null ? abandonedConfig.getRemoveAbandonedTimeoutDuration() : DEFAULT_REMOVE_ABANDONED_TIMEOUT;
    }

    public final long getReturnedCount() {
        return this.returnedCount.get();
    }

    public final Duration getSoftMinEvictableIdleDuration() {
        return this.softMinEvictableIdleDuration;
    }

    @Deprecated
    public final Duration getSoftMinEvictableIdleTime() {
        return this.softMinEvictableIdleDuration;
    }

    @Deprecated
    public final long getSoftMinEvictableIdleTimeMillis() {
        return this.softMinEvictableIdleDuration.toMillis();
    }

    private String getStackTrace(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    String getStatsString() {
        return String.format("activeTimes=%s, blockWhenExhausted=%s, borrowedCount=%,d, closed=%s, createdCount=%,d, destroyedByBorrowValidationCount=%,d, destroyedByEvictorCount=%,d, evictorShutdownTimeoutDuration=%s, fairness=%s, idleTimes=%s, lifo=%s, maxBorrowWaitDuration=%s, maxTotal=%s, maxWaitDuration=%s, minEvictableIdleDuration=%s, numTestsPerEvictionRun=%s, returnedCount=%s, softMinEvictableIdleDuration=%s, testOnBorrow=%s, testOnCreate=%s, testOnReturn=%s, testWhileIdle=%s, durationBetweenEvictionRuns=%s, waitTimes=%s", this.activeTimes.getCurrentValues(), Boolean.valueOf(this.blockWhenExhausted), Long.valueOf(this.borrowedCount.get()), Boolean.valueOf(this.closed), Long.valueOf(this.createdCount.get()), Long.valueOf(this.destroyedByBorrowValidationCount.get()), Long.valueOf(this.destroyedByEvictorCount.get()), this.evictorShutdownTimeoutDuration, Boolean.valueOf(this.fairness), this.idleTimes.getCurrentValues(), Boolean.valueOf(this.lifo), this.maxBorrowWaitDuration.get(), Integer.valueOf(this.maxTotal), this.maxWaitDuration, this.minEvictableIdleDuration, Integer.valueOf(this.numTestsPerEvictionRun), this.returnedCount, this.softMinEvictableIdleDuration, Boolean.valueOf(this.testOnBorrow), Boolean.valueOf(this.testOnCreate), Boolean.valueOf(this.testOnReturn), Boolean.valueOf(this.testWhileIdle), this.durationBetweenEvictionRuns, this.waitTimes.getCurrentValues());
    }

    public final SwallowedExceptionListener getSwallowedExceptionListener() {
        return this.swallowedExceptionListener;
    }

    public final boolean getTestOnBorrow() {
        return this.testOnBorrow;
    }

    public final boolean getTestOnCreate() {
        return this.testOnCreate;
    }

    public final boolean getTestOnReturn() {
        return this.testOnReturn;
    }

    public final boolean getTestWhileIdle() {
        return this.testWhileIdle;
    }

    public final Duration getDurationBetweenEvictionRuns() {
        return this.durationBetweenEvictionRuns;
    }

    @Deprecated
    public final Duration getTimeBetweenEvictionRuns() {
        return this.durationBetweenEvictionRuns;
    }

    @Deprecated
    public final long getTimeBetweenEvictionRunsMillis() {
        return this.durationBetweenEvictionRuns.toMillis();
    }

    public boolean isAbandonedConfig() {
        return this.abandonedConfig != null;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    private ObjectName jmxRegister(BaseObjectPoolConfig<T> baseObjectPoolConfig, String str, String str2) {
        ObjectName objectName;
        ObjectName objectName2 = null;
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        int i = 1;
        boolean z = false;
        String jmxNameBase = baseObjectPoolConfig.getJmxNameBase();
        if (jmxNameBase == null) {
            jmxNameBase = str;
        }
        while (!z) {
            if (i == 1) {
                try {
                    objectName = new ObjectName(jmxNameBase + str2);
                } catch (InstanceAlreadyExistsException e) {
                    i++;
                } catch (MBeanRegistrationException | NotCompliantMBeanException e2) {
                    z = true;
                } catch (MalformedObjectNameException e3) {
                    if (BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX.equals(str2) && str.equals(jmxNameBase)) {
                        z = true;
                    } else {
                        str2 = BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX;
                        jmxNameBase = str;
                    }
                }
            } else {
                objectName = new ObjectName(jmxNameBase + str2 + i);
            }
            platformMBeanServer.registerMBean(this, objectName);
            objectName2 = objectName;
            z = true;
        }
        return objectName2;
    }

    final void jmxUnregister() {
        if (this.objectName != null) {
            try {
                ManagementFactory.getPlatformMBeanServer().unregisterMBean(this.objectName);
            } catch (MBeanRegistrationException | InstanceNotFoundException e) {
                swallowException(e);
            }
        }
    }

    protected void markReturningState(PooledObject<T> pooledObject) {
        synchronized (pooledObject) {
            if (pooledObject.getState() != PooledObjectState.ALLOCATED) {
                throw new IllegalStateException("Object has already been returned to this pool or is invalid");
            }
            pooledObject.markReturning();
        }
    }

    public void setAbandonedConfig(AbandonedConfig abandonedConfig) {
        this.abandonedConfig = AbandonedConfig.copy(abandonedConfig);
    }

    public final void setBlockWhenExhausted(boolean z) {
        this.blockWhenExhausted = z;
    }

    protected void setConfig(BaseObjectPoolConfig<T> baseObjectPoolConfig) {
        setLifo(baseObjectPoolConfig.getLifo());
        setMaxWait(baseObjectPoolConfig.getMaxWaitDuration());
        setBlockWhenExhausted(baseObjectPoolConfig.getBlockWhenExhausted());
        setTestOnCreate(baseObjectPoolConfig.getTestOnCreate());
        setTestOnBorrow(baseObjectPoolConfig.getTestOnBorrow());
        setTestOnReturn(baseObjectPoolConfig.getTestOnReturn());
        setTestWhileIdle(baseObjectPoolConfig.getTestWhileIdle());
        setNumTestsPerEvictionRun(baseObjectPoolConfig.getNumTestsPerEvictionRun());
        setMinEvictableIdle(baseObjectPoolConfig.getMinEvictableIdleDuration());
        setTimeBetweenEvictionRuns(baseObjectPoolConfig.getDurationBetweenEvictionRuns());
        setSoftMinEvictableIdle(baseObjectPoolConfig.getSoftMinEvictableIdleDuration());
        EvictionPolicy<T> evictionPolicy = baseObjectPoolConfig.getEvictionPolicy();
        if (evictionPolicy == null) {
            setEvictionPolicyClassName(baseObjectPoolConfig.getEvictionPolicyClassName());
        } else {
            setEvictionPolicy(evictionPolicy);
        }
        setEvictorShutdownTimeout(baseObjectPoolConfig.getEvictorShutdownTimeoutDuration());
    }

    public void setEvictionPolicy(EvictionPolicy<T> evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    private void setEvictionPolicy(String str, ClassLoader classLoader) {
        this.evictionPolicy = (EvictionPolicy) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    public final void setEvictionPolicyClassName(String str) {
        setEvictionPolicyClassName(str, Thread.currentThread().getContextClassLoader());
    }

    public final void setEvictionPolicyClassName(String str, ClassLoader classLoader) {
        ClassLoader classLoader2 = EvictionPolicy.class.getClassLoader();
        try {
            try {
                setEvictionPolicy(str, classLoader);
            } catch (ClassCastException | ClassNotFoundException e) {
                setEvictionPolicy(str, classLoader2);
            }
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException("Class " + str + " from class loaders [" + classLoader + ", " + classLoader2 + "] do not implement " + EVICTION_POLICY_TYPE_NAME);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e3) {
            throw new IllegalArgumentException("Unable to create " + EVICTION_POLICY_TYPE_NAME + " instance of type " + str, e3);
        }
    }

    public final void setEvictorShutdownTimeout(Duration duration) {
        this.evictorShutdownTimeoutDuration = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT);
    }

    @Deprecated
    public final void setEvictorShutdownTimeoutMillis(long j) {
        setEvictorShutdownTimeout(Duration.ofMillis(j));
    }

    public final void setLifo(boolean z) {
        this.lifo = z;
    }

    public final void setMaxTotal(int i) {
        this.maxTotal = i;
    }

    public final void setMaxWait(Duration duration) {
        this.maxWaitDuration = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_MAX_WAIT);
    }

    @Deprecated
    public final void setMaxWaitMillis(long j) {
        setMaxWait(Duration.ofMillis(j));
    }

    public void setMessagesStatistics(boolean z) {
        this.messageStatistics = z;
    }

    public final void setMinEvictableIdle(Duration duration) {
        this.minEvictableIdleDuration = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_MIN_EVICTABLE_IDLE_DURATION);
    }

    @Deprecated
    public final void setMinEvictableIdleTime(Duration duration) {
        this.minEvictableIdleDuration = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_MIN_EVICTABLE_IDLE_DURATION);
    }

    @Deprecated
    public final void setMinEvictableIdleTimeMillis(long j) {
        setMinEvictableIdleTime(Duration.ofMillis(j));
    }

    public final void setNumTestsPerEvictionRun(int i) {
        this.numTestsPerEvictionRun = i;
    }

    public final void setSoftMinEvictableIdle(Duration duration) {
        this.softMinEvictableIdleDuration = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_SOFT_MIN_EVICTABLE_IDLE_DURATION);
    }

    @Deprecated
    public final void setSoftMinEvictableIdleTime(Duration duration) {
        this.softMinEvictableIdleDuration = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_SOFT_MIN_EVICTABLE_IDLE_DURATION);
    }

    @Deprecated
    public final void setSoftMinEvictableIdleTimeMillis(long j) {
        setSoftMinEvictableIdleTime(Duration.ofMillis(j));
    }

    public final void setSwallowedExceptionListener(SwallowedExceptionListener swallowedExceptionListener) {
        this.swallowedExceptionListener = swallowedExceptionListener;
    }

    public final void setTestOnBorrow(boolean z) {
        this.testOnBorrow = z;
    }

    public final void setTestOnCreate(boolean z) {
        this.testOnCreate = z;
    }

    public final void setTestOnReturn(boolean z) {
        this.testOnReturn = z;
    }

    public final void setTestWhileIdle(boolean z) {
        this.testWhileIdle = z;
    }

    public final void setTimeBetweenEvictionRuns(Duration duration) {
        this.durationBetweenEvictionRuns = PoolImplUtils.nonNull(duration, BaseObjectPoolConfig.DEFAULT_TIME_BETWEEN_EVICTION_RUNS);
        startEvictor(this.durationBetweenEvictionRuns);
    }

    @Deprecated
    public final void setTimeBetweenEvictionRunsMillis(long j) {
        setTimeBetweenEvictionRuns(Duration.ofMillis(j));
    }

    final void startEvictor(Duration duration) {
        synchronized (this.evictionLock) {
            boolean zIsPositive = PoolImplUtils.isPositive(duration);
            if (this.evictor == null) {
                if (zIsPositive) {
                    this.evictor = new Evictor();
                    EvictionTimer.schedule(this.evictor, duration, duration);
                }
            } else if (zIsPositive) {
                synchronized (EvictionTimer.class) {
                    EvictionTimer.cancel(this.evictor, this.evictorShutdownTimeoutDuration, true);
                    this.evictor = null;
                    this.evictionIterator = null;
                    this.evictor = new Evictor();
                    EvictionTimer.schedule(this.evictor, duration, duration);
                }
            } else {
                EvictionTimer.cancel(this.evictor, this.evictorShutdownTimeoutDuration, false);
            }
        }
    }

    void stopEvictor() {
        startEvictor(Duration.ofMillis(-1L));
    }

    final void swallowException(Exception exc) {
        SwallowedExceptionListener swallowedExceptionListener = getSwallowedExceptionListener();
        if (swallowedExceptionListener == null) {
            return;
        }
        try {
            swallowedExceptionListener.onSwallowException(exc);
        } catch (VirtualMachineError e) {
            throw e;
        } catch (Throwable th) {
        }
    }

    @Override // org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        sb.append("maxTotal=");
        sb.append(this.maxTotal);
        sb.append(", blockWhenExhausted=");
        sb.append(this.blockWhenExhausted);
        sb.append(", maxWaitDuration=");
        sb.append(this.maxWaitDuration);
        sb.append(", lifo=");
        sb.append(this.lifo);
        sb.append(", fairness=");
        sb.append(this.fairness);
        sb.append(", testOnCreate=");
        sb.append(this.testOnCreate);
        sb.append(", testOnBorrow=");
        sb.append(this.testOnBorrow);
        sb.append(", testOnReturn=");
        sb.append(this.testOnReturn);
        sb.append(", testWhileIdle=");
        sb.append(this.testWhileIdle);
        sb.append(", durationBetweenEvictionRuns=");
        sb.append(this.durationBetweenEvictionRuns);
        sb.append(", numTestsPerEvictionRun=");
        sb.append(this.numTestsPerEvictionRun);
        sb.append(", minEvictableIdleTimeDuration=");
        sb.append(this.minEvictableIdleDuration);
        sb.append(", softMinEvictableIdleTimeDuration=");
        sb.append(this.softMinEvictableIdleDuration);
        sb.append(", evictionPolicy=");
        sb.append(this.evictionPolicy);
        sb.append(", closeLock=");
        sb.append(this.closeLock);
        sb.append(", closed=");
        sb.append(this.closed);
        sb.append(", evictionLock=");
        sb.append(this.evictionLock);
        sb.append(", evictor=");
        sb.append(this.evictor);
        sb.append(", evictionIterator=");
        sb.append(this.evictionIterator);
        sb.append(", factoryClassLoader=");
        sb.append(this.factoryClassLoader);
        sb.append(", oname=");
        sb.append(this.objectName);
        sb.append(", creationStackTrace=");
        sb.append(this.creationStackTrace);
        sb.append(", borrowedCount=");
        sb.append(this.borrowedCount);
        sb.append(", returnedCount=");
        sb.append(this.returnedCount);
        sb.append(", createdCount=");
        sb.append(this.createdCount);
        sb.append(", destroyedCount=");
        sb.append(this.destroyedCount);
        sb.append(", destroyedByEvictorCount=");
        sb.append(this.destroyedByEvictorCount);
        sb.append(", destroyedByBorrowValidationCount=");
        sb.append(this.destroyedByBorrowValidationCount);
        sb.append(", activeTimes=");
        sb.append(this.activeTimes);
        sb.append(", idleTimes=");
        sb.append(this.idleTimes);
        sb.append(", waitTimes=");
        sb.append(this.waitTimes);
        sb.append(", maxBorrowWaitDuration=");
        sb.append(this.maxBorrowWaitDuration);
        sb.append(", swallowedExceptionListener=");
        sb.append(this.swallowedExceptionListener);
    }

    final void updateStatsBorrow(PooledObject<T> pooledObject, Duration duration) {
        Duration duration2;
        this.borrowedCount.incrementAndGet();
        this.idleTimes.add(pooledObject.getIdleDuration());
        this.waitTimes.add(duration);
        do {
            duration2 = this.maxBorrowWaitDuration.get();
            if (duration2.compareTo(duration) >= 0) {
                return;
            }
        } while (!this.maxBorrowWaitDuration.compareAndSet(duration2, duration));
    }

    final void updateStatsReturn(Duration duration) {
        this.returnedCount.incrementAndGet();
        this.activeTimes.add(duration);
    }
}

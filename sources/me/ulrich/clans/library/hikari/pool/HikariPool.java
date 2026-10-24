package me.ulrich.clans.library.hikari.pool;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.SQLTransientException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.sql.DataSource;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.HikariPoolMXBean;
import me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory;
import me.ulrich.clans.library.hikari.metrics.PoolStats;
import me.ulrich.clans.library.hikari.util.ClockSource;
import me.ulrich.clans.library.hikari.util.ConcurrentBag;
import me.ulrich.clans.library.hikari.util.SuspendResumeLock;
import me.ulrich.clans.library.hikari.util.UtilityElf;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariPool.class */
public final class HikariPool extends PoolBase implements HikariPoolMXBean, ConcurrentBag.IBagStateListener {
    private final Logger logger;
    public static final int POOL_NORMAL = 0;
    public static final int POOL_SUSPENDED = 1;
    public static final int POOL_SHUTDOWN = 2;
    public volatile int poolState;
    private final long aliveBypassWindowMs;
    private final long housekeepingPeriodMs;
    private final long lifeTimeVarianceFactor;
    private final boolean isRequestBoundariesEnabled;
    private static final String EVICTED_CONNECTION_MESSAGE = "(connection was evicted)";
    private static final String DEAD_CONNECTION_MESSAGE = "(connection is dead)";
    private final PoolEntryCreator poolEntryCreator;
    private final PoolEntryCreator postFillPoolEntryCreator;
    private final ThreadPoolExecutor addConnectionExecutor;
    private final ThreadPoolExecutor closeConnectionExecutor;
    private final ConcurrentBag<PoolEntry> connectionBag;
    private final ProxyLeakTaskFactory leakTaskFactory;
    private final SuspendResumeLock suspendResumeLock;
    private final ScheduledExecutorService houseKeepingExecutorService;
    private ScheduledFuture<?> houseKeeperTask;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariPool$HouseKeeper.class */
    private final class HouseKeeper implements Runnable {
        private volatile long previous;
        private final AtomicReferenceFieldUpdater<PoolBase, String> catalogUpdater = AtomicReferenceFieldUpdater.newUpdater(PoolBase.class, String.class, "catalog");

        private HouseKeeper() {
            this.previous = ClockSource.plusMillis(ClockSource.currentTime(), -HikariPool.this.housekeepingPeriodMs);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HikariPool.this.connectionTimeout = HikariPool.this.config.getConnectionTimeout();
                HikariPool.this.validationTimeout = HikariPool.this.config.getValidationTimeout();
                HikariPool.this.leakTaskFactory.updateLeakDetectionThreshold(HikariPool.this.config.getLeakDetectionThreshold());
                if (HikariPool.this.config.getCatalog() != null && !HikariPool.this.config.getCatalog().equals(HikariPool.this.catalog)) {
                    this.catalogUpdater.set(HikariPool.this, HikariPool.this.config.getCatalog());
                }
                long idleTimeout = HikariPool.this.config.getIdleTimeout();
                long jCurrentTime = ClockSource.currentTime();
                if (ClockSource.plusMillis(jCurrentTime, 128L) < ClockSource.plusMillis(this.previous, HikariPool.this.housekeepingPeriodMs)) {
                    HikariPool.this.logger.warn("{} - Retrograde clock change detected (housekeeper delta={}), soft-evicting connections from pool.", HikariPool.this.poolName, ClockSource.elapsedDisplayString(this.previous, jCurrentTime));
                    this.previous = jCurrentTime;
                    HikariPool.this.softEvictConnections();
                    return;
                }
                if (jCurrentTime > ClockSource.plusMillis(this.previous, (3 * HikariPool.this.housekeepingPeriodMs) / 2)) {
                    HikariPool.this.logger.warn("{} - Thread starvation or clock leap detected (housekeeper delta={}).", HikariPool.this.poolName, ClockSource.elapsedDisplayString(this.previous, jCurrentTime));
                }
                this.previous = jCurrentTime;
                if (idleTimeout <= 0 || HikariPool.this.config.getMinimumIdle() >= HikariPool.this.config.getMaximumPoolSize()) {
                    HikariPool.this.logPoolState("Pool ");
                } else {
                    HikariPool.this.logPoolState("Before cleanup ");
                    List<T> listValues = HikariPool.this.connectionBag.values(0);
                    int size = listValues.size() - HikariPool.this.config.getMinimumIdle();
                    for (T t : listValues) {
                        if (size > 0 && ClockSource.elapsedMillis(t.lastAccessed, jCurrentTime) > idleTimeout && HikariPool.this.connectionBag.reserve(t)) {
                            HikariPool.this.closeConnection(t, "(connection has passed idleTimeout)");
                            size--;
                        }
                    }
                    HikariPool.this.logPoolState("After  cleanup ");
                }
                HikariPool.this.fillPool(true);
            } catch (Exception e) {
                HikariPool.this.logger.error("Unexpected exception in housekeeping task", (Throwable) e);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariPool$KeepaliveTask.class */
    private final class KeepaliveTask implements Runnable {
        private final PoolEntry poolEntry;

        KeepaliveTask(PoolEntry poolEntry) {
            this.poolEntry = poolEntry;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HikariPool.this.connectionBag.reserve(this.poolEntry)) {
                if (HikariPool.this.isConnectionDead(this.poolEntry.connection)) {
                    HikariPool.this.softEvictConnection(this.poolEntry, HikariPool.DEAD_CONNECTION_MESSAGE, true);
                    HikariPool.this.addBagItem(HikariPool.this.connectionBag.getWaitingThreadCount());
                } else {
                    HikariPool.this.connectionBag.unreserve(this.poolEntry);
                    HikariPool.this.logger.debug("{} - keepalive: connection {} is alive", HikariPool.this.poolName, this.poolEntry.connection);
                }
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariPool$MaxLifetimeTask.class */
    private final class MaxLifetimeTask implements Runnable {
        private final PoolEntry poolEntry;

        MaxLifetimeTask(PoolEntry poolEntry) {
            this.poolEntry = poolEntry;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HikariPool.this.softEvictConnection(this.poolEntry, "(connection has passed maxLifetime)", false)) {
                HikariPool.this.addBagItem(HikariPool.this.connectionBag.getWaitingThreadCount());
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariPool$PoolEntryCreator.class */
    private final class PoolEntryCreator implements Callable<Boolean> {
        private final String loggingPrefix;

        PoolEntryCreator(HikariPool hikariPool) {
            this(null);
        }

        PoolEntryCreator(String str) {
            this.loggingPrefix = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:19:0x00af A[DONT_GENERATE] */
        /* JADX WARN: Code duplicated, block: B:21:0x00b3  */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            boolean z;
            boolean z2;
            String str;
            long jMin = 10;
            boolean z3 = false;
            while (shouldContinueCreating()) {
                try {
                    PoolEntry poolEntryCreatePoolEntry = HikariPool.this.createPoolEntry();
                    if (poolEntryCreatePoolEntry != null) {
                        z3 = true;
                        HikariPool.this.connectionBag.add(poolEntryCreatePoolEntry);
                        HikariPool.this.logger.debug("{} - Added connection {}", HikariPool.this.poolName, poolEntryCreatePoolEntry.connection);
                        UtilityElf.quietlySleep(30L);
                        break;
                    }
                    if (this.loggingPrefix != null && jMin % 50 == 0) {
                        HikariPool.this.logger.debug("{} - Connection add failed, sleeping with backoff: {}ms", HikariPool.this.poolName, Long.valueOf(jMin));
                    }
                    UtilityElf.quietlySleep(jMin);
                    jMin = Math.min(TimeUnit.SECONDS.toMillis(5L), jMin * 2);
                } finally {
                    if (z3 && this.loggingPrefix != null) {
                        HikariPool.this.logPoolState(this.loggingPrefix);
                    } else if (!z3) {
                        HikariPool.this.logPoolState("Connection not added, ");
                    }
                }
            }
            if (z) {
                if (str != null) {
                    HikariPool.this.logPoolState(this.loggingPrefix);
                } else if (!z2) {
                    HikariPool.this.logPoolState("Connection not added, ");
                }
            } else if (!z2) {
                HikariPool.this.logPoolState("Connection not added, ");
            }
            return Boolean.FALSE;
        }

        private synchronized boolean shouldContinueCreating() {
            return HikariPool.this.poolState == 0 && !Thread.interrupted() && HikariPool.this.getTotalConnections() < HikariPool.this.config.getMaximumPoolSize() && (HikariPool.this.getIdleConnections() < HikariPool.this.config.getMinimumIdle() || HikariPool.this.connectionBag.getWaitingThreadCount() > HikariPool.this.getIdleConnections());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariPool$PoolInitializationException.class */
    public static class PoolInitializationException extends RuntimeException {
        private static final long serialVersionUID = 929872118275916520L;

        public PoolInitializationException(Throwable th) {
            super("Failed to initialize pool: " + th.getMessage(), th);
        }
    }

    public HikariPool(HikariConfig hikariConfig) {
        super(hikariConfig);
        this.logger = LoggerFactory.getLogger((Class<?>) HikariPool.class);
        this.aliveBypassWindowMs = Long.getLong("me.ulrich.clans.library.hikari.aliveBypassWindowMs", TimeUnit.MILLISECONDS.toMillis(500L)).longValue();
        this.housekeepingPeriodMs = Long.getLong("me.ulrich.clans.library.hikari.housekeeping.periodMs", TimeUnit.SECONDS.toMillis(30L)).longValue();
        this.lifeTimeVarianceFactor = Math.min(40L, Math.max(2L, Long.getLong("me.ulrich.clans.library.hikari.lifeTimeVarianceFactor", 4L).longValue()));
        this.isRequestBoundariesEnabled = Boolean.getBoolean("me.ulrich.clans.library.hikari.enableRequestBoundaries");
        this.poolEntryCreator = new PoolEntryCreator(this);
        this.postFillPoolEntryCreator = new PoolEntryCreator("After adding ");
        this.connectionBag = new ConcurrentBag<>(this);
        this.suspendResumeLock = hikariConfig.isAllowPoolSuspension() ? new SuspendResumeLock() : SuspendResumeLock.FAUX_LOCK;
        this.houseKeepingExecutorService = initializeHouseKeepingExecutorService();
        checkFailFast();
        if (hikariConfig.getMetricsTrackerFactory() != null) {
            setMetricsTrackerFactory(hikariConfig.getMetricsTrackerFactory());
        } else {
            setMetricRegistry(hikariConfig.getMetricRegistry());
        }
        setHealthCheckRegistry(hikariConfig.getHealthCheckRegistry());
        handleMBeans(this, true);
        ThreadFactory threadFactory = hikariConfig.getThreadFactory();
        int maximumPoolSize = hikariConfig.getMaximumPoolSize();
        this.addConnectionExecutor = UtilityElf.createThreadPoolExecutor(maximumPoolSize, this.poolName + ":connection-adder", threadFactory, new UtilityElf.CustomDiscardPolicy());
        this.closeConnectionExecutor = UtilityElf.createThreadPoolExecutor(maximumPoolSize, this.poolName + ":connection-closer", threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        this.leakTaskFactory = new ProxyLeakTaskFactory(hikariConfig.getLeakDetectionThreshold(), this.houseKeepingExecutorService);
        this.houseKeeperTask = this.houseKeepingExecutorService.scheduleWithFixedDelay(new HouseKeeper(), 100L, this.housekeepingPeriodMs, TimeUnit.MILLISECONDS);
        if (!Boolean.getBoolean("me.ulrich.clans.library.hikari.blockUntilFilled") || hikariConfig.getInitializationFailTimeout() <= 1) {
            return;
        }
        this.addConnectionExecutor.setMaximumPoolSize(Math.min(16, Runtime.getRuntime().availableProcessors()));
        this.addConnectionExecutor.setCorePoolSize(Math.min(16, Runtime.getRuntime().availableProcessors()));
        long jCurrentTime = ClockSource.currentTime();
        while (ClockSource.elapsedMillis(jCurrentTime) < hikariConfig.getInitializationFailTimeout() && getTotalConnections() < hikariConfig.getMinimumIdle()) {
            UtilityElf.quietlySleep(TimeUnit.MILLISECONDS.toMillis(100L));
        }
        this.addConnectionExecutor.setCorePoolSize(1);
        this.addConnectionExecutor.setMaximumPoolSize(1);
    }

    public Connection getConnection() {
        return getConnection(this.connectionTimeout);
    }

    public Connection getConnection(long j) throws SQLTransientException {
        this.suspendResumeLock.acquire();
        long jCurrentTime = ClockSource.currentTime();
        try {
            long jElapsedMillis = j;
            do {
                try {
                    PoolEntry poolEntry = (PoolEntry) this.connectionBag.borrow(jElapsedMillis, TimeUnit.MILLISECONDS);
                    if (poolEntry == null) {
                        break;
                    }
                    long jCurrentTime2 = ClockSource.currentTime();
                    if (!poolEntry.isMarkedEvicted() && (ClockSource.elapsedMillis(poolEntry.lastAccessed, jCurrentTime2) <= this.aliveBypassWindowMs || !isConnectionDead(poolEntry.connection))) {
                        this.metricsTracker.recordBorrowStats(poolEntry, jCurrentTime);
                        if (this.isRequestBoundariesEnabled) {
                            try {
                                poolEntry.connection.beginRequest();
                            } catch (SQLException e) {
                                this.logger.warn("beginRequest Failed for: {}, ({})", poolEntry.connection, e.getMessage());
                            }
                        }
                        Connection connectionCreateProxyConnection = poolEntry.createProxyConnection(this.leakTaskFactory.schedule(poolEntry));
                        this.suspendResumeLock.release();
                        return connectionCreateProxyConnection;
                    }
                    closeConnection(poolEntry, poolEntry.isMarkedEvicted() ? EVICTED_CONNECTION_MESSAGE : DEAD_CONNECTION_MESSAGE);
                    jElapsedMillis = j - ClockSource.elapsedMillis(jCurrentTime);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw new SQLException(this.poolName + " - Interrupted during connection acquisition", e2);
                }
            } while (jElapsedMillis > 0);
            this.metricsTracker.recordBorrowTimeoutStats(jCurrentTime);
            throw createTimeoutException(jCurrentTime);
        } catch (Throwable th) {
            this.suspendResumeLock.release();
            throw th;
        }
    }

    public synchronized void shutdown() {
        try {
            this.poolState = 2;
            if (this.addConnectionExecutor == null) {
                logPoolState("After  shutdown ");
                handleMBeans(this, false);
                this.metricsTracker.close();
                return;
            }
            logPoolState("Before shutdown ");
            if (this.houseKeeperTask != null) {
                this.houseKeeperTask.cancel(false);
                this.houseKeeperTask = null;
            }
            softEvictConnections();
            this.addConnectionExecutor.shutdown();
            if (!this.addConnectionExecutor.awaitTermination(getLoginTimeout(), TimeUnit.SECONDS)) {
                this.logger.warn("Timed-out waiting for add connection executor to shutdown");
            }
            destroyHouseKeepingExecutorService();
            this.connectionBag.close();
            ThreadPoolExecutor threadPoolExecutorCreateThreadPoolExecutor = UtilityElf.createThreadPoolExecutor(this.config.getMaximumPoolSize(), this.poolName + ":connection-assassinator", this.config.getThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
            try {
                long jCurrentTime = ClockSource.currentTime();
                do {
                    abortActiveConnections(threadPoolExecutorCreateThreadPoolExecutor);
                    softEvictConnections();
                    if (getTotalConnections() <= 0) {
                        break;
                    }
                } while (ClockSource.elapsedMillis(jCurrentTime) < TimeUnit.SECONDS.toMillis(10L));
                threadPoolExecutorCreateThreadPoolExecutor.shutdown();
                if (!threadPoolExecutorCreateThreadPoolExecutor.awaitTermination(10L, TimeUnit.SECONDS)) {
                    this.logger.warn("Timed-out waiting for connection assassin to shutdown");
                }
                shutdownNetworkTimeoutExecutor();
                this.closeConnectionExecutor.shutdown();
                if (!this.closeConnectionExecutor.awaitTermination(10L, TimeUnit.SECONDS)) {
                    this.logger.warn("Timed-out waiting for close connection executor to shutdown");
                }
                logPoolState("After  shutdown ");
                handleMBeans(this, false);
                this.metricsTracker.close();
            } catch (Throwable th) {
                threadPoolExecutorCreateThreadPoolExecutor.shutdown();
                if (!threadPoolExecutorCreateThreadPoolExecutor.awaitTermination(10L, TimeUnit.SECONDS)) {
                    this.logger.warn("Timed-out waiting for connection assassin to shutdown");
                }
                throw th;
            }
        } catch (Throwable th2) {
            logPoolState("After  shutdown ");
            handleMBeans(this, false);
            this.metricsTracker.close();
            throw th2;
        }
    }

    public void evictConnection(Connection connection) {
        ProxyConnection proxyConnection = (ProxyConnection) connection;
        proxyConnection.cancelLeakTask();
        try {
            softEvictConnection(proxyConnection.getPoolEntry(), "(connection evicted by user)", !connection.isClosed());
        } catch (SQLException e) {
        }
    }

    public void setMetricRegistry(Object obj) {
        if (obj != null && UtilityElf.safeIsAssignableFrom(obj, "com.codahale.metrics.MetricRegistry")) {
            setMetricsTrackerFactory((MetricsTrackerFactory) UtilityElf.createInstance("me.ulrich.clans.library.hikari.metrics.dropwizard.CodahaleMetricsTrackerFactory", MetricsTrackerFactory.class, obj));
            return;
        }
        if (obj != null && UtilityElf.safeIsAssignableFrom(obj, "io.dropwizard.metrics5.MetricRegistry")) {
            setMetricsTrackerFactory((MetricsTrackerFactory) UtilityElf.createInstance("me.ulrich.clans.library.hikari.metrics.dropwizard.Dropwizard5MetricsTrackerFactory", MetricsTrackerFactory.class, obj));
        } else if (obj == null || !UtilityElf.safeIsAssignableFrom(obj, "io.micrometer.core.instrument.MeterRegistry")) {
            setMetricsTrackerFactory(null);
        } else {
            setMetricsTrackerFactory((MetricsTrackerFactory) UtilityElf.createInstance("me.ulrich.clans.library.hikari.metrics.micrometer.MicrometerMetricsTrackerFactory", MetricsTrackerFactory.class, obj));
        }
    }

    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        if (metricsTrackerFactory != null) {
            this.metricsTracker = new PoolBase.MetricsTrackerDelegate(metricsTrackerFactory.create(this.config.getPoolName(), getPoolStats()));
        } else {
            this.metricsTracker = new PoolBase.NopMetricsTrackerDelegate();
        }
    }

    public void setHealthCheckRegistry(Object obj) {
        if (obj != null) {
            try {
                HikariPool.class.getClassLoader().loadClass("me.ulrich.clans.library.hikari.metrics.dropwizard.CodahaleHealthChecker").getMethod("registerHealthChecks", HikariPool.class, HikariConfig.class, HikariPool.class.getClassLoader().loadClass("com.codahale.metrics.health.HealthCheckRegistry")).invoke(null, this, this.config, obj);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // me.ulrich.clans.library.hikari.util.ConcurrentBag.IBagStateListener
    public void addBagItem(int i) {
        if (i > this.addConnectionExecutor.getQueue().size()) {
            this.addConnectionExecutor.submit(this.poolEntryCreator);
        }
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public int getActiveConnections() {
        return this.connectionBag.getCount(1);
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public int getIdleConnections() {
        return this.connectionBag.getCount(0);
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public int getTotalConnections() {
        return this.connectionBag.size();
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public int getThreadsAwaitingConnection() {
        return this.connectionBag.getWaitingThreadCount();
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public void softEvictConnections() {
        this.connectionBag.values().forEach(poolEntry -> {
            softEvictConnection(poolEntry, "(connection evicted)", false);
        });
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public synchronized void suspendPool() {
        if (this.suspendResumeLock == SuspendResumeLock.FAUX_LOCK) {
            throw new IllegalStateException(this.poolName + " - is not suspendable");
        }
        if (this.poolState != 1) {
            this.suspendResumeLock.suspend();
            this.poolState = 1;
        }
    }

    @Override // me.ulrich.clans.library.hikari.HikariPoolMXBean
    public synchronized void resumePool() {
        if (this.poolState == 1) {
            this.poolState = 0;
            fillPool(false);
            this.suspendResumeLock.resume();
        }
    }

    void logPoolState(String... strArr) {
        if (this.logger.isDebugEnabled()) {
            Logger logger = this.logger;
            Object[] objArr = new Object[8];
            objArr[0] = this.poolName;
            objArr[1] = strArr.length > 0 ? strArr[0] : "";
            objArr[2] = Integer.valueOf(getTotalConnections());
            objArr[3] = Integer.valueOf(this.config.getMaximumPoolSize());
            objArr[4] = Integer.valueOf(getIdleConnections());
            objArr[5] = Integer.valueOf(this.config.getMinimumIdle());
            objArr[6] = Integer.valueOf(getActiveConnections());
            objArr[7] = Integer.valueOf(getThreadsAwaitingConnection());
            logger.debug("{} - {}stats (total={}/{}, idle={}/{}, active={}, waiting={})", objArr);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.PoolBase
    void recycle(PoolEntry poolEntry) {
        this.metricsTracker.recordConnectionUsage(poolEntry);
        if (poolEntry.isMarkedEvicted()) {
            closeConnection(poolEntry, EVICTED_CONNECTION_MESSAGE);
            return;
        }
        if (this.isRequestBoundariesEnabled) {
            try {
                poolEntry.connection.endRequest();
            } catch (SQLException e) {
                this.logger.warn("endRequest Failed for: {},({})", poolEntry.connection, e.getMessage());
            }
        }
        this.connectionBag.requite(poolEntry);
    }

    void closeConnection(PoolEntry poolEntry, String str) {
        if (this.connectionBag.remove(poolEntry)) {
            Connection connectionClose = poolEntry.close();
            this.closeConnectionExecutor.execute(() -> {
                quietlyCloseConnection(connectionClose, str);
                if (this.poolState == 0) {
                    fillPool(false);
                }
            });
        }
    }

    int[] getPoolStateCounts() {
        return this.connectionBag.getStateCounts();
    }

    private PoolEntry createPoolEntry() {
        try {
            PoolEntry poolEntryNewPoolEntry = newPoolEntry(getTotalConnections() == 0);
            long maxLifetime = this.config.getMaxLifetime();
            if (maxLifetime > 0) {
                poolEntryNewPoolEntry.setFutureEol(this.houseKeepingExecutorService.schedule(new MaxLifetimeTask(poolEntryNewPoolEntry), maxLifetime - (maxLifetime > BaseObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS ? ThreadLocalRandom.current().nextLong(maxLifetime / this.lifeTimeVarianceFactor) : 0L), TimeUnit.MILLISECONDS));
            }
            long keepaliveTime = this.config.getKeepaliveTime();
            if (keepaliveTime > 0) {
                long jNextLong = keepaliveTime - ThreadLocalRandom.current().nextLong(keepaliveTime / 5);
                poolEntryNewPoolEntry.setKeepalive(this.houseKeepingExecutorService.scheduleWithFixedDelay(new KeepaliveTask(poolEntryNewPoolEntry), jNextLong, jNextLong, TimeUnit.MILLISECONDS));
            }
            return poolEntryNewPoolEntry;
        } catch (PoolBase.ConnectionSetupException e) {
            if (this.poolState != 0) {
                return null;
            }
            this.logger.debug("{} - Error thrown while acquiring connection from data source", this.poolName, e.getCause());
            return null;
        } catch (Throwable th) {
            if (this.poolState != 0) {
                return null;
            }
            this.logger.debug("{} - Cannot acquire connection from data source", this.poolName, th);
            return null;
        }
    }

    private synchronized void fillPool(boolean z) {
        int idleConnections = getIdleConnections();
        if (!(getTotalConnections() < this.config.getMaximumPoolSize() && idleConnections < this.config.getMinimumIdle())) {
            if (z) {
                this.logger.debug("{} - Fill pool skipped, pool has sufficient level or currently being filled.", this.poolName);
            }
        } else {
            int minimumIdle = this.config.getMinimumIdle() - idleConnections;
            for (int i = 0; i < minimumIdle; i++) {
                this.addConnectionExecutor.submit(z ? this.postFillPoolEntryCreator : this.poolEntryCreator);
            }
        }
    }

    private void abortActiveConnections(ExecutorService executorService) {
        for (T t : this.connectionBag.values(1)) {
            Connection connectionClose = t.close();
            try {
                try {
                    connectionClose.abort(executorService);
                    this.connectionBag.remove(t);
                } catch (Throwable th) {
                    quietlyCloseConnection(connectionClose, "(connection aborted during shutdown)");
                    this.connectionBag.remove(t);
                }
            } catch (Throwable th2) {
                this.connectionBag.remove(t);
                throw th2;
            }
        }
    }

    private void checkFailFast() {
        long initializationFailTimeout = this.config.getInitializationFailTimeout();
        if (initializationFailTimeout < 0) {
            return;
        }
        long jCurrentTime = ClockSource.currentTime();
        do {
            PoolEntry poolEntryCreatePoolEntry = createPoolEntry();
            if (poolEntryCreatePoolEntry != null) {
                if (this.config.getMinimumIdle() <= 0) {
                    quietlyCloseConnection(poolEntryCreatePoolEntry.close(), "(initialization check complete and minimumIdle is zero)");
                    return;
                } else {
                    this.connectionBag.add(poolEntryCreatePoolEntry);
                    this.logger.info("{} - Added connection {}", this.poolName, poolEntryCreatePoolEntry.connection);
                    return;
                }
            }
            if (getLastConnectionFailure() instanceof PoolBase.ConnectionSetupException) {
                throwPoolInitializationException(getLastConnectionFailure().getCause());
            }
            UtilityElf.quietlySleep(TimeUnit.SECONDS.toMillis(1L));
        } while (ClockSource.elapsedMillis(jCurrentTime) < initializationFailTimeout);
        if (initializationFailTimeout > 0) {
            throwPoolInitializationException(getLastConnectionFailure());
        }
    }

    private void throwPoolInitializationException(Throwable th) {
        destroyHouseKeepingExecutorService();
        throw new PoolInitializationException(th);
    }

    private boolean softEvictConnection(PoolEntry poolEntry, String str, boolean z) {
        poolEntry.markEvicted();
        if (!z && !this.connectionBag.reserve(poolEntry)) {
            return false;
        }
        closeConnection(poolEntry, str);
        return true;
    }

    private ScheduledExecutorService initializeHouseKeepingExecutorService() {
        if (this.config.getScheduledExecutor() != null) {
            return this.config.getScheduledExecutor();
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, (ThreadFactory) Optional.ofNullable(this.config.getThreadFactory()).orElseGet(() -> {
            return new UtilityElf.DefaultThreadFactory(this.poolName + ":housekeeper");
        }), new ThreadPoolExecutor.DiscardPolicy());
        scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        return scheduledThreadPoolExecutor;
    }

    private void destroyHouseKeepingExecutorService() {
        if (this.config.getScheduledExecutor() == null) {
            this.houseKeepingExecutorService.shutdownNow();
        }
    }

    private PoolStats getPoolStats() {
        return new PoolStats(TimeUnit.SECONDS.toMillis(1L)) { // from class: me.ulrich.clans.library.hikari.pool.HikariPool.1
            @Override // me.ulrich.clans.library.hikari.metrics.PoolStats
            protected void update() {
                this.pendingThreads = HikariPool.this.getThreadsAwaitingConnection();
                this.idleConnections = HikariPool.this.getIdleConnections();
                this.totalConnections = HikariPool.this.getTotalConnections();
                this.activeConnections = HikariPool.this.getActiveConnections();
                this.maxConnections = HikariPool.this.config.getMaximumPoolSize();
                this.minConnections = HikariPool.this.config.getMinimumIdle();
            }
        };
    }

    private SQLException createTimeoutException(long j) {
        logPoolState("Timeout failure ");
        this.metricsTracker.recordConnectionTimeout();
        String sQLState = null;
        int errorCode = 0;
        Throwable lastConnectionFailure = getLastConnectionFailure();
        if (lastConnectionFailure instanceof SQLException) {
            sQLState = ((SQLException) lastConnectionFailure).getSQLState();
            errorCode = ((SQLException) lastConnectionFailure).getErrorCode();
        }
        String str = this.poolName;
        long jElapsedMillis = ClockSource.elapsedMillis(j);
        int totalConnections = getTotalConnections();
        int activeConnections = getActiveConnections();
        int idleConnections = getIdleConnections();
        getThreadsAwaitingConnection();
        SQLTransientConnectionException sQLTransientConnectionException = new SQLTransientConnectionException(str + " - Connection is not available, request timed out after " + jElapsedMillis + "ms (total=" + sQLTransientConnectionException + ", active=" + totalConnections + ", idle=" + activeConnections + ", waiting=" + idleConnections + ")", sQLState, errorCode, lastConnectionFailure);
        if (lastConnectionFailure instanceof SQLException) {
            sQLTransientConnectionException.setNextException((SQLException) lastConnectionFailure);
        }
        return sQLTransientConnectionException;
    }

    @Override // me.ulrich.clans.library.hikari.pool.PoolBase
    public /* bridge */ /* synthetic */ DataSource getUnwrappedDataSource() {
        return super.getUnwrappedDataSource();
    }

    @Override // me.ulrich.clans.library.hikari.pool.PoolBase
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}

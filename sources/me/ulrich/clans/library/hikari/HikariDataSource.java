package me.ulrich.clans.library.hikari;

import java.io.Closeable;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.sql.DataSource;
import me.ulrich.clans.library.hikari.metrics.MetricsTrackerFactory;
import me.ulrich.clans.library.hikari.pool.HikariPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/HikariDataSource.class */
public class HikariDataSource extends HikariConfig implements Closeable, DataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) HikariDataSource.class);
    private final AtomicBoolean isShutdown;
    private final HikariPool fastPathPool;
    private volatile HikariPool pool;

    public HikariDataSource() {
        this.isShutdown = new AtomicBoolean();
        this.fastPathPool = null;
    }

    public HikariDataSource(HikariConfig hikariConfig) {
        this.isShutdown = new AtomicBoolean();
        hikariConfig.validate();
        hikariConfig.copyStateTo(this);
        LOGGER.info("{} - Starting...", hikariConfig.getPoolName());
        HikariPool hikariPool = new HikariPool(this);
        this.fastPathPool = hikariPool;
        this.pool = hikariPool;
        LOGGER.info("{} - Start completed.", hikariConfig.getPoolName());
        seal();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        if (isClosed()) {
            throw new SQLException("HikariDataSource " + this + " has been closed.");
        }
        if (this.fastPathPool != null) {
            return this.fastPathPool.getConnection();
        }
        HikariPool hikariPool = this.pool;
        if (hikariPool == null) {
            synchronized (this) {
                hikariPool = this.pool;
                if (hikariPool == null) {
                    validate();
                    LOGGER.info("{} - Starting...", getPoolName());
                    try {
                        HikariPool hikariPool2 = new HikariPool(this);
                        hikariPool = hikariPool2;
                        this.pool = hikariPool2;
                        seal();
                        LOGGER.info("{} - Start completed.", getPoolName());
                    } catch (HikariPool.PoolInitializationException e) {
                        if (e.getCause() instanceof SQLException) {
                            throw ((SQLException) e.getCause());
                        }
                        throw e;
                    }
                }
            }
        }
        return hikariPool.getConnection();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String str, String str2) throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() {
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            return hikariPool.getUnwrappedDataSource().getLogWriter();
        }
        return null;
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter printWriter) {
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            hikariPool.getUnwrappedDataSource().setLogWriter(printWriter);
        }
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int i) {
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            hikariPool.getUnwrappedDataSource().setLoginTimeout(i);
        }
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() {
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            return hikariPool.getUnwrappedDataSource().getLoginTimeout();
        }
        return 0;
    }

    @Override // javax.sql.CommonDataSource
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Object, javax.sql.DataSource] */
    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLException {
        if (cls.isInstance(this)) {
            return this;
        }
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            T r0 = (T) hikariPool.getUnwrappedDataSource();
            if (cls.isInstance(r0)) {
                return r0;
            }
            if (r0 != 0) {
                return (T) r0.unwrap(cls);
            }
        }
        throw new SQLException("Wrapped DataSource is not an instance of " + cls);
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) {
        if (cls.isInstance(this)) {
            return true;
        }
        HikariPool hikariPool = this.pool;
        if (hikariPool == null) {
            return false;
        }
        DataSource unwrappedDataSource = hikariPool.getUnwrappedDataSource();
        if (cls.isInstance(unwrappedDataSource)) {
            return true;
        }
        if (unwrappedDataSource != null) {
            return unwrappedDataSource.isWrapperFor(cls);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.hikari.HikariConfig
    public void setMetricRegistry(Object obj) {
        boolean z = getMetricRegistry() != null;
        super.setMetricRegistry(obj);
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            if (z) {
                throw new IllegalStateException("MetricRegistry can only be set one time");
            }
            hikariPool.setMetricRegistry(super.getMetricRegistry());
        }
    }

    @Override // me.ulrich.clans.library.hikari.HikariConfig
    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        boolean z = getMetricsTrackerFactory() != null;
        super.setMetricsTrackerFactory(metricsTrackerFactory);
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            if (z) {
                throw new IllegalStateException("MetricsTrackerFactory can only be set one time");
            }
            hikariPool.setMetricsTrackerFactory(super.getMetricsTrackerFactory());
        }
    }

    @Override // me.ulrich.clans.library.hikari.HikariConfig
    public void setHealthCheckRegistry(Object obj) {
        boolean z = getHealthCheckRegistry() != null;
        super.setHealthCheckRegistry(obj);
        HikariPool hikariPool = this.pool;
        if (hikariPool != null) {
            if (z) {
                throw new IllegalStateException("HealthCheckRegistry can only be set one time");
            }
            hikariPool.setHealthCheckRegistry(super.getHealthCheckRegistry());
        }
    }

    public boolean isRunning() {
        return this.pool != null && this.pool.poolState == 0;
    }

    public HikariPoolMXBean getHikariPoolMXBean() {
        return this.pool;
    }

    public HikariConfigMXBean getHikariConfigMXBean() {
        return this;
    }

    public void evictConnection(Connection connection) {
        HikariPool hikariPool;
        if (isClosed() || (hikariPool = this.pool) == null || !connection.getClass().getName().startsWith("me.ulrich.clans.library.hikari")) {
            return;
        }
        hikariPool.evictConnection(connection);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HikariPool hikariPool;
        if (this.isShutdown.getAndSet(true) || (hikariPool = this.pool) == null) {
            return;
        }
        try {
            LOGGER.info("{} - Shutdown initiated...", getPoolName());
            hikariPool.shutdown();
            LOGGER.info("{} - Shutdown completed.", getPoolName());
        } catch (InterruptedException e) {
            LOGGER.warn("{} - Interrupted during closing", getPoolName(), e);
            Thread.currentThread().interrupt();
        }
    }

    public boolean isClosed() {
        return this.isShutdown.get();
    }

    public String toString() {
        return "HikariDataSource (" + this.pool + ")";
    }
}

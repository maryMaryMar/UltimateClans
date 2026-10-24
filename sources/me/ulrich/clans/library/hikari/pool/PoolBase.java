package me.ulrich.clans.library.hikari.pool;

import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.HikariCredentialsProvider;
import me.ulrich.clans.library.hikari.SQLExceptionOverride;
import me.ulrich.clans.library.hikari.metrics.IMetricsTracker;
import me.ulrich.clans.library.hikari.util.ClockSource;
import me.ulrich.clans.library.hikari.util.Credentials;
import me.ulrich.clans.library.hikari.util.DriverDataSource;
import me.ulrich.clans.library.hikari.util.PropertyElf;
import me.ulrich.clans.library.hikari.util.UtilityElf;
import org.java_websocket.framing.CloseFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/PoolBase.class */
abstract class PoolBase {
    public final HikariConfig config;
    IMetricsTrackerDelegate metricsTracker;
    protected final String poolName;
    volatile String catalog;
    final AtomicReference<Throwable> lastConnectionFailure;
    final AtomicLong connectionFailureTimestamp;
    long connectionTimeout;
    long validationTimeout;
    SQLExceptionOverride exceptionOverride;
    HikariCredentialsProvider credentialsProvider;
    private static final int UNINITIALIZED = -1;
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private int defaultTransactionIsolation;
    private int transactionIsolation;
    private Executor netTimeoutExecutor;
    private DataSource dataSource;
    private final String schema;
    private final boolean isReadOnly;
    private final boolean isAutoCommit;
    private final boolean isUseJdbc4Validation;
    private final boolean isIsolateInternalQueries;
    private volatile boolean isValidChecked;
    private static final String[] RESET_STATES = {"readOnly", "autoCommit", "isolation", "catalog", "netTimeout", "schema"};
    private static final int MINIMUM_LOGIN_TIMEOUT = Integer.getInteger("me.ulrich.clans.library.hikari.minimumLoginTimeoutSecs", 1).intValue();
    private static final boolean LEGACY_USERPASS_DS_OVERRIDE = Boolean.getBoolean("me.ulrich.clans.library.hikari.legacy.supportUserPassDataSourceOverride");
    private final Logger logger = LoggerFactory.getLogger((Class<?>) PoolBase.class);
    private int networkTimeout = -1;
    private int isQueryTimeoutSupported = -1;
    private volatile int isNetworkTimeoutSupported = -1;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/PoolBase$ConnectionSetupException.class */
    static class ConnectionSetupException extends Exception {
        private static final long serialVersionUID = 929872118275916521L;

        ConnectionSetupException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/PoolBase$IMetricsTrackerDelegate.class */
    interface IMetricsTrackerDelegate extends AutoCloseable {
        default void recordConnectionUsage(PoolEntry poolEntry) {
        }

        default void recordConnectionCreated(long j) {
        }

        default void recordBorrowTimeoutStats(long j) {
        }

        default void recordBorrowStats(PoolEntry poolEntry, long j) {
        }

        default void recordConnectionTimeout() {
        }

        @Override // java.lang.AutoCloseable
        default void close() {
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/PoolBase$MetricsTrackerDelegate.class */
    static class MetricsTrackerDelegate implements IMetricsTrackerDelegate {
        final IMetricsTracker tracker;

        MetricsTrackerDelegate(IMetricsTracker iMetricsTracker) {
            this.tracker = iMetricsTracker;
        }

        @Override // me.ulrich.clans.library.hikari.pool.PoolBase.IMetricsTrackerDelegate
        public void recordConnectionUsage(PoolEntry poolEntry) {
            this.tracker.recordConnectionUsageMillis(poolEntry.getMillisSinceBorrowed());
        }

        @Override // me.ulrich.clans.library.hikari.pool.PoolBase.IMetricsTrackerDelegate
        public void recordConnectionCreated(long j) {
            this.tracker.recordConnectionCreatedMillis(j);
        }

        @Override // me.ulrich.clans.library.hikari.pool.PoolBase.IMetricsTrackerDelegate
        public void recordBorrowTimeoutStats(long j) {
            this.tracker.recordConnectionAcquiredNanos(ClockSource.elapsedNanos(j));
        }

        @Override // me.ulrich.clans.library.hikari.pool.PoolBase.IMetricsTrackerDelegate
        public void recordBorrowStats(PoolEntry poolEntry, long j) {
            long jCurrentTime = ClockSource.currentTime();
            poolEntry.lastBorrowed = jCurrentTime;
            this.tracker.recordConnectionAcquiredNanos(ClockSource.elapsedNanos(j, jCurrentTime));
        }

        @Override // me.ulrich.clans.library.hikari.pool.PoolBase.IMetricsTrackerDelegate
        public void recordConnectionTimeout() {
            this.tracker.recordConnectionTimeout();
        }

        @Override // me.ulrich.clans.library.hikari.pool.PoolBase.IMetricsTrackerDelegate, java.lang.AutoCloseable
        public void close() {
            this.tracker.close();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/PoolBase$NopMetricsTrackerDelegate.class */
    static final class NopMetricsTrackerDelegate implements IMetricsTrackerDelegate {
        NopMetricsTrackerDelegate() {
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/PoolBase$SynchronousExecutor.class */
    private static class SynchronousExecutor implements Executor {
        private SynchronousExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                runnable.run();
            } catch (Exception e) {
                LoggerFactory.getLogger((Class<?>) PoolBase.class).debug("Failed to execute: {}", runnable, e);
            }
        }
    }

    PoolBase(HikariConfig hikariConfig) {
        this.config = hikariConfig;
        this.catalog = hikariConfig.getCatalog();
        this.schema = hikariConfig.getSchema();
        this.isReadOnly = hikariConfig.isReadOnly();
        this.isAutoCommit = hikariConfig.isAutoCommit();
        this.exceptionOverride = hikariConfig.getExceptionOverride();
        this.credentialsProvider = hikariConfig.getCredentialsProvider();
        this.transactionIsolation = UtilityElf.getTransactionIsolation(hikariConfig.getTransactionIsolation());
        this.isUseJdbc4Validation = hikariConfig.getConnectionTestQuery() == null;
        this.isIsolateInternalQueries = hikariConfig.isIsolateInternalQueries();
        this.poolName = hikariConfig.getPoolName();
        this.connectionTimeout = hikariConfig.getConnectionTimeout();
        this.validationTimeout = hikariConfig.getValidationTimeout();
        this.lastConnectionFailure = new AtomicReference<>();
        this.connectionFailureTimestamp = new AtomicLong();
        initializeDataSource();
    }

    public String toString() {
        return this.poolName;
    }

    abstract void recycle(PoolEntry poolEntry);

    void quietlyCloseConnection(Connection connection, String str) {
        if (connection != null) {
            try {
                this.logger.debug("{} - Closing connection {}: {}", this.poolName, connection, str);
                try {
                    try {
                        if (!connection.isClosed()) {
                            setNetworkTimeout(connection, TimeUnit.SECONDS.toMillis(15L));
                        }
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                    }
                } catch (Throwable th) {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.logger.debug("{} - Closing connection {} failed", this.poolName, connection, e2);
            }
        }
    }

    boolean isConnectionDead(Connection connection) {
        try {
            setNetworkTimeout(connection, this.validationTimeout);
            try {
                int iMax = ((int) Math.max(1000L, this.validationTimeout)) / CloseFrame.NORMAL;
                if (this.isUseJdbc4Validation) {
                    boolean z = !connection.isValid(iMax);
                    setNetworkTimeout(connection, this.networkTimeout);
                    if (this.isIsolateInternalQueries && !this.isAutoCommit) {
                        connection.rollback();
                    }
                    return z;
                }
                Statement statementCreateStatement = connection.createStatement();
                try {
                    if (this.isNetworkTimeoutSupported != 1) {
                        setQueryTimeout(statementCreateStatement, iMax);
                    }
                    statementCreateStatement.execute(this.config.getConnectionTestQuery());
                    if (statementCreateStatement != null) {
                        statementCreateStatement.close();
                    }
                    setNetworkTimeout(connection, this.networkTimeout);
                    if (!this.isIsolateInternalQueries || this.isAutoCommit) {
                        return false;
                    }
                    connection.rollback();
                    return false;
                } catch (Throwable th) {
                    if (statementCreateStatement != null) {
                        try {
                            statementCreateStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                setNetworkTimeout(connection, this.networkTimeout);
                if (this.isIsolateInternalQueries && !this.isAutoCommit) {
                    connection.rollback();
                }
                throw th3;
            }
        } catch (Exception e) {
            this.lastConnectionFailure.set(e);
            this.logger.warn("{} - Failed to validate connection {} ({}). Possibly consider using a shorter maxLifetime value.", this.poolName, connection, e.getMessage());
            return true;
        }
    }

    Throwable getLastConnectionFailure() {
        return this.lastConnectionFailure.get();
    }

    public DataSource getUnwrappedDataSource() {
        return this.dataSource;
    }

    PoolEntry newPoolEntry(boolean z) {
        return new PoolEntry(newConnection(z), this, this.isReadOnly, this.isAutoCommit);
    }

    void resetConnectionState(Connection connection, ProxyConnection proxyConnection, int i) throws SQLException {
        int i2 = 0;
        if ((i & 1) != 0 && proxyConnection.getReadOnlyState() != this.isReadOnly) {
            connection.setReadOnly(this.isReadOnly);
            i2 = 0 | 1;
        }
        if ((i & 2) != 0 && proxyConnection.getAutoCommitState() != this.isAutoCommit) {
            connection.setAutoCommit(this.isAutoCommit);
            i2 |= 2;
        }
        if ((i & 4) != 0 && proxyConnection.getTransactionIsolationState() != this.transactionIsolation) {
            connection.setTransactionIsolation(this.transactionIsolation);
            i2 |= 4;
        }
        if ((i & 8) != 0 && this.catalog != null && !this.catalog.equals(proxyConnection.getCatalogState())) {
            connection.setCatalog(this.catalog);
            i2 |= 8;
        }
        if ((i & 16) != 0 && proxyConnection.getNetworkTimeoutState() != this.networkTimeout) {
            setNetworkTimeout(connection, this.networkTimeout);
            i2 |= 16;
        }
        if ((i & 32) != 0 && this.schema != null && !this.schema.equals(proxyConnection.getSchemaState())) {
            connection.setSchema(this.schema);
            i2 |= 32;
        }
        if (i2 == 0 || !this.logger.isDebugEnabled()) {
            return;
        }
        this.logger.debug("{} - Reset ({}) on connection {}", this.poolName, stringFromResetBits(i2), connection);
    }

    void shutdownNetworkTimeoutExecutor() {
        this.isNetworkTimeoutSupported = -1;
        if (this.netTimeoutExecutor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) this.netTimeoutExecutor).shutdownNow();
        }
    }

    long getLoginTimeout() {
        try {
            return this.dataSource != null ? this.dataSource.getLoginTimeout() : TimeUnit.SECONDS.toSeconds(5L);
        } catch (SQLException e) {
            return TimeUnit.SECONDS.toSeconds(5L);
        }
    }

    void handleMBeans(HikariPool hikariPool, boolean z) {
        ObjectName objectName;
        ObjectName objectName2;
        if (this.config.isRegisterMbeans()) {
            try {
                MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
                if ("true".equals(System.getProperty("hikaricp.jmx.register2.0"))) {
                    objectName = new ObjectName("me.ulrich.clans.library.hikari:type=PoolConfig,name=" + this.poolName);
                    objectName2 = new ObjectName("me.ulrich.clans.library.hikari:type=Pool,name=" + this.poolName);
                } else {
                    objectName = new ObjectName("me.ulrich.clans.library.hikari:type=PoolConfig (" + this.poolName + ")");
                    objectName2 = new ObjectName("me.ulrich.clans.library.hikari:type=Pool (" + this.poolName + ")");
                }
                if (z) {
                    if (platformMBeanServer.isRegistered(objectName)) {
                        this.logger.error("{} - JMX name ({}) is already registered.", this.poolName, this.poolName);
                    } else {
                        platformMBeanServer.registerMBean(this.config, objectName);
                        platformMBeanServer.registerMBean(hikariPool, objectName2);
                    }
                } else if (platformMBeanServer.isRegistered(objectName)) {
                    platformMBeanServer.unregisterMBean(objectName);
                    platformMBeanServer.unregisterMBean(objectName2);
                }
            } catch (Exception e) {
                Logger logger = this.logger;
                Object[] objArr = new Object[3];
                objArr[0] = this.poolName;
                objArr[1] = z ? "register" : "unregister";
                objArr[2] = e;
                logger.warn("{} - Failed to {} management beans.", objArr);
            }
        }
    }

    private void initializeDataSource() {
        String jdbcUrl = this.config.getJdbcUrl();
        String dataSourceClassName = this.config.getDataSourceClassName();
        String driverClassName = this.config.getDriverClassName();
        String dataSourceJNDI = this.config.getDataSourceJNDI();
        Properties dataSourceProperties = this.config.getDataSourceProperties();
        Credentials credentials = getCredentials();
        DataSource dataSource = this.config.getDataSource();
        if (dataSourceClassName != null && dataSource == null) {
            dataSource = (DataSource) UtilityElf.createInstance(dataSourceClassName, DataSource.class);
            PropertyElf.setTargetFromProperties(dataSource, dataSourceProperties);
        } else if (jdbcUrl != null && dataSource == null) {
            dataSource = new DriverDataSource(jdbcUrl, driverClassName, dataSourceProperties, credentials.getUsername(), credentials.getPassword());
        } else if (dataSourceJNDI != null && dataSource == null) {
            try {
                dataSource = (DataSource) new InitialContext().lookup(dataSourceJNDI);
            } catch (NamingException e) {
                throw new HikariPool.PoolInitializationException(e);
            }
        }
        if (dataSource != null) {
            setLoginTimeout(dataSource);
            createNetworkTimeoutExecutor(dataSource, dataSourceClassName, jdbcUrl);
        }
        this.dataSource = dataSource;
    }

    private Connection newConnection(boolean z) {
        long jCurrentTime = ClockSource.currentTime();
        UUID uuidRandomUUID = UUID.randomUUID();
        try {
            try {
                Credentials credentials = getCredentials();
                String username = credentials.getUsername();
                String password = credentials.getPassword();
                this.logger.debug("{} - Attempting to create/setup new connection ({})", this.poolName, uuidRandomUUID);
                Connection connection = username == null ? this.dataSource.getConnection() : this.dataSource.getConnection(username, password);
                if (connection == null) {
                    throw new SQLTransientConnectionException("DataSource returned null unexpectedly");
                }
                setupConnection(connection);
                this.lastConnectionFailure.set(null);
                this.connectionFailureTimestamp.set(0L);
                this.logger.debug("{} - Established new connection ({})", this.poolName, uuidRandomUUID);
                if (this.metricsTracker != null) {
                    this.metricsTracker.recordConnectionCreated(ClockSource.elapsedMillis(jCurrentTime));
                }
                return connection;
            } catch (Throwable th) {
                this.logger.debug("{} - Failed to create/setup connection ({}): {}", this.poolName, uuidRandomUUID, th.getMessage());
                this.connectionFailureTimestamp.compareAndSet(0L, jCurrentTime);
                if (z && ClockSource.elapsedMillis(this.connectionFailureTimestamp.get()) > TimeUnit.MINUTES.toMillis(1L)) {
                    this.logger.warn("{} - Pool is empty, failed to create/setup connection ({})", this.poolName, uuidRandomUUID, th);
                    this.connectionFailureTimestamp.set(0L);
                }
                if (0 != 0) {
                    quietlyCloseConnection(null, "(Failed to create/setup connection (".concat(uuidRandomUUID.toString()).concat(")"));
                }
                this.lastConnectionFailure.set(th);
                throw th;
            }
        } catch (Throwable th2) {
            if (this.metricsTracker != null) {
                this.metricsTracker.recordConnectionCreated(ClockSource.elapsedMillis(jCurrentTime));
            }
            throw th2;
        }
    }

    private void setupConnection(Connection connection) throws ConnectionSetupException {
        try {
            if (this.networkTimeout == -1) {
                this.networkTimeout = getAndSetNetworkTimeout(connection, this.validationTimeout);
            } else {
                setNetworkTimeout(connection, this.validationTimeout);
            }
            if (connection.isReadOnly() != this.isReadOnly) {
                connection.setReadOnly(this.isReadOnly);
            }
            if (connection.getAutoCommit() != this.isAutoCommit) {
                connection.setAutoCommit(this.isAutoCommit);
            }
            checkDriverSupport(connection);
            if (this.transactionIsolation != this.defaultTransactionIsolation) {
                connection.setTransactionIsolation(this.transactionIsolation);
            }
            if (this.catalog != null) {
                connection.setCatalog(this.catalog);
            }
            if (this.schema != null) {
                connection.setSchema(this.schema);
            }
            executeSql(connection, this.config.getConnectionInitSql(), true);
            setNetworkTimeout(connection, this.networkTimeout);
        } catch (SQLException e) {
            throw new ConnectionSetupException(e);
        }
    }

    private void checkDriverSupport(Connection connection) throws SQLException {
        if (this.isValidChecked) {
            return;
        }
        checkValidationSupport(connection);
        checkDefaultIsolation(connection);
        this.isValidChecked = true;
    }

    private void checkValidationSupport(Connection connection) {
        try {
            if (this.isUseJdbc4Validation) {
                connection.isValid(Math.max(1, (int) TimeUnit.MILLISECONDS.toSeconds(this.validationTimeout)));
            } else {
                executeSql(connection, this.config.getConnectionTestQuery(), false);
            }
        } catch (AbstractMethodError | Exception e) {
            Logger logger = this.logger;
            Object[] objArr = new Object[3];
            objArr[0] = this.poolName;
            objArr[1] = this.isUseJdbc4Validation ? " isValid() for connection, configure" : "";
            objArr[2] = e.getMessage();
            logger.error("{} - Failed to execute{} connection test query ({}).", objArr);
            throw e;
        }
    }

    private void checkDefaultIsolation(Connection connection) throws SQLException {
        try {
            this.defaultTransactionIsolation = connection.getTransactionIsolation();
            if (this.transactionIsolation == -1) {
                this.transactionIsolation = this.defaultTransactionIsolation;
            }
        } catch (SQLException e) {
            this.logger.warn("{} - Default transaction isolation level detection failed ({}).", this.poolName, e.getMessage());
            if (e.getSQLState() != null && !e.getSQLState().startsWith("08")) {
                throw e;
            }
        }
    }

    private void setQueryTimeout(Statement statement, int i) {
        if (this.isQueryTimeoutSupported != 0) {
            try {
                statement.setQueryTimeout(i);
                this.isQueryTimeoutSupported = 1;
            } catch (Exception e) {
                if (this.isQueryTimeoutSupported == -1) {
                    this.isQueryTimeoutSupported = 0;
                    this.logger.info("{} - Failed to set query timeout for statement. ({})", this.poolName, e.getMessage());
                }
            }
        }
    }

    private int getAndSetNetworkTimeout(Connection connection, long j) {
        if (this.isNetworkTimeoutSupported == 0) {
            return 0;
        }
        try {
            int networkTimeout = connection.getNetworkTimeout();
            connection.setNetworkTimeout(this.netTimeoutExecutor, (int) j);
            this.isNetworkTimeoutSupported = 1;
            return networkTimeout;
        } catch (AbstractMethodError | Exception e) {
            if (this.isNetworkTimeoutSupported != -1) {
                return 0;
            }
            this.isNetworkTimeoutSupported = 0;
            this.logger.info("{} - Driver does not support get/set network timeout for connections. ({})", this.poolName, e.getMessage());
            if (this.validationTimeout < TimeUnit.SECONDS.toMillis(1L)) {
                this.logger.warn("{} - A validationTimeout of less than 1 second cannot be honored on drivers without setNetworkTimeout() support.", this.poolName);
                return 0;
            }
            if (this.validationTimeout % TimeUnit.SECONDS.toMillis(1L) == 0) {
                return 0;
            }
            this.logger.warn("{} - A validationTimeout with fractional second granularity cannot be honored on drivers without setNetworkTimeout() support.", this.poolName);
            return 0;
        }
    }

    private void setNetworkTimeout(Connection connection, long j) {
        if (this.isNetworkTimeoutSupported == 1) {
            connection.setNetworkTimeout(this.netTimeoutExecutor, (int) j);
        }
    }

    private void executeSql(Connection connection, String str, boolean z) throws SQLException {
        if (str != null) {
            Statement statementCreateStatement = connection.createStatement();
            try {
                statementCreateStatement.execute(str);
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
                if (!this.isIsolateInternalQueries || this.isAutoCommit) {
                    return;
                }
                if (z) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
            } catch (Throwable th) {
                if (statementCreateStatement != null) {
                    try {
                        statementCreateStatement.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private void createNetworkTimeoutExecutor(DataSource dataSource, String str, String str2) {
        if ((str != null && str.contains("Mysql")) || ((str2 != null && str2.contains("mysql")) || (dataSource != null && dataSource.getClass().getName().contains("Mysql")))) {
            this.netTimeoutExecutor = new SynchronousExecutor();
            return;
        }
        ThreadFactory threadFactory = this.config.getThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool(threadFactory != null ? threadFactory : new UtilityElf.DefaultThreadFactory(this.poolName + ":network-timeout-executor"));
        threadPoolExecutor.setKeepAliveTime(15L, TimeUnit.SECONDS);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.netTimeoutExecutor = threadPoolExecutor;
    }

    private void setLoginTimeout(DataSource dataSource) {
        if (this.connectionTimeout != 2147483647L) {
            try {
                dataSource.setLoginTimeout(Math.max(MINIMUM_LOGIN_TIMEOUT, (int) TimeUnit.MILLISECONDS.toSeconds(500 + this.connectionTimeout)));
            } catch (Exception e) {
                this.logger.info("{} - Failed to set login timeout for data source. ({})", this.poolName, e.getMessage());
            }
        }
    }

    private String stringFromResetBits(int i) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (int i2 = 0; i2 < RESET_STATES.length; i2++) {
            if ((i & (1 << i2)) != 0) {
                stringJoiner.add(RESET_STATES[i2]);
            }
        }
        return stringJoiner.toString();
    }

    private Credentials getCredentials() {
        if (this.credentialsProvider != null) {
            return this.credentialsProvider.getCredentials();
        }
        Credentials credentials = this.config.getCredentials();
        if (LEGACY_USERPASS_DS_OVERRIDE) {
            credentials = Credentials.of(this.config.getUsername(), this.config.getPassword());
        }
        return credentials;
    }
}

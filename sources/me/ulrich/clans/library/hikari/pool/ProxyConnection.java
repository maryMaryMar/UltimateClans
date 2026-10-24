package me.ulrich.clans.library.hikari.pool;

import java.lang.reflect.Proxy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import me.ulrich.clans.library.hikari.SQLExceptionOverride;
import me.ulrich.clans.library.hikari.util.FastList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyConnection.class */
public abstract class ProxyConnection implements Connection {
    static final int DIRTY_BIT_READONLY = 1;
    static final int DIRTY_BIT_AUTOCOMMIT = 2;
    static final int DIRTY_BIT_ISOLATION = 4;
    static final int DIRTY_BIT_CATALOG = 8;
    static final int DIRTY_BIT_NETTIMEOUT = 16;
    static final int DIRTY_BIT_SCHEMA = 32;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ProxyConnection.class);
    private static final Set<String> ERROR_STATES = new HashSet();
    private static final Set<Integer> ERROR_CODES;
    protected Connection delegate;
    private final PoolEntry poolEntry;
    private final ProxyLeakTask leakTask;
    private final FastList<Statement> openStatements;
    private int dirtyBits;
    private boolean isCommitStateDirty;
    private boolean isReadOnly;
    private boolean isAutoCommit;
    private int networkTimeout;
    private int transactionIsolation;
    private String dbcatalog;
    private String dbschema;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyConnection$ClosedConnection.class */
    private static final class ClosedConnection {
        static final Connection CLOSED_CONNECTION = getClosedConnection();

        private ClosedConnection() {
        }

        private static Connection getClosedConnection() {
            return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[]{Connection.class}, (obj, method, objArr) -> {
                switch (method.getName()) {
                    case "isClosed":
                        return Boolean.TRUE;
                    case "isValid":
                        return Boolean.FALSE;
                    case "abort":
                        return Void.TYPE;
                    case "close":
                        return Void.TYPE;
                    case "toString":
                        return ClosedConnection.class.getCanonicalName();
                    default:
                        throw new SQLException("Connection is closed");
                }
            });
        }
    }

    protected ProxyConnection(PoolEntry poolEntry, Connection connection, FastList<Statement> fastList, ProxyLeakTask proxyLeakTask, boolean z, boolean z2) {
        this.poolEntry = poolEntry;
        this.delegate = connection;
        this.openStatements = fastList;
        this.leakTask = proxyLeakTask;
        this.isReadOnly = z;
        this.isAutoCommit = z2;
    }

    public final String toString() {
        return getClass().getSimpleName() + "@" + System.identityHashCode(this) + " wrapping " + this.delegate;
    }

    final boolean getAutoCommitState() {
        return this.isAutoCommit;
    }

    final String getCatalogState() {
        return this.dbcatalog;
    }

    final String getSchemaState() {
        return this.dbschema;
    }

    final int getTransactionIsolationState() {
        return this.transactionIsolation;
    }

    final boolean getReadOnlyState() {
        return this.isReadOnly;
    }

    final int getNetworkTimeoutState() {
        return this.networkTimeout;
    }

    final PoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    final SQLException checkException(SQLException sQLException) {
        boolean z = false;
        SQLException nextException = sQLException;
        SQLExceptionOverride sQLExceptionOverride = this.poolEntry.getPoolBase().exceptionOverride;
        for (int i = 0; this.delegate != ClosedConnection.CLOSED_CONNECTION && nextException != null && i < 10; i++) {
            String sQLState = nextException.getSQLState();
            SQLExceptionOverride.Override overrideAdjudicate = sQLExceptionOverride != null ? sQLExceptionOverride.adjudicate(nextException) : SQLExceptionOverride.Override.CONTINUE_EVICT;
            if (overrideAdjudicate == SQLExceptionOverride.Override.DO_NOT_EVICT) {
                break;
            }
            if ((sQLState != null && sQLState.startsWith("08")) || ERROR_STATES.contains(sQLState) || ERROR_CODES.contains(Integer.valueOf(nextException.getErrorCode())) || overrideAdjudicate == SQLExceptionOverride.Override.MUST_EVICT) {
                z = true;
                break;
            }
            nextException = nextException.getNextException();
        }
        if (z) {
            SQLException sQLException2 = nextException != null ? nextException : sQLException;
            LOGGER.warn("{} - Connection {} marked as broken because of SQLSTATE({}), ErrorCode({})", this.poolEntry.getPoolName(), this.delegate, sQLException2.getSQLState(), Integer.valueOf(sQLException2.getErrorCode()), sQLException2);
            this.leakTask.cancel();
            this.poolEntry.evict("(connection is broken)");
            this.delegate = ClosedConnection.CLOSED_CONNECTION;
        }
        return sQLException;
    }

    final synchronized void untrackStatement(Statement statement) {
        this.openStatements.remove(statement);
    }

    final void markCommitStateDirty() {
        if (this.isAutoCommit) {
            return;
        }
        this.isCommitStateDirty = true;
    }

    void cancelLeakTask() {
        this.leakTask.cancel();
    }

    private synchronized <T extends Statement> T trackStatement(T t) {
        this.openStatements.add(t);
        return t;
    }

    private synchronized void closeStatements() {
        int size = this.openStatements.size();
        if (size > 0) {
            for (int i = 0; i < size && this.delegate != ClosedConnection.CLOSED_CONNECTION; i++) {
                try {
                    Statement statement = this.openStatements.get(i);
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    LOGGER.warn("{} - Connection {} marked as broken because of an exception closing open statements during Connection.close()", this.poolEntry.getPoolName(), this.delegate);
                    this.leakTask.cancel();
                    this.poolEntry.evict("(exception closing Statements during Connection.close())");
                    this.delegate = ClosedConnection.CLOSED_CONNECTION;
                }
            }
            this.openStatements.clear();
        }
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public final void close() {
        closeStatements();
        if (this.delegate != ClosedConnection.CLOSED_CONNECTION) {
            this.leakTask.cancel();
            try {
                try {
                    if (this.isCommitStateDirty && !this.isAutoCommit) {
                        this.delegate.rollback();
                        LOGGER.debug("{} - Executed rollback on connection {} due to dirty commit state on close().", this.poolEntry.getPoolName(), this.delegate);
                    }
                    if (this.dirtyBits != 0) {
                        this.poolEntry.resetConnectionState(this, this.dirtyBits);
                    }
                    this.delegate.clearWarnings();
                    this.delegate = ClosedConnection.CLOSED_CONNECTION;
                    this.poolEntry.recycle();
                } catch (SQLException e) {
                    if (!this.poolEntry.isMarkedEvicted()) {
                        throw checkException(e);
                    }
                    this.delegate = ClosedConnection.CLOSED_CONNECTION;
                    this.poolEntry.recycle();
                }
            } catch (Throwable th) {
                this.delegate = ClosedConnection.CLOSED_CONNECTION;
                this.poolEntry.recycle();
                throw th;
            }
        }
    }

    @Override // java.sql.Connection
    public boolean isClosed() {
        return this.delegate == ClosedConnection.CLOSED_CONNECTION;
    }

    @Override // java.sql.Connection
    public Statement createStatement() {
        return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement()));
    }

    @Override // java.sql.Connection
    public Statement createStatement(int i, int i2) {
        return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement(i, i2)));
    }

    @Override // java.sql.Connection
    public Statement createStatement(int i, int i2, int i3) {
        return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement(i, i2, i3)));
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str) {
        return ProxyFactory.getProxyCallableStatement(this, (CallableStatement) trackStatement(this.delegate.prepareCall(str)));
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str, int i, int i2) {
        return ProxyFactory.getProxyCallableStatement(this, (CallableStatement) trackStatement(this.delegate.prepareCall(str, i, i2)));
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str, int i, int i2, int i3) {
        return ProxyFactory.getProxyCallableStatement(this, (CallableStatement) trackStatement(this.delegate.prepareCall(str, i, i2, i3)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str) {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(str)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i) {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(str, i)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i, int i2) {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(str, i, i2)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i, int i2, int i3) {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(str, i, i2, i3)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int[] iArr) {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(str, iArr)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, String[] strArr) {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(str, strArr)));
    }

    @Override // java.sql.Connection
    public DatabaseMetaData getMetaData() {
        markCommitStateDirty();
        return ProxyFactory.getProxyDatabaseMetaData(this, this.delegate.getMetaData());
    }

    @Override // java.sql.Connection
    public void commit() throws SQLException {
        this.delegate.commit();
        this.isCommitStateDirty = false;
    }

    @Override // java.sql.Connection
    public void rollback() throws SQLException {
        this.delegate.rollback();
        this.isCommitStateDirty = false;
    }

    @Override // java.sql.Connection
    public void rollback(Savepoint savepoint) throws SQLException {
        this.delegate.rollback(savepoint);
        this.isCommitStateDirty = true;
    }

    @Override // java.sql.Connection
    public boolean getAutoCommit() {
        return (this.dirtyBits & 2) != 0 ? this.isAutoCommit : this.delegate.getAutoCommit();
    }

    @Override // java.sql.Connection
    public void setAutoCommit(boolean z) throws SQLException {
        this.delegate.setAutoCommit(z);
        this.isAutoCommit = z;
        this.dirtyBits |= 2;
    }

    @Override // java.sql.Connection
    public boolean isReadOnly() {
        return (this.dirtyBits & 1) != 0 ? this.isReadOnly : this.delegate.isReadOnly();
    }

    @Override // java.sql.Connection
    public void setReadOnly(boolean z) throws SQLException {
        this.delegate.setReadOnly(z);
        this.isReadOnly = z;
        this.dirtyBits |= 1;
    }

    @Override // java.sql.Connection
    public int getTransactionIsolation() {
        return (this.dirtyBits & 4) != 0 ? this.transactionIsolation : this.delegate.getTransactionIsolation();
    }

    @Override // java.sql.Connection
    public void setTransactionIsolation(int i) throws SQLException {
        this.delegate.setTransactionIsolation(i);
        this.transactionIsolation = i;
        this.dirtyBits |= 4;
    }

    @Override // java.sql.Connection
    public String getCatalog() {
        return (this.dirtyBits & 8) != 0 ? this.dbcatalog : this.delegate.getCatalog();
    }

    @Override // java.sql.Connection
    public void setCatalog(String str) throws SQLException {
        this.delegate.setCatalog(str);
        this.dbcatalog = str;
        this.dirtyBits |= 8;
    }

    public int getNetworkTimeout() {
        return (this.dirtyBits & 16) != 0 ? this.networkTimeout : this.delegate.getNetworkTimeout();
    }

    public void setNetworkTimeout(Executor executor, int i) {
        this.delegate.setNetworkTimeout(executor, i);
        this.networkTimeout = i;
        this.dirtyBits |= 16;
    }

    public String getSchema() {
        return (this.dirtyBits & 32) != 0 ? this.dbschema : this.delegate.getSchema();
    }

    public void setSchema(String str) {
        this.delegate.setSchema(str);
        this.dbschema = this.delegate.getSchema();
        this.dirtyBits |= 32;
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class<?> cls) {
        return cls.isInstance(this.delegate) || (this.delegate != null && this.delegate.isWrapperFor(cls));
    }

    @Override // java.sql.Wrapper
    public final <T> T unwrap(Class<T> cls) throws SQLException {
        if (cls.isInstance(this.delegate)) {
            return (T) this.delegate;
        }
        if (this.delegate != null) {
            return (T) this.delegate.unwrap(cls);
        }
        throw new SQLException("Wrapped connection is not an instance of " + cls);
    }

    static {
        ERROR_STATES.add("0A000");
        ERROR_STATES.add("57P01");
        ERROR_STATES.add("57P02");
        ERROR_STATES.add("57P03");
        ERROR_STATES.add("01002");
        ERROR_STATES.add("JZ0C0");
        ERROR_STATES.add("JZ0C1");
        ERROR_CODES = new HashSet();
        ERROR_CODES.add(500150);
        ERROR_CODES.add(2399);
        ERROR_CODES.add(1105);
    }
}

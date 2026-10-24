package me.ulrich.clans.library.hikari.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyStatement.class */
public abstract class ProxyStatement implements Statement {
    protected final ProxyConnection connection;
    final Statement delegate;
    private boolean isClosed;
    private ResultSet proxyResultSet;

    ProxyStatement(ProxyConnection proxyConnection, Statement statement) {
        this.connection = proxyConnection;
        this.delegate = statement;
    }

    final SQLException checkException(SQLException sQLException) {
        return this.connection.checkException(sQLException);
    }

    public final String toString() {
        return getClass().getSimpleName() + "@" + System.identityHashCode(this) + " wrapping " + this.delegate.toString();
    }

    @Override // java.sql.Statement, java.lang.AutoCloseable
    public final void close() throws SQLException {
        synchronized (this) {
            if (this.isClosed) {
                return;
            }
            this.isClosed = true;
            this.connection.untrackStatement(this.delegate);
            try {
                this.delegate.close();
            } catch (SQLException e) {
                throw this.connection.checkException(e);
            }
        }
    }

    @Override // java.sql.Statement
    public Connection getConnection() {
        return this.connection;
    }

    @Override // java.sql.Statement
    public boolean execute(String str) {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(str);
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int i) {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(str, i);
    }

    @Override // java.sql.Statement
    public ResultSet executeQuery(String str) throws SQLException {
        this.connection.markCommitStateDirty();
        return ProxyFactory.getProxyResultSet(this.connection, this, this.delegate.executeQuery(str));
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(str);
    }

    @Override // java.sql.Statement
    public int[] executeBatch() {
        this.connection.markCommitStateDirty();
        return this.delegate.executeBatch();
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int i) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(str, i);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int[] iArr) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(str, iArr);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, String[] strArr) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(str, strArr);
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int[] iArr) {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(str, iArr);
    }

    @Override // java.sql.Statement
    public boolean execute(String str, String[] strArr) {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(str, strArr);
    }

    public long[] executeLargeBatch() {
        this.connection.markCommitStateDirty();
        return this.delegate.executeLargeBatch();
    }

    public long executeLargeUpdate(String str) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeLargeUpdate(str);
    }

    public long executeLargeUpdate(String str, int i) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeLargeUpdate(str, i);
    }

    public long executeLargeUpdate(String str, int[] iArr) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeLargeUpdate(str, iArr);
    }

    public long executeLargeUpdate(String str, String[] strArr) {
        this.connection.markCommitStateDirty();
        return this.delegate.executeLargeUpdate(str, strArr);
    }

    @Override // java.sql.Statement
    public ResultSet getResultSet() throws SQLException {
        ResultSet resultSet = this.delegate.getResultSet();
        if (resultSet == null) {
            this.proxyResultSet = null;
        } else if (this.proxyResultSet == null || ((ProxyResultSet) this.proxyResultSet).delegate != resultSet) {
            this.proxyResultSet = ProxyFactory.getProxyResultSet(this.connection, this, resultSet);
        }
        return this.proxyResultSet;
    }

    @Override // java.sql.Statement
    public ResultSet getGeneratedKeys() throws SQLException {
        ResultSet generatedKeys = this.delegate.getGeneratedKeys();
        if (this.proxyResultSet == null || ((ProxyResultSet) this.proxyResultSet).delegate != generatedKeys) {
            this.proxyResultSet = ProxyFactory.getProxyResultSet(this.connection, this, generatedKeys);
        }
        return this.proxyResultSet;
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
        throw new SQLException("Wrapped statement is not an instance of " + cls);
    }
}

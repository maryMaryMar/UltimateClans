package me.ulrich.clans.library.hikari.pool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyResultSet.class */
public abstract class ProxyResultSet implements ResultSet {
    protected final ProxyConnection connection;
    protected final ProxyStatement statement;
    final ResultSet delegate;

    protected ProxyResultSet(ProxyConnection proxyConnection, ProxyStatement proxyStatement, ResultSet resultSet) {
        this.connection = proxyConnection;
        this.statement = proxyStatement;
        this.delegate = resultSet;
    }

    final SQLException checkException(SQLException sQLException) {
        return this.connection.checkException(sQLException);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + System.identityHashCode(this) + " wrapping " + this.delegate;
    }

    @Override // java.sql.ResultSet
    public final Statement getStatement() {
        return this.statement;
    }

    @Override // java.sql.ResultSet
    public void updateRow() throws SQLException {
        this.connection.markCommitStateDirty();
        this.delegate.updateRow();
    }

    @Override // java.sql.ResultSet
    public void insertRow() throws SQLException {
        this.connection.markCommitStateDirty();
        this.delegate.insertRow();
    }

    @Override // java.sql.ResultSet
    public void deleteRow() throws SQLException {
        this.connection.markCommitStateDirty();
        this.delegate.deleteRow();
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
        throw new SQLException("Wrapped ResultSet is not an instance of " + cls);
    }
}

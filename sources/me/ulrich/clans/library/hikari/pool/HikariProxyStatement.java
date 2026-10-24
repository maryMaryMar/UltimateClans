package me.ulrich.clans.library.hikari.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Wrapper;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/HikariProxyStatement.class */
public final class HikariProxyStatement extends ProxyStatement implements AutoCloseable, Statement, Wrapper {
    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public ResultSet executeQuery(String str) throws SQLException {
        try {
            return super.executeQuery(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public int executeUpdate(String str) throws SQLException {
        try {
            return super.executeUpdate(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getMaxFieldSize() throws SQLException {
        try {
            return this.delegate.getMaxFieldSize();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setMaxFieldSize(int i) throws SQLException {
        try {
            this.delegate.setMaxFieldSize(i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getMaxRows() throws SQLException {
        try {
            return this.delegate.getMaxRows();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setMaxRows(int i) throws SQLException {
        try {
            this.delegate.setMaxRows(i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setEscapeProcessing(boolean z) throws SQLException {
        try {
            this.delegate.setEscapeProcessing(z);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getQueryTimeout() throws SQLException {
        try {
            return this.delegate.getQueryTimeout();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setQueryTimeout(int i) throws SQLException {
        try {
            this.delegate.setQueryTimeout(i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void cancel() throws SQLException {
        try {
            this.delegate.cancel();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public SQLWarning getWarnings() throws SQLException {
        try {
            return this.delegate.getWarnings();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void clearWarnings() throws SQLException {
        try {
            this.delegate.clearWarnings();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setCursorName(String str) throws SQLException {
        try {
            this.delegate.setCursorName(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public boolean execute(String str) throws SQLException {
        try {
            return super.execute(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public ResultSet getResultSet() throws SQLException {
        try {
            return super.getResultSet();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getUpdateCount() throws SQLException {
        try {
            return this.delegate.getUpdateCount();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public boolean getMoreResults() throws SQLException {
        try {
            return this.delegate.getMoreResults();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setFetchDirection(int i) throws SQLException {
        try {
            this.delegate.setFetchDirection(i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getFetchDirection() throws SQLException {
        try {
            return this.delegate.getFetchDirection();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setFetchSize(int i) throws SQLException {
        try {
            this.delegate.setFetchSize(i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getFetchSize() throws SQLException {
        try {
            return this.delegate.getFetchSize();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getResultSetConcurrency() throws SQLException {
        try {
            return this.delegate.getResultSetConcurrency();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getResultSetType() throws SQLException {
        try {
            return this.delegate.getResultSetType();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void addBatch(String str) throws SQLException {
        try {
            this.delegate.addBatch(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void clearBatch() throws SQLException {
        try {
            this.delegate.clearBatch();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public int[] executeBatch() throws SQLException {
        try {
            return super.executeBatch();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public Connection getConnection() throws SQLException {
        try {
            return super.getConnection();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public boolean getMoreResults(int i) throws SQLException {
        try {
            return this.delegate.getMoreResults(i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public ResultSet getGeneratedKeys() throws SQLException {
        try {
            return super.getGeneratedKeys();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public int executeUpdate(String str, int i) throws SQLException {
        try {
            return super.executeUpdate(str, i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public int executeUpdate(String str, int[] iArr) throws SQLException {
        try {
            return super.executeUpdate(str, iArr);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public int executeUpdate(String str, String[] strArr) throws SQLException {
        try {
            return super.executeUpdate(str, strArr);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public boolean execute(String str, int i) throws SQLException {
        try {
            return super.execute(str, i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public boolean execute(String str, int[] iArr) throws SQLException {
        try {
            return super.execute(str, iArr);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement, java.sql.Statement
    public boolean execute(String str, String[] strArr) throws SQLException {
        try {
            return super.execute(str, strArr);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public int getResultSetHoldability() throws SQLException {
        try {
            return this.delegate.getResultSetHoldability();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public boolean isClosed() throws SQLException {
        try {
            return this.delegate.isClosed();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public void setPoolable(boolean z) throws SQLException {
        try {
            this.delegate.setPoolable(z);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // java.sql.Statement
    public boolean isPoolable() throws SQLException {
        try {
            return this.delegate.isPoolable();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public void closeOnCompletion() throws SQLException {
        try {
            this.delegate.closeOnCompletion();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public boolean isCloseOnCompletion() throws SQLException {
        try {
            return this.delegate.isCloseOnCompletion();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public long getLargeUpdateCount() throws SQLException {
        try {
            return this.delegate.getLargeUpdateCount();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public void setLargeMaxRows(long j) throws SQLException {
        try {
            this.delegate.setLargeMaxRows(j);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public long getLargeMaxRows() throws SQLException {
        try {
            return this.delegate.getLargeMaxRows();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement
    public long[] executeLargeBatch() throws SQLException {
        try {
            return this.delegate.executeLargeBatch();
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement
    public long executeLargeUpdate(String str) throws SQLException {
        try {
            return this.delegate.executeLargeUpdate(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement
    public long executeLargeUpdate(String str, int i) throws SQLException {
        try {
            return this.delegate.executeLargeUpdate(str, i);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement
    public long executeLargeUpdate(String str, int[] iArr) throws SQLException {
        try {
            return this.delegate.executeLargeUpdate(str, iArr);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    @Override // me.ulrich.clans.library.hikari.pool.ProxyStatement
    public long executeLargeUpdate(String str, String[] strArr) throws SQLException {
        try {
            return this.delegate.executeLargeUpdate(str, strArr);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public String enquoteLiteral(String str) throws SQLException {
        try {
            return this.delegate.enquoteLiteral(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public String enquoteIdentifier(String str, boolean z) throws SQLException {
        try {
            return this.delegate.enquoteIdentifier(str, z);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public boolean isSimpleIdentifier(String str) throws SQLException {
        try {
            return this.delegate.isSimpleIdentifier(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    public String enquoteNCharLiteral(String str) throws SQLException {
        try {
            return this.delegate.enquoteNCharLiteral(str);
        } catch (SQLException e) {
            throw checkException(e);
        }
    }

    HikariProxyStatement(ProxyConnection proxyConnection, Statement statement) {
        super(proxyConnection, statement);
    }
}

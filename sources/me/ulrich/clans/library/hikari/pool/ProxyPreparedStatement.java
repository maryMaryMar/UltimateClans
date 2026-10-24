package me.ulrich.clans.library.hikari.pool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyPreparedStatement.class */
public abstract class ProxyPreparedStatement extends ProxyStatement implements PreparedStatement {
    ProxyPreparedStatement(ProxyConnection proxyConnection, PreparedStatement preparedStatement) {
        super(proxyConnection, preparedStatement);
    }

    public boolean execute() {
        this.connection.markCommitStateDirty();
        return ((PreparedStatement) this.delegate).execute();
    }

    public ResultSet executeQuery() throws SQLException {
        this.connection.markCommitStateDirty();
        return ProxyFactory.getProxyResultSet(this.connection, this, ((PreparedStatement) this.delegate).executeQuery());
    }

    public int executeUpdate() {
        this.connection.markCommitStateDirty();
        return ((PreparedStatement) this.delegate).executeUpdate();
    }

    public long executeLargeUpdate() {
        this.connection.markCommitStateDirty();
        return ((PreparedStatement) this.delegate).executeLargeUpdate();
    }
}

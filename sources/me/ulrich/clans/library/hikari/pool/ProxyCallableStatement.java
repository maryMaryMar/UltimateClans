package me.ulrich.clans.library.hikari.pool;

import java.sql.CallableStatement;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyCallableStatement.class */
public abstract class ProxyCallableStatement extends ProxyPreparedStatement implements CallableStatement {
    protected ProxyCallableStatement(ProxyConnection proxyConnection, CallableStatement callableStatement) {
        super(proxyConnection, callableStatement);
    }
}

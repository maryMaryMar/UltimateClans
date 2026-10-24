package me.module.multiserver.library.redis.jedis.providers;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Connection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/providers/ManagedConnectionProvider.class */
public class ManagedConnectionProvider implements ConnectionProvider {
    private Connection connection;

    public final void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public final Connection getConnection() {
        return this.connection;
    }

    @Override // me.module.multiserver.library.redis.jedis.providers.ConnectionProvider
    public final Connection getConnection(CommandArguments commandArguments) {
        return this.connection;
    }
}

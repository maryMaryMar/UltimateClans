package me.module.multiserver.library.redis.jedis.executors;

import me.module.multiserver.library.redis.jedis.CommandObject;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.util.IOUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/executors/SimpleCommandExecutor.class */
public class SimpleCommandExecutor implements CommandExecutor {
    protected final Connection connection;

    public SimpleCommandExecutor(Connection connection) {
        this.connection = connection;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.connection);
    }

    @Override // me.module.multiserver.library.redis.jedis.executors.CommandExecutor
    public final <T> T executeCommand(CommandObject<T> commandObject) {
        return (T) this.connection.executeCommand(commandObject);
    }
}

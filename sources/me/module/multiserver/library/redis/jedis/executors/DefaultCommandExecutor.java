package me.module.multiserver.library.redis.jedis.executors;

import me.module.multiserver.library.redis.jedis.CommandObject;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.providers.ConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.IOUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/executors/DefaultCommandExecutor.class */
public class DefaultCommandExecutor implements CommandExecutor {
    protected final ConnectionProvider provider;

    public DefaultCommandExecutor(ConnectionProvider connectionProvider) {
        this.provider = connectionProvider;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.provider);
    }

    @Override // me.module.multiserver.library.redis.jedis.executors.CommandExecutor
    public final <T> T executeCommand(CommandObject<T> commandObject) {
        Connection connection = this.provider.getConnection(commandObject.getArguments());
        Throwable th = null;
        try {
            T t = (T) connection.executeCommand(commandObject);
            if (connection != null) {
                if (0 != 0) {
                    try {
                        connection.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    connection.close();
                }
            }
            return t;
        } catch (Throwable th3) {
            if (connection != null) {
                if (0 != 0) {
                    try {
                        connection.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    connection.close();
                }
            }
            throw th3;
        }
    }
}

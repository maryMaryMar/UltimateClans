package me.module.multiserver.library.redis.jedis.executors;

import me.module.multiserver.library.redis.jedis.CommandObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/executors/CommandExecutor.class */
public interface CommandExecutor extends AutoCloseable {
    <T> T executeCommand(CommandObject<T> commandObject);
}

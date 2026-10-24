package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.resps.Slowlog;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SlowlogCommands.class */
public interface SlowlogCommands {
    String slowlogReset();

    long slowlogLen();

    List<Slowlog> slowlogGet();

    List<Object> slowlogGetBinary();

    List<Slowlog> slowlogGet(long j);

    List<Object> slowlogGetBinary(long j);
}

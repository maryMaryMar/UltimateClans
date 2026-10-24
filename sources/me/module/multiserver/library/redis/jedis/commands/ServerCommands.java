package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.SaveMode;
import me.module.multiserver.library.redis.jedis.params.LolwutParams;
import me.module.multiserver.library.redis.jedis.params.ShutdownParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ServerCommands.class */
public interface ServerCommands {
    String ping();

    String ping(String str);

    String echo(String str);

    byte[] echo(byte[] bArr);

    String quit();

    String flushDB();

    String flushAll();

    String flushAll(FlushMode flushMode);

    String auth(String str);

    String auth(String str, String str2);

    String save();

    String bgsave();

    String bgsaveSchedule();

    String bgrewriteaof();

    long lastsave();

    void shutdown();

    @Deprecated
    void shutdown(SaveMode saveMode);

    void shutdown(ShutdownParams shutdownParams);

    String shutdownAbort();

    String info();

    String info(String str);

    @Deprecated
    String slaveof(String str, int i);

    @Deprecated
    String slaveofNoOne();

    String replicaof(String str, int i);

    String replicaofNoOne();

    long waitReplicas(int i, long j);

    String lolwut();

    String lolwut(LolwutParams lolwutParams);
}

package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.args.ClientPauseMode;
import me.module.multiserver.library.redis.jedis.args.ClientType;
import me.module.multiserver.library.redis.jedis.args.UnblockType;
import me.module.multiserver.library.redis.jedis.params.ClientKillParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ClientCommands.class */
public interface ClientCommands {
    String clientKill(String str);

    String clientKill(String str, int i);

    long clientKill(ClientKillParams clientKillParams);

    String clientGetname();

    String clientList();

    String clientList(ClientType clientType);

    String clientList(long... jArr);

    String clientInfo();

    String clientSetname(String str);

    long clientId();

    long clientUnblock(long j);

    long clientUnblock(long j, UnblockType unblockType);

    String clientPause(long j);

    String clientPause(long j, ClientPauseMode clientPauseMode);

    String clientNoEvictOn();

    String clientNoEvictOff();
}

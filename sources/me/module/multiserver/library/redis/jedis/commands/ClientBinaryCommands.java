package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.args.ClientPauseMode;
import me.module.multiserver.library.redis.jedis.args.ClientType;
import me.module.multiserver.library.redis.jedis.args.UnblockType;
import me.module.multiserver.library.redis.jedis.params.ClientKillParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ClientBinaryCommands.class */
public interface ClientBinaryCommands {
    String clientKill(byte[] bArr);

    String clientKill(String str, int i);

    long clientKill(ClientKillParams clientKillParams);

    byte[] clientGetnameBinary();

    byte[] clientListBinary();

    byte[] clientListBinary(ClientType clientType);

    byte[] clientListBinary(long... jArr);

    byte[] clientInfoBinary();

    String clientSetname(byte[] bArr);

    long clientId();

    long clientUnblock(long j);

    long clientUnblock(long j, UnblockType unblockType);

    String clientPause(long j);

    String clientPause(long j, ClientPauseMode clientPauseMode);

    String clientNoEvictOn();

    String clientNoEvictOff();
}

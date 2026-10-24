package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ConfigCommands.class */
public interface ConfigCommands {
    List<String> configGet(String str);

    List<String> configGet(String... strArr);

    List<byte[]> configGet(byte[] bArr);

    List<byte[]> configGet(byte[]... bArr);

    String configSet(String str, String str2);

    String configSet(String... strArr);

    String configSet(byte[] bArr, byte[] bArr2);

    String configSet(byte[]... bArr);

    String configResetStat();

    String configRewrite();
}

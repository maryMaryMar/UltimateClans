package me.module.multiserver.library.redis.jedis.commands;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HyperLogLogBinaryCommands.class */
public interface HyperLogLogBinaryCommands {
    long pfadd(byte[] bArr, byte[]... bArr2);

    String pfmerge(byte[] bArr, byte[]... bArr2);

    long pfcount(byte[] bArr);

    long pfcount(byte[]... bArr);
}

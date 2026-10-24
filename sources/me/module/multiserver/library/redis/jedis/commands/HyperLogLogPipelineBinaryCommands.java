package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HyperLogLogPipelineBinaryCommands.class */
public interface HyperLogLogPipelineBinaryCommands {
    Response<Long> pfadd(byte[] bArr, byte[]... bArr2);

    Response<String> pfmerge(byte[] bArr, byte[]... bArr2);

    Response<Long> pfcount(byte[] bArr);

    Response<Long> pfcount(byte[]... bArr);
}

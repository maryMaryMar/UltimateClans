package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.FlushMode;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SampleBinaryKeyedCommands.class */
public interface SampleBinaryKeyedCommands {
    long waitReplicas(byte[] bArr, int i, long j);

    Object eval(byte[] bArr, byte[] bArr2);

    Object evalsha(byte[] bArr, byte[] bArr2);

    Boolean scriptExists(byte[] bArr, byte[] bArr2);

    List<Boolean> scriptExists(byte[] bArr, byte[]... bArr2);

    byte[] scriptLoad(byte[] bArr, byte[] bArr2);

    String scriptFlush(byte[] bArr);

    String scriptFlush(byte[] bArr, FlushMode flushMode);

    String scriptKill(byte[] bArr);
}

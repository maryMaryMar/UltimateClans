package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.FlushMode;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SampleBinaryKeyedPipelineCommands.class */
public interface SampleBinaryKeyedPipelineCommands {
    Response<Long> waitReplicas(byte[] bArr, int i, long j);

    Response<Object> eval(byte[] bArr, byte[] bArr2);

    Response<Object> evalsha(byte[] bArr, byte[] bArr2);

    Response<List<Boolean>> scriptExists(byte[] bArr, byte[]... bArr2);

    Response<byte[]> scriptLoad(byte[] bArr, byte[] bArr2);

    Response<String> scriptFlush(byte[] bArr);

    Response<String> scriptFlush(byte[] bArr, FlushMode flushMode);

    Response<String> scriptKill(byte[] bArr);
}

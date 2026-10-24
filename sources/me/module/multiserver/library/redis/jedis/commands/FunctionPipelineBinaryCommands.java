package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.FunctionRestorePolicy;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/FunctionPipelineBinaryCommands.class */
public interface FunctionPipelineBinaryCommands {
    Response<Object> fcall(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Response<Object> fcallReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Response<String> functionDelete(byte[] bArr);

    Response<byte[]> functionDump();

    Response<String> functionFlush();

    Response<String> functionFlush(FlushMode flushMode);

    Response<String> functionKill();

    Response<List<Object>> functionListBinary();

    Response<List<Object>> functionList(byte[] bArr);

    Response<List<Object>> functionListWithCodeBinary();

    Response<List<Object>> functionListWithCode(byte[] bArr);

    Response<String> functionLoad(byte[] bArr);

    Response<String> functionLoadReplace(byte[] bArr);

    Response<String> functionRestore(byte[] bArr);

    Response<String> functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy);

    Response<Object> functionStatsBinary();
}

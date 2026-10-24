package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.FunctionRestorePolicy;
import me.module.multiserver.library.redis.jedis.resps.FunctionStats;
import me.module.multiserver.library.redis.jedis.resps.LibraryInfo;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/FunctionPipelineCommands.class */
public interface FunctionPipelineCommands {
    Response<Object> fcall(String str, List<String> list, List<String> list2);

    Response<Object> fcallReadonly(String str, List<String> list, List<String> list2);

    Response<String> functionDelete(String str);

    Response<byte[]> functionDump();

    Response<String> functionFlush();

    Response<String> functionFlush(FlushMode flushMode);

    Response<String> functionKill();

    Response<List<LibraryInfo>> functionList();

    Response<List<LibraryInfo>> functionList(String str);

    Response<List<LibraryInfo>> functionListWithCode();

    Response<List<LibraryInfo>> functionListWithCode(String str);

    Response<String> functionLoad(String str);

    Response<String> functionLoadReplace(String str);

    Response<String> functionRestore(byte[] bArr);

    Response<String> functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy);

    Response<FunctionStats> functionStats();
}

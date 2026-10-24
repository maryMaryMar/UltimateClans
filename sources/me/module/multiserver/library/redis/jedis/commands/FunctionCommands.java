package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.FunctionRestorePolicy;
import me.module.multiserver.library.redis.jedis.resps.FunctionStats;
import me.module.multiserver.library.redis.jedis.resps.LibraryInfo;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/FunctionCommands.class */
public interface FunctionCommands {
    Object fcall(String str, List<String> list, List<String> list2);

    Object fcallReadonly(String str, List<String> list, List<String> list2);

    String functionDelete(String str);

    byte[] functionDump();

    String functionFlush();

    String functionFlush(FlushMode flushMode);

    String functionKill();

    List<LibraryInfo> functionList();

    List<LibraryInfo> functionList(String str);

    List<LibraryInfo> functionListWithCode();

    List<LibraryInfo> functionListWithCode(String str);

    String functionLoad(String str);

    String functionLoadReplace(String str);

    String functionRestore(byte[] bArr);

    String functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy);

    FunctionStats functionStats();
}

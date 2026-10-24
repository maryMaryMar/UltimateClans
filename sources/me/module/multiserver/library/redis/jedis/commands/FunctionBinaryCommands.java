package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.FunctionRestorePolicy;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/FunctionBinaryCommands.class */
public interface FunctionBinaryCommands {
    Object fcall(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object fcallReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    String functionDelete(byte[] bArr);

    byte[] functionDump();

    String functionFlush();

    String functionFlush(FlushMode flushMode);

    String functionKill();

    List<Object> functionListBinary();

    List<Object> functionList(byte[] bArr);

    List<Object> functionListWithCodeBinary();

    List<Object> functionListWithCode(byte[] bArr);

    String functionLoad(byte[] bArr);

    String functionLoadReplace(byte[] bArr);

    String functionRestore(byte[] bArr);

    String functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy);

    Object functionStatsBinary();
}

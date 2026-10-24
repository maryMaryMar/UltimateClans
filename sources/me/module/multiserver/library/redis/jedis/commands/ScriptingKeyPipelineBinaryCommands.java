package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ScriptingKeyPipelineBinaryCommands.class */
public interface ScriptingKeyPipelineBinaryCommands {
    Response<Object> eval(byte[] bArr);

    Response<Object> eval(byte[] bArr, int i, byte[]... bArr2);

    Response<Object> eval(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Response<Object> evalReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Response<Object> evalsha(byte[] bArr);

    Response<Object> evalsha(byte[] bArr, int i, byte[]... bArr2);

    Response<Object> evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Response<Object> evalshaReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2);
}

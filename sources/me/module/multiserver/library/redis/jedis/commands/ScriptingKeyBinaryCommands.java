package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ScriptingKeyBinaryCommands.class */
public interface ScriptingKeyBinaryCommands {
    Object eval(byte[] bArr);

    Object eval(byte[] bArr, int i, byte[]... bArr2);

    Object eval(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object evalReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object evalsha(byte[] bArr);

    Object evalsha(byte[] bArr, int i, byte[]... bArr2);

    Object evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object evalshaReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2);
}

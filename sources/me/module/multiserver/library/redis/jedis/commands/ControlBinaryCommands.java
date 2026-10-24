package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ControlBinaryCommands.class */
public interface ControlBinaryCommands extends AccessControlLogBinaryCommands, ClientBinaryCommands {
    List<Object> roleBinary();

    Long objectRefcount(byte[] bArr);

    byte[] objectEncoding(byte[] bArr);

    Long objectIdletime(byte[] bArr);

    List<byte[]> objectHelpBinary();

    Long objectFreq(byte[] bArr);

    byte[] memoryDoctorBinary();

    Long memoryUsage(byte[] bArr);

    Long memoryUsage(byte[] bArr, int i);
}

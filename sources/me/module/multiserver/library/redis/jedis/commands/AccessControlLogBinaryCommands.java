package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.resps.AccessControlUser;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/AccessControlLogBinaryCommands.class */
public interface AccessControlLogBinaryCommands {
    byte[] aclWhoAmIBinary();

    byte[] aclGenPassBinary();

    byte[] aclGenPassBinary(int i);

    List<byte[]> aclListBinary();

    List<byte[]> aclUsersBinary();

    AccessControlUser aclGetUser(byte[] bArr);

    String aclSetUser(byte[] bArr);

    String aclSetUser(byte[] bArr, byte[]... bArr2);

    long aclDelUser(byte[] bArr);

    long aclDelUser(byte[] bArr, byte[]... bArr2);

    List<byte[]> aclCatBinary();

    List<byte[]> aclCat(byte[] bArr);

    List<byte[]> aclLogBinary();

    List<byte[]> aclLogBinary(int i);

    String aclLogReset();

    String aclLoad();

    String aclSave();

    byte[] aclDryRunBinary(byte[] bArr, byte[] bArr2, byte[]... bArr3);

    byte[] aclDryRunBinary(byte[] bArr, CommandArguments commandArguments);
}

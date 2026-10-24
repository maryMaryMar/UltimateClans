package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/DatabaseCommands.class */
public interface DatabaseCommands {
    String select(int i);

    long dbSize();

    String flushDB(FlushMode flushMode);

    String swapDB(int i, int i2);

    long move(String str, int i);

    long move(byte[] bArr, int i);

    boolean copy(String str, String str2, int i, boolean z);

    boolean copy(byte[] bArr, byte[] bArr2, int i, boolean z);

    String migrate(String str, int i, String str2, int i2, int i3);

    String migrate(String str, int i, byte[] bArr, int i2, int i3);

    String migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, String... strArr);

    String migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, byte[]... bArr);
}

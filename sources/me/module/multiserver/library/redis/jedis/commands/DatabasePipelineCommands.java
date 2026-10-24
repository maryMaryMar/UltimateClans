package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/DatabasePipelineCommands.class */
public interface DatabasePipelineCommands {
    Response<String> select(int i);

    Response<Long> dbSize();

    Response<String> swapDB(int i, int i2);

    Response<Long> move(String str, int i);

    Response<Long> move(byte[] bArr, int i);

    Response<Boolean> copy(String str, String str2, int i, boolean z);

    Response<Boolean> copy(byte[] bArr, byte[] bArr2, int i, boolean z);

    Response<String> migrate(String str, int i, byte[] bArr, int i2, int i3);

    Response<String> migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, byte[]... bArr);

    Response<String> migrate(String str, int i, String str2, int i2, int i3);

    Response<String> migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, String... strArr);
}

package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.FlushMode;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ScriptingControlCommands.class */
public interface ScriptingControlCommands {
    Boolean scriptExists(String str);

    List<Boolean> scriptExists(String... strArr);

    Boolean scriptExists(byte[] bArr);

    List<Boolean> scriptExists(byte[]... bArr);

    String scriptLoad(String str);

    byte[] scriptLoad(byte[] bArr);

    String scriptFlush();

    String scriptFlush(FlushMode flushMode);

    String scriptKill();
}

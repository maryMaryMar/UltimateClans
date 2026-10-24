package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.FlushMode;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SampleKeyedCommands.class */
public interface SampleKeyedCommands {
    long waitReplicas(String str, int i, long j);

    Object eval(String str, String str2);

    Object evalsha(String str, String str2);

    Boolean scriptExists(String str, String str2);

    List<Boolean> scriptExists(String str, String... strArr);

    String scriptLoad(String str, String str2);

    String scriptFlush(String str);

    String scriptFlush(String str, FlushMode flushMode);

    String scriptKill(String str);
}

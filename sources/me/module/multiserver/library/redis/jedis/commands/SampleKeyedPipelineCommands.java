package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.FlushMode;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SampleKeyedPipelineCommands.class */
public interface SampleKeyedPipelineCommands {
    Response<Long> waitReplicas(String str, int i, long j);

    Response<Object> eval(String str, String str2);

    Response<Object> evalsha(String str, String str2);

    Response<List<Boolean>> scriptExists(String str, String... strArr);

    Response<String> scriptLoad(String str, String str2);

    Response<String> scriptFlush(String str);

    Response<String> scriptFlush(String str, FlushMode flushMode);

    Response<String> scriptKill(String str);
}

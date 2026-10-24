package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/CountMinSketchPipelineCommands.class */
public interface CountMinSketchPipelineCommands {
    Response<String> cmsInitByDim(String str, long j, long j2);

    Response<String> cmsInitByProb(String str, double d, double d2);

    Response<List<Long>> cmsIncrBy(String str, Map<String, Long> map);

    Response<List<Long>> cmsQuery(String str, String... strArr);

    Response<String> cmsMerge(String str, String... strArr);

    Response<String> cmsMerge(String str, Map<String, Long> map);

    Response<Map<String, Object>> cmsInfo(String str);
}

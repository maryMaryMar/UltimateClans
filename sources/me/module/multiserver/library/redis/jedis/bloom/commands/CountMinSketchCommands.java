package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/CountMinSketchCommands.class */
public interface CountMinSketchCommands {
    String cmsInitByDim(String str, long j, long j2);

    String cmsInitByProb(String str, double d, double d2);

    default long cmsIncrBy(String str, String str2, long j) {
        return cmsIncrBy(str, Collections.singletonMap(str2, Long.valueOf(j))).get(0).longValue();
    }

    List<Long> cmsIncrBy(String str, Map<String, Long> map);

    List<Long> cmsQuery(String str, String... strArr);

    String cmsMerge(String str, String... strArr);

    String cmsMerge(String str, Map<String, Long> map);

    Map<String, Object> cmsInfo(String str);
}

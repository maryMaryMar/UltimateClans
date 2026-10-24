package me.module.multiserver.library.redis.jedis.graph;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/RedisGraphPipelineCommands.class */
public interface RedisGraphPipelineCommands {
    Response<ResultSet> graphQuery(String str, String str2);

    Response<ResultSet> graphReadonlyQuery(String str, String str2);

    Response<ResultSet> graphQuery(String str, String str2, long j);

    Response<ResultSet> graphReadonlyQuery(String str, String str2, long j);

    Response<ResultSet> graphQuery(String str, String str2, Map<String, Object> map);

    Response<ResultSet> graphReadonlyQuery(String str, String str2, Map<String, Object> map);

    Response<ResultSet> graphQuery(String str, String str2, Map<String, Object> map, long j);

    Response<ResultSet> graphReadonlyQuery(String str, String str2, Map<String, Object> map, long j);

    Response<String> graphDelete(String str);

    Response<List<String>> graphProfile(String str, String str2);
}

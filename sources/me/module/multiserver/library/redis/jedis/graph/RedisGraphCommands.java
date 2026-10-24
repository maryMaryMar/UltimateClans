package me.module.multiserver.library.redis.jedis.graph;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/RedisGraphCommands.class */
public interface RedisGraphCommands {
    ResultSet graphQuery(String str, String str2);

    ResultSet graphReadonlyQuery(String str, String str2);

    ResultSet graphQuery(String str, String str2, long j);

    ResultSet graphReadonlyQuery(String str, String str2, long j);

    ResultSet graphQuery(String str, String str2, Map<String, Object> map);

    ResultSet graphReadonlyQuery(String str, String str2, Map<String, Object> map);

    ResultSet graphQuery(String str, String str2, Map<String, Object> map, long j);

    ResultSet graphReadonlyQuery(String str, String str2, Map<String, Object> map, long j);

    String graphDelete(String str);

    List<String> graphList();

    List<String> graphProfile(String str, String str2);

    List<String> graphExplain(String str, String str2);

    List<List<String>> graphSlowlog(String str);

    String graphConfigSet(String str, Object obj);

    Map<String, Object> graphConfigGet(String str);
}

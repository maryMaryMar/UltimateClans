package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.ListDirection;
import me.module.multiserver.library.redis.jedis.args.ListPosition;
import me.module.multiserver.library.redis.jedis.params.LPosParams;
import me.module.multiserver.library.redis.jedis.resps.KeyedListElement;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ListPipelineCommands.class */
public interface ListPipelineCommands {
    Response<Long> rpush(String str, String... strArr);

    Response<Long> lpush(String str, String... strArr);

    Response<Long> llen(String str);

    Response<List<String>> lrange(String str, long j, long j2);

    Response<String> ltrim(String str, long j, long j2);

    Response<String> lindex(String str, long j);

    Response<String> lset(String str, long j, String str2);

    Response<Long> lrem(String str, long j, String str2);

    Response<String> lpop(String str);

    Response<List<String>> lpop(String str, int i);

    Response<Long> lpos(String str, String str2);

    Response<Long> lpos(String str, String str2, LPosParams lPosParams);

    Response<List<Long>> lpos(String str, String str2, LPosParams lPosParams, long j);

    Response<String> rpop(String str);

    Response<List<String>> rpop(String str, int i);

    Response<Long> linsert(String str, ListPosition listPosition, String str2, String str3);

    Response<Long> lpushx(String str, String... strArr);

    Response<Long> rpushx(String str, String... strArr);

    Response<List<String>> blpop(int i, String str);

    Response<KeyedListElement> blpop(double d, String str);

    Response<List<String>> brpop(int i, String str);

    Response<KeyedListElement> brpop(double d, String str);

    Response<List<String>> blpop(int i, String... strArr);

    Response<KeyedListElement> blpop(double d, String... strArr);

    Response<List<String>> brpop(int i, String... strArr);

    Response<KeyedListElement> brpop(double d, String... strArr);

    Response<String> rpoplpush(String str, String str2);

    Response<String> brpoplpush(String str, String str2, int i);

    Response<String> lmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2);

    Response<String> blmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2, double d);

    Response<KeyValue<String, List<String>>> lmpop(ListDirection listDirection, String... strArr);

    Response<KeyValue<String, List<String>>> lmpop(ListDirection listDirection, int i, String... strArr);

    Response<KeyValue<String, List<String>>> blmpop(long j, ListDirection listDirection, String... strArr);

    Response<KeyValue<String, List<String>>> blmpop(long j, ListDirection listDirection, int i, String... strArr);
}

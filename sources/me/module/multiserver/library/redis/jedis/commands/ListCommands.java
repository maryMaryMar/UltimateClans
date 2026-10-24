package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.ListDirection;
import me.module.multiserver.library.redis.jedis.args.ListPosition;
import me.module.multiserver.library.redis.jedis.params.LPosParams;
import me.module.multiserver.library.redis.jedis.resps.KeyedListElement;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ListCommands.class */
public interface ListCommands {
    long rpush(String str, String... strArr);

    long lpush(String str, String... strArr);

    long llen(String str);

    List<String> lrange(String str, long j, long j2);

    String ltrim(String str, long j, long j2);

    String lindex(String str, long j);

    String lset(String str, long j, String str2);

    long lrem(String str, long j, String str2);

    String lpop(String str);

    List<String> lpop(String str, int i);

    Long lpos(String str, String str2);

    Long lpos(String str, String str2, LPosParams lPosParams);

    List<Long> lpos(String str, String str2, LPosParams lPosParams, long j);

    String rpop(String str);

    List<String> rpop(String str, int i);

    long linsert(String str, ListPosition listPosition, String str2, String str3);

    long lpushx(String str, String... strArr);

    long rpushx(String str, String... strArr);

    List<String> blpop(int i, String... strArr);

    List<String> blpop(int i, String str);

    KeyedListElement blpop(double d, String... strArr);

    KeyedListElement blpop(double d, String str);

    List<String> brpop(int i, String... strArr);

    List<String> brpop(int i, String str);

    KeyedListElement brpop(double d, String... strArr);

    KeyedListElement brpop(double d, String str);

    String rpoplpush(String str, String str2);

    String brpoplpush(String str, String str2, int i);

    String lmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2);

    String blmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2, double d);

    KeyValue<String, List<String>> lmpop(ListDirection listDirection, String... strArr);

    KeyValue<String, List<String>> lmpop(ListDirection listDirection, int i, String... strArr);

    KeyValue<String, List<String>> blmpop(long j, ListDirection listDirection, String... strArr);

    KeyValue<String, List<String>> blmpop(long j, ListDirection listDirection, int i, String... strArr);
}

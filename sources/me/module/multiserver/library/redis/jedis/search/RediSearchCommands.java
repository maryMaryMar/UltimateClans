package me.module.multiserver.library.redis.jedis.search;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationBuilder;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationResult;
import me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/RediSearchCommands.class */
public interface RediSearchCommands {
    String ftCreate(String str, IndexOptions indexOptions, Schema schema);

    default String ftCreate(String str, SchemaField... schemaFieldArr) {
        return ftCreate(str, Arrays.asList(schemaFieldArr));
    }

    default String ftCreate(String str, FTCreateParams fTCreateParams, SchemaField... schemaFieldArr) {
        return ftCreate(str, fTCreateParams, Arrays.asList(schemaFieldArr));
    }

    default String ftCreate(String str, Iterable<SchemaField> iterable) {
        return ftCreate(str, FTCreateParams.createParams(), iterable);
    }

    String ftCreate(String str, FTCreateParams fTCreateParams, Iterable<SchemaField> iterable);

    default String ftAlter(String str, Schema.Field... fieldArr) {
        return ftAlter(str, Schema.from(fieldArr));
    }

    String ftAlter(String str, Schema schema);

    default String ftAlter(String str, SchemaField... schemaFieldArr) {
        return ftAlter(str, Arrays.asList(schemaFieldArr));
    }

    String ftAlter(String str, Iterable<SchemaField> iterable);

    default SearchResult ftSearch(String str) {
        return ftSearch(str, Marker.ANY_MARKER);
    }

    SearchResult ftSearch(String str, String str2);

    SearchResult ftSearch(String str, String str2, FTSearchParams fTSearchParams);

    SearchResult ftSearch(String str, Query query);

    SearchResult ftSearch(byte[] bArr, Query query);

    String ftExplain(String str, Query query);

    List<String> ftExplainCLI(String str, Query query);

    AggregationResult ftAggregate(String str, AggregationBuilder aggregationBuilder);

    AggregationResult ftCursorRead(String str, long j, int i);

    String ftCursorDel(String str, long j);

    String ftDropIndex(String str);

    String ftDropIndexDD(String str);

    String ftSynUpdate(String str, String str2, String... strArr);

    Map<String, List<String>> ftSynDump(String str);

    long ftDictAdd(String str, String... strArr);

    long ftDictDel(String str, String... strArr);

    Set<String> ftDictDump(String str);

    long ftDictAddBySampleKey(String str, String str2, String... strArr);

    long ftDictDelBySampleKey(String str, String str2, String... strArr);

    Set<String> ftDictDumpBySampleKey(String str, String str2);

    Map<String, Object> ftInfo(String str);

    Set<String> ftTagVals(String str, String str2);

    String ftAliasAdd(String str, String str2);

    String ftAliasUpdate(String str, String str2);

    String ftAliasDel(String str);

    Map<String, String> ftConfigGet(String str);

    Map<String, String> ftConfigGet(String str, String str2);

    String ftConfigSet(String str, String str2);

    String ftConfigSet(String str, String str2, String str3);

    long ftSugAdd(String str, String str2, double d);

    long ftSugAddIncr(String str, String str2, double d);

    List<String> ftSugGet(String str, String str2);

    List<String> ftSugGet(String str, String str2, boolean z, int i);

    List<Tuple> ftSugGetWithScores(String str, String str2);

    List<Tuple> ftSugGetWithScores(String str, String str2, boolean z, int i);

    boolean ftSugDel(String str, String str2);

    long ftSugLen(String str);
}

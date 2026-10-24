package me.module.multiserver.library.redis.jedis.search;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationBuilder;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationResult;
import me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/RediSearchPipelineCommands.class */
public interface RediSearchPipelineCommands {
    Response<String> ftCreate(String str, IndexOptions indexOptions, Schema schema);

    default Response<String> ftCreate(String str, SchemaField... schemaFieldArr) {
        return ftCreate(str, Arrays.asList(schemaFieldArr));
    }

    default Response<String> ftCreate(String str, FTCreateParams fTCreateParams, SchemaField... schemaFieldArr) {
        return ftCreate(str, fTCreateParams, Arrays.asList(schemaFieldArr));
    }

    default Response<String> ftCreate(String str, Iterable<SchemaField> iterable) {
        return ftCreate(str, FTCreateParams.createParams(), iterable);
    }

    Response<String> ftCreate(String str, FTCreateParams fTCreateParams, Iterable<SchemaField> iterable);

    default Response<String> ftAlter(String str, Schema.Field... fieldArr) {
        return ftAlter(str, Schema.from(fieldArr));
    }

    Response<String> ftAlter(String str, Schema schema);

    default Response<String> ftAlter(String str, SchemaField... schemaFieldArr) {
        return ftAlter(str, Arrays.asList(schemaFieldArr));
    }

    Response<String> ftAlter(String str, Iterable<SchemaField> iterable);

    default Response<SearchResult> ftSearch(String str) {
        return ftSearch(str, Marker.ANY_MARKER);
    }

    Response<SearchResult> ftSearch(String str, String str2);

    Response<SearchResult> ftSearch(String str, String str2, FTSearchParams fTSearchParams);

    Response<SearchResult> ftSearch(String str, Query query);

    Response<SearchResult> ftSearch(byte[] bArr, Query query);

    Response<String> ftExplain(String str, Query query);

    Response<List<String>> ftExplainCLI(String str, Query query);

    Response<AggregationResult> ftAggregate(String str, AggregationBuilder aggregationBuilder);

    Response<AggregationResult> ftCursorRead(String str, long j, int i);

    Response<String> ftCursorDel(String str, long j);

    Response<String> ftDropIndex(String str);

    Response<String> ftDropIndexDD(String str);

    Response<String> ftSynUpdate(String str, String str2, String... strArr);

    Response<Map<String, List<String>>> ftSynDump(String str);

    Response<Long> ftDictAdd(String str, String... strArr);

    Response<Long> ftDictDel(String str, String... strArr);

    Response<Set<String>> ftDictDump(String str);

    Response<Long> ftDictAddBySampleKey(String str, String str2, String... strArr);

    Response<Long> ftDictDelBySampleKey(String str, String str2, String... strArr);

    Response<Set<String>> ftDictDumpBySampleKey(String str, String str2);

    Response<Map<String, Object>> ftInfo(String str);

    Response<Set<String>> ftTagVals(String str, String str2);

    Response<String> ftAliasAdd(String str, String str2);

    Response<String> ftAliasUpdate(String str, String str2);

    Response<String> ftAliasDel(String str);

    Response<Map<String, String>> ftConfigGet(String str);

    Response<Map<String, String>> ftConfigGet(String str, String str2);

    Response<String> ftConfigSet(String str, String str2);

    Response<String> ftConfigSet(String str, String str2, String str3);

    Response<Long> ftSugAdd(String str, String str2, double d);

    Response<Long> ftSugAddIncr(String str, String str2, double d);

    Response<List<String>> ftSugGet(String str, String str2);

    Response<List<String>> ftSugGet(String str, String str2, boolean z, int i);

    Response<List<Tuple>> ftSugGetWithScores(String str, String str2);

    Response<List<Tuple>> ftSugGetWithScores(String str, String str2, boolean z, int i);

    Response<Boolean> ftSugDel(String str, String str2);

    Response<Long> ftSugLen(String str);
}

package me.module.multiserver.library.redis.jedis.json;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import org.json.JSONArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/RedisJsonPipelineCommands.class */
public interface RedisJsonPipelineCommands {
    default Response<String> jsonSet(String str, Object obj) {
        return jsonSet(str, Path2.ROOT_PATH, obj);
    }

    default Response<String> jsonSetWithEscape(String str, Object obj) {
        return jsonSetWithEscape(str, Path2.ROOT_PATH, obj);
    }

    default Response<String> jsonSetLegacy(String str, Object obj) {
        return jsonSet(str, Path.ROOT_PATH, obj);
    }

    default Response<String> jsonSet(String str, Object obj, JsonSetParams jsonSetParams) {
        return jsonSet(str, Path2.ROOT_PATH, obj, jsonSetParams);
    }

    default Response<String> jsonSetWithEscape(String str, Object obj, JsonSetParams jsonSetParams) {
        return jsonSetWithEscape(str, Path2.ROOT_PATH, obj, jsonSetParams);
    }

    default Response<String> jsonSetLegacy(String str, Object obj, JsonSetParams jsonSetParams) {
        return jsonSet(str, Path.ROOT_PATH, obj, jsonSetParams);
    }

    Response<String> jsonSet(String str, Path2 path2, Object obj);

    Response<String> jsonSetWithEscape(String str, Path2 path2, Object obj);

    Response<String> jsonSet(String str, Path path, Object obj);

    Response<String> jsonSet(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams);

    Response<String> jsonSetWithEscape(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams);

    Response<String> jsonSet(String str, Path path, Object obj, JsonSetParams jsonSetParams);

    Response<Object> jsonGet(String str);

    <T> Response<T> jsonGet(String str, Class<T> cls);

    Response<Object> jsonGet(String str, Path2... path2Arr);

    Response<Object> jsonGet(String str, Path... pathArr);

    <T> Response<T> jsonGet(String str, Class<T> cls, Path... pathArr);

    default Response<List<JSONArray>> jsonMGet(String... strArr) {
        return jsonMGet(Path2.ROOT_PATH, strArr);
    }

    default <T> Response<List<T>> jsonMGet(Class<T> cls, String... strArr) {
        return jsonMGet(Path.ROOT_PATH, cls, strArr);
    }

    Response<List<JSONArray>> jsonMGet(Path2 path2, String... strArr);

    <T> Response<List<T>> jsonMGet(Path path, Class<T> cls, String... strArr);

    Response<Long> jsonDel(String str);

    Response<Long> jsonDel(String str, Path2 path2);

    Response<Long> jsonDel(String str, Path path);

    Response<Long> jsonClear(String str);

    Response<Long> jsonClear(String str, Path2 path2);

    Response<Long> jsonClear(String str, Path path);

    Response<List<Boolean>> jsonToggle(String str, Path2 path2);

    Response<String> jsonToggle(String str, Path path);

    Response<Class<?>> jsonType(String str);

    Response<List<Class<?>>> jsonType(String str, Path2 path2);

    Response<Class<?>> jsonType(String str, Path path);

    Response<Long> jsonStrAppend(String str, Object obj);

    Response<List<Long>> jsonStrAppend(String str, Path2 path2, Object obj);

    Response<Long> jsonStrAppend(String str, Path path, Object obj);

    Response<Long> jsonStrLen(String str);

    Response<List<Long>> jsonStrLen(String str, Path2 path2);

    Response<Long> jsonStrLen(String str, Path path);

    Response<JSONArray> jsonNumIncrBy(String str, Path2 path2, double d);

    Response<Double> jsonNumIncrBy(String str, Path path, double d);

    Response<List<Long>> jsonArrAppend(String str, Path2 path2, Object... objArr);

    Response<List<Long>> jsonArrAppendWithEscape(String str, Path2 path2, Object... objArr);

    Response<Long> jsonArrAppend(String str, Path path, Object... objArr);

    Response<List<Long>> jsonArrIndex(String str, Path2 path2, Object obj);

    Response<List<Long>> jsonArrIndexWithEscape(String str, Path2 path2, Object obj);

    Response<Long> jsonArrIndex(String str, Path path, Object obj);

    Response<List<Long>> jsonArrInsert(String str, Path2 path2, int i, Object... objArr);

    Response<List<Long>> jsonArrInsertWithEscape(String str, Path2 path2, int i, Object... objArr);

    Response<Long> jsonArrInsert(String str, Path path, int i, Object... objArr);

    Response<Object> jsonArrPop(String str);

    <T> Response<T> jsonArrPop(String str, Class<T> cls);

    Response<List<Object>> jsonArrPop(String str, Path2 path2);

    Response<Object> jsonArrPop(String str, Path path);

    <T> Response<T> jsonArrPop(String str, Class<T> cls, Path path);

    Response<List<Object>> jsonArrPop(String str, Path2 path2, int i);

    Response<Object> jsonArrPop(String str, Path path, int i);

    <T> Response<T> jsonArrPop(String str, Class<T> cls, Path path, int i);

    Response<Long> jsonArrLen(String str);

    Response<List<Long>> jsonArrLen(String str, Path2 path2);

    Response<Long> jsonArrLen(String str, Path path);

    Response<List<Long>> jsonArrTrim(String str, Path2 path2, int i, int i2);

    Response<Long> jsonArrTrim(String str, Path path, int i, int i2);
}

package me.module.multiserver.library.redis.jedis.json;

import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/RedisJsonCommands.class */
public interface RedisJsonCommands {
    default String jsonSet(String str, Object obj) {
        return jsonSet(str, Path2.ROOT_PATH, obj);
    }

    default String jsonSetWithEscape(String str, Object obj) {
        return jsonSetWithEscape(str, Path2.ROOT_PATH, obj);
    }

    default String jsonSetLegacy(String str, Object obj) {
        return jsonSet(str, Path.ROOT_PATH, obj);
    }

    default String jsonSet(String str, Object obj, JsonSetParams jsonSetParams) {
        return jsonSet(str, Path2.ROOT_PATH, obj, jsonSetParams);
    }

    default String jsonSetWithEscape(String str, Object obj, JsonSetParams jsonSetParams) {
        return jsonSetWithEscape(str, Path2.ROOT_PATH, obj, jsonSetParams);
    }

    default String jsonSetLegacy(String str, Object obj, JsonSetParams jsonSetParams) {
        return jsonSet(str, Path.ROOT_PATH, obj, jsonSetParams);
    }

    String jsonSet(String str, Path2 path2, Object obj);

    String jsonSetWithEscape(String str, Path2 path2, Object obj);

    String jsonSet(String str, Path path, Object obj);

    String jsonSetWithPlainString(String str, Path path, String str2);

    String jsonSet(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams);

    String jsonSetWithEscape(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams);

    String jsonSet(String str, Path path, Object obj, JsonSetParams jsonSetParams);

    Object jsonGet(String str);

    <T> T jsonGet(String str, Class<T> cls);

    Object jsonGet(String str, Path2... path2Arr);

    Object jsonGet(String str, Path... pathArr);

    String jsonGetAsPlainString(String str, Path path);

    <T> T jsonGet(String str, Class<T> cls, Path... pathArr);

    default List<JSONArray> jsonMGet(String... strArr) {
        return jsonMGet(Path2.ROOT_PATH, strArr);
    }

    default <T> List<T> jsonMGet(Class<T> cls, String... strArr) {
        return jsonMGet(Path.ROOT_PATH, cls, strArr);
    }

    List<JSONArray> jsonMGet(Path2 path2, String... strArr);

    <T> List<T> jsonMGet(Path path, Class<T> cls, String... strArr);

    long jsonDel(String str);

    long jsonDel(String str, Path2 path2);

    long jsonDel(String str, Path path);

    long jsonClear(String str);

    long jsonClear(String str, Path2 path2);

    long jsonClear(String str, Path path);

    List<Boolean> jsonToggle(String str, Path2 path2);

    String jsonToggle(String str, Path path);

    Class<?> jsonType(String str);

    List<Class<?>> jsonType(String str, Path2 path2);

    Class<?> jsonType(String str, Path path);

    long jsonStrAppend(String str, Object obj);

    List<Long> jsonStrAppend(String str, Path2 path2, Object obj);

    long jsonStrAppend(String str, Path path, Object obj);

    Long jsonStrLen(String str);

    List<Long> jsonStrLen(String str, Path2 path2);

    Long jsonStrLen(String str, Path path);

    JSONArray jsonNumIncrBy(String str, Path2 path2, double d);

    double jsonNumIncrBy(String str, Path path, double d);

    List<Long> jsonArrAppend(String str, Path2 path2, Object... objArr);

    List<Long> jsonArrAppendWithEscape(String str, Path2 path2, Object... objArr);

    Long jsonArrAppend(String str, Path path, Object... objArr);

    List<Long> jsonArrIndex(String str, Path2 path2, Object obj);

    List<Long> jsonArrIndexWithEscape(String str, Path2 path2, Object obj);

    long jsonArrIndex(String str, Path path, Object obj);

    List<Long> jsonArrInsert(String str, Path2 path2, int i, Object... objArr);

    List<Long> jsonArrInsertWithEscape(String str, Path2 path2, int i, Object... objArr);

    long jsonArrInsert(String str, Path path, int i, Object... objArr);

    Object jsonArrPop(String str);

    <T> T jsonArrPop(String str, Class<T> cls);

    List<Object> jsonArrPop(String str, Path2 path2);

    Object jsonArrPop(String str, Path path);

    <T> T jsonArrPop(String str, Class<T> cls, Path path);

    List<Object> jsonArrPop(String str, Path2 path2, int i);

    Object jsonArrPop(String str, Path path, int i);

    <T> T jsonArrPop(String str, Class<T> cls, Path path, int i);

    Long jsonArrLen(String str);

    List<Long> jsonArrLen(String str, Path2 path2);

    Long jsonArrLen(String str, Path path);

    List<Long> jsonArrTrim(String str, Path2 path2, int i, int i2);

    Long jsonArrTrim(String str, Path path, int i, int i2);

    Long jsonObjLen(String str);

    Long jsonObjLen(String str, Path path);

    List<Long> jsonObjLen(String str, Path2 path2);

    List<String> jsonObjKeys(String str);

    List<String> jsonObjKeys(String str, Path path);

    List<List<String>> jsonObjKeys(String str, Path2 path2);

    long jsonDebugMemory(String str);

    long jsonDebugMemory(String str, Path path);

    List<Long> jsonDebugMemory(String str, Path2 path2);

    List<Object> jsonResp(String str);

    List<Object> jsonResp(String str, Path path);

    List<List<Object>> jsonResp(String str, Path2 path2);
}

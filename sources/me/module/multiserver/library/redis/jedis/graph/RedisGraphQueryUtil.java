package me.module.multiserver.library.redis.jedis.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/RedisGraphQueryUtil.class */
public class RedisGraphQueryUtil {
    public static final List<String> DUMMY_LIST = Collections.emptyList();
    public static final Map<String, List<String>> DUMMY_MAP = Collections.emptyMap();
    public static final String COMPACT_STRING = "--COMPACT";
    public static final String TIMEOUT_STRING = "TIMEOUT";

    private RedisGraphQueryUtil() {
    }

    public static String prepareQuery(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("CYPHER ");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey()).append('=').append(valueToString(entry.getValue())).append(' ');
        }
        sb.append(str);
        return sb.toString();
    }

    private static String valueToString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return quoteString((String) obj);
        }
        if (obj instanceof Character) {
            return quoteString(((Character) obj).toString());
        }
        if (obj instanceof Object[]) {
            return arrayToString((Object[]) obj);
        }
        return obj instanceof List ? arrayToString((List<Object>) obj) : obj.toString();
    }

    private static String quoteString(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append('\"');
        sb.append(str.replace("\"", "\\\""));
        sb.append('\"');
        return sb.toString();
    }

    private static String arrayToString(Object[] objArr) {
        return arrayToString((List<Object>) Arrays.asList(objArr));
    }

    private static String arrayToString(List<Object> list) {
        StringBuilder sbAppend = new StringBuilder().append('[');
        sbAppend.append(String.join(", ", (Iterable<? extends CharSequence>) list.stream().map(RedisGraphQueryUtil::valueToString).collect(Collectors.toList())));
        sbAppend.append(']');
        return sbAppend.toString();
    }
}

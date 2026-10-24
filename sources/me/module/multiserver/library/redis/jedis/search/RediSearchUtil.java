package me.module.multiserver.library.redis.jedis.search;

import java.util.HashMap;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.GeoCoordinate;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/RediSearchUtil.class */
public class RediSearchUtil {
    public static Map<String, String> toStringMap(Map<String, Object> map) {
        String string;
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key == null || value == null) {
                throw new NullPointerException("A null argument cannot be sent to Redis.");
            }
            if (value instanceof byte[]) {
                string = SafeEncoder.encode((byte[]) value);
            } else if (value instanceof GeoCoordinate) {
                GeoCoordinate geoCoordinate = (GeoCoordinate) value;
                string = geoCoordinate.getLongitude() + "," + geoCoordinate.getLatitude();
            } else {
                string = value instanceof String ? (String) value : value.toString();
            }
            map2.put(key, string);
        }
        return map2;
    }

    private RediSearchUtil() {
        throw new InstantiationError("Must not instantiate this class");
    }
}

package me.module.multiserver.library.redis.jedis.resps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/FunctionStats.class */
public class FunctionStats {
    private final Map<String, Object> runningScript;
    private final Map<String, Map<String, Object>> engines;
    public static final Builder<FunctionStats> FUNCTION_STATS_BUILDER = new Builder<FunctionStats>() { // from class: me.module.multiserver.library.redis.jedis.resps.FunctionStats.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public FunctionStats build(Object obj) {
            List list = (List) obj;
            Map<String, Object> mapBuild = list.get(1) == null ? null : BuilderFactory.ENCODED_OBJECT_MAP.build(list.get(1));
            List list2 = (List) list.get(3);
            LinkedHashMap linkedHashMap = new LinkedHashMap(list2.size() / 2);
            for (int i = 0; i < list2.size(); i += 2) {
                linkedHashMap.put(BuilderFactory.STRING.build(list2.get(i)), BuilderFactory.ENCODED_OBJECT_MAP.build(list2.get(i + 1)));
            }
            return new FunctionStats(mapBuild, linkedHashMap);
        }
    };

    public FunctionStats(Map<String, Object> map, Map<String, Map<String, Object>> map2) {
        this.runningScript = map;
        this.engines = map2;
    }

    public Map<String, Object> getRunningScript() {
        return this.runningScript;
    }

    public Map<String, Map<String, Object>> getEngines() {
        return this.engines;
    }
}

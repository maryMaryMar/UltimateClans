package me.module.multiserver.library.redis.jedis.timeseries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;
import me.module.multiserver.library.redis.jedis.util.DoublePrecision;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSInfo.class */
public class TSInfo {
    private static final String DUPLICATE_POLICY_PROPERTY = "duplicatePolicy";
    private static final String LABELS_PROPERTY = "labels";
    private static final String RULES_PROPERTY = "rules";
    private static final String CHUNKS_PROPERTY = "Chunks";
    private static final String CHUNKS_BYTES_PER_SAMPLE_PROPERTY = "bytesPerSample";
    private final Map<String, Object> properties;
    private final Map<String, String> labels;
    private final Map<String, Rule> rules;
    private final List<Map<String, Object>> chunks;
    public static Builder<TSInfo> TIMESERIES_INFO = new Builder<TSInfo>() { // from class: me.module.multiserver.library.redis.jedis.timeseries.TSInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public TSInfo build(Object obj) {
            List list = (List) obj;
            HashMap map = new HashMap();
            Map<String, String> mapBuild = null;
            HashMap map2 = null;
            ArrayList arrayList = null;
            for (int i = 0; i < list.size(); i += 2) {
                String strEncode = SafeEncoder.encode((byte[]) list.get(i));
                Object objEncode = list.get(i + 1);
                if (objEncode instanceof List) {
                    switch (strEncode) {
                        case "labels":
                            mapBuild = BuilderFactory.STRING_MAP_FROM_PAIRS.build(objEncode);
                            objEncode = mapBuild;
                            break;
                        case "rules":
                            List list2 = (List) objEncode;
                            ArrayList arrayList2 = new ArrayList(list2.size());
                            map2 = new HashMap(list2.size());
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                List list3 = (List) SafeEncoder.encodeObject(it.next());
                                arrayList2.add(list3);
                                map2.put((String) list3.get(0), new Rule((String) list3.get(0), ((Long) list3.get(1)).longValue(), AggregationType.safeValueOf((String) list3.get(2)), ((Long) list3.get(3)).longValue()));
                            }
                            objEncode = arrayList2;
                            break;
                        case "Chunks":
                            List list4 = (List) objEncode;
                            ArrayList arrayList3 = new ArrayList(list4.size());
                            arrayList = new ArrayList(list4.size());
                            Iterator it2 = list4.iterator();
                            while (it2.hasNext()) {
                                Map<String, Object> mapBuild2 = BuilderFactory.ENCODED_OBJECT_MAP.build(it2.next());
                                arrayList3.add(new HashMap(mapBuild2));
                                if (mapBuild2.containsKey(TSInfo.CHUNKS_BYTES_PER_SAMPLE_PROPERTY)) {
                                    mapBuild2.put(TSInfo.CHUNKS_BYTES_PER_SAMPLE_PROPERTY, DoublePrecision.parseFloatingPointNumber((String) mapBuild2.get(TSInfo.CHUNKS_BYTES_PER_SAMPLE_PROPERTY)));
                                }
                                arrayList.add(mapBuild2);
                            }
                            objEncode = arrayList3;
                            break;
                        default:
                            objEncode = SafeEncoder.encodeObject(objEncode);
                            break;
                    }
                } else if (objEncode instanceof byte[]) {
                    objEncode = SafeEncoder.encode((byte[]) objEncode);
                    if (TSInfo.DUPLICATE_POLICY_PROPERTY.equals(strEncode)) {
                        try {
                            objEncode = DuplicatePolicy.valueOf(((String) objEncode).toUpperCase());
                        } catch (Exception e) {
                        }
                    }
                }
                map.put(strEncode, objEncode);
            }
            return new TSInfo(map, mapBuild, map2, arrayList);
        }
    };

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSInfo$Rule.class */
    public static class Rule {
        private final String compactionKey;
        private final long bucketDuration;
        private final AggregationType aggregator;
        private final long alignmentTimestamp;

        private Rule(String str, long j, AggregationType aggregationType, long j2) {
            this.compactionKey = str;
            this.bucketDuration = j;
            this.aggregator = aggregationType;
            this.alignmentTimestamp = j2;
        }

        public String getCompactionKey() {
            return this.compactionKey;
        }

        public long getBucketDuration() {
            return this.bucketDuration;
        }

        public AggregationType getAggregator() {
            return this.aggregator;
        }

        public long getAlignmentTimestamp() {
            return this.alignmentTimestamp;
        }
    }

    private TSInfo(Map<String, Object> map, Map<String, String> map2, Map<String, Rule> map3, List<Map<String, Object>> list) {
        this.properties = map;
        this.labels = map2;
        this.rules = map3;
        this.chunks = list;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public Object getProperty(String str) {
        return this.properties.get(str);
    }

    public Long getIntegerProperty(String str) {
        return (Long) this.properties.get(str);
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public String getLabel(String str) {
        return this.labels.get(str);
    }

    public Map<String, Rule> getRules() {
        return this.rules;
    }

    public Rule getRule(String str) {
        return this.rules.get(str);
    }

    public List<Map<String, Object>> getChunks() {
        return this.chunks;
    }
}

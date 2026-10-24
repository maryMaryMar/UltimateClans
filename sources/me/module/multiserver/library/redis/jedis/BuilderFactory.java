package me.module.multiserver.library.redis.jedis;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.resps.AccessControlLogEntry;
import me.module.multiserver.library.redis.jedis.resps.AccessControlUser;
import me.module.multiserver.library.redis.jedis.resps.CommandDocument;
import me.module.multiserver.library.redis.jedis.resps.CommandInfo;
import me.module.multiserver.library.redis.jedis.resps.GeoRadiusResponse;
import me.module.multiserver.library.redis.jedis.resps.KeyedListElement;
import me.module.multiserver.library.redis.jedis.resps.KeyedZSetElement;
import me.module.multiserver.library.redis.jedis.resps.LCSMatchResult;
import me.module.multiserver.library.redis.jedis.resps.LibraryInfo;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.resps.StreamConsumerFullInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamConsumersInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamFullInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamGroupFullInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamGroupInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingSummary;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationResult;
import me.module.multiserver.library.redis.jedis.timeseries.TSElement;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyValue;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyedElements;
import me.module.multiserver.library.redis.jedis.util.DoublePrecision;
import me.module.multiserver.library.redis.jedis.util.JedisByteHashMap;
import me.module.multiserver.library.redis.jedis.util.KeyValue;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/BuilderFactory.class */
public final class BuilderFactory {
    public static final Builder<Object> RAW_OBJECT = new Builder<Object>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.1
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Object build(Object obj) {
            return obj;
        }

        public String toString() {
            return "Object";
        }
    };
    public static final Builder<List<Object>> RAW_OBJECT_LIST = new Builder<List<Object>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Object> build(Object obj) {
            return (List) obj;
        }

        public String toString() {
            return "List<Object>";
        }
    };
    public static final Builder<Object> ENCODED_OBJECT = new Builder<Object>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.3
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Object build(Object obj) {
            return SafeEncoder.encodeObject(obj);
        }

        public String toString() {
            return "Object";
        }
    };
    public static final Builder<List<Object>> ENCODED_OBJECT_LIST = new Builder<List<Object>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Object> build(Object obj) {
            return (List) SafeEncoder.encodeObject(obj);
        }

        public String toString() {
            return "List<Object>";
        }
    };
    public static final Builder<Map<String, Object>> ENCODED_OBJECT_MAP = new Builder<Map<String, Object>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.5
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, Object> build(Object obj) {
            List list = (List) obj;
            HashMap map = new HashMap(list.size() / 2, 1.0f);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                map.put(BuilderFactory.STRING.build(it.next()), BuilderFactory.ENCODED_OBJECT.build(it.next()));
            }
            return map;
        }
    };
    public static final Builder<Long> LONG = new Builder<Long>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Long build(Object obj) {
            return (Long) obj;
        }

        public String toString() {
            return "Long";
        }
    };
    public static final Builder<List<Long>> LONG_LIST = new Builder<List<Long>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Long> build(Object obj) {
            if (null == obj) {
                return null;
            }
            return (List) obj;
        }

        public String toString() {
            return "List<Long>";
        }
    };
    public static final Builder<Double> DOUBLE = new Builder<Double>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.8
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Double build(Object obj) {
            return DoublePrecision.parseFloatingPointNumber(BuilderFactory.STRING.build(obj));
        }

        public String toString() {
            return "Double";
        }
    };
    public static final Builder<List<Double>> DOUBLE_LIST = new Builder<List<Double>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.9
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Double> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(BuilderFactory.DOUBLE.build((byte[]) it.next()));
            }
            return arrayList;
        }

        public String toString() {
            return "List<Double>";
        }
    };
    public static final Builder<Boolean> BOOLEAN = new Builder<Boolean>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.10
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Boolean build(Object obj) {
            if (obj == null) {
                return null;
            }
            return Boolean.valueOf(((Long) obj).longValue() == 1);
        }

        public String toString() {
            return "Boolean";
        }
    };
    public static final Builder<List<Boolean>> BOOLEAN_LIST = new Builder<List<Boolean>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.11
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Boolean> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List<Long> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Long l : list) {
                arrayList.add(l == null ? null : Boolean.valueOf(l.longValue() == 1));
            }
            return arrayList;
        }

        public String toString() {
            return "List<Boolean>";
        }
    };
    public static final Builder<List<Boolean>> BOOLEAN_WITH_ERROR_LIST = new Builder<List<Boolean>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.12
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Boolean> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj2 : list) {
                Boolean bool = null;
                if (obj2 != null && (obj2 instanceof Long)) {
                    long jLongValue = ((Long) obj2).longValue();
                    if (jLongValue == 1) {
                        bool = Boolean.TRUE;
                    } else if (jLongValue == 0) {
                        bool = Boolean.FALSE;
                    }
                }
                arrayList.add(bool);
            }
            return arrayList;
        }

        public String toString() {
            return "List<Boolean>";
        }
    };
    public static final Builder<byte[]> BYTE_ARRAY = new Builder<byte[]>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.13
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public byte[] build(Object obj) {
            return (byte[]) obj;
        }

        public String toString() {
            return "byte[]";
        }
    };
    public static final Builder<List<byte[]>> BYTE_ARRAY_LIST = new Builder<List<byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.14
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<byte[]> build(Object obj) {
            if (null == obj) {
                return null;
            }
            return (List) obj;
        }

        public String toString() {
            return "List<byte[]>";
        }
    };
    public static final Builder<byte[]> BINARY = new Builder<byte[]>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.15
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public byte[] build(Object obj) {
            return (byte[]) obj;
        }

        public String toString() {
            return "byte[]";
        }
    };
    public static final Builder<List<byte[]>> BINARY_LIST = new Builder<List<byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.16
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<byte[]> build(Object obj) {
            return (List) obj;
        }

        public String toString() {
            return "List<byte[]>";
        }
    };
    public static final Builder<Set<byte[]>> BINARY_SET = new Builder<Set<byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.17
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Set<byte[]> build(Object obj) {
            if (null == obj) {
                return null;
            }
            return SetFromList.of((List) BuilderFactory.BINARY_LIST.build(obj));
        }

        public String toString() {
            return "Set<byte[]>";
        }
    };
    public static final Builder<Map<byte[], byte[]>> BINARY_MAP = new Builder<Map<byte[], byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.18
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<byte[], byte[]> build(Object obj) {
            JedisByteHashMap jedisByteHashMap = new JedisByteHashMap();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                jedisByteHashMap.put(it.next(), it.next());
            }
            return jedisByteHashMap;
        }

        public String toString() {
            return "Map<byte[], byte[]>";
        }
    };
    public static final Builder<String> STRING = new Builder<String>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.19
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public String build(Object obj) {
            if (obj == null) {
                return null;
            }
            return SafeEncoder.encode((byte[]) obj);
        }

        public String toString() {
            return "String";
        }
    };
    public static final Builder<List<String>> STRING_LIST = new Builder<List<String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.20
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<String> build(Object obj) {
            if (null == obj) {
                return null;
            }
            Stream stream = ((List) obj).stream();
            Builder<String> builder = BuilderFactory.STRING;
            builder.getClass();
            return (List) stream.map(builder::build).collect(Collectors.toList());
        }

        public String toString() {
            return "List<String>";
        }
    };
    public static final Builder<Set<String>> STRING_SET = new Builder<Set<String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.21
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Set<String> build(Object obj) {
            if (null == obj) {
                return null;
            }
            Stream stream = ((List) obj).stream();
            Builder<String> builder = BuilderFactory.STRING;
            builder.getClass();
            return (Set) stream.map(builder::build).collect(Collectors.toSet());
        }

        public String toString() {
            return "Set<String>";
        }
    };
    public static final Builder<Set<String>> STRING_ORDERED_SET = new Builder<Set<String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.22
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Set<String> build(Object obj) {
            if (null == obj) {
                return null;
            }
            Stream stream = ((List) obj).stream();
            Builder<String> builder = BuilderFactory.STRING;
            builder.getClass();
            return (Set) stream.map(builder::build).collect(Collectors.toCollection(LinkedHashSet::new));
        }

        public String toString() {
            return "Set<String>";
        }
    };
    public static final Builder<Map<String, String>> STRING_MAP = new Builder<Map<String, String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.23
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, String> build(Object obj) {
            List list = (List) obj;
            HashMap map = new HashMap(list.size() / 2, 1.0f);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                map.put(SafeEncoder.encode((byte[]) it.next()), SafeEncoder.encode((byte[]) it.next()));
            }
            return map;
        }

        public String toString() {
            return "Map<String, String>";
        }
    };
    public static final Builder<KeyedListElement> KEYED_LIST_ELEMENT = new Builder<KeyedListElement>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.24
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public KeyedListElement build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            return new KeyedListElement((byte[]) list.get(0), (byte[]) list.get(1));
        }

        public String toString() {
            return "KeyedListElement";
        }
    };
    public static final Builder<KeyValue<String, List<String>>> KEYED_STRING_LIST = new Builder<KeyValue<String, List<String>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.25
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public KeyValue<String, List<String>> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            return new KeyValue<>(BuilderFactory.STRING.build(list.get(0)), BuilderFactory.STRING_LIST.build(list.get(1)));
        }

        public String toString() {
            return "KeyValue<String, List<String>>";
        }
    };
    public static final Builder<List<KeyValue<String, List<String>>>> KEYED_STRING_LIST_LIST = new Builder<List<KeyValue<String, List<String>>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.26
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<KeyValue<String, List<String>>> build(Object obj) {
            Stream stream = ((List) obj).stream();
            Builder<KeyValue<String, List<String>>> builder = BuilderFactory.KEYED_STRING_LIST;
            builder.getClass();
            return (List) stream.map(builder::build).collect(Collectors.toList());
        }
    };
    public static final Builder<KeyValue<byte[], List<byte[]>>> KEYED_BINARY_LIST = new Builder<KeyValue<byte[], List<byte[]>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.27
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public KeyValue<byte[], List<byte[]>> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            return new KeyValue<>(BuilderFactory.BINARY.build(list.get(0)), BuilderFactory.BINARY_LIST.build(list.get(1)));
        }

        public String toString() {
            return "KeyValue<byte[], List<byte[]>>";
        }
    };
    public static final Builder<Tuple> TUPLE = new Builder<Tuple>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.28
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Tuple build(Object obj) {
            List list = (List) obj;
            if (list.isEmpty()) {
                return null;
            }
            return new Tuple((byte[]) list.get(0), BuilderFactory.DOUBLE.build(list.get(1)));
        }

        public String toString() {
            return "Tuple";
        }
    };
    public static final Builder<KeyedZSetElement> KEYED_ZSET_ELEMENT = new Builder<KeyedZSetElement>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.29
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public KeyedZSetElement build(Object obj) {
            List list = (List) obj;
            if (list.isEmpty()) {
                return null;
            }
            return new KeyedZSetElement((byte[]) list.get(0), (byte[]) list.get(1), BuilderFactory.DOUBLE.build(list.get(2)));
        }

        public String toString() {
            return "KeyedZSetElement";
        }
    };
    public static final Builder<List<Tuple>> TUPLE_LIST = new Builder<List<Tuple>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.30
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Tuple> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size() / 2);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Tuple((byte[]) it.next(), BuilderFactory.DOUBLE.build(it.next())));
            }
            return arrayList;
        }

        public String toString() {
            return "List<Tuple>";
        }
    };
    public static final Builder<Set<Tuple>> TUPLE_ZSET = new Builder<Set<Tuple>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.31
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Set<Tuple> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            LinkedHashSet linkedHashSet = new LinkedHashSet(list.size() / 2, 1.0f);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(new Tuple((byte[]) it.next(), BuilderFactory.DOUBLE.build(it.next())));
            }
            return linkedHashSet;
        }

        public String toString() {
            return "ZSet<Tuple>";
        }
    };
    private static final Builder<List<Tuple>> TUPLE_LIST_FROM_PAIRS = new Builder<List<Tuple>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.32
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Tuple> build(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) ((List) obj).stream().map(obj2 -> {
                return (List) obj2;
            }).map(list -> {
                return BuilderFactory.TUPLE.build(list);
            }).collect(Collectors.toList());
        }

        public String toString() {
            return "List<Tuple>";
        }
    };
    public static final Builder<KeyValue<String, List<Tuple>>> KEYED_TUPLE_LIST = new Builder<KeyValue<String, List<Tuple>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.33
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public KeyValue<String, List<Tuple>> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            return new KeyValue<>(BuilderFactory.STRING.build(list.get(0)), BuilderFactory.TUPLE_LIST_FROM_PAIRS.build(list.get(1)));
        }

        public String toString() {
            return "KeyValue<String, List<Tuple>>";
        }
    };
    public static final Builder<KeyValue<byte[], List<Tuple>>> BINARY_KEYED_TUPLE_LIST = new Builder<KeyValue<byte[], List<Tuple>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.34
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public KeyValue<byte[], List<Tuple>> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            return new KeyValue<>(BuilderFactory.BINARY.build(list.get(0)), BuilderFactory.TUPLE_LIST_FROM_PAIRS.build(list.get(1)));
        }

        public String toString() {
            return "KeyValue<byte[], List<Tuple>>";
        }
    };
    public static final Builder<ScanResult<String>> SCAN_RESPONSE = new Builder<ScanResult<String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.35
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<String> build(Object obj) {
            List list = (List) obj;
            String str = new String((byte[]) list.get(0));
            List list2 = (List) list.get(1);
            ArrayList arrayList = new ArrayList(list2.size());
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(SafeEncoder.encode((byte[]) it.next()));
            }
            return new ScanResult<>(str, arrayList);
        }
    };
    public static final Builder<ScanResult<Map.Entry<String, String>>> HSCAN_RESPONSE = new Builder<ScanResult<Map.Entry<String, String>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.36
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<Map.Entry<String, String>> build(Object obj) {
            List list = (List) obj;
            String str = new String((byte[]) list.get(0));
            List list2 = (List) list.get(1);
            ArrayList arrayList = new ArrayList(list2.size() / 2);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new AbstractMap.SimpleEntry(SafeEncoder.encode((byte[]) it.next()), SafeEncoder.encode((byte[]) it.next())));
            }
            return new ScanResult<>(str, arrayList);
        }
    };
    public static final Builder<ScanResult<String>> SSCAN_RESPONSE = new Builder<ScanResult<String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.37
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<String> build(Object obj) {
            List list = (List) obj;
            String str = new String((byte[]) list.get(0));
            List list2 = (List) list.get(1);
            ArrayList arrayList = new ArrayList(list2.size());
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(SafeEncoder.encode((byte[]) it.next()));
            }
            return new ScanResult<>(str, arrayList);
        }
    };
    public static final Builder<ScanResult<Tuple>> ZSCAN_RESPONSE = new Builder<ScanResult<Tuple>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.38
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<Tuple> build(Object obj) {
            List list = (List) obj;
            String str = new String((byte[]) list.get(0));
            List list2 = (List) list.get(1);
            ArrayList arrayList = new ArrayList(list2.size() / 2);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new Tuple((byte[]) it.next(), BuilderFactory.DOUBLE.build(it.next())));
            }
            return new ScanResult<>(str, arrayList);
        }
    };
    public static final Builder<ScanResult<byte[]>> SCAN_BINARY_RESPONSE = new Builder<ScanResult<byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.39
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<byte[]> build(Object obj) {
            List list = (List) obj;
            return new ScanResult<>((byte[]) list.get(0), (List) list.get(1));
        }
    };
    public static final Builder<ScanResult<Map.Entry<byte[], byte[]>>> HSCAN_BINARY_RESPONSE = new Builder<ScanResult<Map.Entry<byte[], byte[]>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.40
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<Map.Entry<byte[], byte[]>> build(Object obj) {
            List list = (List) obj;
            byte[] bArr = (byte[]) list.get(0);
            List list2 = (List) list.get(1);
            ArrayList arrayList = new ArrayList(list2.size() / 2);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new AbstractMap.SimpleEntry(it.next(), it.next()));
            }
            return new ScanResult<>(bArr, arrayList);
        }
    };
    public static final Builder<ScanResult<byte[]>> SSCAN_BINARY_RESPONSE = new Builder<ScanResult<byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.41
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public ScanResult<byte[]> build(Object obj) {
            List list = (List) obj;
            return new ScanResult<>((byte[]) list.get(0), (List) list.get(1));
        }
    };
    public static final Builder<Map<String, Long>> PUBSUB_NUMSUB_MAP = new Builder<Map<String, Long>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.42
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, Long> build(Object obj) {
            List list = (List) obj;
            HashMap map = new HashMap(list.size() / 2, 1.0f);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                map.put(SafeEncoder.encode((byte[]) it.next()), (Long) it.next());
            }
            return map;
        }

        public String toString() {
            return "PUBSUB_NUMSUB_MAP<String, String>";
        }
    };
    public static final Builder<List<GeoCoordinate>> GEO_COORDINATE_LIST = new Builder<List<GeoCoordinate>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.43
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<GeoCoordinate> build(Object obj) {
            if (null == obj) {
                return null;
            }
            return interpretGeoposResult((List) obj);
        }

        public String toString() {
            return "List<GeoCoordinate>";
        }

        private List<GeoCoordinate> interpretGeoposResult(List<Object> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj == null) {
                    arrayList.add(null);
                } else {
                    List list2 = (List) obj;
                    arrayList.add(new GeoCoordinate(BuilderFactory.DOUBLE.build(list2.get(0)).doubleValue(), BuilderFactory.DOUBLE.build(list2.get(1)).doubleValue()));
                }
            }
            return arrayList;
        }
    };
    public static final Builder<List<GeoRadiusResponse>> GEORADIUS_WITH_PARAMS_RESULT = new Builder<List<GeoRadiusResponse>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.44
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<GeoRadiusResponse> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List<List> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            if (list.isEmpty()) {
                return arrayList;
            }
            if (list.get(0) instanceof List) {
                for (List list2 : list) {
                    GeoRadiusResponse geoRadiusResponse = new GeoRadiusResponse((byte[]) list2.get(0));
                    int size = list2.size();
                    for (int i = 1; i < size; i++) {
                        Object obj2 = list2.get(i);
                        if (obj2 instanceof List) {
                            List list3 = (List) obj2;
                            geoRadiusResponse.setCoordinate(new GeoCoordinate(BuilderFactory.DOUBLE.build(list3.get(0)).doubleValue(), BuilderFactory.DOUBLE.build(list3.get(1)).doubleValue()));
                        } else if (obj2 instanceof Long) {
                            geoRadiusResponse.setRawScore(BuilderFactory.LONG.build(obj2).longValue());
                        } else {
                            geoRadiusResponse.setDistance(BuilderFactory.DOUBLE.build(obj2).doubleValue());
                        }
                    }
                    arrayList.add(geoRadiusResponse);
                }
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new GeoRadiusResponse((byte[]) it.next()));
                }
            }
            return arrayList;
        }

        public String toString() {
            return "GeoRadiusWithParamsResult";
        }
    };
    public static final Builder<Map<String, CommandDocument>> COMMAND_DOCS_RESPONSE = new Builder<Map<String, CommandDocument>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.45
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, CommandDocument> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            HashMap map = new HashMap(list.size() / 2, 1.0f);
            int i = 0;
            while (i < list.size()) {
                int i2 = i;
                int i3 = i + 1;
                i = i3 + 1;
                map.put(BuilderFactory.STRING.build(list.get(i2)), CommandDocument.COMMAND_DOCUMENT_BUILDER.build(list.get(i3)));
            }
            return map;
        }
    };
    public static final Builder<Map<String, CommandInfo>> COMMAND_INFO_RESPONSE = new Builder<Map<String, CommandInfo>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.46
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, CommandInfo> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            HashMap map = new HashMap(list.size());
            for (Object obj2 : list) {
                if (obj2 != null) {
                    List list2 = (List) obj2;
                    map.put(BuilderFactory.STRING.build(list2.get(0)), CommandInfo.COMMAND_INFO_BUILDER.build(list2));
                }
            }
            return map;
        }
    };
    public static final Builder<List<Module>> MODULE_LIST = new Builder<List<Module>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.47
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Module> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List<List> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            if (list.isEmpty()) {
                return arrayList;
            }
            for (List list2 : list) {
                arrayList.add(new Module(SafeEncoder.encode((byte[]) list2.get(1)), ((Long) list2.get(3)).intValue()));
            }
            return arrayList;
        }

        public String toString() {
            return "List<Module>";
        }
    };
    public static final Builder<AccessControlUser> ACCESS_CONTROL_USER = new Builder<AccessControlUser>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.48
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public AccessControlUser build(Object obj) {
            if (obj == null) {
                return null;
            }
            List list = (List) obj;
            if (list.isEmpty()) {
                return null;
            }
            AccessControlUser accessControlUser = new AccessControlUser();
            Iterator it = ((List) list.get(1)).iterator();
            while (it.hasNext()) {
                accessControlUser.addFlag(SafeEncoder.encode((byte[]) it.next()));
            }
            Iterator it2 = ((List) list.get(3)).iterator();
            while (it2.hasNext()) {
                accessControlUser.addPassword(SafeEncoder.encode((byte[]) it2.next()));
            }
            accessControlUser.setCommands(SafeEncoder.encode((byte[]) list.get(5)));
            if (list.size() >= 12) {
                accessControlUser.addKeys(SafeEncoder.encode((byte[]) list.get(7)));
                accessControlUser.addChannels(SafeEncoder.encode((byte[]) list.get(9)));
            } else {
                Iterator it3 = ((List) list.get(7)).iterator();
                while (it3.hasNext()) {
                    accessControlUser.addKey(SafeEncoder.encode((byte[]) it3.next()));
                }
                if (list.size() >= 10) {
                    Iterator it4 = ((List) list.get(9)).iterator();
                    while (it4.hasNext()) {
                        accessControlUser.addChannel(SafeEncoder.encode((byte[]) it4.next()));
                    }
                }
            }
            return accessControlUser;
        }

        public String toString() {
            return "AccessControlUser";
        }
    };
    public static final Builder<List<AccessControlLogEntry>> ACCESS_CONTROL_LOG_ENTRY_LIST = new Builder<List<AccessControlLogEntry>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.49
        private final Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("count", BuilderFactory.LONG);
            map.put(AccessControlLogEntry.REASON, BuilderFactory.STRING);
            map.put(AccessControlLogEntry.CONTEXT, BuilderFactory.STRING);
            map.put(AccessControlLogEntry.OBJECT, BuilderFactory.STRING);
            map.put(AccessControlLogEntry.USERNAME, BuilderFactory.STRING);
            map.put(AccessControlLogEntry.AGE_SECONDS, BuilderFactory.STRING);
            map.put(AccessControlLogEntry.CLIENT_INFO, BuilderFactory.STRING);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<AccessControlLogEntry> build(Object obj) {
            if (null == obj) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(new AccessControlLogEntry(BuilderFactory.createMapFromDecodingFunctions(((List) it.next()).iterator(), this.mappingFunctions)));
            }
            return arrayList;
        }

        public String toString() {
            return "List<AccessControlLogEntry>";
        }
    };
    public static final Builder<StreamEntryID> STREAM_ENTRY_ID = new Builder<StreamEntryID>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.50
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public StreamEntryID build(Object obj) {
            if (null == obj) {
                return null;
            }
            return new StreamEntryID(SafeEncoder.encode((byte[]) obj));
        }

        public String toString() {
            return "StreamEntryID";
        }
    };
    public static final Builder<List<StreamEntryID>> STREAM_ENTRY_ID_LIST = new Builder<List<StreamEntryID>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.51
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamEntryID> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuilderFactory.STREAM_ENTRY_ID.build(it.next()));
                }
            }
            return arrayList;
        }
    };
    public static final Builder<StreamEntry> STREAM_ENTRY = new Builder<StreamEntry>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.52
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public StreamEntry build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            if (list.isEmpty()) {
                return null;
            }
            StreamEntryID streamEntryID = new StreamEntryID(SafeEncoder.encode((byte[]) list.get(0)));
            List list2 = (List) list.get(1);
            Iterator it = list2.iterator();
            HashMap map = new HashMap(list2.size() / 2, 1.0f);
            while (it.hasNext()) {
                map.put(SafeEncoder.encode((byte[]) it.next()), SafeEncoder.encode((byte[]) it.next()));
            }
            return new StreamEntry(streamEntryID, map);
        }

        public String toString() {
            return "StreamEntry";
        }
    };
    public static final Builder<List<StreamEntry>> STREAM_ENTRY_LIST = new Builder<List<StreamEntry>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.53
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamEntry> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List<ArrayList> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size() / 2);
            if (list.isEmpty()) {
                return arrayList;
            }
            for (ArrayList arrayList2 : list) {
                if (arrayList2 == null) {
                    arrayList.add(null);
                } else {
                    StreamEntryID streamEntryID = new StreamEntryID(SafeEncoder.encode((byte[]) arrayList2.get(0)));
                    List list2 = (List) arrayList2.get(1);
                    if (list2 == null) {
                        arrayList.add(new StreamEntry(streamEntryID, null));
                    } else {
                        Iterator it = list2.iterator();
                        HashMap map = new HashMap(list2.size() / 2, 1.0f);
                        while (it.hasNext()) {
                            map.put(SafeEncoder.encode((byte[]) it.next()), SafeEncoder.encode((byte[]) it.next()));
                        }
                        arrayList.add(new StreamEntry(streamEntryID, map));
                    }
                }
            }
            return arrayList;
        }

        public String toString() {
            return "List<StreamEntry>";
        }
    };
    public static final Builder<Map.Entry<StreamEntryID, List<StreamEntry>>> STREAM_AUTO_CLAIM_RESPONSE = new Builder<Map.Entry<StreamEntryID, List<StreamEntry>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.54
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map.Entry<StreamEntryID, List<StreamEntry>> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            return new AbstractMap.SimpleEntry(BuilderFactory.STREAM_ENTRY_ID.build(list.get(0)), BuilderFactory.STREAM_ENTRY_LIST.build(list.get(1)));
        }

        public String toString() {
            return "Map.Entry<StreamEntryID, List<StreamEntry>>";
        }
    };
    public static final Builder<Map.Entry<StreamEntryID, List<StreamEntryID>>> STREAM_AUTO_CLAIM_ID_RESPONSE = new Builder<Map.Entry<StreamEntryID, List<StreamEntryID>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.55
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map.Entry<StreamEntryID, List<StreamEntryID>> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            return new AbstractMap.SimpleEntry(BuilderFactory.STREAM_ENTRY_ID.build(list.get(0)), BuilderFactory.STREAM_ENTRY_ID_LIST.build(list.get(1)));
        }

        public String toString() {
            return "Map.Entry<StreamEntryID, List<StreamEntryID>>";
        }
    };
    public static final Builder<List<Map.Entry<String, List<StreamEntry>>>> STREAM_READ_RESPONSE = new Builder<List<Map.Entry<String, List<StreamEntry>>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.56
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Map.Entry<String, List<StreamEntry>>> build(Object obj) {
            if (obj == null) {
                return null;
            }
            List<List> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (List list2 : list) {
                arrayList.add(new AbstractMap.SimpleEntry(SafeEncoder.encode((byte[]) list2.get(0)), BuilderFactory.STREAM_ENTRY_LIST.build(list2.get(1))));
            }
            return arrayList;
        }

        public String toString() {
            return "List<Entry<String, List<StreamEntry>>>";
        }
    };
    public static final Builder<List<StreamPendingEntry>> STREAM_PENDING_ENTRY_LIST = new Builder<List<StreamPendingEntry>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.57
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamPendingEntry> build(Object obj) {
            if (null == obj) {
                return null;
            }
            List<List> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (List list2 : list) {
                String strEncode = SafeEncoder.encode((byte[]) list2.get(0));
                arrayList.add(new StreamPendingEntry(new StreamEntryID(strEncode), SafeEncoder.encode((byte[]) list2.get(1)), BuilderFactory.LONG.build(list2.get(2)).longValue(), BuilderFactory.LONG.build(list2.get(3)).longValue()));
            }
            return arrayList;
        }

        public String toString() {
            return "List<StreamPendingEntry>";
        }
    };
    public static final Builder<StreamInfo> STREAM_INFO = new Builder<StreamInfo>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.58
        Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("last-generated-id", BuilderFactory.STREAM_ENTRY_ID);
            map.put(StreamInfo.FIRST_ENTRY, BuilderFactory.STREAM_ENTRY);
            map.put("length", BuilderFactory.LONG);
            map.put("radix-tree-keys", BuilderFactory.LONG);
            map.put("radix-tree-nodes", BuilderFactory.LONG);
            map.put(StreamInfo.LAST_ENTRY, BuilderFactory.STREAM_ENTRY);
            map.put("groups", BuilderFactory.LONG);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public StreamInfo build(Object obj) {
            if (null == obj) {
                return null;
            }
            return new StreamInfo(BuilderFactory.createMapFromDecodingFunctions(((List) obj).iterator(), this.mappingFunctions));
        }

        public String toString() {
            return "StreamInfo";
        }
    };
    public static final Builder<List<StreamGroupInfo>> STREAM_GROUP_INFO_LIST = new Builder<List<StreamGroupInfo>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.59
        Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("name", BuilderFactory.STRING);
            map.put("consumers", BuilderFactory.LONG);
            map.put("pending", BuilderFactory.LONG);
            map.put("last-delivered-id", BuilderFactory.STREAM_ENTRY_ID);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamGroupInfo> build(Object obj) {
            if (null == obj) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(new StreamGroupInfo(BuilderFactory.createMapFromDecodingFunctions(((List) it.next()).iterator(), this.mappingFunctions)));
            }
            return arrayList;
        }

        public String toString() {
            return "List<StreamGroupInfo>";
        }
    };
    public static final Builder<List<StreamConsumersInfo>> STREAM_CONSUMERS_INFO_LIST = new Builder<List<StreamConsumersInfo>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.60
        Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("name", BuilderFactory.STRING);
            map.put(StreamConsumersInfo.IDLE, BuilderFactory.LONG);
            map.put("pending", BuilderFactory.LONG);
            map.put("last-delivered-id", BuilderFactory.STRING);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamConsumersInfo> build(Object obj) {
            if (null == obj) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(new StreamConsumersInfo(BuilderFactory.createMapFromDecodingFunctions(((List) it.next()).iterator(), this.mappingFunctions)));
            }
            return arrayList;
        }

        public String toString() {
            return "List<StreamConsumersInfo>";
        }
    };
    private static final Builder<List<StreamConsumerFullInfo>> STREAM_CONSUMER_FULL_INFO_LIST = new Builder<List<StreamConsumerFullInfo>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.61
        final Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("name", BuilderFactory.STRING);
            map.put(StreamConsumerFullInfo.SEEN_TIME, BuilderFactory.LONG);
            map.put("pel-count", BuilderFactory.LONG);
            map.put("pending", BuilderFactory.ENCODED_OBJECT_LIST);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamConsumerFullInfo> build(Object obj) {
            if (null == obj) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(new StreamConsumerFullInfo(BuilderFactory.createMapFromDecodingFunctions(((List) it.next()).iterator(), this.mappingFunctions)));
            }
            return arrayList;
        }

        public String toString() {
            return "List<StreamConsumerFullInfo>";
        }
    };
    private static final Builder<List<StreamGroupFullInfo>> STREAM_GROUP_FULL_INFO_LIST = new Builder<List<StreamGroupFullInfo>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.62
        final Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("name", BuilderFactory.STRING);
            map.put("consumers", BuilderFactory.STREAM_CONSUMER_FULL_INFO_LIST);
            map.put("pending", BuilderFactory.ENCODED_OBJECT_LIST);
            map.put("last-delivered-id", BuilderFactory.STREAM_ENTRY_ID);
            map.put("pel-count", BuilderFactory.LONG);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<StreamGroupFullInfo> build(Object obj) {
            if (null == obj) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(new StreamGroupFullInfo(BuilderFactory.createMapFromDecodingFunctions(((List) it.next()).iterator(), this.mappingFunctions)));
            }
            return arrayList;
        }

        public String toString() {
            return "List<StreamGroupFullInfo>";
        }
    };
    public static final Builder<StreamFullInfo> STREAM_INFO_FULL = new Builder<StreamFullInfo>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.63
        final Map<String, Builder> mappingFunctions = createDecoderMap();

        private Map<String, Builder> createDecoderMap() {
            HashMap map = new HashMap();
            map.put("last-generated-id", BuilderFactory.STREAM_ENTRY_ID);
            map.put("length", BuilderFactory.LONG);
            map.put("radix-tree-keys", BuilderFactory.LONG);
            map.put("radix-tree-nodes", BuilderFactory.LONG);
            map.put("groups", BuilderFactory.STREAM_GROUP_FULL_INFO_LIST);
            map.put(StreamFullInfo.ENTRIES, BuilderFactory.STREAM_ENTRY_LIST);
            return map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public StreamFullInfo build(Object obj) {
            if (null == obj) {
                return null;
            }
            return new StreamFullInfo(BuilderFactory.createMapFromDecodingFunctions(((List) obj).iterator(), this.mappingFunctions));
        }

        public String toString() {
            return "StreamFullInfo";
        }
    };
    public static final Builder<StreamPendingSummary> STREAM_PENDING_SUMMARY = new Builder<StreamPendingSummary>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.64
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public StreamPendingSummary build(Object obj) {
            if (null == obj) {
                return null;
            }
            List list = (List) obj;
            long jLongValue = BuilderFactory.LONG.build(list.get(0)).longValue();
            String strEncode = SafeEncoder.encode((byte[]) list.get(1));
            String strEncode2 = SafeEncoder.encode((byte[]) list.get(2));
            List<List> list2 = (List) list.get(3);
            HashMap map = new HashMap(list2.size());
            for (List list3 : list2) {
                map.put(SafeEncoder.encode((byte[]) list3.get(0)), Long.valueOf(Long.parseLong(SafeEncoder.encode((byte[]) list3.get(1)))));
            }
            return new StreamPendingSummary(jLongValue, new StreamEntryID(strEncode), new StreamEntryID(strEncode2), map);
        }

        public String toString() {
            return "StreamPendingSummary";
        }
    };
    public static final Builder<LCSMatchResult> STR_ALGO_LCS_RESULT_BUILDER = new Builder<LCSMatchResult>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.65
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public LCSMatchResult build(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof byte[]) {
                return new LCSMatchResult(BuilderFactory.STRING.build(obj));
            }
            if (obj instanceof Long) {
                return new LCSMatchResult(BuilderFactory.LONG.build(obj).longValue());
            }
            ArrayList arrayList = new ArrayList();
            List list = (List) obj;
            if ("matches".equalsIgnoreCase(BuilderFactory.STRING.build(list.get(0)))) {
                for (Object obj2 : (List) list.get(1)) {
                    if (obj2 instanceof List) {
                        List list2 = (List) obj2;
                        arrayList.add(new LCSMatchResult.MatchedPosition(new LCSMatchResult.Position(BuilderFactory.LONG.build(((List) list2.get(0)).get(0)).longValue(), BuilderFactory.LONG.build(((List) list2.get(0)).get(1)).longValue()), new LCSMatchResult.Position(BuilderFactory.LONG.build(((List) list2.get(1)).get(0)).longValue(), BuilderFactory.LONG.build(((List) list2.get(1)).get(1)).longValue()), list2.size() >= 3 ? BuilderFactory.LONG.build(list2.get(2)).longValue() : 0L));
                    }
                }
            }
            return new LCSMatchResult(arrayList, "len".equalsIgnoreCase(BuilderFactory.STRING.build(list.get(2))) ? BuilderFactory.LONG.build(list.get(3)).longValue() : 0L);
        }
    };
    public static final Builder<Map<String, String>> STRING_MAP_FROM_PAIRS = new Builder<Map<String, String>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.66
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, String> build(Object obj) {
            List<List> list = (List) obj;
            HashMap map = new HashMap(list.size());
            for (List list2 : list) {
                map.put(SafeEncoder.encode((byte[]) list2.get(0)), list2.get(1) != null ? SafeEncoder.encode((byte[]) list2.get(1)) : null);
            }
            return map;
        }

        public String toString() {
            return "Map<String, String>";
        }
    };
    public static final Builder<List<LibraryInfo>> LIBRARY_LIST = new Builder<List<LibraryInfo>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.67
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<LibraryInfo> build(Object obj) {
            return (List) ((List) obj).stream().map(obj2 -> {
                return LibraryInfo.LIBRARY_BUILDER.build(obj2);
            }).collect(Collectors.toList());
        }
    };
    public static final Builder<Class<?>> JSON_TYPE = new Builder<Class<?>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.68
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Class<?> build(Object obj) {
            if (obj == null) {
                return null;
            }
            String strBuild = BuilderFactory.STRING.build(obj);
            switch (strBuild) {
                case "null":
                    return null;
                case "boolean":
                    return Boolean.TYPE;
                case "integer":
                    return Integer.TYPE;
                case "number":
                    return Float.TYPE;
                case "string":
                    return String.class;
                case "object":
                    return Object.class;
                case "array":
                    return List.class;
                default:
                    throw new JedisException("Unknown type: " + strBuild);
            }
        }

        public String toString() {
            return "Class<?>";
        }
    };
    public static final Builder<List<Class<?>>> JSON_TYPE_LIST = new Builder<List<Class<?>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.69
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<Class<?>> build(Object obj) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(BuilderFactory.JSON_TYPE.build(it.next()));
                } catch (JedisException e) {
                    arrayList.add(null);
                }
            }
            return arrayList;
        }
    };
    public static final Builder<Object> JSON_OBJECT = new Builder<Object>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.70
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Object build(Object obj) {
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof byte[])) {
                return obj;
            }
            String strBuild = BuilderFactory.STRING.build(obj);
            if (strBuild.charAt(0) == '{') {
                try {
                    return new JSONObject(strBuild);
                } catch (Exception e) {
                }
            } else if (strBuild.charAt(0) == '[') {
                try {
                    return new JSONArray(strBuild);
                } catch (Exception e2) {
                }
            }
            return strBuild;
        }
    };
    public static final Builder<JSONArray> JSON_ARRAY = new Builder<JSONArray>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.71
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public JSONArray build(Object obj) {
            if (obj == null) {
                return null;
            }
            return new JSONArray(BuilderFactory.STRING.build(obj));
        }
    };
    public static final Builder<List<JSONArray>> JSON_ARRAY_LIST = new Builder<List<JSONArray>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.72
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<JSONArray> build(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) ((List) obj).stream().map(obj2 -> {
                return BuilderFactory.JSON_ARRAY.build(obj2);
            }).collect(Collectors.toList());
        }
    };
    public static final Builder<List<List<String>>> STRING_LIST_LIST = new Builder<List<List<String>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.73
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<List<String>> build(Object obj) {
            if (null == obj) {
                return null;
            }
            Stream stream = ((List) obj).stream();
            Builder<List<String>> builder = BuilderFactory.STRING_LIST;
            builder.getClass();
            return (List) stream.map(builder::build).collect(Collectors.toList());
        }

        public String toString() {
            return "List<List<String>>";
        }
    };
    public static final Builder<List<List<Object>>> ENCODED_OBJECT_LIST_LIST = new Builder<List<List<Object>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.74
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<List<Object>> build(Object obj) {
            if (null == obj) {
                return null;
            }
            Stream stream = ((List) obj).stream();
            Builder<List<Object>> builder = BuilderFactory.ENCODED_OBJECT_LIST;
            builder.getClass();
            return (List) stream.map(builder::build).collect(Collectors.toList());
        }

        public String toString() {
            return "List<List<Object>>";
        }
    };
    public static final Builder<AggregationResult> SEARCH_AGGREGATION_RESULT = new Builder<AggregationResult>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.75
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public AggregationResult build(Object obj) {
            return new AggregationResult(obj);
        }
    };
    public static final Builder<AggregationResult> SEARCH_AGGREGATION_RESULT_WITH_CURSOR = new Builder<AggregationResult>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.76
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public AggregationResult build(Object obj) {
            List list = (List) obj;
            return new AggregationResult(list.get(0), ((Long) list.get(1)).longValue());
        }
    };
    public static final Builder<Map<String, List<String>>> SEARCH_SYNONYM_GROUPS = new Builder<Map<String, List<String>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.77
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map<String, List<String>> build(Object obj) {
            List list = (List) obj;
            HashMap map = new HashMap(list.size() / 2, 1.0f);
            for (int i = 0; i < list.size(); i += 2) {
                map.put(BuilderFactory.STRING.build(list.get(i)), BuilderFactory.STRING_LIST.build(list.get(i + 1)));
            }
            return map;
        }
    };
    public static final Builder<TSElement> TIMESERIES_ELEMENT = new Builder<TSElement>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.78
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public TSElement build(Object obj) {
            List list = (List) obj;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return new TSElement(BuilderFactory.LONG.build(list.get(0)).longValue(), BuilderFactory.DOUBLE.build(list.get(1)).doubleValue());
        }
    };
    public static final Builder<List<TSElement>> TIMESERIES_ELEMENT_LIST = new Builder<List<TSElement>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.79
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<TSElement> build(Object obj) {
            return (List) ((List) obj).stream().map(obj2 -> {
                return (List) obj2;
            }).map(list -> {
                return new TSElement(BuilderFactory.LONG.build(list.get(0)).longValue(), BuilderFactory.DOUBLE.build(list.get(1)).doubleValue());
            }).collect(Collectors.toList());
        }
    };
    public static final Builder<List<TSKeyedElements>> TIMESERIES_MRANGE_RESPONSE = new Builder<List<TSKeyedElements>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.80
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<TSKeyedElements> build(Object obj) {
            return (List) ((List) obj).stream().map(obj2 -> {
                return (List) obj2;
            }).map(list -> {
                return new TSKeyedElements(BuilderFactory.STRING.build(list.get(0)), BuilderFactory.STRING_MAP_FROM_PAIRS.build(list.get(1)), BuilderFactory.TIMESERIES_ELEMENT_LIST.build(list.get(2)));
            }).collect(Collectors.toList());
        }
    };
    public static final Builder<List<TSKeyValue<TSElement>>> TIMESERIES_MGET_RESPONSE = new Builder<List<TSKeyValue<TSElement>>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.81
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<TSKeyValue<TSElement>> build(Object obj) {
            return (List) ((List) obj).stream().map(obj2 -> {
                return (List) obj2;
            }).map(list -> {
                return new TSKeyValue(BuilderFactory.STRING.build(list.get(0)), BuilderFactory.STRING_MAP_FROM_PAIRS.build(list.get(1)), BuilderFactory.TIMESERIES_ELEMENT.build(list.get(2)));
            }).collect(Collectors.toList());
        }
    };
    public static final Builder<Map.Entry<Long, byte[]>> BLOOM_SCANDUMP_RESPONSE = new Builder<Map.Entry<Long, byte[]>>() { // from class: me.module.multiserver.library.redis.jedis.BuilderFactory.82
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public Map.Entry<Long, byte[]> build(Object obj) {
            List list = (List) obj;
            return new KeyValue(BuilderFactory.LONG.build(list.get(0)), BuilderFactory.BINARY.build(list.get(1)));
        }
    };

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/BuilderFactory$SetFromList.class */
    protected static class SetFromList<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = -2850347066962734052L;
        private final List<E> list;

        private SetFromList(List<E> list) {
            this.list = list;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.list.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.list.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.list.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            return !contains(e) && this.list.add(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.list.iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.list.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.list.toArray(tArr);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.list.toString();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Collection<?> collection = (Collection) obj;
            if (collection.size() != size()) {
                return false;
            }
            return containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.list.containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return this.list.removeAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return this.list.retainAll(collection);
        }

        protected static <E> SetFromList<E> of(List<E> list) {
            if (list == null) {
                return null;
            }
            return new SetFromList<>(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> createMapFromDecodingFunctions(Iterator<Object> it, Map<String, Builder> map) {
        HashMap map2 = new HashMap();
        while (it.hasNext()) {
            String strBuild = STRING.build(it.next());
            if (map.containsKey(strBuild)) {
                map2.put(strBuild, map.get(strBuild).build(it.next()));
            } else {
                Object next = it.next();
                Iterator<Builder> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    try {
                        map2.put(strBuild, it2.next().build(next));
                        break;
                    } catch (ClassCastException e) {
                    }
                }
            }
        }
        return map2;
    }

    private BuilderFactory() {
        throw new InstantiationError("Must not instantiate this class");
    }
}

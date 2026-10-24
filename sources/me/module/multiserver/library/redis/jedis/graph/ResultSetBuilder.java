package me.module.multiserver.library.redis.jedis.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.graph.entities.Edge;
import me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity;
import me.module.multiserver.library.redis.jedis.graph.entities.Node;
import me.module.multiserver.library.redis.jedis.graph.entities.Path;
import me.module.multiserver.library.redis.jedis.graph.entities.Point;
import me.module.multiserver.library.redis.jedis.search.IndexOptions;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import me.ulrich.clans.library.udojava.evalex.Expression;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder.class */
class ResultSetBuilder extends Builder<ResultSet> {
    private final GraphCache graphCache;
    private static final ScalarType[] SCALAR_TYPES = ScalarType.values();
    private static final ResultSet.ColumnType[] COLUMN_TYPES = ResultSet.ColumnType.values();

    /* JADX INFO: renamed from: me.module.multiserver.library.redis.jedis.graph.ResultSetBuilder$1, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType = new int[ScalarType.values().length];

        static {
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.NODE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.EDGE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.PATH.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.MAP.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.POINT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[ScalarType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            $SwitchMap$redis$clients$jedis$graph$ResultSet$ColumnType = new int[ResultSet.ColumnType.values().length];
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSet$ColumnType[ResultSet.ColumnType.NODE.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSet$ColumnType[ResultSet.ColumnType.RELATION.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$redis$clients$jedis$graph$ResultSet$ColumnType[ResultSet.ColumnType.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder$HeaderImpl.class */
    private class HeaderImpl implements Header {
        private final List<ResultSet.ColumnType> schemaTypes;
        private final List<String> schemaNames;

        private HeaderImpl() {
            this.schemaTypes = Collections.emptyList();
            this.schemaNames = Collections.emptyList();
        }

        private HeaderImpl(List<ResultSet.ColumnType> list, List<String> list2) {
            this.schemaTypes = list;
            this.schemaNames = list2;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Header
        public List<String> getSchemaNames() {
            return this.schemaNames;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Header
        public List<ResultSet.ColumnType> getSchemaTypes() {
            return this.schemaTypes;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HeaderImpl)) {
                return false;
            }
            HeaderImpl headerImpl = (HeaderImpl) obj;
            return Objects.equals(getSchemaTypes(), headerImpl.getSchemaTypes()) && Objects.equals(getSchemaNames(), headerImpl.getSchemaNames());
        }

        public int hashCode() {
            return Objects.hash(getSchemaTypes(), getSchemaNames());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("HeaderImpl{");
            sb.append("schemaTypes=").append(this.schemaTypes);
            sb.append(", schemaNames=").append(this.schemaNames);
            sb.append('}');
            return sb.toString();
        }

        /* synthetic */ HeaderImpl(ResultSetBuilder resultSetBuilder, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* synthetic */ HeaderImpl(ResultSetBuilder resultSetBuilder, List list, List list2, AnonymousClass1 anonymousClass1) {
            this(list, list2);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder$RecordImpl.class */
    private class RecordImpl implements Record {
        private final List<String> header;
        private final List<Object> values;

        public RecordImpl(List<String> list, List<Object> list2) {
            this.header = list;
            this.values = list2;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public <T> T getValue(int i) {
            return (T) this.values.get(i);
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public <T> T getValue(String str) {
            return (T) getValue(this.header.indexOf(str));
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public String getString(int i) {
            return this.values.get(i).toString();
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public String getString(String str) {
            return getString(this.header.indexOf(str));
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public List<String> keys() {
            return this.header;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public List<Object> values() {
            return this.values;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public boolean containsKey(String str) {
            return this.header.contains(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Record
        public int size() {
            return this.header.size();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RecordImpl)) {
                return false;
            }
            RecordImpl recordImpl = (RecordImpl) obj;
            return Objects.equals(this.header, recordImpl.header) && Objects.equals(this.values, recordImpl.values);
        }

        public int hashCode() {
            return Objects.hash(this.header, this.values);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Record{");
            sb.append("values=").append(this.values);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder$ResultSetImpl.class */
    private class ResultSetImpl implements ResultSet {
        private final Header header;
        private final List<Record> results;
        private final Statistics statistics;

        private ResultSetImpl(Header header, List<Record> list, Statistics statistics) {
            this.header = header;
            this.results = list;
            this.statistics = statistics;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.ResultSet
        public Header getHeader() {
            return this.header;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.ResultSet
        public Statistics getStatistics() {
            return this.statistics;
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.ResultSet
        public int size() {
            return this.results.size();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultSetImpl)) {
                return false;
            }
            ResultSetImpl resultSetImpl = (ResultSetImpl) obj;
            return Objects.equals(getHeader(), resultSetImpl.getHeader()) && Objects.equals(getStatistics(), resultSetImpl.getStatistics()) && Objects.equals(this.results, resultSetImpl.results);
        }

        public int hashCode() {
            return Objects.hash(getHeader(), getStatistics(), this.results);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ResultSetImpl{");
            sb.append("header=").append(this.header);
            sb.append(", statistics=").append(this.statistics);
            sb.append(", results=").append(this.results);
            sb.append('}');
            return sb.toString();
        }

        @Override // java.lang.Iterable
        public Iterator<Record> iterator() {
            return this.results.iterator();
        }

        /* synthetic */ ResultSetImpl(ResultSetBuilder resultSetBuilder, Header header, List list, Statistics statistics, AnonymousClass1 anonymousClass1) {
            this(header, list, statistics);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder$ScalarType.class */
    private enum ScalarType {
        UNKNOWN,
        NULL,
        STRING,
        INTEGER,
        BOOLEAN,
        DOUBLE,
        ARRAY,
        EDGE,
        NODE,
        PATH,
        MAP,
        POINT
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSetBuilder$StatisticsImpl.class */
    private class StatisticsImpl implements Statistics {
        private final Map<String, String> statistics;

        private StatisticsImpl(Map<String, String> map) {
            this.statistics = map;
        }

        public String getStringValue(String str) {
            return this.statistics.get(str);
        }

        private int getIntValue(String str) {
            String stringValue = getStringValue(str);
            if (stringValue == null) {
                return 0;
            }
            return Integer.parseInt(stringValue);
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int nodesCreated() {
            return getIntValue("Nodes created");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int nodesDeleted() {
            return getIntValue("Nodes deleted");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int indicesCreated() {
            return getIntValue("Indices created");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int indicesDeleted() {
            return getIntValue("Indices deleted");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int labelsAdded() {
            return getIntValue("Labels added");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int relationshipsDeleted() {
            return getIntValue("Relationships deleted");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int relationshipsCreated() {
            return getIntValue("Relationships created");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public int propertiesSet() {
            return getIntValue("Properties set");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public boolean cachedExecution() {
            return "1".equals(getStringValue("Cached execution"));
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.Statistics
        public String queryIntervalExecutionTime() {
            return getStringValue("Query internal execution time");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StatisticsImpl) {
                return Objects.equals(this.statistics, ((StatisticsImpl) obj).statistics);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.statistics);
        }

        public String toString() {
            return "Statistics{" + this.statistics + '}';
        }

        /* synthetic */ StatisticsImpl(ResultSetBuilder resultSetBuilder, Map map, AnonymousClass1 anonymousClass1) {
            this(map);
        }
    }

    ResultSetBuilder(GraphCache graphCache) {
        this.graphCache = graphCache;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.module.multiserver.library.redis.jedis.Builder
    public ResultSet build(Object obj) {
        Object objEmptyList;
        Object objEmptyList2;
        Object obj2;
        List list = (List) obj;
        if (list.get(list.size() - 1) instanceof JedisDataException) {
            throw ((JedisDataException) list.get(list.size() - 1));
        }
        if (list.size() == 1) {
            objEmptyList = Collections.emptyList();
            objEmptyList2 = Collections.emptyList();
            obj2 = list.get(0);
        } else {
            if (list.size() != 3) {
                throw new JedisException("Unrecognized graph response format.");
            }
            objEmptyList = list.get(0);
            objEmptyList2 = list.get(1);
            obj2 = list.get(2);
        }
        HeaderImpl header = parseHeader(objEmptyList);
        return new ResultSetImpl(this, header, parseRecords(header, objEmptyList2), parseStatistics(obj2), null);
    }

    private List<Record> parseRecords(Header header, Object obj) {
        List<List> list = (List) obj;
        if (list == null || list.isEmpty()) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (List list2 : list) {
            ArrayList arrayList2 = new ArrayList(list2.size());
            for (int i = 0; i < list2.size(); i++) {
                List<Object> list3 = (List) list2.get(i);
                switch (header.getSchemaTypes().get(i)) {
                    case NODE:
                        arrayList2.add(deserializeNode(list3));
                        break;
                    case RELATION:
                        arrayList2.add(deserializeEdge(list3));
                        break;
                    case SCALAR:
                        arrayList2.add(deserializeScalar(list3));
                        break;
                    default:
                        arrayList2.add(null);
                        break;
                }
            }
            arrayList.add(new RecordImpl(header.getSchemaNames(), arrayList2));
        }
        return arrayList;
    }

    private Node deserializeNode(List<Object> list) {
        List list2 = (List) list.get(1);
        List<List<Object>> list3 = (List) list.get(2);
        Node node = new Node(list2.size(), list3.size());
        deserializeGraphEntityId(node, ((Long) list.get(0)).longValue());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            node.addLabel(this.graphCache.getLabel(((Long) it.next()).intValue()));
        }
        deserializeGraphEntityProperties(node, list3);
        return node;
    }

    private void deserializeGraphEntityId(GraphEntity graphEntity, long j) {
        graphEntity.setId(j);
    }

    private Edge deserializeEdge(List<Object> list) {
        List<List<Object>> list2 = (List) list.get(4);
        Edge edge = new Edge(list2.size());
        deserializeGraphEntityId(edge, ((Long) list.get(0)).longValue());
        edge.setRelationshipType(this.graphCache.getRelationshipType(((Long) list.get(1)).intValue()));
        edge.setSource(((Long) list.get(2)).longValue());
        edge.setDestination(((Long) list.get(3)).longValue());
        deserializeGraphEntityProperties(edge, list2);
        return edge;
    }

    private void deserializeGraphEntityProperties(GraphEntity graphEntity, List<List<Object>> list) {
        for (List<Object> list2 : list) {
            graphEntity.addProperty(this.graphCache.getPropertyName(((Long) list2.get(0)).intValue()), deserializeScalar(list2.subList(1, list2.size())));
        }
    }

    private Object deserializeScalar(List<Object> list) {
        ScalarType valueTypeFromObject = getValueTypeFromObject(list.get(0));
        Object obj = list.get(1);
        switch (AnonymousClass1.$SwitchMap$redis$clients$jedis$graph$ResultSetBuilder$ScalarType[valueTypeFromObject.ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(Boolean.parseBoolean(SafeEncoder.encode((byte[]) obj)));
            case 3:
                return BuilderFactory.DOUBLE.build(obj);
            case 4:
                return (Long) obj;
            case 5:
                return SafeEncoder.encode((byte[]) obj);
            case 6:
                return deserializeArray(obj);
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                return deserializeNode((List) obj);
            case 8:
                return deserializeEdge((List) obj);
            case 9:
                return deserializePath(obj);
            case 10:
                return deserializeMap(obj);
            case IndexOptions.DEFAULT_FLAGS /* 11 */:
                return deserializePoint(obj);
            case 12:
            default:
                return obj;
        }
    }

    private Object deserializePoint(Object obj) {
        return new Point(BuilderFactory.DOUBLE_LIST.build(obj));
    }

    private Map<String, Object> deserializeMap(Object obj) {
        List list = (List) obj;
        int size = list.size();
        HashMap map = new HashMap(size >> 1);
        for (int i = 0; i < size; i += 2) {
            map.put(SafeEncoder.encode((byte[]) list.get(i)), deserializeScalar((List) list.get(i + 1)));
        }
        return map;
    }

    private Path deserializePath(Object obj) {
        List list = (List) obj;
        return new Path((List) deserializeScalar((List) list.get(0)), (List) deserializeScalar((List) list.get(1)));
    }

    private List<Object> deserializeArray(Object obj) {
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(deserializeScalar((List) it.next()));
        }
        return arrayList;
    }

    private ScalarType getValueTypeFromObject(Object obj) {
        return getScalarType(((Long) obj).intValue());
    }

    private static ScalarType getScalarType(int i) {
        try {
            return SCALAR_TYPES[i];
        } catch (IndexOutOfBoundsException e) {
            throw new JedisException("Unrecognized response type");
        }
    }

    private HeaderImpl parseHeader(Object obj) {
        if (obj == null) {
            return new HeaderImpl(this, null);
        }
        List<List> list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (List list2 : list) {
            arrayList.add(COLUMN_TYPES[((Long) list2.get(0)).intValue()]);
            arrayList2.add(SafeEncoder.encode((byte[]) list2.get(1)));
        }
        return new HeaderImpl(this, arrayList, arrayList2, null);
    }

    private StatisticsImpl parseStatistics(Object obj) {
        return new StatisticsImpl(this, (Map) ((List) obj).stream().map(SafeEncoder::encode).map(str -> {
            return str.split(": ");
        }).collect(Collectors.toMap(strArr -> {
            return strArr[0];
        }, strArr2 -> {
            return strArr2[1];
        })), null);
    }
}

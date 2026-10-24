package me.module.multiserver.library.redis.jedis.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.CommandObject;
import me.module.multiserver.library.redis.jedis.Connection;
import me.module.multiserver.library.redis.jedis.providers.ConnectionProvider;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphCommandObjects.class */
public class GraphCommandObjects {
    private final RedisGraphCommands graph;
    private final Connection connection;
    private final ConnectionProvider provider;
    private final ConcurrentHashMap<String, Builder<ResultSet>> builders;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphCommandObjects$GraphCacheImpl.class */
    private class GraphCacheImpl implements GraphCache {
        private final GraphCacheList labels;
        private final GraphCacheList propertyNames;
        private final GraphCacheList relationshipTypes;

        public GraphCacheImpl(String str) {
            this.labels = GraphCommandObjects.this.new GraphCacheList(str, "db.labels");
            this.propertyNames = GraphCommandObjects.this.new GraphCacheList(str, "db.propertyKeys");
            this.relationshipTypes = GraphCommandObjects.this.new GraphCacheList(str, "db.relationshipTypes");
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.GraphCache
        public String getLabel(int i) {
            return this.labels.getCachedData(i);
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.GraphCache
        public String getRelationshipType(int i) {
            return this.relationshipTypes.getCachedData(i);
        }

        @Override // me.module.multiserver.library.redis.jedis.graph.GraphCache
        public String getPropertyName(int i) {
            return this.propertyNames.getCachedData(i);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphCommandObjects$GraphCacheList.class */
    private class GraphCacheList {
        private final String name;
        private final String query;
        private final List<String> data = new CopyOnWriteArrayList();

        public GraphCacheList(String str, String str2) {
            this.name = str;
            this.query = "CALL " + str2 + "()";
        }

        public String getCachedData(int i) {
            if (i >= this.data.size()) {
                synchronized (this.data) {
                    if (i >= this.data.size()) {
                        getProcedureInfo();
                    }
                }
            }
            return this.data.get(i);
        }

        private void getProcedureInfo() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Record record : callProcedure()) {
                if (i >= this.data.size()) {
                    arrayList.add(record.getString(0));
                }
                i++;
            }
            this.data.addAll(arrayList);
        }

        private ResultSet callProcedure() {
            if (GraphCommandObjects.this.graph != null) {
                return GraphCommandObjects.this.graph.graphQuery(this.name, this.query);
            }
            CommandObject commandObject = new CommandObject(new CommandArguments(GraphProtocol.GraphCommand.QUERY).key(this.name).add(this.query).add(GraphProtocol.GraphKeyword.__COMPACT), GraphCommandObjects.this.getBuilder(this.name));
            if (GraphCommandObjects.this.connection != null) {
                return (ResultSet) GraphCommandObjects.this.connection.executeCommand(commandObject);
            }
            Connection connection = GraphCommandObjects.this.provider.getConnection(commandObject.getArguments());
            Throwable th = null;
            try {
                try {
                    ResultSet resultSet = (ResultSet) connection.executeCommand(commandObject);
                    if (connection != null) {
                        if (0 != 0) {
                            try {
                                connection.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            connection.close();
                        }
                    }
                    return resultSet;
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (Throwable th4) {
                if (connection != null) {
                    if (th != null) {
                        try {
                            connection.close();
                        } catch (Throwable th5) {
                            th.addSuppressed(th5);
                        }
                    } else {
                        connection.close();
                    }
                }
                throw th4;
            }
        }
    }

    public GraphCommandObjects(RedisGraphCommands redisGraphCommands) {
        this.builders = new ConcurrentHashMap<>();
        this.graph = redisGraphCommands;
        this.connection = null;
        this.provider = null;
    }

    public GraphCommandObjects(Connection connection) {
        this.builders = new ConcurrentHashMap<>();
        this.connection = connection;
        this.provider = null;
        this.graph = null;
    }

    public GraphCommandObjects(ConnectionProvider connectionProvider) {
        this.builders = new ConcurrentHashMap<>();
        this.provider = connectionProvider;
        this.connection = null;
        this.graph = null;
    }

    public final CommandObject<ResultSet> graphQuery(String str, String str2) {
        return new CommandObject<>(new CommandArguments(GraphProtocol.GraphCommand.QUERY).key(str).add(str2).add(GraphProtocol.GraphKeyword.__COMPACT), getBuilder(str));
    }

    public final CommandObject<ResultSet> graphReadonlyQuery(String str, String str2) {
        return new CommandObject<>(new CommandArguments(GraphProtocol.GraphCommand.RO_QUERY).key(str).add(str2).add(GraphProtocol.GraphKeyword.__COMPACT), getBuilder(str));
    }

    public final CommandObject<ResultSet> graphQuery(String str, String str2, long j) {
        return graphQuery(str, GraphQueryParams.queryParams(str2).timeout(j));
    }

    public final CommandObject<ResultSet> graphReadonlyQuery(String str, String str2, long j) {
        return graphQuery(str, GraphQueryParams.queryParams().readonly().query(str2).timeout(j));
    }

    public final CommandObject<ResultSet> graphQuery(String str, String str2, Map<String, Object> map) {
        return graphQuery(str, GraphQueryParams.queryParams(str2).params(map));
    }

    public final CommandObject<ResultSet> graphReadonlyQuery(String str, String str2, Map<String, Object> map) {
        return graphQuery(str, GraphQueryParams.queryParams().readonly().query(str2).params(map));
    }

    public final CommandObject<ResultSet> graphQuery(String str, String str2, Map<String, Object> map, long j) {
        return graphQuery(str, GraphQueryParams.queryParams(str2).params(map).timeout(j));
    }

    public final CommandObject<ResultSet> graphReadonlyQuery(String str, String str2, Map<String, Object> map, long j) {
        return graphQuery(str, GraphQueryParams.queryParams().readonly().query(str2).params(map).timeout(j));
    }

    private CommandObject<ResultSet> graphQuery(String str, GraphQueryParams graphQueryParams) {
        return new CommandObject<>(graphQueryParams.getArguments(str), getBuilder(str));
    }

    public final CommandObject<String> graphDelete(String str) {
        return new CommandObject<>(new CommandArguments(GraphProtocol.GraphCommand.DELETE).key(str), BuilderFactory.STRING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Builder<ResultSet> getBuilder(String str) {
        if (!this.builders.containsKey(str)) {
            createBuilder(str);
        }
        return this.builders.get(str);
    }

    private void createBuilder(String str) {
        synchronized (this.builders) {
            this.builders.putIfAbsent(str, new ResultSetBuilder(new GraphCacheImpl(str)));
        }
    }
}

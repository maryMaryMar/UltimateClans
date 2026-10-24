package me.module.multiserver.library.redis.jedis.graph;

import java.util.HashMap;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphQueryParams.class */
public class GraphQueryParams implements IParams {
    private boolean readonly;
    private String query;
    private Map<String, Object> params;
    private Long timeout;

    public GraphQueryParams() {
    }

    public static GraphQueryParams queryParams() {
        return new GraphQueryParams();
    }

    public GraphQueryParams(String str) {
        this.query = str;
    }

    public static GraphQueryParams queryParams(String str) {
        return new GraphQueryParams(str);
    }

    public GraphQueryParams readonly() {
        return readonly(true);
    }

    public GraphQueryParams readonly(boolean z) {
        this.readonly = z;
        return this;
    }

    public GraphQueryParams query(String str) {
        this.query = str;
        return this;
    }

    public GraphQueryParams params(Map<String, Object> map) {
        this.params = map;
        return this;
    }

    public GraphQueryParams addParam(String str, Object obj) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(str, obj);
        return this;
    }

    public GraphQueryParams timeout(long j) {
        this.timeout = Long.valueOf(j);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.query == null) {
            throw new JedisException("Query string must be set.");
        }
        if (this.params == null) {
            commandArguments.add(this.query);
        } else {
            commandArguments.add(RedisGraphQueryUtil.prepareQuery(this.query, this.params));
        }
        commandArguments.add(GraphProtocol.GraphKeyword.__COMPACT);
        if (this.timeout != null) {
            commandArguments.add(GraphProtocol.GraphKeyword.TIMEOUT).add(this.timeout).blocking();
        }
    }

    public CommandArguments getArguments(String str) {
        return new CommandArguments(!this.readonly ? GraphProtocol.GraphCommand.QUERY : GraphProtocol.GraphCommand.RO_QUERY).key(str).addParams(this);
    }
}

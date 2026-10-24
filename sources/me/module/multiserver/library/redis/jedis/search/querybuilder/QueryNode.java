package me.module.multiserver.library.redis.jedis.search.querybuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/QueryNode.class */
public abstract class QueryNode implements Node {
    private final List<Node> children = new ArrayList();

    protected abstract String getJoinString();

    public QueryNode add(String str, Value... valueArr) {
        this.children.add(new ValueNode(str, getJoinString(), valueArr));
        return this;
    }

    public QueryNode add(String str, String... strArr) {
        this.children.add(new ValueNode(str, getJoinString(), strArr));
        return this;
    }

    public QueryNode add(String str, Collection<Value> collection) {
        return add(str, (Value[]) collection.toArray(new Value[0]));
    }

    public QueryNode add(Node... nodeArr) {
        this.children.addAll(Arrays.asList(nodeArr));
        return this;
    }

    protected boolean shouldParenthesize(Node.Parenthesize parenthesize) {
        if (parenthesize == Node.Parenthesize.ALWAYS) {
            return true;
        }
        return parenthesize != Node.Parenthesize.NEVER && this.children.size() > 1;
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Node
    public String toString(Node.Parenthesize parenthesize) {
        StringBuilder sb = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(getJoinString());
        if (shouldParenthesize(parenthesize)) {
            sb.append('(');
        }
        Iterator<Node> it = this.children.iterator();
        while (it.hasNext()) {
            stringJoiner.add(it.next().toString(parenthesize));
        }
        sb.append(stringJoiner.toString());
        if (shouldParenthesize(parenthesize)) {
            sb.append(')');
        }
        return sb.toString();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Node
    public String toString() {
        return toString(Node.Parenthesize.DEFAULT);
    }
}

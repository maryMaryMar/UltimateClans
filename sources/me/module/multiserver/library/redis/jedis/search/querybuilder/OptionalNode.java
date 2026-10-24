package me.module.multiserver.library.redis.jedis.search.querybuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/OptionalNode.class */
public class OptionalNode extends IntersectNode {
    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.QueryNode, me.module.multiserver.library.redis.jedis.search.querybuilder.Node
    public String toString(Node.Parenthesize parenthesize) {
        String string = super.toString(Node.Parenthesize.NEVER);
        return shouldParenthesize(parenthesize) ? "~(" + string + ")" : "~" + string;
    }
}

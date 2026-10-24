package me.module.multiserver.library.redis.jedis.search.querybuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/DisjunctUnionNode.class */
public class DisjunctUnionNode extends DisjunctNode {
    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.IntersectNode, me.module.multiserver.library.redis.jedis.search.querybuilder.QueryNode
    protected String getJoinString() {
        return "|";
    }
}

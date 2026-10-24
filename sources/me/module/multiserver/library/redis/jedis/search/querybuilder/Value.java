package me.module.multiserver.library.redis.jedis.search.querybuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/Value.class */
public abstract class Value {
    public boolean isCombinable() {
        return false;
    }

    public abstract String toString();
}

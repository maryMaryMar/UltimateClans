package me.module.multiserver.library.redis.jedis.graph;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/Record.class */
public interface Record {
    <T> T getValue(int i);

    <T> T getValue(String str);

    String getString(int i);

    String getString(String str);

    List<String> keys();

    List<Object> values();

    boolean containsKey(String str);

    int size();
}

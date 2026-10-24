package me.module.multiserver.library.redis.jedis.util;

import java.util.AbstractMap;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/KeyValue.class */
public class KeyValue<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    public KeyValue(K k, V v) {
        super(k, v);
    }

    public static <K, V> KeyValue<K, V> of(K k, V v) {
        return new KeyValue<>(k, v);
    }
}

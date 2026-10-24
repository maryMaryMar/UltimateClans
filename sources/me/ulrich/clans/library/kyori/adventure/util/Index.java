package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Index.class */
public final class Index<K, V> {
    private final Map<K, V> keyToValue;
    private final Map<V, K> valueToKey;

    private Index(Map<K, V> map, Map<V, K> map2) {
        this.keyToValue = map;
        this.valueToKey = map2;
    }

    @NotNull
    public static <K, V extends Enum<V>> Index<K, V> create(Class<V> cls, @NotNull Function<? super V, ? extends K> function) {
        return create(cls, function, (Enum[]) cls.getEnumConstants());
    }

    /* JADX WARN: Incorrect types in method signature: <K:Ljava/lang/Object;V:Ljava/lang/Enum<TV;>;>(Ljava/lang/Class<TV;>;Ljava/util/function/Function<-TV;+TK;>;[TV;)Lme/ulrich/clans/library/kyori/adventure/util/Index<TK;TV;>; */
    @SafeVarargs
    @NotNull
    public static Index create(Class cls, @NotNull Function function, @NotNull Enum... enumArr) {
        return create(enumArr, i -> {
            return new EnumMap(cls);
        }, function);
    }

    @SafeVarargs
    @NotNull
    public static <K, V> Index<K, V> create(@NotNull Function<? super V, ? extends K> function, @NotNull V... vArr) {
        return create(vArr, HashMap::new, function);
    }

    @NotNull
    public static <K, V> Index<K, V> create(@NotNull Function<? super V, ? extends K> function, @NotNull List<V> list) {
        return create(list, HashMap::new, function);
    }

    @NotNull
    private static <K, V> Index<K, V> create(V[] vArr, IntFunction<Map<V, K>> intFunction, @NotNull Function<? super V, ? extends K> function) {
        return create(Arrays.asList(vArr), intFunction, function);
    }

    @NotNull
    private static <K, V> Index<K, V> create(List<V> list, IntFunction<Map<V, K>> intFunction, @NotNull Function<? super V, ? extends K> function) {
        int size = list.size();
        HashMap map = new HashMap(size);
        Map<V, K> mapApply = intFunction.apply(size);
        for (int i = 0; i < size; i++) {
            V v = list.get(i);
            K kApply = function.apply(v);
            if (map.putIfAbsent(kApply, v) != null) {
                throw new IllegalStateException(String.format("Key %s already mapped to value %s", kApply, map.get(kApply)));
            }
            if (mapApply.putIfAbsent(v, kApply) != null) {
                throw new IllegalStateException(String.format("Value %s already mapped to key %s", v, mapApply.get(v)));
            }
        }
        return new Index<>(Collections.unmodifiableMap(map), Collections.unmodifiableMap(mapApply));
    }

    @NotNull
    public Set<K> keys() {
        return Collections.unmodifiableSet(this.keyToValue.keySet());
    }

    @Nullable
    public K key(@NotNull V v) {
        return this.valueToKey.get(v);
    }

    @NotNull
    public K keyOrThrow(@NotNull V v) {
        K kKey = key(v);
        if (kKey == null) {
            throw new NoSuchElementException("There is no key for value " + v);
        }
        return kKey;
    }

    @Contract("_, null -> null; _, !null -> !null")
    public K keyOr(@NotNull V v, @Nullable K k) {
        K kKey = key(v);
        return kKey == null ? k : kKey;
    }

    @NotNull
    public Set<V> values() {
        return Collections.unmodifiableSet(this.valueToKey.keySet());
    }

    @Nullable
    public V value(@NotNull K k) {
        return this.keyToValue.get(k);
    }

    @NotNull
    public V valueOrThrow(@NotNull K k) {
        V vValue = value(k);
        if (vValue == null) {
            throw new NoSuchElementException("There is no value for key " + k);
        }
        return vValue;
    }

    @Contract("_, null -> null; _, !null -> !null")
    public V valueOr(@NotNull K k, @Nullable V v) {
        V vValue = value(k);
        return vValue == null ? v : vValue;
    }

    @NotNull
    public Map<K, V> keyToValue() {
        return Collections.unmodifiableMap(this.keyToValue);
    }

    @NotNull
    public Map<V, K> valueToKey() {
        return Collections.unmodifiableMap(this.valueToKey);
    }
}

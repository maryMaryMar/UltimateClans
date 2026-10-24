package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/InheritanceAwareMapImpl.class */
final class InheritanceAwareMapImpl<C, V> implements InheritanceAwareMap<C, V> {
    private static final Object NONE = new Object();
    static final InheritanceAwareMapImpl EMPTY = new InheritanceAwareMapImpl(false, Collections.emptyMap());
    private final Map<Class<? extends C>, V> declaredValues;
    private final boolean strict;
    private final transient ConcurrentMap<Class<? extends C>, Object> cache = new ConcurrentHashMap();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/InheritanceAwareMapImpl$BuilderImpl.class */
    static final class BuilderImpl<C, V> implements InheritanceAwareMap.Builder<C, V> {
        private boolean strict;
        private final Map<Class<? extends C>, V> values = new LinkedHashMap();

        BuilderImpl() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        public InheritanceAwareMap<C, V> build() {
            return new InheritanceAwareMapImpl(this.strict, Collections.unmodifiableMap(new LinkedHashMap(this.values)));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap.Builder
        @NotNull
        public InheritanceAwareMap.Builder<C, V> strict(boolean z) {
            if (z && !this.strict) {
                Iterator<Class<? extends C>> it = this.values.keySet().iterator();
                while (it.hasNext()) {
                    InheritanceAwareMapImpl.validateNoneInHierarchy(it.next(), this.values);
                }
            }
            this.strict = z;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap.Builder
        @NotNull
        public InheritanceAwareMap.Builder<C, V> put(@NotNull Class<? extends C> cls, @NotNull V v) {
            if (this.strict) {
                InheritanceAwareMapImpl.validateNoneInHierarchy(cls, this.values);
            }
            this.values.put((Class) Objects.requireNonNull(cls, "clazz"), (V) Objects.requireNonNull(v, "value"));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap.Builder
        @NotNull
        public InheritanceAwareMap.Builder<C, V> remove(@NotNull Class<? extends C> cls) {
            this.values.remove(Objects.requireNonNull(cls, "clazz"));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap.Builder
        @NotNull
        public InheritanceAwareMap.Builder<C, V> putAll(@NotNull InheritanceAwareMap<? extends C, ? extends V> inheritanceAwareMap) {
            InheritanceAwareMapImpl inheritanceAwareMapImpl = (InheritanceAwareMapImpl) inheritanceAwareMap;
            if (!this.strict || (this.values.isEmpty() && inheritanceAwareMapImpl.strict)) {
                this.values.putAll(inheritanceAwareMapImpl.declaredValues);
                return this;
            }
            for (Map.Entry entry : inheritanceAwareMapImpl.declaredValues.entrySet()) {
                InheritanceAwareMapImpl.validateNoneInHierarchy((Class) entry.getKey(), this.values);
                this.values.put((Class) entry.getKey(), (V) entry.getValue());
            }
            return this;
        }
    }

    InheritanceAwareMapImpl(boolean z, Map<Class<? extends C>, V> map) {
        this.strict = z;
        this.declaredValues = map;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap
    public boolean containsKey(@NotNull Class<? extends C> cls) {
        return get(cls) != null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap
    @Nullable
    public V get(@NotNull Class<? extends C> cls) {
        V v = (V) this.cache.computeIfAbsent(cls, cls2 -> {
            V v2 = this.declaredValues.get(cls2);
            if (v2 != null) {
                return v2;
            }
            for (Map.Entry<Class<? extends C>, V> entry : this.declaredValues.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls2)) {
                    return entry.getValue();
                }
            }
            return NONE;
        });
        if (v == NONE) {
            return null;
        }
        return v;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap
    @NotNull
    public InheritanceAwareMap<C, V> with(@NotNull Class<? extends C> cls, @NotNull V v) {
        if (Objects.equals(this.declaredValues.get(cls), v)) {
            return this;
        }
        if (this.strict) {
            validateNoneInHierarchy(cls, this.declaredValues);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.declaredValues);
        linkedHashMap.put(cls, v);
        return new InheritanceAwareMapImpl(this.strict, Collections.unmodifiableMap(linkedHashMap));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap
    @NotNull
    public InheritanceAwareMap<C, V> without(@NotNull Class<? extends C> cls) {
        if (!this.declaredValues.containsKey(cls)) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.declaredValues);
        linkedHashMap.remove(cls);
        return new InheritanceAwareMapImpl(this.strict, Collections.unmodifiableMap(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateNoneInHierarchy(Class<?> cls, Map<? extends Class<?>, ?> map) {
        Iterator<? extends Class<?>> it = map.keySet().iterator();
        while (it.hasNext()) {
            testHierarchy(it.next(), cls);
        }
    }

    private static void testHierarchy(Class<?> cls, Class<?> cls2) {
        if (cls.equals(cls2)) {
            return;
        }
        if (cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Conflict detected between already registered type " + cls + " and newly registered type " + cls2 + "! Types in a strict inheritance-aware map must not share a common hierarchy!");
        }
    }
}

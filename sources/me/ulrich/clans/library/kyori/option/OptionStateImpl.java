package me.ulrich.clans.library.kyori.option;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.option.value.ValueSource;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionStateImpl.class */
final class OptionStateImpl implements OptionState {
    private final OptionSchema schema;
    private final IdentityHashMap<Option<?>, Object> values;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionStateImpl$BuilderImpl.class */
    static final class BuilderImpl implements OptionState.Builder {
        private final OptionSchema schema;
        private final IdentityHashMap<Option<?>, Object> values = new IdentityHashMap<>();

        BuilderImpl(OptionSchema optionSchema) {
            this.schema = optionSchema;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.Builder
        public OptionState build() {
            return this.values.isEmpty() ? this.schema.emptyState() : new OptionStateImpl(this.schema, this.values);
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.Builder
        public <V> OptionState.Builder value(Option<V> option, V v) {
            if (!this.schema.has((Option) Objects.requireNonNull(option, "option"))) {
                throw new IllegalStateException("Option '" + option.id() + "' was not present in active schema");
            }
            if (v == null) {
                this.values.remove(option);
            } else {
                this.values.put(option, v);
            }
            return this;
        }

        private void putAll(Map<Option<?>, Object> map) {
            for (Map.Entry<Option<?>, Object> entry : map.entrySet()) {
                if (!this.schema.has(entry.getKey())) {
                    throw new IllegalStateException("Option '" + entry.getKey().id() + "' was not present in active schema");
                }
                this.values.put(entry.getKey(), entry.getValue());
            }
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.Builder
        public OptionState.Builder values(OptionState optionState) {
            if (optionState instanceof OptionStateImpl) {
                putAll(((OptionStateImpl) optionState).values);
            } else {
                if (!(optionState instanceof VersionedImpl)) {
                    throw new IllegalArgumentException("existing set " + optionState + " is of an unknown implementation type");
                }
                putAll(((OptionStateImpl) ((VersionedImpl) optionState).filtered).values);
            }
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.Builder
        public OptionState.Builder values(ValueSource valueSource) {
            for (Option<?> option : this.schema.knownOptions()) {
                Object objValue = valueSource.value(option);
                if (objValue != null) {
                    this.values.put(option, objValue);
                }
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionStateImpl$VersionedBuilderImpl.class */
    static final class VersionedBuilderImpl implements OptionState.VersionedBuilder {
        private final OptionSchema schema;
        private final Map<Integer, BuilderImpl> builders = new TreeMap();

        VersionedBuilderImpl(OptionSchema optionSchema) {
            this.schema = optionSchema;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.VersionedBuilder
        public OptionState.Versioned build() {
            if (this.builders.isEmpty()) {
                return new VersionedImpl(this.schema, Collections.emptySortedMap(), 0, this.schema.emptyState());
            }
            TreeMap treeMap = new TreeMap();
            for (Map.Entry<Integer, BuilderImpl> entry : this.builders.entrySet()) {
                treeMap.put(entry.getKey(), entry.getValue().build());
            }
            return new VersionedImpl(this.schema, treeMap, ((Integer) treeMap.lastKey()).intValue(), VersionedImpl.flattened(this.schema, treeMap, ((Integer) treeMap.lastKey()).intValue()));
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.VersionedBuilder
        public OptionState.VersionedBuilder version(int i, Consumer<OptionState.Builder> consumer) {
            ((Consumer) Objects.requireNonNull(consumer, "versionBuilder")).accept(this.builders.computeIfAbsent(Integer.valueOf(i), num -> {
                return new BuilderImpl(this.schema);
            }));
            return this;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionStateImpl$VersionedImpl.class */
    static final class VersionedImpl implements OptionState.Versioned {
        private final OptionSchema schema;
        private final SortedMap<Integer, OptionState> sets;
        private final int targetVersion;
        private final OptionState filtered;

        VersionedImpl(OptionSchema optionSchema, SortedMap<Integer, OptionState> sortedMap, int i, OptionState optionState) {
            this.schema = optionSchema;
            this.sets = sortedMap;
            this.targetVersion = i;
            this.filtered = optionState;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState
        public OptionSchema schema() {
            return this.schema;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState
        public boolean has(Option<?> option) {
            return this.filtered.has(option);
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState
        public <V> V value(Option<V> option) {
            return (V) this.filtered.value(option);
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.Versioned
        public Map<Integer, OptionState> childStates() {
            return Collections.unmodifiableSortedMap(this.sets.headMap(Integer.valueOf(this.targetVersion + 1)));
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionState.Versioned
        public OptionState.Versioned at(int i) {
            return new VersionedImpl(this.schema, this.sets, i, flattened(this.schema, this.sets, i));
        }

        public static OptionState flattened(OptionSchema optionSchema, SortedMap<Integer, OptionState> sortedMap, int i) {
            SortedMap<Integer, OptionState> sortedMapHeadMap = sortedMap.headMap(Integer.valueOf(i + 1));
            OptionState.Builder builderStateBuilder = optionSchema.stateBuilder();
            Iterator<OptionState> it = sortedMapHeadMap.values().iterator();
            while (it.hasNext()) {
                builderStateBuilder.values(it.next());
            }
            return builderStateBuilder.build();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            VersionedImpl versionedImpl = (VersionedImpl) obj;
            return this.targetVersion == versionedImpl.targetVersion && Objects.equals(this.schema, versionedImpl.schema) && Objects.equals(this.sets, versionedImpl.sets) && Objects.equals(this.filtered, versionedImpl.filtered);
        }

        public int hashCode() {
            return Objects.hash(this.schema, this.sets, Integer.valueOf(this.targetVersion), this.filtered);
        }

        public String toString() {
            return getClass().getSimpleName() + "{schema=" + this.schema + ", sets=" + this.sets + ", targetVersion=" + this.targetVersion + ", filtered=" + this.filtered + '}';
        }
    }

    OptionStateImpl(OptionSchema optionSchema, IdentityHashMap<Option<?>, Object> identityHashMap) {
        this.schema = optionSchema;
        this.values = new IdentityHashMap<>(identityHashMap);
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionState
    public OptionSchema schema() {
        return this.schema;
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionState
    public boolean has(Option<?> option) {
        return this.values.containsKey(Objects.requireNonNull(option, "flag"));
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionState
    public <V> V value(Option<V> option) {
        V vCast = option.valueType().type().cast(this.values.get(Objects.requireNonNull(option, "flag")));
        return vCast == null ? option.defaultValue() : vCast;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.values, ((OptionStateImpl) obj).values);
    }

    public int hashCode() {
        return Objects.hash(this.values);
    }

    public String toString() {
        return getClass().getSimpleName() + "{values=" + this.values + '}';
    }
}

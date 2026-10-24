package me.ulrich.clans.library.kyori.option;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.ulrich.clans.library.kyori.option.value.ValueType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionSchemaImpl.class */
final class OptionSchemaImpl implements OptionSchema {
    final OptionState emptyState;
    final ConcurrentMap<String, Option<?>> options = new ConcurrentHashMap();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionSchemaImpl$Instances.class */
    static final class Instances {
        static MutableImpl GLOBAL = new OptionSchemaImpl(null).new MutableImpl();

        Instances() {
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionSchemaImpl$MutableImpl.class */
    final class MutableImpl implements OptionSchema.Mutable {
        MutableImpl() {
        }

        <T> Option<T> register(String str, ValueType<T> valueType, T t) {
            OptionImpl optionImpl = new OptionImpl((String) Objects.requireNonNull(str, "id"), (ValueType) Objects.requireNonNull(valueType, "type"), t);
            if (OptionSchemaImpl.this.options.putIfAbsent(str, optionImpl) != null) {
                throw new IllegalStateException("Key " + str + " has already been used. Option keys must be unique within a schema.");
            }
            return optionImpl;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema.Mutable
        public Option<String> stringOption(String str, String str2) {
            return register(str, ValueType.stringType(), str2);
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema.Mutable
        public Option<Boolean> booleanOption(String str, boolean z) {
            return register(str, ValueType.booleanType(), Boolean.valueOf(z));
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema.Mutable
        public Option<Integer> intOption(String str, int i) {
            return register(str, ValueType.integerType(), Integer.valueOf(i));
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema.Mutable
        public Option<Double> doubleOption(String str, double d) {
            return register(str, ValueType.doubleType(), Double.valueOf(d));
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema.Mutable
        public <E extends Enum<E>> Option<E> enumOption(String str, Class<E> cls, E e) {
            return register(str, ValueType.enumType(cls), e);
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema.Mutable
        public OptionSchema frozenView() {
            return OptionSchemaImpl.this;
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema
        public Set<Option<?>> knownOptions() {
            return OptionSchemaImpl.this.knownOptions();
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema
        public boolean has(Option<?> option) {
            return OptionSchemaImpl.this.has(option);
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema
        public OptionState.Builder stateBuilder() {
            return OptionSchemaImpl.this.stateBuilder();
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema
        public OptionState.VersionedBuilder versionedStateBuilder() {
            return OptionSchemaImpl.this.versionedStateBuilder();
        }

        @Override // me.ulrich.clans.library.kyori.option.OptionSchema
        public OptionState emptyState() {
            return OptionSchemaImpl.this.emptyState();
        }

        public String toString() {
            return "MutableImpl{schema=" + OptionSchemaImpl.this + "}";
        }
    }

    OptionSchemaImpl(OptionSchemaImpl optionSchemaImpl) {
        if (optionSchemaImpl != null) {
            this.options.putAll(optionSchemaImpl.options);
        }
        this.emptyState = new OptionStateImpl(this, new IdentityHashMap());
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionSchema
    public Set<Option<?>> knownOptions() {
        return Collections.unmodifiableSet(new HashSet(this.options.values()));
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionSchema
    public boolean has(Option<?> option) {
        Option<?> option2 = this.options.get(option.id());
        return option2 != null && option2.equals(option);
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionSchema
    public OptionState.Builder stateBuilder() {
        return new OptionStateImpl.BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionSchema
    public OptionState.VersionedBuilder versionedStateBuilder() {
        return new OptionStateImpl.VersionedBuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.option.OptionSchema
    public OptionState emptyState() {
        return this.emptyState;
    }

    public String toString() {
        return "OptionSchemaImpl{options=" + this.options + '}';
    }
}

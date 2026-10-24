package me.ulrich.clans.library.kyori.option;

import java.util.Objects;
import me.ulrich.clans.library.kyori.option.value.ValueType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionImpl.class */
final class OptionImpl<V> implements Option<V> {
    private final String id;
    private final ValueType<V> type;
    private final V defaultValue;

    OptionImpl(String str, ValueType<V> valueType, V v) {
        this.id = str;
        this.type = valueType;
        this.defaultValue = v;
    }

    @Override // me.ulrich.clans.library.kyori.option.Option
    public String id() {
        return this.id;
    }

    @Override // me.ulrich.clans.library.kyori.option.Option
    public ValueType<V> valueType() {
        return this.type;
    }

    @Override // me.ulrich.clans.library.kyori.option.Option
    public V defaultValue() {
        return this.defaultValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OptionImpl optionImpl = (OptionImpl) obj;
        return Objects.equals(this.id, optionImpl.id) && Objects.equals(this.type, optionImpl.type);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.type);
    }

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.id + ",type=" + this.type + ",defaultValue=" + this.defaultValue + '}';
    }
}

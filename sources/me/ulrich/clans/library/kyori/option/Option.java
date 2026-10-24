package me.ulrich.clans.library.kyori.option;

import me.ulrich.clans.library.kyori.option.value.ValueType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/Option.class */
@ApiStatus.NonExtendable
public interface Option<V> {
    @Deprecated
    static Option<Boolean> booleanOption(String str, boolean z) {
        return OptionSchema.globalSchema().booleanOption(str, z);
    }

    @Deprecated
    static <E extends Enum<E>> Option<E> enumOption(String str, Class<E> cls, E e) {
        return OptionSchema.globalSchema().enumOption(str, cls, e);
    }

    String id();

    @Deprecated
    default Class<V> type() {
        return valueType().type();
    }

    ValueType<V> valueType();

    V defaultValue();
}

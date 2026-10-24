package me.ulrich.clans.library.kyori.option.value;

import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueType.class */
public interface ValueType<T> {
    static ValueType<String> stringType() {
        return ValueTypeImpl.Types.STRING;
    }

    static ValueType<Boolean> booleanType() {
        return ValueTypeImpl.Types.BOOLEAN;
    }

    static ValueType<Integer> integerType() {
        return ValueTypeImpl.Types.INT;
    }

    static ValueType<Double> doubleType() {
        return ValueTypeImpl.Types.DOUBLE;
    }

    static <E extends Enum<E>> ValueType<E> enumType(Class<E> cls) {
        return new ValueTypeImpl.EnumType((Class) Objects.requireNonNull(cls, "enumClazz"));
    }

    Class<T> type();

    T parse(String str);
}

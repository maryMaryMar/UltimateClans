package me.ulrich.clans.library.kyori.option.value;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueTypeImpl.class */
abstract class ValueTypeImpl<T> implements ValueType<T> {
    private final Class<T> type;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueTypeImpl$EnumType.class */
    static final class EnumType<E extends Enum<E>> extends ValueTypeImpl<E> {
        private final Map<String, E> values;

        EnumType(Class<E> cls) {
            super(cls);
            this.values = new HashMap();
            for (E e : cls.getEnumConstants()) {
                this.values.put(e.name().toLowerCase(Locale.ROOT), e);
            }
        }

        @Override // me.ulrich.clans.library.kyori.option.value.ValueType
        public E parse(String str) {
            E e = this.values.get(str.toLowerCase(Locale.ROOT));
            if (e == null) {
                throw doNotKnowHowToTurn(str, type(), null);
            }
            return e;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueTypeImpl$Types.class */
    static final class Types {
        static ValueType<String> STRING = new ValueTypeImpl<String>(String.class) { // from class: me.ulrich.clans.library.kyori.option.value.ValueTypeImpl.Types.1
            @Override // me.ulrich.clans.library.kyori.option.value.ValueType
            public String parse(String str) {
                return str;
            }
        };
        static ValueType<Boolean> BOOLEAN = new ValueTypeImpl<Boolean>(Boolean.class) { // from class: me.ulrich.clans.library.kyori.option.value.ValueTypeImpl.Types.2
            @Override // me.ulrich.clans.library.kyori.option.value.ValueType
            public Boolean parse(String str) {
                if (str.equalsIgnoreCase("true")) {
                    return Boolean.TRUE;
                }
                if (str.equalsIgnoreCase("false")) {
                    return Boolean.FALSE;
                }
                throw doNotKnowHowToTurn(str, Boolean.class, null);
            }
        };
        static ValueType<Integer> INT = new ValueTypeImpl<Integer>(Integer.class) { // from class: me.ulrich.clans.library.kyori.option.value.ValueTypeImpl.Types.3
            @Override // me.ulrich.clans.library.kyori.option.value.ValueType
            public Integer parse(String str) {
                try {
                    return Integer.decode(str);
                } catch (NumberFormatException e) {
                    throw doNotKnowHowToTurn(str, Integer.class, e.getMessage());
                }
            }
        };
        static ValueType<Double> DOUBLE = new ValueTypeImpl<Double>(Double.class) { // from class: me.ulrich.clans.library.kyori.option.value.ValueTypeImpl.Types.4
            @Override // me.ulrich.clans.library.kyori.option.value.ValueType
            public Double parse(String str) {
                try {
                    return Double.valueOf(Double.parseDouble(str));
                } catch (NumberFormatException e) {
                    throw doNotKnowHowToTurn(str, Double.class, e.getMessage());
                }
            }
        };

        private Types() {
        }
    }

    ValueTypeImpl(Class<T> cls) {
        this.type = cls;
    }

    @Override // me.ulrich.clans.library.kyori.option.value.ValueType
    public Class<T> type() {
        return this.type;
    }

    static IllegalArgumentException doNotKnowHowToTurn(String str, Class<?> cls, String str2) {
        throw new IllegalArgumentException("Do not know how to turn value '" + str + "' into a " + cls.getName() + (str2 == null ? "" : ": " + str2));
    }
}

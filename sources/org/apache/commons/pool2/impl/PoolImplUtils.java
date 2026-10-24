package org.apache.commons.pool2.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.udojava.evalex.Expression;
import org.apache.commons.pool2.PooledObjectFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/PoolImplUtils.class */
class PoolImplUtils {

    /* JADX INFO: renamed from: org.apache.commons.pool2.impl.PoolImplUtils$1, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/PoolImplUtils$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit = new int[TimeUnit.values().length];

        static {
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    PoolImplUtils() {
    }

    static Class<?> getFactoryType(Class<? extends PooledObjectFactory> cls) {
        Type[] bounds;
        Object genericType = getGenericType(PooledObjectFactory.class, cls);
        if (!(genericType instanceof Integer)) {
            return (Class) genericType;
        }
        ParameterizedType parameterizedType = getParameterizedType(PooledObjectFactory.class, cls);
        if (parameterizedType == null || (bounds = ((TypeVariable) parameterizedType.getActualTypeArguments()[((Integer) genericType).intValue()]).getBounds()) == null || bounds.length <= 0) {
            return Object.class;
        }
        Type type = bounds[0];
        return type instanceof Class ? (Class) type : Object.class;
    }

    private static <T> Object getGenericType(Class<T> cls, Class<? extends T> cls2) {
        if (cls == null || cls2 == null) {
            return null;
        }
        ParameterizedType parameterizedType = getParameterizedType(cls, cls2);
        if (parameterizedType != null) {
            return getTypeParameter(cls2, parameterizedType.getActualTypeArguments()[0]);
        }
        Object genericType = getGenericType(cls, cls2.getSuperclass());
        if (genericType instanceof Class) {
            return genericType;
        }
        if (genericType instanceof Integer) {
            return getTypeParameter(cls2, ((ParameterizedType) cls2.getGenericSuperclass()).getActualTypeArguments()[((Integer) genericType).intValue()]);
        }
        return null;
    }

    private static <T> ParameterizedType getParameterizedType(Class<T> cls, Class<? extends T> cls2) {
        for (Type type : cls2.getGenericInterfaces()) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if ((parameterizedType.getRawType() instanceof Class) && cls.isAssignableFrom((Class) parameterizedType.getRawType())) {
                    return parameterizedType;
                }
            }
        }
        return null;
    }

    private static Object getTypeParameter(Class<?> cls, Type type) {
        if (type instanceof Class) {
            return type;
        }
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            if (typeParameters[i].equals(type)) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    static boolean isPositive(Duration duration) {
        return (duration == null || duration.isNegative() || duration.isZero()) ? false : true;
    }

    static Instant max(Instant instant, Instant instant2) {
        return instant.compareTo(instant2) > 0 ? instant : instant2;
    }

    static Instant min(Instant instant, Instant instant2) {
        return instant.compareTo(instant2) < 0 ? instant : instant2;
    }

    static ChronoUnit toChronoUnit(TimeUnit timeUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[((TimeUnit) Objects.requireNonNull(timeUnit)).ordinal()]) {
            case 1:
                return ChronoUnit.NANOS;
            case 2:
                return ChronoUnit.MICROS;
            case 3:
                return ChronoUnit.MILLIS;
            case 4:
                return ChronoUnit.SECONDS;
            case 5:
                return ChronoUnit.MINUTES;
            case 6:
                return ChronoUnit.HOURS;
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                return ChronoUnit.DAYS;
            default:
                throw new IllegalArgumentException(timeUnit.toString());
        }
    }

    static Duration nonNull(Duration duration, Duration duration2) {
        return duration != null ? duration : (Duration) Objects.requireNonNull(duration2, "defaultValue");
    }

    static Duration toDuration(long j, TimeUnit timeUnit) {
        return Duration.of(j, toChronoUnit(timeUnit));
    }
}

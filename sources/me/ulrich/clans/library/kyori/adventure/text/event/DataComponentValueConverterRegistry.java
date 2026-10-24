package me.ulrich.clans.library.kyori.adventure.text.event;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValueConverterRegistry.class */
public final class DataComponentValueConverterRegistry {
    private static final Set<Provider> PROVIDERS = Services.services(Provider.class);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValueConverterRegistry$Conversion.class */
    @ApiStatus.NonExtendable
    public interface Conversion<I, O> extends Examinable {
        @NotNull
        static <I1, O1> Conversion<I1, O1> convert(@NotNull Class<I1> cls, @NotNull Class<O1> cls2, @NotNull BiFunction<Key, I1, O1> biFunction) {
            return new DataComponentValueConversionImpl((Class) Objects.requireNonNull(cls, "src"), (Class) Objects.requireNonNull(cls2, "dst"), (BiFunction) Objects.requireNonNull(biFunction, "op"));
        }

        @Contract(pure = true)
        @NotNull
        Class<I> source();

        @Contract(pure = true)
        @NotNull
        Class<O> destination();

        @NotNull
        O convert(@NotNull Key key, @NotNull I i);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValueConverterRegistry$ConversionCache.class */
    static final class ConversionCache {
        private static final ConcurrentMap<Class<?>, ConcurrentMap<Class<?>, RegisteredConversion>> CACHE = new ConcurrentHashMap();
        private static final Map<Class<?>, Set<RegisteredConversion>> CONVERSIONS = collectConversions();

        ConversionCache() {
        }

        private static Map<Class<?>, Set<RegisteredConversion>> collectConversions() {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Provider provider : DataComponentValueConverterRegistry.PROVIDERS) {
                Key key = (Key) Objects.requireNonNull(provider.id(), (Supplier<String>) () -> {
                    return "ID of provider " + provider + " is null";
                });
                for (Conversion<?, ?> conversion : provider.conversions()) {
                    ((Set) concurrentHashMap.computeIfAbsent(conversion.source(), cls -> {
                        return ConcurrentHashMap.newKeySet();
                    })).add(new RegisteredConversion(key, conversion));
                }
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                entry.setValue(Collections.unmodifiableSet((Set) entry.getValue()));
            }
            return new ConcurrentHashMap(concurrentHashMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static RegisteredConversion compute(Class<?> cls, Class<?> cls2) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(cls);
            while (true) {
                Class cls3 = (Class) arrayDeque.poll();
                if (cls3 == null) {
                    return RegisteredConversion.NONE;
                }
                Set<RegisteredConversion> set = CONVERSIONS.get(cls3);
                if (set != null) {
                    RegisteredConversion registeredConversion = null;
                    for (RegisteredConversion registeredConversion2 : set) {
                        Class<?> clsDestination = registeredConversion2.conversion.destination();
                        if (cls2.equals(clsDestination)) {
                            return registeredConversion2;
                        }
                        if (cls2.isAssignableFrom(clsDestination) && (registeredConversion == null || clsDestination.isAssignableFrom(registeredConversion.conversion.destination()))) {
                            registeredConversion = registeredConversion2;
                        }
                    }
                    if (registeredConversion != null) {
                        return registeredConversion;
                    }
                }
                addSupertypes(cls3, arrayDeque);
            }
        }

        private static void addSupertypes(Class<?> cls, Deque<Class<?>> deque) {
            if (cls.getSuperclass() != null) {
                deque.add(cls.getSuperclass());
            }
            deque.addAll(Arrays.asList(cls.getInterfaces()));
        }

        @Nullable
        static RegisteredConversion converter(Class<? extends DataComponentValue> cls, Class<? extends DataComponentValue> cls2) {
            RegisteredConversion registeredConversionComputeIfAbsent = CACHE.computeIfAbsent(cls, cls3 -> {
                return new ConcurrentHashMap();
            }).computeIfAbsent(cls2, cls4 -> {
                return compute(cls, cls2);
            });
            if (registeredConversionComputeIfAbsent == RegisteredConversion.NONE) {
                return null;
            }
            return registeredConversionComputeIfAbsent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValueConverterRegistry$Provider.class */
    public interface Provider {
        @NotNull
        Key id();

        @NotNull
        Iterable<Conversion<?, ?>> conversions();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValueConverterRegistry$RegisteredConversion.class */
    static final class RegisteredConversion {
        static final RegisteredConversion NONE = new RegisteredConversion(null, null);
        final Key provider;
        final Conversion<?, ?> conversion;

        RegisteredConversion(Key key, Conversion<?, ?> conversion) {
            this.provider = key;
            this.conversion = conversion;
        }
    }

    private DataComponentValueConverterRegistry() {
    }

    public static Set<Key> knownProviders() {
        return Collections.unmodifiableSet((Set) PROVIDERS.stream().map((v0) -> {
            return v0.id();
        }).collect(Collectors.toSet()));
    }

    @NotNull
    public static <O extends DataComponentValue> O convert(@NotNull Class<O> cls, @NotNull Key key, @NotNull DataComponentValue dataComponentValue) {
        if (cls.isInstance(dataComponentValue)) {
            return cls.cast(dataComponentValue);
        }
        RegisteredConversion registeredConversionConverter = ConversionCache.converter(dataComponentValue.getClass(), cls);
        if (registeredConversionConverter == null) {
            throw new IllegalArgumentException("There is no data holder converter registered to convert from a " + dataComponentValue.getClass() + " instance to a " + cls + " (on field " + key + ")");
        }
        try {
            return (O) registeredConversionConverter.conversion.convert(key, dataComponentValue);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to convert data component value of type " + dataComponentValue.getClass() + " to type " + cls + " due to an error in a converter provided by " + registeredConversionConverter.provider.asString() + DecorationTag.REVERT, e);
        }
    }
}

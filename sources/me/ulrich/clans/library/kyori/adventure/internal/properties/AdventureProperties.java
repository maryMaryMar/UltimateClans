package me.ulrich.clans.library.kyori.adventure.internal.properties;

import java.util.Objects;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/internal/properties/AdventureProperties.class */
@ApiStatus.Internal
public final class AdventureProperties {
    public static final Property<Boolean> DEBUG = property("debug", Boolean::parseBoolean, false);
    public static final Property<String> DEFAULT_TRANSLATION_LOCALE = property("defaultTranslationLocale", Function.identity(), null);
    public static final Property<Boolean> SERVICE_LOAD_FAILURES_ARE_FATAL = property("serviceLoadFailuresAreFatal", Boolean::parseBoolean, Boolean.TRUE, false);
    public static final Property<Boolean> TEXT_WARN_WHEN_LEGACY_FORMATTING_DETECTED = property("text.warnWhenLegacyFormattingDetected", Boolean::parseBoolean, Boolean.FALSE);
    public static final Property<Integer> DEFAULT_FLATTENER_NESTING_LIMIT = property("defaultFlattenerNestingLimit", Integer::parseInt, -1);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/internal/properties/AdventureProperties$DefaultOverrideProvider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface DefaultOverrideProvider {
        @Nullable
        <T> T overrideDefault(@NotNull Property<T> property, @Nullable T t);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/internal/properties/AdventureProperties$Property.class */
    @ApiStatus.Internal
    @ApiStatus.NonExtendable
    public interface Property<T> {
        @Nullable
        T value();

        @NotNull
        default T valueOr(@NotNull T t) {
            T tValue = value();
            return tValue == null ? (T) Objects.requireNonNull(t, "defaultValue") : tValue;
        }
    }

    private AdventureProperties() {
    }

    @NotNull
    public static <T> Property<T> property(@NotNull String str, @NotNull Function<String, T> function, @Nullable T t) {
        return property(str, function, t, true);
    }

    @NotNull
    public static <T> Property<T> property(@NotNull String str, @NotNull Function<String, T> function, @Nullable T t, boolean z) {
        return AdventurePropertiesImpl.property(str, function, t, z);
    }
}

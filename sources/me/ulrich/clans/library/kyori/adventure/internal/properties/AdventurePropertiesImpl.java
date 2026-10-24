package me.ulrich.clans.library.kyori.adventure.internal.properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/internal/properties/AdventurePropertiesImpl.class */
final class AdventurePropertiesImpl {
    private static final String FILESYSTEM_DIRECTORY_NAME = "config";
    private static final String FILESYSTEM_FILE_NAME = "adventure.properties";
    private static final Properties PROPERTIES = new Properties();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/internal/properties/AdventurePropertiesImpl$PropertyImpl.class */
    private static final class PropertyImpl<T> implements AdventureProperties.Property<T> {
        private final String name;
        private final Function<String, T> parser;

        @Nullable
        private final T defaultValue;
        private final boolean allowProviderDefaultOverride;
        private boolean valueCalculated;

        @Nullable
        private T value;

        PropertyImpl(@NotNull String str, @NotNull Function<String, T> function, @Nullable T t, boolean z) {
            this.name = str;
            this.parser = function;
            this.defaultValue = t;
            this.allowProviderDefaultOverride = z;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.internal.properties.AdventureProperties.Property
        @Nullable
        public T value() {
            if (!this.valueCalculated) {
                String property = System.getProperty(AdventurePropertiesImpl.systemPropertyName(this.name), AdventurePropertiesImpl.PROPERTIES.getProperty(this.name));
                if (property != null) {
                    this.value = this.parser.apply(property);
                }
                if (this.value == null) {
                    if (this.allowProviderDefaultOverride) {
                        this.value = (T) Providers.DEFAULT_PROVIDER.map(defaultOverrideProvider -> {
                            return defaultOverrideProvider.overrideDefault(this, this.defaultValue);
                        }).orElse(this.defaultValue);
                    } else {
                        this.value = this.defaultValue;
                    }
                }
                this.valueCalculated = true;
            }
            return this.value;
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/internal/properties/AdventurePropertiesImpl$Providers.class */
    static final class Providers {

        @NotNull
        static final Optional<AdventureProperties.DefaultOverrideProvider> DEFAULT_PROVIDER = Services.service(AdventureProperties.DefaultOverrideProvider.class);

        Providers() {
        }
    }

    private static void print(Throwable th) {
        th.printStackTrace();
    }

    private AdventurePropertiesImpl() {
    }

    @VisibleForTesting
    @NotNull
    static String systemPropertyName(String str) {
        return String.join(".", "net", "kyori", Adventure.NAMESPACE, str);
    }

    static <T> AdventureProperties.Property<T> property(@NotNull String str, @NotNull Function<String, T> function, @Nullable T t, boolean z) {
        return new PropertyImpl(str, function, t, z);
    }

    static {
        Path path = (Path) Optional.ofNullable(System.getProperty(systemPropertyName(FILESYSTEM_DIRECTORY_NAME))).map(str -> {
            return Paths.get(str, new String[0]);
        }).orElseGet(() -> {
            return Paths.get(FILESYSTEM_DIRECTORY_NAME, FILESYSTEM_FILE_NAME);
        });
        if (Files.isRegularFile(path, new LinkOption[0])) {
            try {
                InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    PROPERTIES.load(inputStreamNewInputStream);
                    if (inputStreamNewInputStream != null) {
                        inputStreamNewInputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamNewInputStream != null) {
                        try {
                            inputStreamNewInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                print(e);
            }
        }
    }
}

package me.ulrich.clans.library.kyori.adventure.translation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/TranslationRegistry.class */
@Deprecated
public interface TranslationRegistry extends TranslationStore.StringBased<MessageFormat>, Translator {

    @Deprecated
    public static final Pattern SINGLE_QUOTE_PATTERN = Pattern.compile("'");

    @Deprecated
    @NotNull
    static TranslationRegistry create(Key key) {
        return new MessageFormatTranslationStore((Key) Objects.requireNonNull(key, "name"));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    @Deprecated
    boolean contains(@NotNull String str);

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Deprecated
    @Nullable
    MessageFormat translate(@NotNull String str, @NotNull Locale locale);

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    @Deprecated
    void defaultLocale(@NotNull Locale locale);

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    @Deprecated
    void register(@NotNull String str, @NotNull Locale locale, @NotNull MessageFormat messageFormat);

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    @Deprecated
    default void registerAll(@NotNull Locale locale, @NotNull Map<String, MessageFormat> map) {
        Set<String> setKeySet = map.keySet();
        Objects.requireNonNull(map);
        registerAll(locale, setKeySet, (v1) -> {
            return r3.get(v1);
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore.StringBased
    @Deprecated
    default void registerAll(@NotNull Locale locale, @NotNull Path path, boolean z) {
        try {
            BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            try {
                registerAll(locale, new PropertyResourceBundle(bufferedReaderNewBufferedReader), z);
                if (bufferedReaderNewBufferedReader != null) {
                    bufferedReaderNewBufferedReader.close();
                }
            } catch (Throwable th) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore.StringBased
    @Deprecated
    default void registerAll(@NotNull Locale locale, @NotNull ResourceBundle resourceBundle, boolean z) {
        registerAll(locale, resourceBundle.keySet(), str -> {
            String string = resourceBundle.getString(str);
            return new MessageFormat(z ? SINGLE_QUOTE_PATTERN.matcher(string).replaceAll("''") : string, locale);
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    @Deprecated
    default void registerAll(@NotNull Locale locale, @NotNull Set<String> set, Function<String, MessageFormat> function) {
        IllegalArgumentException illegalArgumentException = null;
        int i = 0;
        for (String str : set) {
            try {
                register(str, locale, function.apply(str));
            } catch (IllegalArgumentException e) {
                if (illegalArgumentException == null) {
                    illegalArgumentException = e;
                }
                i++;
            }
        }
        if (illegalArgumentException != null) {
            if (i == 1) {
                throw illegalArgumentException;
            }
            if (i > 1) {
                throw new IllegalArgumentException(String.format("Invalid key (and %d more)", Integer.valueOf(i - 1)), illegalArgumentException);
            }
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    @Deprecated
    void unregister(@NotNull String str);
}

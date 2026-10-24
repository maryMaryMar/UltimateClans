package me.ulrich.clans.library.kyori.adventure.translation;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/TranslationStore.class */
public interface TranslationStore<T> extends Translator {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/TranslationStore$StringBased.class */
    public interface StringBased<T> extends TranslationStore<T> {
        void registerAll(@NotNull Locale locale, @NotNull Path path, boolean z);

        void registerAll(@NotNull Locale locale, @NotNull ResourceBundle resourceBundle, boolean z);
    }

    @NotNull
    static TranslationStore<Component> component(@NotNull Key key) {
        return new ComponentTranslationStore((Key) Objects.requireNonNull(key, "name"));
    }

    static StringBased<MessageFormat> messageFormat(@NotNull Key key) {
        return new MessageFormatTranslationStore((Key) Objects.requireNonNull(key, "name"));
    }

    boolean contains(@NotNull String str);

    boolean contains(@NotNull String str, @NotNull Locale locale);

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    default boolean canTranslate(@NotNull String str, @NotNull Locale locale) {
        return super.canTranslate(str, locale);
    }

    void defaultLocale(@NotNull Locale locale);

    void register(@NotNull String str, @NotNull Locale locale, T t);

    void registerAll(@NotNull Locale locale, @NotNull Map<String, T> map);

    void registerAll(@NotNull Locale locale, @NotNull Set<String> set, Function<String, T> function);

    void unregister(@NotNull String str);
}

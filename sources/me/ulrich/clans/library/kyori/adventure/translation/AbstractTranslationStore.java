package me.ulrich.clans.library.kyori.adventure.translation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/AbstractTranslationStore.class */
public abstract class AbstractTranslationStore<T> implements TranslationStore<T>, Examinable {

    @NotNull
    private final Key name;
    private final Map<String, AbstractTranslationStore<T>.Translation> translations = new ConcurrentHashMap();

    @NotNull
    private volatile Locale defaultLocale = Locale.US;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/AbstractTranslationStore$StringBased.class */
    public static abstract class StringBased<T> extends AbstractTranslationStore<T> implements TranslationStore.StringBased<T> {
        private static final Pattern SINGLE_QUOTE_PATTERN = Pattern.compile("'");

        protected StringBased(@NotNull Key key) {
            super(key);
        }

        @NotNull
        protected abstract T parse(@NotNull String str, @NotNull Locale locale);

        @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore.StringBased
        public final void registerAll(@NotNull Locale locale, @NotNull Path path, boolean z) {
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
        public final void registerAll(@NotNull Locale locale, @NotNull ResourceBundle resourceBundle, boolean z) {
            registerAll(locale, resourceBundle.keySet(), str -> {
                String string = resourceBundle.getString(str);
                return parse(z ? SINGLE_QUOTE_PATTERN.matcher(string).replaceAll("''") : string, locale);
            });
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/AbstractTranslationStore$Translation.class */
    private final class Translation implements Examinable {
        private final String key;
        private final Map<Locale, T> translations;

        private Translation(String str) {
            this.key = (String) Objects.requireNonNull(str, KeybindTag.KEYBIND);
            this.translations = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public T translate(@NotNull Locale locale) {
            T t = this.translations.get(Objects.requireNonNull(locale, "locale"));
            if (t == null) {
                t = this.translations.get(new Locale(locale.getLanguage()));
                if (t == null) {
                    t = this.translations.get(AbstractTranslationStore.this.defaultLocale);
                    if (t == null) {
                        t = this.translations.get(TranslationLocales.global());
                    }
                }
            }
            return t;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void register(@NotNull Locale locale, @NotNull T t) {
            if (this.translations.putIfAbsent((Locale) Objects.requireNonNull(locale, "locale"), (T) Objects.requireNonNull(t, "translation")) != null) {
                throw new IllegalArgumentException(String.format("Translation already exists: %s for %s", this.key, locale));
            }
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of(KeybindTag.KEYBIND, this.key), ExaminableProperty.of("translations", this.translations)});
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Translation)) {
                return false;
            }
            Translation translation = (Translation) obj;
            return this.key.equals(translation.key) && this.translations.equals(translation.translations);
        }

        public int hashCode() {
            return Objects.hash(this.key, this.translations);
        }

        public String toString() {
            return Internals.toString(this);
        }
    }

    protected AbstractTranslationStore(@NotNull Key key) {
        this.name = (Key) Objects.requireNonNull(key, "name");
    }

    @Nullable
    protected T translationValue(@NotNull String str, @NotNull Locale locale) {
        AbstractTranslationStore<T>.Translation translation = this.translations.get(Objects.requireNonNull(str, KeybindTag.KEYBIND));
        if (translation == null) {
            return null;
        }
        return (T) translation.translate((Locale) Objects.requireNonNull(locale, "locale"));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    public final boolean contains(@NotNull String str) {
        return this.translations.containsKey(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    public final boolean contains(@NotNull String str, @NotNull Locale locale) {
        AbstractTranslationStore<T>.Translation translation = this.translations.get(Objects.requireNonNull(str, KeybindTag.KEYBIND));
        return (translation == null || ((Translation) translation).translations.get(Objects.requireNonNull(locale, "locale")) == null) ? false : true;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore, me.ulrich.clans.library.kyori.adventure.translation.Translator
    public final boolean canTranslate(@NotNull String str, @NotNull Locale locale) {
        AbstractTranslationStore<T>.Translation translation = this.translations.get(Objects.requireNonNull(str, KeybindTag.KEYBIND));
        return (translation == null || translation.translate((Locale) Objects.requireNonNull(locale, "locale")) == null) ? false : true;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    public final void defaultLocale(@NotNull Locale locale) {
        this.defaultLocale = (Locale) Objects.requireNonNull(locale, "locale");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    public final void register(@NotNull String str, @NotNull Locale locale, @NotNull T t) {
        this.translations.computeIfAbsent(str, str2 -> {
            return new Translation(str2);
        }).register(locale, t);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    public final void registerAll(@NotNull Locale locale, @NotNull Map<String, T> map) {
        Set<String> setKeySet = map.keySet();
        Objects.requireNonNull(map);
        registerAll(locale, setKeySet, (v1) -> {
            return r3.get(v1);
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationStore
    public final void registerAll(@NotNull Locale locale, @NotNull Set<String> set, Function<String, T> function) {
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
    public final void unregister(@NotNull String str) {
        this.translations.remove(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @NotNull
    public final Key name() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @NotNull
    public final TriState hasAnyTranslations() {
        return TriState.byBoolean(!this.translations.isEmpty());
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public final Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("translations", this.translations));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractTranslationStore) {
            return this.name.equals(((AbstractTranslationStore) obj).name);
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    @NotNull
    public final String toString() {
        return Internals.toString(this);
    }
}

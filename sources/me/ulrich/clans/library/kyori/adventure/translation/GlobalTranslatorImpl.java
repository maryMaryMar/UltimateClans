package me.ulrich.clans.library.kyori.adventure.translation;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.adventure.text.renderer.TranslatableComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/GlobalTranslatorImpl.class */
final class GlobalTranslatorImpl implements GlobalTranslator {
    private static final Key NAME = Key.key(Adventure.NAMESPACE, "global");
    static final GlobalTranslatorImpl INSTANCE = new GlobalTranslatorImpl();
    final TranslatableComponentRenderer<Locale> renderer = TranslatableComponentRenderer.usingTranslationSource(this);
    private final Set<Translator> sources = Collections.newSetFromMap(new ConcurrentHashMap());

    private GlobalTranslatorImpl() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @NotNull
    public Key name() {
        return NAME;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator
    @NotNull
    public Iterable<? extends Translator> sources() {
        return Collections.unmodifiableSet(this.sources);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator
    public boolean addSource(@NotNull Translator translator) {
        Objects.requireNonNull(translator, "source");
        if (translator == this) {
            throw new IllegalArgumentException("GlobalTranslationSource");
        }
        return this.sources.add(translator);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator
    public boolean removeSource(@NotNull Translator translator) {
        Objects.requireNonNull(translator, "source");
        return this.sources.remove(translator);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @NotNull
    public TriState hasAnyTranslations() {
        return !this.sources.isEmpty() ? TriState.TRUE : TriState.FALSE;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    public boolean canTranslate(@NotNull String str, @NotNull Locale locale) {
        Objects.requireNonNull(str, KeybindTag.KEYBIND);
        Objects.requireNonNull(locale, "locale");
        Iterator<Translator> it = this.sources.iterator();
        while (it.hasNext()) {
            if (it.next().canTranslate(str, locale)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public MessageFormat translate(@NotNull String str, @NotNull Locale locale) {
        Objects.requireNonNull(str, KeybindTag.KEYBIND);
        Objects.requireNonNull(locale, "locale");
        Iterator<Translator> it = this.sources.iterator();
        while (it.hasNext()) {
            MessageFormat messageFormatTranslate = it.next().translate(str, locale);
            if (messageFormatTranslate != null) {
                return messageFormatTranslate;
            }
        }
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public Component translate(@NotNull TranslatableComponent translatableComponent, @NotNull Locale locale) {
        Objects.requireNonNull(translatableComponent, "component");
        Objects.requireNonNull(locale, "locale");
        Iterator<Translator> it = this.sources.iterator();
        while (it.hasNext()) {
            Component componentTranslate = it.next().translate(translatableComponent, locale);
            if (componentTranslate != null) {
                return componentTranslate;
            }
        }
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("sources", this.sources));
    }
}

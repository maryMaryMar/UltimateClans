package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.translation.AbstractTranslationStore;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/MiniMessageTranslationStoreImpl.class */
final class MiniMessageTranslationStoreImpl extends AbstractTranslationStore.StringBased<String> implements MiniMessageTranslationStore {
    private final Translator translator;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/MiniMessageTranslationStoreImpl$Translator.class */
    private final class Translator extends MiniMessageTranslator {
        private Translator(MiniMessage miniMessage) {
            super(miniMessage);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.translation.MiniMessageTranslator
        @Nullable
        protected String getMiniMessageString(@NotNull String str, @NotNull Locale locale) {
            return (String) MiniMessageTranslationStoreImpl.this.translationValue(str, locale);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
        @NotNull
        public Key name() {
            return MiniMessageTranslationStoreImpl.this.name();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
        @NotNull
        public TriState hasAnyTranslations() {
            return MiniMessageTranslationStoreImpl.this.hasAnyTranslations();
        }
    }

    MiniMessageTranslationStoreImpl(@NotNull Key key, @NotNull MiniMessage miniMessage) {
        super(key);
        this.translator = new Translator((MiniMessage) Objects.requireNonNull(miniMessage, "miniMessage"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.translation.AbstractTranslationStore.StringBased
    @NotNull
    public String parse(@NotNull String str, @NotNull Locale locale) {
        return str;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public MessageFormat translate(@NotNull String str, @NotNull Locale locale) {
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public Component translate(@NotNull TranslatableComponent translatableComponent, @NotNull Locale locale) {
        return this.translator.translate(translatableComponent, locale);
    }
}

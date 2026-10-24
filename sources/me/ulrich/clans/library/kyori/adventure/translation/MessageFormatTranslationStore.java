package me.ulrich.clans.library.kyori.adventure.translation;

import java.text.MessageFormat;
import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/MessageFormatTranslationStore.class */
final class MessageFormatTranslationStore extends AbstractTranslationStore.StringBased<MessageFormat> implements TranslationRegistry {
    MessageFormatTranslationStore(Key key) {
        super(key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.translation.AbstractTranslationStore.StringBased
    @NotNull
    public MessageFormat parse(@NotNull String str, @NotNull Locale locale) {
        return new MessageFormat(str, locale);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public MessageFormat translate(@NotNull String str, @NotNull Locale locale) {
        return translationValue(str, locale);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.TranslationRegistry
    public /* bridge */ /* synthetic */ void register(@NotNull String str, @NotNull Locale locale, @NotNull MessageFormat messageFormat) {
        super.register(str, locale, messageFormat);
    }
}

package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.translation.TranslationStore;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/MiniMessageTranslationStore.class */
@ApiStatus.NonExtendable
public interface MiniMessageTranslationStore extends TranslationStore.StringBased<String> {
    @NotNull
    static MiniMessageTranslationStore create(@NotNull Key key) {
        return create(key, MiniMessage.miniMessage());
    }

    @NotNull
    static MiniMessageTranslationStore create(@NotNull Key key, @NotNull MiniMessage miniMessage) {
        return new MiniMessageTranslationStoreImpl(key, miniMessage);
    }
}

package me.ulrich.clans.library.kyori.adventure.translation;

import java.text.MessageFormat;
import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/ComponentTranslationStore.class */
final class ComponentTranslationStore extends AbstractTranslationStore<Component> {
    ComponentTranslationStore(@NotNull Key key) {
        super(key);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public MessageFormat translate(@NotNull String str, @NotNull Locale locale) {
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public Component translate(@NotNull TranslatableComponent translatableComponent, @NotNull Locale locale) {
        Component componentTranslationValue = translationValue(translatableComponent.key(), locale);
        if (componentTranslationValue == null) {
            return null;
        }
        return componentTranslationValue.append(translatableComponent.children());
    }
}

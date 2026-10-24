package me.ulrich.clans.library.kyori.adventure.text;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslationArgumentLike.class */
@FunctionalInterface
public interface TranslationArgumentLike extends ComponentLike {
    @NotNull
    TranslationArgument asTranslationArgument();

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentLike
    @NotNull
    default Component asComponent() {
        return asTranslationArgument().asComponent();
    }
}

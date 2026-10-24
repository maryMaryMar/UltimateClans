package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/LocalePointered.class */
final class LocalePointered implements Pointered {
    private final Pointers pointers;

    LocalePointered(@NotNull Locale locale) {
        this.pointers = Pointers.builder().withStatic(Identity.LOCALE, locale).build2();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
    @NotNull
    public Pointers pointers() {
        return this.pointers;
    }
}

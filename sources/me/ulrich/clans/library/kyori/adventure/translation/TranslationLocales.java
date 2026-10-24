package me.ulrich.clans.library.kyori.adventure.translation;

import java.util.Locale;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.internal.properties.AdventureProperties;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/TranslationLocales.class */
final class TranslationLocales {
    private static final Supplier<Locale> GLOBAL;

    private TranslationLocales() {
    }

    static Locale global() {
        return GLOBAL.get();
    }

    static {
        String strValue = AdventureProperties.DEFAULT_TRANSLATION_LOCALE.value();
        if (strValue == null || strValue.isEmpty()) {
            GLOBAL = () -> {
                return Locale.US;
            };
        } else if (strValue.equals("system")) {
            GLOBAL = Locale::getDefault;
        } else {
            Locale locale = Translator.parseLocale(strValue);
            GLOBAL = () -> {
                return locale;
            };
        }
    }
}

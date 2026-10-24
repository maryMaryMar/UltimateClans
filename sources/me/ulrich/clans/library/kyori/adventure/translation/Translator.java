package me.ulrich.clans.library.kyori.adventure.translation;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/Translator.class */
public interface Translator {
    @Nullable
    static Locale parseLocale(@NotNull String str) {
        String[] strArrSplit = str.split("_", 3);
        int length = strArrSplit.length;
        if (length == 1) {
            return new Locale(str);
        }
        if (length == 2) {
            return new Locale(strArrSplit[0], strArrSplit[1]);
        }
        if (length == 3) {
            return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        return null;
    }

    @NotNull
    Key name();

    @NotNull
    default TriState hasAnyTranslations() {
        return TriState.NOT_SET;
    }

    default boolean canTranslate(@NotNull String str, @NotNull Locale locale) {
        return (translate(Component.translatable((String) Objects.requireNonNull(str, KeybindTag.KEYBIND)), (Locale) Objects.requireNonNull(locale, "locale")) == null && translate(str, locale) == null) ? false : true;
    }

    @Nullable
    MessageFormat translate(@NotNull String str, @NotNull Locale locale);

    @Nullable
    default Component translate(@NotNull TranslatableComponent translatableComponent, @NotNull Locale locale) {
        return null;
    }
}

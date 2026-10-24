package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Objects;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslationArgument.class */
@ApiStatus.NonExtendable
public interface TranslationArgument extends TranslationArgumentLike, Examinable {
    @NotNull
    static TranslationArgument bool(boolean z) {
        return new TranslationArgumentImpl(Boolean.valueOf(z));
    }

    @NotNull
    static TranslationArgument numeric(@NotNull Number number) {
        return new TranslationArgumentImpl(Objects.requireNonNull(number, "value"));
    }

    @NotNull
    static TranslationArgument component(@NotNull ComponentLike componentLike) {
        return componentLike instanceof TranslationArgumentLike ? ((TranslationArgumentLike) componentLike).asTranslationArgument() : new TranslationArgumentImpl(Objects.requireNonNull(((ComponentLike) Objects.requireNonNull(componentLike, "value")).asComponent(), "value.asComponent()"));
    }

    @NotNull
    Object value();

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslationArgumentLike
    @NotNull
    default TranslationArgument asTranslationArgument() {
        return this;
    }
}

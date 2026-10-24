package me.ulrich.clans.library.kyori.adventure.translation;

import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.renderer.TranslatableComponentRenderer;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/translation/GlobalTranslator.class */
public interface GlobalTranslator extends Translator, Examinable {
    @NotNull
    static GlobalTranslator translator() {
        return GlobalTranslatorImpl.INSTANCE;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static GlobalTranslator get() {
        return GlobalTranslatorImpl.INSTANCE;
    }

    @NotNull
    static TranslatableComponentRenderer<Locale> renderer() {
        return GlobalTranslatorImpl.INSTANCE.renderer;
    }

    @NotNull
    static Component render(@NotNull Component component, @NotNull Locale locale) {
        return renderer().render(component, locale);
    }

    @NotNull
    Iterable<? extends Translator> sources();

    boolean addSource(@NotNull Translator translator);

    boolean removeSource(@NotNull Translator translator);
}

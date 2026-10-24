package me.ulrich.clans.library.kyori.adventure.text.format;

import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilderApplicable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/StyleBuilderApplicable.class */
@FunctionalInterface
public interface StyleBuilderApplicable extends ComponentBuilderApplicable {
    @Contract(mutates = "param")
    void styleApply(Style.Builder builder);

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilderApplicable
    default void componentBuilderApply(@NotNull ComponentBuilder<?, ?> componentBuilder) {
        componentBuilder.style(this::styleApply);
    }
}

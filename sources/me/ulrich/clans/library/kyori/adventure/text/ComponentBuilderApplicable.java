package me.ulrich.clans.library.kyori.adventure.text;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ComponentBuilderApplicable.class */
@FunctionalInterface
public interface ComponentBuilderApplicable {
    @Contract(mutates = "param")
    void componentBuilderApply(@NotNull ComponentBuilder<?, ?> componentBuilder);
}

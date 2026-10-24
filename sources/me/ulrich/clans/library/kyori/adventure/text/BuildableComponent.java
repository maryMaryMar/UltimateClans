package me.ulrich.clans.library.kyori.adventure.text;

import me.ulrich.clans.library.kyori.adventure.text.BuildableComponent;
import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BuildableComponent.class */
@Deprecated
public interface BuildableComponent<C extends BuildableComponent<C, B>, B extends ComponentBuilder<C, B>> extends Component, Buildable<C, B> {
    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    B mo683toBuilder();
}

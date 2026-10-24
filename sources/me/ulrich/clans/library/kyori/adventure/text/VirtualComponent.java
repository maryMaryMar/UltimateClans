package me.ulrich.clans.library.kyori.adventure.text;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/VirtualComponent.class */
@ApiStatus.NonExtendable
public interface VirtualComponent extends TextComponent {
    @NotNull
    Class<?> contextType();

    @NotNull
    VirtualComponentRenderer<?> renderer();
}

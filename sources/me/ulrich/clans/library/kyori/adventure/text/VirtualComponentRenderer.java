package me.ulrich.clans.library.kyori.adventure.text;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/VirtualComponentRenderer.class */
public interface VirtualComponentRenderer<C> {
    ComponentLike apply(@NotNull C c);

    @NotNull
    default String fallbackString() {
        return "";
    }
}

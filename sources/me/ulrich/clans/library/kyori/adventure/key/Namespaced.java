package me.ulrich.clans.library.kyori.adventure.key;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/Namespaced.class */
public interface Namespaced {
    @KeyPattern.Namespace
    @NotNull
    String namespace();
}

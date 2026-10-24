package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/Inserting.class */
public interface Inserting extends Tag {
    @NotNull
    Component value();

    default boolean allowsChildren() {
        return true;
    }
}

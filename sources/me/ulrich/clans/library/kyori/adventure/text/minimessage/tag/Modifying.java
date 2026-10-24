package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/Modifying.class */
@ApiStatus.OverrideOnly
public interface Modifying extends Tag {
    default void visit(@NotNull Node node, int i) {
    }

    default void postVisit() {
    }

    Component apply(@NotNull Component component, int i);
}

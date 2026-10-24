package me.ulrich.clans.library.kyori.adventure.text.minimessage.tree;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tree/Node.class */
@ApiStatus.NonExtendable
public interface Node {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tree/Node$Root.class */
    @ApiStatus.NonExtendable
    public interface Root extends Node {
        @NotNull
        String input();
    }

    @NotNull
    String toString();

    @NotNull
    List<? extends Node> children();

    @Nullable
    Node parent();
}

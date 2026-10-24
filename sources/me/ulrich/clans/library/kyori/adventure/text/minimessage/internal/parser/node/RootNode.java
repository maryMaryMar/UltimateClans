package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node;

import me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/node/RootNode.class */
public final class RootNode extends ElementNode implements Node.Root {
    private final String beforePreprocessing;

    public RootNode(@NotNull String str, @NotNull String str2) {
        super(null, null, str);
        this.beforePreprocessing = str2;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node.Root
    @NotNull
    public String input() {
        return this.beforePreprocessing;
    }
}

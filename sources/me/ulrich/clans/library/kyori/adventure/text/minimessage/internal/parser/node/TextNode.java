package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node;

import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/node/TextNode.class */
public final class TextNode extends ValueNode {
    private static boolean isEscape(int i) {
        return i == 60 || i == 92;
    }

    public TextNode(@Nullable ElementNode elementNode, @NotNull Token token, @NotNull String str) {
        super(elementNode, token, str, TokenParser.unescape(str, token.startIndex(), token.endIndex(), TextNode::isEscape));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ValueNode
    String valueName() {
        return "TextNode";
    }
}

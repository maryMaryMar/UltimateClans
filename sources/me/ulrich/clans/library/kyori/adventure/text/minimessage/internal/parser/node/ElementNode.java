package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenType;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/node/ElementNode.class */
public class ElementNode implements Node {

    @Nullable
    private final ElementNode parent;

    @Nullable
    private final Token token;
    private final String sourceMessage;
    private final List<ElementNode> children = new ArrayList();

    ElementNode(@Nullable ElementNode elementNode, @Nullable Token token, @NotNull String str) {
        this.parent = elementNode;
        this.token = token;
        this.sourceMessage = str;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node
    @Nullable
    public ElementNode parent() {
        return this.parent;
    }

    @Nullable
    public Token token() {
        return this.token;
    }

    @NotNull
    public String sourceMessage() {
        return this.sourceMessage;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node
    @NotNull
    public List<ElementNode> children() {
        return Collections.unmodifiableList(this.children);
    }

    @NotNull
    public List<ElementNode> unsafeChildren() {
        return this.children;
    }

    public void addChild(@NotNull ElementNode elementNode) {
        int size = this.children.size() - 1;
        if (!(elementNode instanceof TextNode) || this.children.isEmpty() || !(this.children.get(size) instanceof TextNode)) {
            this.children.add(elementNode);
            return;
        }
        TextNode textNode = (TextNode) this.children.remove(size);
        if (textNode.token().endIndex() == elementNode.token().startIndex()) {
            this.children.add(new TextNode(this, new Token(textNode.token().startIndex(), elementNode.token().endIndex(), TokenType.TEXT), textNode.sourceMessage()));
        } else {
            this.children.add(textNode);
            this.children.add(elementNode);
        }
    }

    @NotNull
    public StringBuilder buildToString(@NotNull StringBuilder sb, int i) {
        char[] cArrIdent = ident(i);
        sb.append(cArrIdent).append("Node {\n");
        Iterator<ElementNode> it = this.children.iterator();
        while (it.hasNext()) {
            it.next().buildToString(sb, i + 1);
        }
        sb.append(cArrIdent).append("}\n");
        return sb;
    }

    char[] ident(int i) {
        char[] cArr = new char[i * 2];
        Arrays.fill(cArr, ' ');
        return cArr;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node
    @NotNull
    public String toString() {
        return buildToString(new StringBuilder(), 0).toString();
    }
}

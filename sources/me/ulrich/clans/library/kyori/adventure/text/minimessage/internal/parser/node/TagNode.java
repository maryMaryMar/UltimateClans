package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.ParsingExceptionImpl;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/node/TagNode.class */
public final class TagNode extends ElementNode {
    private final List<TagPart> parts;

    @Nullable
    private Tag tag;

    public TagNode(@NotNull ElementNode elementNode, @NotNull Token token, @NotNull String str, TokenParser.TagProvider tagProvider) {
        super(elementNode, token, str);
        this.tag = null;
        this.parts = genParts(token, str, tagProvider);
        if (this.parts.isEmpty()) {
            throw new ParsingExceptionImpl("Tag has no parts? " + this, sourceMessage(), token());
        }
    }

    @NotNull
    private static List<TagPart> genParts(@NotNull Token token, @NotNull String str, TokenParser.TagProvider tagProvider) {
        ArrayList arrayList = new ArrayList();
        if (token.childTokens() != null) {
            Iterator<Token> it = token.childTokens().iterator();
            while (it.hasNext()) {
                arrayList.add(new TagPart(str, it.next(), tagProvider));
            }
        }
        return arrayList;
    }

    @NotNull
    public List<TagPart> parts() {
        return this.parts;
    }

    @NotNull
    public String name() {
        return this.parts.get(0).value();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ElementNode
    @NotNull
    public Token token() {
        return (Token) Objects.requireNonNull(super.token(), "token is not set");
    }

    @NotNull
    public Tag tag() {
        return (Tag) Objects.requireNonNull(this.tag, "no tag set");
    }

    public void tag(@NotNull Tag tag) {
        this.tag = tag;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ElementNode
    @NotNull
    public StringBuilder buildToString(@NotNull StringBuilder sb, int i) {
        char[] cArrIdent = ident(i);
        sb.append(cArrIdent).append("TagNode(");
        int size = this.parts.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('\'').append(this.parts.get(i2).value()).append('\'');
            if (i2 != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");
        Iterator<ElementNode> it = children().iterator();
        while (it.hasNext()) {
            it.next().buildToString(sb, i + 1);
        }
        sb.append(cArrIdent).append("}\n");
        return sb;
    }
}

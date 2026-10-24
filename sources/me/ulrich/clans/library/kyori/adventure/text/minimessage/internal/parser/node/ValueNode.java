package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/node/ValueNode.class */
public abstract class ValueNode extends ElementNode {
    private final String value;

    ValueNode(@Nullable ElementNode elementNode, @Nullable Token token, @NotNull String str, @NotNull String str2) {
        super(elementNode, token, str);
        this.value = str2;
    }

    abstract String valueName();

    @NotNull
    public String value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ElementNode
    @NotNull
    public Token token() {
        return (Token) Objects.requireNonNull(super.token(), "token is not set");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ElementNode
    @NotNull
    public StringBuilder buildToString(@NotNull StringBuilder sb, int i) {
        sb.append(ident(i)).append(valueName()).append("('").append(this.value).append("')\n");
        return sb;
    }
}

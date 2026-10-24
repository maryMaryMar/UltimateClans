package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/Token.class */
public final class Token implements Examinable {
    private final int startIndex;
    private final int endIndex;
    private final TokenType type;
    private List<Token> childTokens = null;

    public Token(int i, int i2, TokenType tokenType) {
        this.startIndex = i;
        this.endIndex = i2;
        this.type = tokenType;
    }

    public int startIndex() {
        return this.startIndex;
    }

    public int endIndex() {
        return this.endIndex;
    }

    public TokenType type() {
        return this.type;
    }

    public List<Token> childTokens() {
        return this.childTokens;
    }

    public void childTokens(List<Token> list) {
        this.childTokens = list;
    }

    public CharSequence get(CharSequence charSequence) {
        return charSequence.subSequence(this.startIndex, this.endIndex);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("startIndex", this.startIndex), ExaminableProperty.of("endIndex", this.endIndex), ExaminableProperty.of("type", this.type)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token = (Token) obj;
        return this.startIndex == token.startIndex && this.endIndex == token.endIndex && this.type == token.type;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.startIndex), Integer.valueOf(this.endIndex), this.type);
    }

    public String toString() {
        return Internals.toString(this);
    }
}

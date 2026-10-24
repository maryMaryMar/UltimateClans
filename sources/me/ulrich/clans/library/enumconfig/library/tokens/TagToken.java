package me.ulrich.clans.library.enumconfig.library.tokens;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/TagToken.class */
public final class TagToken extends Token {
    private final TagTuple value;

    public TagToken(TagTuple tagTuple, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.value = tagTuple;
    }

    public TagTuple getValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Tag;
    }
}

package me.ulrich.clans.library.enumconfig.library.tokens;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/AliasToken.class */
public final class AliasToken extends Token {
    private final String value;

    public AliasToken(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        if (str == null) {
            throw new NullPointerException("alias is expected");
        }
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Alias;
    }
}

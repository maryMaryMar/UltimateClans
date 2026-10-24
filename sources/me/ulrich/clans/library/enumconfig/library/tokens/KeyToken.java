package me.ulrich.clans.library.enumconfig.library.tokens;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/KeyToken.class */
public final class KeyToken extends Token {
    public KeyToken(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Key;
    }
}

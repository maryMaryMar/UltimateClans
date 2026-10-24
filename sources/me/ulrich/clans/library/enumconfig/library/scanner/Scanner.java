package me.ulrich.clans.library.enumconfig.library.scanner;

import me.ulrich.clans.library.enumconfig.library.tokens.Token;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/scanner/Scanner.class */
public interface Scanner {
    boolean checkToken(Token.ID... idArr);

    default boolean checkToken(Token.ID id) {
        return checkToken(id);
    }

    Token peekToken();

    Token getToken();

    void resetDocumentIndex();
}

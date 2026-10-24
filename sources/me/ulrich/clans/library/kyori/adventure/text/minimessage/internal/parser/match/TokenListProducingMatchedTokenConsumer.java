package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/match/TokenListProducingMatchedTokenConsumer.class */
public final class TokenListProducingMatchedTokenConsumer extends MatchedTokenConsumer<List<Token>> {
    private List<Token> result;

    public TokenListProducingMatchedTokenConsumer(@NotNull String str) {
        super(str);
        this.result = null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.MatchedTokenConsumer
    public void accept(int i, int i2, @NotNull TokenType tokenType) {
        super.accept(i, i2, tokenType);
        if (this.result == null) {
            this.result = new ArrayList();
        }
        this.result.add(new Token(i, i2, tokenType));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.MatchedTokenConsumer
    @NotNull
    public List<Token> result() {
        return this.result == null ? Collections.emptyList() : this.result;
    }
}

package me.ulrich.clans.library.enumconfig.library.tokens;

import java.util.List;
import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/DirectiveToken.class */
public final class DirectiveToken<T> extends Token {
    private final String name;
    private final List<T> value;

    public DirectiveToken(String str, List<T> list, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.name = str;
        if (list != null && list.size() != 2) {
            throw new YAMLException("Two strings must be provided instead of " + list.size());
        }
        this.value = list;
    }

    public String getName() {
        return this.name;
    }

    public List<T> getValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Directive;
    }
}

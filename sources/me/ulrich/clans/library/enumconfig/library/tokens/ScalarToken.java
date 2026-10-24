package me.ulrich.clans.library.enumconfig.library.tokens;

import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/ScalarToken.class */
public final class ScalarToken extends Token {
    private final String value;
    private final boolean plain;
    private final DumperOptions.ScalarStyle style;

    public ScalarToken(String str, Mark mark, Mark mark2, boolean z) {
        this(str, z, mark, mark2, DumperOptions.ScalarStyle.PLAIN);
    }

    public ScalarToken(String str, boolean z, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(mark, mark2);
        this.value = str;
        this.plain = z;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = scalarStyle;
    }

    public boolean getPlain() {
        return this.plain;
    }

    public String getValue() {
        return this.value;
    }

    public DumperOptions.ScalarStyle getStyle() {
        return this.style;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Scalar;
    }
}

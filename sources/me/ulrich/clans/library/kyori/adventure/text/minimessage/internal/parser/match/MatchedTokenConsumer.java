package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match;

import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenType;
import org.jetbrains.annotations.MustBeInvokedByOverriders;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/match/MatchedTokenConsumer.class */
public abstract class MatchedTokenConsumer<T> {
    protected final String input;
    private int lastIndex = -1;

    public MatchedTokenConsumer(@NotNull String str) {
        this.input = str;
    }

    @MustBeInvokedByOverriders
    public void accept(int i, int i2, @NotNull TokenType tokenType) {
        this.lastIndex = i2;
    }

    public abstract T result();

    public final int lastEndIndex() {
        return this.lastIndex;
    }
}

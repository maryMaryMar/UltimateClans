package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node;

import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/node/TagPart.class */
public final class TagPart implements Tag.Argument {
    private final String value;
    private final Token token;

    public TagPart(@NotNull String str, @NotNull Token token, TokenParser.TagProvider tagProvider) {
        this.value = TokenParser.resolvePreProcessTags(unquoteAndEscape(str, token.startIndex(), token.endIndex()), tagProvider);
        this.token = token;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag.Argument
    @NotNull
    public String value() {
        return this.value;
    }

    @NotNull
    public Token token() {
        return this.token;
    }

    @NotNull
    public static String unquoteAndEscape(@NotNull String str, int i, int i2) {
        if (i == i2) {
            return "";
        }
        int i3 = i2;
        char cCharAt = str.charAt(i);
        char cCharAt2 = str.charAt(i3 - 1);
        if (cCharAt != '\'' && cCharAt != '\"') {
            return str.substring(i, i3);
        }
        int i4 = i + 1;
        if (cCharAt2 == '\'' || cCharAt2 == '\"') {
            i3--;
        }
        return i4 > i3 ? str.substring(i, i2) : TokenParser.unescape(str, i4, i3, i5 -> {
            return i5 == cCharAt || i5 == 92;
        });
    }

    public String toString() {
        return this.value;
    }
}

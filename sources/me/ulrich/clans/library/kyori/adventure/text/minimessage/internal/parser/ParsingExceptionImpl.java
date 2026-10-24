package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser;

import java.util.Arrays;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.ParsingException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/ParsingExceptionImpl.class */
@ApiStatus.Internal
public class ParsingExceptionImpl extends ParsingException {
    private static final long serialVersionUID = 2507190809441787202L;
    private final String originalText;
    private Token[] tokens;

    public ParsingExceptionImpl(String str, @Nullable String str2, @NotNull Token... tokenArr) {
        super(str, null, true, false);
        this.tokens = tokenArr;
        this.originalText = str2;
    }

    public ParsingExceptionImpl(String str, @Nullable String str2, @Nullable Throwable th, boolean z, @NotNull Token... tokenArr) {
        super(str, th, true, z);
        this.tokens = tokenArr;
        this.originalText = str2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + (originalText() != null ? "\n\t" + originalText() + (tokens().length != 0 ? "\n\t" + arrow() : "") : "");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.ParsingException
    @Nullable
    public String detailMessage() {
        return super.getMessage();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.ParsingException
    @Nullable
    public String originalText() {
        return this.originalText;
    }

    @NotNull
    public Token[] tokens() {
        return this.tokens;
    }

    public void tokens(@NotNull Token[] tokenArr) {
        this.tokens = tokenArr;
    }

    private String arrow() {
        Token[] tokenArr = tokens();
        char[] cArr = new char[tokenArr[tokenArr.length - 1].endIndex()];
        int iEndIndex = 0;
        for (Token token : tokenArr) {
            Arrays.fill(cArr, iEndIndex, token.startIndex(), ' ');
            cArr[token.startIndex()] = '^';
            if (Math.abs(token.startIndex() - token.endIndex()) > 1) {
                Arrays.fill(cArr, token.startIndex() + 1, token.endIndex() - 1, '~');
            }
            cArr[token.endIndex() - 1] = '^';
            iEndIndex = token.endIndex();
        }
        return new String(cArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.ParsingException
    public int startIndex() {
        if (this.tokens.length == 0) {
            return -1;
        }
        return this.tokens[0].startIndex();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.ParsingException
    public int endIndex() {
        if (this.tokens.length == 0) {
            return -1;
        }
        return this.tokens[this.tokens.length - 1].endIndex();
    }
}

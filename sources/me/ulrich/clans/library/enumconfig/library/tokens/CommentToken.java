package me.ulrich.clans.library.enumconfig.library.tokens;

import java.util.Objects;
import me.ulrich.clans.library.enumconfig.library.comments.CommentType;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/CommentToken.class */
public final class CommentToken extends Token {
    private final CommentType type;
    private final String value;

    public CommentToken(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        Objects.requireNonNull(commentType);
        this.type = commentType;
        Objects.requireNonNull(str);
        this.value = str;
    }

    public CommentType getCommentType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Comment;
    }
}

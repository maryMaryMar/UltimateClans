package me.ulrich.clans.library.enumconfig.library.comments;

import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.events.CommentEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/comments/CommentLine.class */
public class CommentLine {
    private final Mark startMark;
    private final Mark endMark;
    private final String value;
    private final CommentType commentType;

    public CommentLine(CommentEvent commentEvent) {
        this(commentEvent.getStartMark(), commentEvent.getEndMark(), commentEvent.getValue(), commentEvent.getCommentType());
    }

    public CommentLine(Mark mark, Mark mark2, String str, CommentType commentType) {
        this.startMark = mark;
        this.endMark = mark2;
        this.value = str;
        this.commentType = commentType;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public CommentType getCommentType() {
        return this.commentType;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "<" + getClass().getName() + " (type=" + getCommentType() + ", value=" + getValue() + ")>";
    }
}

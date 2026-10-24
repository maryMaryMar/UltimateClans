package me.ulrich.clans.library.enumconfig.library.nodes;

import java.util.List;
import me.ulrich.clans.library.enumconfig.library.comments.CommentLine;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/nodes/Node.class */
public abstract class Node {
    private Tag tag;
    private final Mark startMark;
    protected Mark endMark;
    private Class<? extends Object> type;
    private boolean twoStepsConstruction;
    private String anchor;
    private List<CommentLine> inLineComments;
    private List<CommentLine> blockComments;
    private List<CommentLine> endComments;
    protected boolean resolved;
    protected Boolean useClassConstructor;

    public Node(Tag tag, Mark mark, Mark mark2) {
        setTag(tag);
        this.startMark = mark;
        this.endMark = mark2;
        this.type = Object.class;
        this.twoStepsConstruction = false;
        this.resolved = true;
        this.useClassConstructor = null;
        this.inLineComments = null;
        this.blockComments = null;
        this.endComments = null;
    }

    public Tag getTag() {
        return this.tag;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public abstract NodeId getNodeId();

    public Mark getStartMark() {
        return this.startMark;
    }

    public void setTag(Tag tag) {
        if (tag == null) {
            throw new NullPointerException("tag in a Node is required.");
        }
        this.tag = tag;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    public void setType(Class<? extends Object> cls) {
        if (cls.isAssignableFrom(this.type)) {
            return;
        }
        this.type = cls;
    }

    public void setTwoStepsConstruction(boolean z) {
        this.twoStepsConstruction = z;
    }

    public boolean isTwoStepsConstruction() {
        return this.twoStepsConstruction;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public boolean useClassConstructor() {
        if (this.useClassConstructor != null) {
            return this.useClassConstructor.booleanValue();
        }
        if (this.tag.isSecondary() || !this.resolved || Object.class.equals(this.type) || this.tag.equals(Tag.NULL)) {
            return this.tag.isCompatible(getType());
        }
        return true;
    }

    public void setUseClassConstructor(Boolean bool) {
        this.useClassConstructor = bool;
    }

    public String getAnchor() {
        return this.anchor;
    }

    public void setAnchor(String str) {
        this.anchor = str;
    }

    public List<CommentLine> getInLineComments() {
        return this.inLineComments;
    }

    public void setInLineComments(List<CommentLine> list) {
        this.inLineComments = list;
    }

    public List<CommentLine> getBlockComments() {
        return this.blockComments;
    }

    public void setBlockComments(List<CommentLine> list) {
        this.blockComments = list;
    }

    public List<CommentLine> getEndComments() {
        return this.endComments;
    }

    public void setEndComments(List<CommentLine> list) {
        this.endComments = list;
    }
}

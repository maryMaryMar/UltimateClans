package me.ulrich.clans.library.enumconfig.library.nodes;

import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/nodes/ScalarNode.class */
public class ScalarNode extends Node {
    private final DumperOptions.ScalarStyle style;
    private final String value;

    public ScalarNode(Tag tag, String str, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        this(tag, true, str, mark, mark2, scalarStyle);
    }

    public ScalarNode(Tag tag, boolean z, String str, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(tag, mark, mark2);
        if (str == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = str;
        if (scalarStyle == null) {
            throw new NullPointerException("Scalar style must be provided.");
        }
        this.style = scalarStyle;
        this.resolved = z;
    }

    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.nodes.Node
    public NodeId getNodeId() {
        return NodeId.scalar;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "<" + getClass().getName() + " (tag=" + getTag() + ", value=" + getValue() + ")>";
    }

    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }
}

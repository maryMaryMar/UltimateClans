package me.ulrich.clans.library.enumconfig.library.nodes;

import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/nodes/SequenceNode.class */
public class SequenceNode extends CollectionNode<Node> {
    private final List<Node> value;

    public SequenceNode(Tag tag, boolean z, List<Node> list, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2, flowStyle);
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = list;
        this.resolved = z;
    }

    public SequenceNode(Tag tag, List<Node> list, DumperOptions.FlowStyle flowStyle) {
        this(tag, true, list, null, null, flowStyle);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.nodes.Node
    public NodeId getNodeId() {
        return NodeId.sequence;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.nodes.CollectionNode
    public List<Node> getValue() {
        return this.value;
    }

    public void setListType(Class<? extends Object> cls) {
        Iterator<Node> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().setType(cls);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : getValue()) {
            if (node instanceof CollectionNode) {
                sb.append(System.identityHashCode(node));
            } else {
                sb.append(node.toString());
            }
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return "<" + getClass().getName() + " (tag=" + getTag() + ", value=[" + ((Object) sb) + "])>";
    }
}

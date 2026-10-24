package me.ulrich.clans.library.enumconfig.library.nodes;

import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/nodes/MappingNode.class */
public class MappingNode extends CollectionNode<NodeTuple> {
    private List<NodeTuple> value;
    private boolean merged;

    public MappingNode(Tag tag, boolean z, List<NodeTuple> list, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2, flowStyle);
        this.merged = false;
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = list;
        this.resolved = z;
    }

    public MappingNode(Tag tag, List<NodeTuple> list, DumperOptions.FlowStyle flowStyle) {
        this(tag, true, list, null, null, flowStyle);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.nodes.Node
    public NodeId getNodeId() {
        return NodeId.mapping;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.nodes.CollectionNode
    public List<NodeTuple> getValue() {
        return this.value;
    }

    public void setValue(List<NodeTuple> list) {
        this.value = list;
    }

    public void setOnlyKeyType(Class<? extends Object> cls) {
        Iterator<NodeTuple> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().getKeyNode().setType(cls);
        }
    }

    public void setTypes(Class<? extends Object> cls, Class<? extends Object> cls2) {
        for (NodeTuple nodeTuple : this.value) {
            nodeTuple.getValueNode().setType(cls2);
            nodeTuple.getKeyNode().setType(cls);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodeTuple nodeTuple : getValue()) {
            sb.append("{ key=");
            sb.append(nodeTuple.getKeyNode());
            sb.append("; value=");
            if (nodeTuple.getValueNode() instanceof CollectionNode) {
                sb.append(System.identityHashCode(nodeTuple.getValueNode()));
            } else {
                sb.append(nodeTuple);
            }
            sb.append(" }");
        }
        return "<" + getClass().getName() + " (tag=" + getTag() + ", values=" + sb.toString() + ")>";
    }

    public void setMerged(boolean z) {
        this.merged = z;
    }

    public boolean isMerged() {
        return this.merged;
    }
}

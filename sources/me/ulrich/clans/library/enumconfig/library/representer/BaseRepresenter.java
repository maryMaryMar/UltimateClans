package me.ulrich.clans.library.enumconfig.library.representer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.introspector.PropertyUtils;
import me.ulrich.clans.library.enumconfig.library.nodes.AnchorNode;
import me.ulrich.clans.library.enumconfig.library.nodes.MappingNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeTuple;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.SequenceNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/BaseRepresenter.class */
public abstract class BaseRepresenter {
    protected Represent nullRepresenter;
    protected Object objectToRepresent;
    private PropertyUtils propertyUtils;
    protected final Map<Class<?>, Represent> representers = new HashMap();
    protected final Map<Class<?>, Represent> multiRepresenters = new LinkedHashMap();
    protected DumperOptions.ScalarStyle defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN;
    protected DumperOptions.FlowStyle defaultFlowStyle = DumperOptions.FlowStyle.AUTO;
    protected final Map<Object, Node> representedObjects = new IdentityHashMap<Object, Node>() { // from class: me.ulrich.clans.library.enumconfig.library.representer.BaseRepresenter.1
        private static final long serialVersionUID = -5576159264232131854L;

        @Override // java.util.IdentityHashMap, java.util.AbstractMap, java.util.Map
        public Node put(Object obj, Node node) {
            return (Node) super.put(obj, new AnchorNode(node));
        }
    };
    private boolean explicitPropertyUtils = false;

    public Node represent(Object obj) {
        Node nodeRepresentData = representData(obj);
        this.representedObjects.clear();
        this.objectToRepresent = null;
        return nodeRepresentData;
    }

    protected final Node representData(Object obj) {
        Node nodeRepresentData;
        this.objectToRepresent = obj;
        if (this.representedObjects.containsKey(this.objectToRepresent)) {
            return this.representedObjects.get(this.objectToRepresent);
        }
        if (obj == null) {
            return this.nullRepresenter.representData(null);
        }
        Class<?> cls = obj.getClass();
        if (this.representers.containsKey(cls)) {
            nodeRepresentData = this.representers.get(cls).representData(obj);
        } else {
            for (Class<?> cls2 : this.multiRepresenters.keySet()) {
                if (cls2 != null && cls2.isInstance(obj)) {
                    return this.multiRepresenters.get(cls2).representData(obj);
                }
            }
            nodeRepresentData = this.multiRepresenters.containsKey(null) ? this.multiRepresenters.get(null).representData(obj) : this.representers.get(null).representData(obj);
        }
        return nodeRepresentData;
    }

    protected Node representScalar(Tag tag, String str, DumperOptions.ScalarStyle scalarStyle) {
        return new ScalarNode(tag, str, null, null, scalarStyle);
    }

    protected Node representScalar(Tag tag, String str) {
        return representScalar(tag, str, this.defaultScalarStyle);
    }

    protected Node representSequence(Tag tag, Iterable<?> iterable, DumperOptions.FlowStyle flowStyle) {
        int size = 10;
        if (iterable instanceof List) {
            size = ((List) iterable).size();
        }
        ArrayList arrayList = new ArrayList(size);
        SequenceNode sequenceNode = new SequenceNode(tag, arrayList, flowStyle);
        this.representedObjects.put(this.objectToRepresent, sequenceNode);
        DumperOptions.FlowStyle flowStyle2 = DumperOptions.FlowStyle.FLOW;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            Node nodeRepresentData = representData(it.next());
            if (!(nodeRepresentData instanceof ScalarNode) || !((ScalarNode) nodeRepresentData).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            arrayList.add(nodeRepresentData);
        }
        if (flowStyle == DumperOptions.FlowStyle.AUTO) {
            if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
                sequenceNode.setFlowStyle(this.defaultFlowStyle);
            } else {
                sequenceNode.setFlowStyle(flowStyle2);
            }
        }
        return sequenceNode;
    }

    protected Node representMapping(Tag tag, Map<?, ?> map, DumperOptions.FlowStyle flowStyle) {
        ArrayList arrayList = new ArrayList(map.size());
        MappingNode mappingNode = new MappingNode(tag, arrayList, flowStyle);
        this.representedObjects.put(this.objectToRepresent, mappingNode);
        DumperOptions.FlowStyle flowStyle2 = DumperOptions.FlowStyle.FLOW;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Node nodeRepresentData = representData(entry.getKey());
            Node nodeRepresentData2 = representData(entry.getValue());
            if (!(nodeRepresentData instanceof ScalarNode) || !((ScalarNode) nodeRepresentData).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            if (!(nodeRepresentData2 instanceof ScalarNode) || !((ScalarNode) nodeRepresentData2).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            arrayList.add(new NodeTuple(nodeRepresentData, nodeRepresentData2));
        }
        if (flowStyle == DumperOptions.FlowStyle.AUTO) {
            if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
                mappingNode.setFlowStyle(this.defaultFlowStyle);
            } else {
                mappingNode.setFlowStyle(flowStyle2);
            }
        }
        return mappingNode;
    }

    public void setDefaultScalarStyle(DumperOptions.ScalarStyle scalarStyle) {
        this.defaultScalarStyle = scalarStyle;
    }

    public DumperOptions.ScalarStyle getDefaultScalarStyle() {
        return this.defaultScalarStyle == null ? DumperOptions.ScalarStyle.PLAIN : this.defaultScalarStyle;
    }

    public void setDefaultFlowStyle(DumperOptions.FlowStyle flowStyle) {
        this.defaultFlowStyle = flowStyle;
    }

    public DumperOptions.FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }
}

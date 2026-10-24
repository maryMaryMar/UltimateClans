package me.ulrich.clans.library.enumconfig.library.representer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.TypeDescription;
import me.ulrich.clans.library.enumconfig.library.introspector.Property;
import me.ulrich.clans.library.enumconfig.library.introspector.PropertyUtils;
import me.ulrich.clans.library.enumconfig.library.nodes.MappingNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeId;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeTuple;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.SequenceNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/Representer.class */
public class Representer extends SafeRepresenter {
    protected Map<Class<? extends Object>, TypeDescription> typeDefinitions;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/Representer$RepresentJavaBean.class */
    protected class RepresentJavaBean implements Represent {
        protected RepresentJavaBean() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return Representer.this.representJavaBean(Representer.this.getProperties(obj.getClass()), obj);
        }
    }

    public Representer(DumperOptions dumperOptions) {
        super(dumperOptions);
        this.typeDefinitions = Collections.emptyMap();
        this.representers.put(null, new RepresentJavaBean());
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (Collections.EMPTY_MAP == this.typeDefinitions) {
            this.typeDefinitions = new HashMap();
        }
        if (typeDescription.getTag() != null) {
            addClassTag(typeDescription.getType(), typeDescription.getTag());
        }
        typeDescription.setPropertyUtils(getPropertyUtils());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.representer.BaseRepresenter
    public void setPropertyUtils(PropertyUtils propertyUtils) {
        super.setPropertyUtils(propertyUtils);
        Iterator<TypeDescription> it = this.typeDefinitions.values().iterator();
        while (it.hasNext()) {
            it.next().setPropertyUtils(propertyUtils);
        }
    }

    protected MappingNode representJavaBean(Set<Property> set, Object obj) {
        ArrayList arrayList = new ArrayList(set.size());
        Tag tag = this.classTags.get(obj.getClass());
        MappingNode mappingNode = new MappingNode(tag != null ? tag : new Tag((Class<? extends Object>) obj.getClass()), arrayList, DumperOptions.FlowStyle.AUTO);
        this.representedObjects.put(obj, mappingNode);
        DumperOptions.FlowStyle flowStyle = DumperOptions.FlowStyle.FLOW;
        for (Property property : set) {
            Object obj2 = property.get(obj);
            NodeTuple nodeTupleRepresentJavaBeanProperty = representJavaBeanProperty(obj, property, obj2, obj2 == null ? null : this.classTags.get(obj2.getClass()));
            if (nodeTupleRepresentJavaBeanProperty != null) {
                if (!((ScalarNode) nodeTupleRepresentJavaBeanProperty.getKeyNode()).isPlain()) {
                    flowStyle = DumperOptions.FlowStyle.BLOCK;
                }
                Node valueNode = nodeTupleRepresentJavaBeanProperty.getValueNode();
                if (!(valueNode instanceof ScalarNode) || !((ScalarNode) valueNode).isPlain()) {
                    flowStyle = DumperOptions.FlowStyle.BLOCK;
                }
                arrayList.add(nodeTupleRepresentJavaBeanProperty);
            }
        }
        if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
            mappingNode.setFlowStyle(this.defaultFlowStyle);
        } else {
            mappingNode.setFlowStyle(flowStyle);
        }
        return mappingNode;
    }

    protected NodeTuple representJavaBeanProperty(Object obj, Property property, Object obj2, Tag tag) {
        ScalarNode scalarNode = (ScalarNode) representData(property.getName());
        boolean zContainsKey = this.representedObjects.containsKey(obj2);
        Node nodeRepresentData = representData(obj2);
        if (obj2 != null && !zContainsKey) {
            NodeId nodeId = nodeRepresentData.getNodeId();
            if (tag == null) {
                if (nodeId != NodeId.scalar) {
                    if (nodeId == NodeId.mapping && property.getType() == obj2.getClass() && !(obj2 instanceof Map) && !nodeRepresentData.getTag().equals(Tag.SET)) {
                        nodeRepresentData.setTag(Tag.MAP);
                    }
                    checkGlobalTag(property, nodeRepresentData, obj2);
                } else if (property.getType() != Enum.class && (obj2 instanceof Enum)) {
                    nodeRepresentData.setTag(Tag.STR);
                }
            }
        }
        return new NodeTuple(scalarNode, nodeRepresentData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void checkGlobalTag(Property property, Node node, Object obj) {
        Class<?>[] actualTypeArguments;
        if ((obj.getClass().isArray() && obj.getClass().getComponentType().isPrimitive()) || (actualTypeArguments = property.getActualTypeArguments()) == null) {
            return;
        }
        if (node.getNodeId() == NodeId.sequence) {
            Class<?> cls = actualTypeArguments[0];
            SequenceNode sequenceNode = (SequenceNode) node;
            Iterable iterableEmptyList = Collections.emptyList();
            if (obj.getClass().isArray()) {
                iterableEmptyList = Arrays.asList((Object[]) obj);
            } else if (obj instanceof Iterable) {
                iterableEmptyList = (Iterable) obj;
            }
            Iterator it = iterableEmptyList.iterator();
            if (it.hasNext()) {
                for (Node node2 : sequenceNode.getValue()) {
                    Object next = it.next();
                    if (next != null && cls.equals(next.getClass()) && node2.getNodeId() == NodeId.mapping) {
                        node2.setTag(Tag.MAP);
                    }
                }
                return;
            }
            return;
        }
        if (obj instanceof Set) {
            Class<?> cls2 = actualTypeArguments[0];
            Iterator<NodeTuple> it2 = ((MappingNode) node).getValue().iterator();
            for (Object obj2 : (Set) obj) {
                Node keyNode = it2.next().getKeyNode();
                if (cls2.equals(obj2.getClass()) && keyNode.getNodeId() == NodeId.mapping) {
                    keyNode.setTag(Tag.MAP);
                }
            }
            return;
        }
        if (obj instanceof Map) {
            Class<?> cls3 = actualTypeArguments[0];
            Class<?> cls4 = actualTypeArguments[1];
            for (NodeTuple nodeTuple : ((MappingNode) node).getValue()) {
                resetTag(cls3, nodeTuple.getKeyNode());
                resetTag(cls4, nodeTuple.getValueNode());
            }
        }
    }

    private void resetTag(Class<? extends Object> cls, Node node) {
        if (node.getTag().matches(cls)) {
            if (Enum.class.isAssignableFrom(cls)) {
                node.setTag(Tag.STR);
            } else {
                node.setTag(Tag.MAP);
            }
        }
    }

    protected Set<Property> getProperties(Class<? extends Object> cls) {
        return this.typeDefinitions.containsKey(cls) ? this.typeDefinitions.get(cls).getProperties() : getPropertyUtils().getProperties(cls);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.representer.SafeRepresenter
    public /* bridge */ /* synthetic */ void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.representer.SafeRepresenter
    public /* bridge */ /* synthetic */ TimeZone getTimeZone() {
        return super.getTimeZone();
    }

    @Override // me.ulrich.clans.library.enumconfig.library.representer.SafeRepresenter
    public /* bridge */ /* synthetic */ Tag addClassTag(Class cls, Tag tag) {
        return super.addClassTag(cls, tag);
    }
}

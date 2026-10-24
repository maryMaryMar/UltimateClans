package me.ulrich.clans.library.enumconfig.library.serializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.comments.CommentLine;
import me.ulrich.clans.library.enumconfig.library.emitter.Emitable;
import me.ulrich.clans.library.enumconfig.library.events.AliasEvent;
import me.ulrich.clans.library.enumconfig.library.events.CommentEvent;
import me.ulrich.clans.library.enumconfig.library.events.DocumentEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.DocumentStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.ImplicitTuple;
import me.ulrich.clans.library.enumconfig.library.events.MappingEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.MappingStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.ScalarEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.StreamEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.StreamStartEvent;
import me.ulrich.clans.library.enumconfig.library.nodes.AnchorNode;
import me.ulrich.clans.library.enumconfig.library.nodes.MappingNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeId;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeTuple;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.SequenceNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;
import me.ulrich.clans.library.enumconfig.library.resolver.Resolver;
import me.ulrich.clans.library.enumconfig.library.util.MergeUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/serializer/Serializer.class */
public final class Serializer {
    private final Emitable emitter;
    private final Resolver resolver;
    private final boolean explicitStart;
    private final boolean explicitEnd;
    private DumperOptions.Version useVersion;
    private final Map<String, String> useTags;
    private final Set<Node> serializedNodes;
    private final Map<Node, String> anchors;
    private final AnchorGenerator anchorGenerator;
    private Boolean closed;
    private final Tag explicitRoot;
    private final boolean dereferenceAliases;
    private final Set<Node> recursive;
    private final MergeUtils mergeUtils;

    public Serializer(Emitable emitable, Resolver resolver, DumperOptions dumperOptions, Tag tag) {
        if (emitable == null) {
            throw new NullPointerException("Emitter must  be provided");
        }
        if (resolver == null) {
            throw new NullPointerException("Resolver must  be provided");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must  be provided");
        }
        this.emitter = emitable;
        this.resolver = resolver;
        this.explicitStart = dumperOptions.isExplicitStart();
        this.explicitEnd = dumperOptions.isExplicitEnd();
        if (dumperOptions.getVersion() != null) {
            this.useVersion = dumperOptions.getVersion();
        }
        this.useTags = dumperOptions.getTags();
        this.serializedNodes = new HashSet();
        this.anchors = new HashMap();
        this.anchorGenerator = dumperOptions.getAnchorGenerator();
        this.dereferenceAliases = dumperOptions.isDereferenceAliases();
        this.recursive = Collections.newSetFromMap(new IdentityHashMap());
        this.closed = null;
        this.explicitRoot = tag;
        this.mergeUtils = new MergeUtils() { // from class: me.ulrich.clans.library.enumconfig.library.serializer.Serializer.1
            @Override // me.ulrich.clans.library.enumconfig.library.util.MergeUtils
            public MappingNode asMappingNode(Node node) {
                if (node instanceof MappingNode) {
                    return (MappingNode) node;
                }
                throw new SerializerException("expecting MappingNode while processing merge.");
            }
        };
    }

    public void open() {
        if (this.closed == null) {
            this.emitter.emit(new StreamStartEvent(null, null));
            this.closed = Boolean.FALSE;
        } else {
            if (!Boolean.TRUE.equals(this.closed)) {
                throw new SerializerException("serializer is already opened");
            }
            throw new SerializerException("serializer is closed");
        }
    }

    public void close() {
        if (this.closed == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (Boolean.TRUE.equals(this.closed)) {
            return;
        }
        this.emitter.emit(new StreamEndEvent(null, null));
        this.closed = Boolean.TRUE;
        this.serializedNodes.clear();
        this.anchors.clear();
        this.recursive.clear();
    }

    public void serialize(Node node) {
        if (this.closed == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (this.closed.booleanValue()) {
            throw new SerializerException("serializer is closed");
        }
        this.emitter.emit(new DocumentStartEvent(null, null, this.explicitStart, this.useVersion, this.useTags));
        anchorNode(node);
        if (this.explicitRoot != null) {
            node.setTag(this.explicitRoot);
        }
        serializeNode(node, null);
        this.emitter.emit(new DocumentEndEvent(null, null, this.explicitEnd));
        this.serializedNodes.clear();
        this.anchors.clear();
        this.recursive.clear();
    }

    private void anchorNode(Node node) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        if (this.anchors.containsKey(node)) {
            if (null == this.anchors.get(node)) {
                this.anchors.put(node, this.anchorGenerator.nextAnchor(node));
                return;
            }
            return;
        }
        this.anchors.put(node, node.getAnchor() != null ? this.anchorGenerator.nextAnchor(node) : null);
        switch (node.getNodeId()) {
            case sequence:
                Iterator<Node> it = ((SequenceNode) node).getValue().iterator();
                while (it.hasNext()) {
                    anchorNode(it.next());
                }
                break;
            case mapping:
                for (NodeTuple nodeTuple : ((MappingNode) node).getValue()) {
                    Node keyNode = nodeTuple.getKeyNode();
                    Node valueNode = nodeTuple.getValueNode();
                    anchorNode(keyNode);
                    anchorNode(valueNode);
                }
                break;
        }
    }

    private void serializeNode(Node node, Node node2) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        if (this.dereferenceAliases && this.recursive.contains(node)) {
            throw new SerializerException("Cannot dereferenceAliases for recursive structures.");
        }
        this.recursive.add(node);
        String str = !this.dereferenceAliases ? this.anchors.get(node) : null;
        if (this.dereferenceAliases || !this.serializedNodes.contains(node)) {
            this.serializedNodes.add(node);
            switch (node.getNodeId()) {
                case sequence:
                    SequenceNode sequenceNode = (SequenceNode) node;
                    serializeComments(node.getBlockComments());
                    this.emitter.emit(new SequenceStartEvent(str, node.getTag().getValue(), node.getTag().equals(this.resolver.resolve(NodeId.sequence, null, true)), null, null, sequenceNode.getFlowStyle()));
                    Iterator<Node> it = sequenceNode.getValue().iterator();
                    while (it.hasNext()) {
                        serializeNode(it.next(), node);
                    }
                    this.emitter.emit(new SequenceEndEvent(null, null));
                    serializeComments(node.getInLineComments());
                    serializeComments(node.getEndComments());
                    break;
                case scalar:
                    ScalarNode scalarNode = (ScalarNode) node;
                    serializeComments(node.getBlockComments());
                    this.emitter.emit(new ScalarEvent(str, node.getTag().getValue(), new ImplicitTuple(node.getTag().equals(this.resolver.resolve(NodeId.scalar, scalarNode.getValue(), true)), node.getTag().equals(this.resolver.resolve(NodeId.scalar, scalarNode.getValue(), false))), scalarNode.getValue(), null, null, scalarNode.getScalarStyle()));
                    serializeComments(node.getInLineComments());
                    serializeComments(node.getEndComments());
                    break;
                default:
                    serializeComments(node.getBlockComments());
                    if (node.getTag() != Tag.COMMENT) {
                        boolean zEquals = node.getTag().equals(this.resolver.resolve(NodeId.mapping, null, true));
                        MappingNode mappingNode = (MappingNode) node;
                        List<NodeTuple> value = mappingNode.getValue();
                        if (this.dereferenceAliases && mappingNode.isMerged()) {
                            value = this.mergeUtils.flatten(mappingNode);
                        }
                        this.emitter.emit(new MappingStartEvent(str, mappingNode.getTag().getValue(), zEquals, null, null, mappingNode.getFlowStyle()));
                        for (NodeTuple nodeTuple : value) {
                            Node keyNode = nodeTuple.getKeyNode();
                            Node valueNode = nodeTuple.getValueNode();
                            serializeNode(keyNode, mappingNode);
                            serializeNode(valueNode, mappingNode);
                        }
                        this.emitter.emit(new MappingEndEvent(null, null));
                        serializeComments(node.getInLineComments());
                        serializeComments(node.getEndComments());
                    }
                    break;
            }
        } else {
            this.emitter.emit(new AliasEvent(str, null, null));
        }
        this.recursive.remove(node);
    }

    private void serializeComments(List<CommentLine> list) {
        if (list == null) {
            return;
        }
        for (CommentLine commentLine : list) {
            this.emitter.emit(new CommentEvent(commentLine.getCommentType(), commentLine.getValue(), commentLine.getStartMark(), commentLine.getEndMark()));
        }
    }
}

package me.ulrich.clans.library.enumconfig.library.composer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.LoaderOptions;
import me.ulrich.clans.library.enumconfig.library.comments.CommentEventsCollector;
import me.ulrich.clans.library.enumconfig.library.comments.CommentLine;
import me.ulrich.clans.library.enumconfig.library.comments.CommentType;
import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.events.AliasEvent;
import me.ulrich.clans.library.enumconfig.library.events.Event;
import me.ulrich.clans.library.enumconfig.library.events.MappingStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.NodeEvent;
import me.ulrich.clans.library.enumconfig.library.events.ScalarEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceStartEvent;
import me.ulrich.clans.library.enumconfig.library.nodes.MappingNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeId;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeTuple;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.SequenceNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;
import me.ulrich.clans.library.enumconfig.library.parser.Parser;
import me.ulrich.clans.library.enumconfig.library.resolver.Resolver;
import me.ulrich.clans.library.enumconfig.library.util.MergeUtils;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/composer/Composer.class */
public class Composer {
    protected final Parser parser;
    private final Resolver resolver;
    private final Map<String, Node> anchors;
    private final Set<Node> recursiveNodes;
    private final LoaderOptions loadingConfig;
    private final CommentEventsCollector blockCommentsCollector;
    private final CommentEventsCollector inlineCommentsCollector;
    private final int nestingDepthLimit;
    private final MergeUtils mergeUtils;
    private int nonScalarAliasesCount = 0;
    private int nestingDepth = 0;

    public Composer(Parser parser, Resolver resolver, LoaderOptions loaderOptions) {
        if (parser == null) {
            throw new NullPointerException("Parser must be provided");
        }
        if (resolver == null) {
            throw new NullPointerException("Resolver must be provided");
        }
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided");
        }
        this.parser = parser;
        this.resolver = resolver;
        this.anchors = new HashMap();
        this.recursiveNodes = new HashSet();
        this.loadingConfig = loaderOptions;
        this.blockCommentsCollector = new CommentEventsCollector(parser, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(parser, CommentType.IN_LINE);
        this.nestingDepthLimit = loaderOptions.getNestingDepthLimit();
        this.mergeUtils = new MergeUtils() { // from class: me.ulrich.clans.library.enumconfig.library.composer.Composer.1
            @Override // me.ulrich.clans.library.enumconfig.library.util.MergeUtils
            public MappingNode asMappingNode(Node node) {
                return Composer.this.asMappingNode(node);
            }
        };
    }

    public boolean checkNode() {
        if (this.parser.checkEvent(Event.ID.StreamStart)) {
            this.parser.getEvent();
        }
        return !this.parser.checkEvent(Event.ID.StreamEnd);
    }

    public Node getNode() {
        this.blockCommentsCollector.collectEvents();
        if (this.parser.checkEvent(Event.ID.StreamEnd)) {
            List<CommentLine> listConsume = this.blockCommentsCollector.consume();
            Mark startMark = listConsume.get(0).getStartMark();
            MappingNode mappingNode = new MappingNode(Tag.COMMENT, false, Collections.emptyList(), startMark, null, DumperOptions.FlowStyle.BLOCK);
            mappingNode.setBlockComments(listConsume);
            return mappingNode;
        }
        this.parser.getEvent();
        Node nodeComposeNode = composeNode(null);
        this.blockCommentsCollector.collectEvents();
        if (!this.blockCommentsCollector.isEmpty()) {
            nodeComposeNode.setEndComments(this.blockCommentsCollector.consume());
        }
        this.parser.getEvent();
        this.anchors.clear();
        this.recursiveNodes.clear();
        return nodeComposeNode;
    }

    public Node getSingleNode() {
        this.parser.getEvent();
        Node node = null;
        if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
            node = getNode();
        }
        if (this.parser.checkEvent(Event.ID.StreamEnd)) {
            this.parser.getEvent();
            return node;
        }
        throw new ComposerException("expected a single document in the stream", node != null ? node.getStartMark() : null, "but found another document", this.parser.getEvent().getStartMark());
    }

    private Node composeNode(Node node) {
        Node nodeComposeSequenceNode;
        this.blockCommentsCollector.collectEvents();
        if (node != null) {
            this.recursiveNodes.add(node);
        }
        if (this.parser.checkEvent(Event.ID.Alias)) {
            AliasEvent aliasEvent = (AliasEvent) this.parser.getEvent();
            String anchor = aliasEvent.getAnchor();
            if (!this.anchors.containsKey(anchor)) {
                throw new ComposerException("found undefined alias " + anchor, aliasEvent.getStartMark());
            }
            nodeComposeSequenceNode = this.anchors.get(anchor);
            if (!(nodeComposeSequenceNode instanceof ScalarNode)) {
                this.nonScalarAliasesCount++;
                if (this.nonScalarAliasesCount > this.loadingConfig.getMaxAliasesForCollections()) {
                    throw new YAMLException("Number of aliases for non-scalar nodes exceeds the specified max=" + this.loadingConfig.getMaxAliasesForCollections());
                }
            }
            if (this.recursiveNodes.remove(nodeComposeSequenceNode)) {
                nodeComposeSequenceNode.setTwoStepsConstruction(true);
            }
            this.blockCommentsCollector.consume();
            this.inlineCommentsCollector.collectEvents().consume();
        } else {
            String anchor2 = ((NodeEvent) this.parser.peekEvent()).getAnchor();
            increaseNestingDepth();
            if (this.parser.checkEvent(Event.ID.Scalar)) {
                nodeComposeSequenceNode = composeScalarNode(anchor2, this.blockCommentsCollector.consume());
            } else {
                nodeComposeSequenceNode = this.parser.checkEvent(Event.ID.SequenceStart) ? composeSequenceNode(anchor2) : composeMappingNode(anchor2);
            }
            decreaseNestingDepth();
        }
        this.recursiveNodes.remove(node);
        return nodeComposeSequenceNode;
    }

    protected Node composeScalarNode(String str, List<CommentLine> list) {
        Tag tagResolve;
        ScalarEvent scalarEvent = (ScalarEvent) this.parser.getEvent();
        String tag = scalarEvent.getTag();
        boolean z = false;
        if (tag == null || tag.equals(DecorationTag.REVERT)) {
            tagResolve = this.resolver.resolve(NodeId.scalar, scalarEvent.getValue(), scalarEvent.getImplicit().canOmitTagInPlainScalar());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException("Global tag is not allowed: " + tag, scalarEvent.getStartMark());
            }
        }
        ScalarNode scalarNode = new ScalarNode(tagResolve, z, scalarEvent.getValue(), scalarEvent.getStartMark(), scalarEvent.getEndMark(), scalarEvent.getScalarStyle());
        if (str != null) {
            scalarNode.setAnchor(str);
            this.anchors.put(str, scalarNode);
        }
        scalarNode.setBlockComments(list);
        scalarNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        return scalarNode;
    }

    protected Node composeSequenceNode(String str) {
        Tag tagResolve;
        SequenceStartEvent sequenceStartEvent = (SequenceStartEvent) this.parser.getEvent();
        String tag = sequenceStartEvent.getTag();
        boolean z = false;
        if (tag == null || tag.equals(DecorationTag.REVERT)) {
            tagResolve = this.resolver.resolve(NodeId.sequence, null, sequenceStartEvent.getImplicit());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException("Global tag is not allowed: " + tag, sequenceStartEvent.getStartMark());
            }
        }
        ArrayList arrayList = new ArrayList();
        SequenceNode sequenceNode = new SequenceNode(tagResolve, z, arrayList, sequenceStartEvent.getStartMark(), null, sequenceStartEvent.getFlowStyle());
        if (sequenceStartEvent.isFlow()) {
            sequenceNode.setBlockComments(this.blockCommentsCollector.consume());
        }
        if (str != null) {
            sequenceNode.setAnchor(str);
            this.anchors.put(str, sequenceNode);
        }
        while (!this.parser.checkEvent(Event.ID.SequenceEnd)) {
            this.blockCommentsCollector.collectEvents();
            if (this.parser.checkEvent(Event.ID.SequenceEnd)) {
                break;
            }
            arrayList.add(composeNode(sequenceNode));
        }
        if (sequenceStartEvent.isFlow()) {
            sequenceNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        }
        sequenceNode.setEndMark(this.parser.getEvent().getEndMark());
        this.inlineCommentsCollector.collectEvents();
        if (!this.inlineCommentsCollector.isEmpty()) {
            sequenceNode.setInLineComments(this.inlineCommentsCollector.consume());
        }
        return sequenceNode;
    }

    protected Node composeMappingNode(String str) {
        Tag tagResolve;
        MappingStartEvent mappingStartEvent = (MappingStartEvent) this.parser.getEvent();
        String tag = mappingStartEvent.getTag();
        boolean z = false;
        if (tag == null || tag.equals(DecorationTag.REVERT)) {
            tagResolve = this.resolver.resolve(NodeId.mapping, null, mappingStartEvent.getImplicit());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException("Global tag is not allowed: " + tag, mappingStartEvent.getStartMark());
            }
        }
        ArrayList arrayList = new ArrayList();
        MappingNode mappingNode = new MappingNode(tagResolve, z, arrayList, mappingStartEvent.getStartMark(), null, mappingStartEvent.getFlowStyle());
        if (mappingStartEvent.isFlow()) {
            mappingNode.setBlockComments(this.blockCommentsCollector.consume());
        }
        if (str != null) {
            mappingNode.setAnchor(str);
            this.anchors.put(str, mappingNode);
        }
        while (!this.parser.checkEvent(Event.ID.MappingEnd)) {
            this.blockCommentsCollector.collectEvents();
            if (this.parser.checkEvent(Event.ID.MappingEnd)) {
                break;
            }
            composeMappingChildren(arrayList, mappingNode);
        }
        if (mappingStartEvent.isFlow()) {
            mappingNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        }
        mappingNode.setEndMark(this.parser.getEvent().getEndMark());
        this.inlineCommentsCollector.collectEvents();
        if (!this.inlineCommentsCollector.isEmpty()) {
            mappingNode.setInLineComments(this.inlineCommentsCollector.consume());
        }
        if (this.loadingConfig.isMergeOnCompose() && mappingNode.isMerged()) {
            mappingNode.setValue(this.mergeUtils.flatten(mappingNode));
            mappingNode.setMerged(false);
        }
        return mappingNode;
    }

    protected void composeMappingChildren(List<NodeTuple> list, MappingNode mappingNode) {
        Node nodeComposeKeyNode = composeKeyNode(mappingNode);
        if (nodeComposeKeyNode.getTag().equals(Tag.MERGE)) {
            mappingNode.setMerged(true);
        }
        list.add(new NodeTuple(nodeComposeKeyNode, composeValueNode(mappingNode)));
    }

    protected MappingNode asMappingNode(Node node) {
        if (node instanceof MappingNode) {
            return (MappingNode) node;
        }
        Node node2 = this.anchors.get(node.getAnchor());
        if (node2 instanceof MappingNode) {
            return (MappingNode) node2;
        }
        throw new ComposerException("Expected mapping node or an anchor referencing mapping", this.parser.peekEvent().getStartMark());
    }

    protected Node composeKeyNode(MappingNode mappingNode) {
        return composeNode(mappingNode);
    }

    protected Node composeValueNode(MappingNode mappingNode) {
        return composeNode(mappingNode);
    }

    private void increaseNestingDepth() {
        if (this.nestingDepth > this.nestingDepthLimit) {
            throw new YAMLException("Nesting Depth exceeded max " + this.nestingDepthLimit);
        }
        this.nestingDepth++;
    }

    private void decreaseNestingDepth() {
        if (this.nestingDepth <= 0) {
            throw new YAMLException("Nesting Depth cannot be negative");
        }
        this.nestingDepth--;
    }
}

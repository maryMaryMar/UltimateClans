package me.ulrich.clans.library.enumconfig.library.emitter;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.comments.CommentEventsCollector;
import me.ulrich.clans.library.enumconfig.library.comments.CommentLine;
import me.ulrich.clans.library.enumconfig.library.comments.CommentType;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.events.AliasEvent;
import me.ulrich.clans.library.enumconfig.library.events.CollectionEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.CollectionStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.CommentEvent;
import me.ulrich.clans.library.enumconfig.library.events.DocumentEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.DocumentStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.Event;
import me.ulrich.clans.library.enumconfig.library.events.MappingEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.MappingStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.NodeEvent;
import me.ulrich.clans.library.enumconfig.library.events.ScalarEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.StreamEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.StreamStartEvent;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;
import me.ulrich.clans.library.enumconfig.library.reader.StreamReader;
import me.ulrich.clans.library.enumconfig.library.scanner.Constant;
import me.ulrich.clans.library.enumconfig.library.util.ArrayStack;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter.class */
public final class Emitter implements Emitable {
    public static final int MIN_INDENT = 1;
    public static final int MAX_INDENT = 10;
    private static final char[] SPACE = {' '};
    private static final Pattern SPACES_PATTERN = Pattern.compile("\\s");
    private static final Set<Character> INVALID_ANCHOR = new HashSet();
    private static final Map<Character, String> ESCAPE_REPLACEMENTS;
    private static final Map<String, String> DEFAULT_TAG_PREFIXES;
    private final Writer stream;
    private final ArrayStack<EmitterState> states;
    private EmitterState state;
    private final Queue<Event> events;
    private Event event;
    private final ArrayStack<Integer> indents;
    private Integer indent;
    private int flowLevel;
    private boolean rootContext;
    private boolean mappingContext;
    private boolean simpleKeyContext;
    private int column;
    private boolean whitespace;
    private boolean indention;
    private boolean openEnded;
    private final Boolean canonical;
    private final Boolean prettyFlow;
    private final boolean allowUnicode;
    private int bestIndent;
    private final int indicatorIndent;
    private final boolean indentWithIndicator;
    private int bestWidth;
    private final char[] bestLineBreak;
    private final boolean splitLines;
    private final int maxSimpleKeyLength;
    private final boolean emitComments;
    private Map<String, String> tagPrefixes;
    private String preparedAnchor;
    private String preparedTag;
    private ScalarAnalysis analysis;
    private DumperOptions.ScalarStyle style;
    private final CommentEventsCollector blockCommentsCollector;
    private final CommentEventsCollector inlineCommentsCollector;
    private static final Pattern HANDLE_FORMAT;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectBlockMappingKey.class */
    private class ExpectBlockMappingKey implements EmitterState {
        private final boolean first;

        public ExpectBlockMappingKey(boolean z) {
            this.first = z;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!this.first && (Emitter.this.event instanceof MappingEndEvent)) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            Emitter.this.writeIndent();
            if (Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectBlockMappingSimpleValue());
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, true);
                Emitter.this.states.push(new ExpectBlockMappingValue());
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectBlockMappingSimpleValue.class */
    private class ExpectBlockMappingSimpleValue implements EmitterState {
        private ExpectBlockMappingSimpleValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter.this.event = Emitter.this.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            if (!Emitter.this.isFoldedOrLiteral(Emitter.this.event) && Emitter.this.writeInlineComments()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeIndent();
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
            }
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeBlockComment();
                Emitter.this.writeIndent();
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
            }
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectBlockMappingValue.class */
    private class ExpectBlockMappingValue implements EmitterState {
        private ExpectBlockMappingValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator(":", true, false, true);
            Emitter.this.event = Emitter.this.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectBlockSequenceItem.class */
    private class ExpectBlockSequenceItem implements EmitterState {
        private final boolean first;

        public ExpectBlockSequenceItem(boolean z) {
            this.first = z;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            if (!this.first && (Emitter.this.event instanceof SequenceEndEvent)) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            if (Emitter.this.event instanceof CommentEvent) {
                Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                return;
            }
            Emitter.this.writeIndent();
            if (!Emitter.this.indentWithIndicator || this.first) {
                Emitter.this.writeWhitespace(Emitter.this.indicatorIndent);
            }
            Emitter.this.writeIndicator("-", true, false, true);
            if (Emitter.this.indentWithIndicator && this.first) {
                Emitter.this.indent = Integer.valueOf(Emitter.this.indent.intValue() + Emitter.this.indicatorIndent);
            }
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.increaseIndent(false, false);
                Emitter.this.writeBlockComment();
                if (Emitter.this.event instanceof ScalarEvent) {
                    ScalarEvent scalarEvent = (ScalarEvent) Emitter.this.event;
                    if (Emitter.this.analysis == null) {
                        Emitter.this.analysis = Emitter.this.analyzeScalar(scalarEvent.getValue());
                    }
                    if (Emitter.this.style == null) {
                        Emitter.this.style = Emitter.this.chooseScalarStyle();
                    }
                    if (!Emitter.this.analysis.isEmpty() || Emitter.this.style == DumperOptions.ScalarStyle.SINGLE_QUOTED || Emitter.this.style == DumperOptions.ScalarStyle.DOUBLE_QUOTED) {
                        Emitter.this.writeIndent();
                    }
                }
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
            }
            Emitter.this.states.push(Emitter.this.new ExpectBlockSequenceItem(false));
            Emitter.this.expectNode(false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectDocumentEnd.class */
    private class ExpectDocumentEnd implements EmitterState {
        private ExpectDocumentEnd() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!(Emitter.this.event instanceof DocumentEndEvent)) {
                throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeIndent();
            if (((DocumentEndEvent) Emitter.this.event).getExplicit()) {
                Emitter.this.writeIndicator("...", true, false, false);
                Emitter.this.writeIndent();
            }
            Emitter.this.flushStream();
            Emitter.this.state = Emitter.this.new ExpectDocumentStart(false);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectDocumentRoot.class */
    private class ExpectDocumentRoot implements EmitterState {
        private ExpectDocumentRoot() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.writeBlockComment();
                if (Emitter.this.event instanceof DocumentEndEvent) {
                    new ExpectDocumentEnd().expect();
                    return;
                }
            }
            Emitter.this.states.push(new ExpectDocumentEnd());
            Emitter.this.expectNode(true, false, false);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectDocumentStart.class */
    private class ExpectDocumentStart implements EmitterState {
        private final boolean first;

        public ExpectDocumentStart(boolean z) {
            this.first = z;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof DocumentStartEvent)) {
                if (Emitter.this.event instanceof StreamEndEvent) {
                    Emitter.this.writeStreamEnd();
                    Emitter.this.state = new ExpectNothing();
                    return;
                } else {
                    if (!(Emitter.this.event instanceof CommentEvent)) {
                        throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.this.event);
                    }
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    Emitter.this.writeBlockComment();
                    return;
                }
            }
            DocumentStartEvent documentStartEvent = (DocumentStartEvent) Emitter.this.event;
            if ((documentStartEvent.getVersion() != null || documentStartEvent.getTags() != null) && Emitter.this.openEnded) {
                Emitter.this.writeIndicator("...", true, false, false);
                Emitter.this.writeIndent();
            }
            if (documentStartEvent.getVersion() != null) {
                Emitter.this.writeVersionDirective(Emitter.this.prepareVersion(documentStartEvent.getVersion()));
            }
            Emitter.this.tagPrefixes = new LinkedHashMap(Emitter.DEFAULT_TAG_PREFIXES);
            if (documentStartEvent.getTags() != null) {
                for (String str : new TreeSet(documentStartEvent.getTags().keySet())) {
                    String str2 = documentStartEvent.getTags().get(str);
                    Emitter.this.tagPrefixes.put(str2, str);
                    Emitter.this.writeTagDirective(Emitter.this.prepareTagHandle(str), Emitter.this.prepareTagPrefix(str2));
                }
            }
            if (!(this.first && !documentStartEvent.getExplicit() && !Emitter.this.canonical.booleanValue() && documentStartEvent.getVersion() == null && (documentStartEvent.getTags() == null || documentStartEvent.getTags().isEmpty()) && !Emitter.this.checkEmptyDocument())) {
                Emitter.this.writeIndent();
                Emitter.this.writeIndicator("---", true, false, false);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndent();
                }
            }
            Emitter.this.state = new ExpectDocumentRoot();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFirstBlockMappingKey.class */
    private class ExpectFirstBlockMappingKey implements EmitterState {
        private ExpectFirstBlockMappingKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockMappingKey(true).expect();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFirstBlockSequenceItem.class */
    private class ExpectFirstBlockSequenceItem implements EmitterState {
        private ExpectFirstBlockSequenceItem() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockSequenceItem(true).expect();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFirstDocumentStart.class */
    private class ExpectFirstDocumentStart implements EmitterState {
        private ExpectFirstDocumentStart() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectDocumentStart(true).expect();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFirstFlowMappingKey.class */
    private class ExpectFirstFlowMappingKey implements EmitterState {
        private ExpectFirstFlowMappingKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.access$2210(Emitter.this);
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue());
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue());
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFirstFlowSequenceItem.class */
    private class ExpectFirstFlowSequenceItem implements EmitterState {
        private ExpectFirstFlowSequenceItem() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.access$2210(Emitter.this);
                Emitter.this.writeIndicator("]", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            if (Emitter.this.event instanceof CommentEvent) {
                Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                Emitter.this.writeBlockComment();
                return;
            }
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            Emitter.this.states.push(new ExpectFlowSequenceItem());
            Emitter.this.expectNode(false, false, false);
            Emitter.this.event = Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFlowMappingKey.class */
    private class ExpectFlowMappingKey implements EmitterState {
        private ExpectFlowMappingKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.access$2210(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            Emitter.this.writeIndicator(",", false, false, false);
            Emitter.this.event = Emitter.this.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue());
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue());
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFlowMappingSimpleValue.class */
    private class ExpectFlowMappingSimpleValue implements EmitterState {
        private ExpectFlowMappingSimpleValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter.this.event = Emitter.this.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey());
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFlowMappingValue.class */
    private class ExpectFlowMappingValue implements EmitterState {
        private ExpectFlowMappingValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator(":", true, false, false);
            Emitter.this.event = Emitter.this.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey());
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectFlowSequenceItem.class */
    private class ExpectFlowSequenceItem implements EmitterState {
        private ExpectFlowSequenceItem() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.access$2210(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                } else if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("]", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            if (Emitter.this.event instanceof CommentEvent) {
                Emitter.this.event = Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                return;
            }
            Emitter.this.writeIndicator(",", false, false, false);
            Emitter.this.writeBlockComment();
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            Emitter.this.states.push(Emitter.this.new ExpectFlowSequenceItem());
            Emitter.this.expectNode(false, false, false);
            Emitter.this.event = Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectNothing.class */
    private class ExpectNothing implements EmitterState {
        private ExpectNothing() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() {
            throw new EmitterException("expecting nothing, but got " + Emitter.this.event);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/Emitter$ExpectStreamStart.class */
    private class ExpectStreamStart implements EmitterState {
        private ExpectStreamStart() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.EmitterState
        public void expect() {
            if (!(Emitter.this.event instanceof StreamStartEvent)) {
                throw new EmitterException("expected StreamStartEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeStreamStart();
            Emitter.this.state = new ExpectFirstDocumentStart();
        }
    }

    public Emitter(Writer writer, DumperOptions dumperOptions) {
        if (writer == null) {
            throw new NullPointerException("Writer must be provided.");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.stream = writer;
        this.states = new ArrayStack<>(100);
        this.state = new ExpectStreamStart();
        this.events = new ArrayDeque(100);
        this.event = null;
        this.indents = new ArrayStack<>(10);
        this.indent = null;
        this.flowLevel = 0;
        this.mappingContext = false;
        this.simpleKeyContext = false;
        this.column = 0;
        this.whitespace = true;
        this.indention = true;
        this.openEnded = false;
        this.canonical = Boolean.valueOf(dumperOptions.isCanonical());
        this.prettyFlow = Boolean.valueOf(dumperOptions.isPrettyFlow());
        this.allowUnicode = dumperOptions.isAllowUnicode();
        this.bestIndent = 2;
        if (dumperOptions.getIndent() > 1 && dumperOptions.getIndent() < 10) {
            this.bestIndent = dumperOptions.getIndent();
        }
        this.indicatorIndent = dumperOptions.getIndicatorIndent();
        this.indentWithIndicator = dumperOptions.getIndentWithIndicator();
        this.bestWidth = 80;
        if (dumperOptions.getWidth() > this.bestIndent * 2) {
            this.bestWidth = dumperOptions.getWidth();
        }
        this.bestLineBreak = dumperOptions.getLineBreak().getString().toCharArray();
        this.splitLines = dumperOptions.getSplitLines();
        this.maxSimpleKeyLength = dumperOptions.getMaxSimpleKeyLength();
        this.emitComments = dumperOptions.isProcessComments();
        this.tagPrefixes = new LinkedHashMap();
        this.preparedAnchor = null;
        this.preparedTag = null;
        this.analysis = null;
        this.style = null;
        this.blockCommentsCollector = new CommentEventsCollector(this.events, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(this.events, CommentType.IN_LINE);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.emitter.Emitable
    public void emit(Event event) {
        this.events.add(event);
        while (!needMoreEvents()) {
            this.event = this.events.poll();
            this.state.expect();
            this.event = null;
        }
    }

    private boolean needMoreEvents() {
        if (this.events.isEmpty()) {
            return true;
        }
        Iterator<Event> it = this.events.iterator();
        Event next = it.next();
        while (true) {
            Event event = next;
            if (!(event instanceof CommentEvent)) {
                if (event instanceof DocumentStartEvent) {
                    return needEvents(it, 1);
                }
                if (event instanceof SequenceStartEvent) {
                    return needEvents(it, 2);
                }
                if (event instanceof MappingStartEvent) {
                    return needEvents(it, 3);
                }
                if (event instanceof StreamStartEvent) {
                    return needEvents(it, 2);
                }
                if (!(event instanceof StreamEndEvent) && this.emitComments) {
                    return needEvents(it, 1);
                }
                return false;
            }
            if (!it.hasNext()) {
                return true;
            }
            next = it.next();
        }
    }

    private boolean needEvents(Iterator<Event> it, int i) {
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Event next = it.next();
            if (!(next instanceof CommentEvent)) {
                i3++;
                if ((next instanceof DocumentStartEvent) || (next instanceof CollectionStartEvent)) {
                    i2++;
                } else if ((next instanceof DocumentEndEvent) || (next instanceof CollectionEndEvent)) {
                    i2--;
                } else if (next instanceof StreamEndEvent) {
                    i2 = -1;
                }
                if (i2 < 0) {
                    return false;
                }
            }
        }
        return i3 < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void increaseIndent(boolean z, boolean z2) {
        this.indents.push(this.indent);
        if (this.indent != null) {
            if (z2) {
                return;
            }
            this.indent = Integer.valueOf(this.indent.intValue() + this.bestIndent);
        } else if (z) {
            this.indent = Integer.valueOf(this.bestIndent);
        } else {
            this.indent = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expectNode(boolean z, boolean z2, boolean z3) throws IOException {
        this.rootContext = z;
        this.mappingContext = z2;
        this.simpleKeyContext = z3;
        if (this.event instanceof AliasEvent) {
            expectAlias();
            return;
        }
        if (!(this.event instanceof ScalarEvent) && !(this.event instanceof CollectionStartEvent)) {
            throw new EmitterException("expected NodeEvent, but got " + this.event);
        }
        processAnchor("&");
        processTag();
        if (this.event instanceof ScalarEvent) {
            expectScalar();
            return;
        }
        if (this.event instanceof SequenceStartEvent) {
            if (this.flowLevel != 0 || this.canonical.booleanValue() || ((SequenceStartEvent) this.event).isFlow() || checkEmptySequence()) {
                expectFlowSequence();
                return;
            } else {
                expectBlockSequence();
                return;
            }
        }
        if (this.flowLevel != 0 || this.canonical.booleanValue() || ((MappingStartEvent) this.event).isFlow() || checkEmptyMapping()) {
            expectFlowMapping();
        } else {
            expectBlockMapping();
        }
    }

    private void expectAlias() throws IOException {
        if (!(this.event instanceof AliasEvent)) {
            throw new EmitterException("Alias must be provided");
        }
        processAnchor(Marker.ANY_MARKER);
        this.state = this.states.pop();
    }

    private void expectScalar() throws IOException {
        increaseIndent(true, false);
        processScalar();
        this.indent = this.indents.pop();
        this.state = this.states.pop();
    }

    private void expectFlowSequence() throws IOException {
        writeIndicator("[", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowSequenceItem();
    }

    private void expectFlowMapping() throws IOException {
        writeIndicator("{", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowMappingKey();
    }

    private void expectBlockSequence() {
        increaseIndent(false, this.mappingContext && !this.indention);
        this.state = new ExpectFirstBlockSequenceItem();
    }

    private void expectBlockMapping() {
        increaseIndent(false, false);
        this.state = new ExpectFirstBlockMappingKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFoldedOrLiteral(Event event) {
        if (!event.is(Event.ID.Scalar)) {
            return false;
        }
        DumperOptions.ScalarStyle scalarStyle = ((ScalarEvent) event).getScalarStyle();
        return scalarStyle == DumperOptions.ScalarStyle.FOLDED || scalarStyle == DumperOptions.ScalarStyle.LITERAL;
    }

    private boolean checkEmptySequence() {
        return (this.event instanceof SequenceStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof SequenceEndEvent);
    }

    private boolean checkEmptyMapping() {
        return (this.event instanceof MappingStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof MappingEndEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkEmptyDocument() {
        if (!(this.event instanceof DocumentStartEvent) || this.events.isEmpty()) {
            return false;
        }
        Event eventPeek = this.events.peek();
        if (!(eventPeek instanceof ScalarEvent)) {
            return false;
        }
        ScalarEvent scalarEvent = (ScalarEvent) eventPeek;
        return scalarEvent.getAnchor() == null && scalarEvent.getTag() == null && scalarEvent.getImplicit() != null && scalarEvent.getValue().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSimpleKey() {
        int length = 0;
        if ((this.event instanceof NodeEvent) && ((NodeEvent) this.event).getAnchor() != null) {
            if (this.preparedAnchor == null) {
                this.preparedAnchor = prepareAnchor(((NodeEvent) this.event).getAnchor());
            }
            length = 0 + this.preparedAnchor.length();
        }
        String tag = null;
        if (this.event instanceof ScalarEvent) {
            tag = ((ScalarEvent) this.event).getTag();
        } else if (this.event instanceof CollectionStartEvent) {
            tag = ((CollectionStartEvent) this.event).getTag();
        }
        if (tag != null) {
            if (this.preparedTag == null) {
                this.preparedTag = prepareTag(tag);
            }
            length += this.preparedTag.length();
        }
        if (this.event instanceof ScalarEvent) {
            if (this.analysis == null) {
                this.analysis = analyzeScalar(((ScalarEvent) this.event).getValue());
            }
            length += this.analysis.getScalar().length();
        }
        return length < this.maxSimpleKeyLength && ((this.event instanceof AliasEvent) || (!(!(this.event instanceof ScalarEvent) || this.analysis.isEmpty() || this.analysis.isMultiline()) || checkEmptySequence() || checkEmptyMapping()));
    }

    private void processAnchor(String str) throws IOException {
        NodeEvent nodeEvent = (NodeEvent) this.event;
        if (nodeEvent.getAnchor() == null) {
            this.preparedAnchor = null;
            return;
        }
        if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(nodeEvent.getAnchor());
        }
        writeIndicator(str + this.preparedAnchor, true, false, false);
        this.preparedAnchor = null;
    }

    private void processTag() throws IOException {
        String tag;
        if (this.event instanceof ScalarEvent) {
            ScalarEvent scalarEvent = (ScalarEvent) this.event;
            tag = scalarEvent.getTag();
            if (this.style == null) {
                this.style = chooseScalarStyle();
            }
            if ((!this.canonical.booleanValue() || tag == null) && ((this.style == DumperOptions.ScalarStyle.PLAIN && scalarEvent.getImplicit().canOmitTagInPlainScalar()) || (this.style != DumperOptions.ScalarStyle.PLAIN && scalarEvent.getImplicit().canOmitTagInNonPlainScalar()))) {
                this.preparedTag = null;
                return;
            } else if (scalarEvent.getImplicit().canOmitTagInPlainScalar() && tag == null) {
                tag = DecorationTag.REVERT;
                this.preparedTag = null;
            }
        } else {
            CollectionStartEvent collectionStartEvent = (CollectionStartEvent) this.event;
            tag = collectionStartEvent.getTag();
            if ((!this.canonical.booleanValue() || tag == null) && collectionStartEvent.getImplicit()) {
                this.preparedTag = null;
                return;
            }
        }
        if (tag == null) {
            throw new EmitterException("tag is not specified");
        }
        if (this.preparedTag == null) {
            this.preparedTag = prepareTag(tag);
        }
        writeIndicator(this.preparedTag, true, false, false);
        this.preparedTag = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DumperOptions.ScalarStyle chooseScalarStyle() {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if ((!scalarEvent.isPlain() && scalarEvent.isDQuoted()) || this.canonical.booleanValue()) {
            return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
        }
        if (scalarEvent.isJson() && Tag.STR.getValue().equals(scalarEvent.getTag())) {
            return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
        }
        if ((scalarEvent.isPlain() || scalarEvent.isJson()) && scalarEvent.getImplicit().canOmitTagInPlainScalar() && (!(this.simpleKeyContext && (this.analysis.isEmpty() || this.analysis.isMultiline())) && ((this.flowLevel != 0 && this.analysis.isAllowFlowPlain()) || (this.flowLevel == 0 && this.analysis.isAllowBlockPlain())))) {
            return DumperOptions.ScalarStyle.PLAIN;
        }
        if ((scalarEvent.isLiteral() || scalarEvent.isFolded()) && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.isAllowBlock()) {
            return scalarEvent.getScalarStyle();
        }
        return ((scalarEvent.isPlain() || scalarEvent.isSQuoted()) && this.analysis.isAllowSingleQuoted() && !(this.simpleKeyContext && this.analysis.isMultiline())) ? DumperOptions.ScalarStyle.SINGLE_QUOTED : DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    private void processScalar() throws IOException {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        boolean z = !this.simpleKeyContext && this.splitLines;
        switch (this.style) {
            case PLAIN:
                writePlain(this.analysis.getScalar(), z);
                break;
            case DOUBLE_QUOTED:
                writeDoubleQuoted(this.analysis.getScalar(), z);
                break;
            case SINGLE_QUOTED:
                writeSingleQuoted(this.analysis.getScalar(), z);
                break;
            case FOLDED:
                writeFolded(this.analysis.getScalar(), z);
                break;
            case LITERAL:
                writeLiteral(this.analysis.getScalar());
                break;
            default:
                throw new YAMLException("Unexpected style: " + this.style);
        }
        this.analysis = null;
        this.style = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareVersion(DumperOptions.Version version) {
        if (version.major() != 1) {
            throw new EmitterException("unsupported YAML version: " + version);
        }
        return version.getRepresentation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagHandle(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag handle must not be empty");
        }
        if (str.charAt(0) != '!' || str.charAt(str.length() - 1) != '!') {
            throw new EmitterException("tag handle must start and end with '!': " + str);
        }
        if (DecorationTag.REVERT.equals(str) || HANDLE_FORMAT.matcher(str).matches()) {
            return str;
        }
        throw new EmitterException("invalid character in the tag handle: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagPrefix(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag prefix must not be empty");
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (str.charAt(0) == '!') {
            i = 1;
        }
        while (i < str.length()) {
            i++;
        }
        sb.append((CharSequence) str, 0, i);
        return sb.toString();
    }

    private String prepareTag(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag must not be empty");
        }
        if (DecorationTag.REVERT.equals(str)) {
            return str;
        }
        String str2 = null;
        String strSubstring = str;
        for (String str3 : this.tagPrefixes.keySet()) {
            if (str.startsWith(str3) && (DecorationTag.REVERT.equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            strSubstring = str.substring(str2.length());
            str2 = this.tagPrefixes.get(str2);
        }
        return str2 != null ? str2 + strSubstring : "!<" + strSubstring + ">";
    }

    static String prepareAnchor(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("anchor must not be empty");
        }
        for (Character ch : INVALID_ANCHOR) {
            if (str.indexOf(ch.charValue()) > -1) {
                throw new EmitterException("Invalid character '" + ch + "' in the anchor: " + str);
            }
        }
        if (SPACES_PATTERN.matcher(str).find()) {
            throw new EmitterException("Anchor may not contain spaces: " + str);
        }
        return str;
    }

    private static boolean hasLeadingZero(String str) {
        if (str.length() <= 1 || str.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '_')) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ScalarAnalysis analyzeScalar(String str) {
        int iCharCount;
        if (str.isEmpty()) {
            return new ScalarAnalysis(str, true, false, false, true, true, false);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean zHasLeadingZero = hasLeadingZero(str);
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        if (str.startsWith("---") || str.startsWith("...")) {
            z = true;
            z2 = true;
        }
        boolean z11 = true;
        boolean z12 = str.length() == 1 || Constant.NULL_BL_T_LINEBR.has(str.codePointAt(1));
        boolean z13 = false;
        boolean z14 = false;
        int iCharCount2 = 0;
        while (iCharCount2 < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount2);
            if (iCharCount2 == 0) {
                if ("#,[]{}&*!|>'\"%@`".indexOf(iCodePointAt) != -1) {
                    z2 = true;
                    z = true;
                }
                if (iCodePointAt == 63 || iCodePointAt == 58) {
                    z2 = true;
                    if (z12) {
                        z = true;
                    }
                }
                if (iCodePointAt == 45 && z12) {
                    z2 = true;
                    z = true;
                }
            } else {
                if (",?[]{}".indexOf(iCodePointAt) != -1) {
                    z2 = true;
                }
                if (iCodePointAt == 58) {
                    z2 = true;
                    if (z12) {
                        z = true;
                    }
                }
                if (iCodePointAt == 35 && z11) {
                    z2 = true;
                    z = true;
                }
            }
            boolean zHas = Constant.LINEBR.has(iCodePointAt);
            if (zHas) {
                z3 = true;
            }
            if (iCodePointAt != 10 && ((32 > iCodePointAt || iCodePointAt > 126) && ((iCodePointAt != 133 && ((iCodePointAt < 160 || iCodePointAt > 55295) && ((iCodePointAt < 57344 || iCodePointAt > 65533) && (iCodePointAt < 65536 || iCodePointAt > 1114111)))) || !this.allowUnicode))) {
                z4 = true;
            }
            if (iCodePointAt == 32) {
                if (iCharCount2 == 0) {
                    z5 = true;
                }
                if (iCharCount2 == str.length() - 1) {
                    z7 = true;
                }
                if (z14) {
                    z9 = true;
                }
                z13 = true;
                z14 = false;
            } else if (zHas) {
                if (iCharCount2 == 0) {
                    z6 = true;
                }
                if (iCharCount2 == str.length() - 1) {
                    z8 = true;
                }
                if (z13) {
                    z10 = true;
                }
                z13 = false;
                z14 = true;
            } else {
                z13 = false;
                z14 = false;
            }
            iCharCount2 += Character.charCount(iCodePointAt);
            z11 = Constant.NULL_BL_T.has(iCodePointAt) || zHas;
            z12 = true;
            if (iCharCount2 + 1 < str.length() && (iCharCount = iCharCount2 + Character.charCount(str.codePointAt(iCharCount2))) < str.length()) {
                z12 = Constant.NULL_BL_T.has(str.codePointAt(iCharCount)) || zHas;
            }
        }
        boolean z15 = true;
        boolean z16 = true;
        boolean z17 = true;
        boolean z18 = true;
        if (z5 || z6 || z7 || z8 || zHasLeadingZero) {
            z16 = false;
            z15 = false;
        }
        if (z7) {
            z18 = false;
        }
        if (z9) {
            z17 = false;
            z16 = false;
            z15 = false;
        }
        if (z10 || z4) {
            z18 = false;
            z17 = false;
            z16 = false;
            z15 = false;
        }
        if (z3) {
            z15 = false;
        }
        if (z2) {
            z15 = false;
        }
        if (z) {
            z16 = false;
        }
        return new ScalarAnalysis(str, false, z3, z15, z16, z17, z18);
    }

    void flushStream() throws IOException {
        this.stream.flush();
    }

    void writeStreamStart() {
    }

    void writeStreamEnd() throws IOException {
        flushStream();
    }

    void writeIndicator(String str, boolean z, boolean z2, boolean z3) throws IOException {
        if (!this.whitespace && z) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = z2;
        this.indention = this.indention && z3;
        this.column += str.length();
        this.openEnded = false;
        this.stream.write(str);
    }

    void writeIndent() throws IOException {
        int iIntValue = this.indent != null ? this.indent.intValue() : 0;
        if (!this.indention || this.column > iIntValue || (this.column == iIntValue && !this.whitespace)) {
            writeLineBreak(null);
        }
        writeWhitespace(iIntValue - this.column);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeWhitespace(int i) throws IOException {
        if (i <= 0) {
            return;
        }
        this.whitespace = true;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = ' ';
        }
        this.column += i;
        this.stream.write(cArr);
    }

    private void writeLineBreak(String str) throws IOException {
        this.whitespace = true;
        this.indention = true;
        this.column = 0;
        if (str == null) {
            this.stream.write(this.bestLineBreak);
        } else {
            this.stream.write(str);
        }
    }

    void writeVersionDirective(String str) throws IOException {
        this.stream.write("%YAML ");
        this.stream.write(str);
        writeLineBreak(null);
    }

    void writeTagDirective(String str, String str2) throws IOException {
        this.stream.write("%TAG ");
        this.stream.write(str);
        this.stream.write(SPACE);
        this.stream.write(str2);
        writeLineBreak(null);
    }

    private void writeSingleQuoted(String str, boolean z) throws IOException {
        writeIndicator("'", true, false, false);
        boolean z2 = false;
        boolean zHas = false;
        int i = 0;
        for (int i2 = 0; i2 <= str.length(); i2++) {
            char cCharAt = i2 < str.length() ? str.charAt(i2) : (char) 0;
            if (z2) {
                if (cCharAt == 0 || cCharAt != ' ') {
                    if (i + 1 != i2 || this.column <= this.bestWidth || !z || i == 0 || i2 == str.length()) {
                        int i3 = i2 - i;
                        this.column += i3;
                        this.stream.write(str, i, i3);
                    } else {
                        writeIndent();
                    }
                    i = i2;
                }
            } else if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i, i2).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    i = i2;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 '") && i < i2) {
                int i4 = i2 - i;
                this.column += i4;
                this.stream.write(str, i, i4);
                i = i2;
            }
            if (cCharAt == '\'') {
                this.column += 2;
                this.stream.write("''");
                i = i2 + 1;
            }
            if (cCharAt != 0) {
                z2 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
        }
        writeIndicator("'", false, false, false);
    }

    private void writeDoubleQuoted(String str, boolean z) throws IOException {
        int iCharValue;
        String strValueOf;
        writeIndicator("\"", true, false, false);
        int i = 0;
        int i2 = 0;
        while (i2 <= str.length()) {
            Character chValueOf = null;
            if (i2 < str.length()) {
                chValueOf = Character.valueOf(str.charAt(i2));
            }
            if (chValueOf == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(chValueOf.charValue()) != -1 || ' ' > chValueOf.charValue() || chValueOf.charValue() > '~') {
                if (i < i2) {
                    int i3 = i2 - i;
                    this.column += i3;
                    this.stream.write(str, i, i3);
                    i = i2;
                }
                if (chValueOf != null) {
                    if (ESCAPE_REPLACEMENTS.containsKey(chValueOf)) {
                        strValueOf = "\\" + ESCAPE_REPLACEMENTS.get(chValueOf);
                    } else {
                        if (!Character.isHighSurrogate(chValueOf.charValue()) || i2 + 1 >= str.length()) {
                            iCharValue = chValueOf.charValue();
                        } else {
                            iCharValue = Character.toCodePoint(chValueOf.charValue(), str.charAt(i2 + 1));
                        }
                        if (this.allowUnicode && StreamReader.isPrintable(iCharValue)) {
                            strValueOf = String.valueOf(Character.toChars(iCharValue));
                            if (Character.charCount(iCharValue) == 2) {
                                i2++;
                            }
                        } else if (chValueOf.charValue() <= 255) {
                            String str2 = "0" + Integer.toString(chValueOf.charValue(), 16);
                            strValueOf = "\\x" + str2.substring(str2.length() - 2);
                        } else if (Character.charCount(iCharValue) == 2) {
                            i2++;
                            String str3 = "000" + Long.toHexString(iCharValue);
                            strValueOf = "\\U" + str3.substring(str3.length() - 8);
                        } else {
                            String str4 = "000" + Integer.toString(chValueOf.charValue(), 16);
                            strValueOf = "\\u" + str4.substring(str4.length() - 4);
                        }
                    }
                    this.column += strValueOf.length();
                    this.stream.write(strValueOf);
                    i = i2 + 1;
                }
            }
            if (0 < i2 && i2 < str.length() - 1 && ((chValueOf.charValue() == ' ' || i >= i2) && this.column + (i2 - i) > this.bestWidth && z)) {
                String str5 = i >= i2 ? "\\" : str.substring(i, i2) + "\\";
                if (i < i2) {
                    i = i2;
                }
                this.column += str5.length();
                this.stream.write(str5);
                writeIndent();
                this.whitespace = false;
                this.indention = false;
                if (str.charAt(i) == ' ') {
                    this.column += "\\".length();
                    this.stream.write("\\");
                }
            }
            i2++;
        }
        writeIndicator("\"", false, false, false);
    }

    private boolean writeCommentLines(List<CommentLine> list) throws IOException {
        boolean z = false;
        if (this.emitComments) {
            int i = 0;
            boolean z2 = true;
            for (CommentLine commentLine : list) {
                if (commentLine.getCommentType() != CommentType.BLANK_LINE) {
                    if (z2) {
                        z2 = false;
                        writeIndicator(TextColor.HEX_PREFIX, commentLine.getCommentType() == CommentType.IN_LINE, false, false);
                        i = this.column > 0 ? this.column - 1 : 0;
                    } else {
                        writeWhitespace(i);
                        writeIndicator(TextColor.HEX_PREFIX, false, false, false);
                    }
                    this.stream.write(commentLine.getValue());
                    writeLineBreak(null);
                } else {
                    writeLineBreak(null);
                    writeIndent();
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBlockComment() throws IOException {
        if (this.blockCommentsCollector.isEmpty()) {
            return;
        }
        writeIndent();
        writeCommentLines(this.blockCommentsCollector.consume());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeInlineComments() {
        return writeCommentLines(this.inlineCommentsCollector.consume());
    }

    private String determineBlockHints(String str) {
        StringBuilder sb = new StringBuilder();
        if (Constant.LINEBR.has(str.charAt(0), " ")) {
            sb.append(this.bestIndent);
        }
        if (Constant.LINEBR.hasNo(str.charAt(str.length() - 1))) {
            sb.append("-");
        } else if (str.length() == 1 || Constant.LINEBR.has(str.charAt(str.length() - 2))) {
            sb.append(Marker.ANY_NON_NULL_MARKER);
        }
        return sb.toString();
    }

    void writeFolded(String str, boolean z) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        writeIndicator(">" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        boolean z2 = true;
        boolean z3 = false;
        boolean zHas = true;
        int i = 0;
        for (int i2 = 0; i2 <= str.length(); i2++) {
            char cCharAt = i2 < str.length() ? str.charAt(i2) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (!z2 && cCharAt != 0 && cCharAt != ' ' && str.charAt(i) == '\n') {
                        writeLineBreak(null);
                    }
                    z2 = cCharAt == ' ';
                    for (char c : str.substring(i, i2).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i = i2;
                }
            } else if (z3) {
                if (cCharAt != ' ') {
                    if (i + 1 == i2 && this.column > this.bestWidth && z) {
                        writeIndent();
                    } else {
                        int i3 = i2 - i;
                        this.column += i3;
                        this.stream.write(str, i, i3);
                    }
                    i = i2;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i4 = i2 - i;
                this.column += i4;
                this.stream.write(str, i, i4);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i = i2;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
                z3 = cCharAt == ' ';
            }
        }
    }

    void writeLiteral(String str) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        writeIndicator("|" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        boolean zHas = true;
        int i = 0;
        for (int i2 = 0; i2 <= str.length(); i2++) {
            char cCharAt = i2 < str.length() ? str.charAt(i2) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    for (char c : str.substring(i, i2).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i = i2;
                }
            } else if (cCharAt == 0 || Constant.LINEBR.has(cCharAt)) {
                this.stream.write(str, i, i2 - i);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i = i2;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
            }
        }
    }

    void writePlain(String str, boolean z) throws IOException {
        if (this.rootContext) {
            this.openEnded = true;
        }
        if (str.isEmpty()) {
            return;
        }
        if (!this.whitespace) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = false;
        this.indention = false;
        boolean z2 = false;
        boolean zHas = false;
        int i = 0;
        for (int i2 = 0; i2 <= str.length(); i2++) {
            char cCharAt = i2 < str.length() ? str.charAt(i2) : (char) 0;
            if (z2) {
                if (cCharAt != ' ') {
                    if (i + 1 == i2 && this.column > this.bestWidth && z) {
                        writeIndent();
                        this.whitespace = false;
                        this.indention = false;
                    } else {
                        int i3 = i2 - i;
                        this.column += i3;
                        this.stream.write(str, i, i3);
                    }
                    i = i2;
                }
            } else if (zHas) {
                if (Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i, i2).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    this.whitespace = false;
                    this.indention = false;
                    i = i2;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i4 = i2 - i;
                this.column += i4;
                this.stream.write(str, i, i4);
                i = i2;
            }
            if (cCharAt != 0) {
                z2 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
        }
    }

    static /* synthetic */ int access$2210(Emitter emitter) {
        int i = emitter.flowLevel;
        emitter.flowLevel = i - 1;
        return i;
    }

    static {
        INVALID_ANCHOR.add('[');
        INVALID_ANCHOR.add(']');
        INVALID_ANCHOR.add('{');
        INVALID_ANCHOR.add('}');
        INVALID_ANCHOR.add(',');
        INVALID_ANCHOR.add('*');
        INVALID_ANCHOR.add('&');
        ESCAPE_REPLACEMENTS = new HashMap();
        ESCAPE_REPLACEMENTS.put((char) 0, "0");
        ESCAPE_REPLACEMENTS.put((char) 7, "a");
        ESCAPE_REPLACEMENTS.put('\b', "b");
        ESCAPE_REPLACEMENTS.put('\t', "t");
        ESCAPE_REPLACEMENTS.put('\n', "n");
        ESCAPE_REPLACEMENTS.put((char) 11, "v");
        ESCAPE_REPLACEMENTS.put('\f', "f");
        ESCAPE_REPLACEMENTS.put('\r', "r");
        ESCAPE_REPLACEMENTS.put((char) 27, "e");
        ESCAPE_REPLACEMENTS.put('\"', "\"");
        ESCAPE_REPLACEMENTS.put('\\', "\\");
        ESCAPE_REPLACEMENTS.put((char) 133, "N");
        ESCAPE_REPLACEMENTS.put((char) 160, "_");
        ESCAPE_REPLACEMENTS.put((char) 8232, "L");
        ESCAPE_REPLACEMENTS.put((char) 8233, "P");
        DEFAULT_TAG_PREFIXES = new LinkedHashMap();
        DEFAULT_TAG_PREFIXES.put(DecorationTag.REVERT, DecorationTag.REVERT);
        DEFAULT_TAG_PREFIXES.put(Tag.PREFIX, "!!");
        HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
    }
}

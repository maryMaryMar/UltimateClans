package me.ulrich.clans.library.enumconfig.library.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.LoaderOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.events.AliasEvent;
import me.ulrich.clans.library.enumconfig.library.events.CommentEvent;
import me.ulrich.clans.library.enumconfig.library.events.DocumentEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.DocumentStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.Event;
import me.ulrich.clans.library.enumconfig.library.events.ImplicitTuple;
import me.ulrich.clans.library.enumconfig.library.events.MappingEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.MappingStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.ScalarEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.SequenceStartEvent;
import me.ulrich.clans.library.enumconfig.library.events.StreamEndEvent;
import me.ulrich.clans.library.enumconfig.library.events.StreamStartEvent;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;
import me.ulrich.clans.library.enumconfig.library.reader.StreamReader;
import me.ulrich.clans.library.enumconfig.library.scanner.Scanner;
import me.ulrich.clans.library.enumconfig.library.scanner.ScannerImpl;
import me.ulrich.clans.library.enumconfig.library.tokens.AliasToken;
import me.ulrich.clans.library.enumconfig.library.tokens.AnchorToken;
import me.ulrich.clans.library.enumconfig.library.tokens.BlockEntryToken;
import me.ulrich.clans.library.enumconfig.library.tokens.CommentToken;
import me.ulrich.clans.library.enumconfig.library.tokens.DirectiveToken;
import me.ulrich.clans.library.enumconfig.library.tokens.ScalarToken;
import me.ulrich.clans.library.enumconfig.library.tokens.StreamEndToken;
import me.ulrich.clans.library.enumconfig.library.tokens.StreamStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.TagToken;
import me.ulrich.clans.library.enumconfig.library.tokens.TagTuple;
import me.ulrich.clans.library.enumconfig.library.tokens.Token;
import me.ulrich.clans.library.enumconfig.library.util.ArrayStack;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl.class */
public class ParserImpl implements Parser {
    private static final Map<String, String> DEFAULT_TAGS = new HashMap();
    protected final Scanner scanner;
    private Event currentEvent;
    private final ArrayStack<Production> states;
    private final ArrayStack<Mark> marks;
    private Production state;
    private VersionTagsTuple directives;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockMappingFirstKey.class */
    private class ParseBlockMappingFirstKey implements Production {
        private ParseBlockMappingFirstKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockMappingKey.class */
    private class ParseBlockMappingKey implements Production {
        private ParseBlockMappingKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseBlockMappingKey();
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.state = new ParseBlockMappingValue();
                    return ParserImpl.this.processEmptyScalar(token.getEndMark());
                }
                ParserImpl.this.states.push(new ParseBlockMappingValue());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block mapping", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found '" + tokenPeekToken.getTokenId() + "'", tokenPeekToken.getStartMark());
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return mappingEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockMappingValue.class */
    private class ParseBlockMappingValue implements Production {
        private ParseBlockMappingValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                if (ParserImpl.this.scanner.checkToken(Token.ID.Scalar)) {
                    ParserImpl.this.states.push(new ParseBlockMappingKey());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockMappingValueComment();
                return ParserImpl.this.state.produce();
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.states.push(new ParseBlockMappingKey());
            return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockMappingValueComment.class */
    private class ParseBlockMappingValueComment implements Production {
        List<CommentToken> tokens;

        private ParseBlockMappingValueComment() {
            this.tokens = new LinkedList();
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                this.tokens.add((CommentToken) ParserImpl.this.scanner.getToken());
                return produce();
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.state = ParserImpl.this.new ParseBlockMappingValueCommentList(this.tokens);
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            ParserImpl.this.states.push(new ParseBlockMappingKey());
            return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockMappingValueCommentList.class */
    private class ParseBlockMappingValueCommentList implements Production {
        List<CommentToken> tokens;

        public ParseBlockMappingValueCommentList(List<CommentToken> list) {
            this.tokens = list;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            return !this.tokens.isEmpty() ? ParserImpl.this.produceCommentEvent(this.tokens.remove(0)) : new ParseBlockMappingKey().produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockNode.class */
    private class ParseBlockNode implements Production {
        private ParseBlockNode() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockSequenceEntryKey.class */
    private class ParseBlockSequenceEntryKey implements Production {
        private ParseBlockSequenceEntryKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseBlockSequenceEntryKey();
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                return ParserImpl.this.new ParseBlockSequenceEntryValue((BlockEntryToken) ParserImpl.this.scanner.getToken()).produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block collection", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found '" + tokenPeekToken.getTokenId() + "'", tokenPeekToken.getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockSequenceEntryValue.class */
    private class ParseBlockSequenceEntryValue implements Production {
        BlockEntryToken token;

        public ParseBlockSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseBlockSequenceEntryValue(this.token);
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                ParserImpl.this.state = new ParseBlockSequenceEntryKey();
                return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
            }
            ParserImpl.this.states.push(new ParseBlockSequenceEntryKey());
            return new ParseBlockNode().produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseBlockSequenceFirstEntry.class */
    private class ParseBlockSequenceFirstEntry implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockSequenceEntryKey().produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseDocumentContent.class */
    private class ParseDocumentContent implements Production {
        private ParseDocumentContent() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseDocumentContent();
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                return new ParseBlockNode().produce();
            }
            Event eventProcessEmptyScalar = ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            return eventProcessEmptyScalar;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseDocumentEnd.class */
    private class ParseDocumentEnd implements Production {
        private ParseDocumentEnd() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
            Mark endMark = startMark;
            boolean z = false;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                endMark = ParserImpl.this.scanner.getToken().getEndMark();
                z = true;
            }
            DocumentEndEvent documentEndEvent = new DocumentEndEvent(startMark, endMark, z);
            ParserImpl.this.state = new ParseDocumentStart();
            return documentEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseDocumentStart.class */
    private class ParseDocumentStart implements Production {
        private ParseDocumentStart() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                ParserImpl.this.scanner.resetDocumentIndex();
                Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
                VersionTagsTuple versionTagsTupleProcessDirectives = ParserImpl.this.processDirectives();
                while (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.scanner.getToken();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                        throw new ParserException(null, null, "expected '<document start>', but found '" + ParserImpl.this.scanner.peekToken().getTokenId() + "'", ParserImpl.this.scanner.peekToken().getStartMark());
                    }
                    DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, ParserImpl.this.scanner.getToken().getEndMark(), true, versionTagsTupleProcessDirectives.getVersion(), versionTagsTupleProcessDirectives.getTags());
                    ParserImpl.this.states.push(new ParseDocumentEnd());
                    ParserImpl.this.state = new ParseDocumentContent();
                    return documentStartEvent;
                }
            }
            StreamEndToken streamEndToken = (StreamEndToken) ParserImpl.this.scanner.getToken();
            StreamEndEvent streamEndEvent = new StreamEndEvent(streamEndToken.getStartMark(), streamEndToken.getEndMark());
            if (!ParserImpl.this.states.isEmpty()) {
                throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
            }
            if (!ParserImpl.this.marks.isEmpty()) {
                throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
            }
            ParserImpl.this.state = null;
            return streamEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowEndComment.class */
    private class ParseFlowEndComment implements Production {
        private ParseFlowEndComment() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            CommentEvent commentEventProduceCommentEvent = ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            }
            return commentEventProduceCommentEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowMappingEmptyValue.class */
    private class ParseFlowMappingEmptyValue implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowMappingFirstKey.class */
    private class ParseFlowMappingFirstKey implements Production {
        private ParseFlowMappingFirstKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return ParserImpl.this.new ParseFlowMappingKey(true).produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowMappingKey.class */
    private class ParseFlowMappingKey implements Production {
        private final boolean first;

        public ParseFlowMappingKey(boolean z) {
            this.first = z;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(this.first);
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", (Mark) ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
                    }
                    ParserImpl.this.scanner.getToken();
                    if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                        ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(true);
                        return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token = ParserImpl.this.scanner.getToken();
                    if (ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.state = new ParseFlowMappingValue();
                        return ParserImpl.this.processEmptyScalar(token.getEndMark());
                    }
                    ParserImpl.this.states.push(new ParseFlowMappingValue());
                    return ParserImpl.this.parseFlowNode();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl.this.marks.pop();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowEndComment();
            } else {
                ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            }
            return mappingEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowMappingValue.class */
    private class ParseFlowMappingValue implements Production {
        private ParseFlowMappingValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.states.push(ParserImpl.this.new ParseFlowMappingKey(false));
            return ParserImpl.this.parseFlowNode();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowSequenceEntry.class */
    private class ParseFlowSequenceEntry implements Production {
        private final boolean first;

        public ParseFlowSequenceEntry(boolean z) {
            this.first = z;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseFlowSequenceEntry(this.first);
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", (Mark) ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
                    }
                    ParserImpl.this.scanner.getToken();
                    if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                        ParserImpl.this.state = ParserImpl.this.new ParseFlowSequenceEntry(true);
                        return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token tokenPeekToken2 = ParserImpl.this.scanner.peekToken();
                    MappingStartEvent mappingStartEvent = new MappingStartEvent(null, null, true, tokenPeekToken2.getStartMark(), tokenPeekToken2.getEndMark(), DumperOptions.FlowStyle.FLOW);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return mappingStartEvent;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(ParserImpl.this.new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowEndComment();
            } else {
                ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            }
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowSequenceEntryMappingEnd.class */
    private class ParseFlowSequenceEntryMappingEnd implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            ParserImpl.this.state = ParserImpl.this.new ParseFlowSequenceEntry(false);
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(tokenPeekToken.getStartMark(), tokenPeekToken.getEndMark());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowSequenceEntryMappingKey.class */
    private class ParseFlowSequenceEntryMappingKey implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
            return ParserImpl.this.parseFlowNode();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowSequenceEntryMappingValue.class */
    private class ParseFlowSequenceEntryMappingValue implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
            return ParserImpl.this.parseFlowNode();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseFlowSequenceFirstEntry.class */
    private class ParseFlowSequenceFirstEntry implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return ParserImpl.this.new ParseFlowSequenceEntry(true).produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseImplicitDocumentStart.class */
    private class ParseImplicitDocumentStart implements Production {
        private ParseImplicitDocumentStart() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseImplicitDocumentStart();
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                return new ParseDocumentStart().produce();
            }
            Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
            DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, startMark, false, null, null);
            ParserImpl.this.states.push(new ParseDocumentEnd());
            ParserImpl.this.state = new ParseBlockNode();
            return documentStartEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseIndentlessSequenceEntryKey.class */
    private class ParseIndentlessSequenceEntryKey implements Production {
        private ParseIndentlessSequenceEntryKey() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseIndentlessSequenceEntryKey();
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                return ParserImpl.this.new ParseIndentlessSequenceEntryValue((BlockEntryToken) ParserImpl.this.scanner.getToken()).produce();
            }
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(tokenPeekToken.getStartMark(), tokenPeekToken.getEndMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            return sequenceEndEvent;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseIndentlessSequenceEntryValue.class */
    private class ParseIndentlessSequenceEntryValue implements Production {
        BlockEntryToken token;

        public ParseIndentlessSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = ParserImpl.this.new ParseIndentlessSequenceEntryValue(this.token);
                return ParserImpl.this.produceCommentEvent((CommentToken) ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
                return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
            }
            ParserImpl.this.states.push(new ParseIndentlessSequenceEntryKey());
            return new ParseBlockNode().produce();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserImpl$ParseStreamStart.class */
    private class ParseStreamStart implements Production {
        private ParseStreamStart() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.parser.Production
        public Event produce() {
            StreamStartToken streamStartToken = (StreamStartToken) ParserImpl.this.scanner.getToken();
            StreamStartEvent streamStartEvent = new StreamStartEvent(streamStartToken.getStartMark(), streamStartToken.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return streamStartEvent;
        }
    }

    public ParserImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        this(new ScannerImpl(streamReader, loaderOptions));
    }

    public ParserImpl(Scanner scanner) {
        this.scanner = scanner;
        this.currentEvent = null;
        this.directives = new VersionTagsTuple(null, new HashMap(DEFAULT_TAGS));
        this.states = new ArrayStack<>(100);
        this.marks = new ArrayStack<>(10);
        this.state = new ParseStreamStart();
    }

    @Override // me.ulrich.clans.library.enumconfig.library.parser.Parser
    public boolean checkEvent(Event.ID id) {
        peekEvent();
        return this.currentEvent != null && this.currentEvent.is(id);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.parser.Parser
    public Event peekEvent() {
        if (this.currentEvent == null && this.state != null) {
            this.currentEvent = this.state.produce();
        }
        return this.currentEvent;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.parser.Parser
    public Event getEvent() {
        peekEvent();
        Event event = this.currentEvent;
        this.currentEvent = null;
        return event;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CommentEvent produceCommentEvent(CommentToken commentToken) {
        Mark startMark = commentToken.getStartMark();
        Mark endMark = commentToken.getEndMark();
        return new CommentEvent(commentToken.getCommentType(), commentToken.getValue(), startMark, endMark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VersionTagsTuple processDirectives() {
        HashMap map = new HashMap(this.directives.getTags());
        Iterator<String> it = DEFAULT_TAGS.keySet().iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        this.directives = new VersionTagsTuple(null, map);
        while (this.scanner.checkToken(Token.ID.Directive)) {
            DirectiveToken directiveToken = (DirectiveToken) this.scanner.getToken();
            if (directiveToken.getName().equals("YAML")) {
                if (this.directives.getVersion() != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", directiveToken.getStartMark());
                }
                List value = directiveToken.getValue();
                if (((Integer) value.get(0)).intValue() != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", directiveToken.getStartMark());
                }
                if (((Integer) value.get(1)).intValue() == 0) {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_0, map);
                } else {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_1, map);
                }
            } else if (directiveToken.getName().equals("TAG")) {
                List value2 = directiveToken.getValue();
                String str = (String) value2.get(0);
                String str2 = (String) value2.get(1);
                if (map.containsKey(str)) {
                    throw new ParserException(null, null, "duplicate tag handle " + str, directiveToken.getStartMark());
                }
                map.put(str, str2);
            } else {
                continue;
            }
        }
        HashMap map2 = new HashMap();
        if (!map.isEmpty()) {
            map2 = new HashMap(map);
        }
        for (String str3 : DEFAULT_TAGS.keySet()) {
            if (!map.containsKey(str3)) {
                map.put(str3, DEFAULT_TAGS.get(str3));
            }
        }
        return new VersionTagsTuple(this.directives.getVersion(), map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseFlowNode() {
        return parseNode(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseBlockNodeOrIndentlessSequence() {
        return parseNode(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseNode(boolean z, boolean z2) {
        Event scalarEvent;
        ImplicitTuple implicitTuple;
        Mark startMark = null;
        Mark endMark = null;
        Mark startMark2 = null;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            AliasToken aliasToken = (AliasToken) this.scanner.getToken();
            scalarEvent = new AliasEvent(aliasToken.getValue(), aliasToken.getStartMark(), aliasToken.getEndMark());
            this.state = this.states.pop();
        } else {
            String value = null;
            TagTuple value2 = null;
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                AnchorToken anchorToken = (AnchorToken) this.scanner.getToken();
                startMark = anchorToken.getStartMark();
                endMark = anchorToken.getEndMark();
                value = anchorToken.getValue();
                if (this.scanner.checkToken(Token.ID.Tag)) {
                    TagToken tagToken = (TagToken) this.scanner.getToken();
                    startMark2 = tagToken.getStartMark();
                    endMark = tagToken.getEndMark();
                    value2 = tagToken.getValue();
                }
            } else if (this.scanner.checkToken(Token.ID.Tag)) {
                TagToken tagToken2 = (TagToken) this.scanner.getToken();
                startMark = tagToken2.getStartMark();
                startMark2 = startMark;
                endMark = tagToken2.getEndMark();
                value2 = tagToken2.getValue();
                if (this.scanner.checkToken(Token.ID.Anchor)) {
                    AnchorToken anchorToken2 = (AnchorToken) this.scanner.getToken();
                    endMark = anchorToken2.getEndMark();
                    value = anchorToken2.getValue();
                }
            }
            String str = null;
            if (value2 != null) {
                String handle = value2.getHandle();
                String suffix = value2.getSuffix();
                if (handle == null) {
                    str = suffix;
                } else {
                    if (!this.directives.getTags().containsKey(handle)) {
                        throw new ParserException("while parsing a node", startMark, "found undefined tag handle " + handle, startMark2);
                    }
                    str = this.directives.getTags().get(handle) + suffix;
                }
            }
            if (startMark == null) {
                startMark = this.scanner.peekToken().getStartMark();
                endMark = startMark;
            }
            boolean z3 = str == null || str.equals(DecorationTag.REVERT);
            if (z2 && this.scanner.checkToken(Token.ID.BlockEntry)) {
                scalarEvent = new SequenceStartEvent(value, str, z3, startMark, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseIndentlessSequenceEntryKey();
            } else if (this.scanner.checkToken(Token.ID.Scalar)) {
                ScalarToken scalarToken = (ScalarToken) this.scanner.getToken();
                Mark endMark2 = scalarToken.getEndMark();
                if ((scalarToken.getPlain() && str == null) || DecorationTag.REVERT.equals(str)) {
                    implicitTuple = new ImplicitTuple(true, false);
                } else {
                    implicitTuple = str == null ? new ImplicitTuple(false, true) : new ImplicitTuple(false, false);
                }
                scalarEvent = new ScalarEvent(value, str, implicitTuple, scalarToken.getValue(), startMark, endMark2, scalarToken.getStyle());
                this.state = this.states.pop();
            } else if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
                scalarEvent = new SequenceStartEvent(value, str, z3, startMark, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowSequenceFirstEntry();
            } else if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
                scalarEvent = new MappingStartEvent(value, str, z3, startMark, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowMappingFirstKey();
            } else if (z && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
                scalarEvent = new SequenceStartEvent(value, str, z3, startMark, this.scanner.peekToken().getStartMark(), DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockSequenceFirstEntry();
            } else if (z && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
                scalarEvent = new MappingStartEvent(value, str, z3, startMark, this.scanner.peekToken().getStartMark(), DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockMappingFirstKey();
            } else {
                if (value == null && str == null) {
                    Token tokenPeekToken = this.scanner.peekToken();
                    throw new ParserException("while parsing a " + (z ? "block" : "flow") + " node", startMark, "expected the node content, but found '" + tokenPeekToken.getTokenId() + "'", tokenPeekToken.getStartMark());
                }
                scalarEvent = new ScalarEvent(value, str, new ImplicitTuple(z3, false), "", startMark, endMark, DumperOptions.ScalarStyle.PLAIN);
                this.state = this.states.pop();
            }
        }
        return scalarEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event processEmptyScalar(Mark mark) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), "", mark, mark, DumperOptions.ScalarStyle.PLAIN);
    }

    static {
        DEFAULT_TAGS.put(DecorationTag.REVERT, DecorationTag.REVERT);
        DEFAULT_TAGS.put("!!", Tag.PREFIX);
    }
}

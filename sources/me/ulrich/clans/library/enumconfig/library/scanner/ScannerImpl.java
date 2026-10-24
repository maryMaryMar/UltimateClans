package me.ulrich.clans.library.enumconfig.library.scanner;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.LoaderOptions;
import me.ulrich.clans.library.enumconfig.library.comments.CommentType;
import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.reader.StreamReader;
import me.ulrich.clans.library.enumconfig.library.tokens.AliasToken;
import me.ulrich.clans.library.enumconfig.library.tokens.AnchorToken;
import me.ulrich.clans.library.enumconfig.library.tokens.BlockEndToken;
import me.ulrich.clans.library.enumconfig.library.tokens.BlockEntryToken;
import me.ulrich.clans.library.enumconfig.library.tokens.BlockMappingStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.BlockSequenceStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.CommentToken;
import me.ulrich.clans.library.enumconfig.library.tokens.DirectiveToken;
import me.ulrich.clans.library.enumconfig.library.tokens.DocumentEndToken;
import me.ulrich.clans.library.enumconfig.library.tokens.DocumentStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.FlowEntryToken;
import me.ulrich.clans.library.enumconfig.library.tokens.FlowMappingEndToken;
import me.ulrich.clans.library.enumconfig.library.tokens.FlowMappingStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.FlowSequenceEndToken;
import me.ulrich.clans.library.enumconfig.library.tokens.FlowSequenceStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.KeyToken;
import me.ulrich.clans.library.enumconfig.library.tokens.ScalarToken;
import me.ulrich.clans.library.enumconfig.library.tokens.StreamEndToken;
import me.ulrich.clans.library.enumconfig.library.tokens.StreamStartToken;
import me.ulrich.clans.library.enumconfig.library.tokens.TagToken;
import me.ulrich.clans.library.enumconfig.library.tokens.TagTuple;
import me.ulrich.clans.library.enumconfig.library.tokens.Token;
import me.ulrich.clans.library.enumconfig.library.tokens.ValueToken;
import me.ulrich.clans.library.enumconfig.library.util.ArrayStack;
import me.ulrich.clans.library.enumconfig.library.util.UriEncoder;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/scanner/ScannerImpl.class */
public final class ScannerImpl implements Scanner {
    private static final Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
    public static final Map<Character, String> ESCAPE_REPLACEMENTS = new HashMap();
    public static final Map<Character, Integer> ESCAPE_CODES = new HashMap();
    private final StreamReader reader;
    private final List<Token> tokens;
    private Token lastToken;
    private final ArrayStack<Integer> indents;
    private final boolean parseComments;
    private final LoaderOptions loaderOptions;
    private final Map<Integer, SimpleKey> possibleSimpleKeys;
    private boolean done = false;
    private int flowLevel = 0;
    private int tokensTaken = 0;
    private int indent = -1;
    private boolean allowSimpleKey = true;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/scanner/ScannerImpl$Chomping.class */
    private static class Chomping {
        private final Boolean value;
        private final int increment;

        public Chomping(Boolean bool, int i) {
            this.value = bool;
            this.increment = i;
        }

        public boolean chompTailIsNotFalse() {
            return this.value == null || this.value.booleanValue();
        }

        public boolean chompTailIsTrue() {
            return this.value != null && this.value.booleanValue();
        }

        public int getIncrement() {
            return this.increment;
        }
    }

    public ScannerImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.parseComments = loaderOptions.isProcessComments();
        this.reader = streamReader;
        this.tokens = new ArrayList(100);
        this.indents = new ArrayStack<>(10);
        this.possibleSimpleKeys = new LinkedHashMap();
        this.loaderOptions = loaderOptions;
        fetchStreamStart();
    }

    @Override // me.ulrich.clans.library.enumconfig.library.scanner.Scanner
    public boolean checkToken(Token.ID id) {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        return !this.tokens.isEmpty() && this.tokens.get(0).getTokenId() == id;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.scanner.Scanner
    public boolean checkToken(Token.ID... idArr) {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        if (this.tokens.isEmpty()) {
            return false;
        }
        if (idArr.length == 0) {
            return true;
        }
        Token.ID tokenId = this.tokens.get(0).getTokenId();
        for (Token.ID id : idArr) {
            if (tokenId == id) {
                return true;
            }
        }
        return false;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.scanner.Scanner
    public Token peekToken() {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        return this.tokens.get(0);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.scanner.Scanner
    public Token getToken() {
        this.tokensTaken++;
        return this.tokens.remove(0);
    }

    private void addToken(Token token) {
        this.lastToken = token;
        this.tokens.add(token);
    }

    private void addToken(int i, Token token) {
        if (i == this.tokens.size()) {
            this.lastToken = token;
        }
        this.tokens.add(i, token);
    }

    private void addAllTokens(List<Token> list) {
        this.lastToken = list.get(list.size() - 1);
        this.tokens.addAll(list);
    }

    private boolean needMoreTokens() {
        if (this.done) {
            return false;
        }
        if (this.tokens.isEmpty()) {
            return true;
        }
        stalePossibleSimpleKeys();
        return nextPossibleSimpleKey() == this.tokensTaken;
    }

    private void fetchMoreTokens() {
        if (this.reader.getDocumentIndex() > this.loaderOptions.getCodePointLimit()) {
            throw new YAMLException("The incoming YAML document exceeds the limit: " + this.loaderOptions.getCodePointLimit() + " code points.");
        }
        scanToNextToken();
        stalePossibleSimpleKeys();
        unwindIndent(this.reader.getColumn());
        int iPeek = this.reader.peek();
        switch (iPeek) {
            case 0:
                fetchStreamEnd();
                return;
            case 33:
                fetchTag();
                return;
            case 34:
                fetchDouble();
                return;
            case 37:
                if (checkDirective()) {
                    fetchDirective();
                    return;
                }
                break;
            case LegacyComponentSerializer.AMPERSAND_CHAR /* 38 */:
                fetchAnchor();
                return;
            case 39:
                fetchSingle();
                return;
            case Protocol.ASTERISK_BYTE /* 42 */:
                fetchAlias();
                return;
            case 44:
                fetchFlowEntry();
                return;
            case Protocol.MINUS_BYTE /* 45 */:
                if (checkDocumentStart()) {
                    fetchDocumentStart();
                    return;
                } else if (checkBlockEntry()) {
                    fetchBlockEntry();
                    return;
                }
            case 46:
                if (checkDocumentEnd()) {
                    fetchDocumentEnd();
                    return;
                }
                break;
            case 58:
                if (checkValue()) {
                    fetchValue();
                    return;
                }
                break;
            case TokenParser.TAG_END /* 62 */:
                if (this.flowLevel == 0) {
                    fetchFolded();
                    return;
                }
                break;
            case 63:
                if (checkKey()) {
                    fetchKey();
                    return;
                }
                break;
            case 91:
                fetchFlowSequenceStart();
                return;
            case 93:
                fetchFlowSequenceEnd();
                return;
            case 123:
                fetchFlowMappingStart();
                return;
            case 124:
                if (this.flowLevel == 0) {
                    fetchLiteral();
                    return;
                }
                break;
            case 125:
                fetchFlowMappingEnd();
                return;
        }
        if (checkPlain()) {
            fetchPlain();
            return;
        }
        String strEscapeChar = escapeChar(String.valueOf(Character.toChars(iPeek)));
        if (iPeek == 9) {
            strEscapeChar = strEscapeChar + "(TAB)";
        }
        throw new ScannerException("while scanning for the next token", null, String.format("found character '%s' that cannot start any token. (Do not use %s for indentation)", strEscapeChar, strEscapeChar), this.reader.getMark());
    }

    private String escapeChar(String str) {
        for (Character ch : ESCAPE_REPLACEMENTS.keySet()) {
            if (ESCAPE_REPLACEMENTS.get(ch).equals(str)) {
                return "\\" + ch;
            }
        }
        return str;
    }

    private int nextPossibleSimpleKey() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return -1;
        }
        return this.possibleSimpleKeys.values().iterator().next().getTokenNumber();
    }

    private void stalePossibleSimpleKeys() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return;
        }
        Iterator<SimpleKey> it = this.possibleSimpleKeys.values().iterator();
        while (it.hasNext()) {
            SimpleKey next = it.next();
            if (next.getLine() != this.reader.getLine() || this.reader.getIndex() - next.getIndex() > 1024) {
                if (next.isRequired()) {
                    throw new ScannerException("while scanning a simple key", next.getMark(), "could not find expected ':'", this.reader.getMark());
                }
                it.remove();
            }
        }
    }

    private void savePossibleSimpleKey() {
        boolean z = this.flowLevel == 0 && this.indent == this.reader.getColumn();
        if (!this.allowSimpleKey && z) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (this.allowSimpleKey) {
            removePossibleSimpleKey();
            this.possibleSimpleKeys.put(Integer.valueOf(this.flowLevel), new SimpleKey(this.tokensTaken + this.tokens.size(), z, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark()));
        }
    }

    private void removePossibleSimpleKey() {
        SimpleKey simpleKeyRemove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (simpleKeyRemove != null && simpleKeyRemove.isRequired()) {
            throw new ScannerException("while scanning a simple key", simpleKeyRemove.getMark(), "could not find expected ':'", this.reader.getMark());
        }
    }

    private void unwindIndent(int i) {
        if (this.flowLevel != 0) {
            return;
        }
        while (this.indent > i) {
            Mark mark = this.reader.getMark();
            this.indent = this.indents.pop().intValue();
            addToken(new BlockEndToken(mark, mark));
        }
    }

    private boolean addIndent(int i) {
        if (this.indent >= i) {
            return false;
        }
        this.indents.push(Integer.valueOf(this.indent));
        this.indent = i;
        return true;
    }

    private void fetchStreamStart() {
        Mark mark = this.reader.getMark();
        addToken(new StreamStartToken(mark, mark));
    }

    private void fetchStreamEnd() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.possibleSimpleKeys.clear();
        Mark mark = this.reader.getMark();
        addToken(new StreamEndToken(mark, mark));
        this.done = true;
    }

    private void fetchDirective() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        addAllTokens(scanDirective());
    }

    private void fetchDocumentStart() {
        fetchDocumentIndicator(true);
    }

    private void fetchDocumentEnd() {
        fetchDocumentIndicator(false);
    }

    private void fetchDocumentIndicator(boolean z) {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward(3);
        Mark mark2 = this.reader.getMark();
        addToken(z ? new DocumentStartToken(mark, mark2) : new DocumentEndToken(mark, mark2));
    }

    private void fetchFlowSequenceStart() {
        fetchFlowCollectionStart(false);
    }

    private void fetchFlowMappingStart() {
        fetchFlowCollectionStart(true);
    }

    private void fetchFlowCollectionStart(boolean z) {
        savePossibleSimpleKey();
        this.flowLevel++;
        this.allowSimpleKey = true;
        Mark mark = this.reader.getMark();
        this.reader.forward(1);
        Mark mark2 = this.reader.getMark();
        addToken(z ? new FlowMappingStartToken(mark, mark2) : new FlowSequenceStartToken(mark, mark2));
    }

    private void fetchFlowSequenceEnd() {
        fetchFlowCollectionEnd(false);
    }

    private void fetchFlowMappingEnd() {
        fetchFlowCollectionEnd(true);
    }

    private void fetchFlowCollectionEnd(boolean z) {
        removePossibleSimpleKey();
        this.flowLevel--;
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward();
        Mark mark2 = this.reader.getMark();
        addToken(z ? new FlowMappingEndToken(mark, mark2) : new FlowSequenceEndToken(mark, mark2));
    }

    private void fetchFlowEntry() {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark = this.reader.getMark();
        this.reader.forward();
        addToken(new FlowEntryToken(mark, this.reader.getMark()));
    }

    private void fetchBlockEntry() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "sequence entries are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockSequenceStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new BlockEntryToken(mark2, this.reader.getMark()));
    }

    private void fetchKey() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping keys are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockMappingStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = this.flowLevel == 0;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new KeyToken(mark2, this.reader.getMark()));
    }

    private void fetchValue() {
        SimpleKey simpleKeyRemove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (simpleKeyRemove != null) {
            addToken(simpleKeyRemove.getTokenNumber() - this.tokensTaken, new KeyToken(simpleKeyRemove.getMark(), simpleKeyRemove.getMark()));
            if (this.flowLevel == 0 && addIndent(simpleKeyRemove.getColumn())) {
                addToken(simpleKeyRemove.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(simpleKeyRemove.getMark(), simpleKeyRemove.getMark()));
            }
            this.allowSimpleKey = false;
        } else {
            if (this.flowLevel == 0 && !this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping values are not allowed here", this.reader.getMark());
            }
            if (this.flowLevel == 0 && addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockMappingStartToken(mark, mark));
            }
            this.allowSimpleKey = this.flowLevel == 0;
            removePossibleSimpleKey();
        }
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new ValueToken(mark2, this.reader.getMark()));
    }

    private void fetchAlias() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanAnchor(false));
    }

    private void fetchAnchor() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanAnchor(true));
    }

    private void fetchTag() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanTag());
    }

    private void fetchLiteral() {
        fetchBlockScalar('|');
    }

    private void fetchFolded() {
        fetchBlockScalar('>');
    }

    private void fetchBlockScalar(char c) {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        addAllTokens(scanBlockScalar(c));
    }

    private void fetchSingle() {
        fetchFlowScalar('\'');
    }

    private void fetchDouble() {
        fetchFlowScalar('\"');
    }

    private void fetchFlowScalar(char c) {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanFlowScalar(c));
    }

    private void fetchPlain() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanPlain());
    }

    private boolean checkDirective() {
        return this.reader.getColumn() == 0;
    }

    private boolean checkDocumentStart() {
        return this.reader.getColumn() == 0 && "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkDocumentEnd() {
        return this.reader.getColumn() == 0 && "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkBlockEntry() {
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkKey() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkValue() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkPlain() {
        int iPeek = this.reader.peek();
        return Constant.NULL_BL_T_LINEBR.hasNo(iPeek, "-?:,[]{}#&*!|>'\"%@`") || (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(1)) && (iPeek == 45 || (this.flowLevel == 0 && "?:".indexOf(iPeek) != -1)));
    }

    private void scanToNextToken() {
        CommentType commentType;
        if (this.reader.getIndex() == 0 && this.reader.peek() == 65279) {
            this.reader.forward();
        }
        boolean z = false;
        int column = -1;
        while (!z) {
            Mark mark = this.reader.getMark();
            int column2 = this.reader.getColumn();
            boolean z2 = false;
            int i = 0;
            while (this.reader.peek(i) == 32) {
                i++;
            }
            while (this.reader.peek(i) == 9 && this.flowLevel > 0) {
                i++;
            }
            if (i > 0) {
                this.reader.forward(i);
            }
            if (this.reader.peek() == 35) {
                z2 = true;
                if (column2 != 0 && (this.lastToken == null || this.lastToken.getTokenId() != Token.ID.BlockEntry)) {
                    commentType = CommentType.IN_LINE;
                    column = this.reader.getColumn();
                } else if (column == this.reader.getColumn()) {
                    commentType = CommentType.IN_LINE;
                } else {
                    column = -1;
                    commentType = CommentType.BLOCK;
                }
                CommentToken commentTokenScanComment = scanComment(commentType);
                if (this.parseComments) {
                    addToken(commentTokenScanComment);
                }
            }
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.isEmpty()) {
                z = true;
            } else {
                if (this.parseComments && !z2 && column2 == 0) {
                    addToken(new CommentToken(CommentType.BLANK_LINE, strScanLineBreak, mark, this.reader.getMark()));
                }
                if (this.flowLevel == 0) {
                    this.allowSimpleKey = true;
                }
            }
        }
    }

    private CommentToken scanComment(CommentType commentType) {
        Mark mark = this.reader.getMark();
        this.reader.forward();
        int i = 0;
        while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
            i++;
        }
        return new CommentToken(commentType, this.reader.prefixForward(i), mark, this.reader.getMark());
    }

    private List<Token> scanDirective() {
        Mark mark;
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        String strScanDirectiveName = scanDirectiveName(mark2);
        List<String> listScanTagDirectiveValue = null;
        if ("YAML".equals(strScanDirectiveName)) {
            listScanTagDirectiveValue = scanYamlDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else if ("TAG".equals(strScanDirectiveName)) {
            listScanTagDirectiveValue = scanTagDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else {
            mark = this.reader.getMark();
            int i = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
                i++;
            }
            if (i > 0) {
                this.reader.forward(i);
            }
        }
        return makeTokenList(new DirectiveToken(strScanDirectiveName, listScanTagDirectiveValue, mark2, mark), scanDirectiveIgnoredLine(mark2));
    }

    private String scanDirectiveName(Mark mark) {
        int i;
        int i2 = 0;
        int iPeek = this.reader.peek(0);
        while (true) {
            i = iPeek;
            if (!Constant.ALPHA.has(i)) {
                break;
            }
            i2++;
            iPeek = this.reader.peek(i2);
        }
        if (i2 == 0) {
            throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(i)) + "(" + i + ")", this.reader.getMark());
        }
        String strPrefixForward = this.reader.prefixForward(i2);
        int iPeek2 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek2)) {
            return strPrefixForward;
        }
        throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
    }

    private List<Integer> scanYamlDirectiveValue(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        Integer numScanYamlDirectiveNumber = scanYamlDirectiveNumber(mark);
        int iPeek = this.reader.peek();
        if (iPeek != 46) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or '.', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        this.reader.forward();
        Integer numScanYamlDirectiveNumber2 = scanYamlDirectiveNumber(mark);
        int iPeek2 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(iPeek2)) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or ' ', but found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(numScanYamlDirectiveNumber);
        arrayList.add(numScanYamlDirectiveNumber2);
        return arrayList;
    }

    private Integer scanYamlDirectiveNumber(Mark mark) {
        int iPeek = this.reader.peek();
        if (!Character.isDigit(iPeek)) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        int i = 0;
        while (Character.isDigit(this.reader.peek(i))) {
            i++;
        }
        String strPrefixForward = this.reader.prefixForward(i);
        if (i > 3) {
            throw new ScannerException("while scanning a YAML directive", mark, "found a number which cannot represent a valid version: " + strPrefixForward, this.reader.getMark());
        }
        return Integer.valueOf(Integer.parseInt(strPrefixForward));
    }

    private List<String> scanTagDirectiveValue(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        String strScanTagDirectiveHandle = scanTagDirectiveHandle(mark);
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        String strScanTagDirectivePrefix = scanTagDirectivePrefix(mark);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(strScanTagDirectiveHandle);
        arrayList.add(strScanTagDirectivePrefix);
        return arrayList;
    }

    private String scanTagDirectiveHandle(Mark mark) {
        String strScanTagHandle = scanTagHandle("directive", mark);
        int iPeek = this.reader.peek();
        if (iPeek == 32) {
            return strScanTagHandle;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private String scanTagDirectivePrefix(Mark mark) {
        String strScanTagUri = scanTagUri("directive", mark);
        int iPeek = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek)) {
            return strScanTagUri;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private CommentToken scanDirectiveIgnoredLine(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        CommentToken commentToken = null;
        if (this.reader.peek() == 35) {
            CommentToken commentTokenScanComment = scanComment(CommentType.IN_LINE);
            if (this.parseComments) {
                commentToken = commentTokenScanComment;
            }
        }
        int iPeek = this.reader.peek();
        if (!scanLineBreak().isEmpty() || iPeek == 0) {
            return commentToken;
        }
        throw new ScannerException("while scanning a directive", mark, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private Token scanAnchor(boolean z) {
        int i;
        Mark mark = this.reader.getMark();
        String str = this.reader.peek() == 42 ? "alias" : "anchor";
        this.reader.forward();
        int i2 = 0;
        int iPeek = this.reader.peek(0);
        while (true) {
            i = iPeek;
            if (!Constant.NULL_BL_T_LINEBR.hasNo(i, ":,[]{}/.*&")) {
                break;
            }
            i2++;
            iPeek = this.reader.peek(i2);
        }
        if (i2 == 0) {
            throw new ScannerException("while scanning an " + str, mark, "unexpected character found " + String.valueOf(Character.toChars(i)) + "(" + i + ")", this.reader.getMark());
        }
        String strPrefixForward = this.reader.prefixForward(i2);
        int iPeek2 = this.reader.peek();
        if (Constant.NULL_BL_T_LINEBR.hasNo(iPeek2, "?:,]}%@`")) {
            throw new ScannerException("while scanning an " + str, mark, "unexpected character found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
        }
        Mark mark2 = this.reader.getMark();
        return z ? new AnchorToken(strPrefixForward, mark, mark2) : new AliasToken(strPrefixForward, mark, mark2);
    }

    private Token scanTag() {
        String strScanTagUri;
        Mark mark = this.reader.getMark();
        int iPeek = this.reader.peek(1);
        String strScanTagHandle = null;
        if (iPeek == 60) {
            this.reader.forward(2);
            strScanTagUri = scanTagUri("tag", mark);
            int iPeek2 = this.reader.peek();
            if (iPeek2 != 62) {
                throw new ScannerException("while scanning a tag", mark, "expected '>', but found '" + String.valueOf(Character.toChars(iPeek2)) + "' (" + iPeek2 + ")", this.reader.getMark());
            }
            this.reader.forward();
        } else if (Constant.NULL_BL_T_LINEBR.has(iPeek)) {
            strScanTagUri = DecorationTag.REVERT;
            this.reader.forward();
        } else {
            int i = 1;
            boolean z = false;
            while (Constant.NULL_BL_LINEBR.hasNo(iPeek)) {
                if (iPeek == 33) {
                    z = true;
                    break;
                }
                i++;
                iPeek = this.reader.peek(i);
            }
            if (z) {
                strScanTagHandle = scanTagHandle("tag", mark);
            } else {
                strScanTagHandle = DecorationTag.REVERT;
                this.reader.forward();
            }
            strScanTagUri = scanTagUri("tag", mark);
        }
        int iPeek3 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek3)) {
            return new TagToken(new TagTuple(strScanTagHandle, strScanTagUri), mark, this.reader.getMark());
        }
        throw new ScannerException("while scanning a tag", mark, "expected ' ', but found '" + String.valueOf(Character.toChars(iPeek3)) + "' (" + iPeek3 + ")", this.reader.getMark());
    }

    private List<Token> scanBlockScalar(char c) {
        int iMax;
        String str;
        Mark mark;
        boolean z = c == '>';
        StringBuilder sb = new StringBuilder();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        Chomping chompingScanBlockScalarIndicators = scanBlockScalarIndicators(mark2);
        int increment = chompingScanBlockScalarIndicators.getIncrement();
        CommentToken commentTokenScanBlockScalarIgnoredLine = scanBlockScalarIgnoredLine(mark2);
        int i = this.indent + 1;
        if (i < 1) {
            i = 1;
        }
        if (increment == -1) {
            Object[] objArrScanBlockScalarIndentation = scanBlockScalarIndentation();
            str = (String) objArrScanBlockScalarIndentation[0];
            int iIntValue = ((Integer) objArrScanBlockScalarIndentation[1]).intValue();
            mark = (Mark) objArrScanBlockScalarIndentation[2];
            iMax = Math.max(i, iIntValue);
        } else {
            iMax = (i + increment) - 1;
            Object[] objArrScanBlockScalarBreaks = scanBlockScalarBreaks(iMax);
            str = (String) objArrScanBlockScalarBreaks[0];
            mark = (Mark) objArrScanBlockScalarBreaks[1];
        }
        String strScanLineBreak = "";
        while (this.reader.getColumn() == iMax && this.reader.peek() != 0) {
            sb.append(str);
            boolean z2 = " \t".indexOf(this.reader.peek()) == -1;
            int i2 = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i2))) {
                i2++;
            }
            sb.append(this.reader.prefixForward(i2));
            strScanLineBreak = scanLineBreak();
            Object[] objArrScanBlockScalarBreaks2 = scanBlockScalarBreaks(iMax);
            str = (String) objArrScanBlockScalarBreaks2[0];
            mark = (Mark) objArrScanBlockScalarBreaks2[1];
            if (this.reader.getColumn() != iMax || this.reader.peek() == 0) {
                break;
            }
            if (!z || !"\n".equals(strScanLineBreak) || !z2 || " \t".indexOf(this.reader.peek()) != -1) {
                sb.append(strScanLineBreak);
            } else if (str.isEmpty()) {
                sb.append(' ');
            }
        }
        if (chompingScanBlockScalarIndicators.chompTailIsNotFalse()) {
            sb.append(strScanLineBreak);
        }
        if (chompingScanBlockScalarIndicators.chompTailIsTrue()) {
            sb.append(str);
        }
        return makeTokenList(commentTokenScanBlockScalarIgnoredLine, new ScalarToken(sb.toString(), false, mark2, mark, DumperOptions.ScalarStyle.createStyle(Character.valueOf(c))));
    }

    private Chomping scanBlockScalarIndicators(Mark mark) {
        Boolean bool = null;
        int i = -1;
        int iPeek = this.reader.peek();
        if (iPeek == 45 || iPeek == 43) {
            bool = iPeek == 43 ? Boolean.TRUE : Boolean.FALSE;
            this.reader.forward();
            int iPeek2 = this.reader.peek();
            if (Character.isDigit(iPeek2)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(iPeek2)));
                if (i == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
            }
        } else if (Character.isDigit(iPeek)) {
            i = Integer.parseInt(String.valueOf(Character.toChars(iPeek)));
            if (i == 0) {
                throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
            }
            this.reader.forward();
            int iPeek3 = this.reader.peek();
            if (iPeek3 == 45 || iPeek3 == 43) {
                bool = iPeek3 == 43 ? Boolean.TRUE : Boolean.FALSE;
                this.reader.forward();
            }
        }
        int iPeek4 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(iPeek4)) {
            throw new ScannerException("while scanning a block scalar", mark, "expected chomping or indentation indicators, but found " + String.valueOf(Character.toChars(iPeek4)) + "(" + iPeek4 + ")", this.reader.getMark());
        }
        return new Chomping(bool, i);
    }

    private CommentToken scanBlockScalarIgnoredLine(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        CommentToken commentTokenScanComment = null;
        if (this.reader.peek() == 35) {
            commentTokenScanComment = scanComment(CommentType.IN_LINE);
        }
        int iPeek = this.reader.peek();
        if (!scanLineBreak().isEmpty() || iPeek == 0) {
            return commentTokenScanComment;
        }
        throw new ScannerException("while scanning a block scalar", mark, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private Object[] scanBlockScalarIndentation() {
        StringBuilder sb = new StringBuilder();
        int column = 0;
        Mark mark = this.reader.getMark();
        while (Constant.LINEBR.has(this.reader.peek(), " \r")) {
            if (this.reader.peek() != 32) {
                sb.append(scanLineBreak());
                mark = this.reader.getMark();
            } else {
                this.reader.forward();
                if (this.reader.getColumn() > column) {
                    column = this.reader.getColumn();
                }
            }
        }
        return new Object[]{sb.toString(), Integer.valueOf(column), mark};
    }

    private Object[] scanBlockScalarBreaks(int i) {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        for (int column = this.reader.getColumn(); column < i && this.reader.peek() == 32; column++) {
            this.reader.forward();
        }
        while (true) {
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.isEmpty()) {
                return new Object[]{sb.toString(), mark};
            }
            sb.append(strScanLineBreak);
            mark = this.reader.getMark();
            for (int column2 = this.reader.getColumn(); column2 < i && this.reader.peek() == 32; column2++) {
                this.reader.forward();
            }
        }
    }

    private Token scanFlowScalar(char c) {
        boolean z = c == '\"';
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int iPeek = this.reader.peek();
        this.reader.forward();
        scanFlowScalarNonSpaces(z, mark, sb);
        while (this.reader.peek() != iPeek) {
            scanFlowScalarSpaces(mark, sb);
            scanFlowScalarNonSpaces(z, mark, sb);
        }
        this.reader.forward();
        return new ScalarToken(sb.toString(), false, mark, this.reader.getMark(), DumperOptions.ScalarStyle.createStyle(Character.valueOf(c)));
    }

    private void scanFlowScalarNonSpaces(boolean z, Mark mark, StringBuilder sb) {
        while (true) {
            int i = 0;
            while (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(i), "'\"\\")) {
                i++;
            }
            if (i != 0) {
                sb.append(this.reader.prefixForward(i));
            }
            int iPeek = this.reader.peek();
            if (!z && iPeek == 39 && this.reader.peek(1) == 39) {
                sb.append('\'');
                this.reader.forward(2);
            } else if ((z && iPeek == 39) || (!z && "\"\\".indexOf(iPeek) != -1)) {
                sb.appendCodePoint(iPeek);
                this.reader.forward();
            } else {
                if (!z || iPeek != 92) {
                    return;
                }
                this.reader.forward();
                int iPeek2 = this.reader.peek();
                if (!Character.isSupplementaryCodePoint(iPeek2) && ESCAPE_REPLACEMENTS.containsKey(Character.valueOf((char) iPeek2))) {
                    sb.append(ESCAPE_REPLACEMENTS.get(Character.valueOf((char) iPeek2)));
                    this.reader.forward();
                } else if (!Character.isSupplementaryCodePoint(iPeek2) && ESCAPE_CODES.containsKey(Character.valueOf((char) iPeek2))) {
                    int iIntValue = ESCAPE_CODES.get(Character.valueOf((char) iPeek2)).intValue();
                    this.reader.forward();
                    String strPrefix = this.reader.prefix(iIntValue);
                    if (NOT_HEXA.matcher(strPrefix).find()) {
                        throw new ScannerException("while scanning a double-quoted scalar", mark, "expected escape sequence of " + iIntValue + " hexadecimal numbers, but found: " + strPrefix, this.reader.getMark());
                    }
                    try {
                        sb.appendCodePoint(Integer.parseInt(strPrefix, 16));
                        this.reader.forward(iIntValue);
                    } catch (IllegalArgumentException e) {
                        throw new ScannerException("while scanning a double-quoted scalar", mark, "found unknown escape character " + strPrefix, this.reader.getMark());
                    }
                } else {
                    if (scanLineBreak().isEmpty()) {
                        throw new ScannerException("while scanning a double-quoted scalar", mark, "found unknown escape character " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
                    }
                    sb.append(scanFlowScalarBreaks(mark));
                }
            }
        }
    }

    private void scanFlowScalarSpaces(Mark mark, StringBuilder sb) {
        int i = 0;
        while (" \t".indexOf(this.reader.peek(i)) != -1) {
            i++;
        }
        String strPrefixForward = this.reader.prefixForward(i);
        if (this.reader.peek() == 0) {
            throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected end of stream", this.reader.getMark());
        }
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.isEmpty()) {
            sb.append(strPrefixForward);
            return;
        }
        String strScanFlowScalarBreaks = scanFlowScalarBreaks(mark);
        if (!"\n".equals(strScanLineBreak)) {
            sb.append(strScanLineBreak);
        } else if (strScanFlowScalarBreaks.isEmpty()) {
            sb.append(' ');
        }
        sb.append(strScanFlowScalarBreaks);
    }

    private String scanFlowScalarBreaks(Mark mark) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String strPrefix = this.reader.prefix(3);
            if (("---".equals(strPrefix) || "...".equals(strPrefix)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", this.reader.getMark());
            }
            while (" \t".indexOf(this.reader.peek()) != -1) {
                this.reader.forward();
            }
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.isEmpty()) {
                return sb.toString();
            }
            sb.append(strScanLineBreak);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0072  */
    private Token scanPlain() {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        Mark mark2 = mark;
        int i = this.indent + 1;
        String strScanPlainSpaces = "";
        while (true) {
            int i2 = 0;
            if (this.reader.peek() == 35) {
                break;
            }
            while (true) {
                int iPeek = this.reader.peek(i2);
                if (Constant.NULL_BL_T_LINEBR.has(iPeek)) {
                    break;
                }
                if (iPeek == 58) {
                    if (!Constant.NULL_BL_T_LINEBR.has(this.reader.peek(i2 + 1), this.flowLevel != 0 ? ",[]{}" : "")) {
                        if (this.flowLevel == 0 && ",?[]{}".indexOf(iPeek) != -1) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                } else {
                    if (this.flowLevel == 0) {
                    }
                    i2++;
                }
            }
            if (i2 == 0) {
                break;
            }
            this.allowSimpleKey = false;
            sb.append(strScanPlainSpaces);
            sb.append(this.reader.prefixForward(i2));
            mark2 = this.reader.getMark();
            strScanPlainSpaces = scanPlainSpaces();
            if (strScanPlainSpaces.isEmpty() || this.reader.peek() == 35 || (this.flowLevel == 0 && this.reader.getColumn() < i)) {
                break;
            }
        }
        return new ScalarToken(sb.toString(), mark, mark2, true);
    }

    private boolean atEndOfPlain() {
        int i = 0;
        int column = this.reader.getColumn();
        while (true) {
            int iPeek = this.reader.peek(i);
            if (iPeek == 0 || !Constant.NULL_BL_T_LINEBR.has(iPeek)) {
                break;
            }
            i++;
            column = (Constant.LINEBR.has(iPeek) || (iPeek == 13 && this.reader.peek(i + 1) == 10) || iPeek == 65279) ? 0 : column + 1;
        }
        if (this.reader.peek(i) == 35 || this.reader.peek(i + 1) == 0) {
            return true;
        }
        if (this.flowLevel == 0 && column < this.indent) {
            return true;
        }
        if (this.flowLevel != 0) {
            return false;
        }
        int i2 = 1;
        while (true) {
            int iPeek2 = this.reader.peek(i + i2);
            if (iPeek2 == 0 || Constant.NULL_BL_T_LINEBR.has(iPeek2)) {
                return false;
            }
            if (iPeek2 == 58 && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(i + i2 + 1))) {
                return true;
            }
            i2++;
        }
    }

    private String scanPlainSpaces() {
        int i = 0;
        while (true) {
            if (this.reader.peek(i) != 32 && this.reader.peek(i) != 9) {
                break;
            }
            i++;
        }
        String strPrefixForward = this.reader.prefixForward(i);
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.isEmpty()) {
            return strPrefixForward;
        }
        this.allowSimpleKey = true;
        String strPrefix = this.reader.prefix(3);
        if ("---".equals(strPrefix)) {
            return "";
        }
        if ("...".equals(strPrefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
            return "";
        }
        if (this.parseComments && atEndOfPlain()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (this.reader.peek() == 32) {
                this.reader.forward();
            } else {
                String strScanLineBreak2 = scanLineBreak();
                if (strScanLineBreak2.isEmpty()) {
                    if ("\n".equals(strScanLineBreak)) {
                        return sb.length() == 0 ? " " : sb.toString();
                    }
                    return strScanLineBreak + ((Object) sb);
                }
                sb.append(strScanLineBreak2);
                String strPrefix2 = this.reader.prefix(3);
                if ("---".equals(strPrefix2)) {
                    return "";
                }
                if ("...".equals(strPrefix2) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                    return "";
                }
            }
        }
    }

    private String scanTagHandle(String str, Mark mark) {
        int iPeek = this.reader.peek();
        if (iPeek != 33) {
            throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        int i = 1;
        int iPeek2 = this.reader.peek(1);
        if (iPeek2 != 32) {
            while (Constant.ALPHA.has(iPeek2)) {
                i++;
                iPeek2 = this.reader.peek(i);
            }
            if (iPeek2 != 33) {
                this.reader.forward(i);
                throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
            }
            i++;
        }
        return this.reader.prefixForward(i);
    }

    private String scanTagUri(String str, Mark mark) {
        int i;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int iPeek = this.reader.peek(0);
        while (true) {
            i = iPeek;
            if (!Constant.URI_CHARS.has(i)) {
                break;
            }
            if (i == 37) {
                sb.append(this.reader.prefixForward(i2));
                i2 = 0;
                sb.append(scanUriEscapes(str, mark));
            } else {
                i2++;
            }
            iPeek = this.reader.peek(i2);
        }
        if (i2 != 0) {
            sb.append(this.reader.prefixForward(i2));
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        throw new ScannerException("while scanning a " + str, mark, "expected URI, but found " + String.valueOf(Character.toChars(i)) + "(" + i + ")", this.reader.getMark());
    }

    private String scanUriEscapes(String str, Mark mark) {
        int i = 1;
        while (this.reader.peek(i * 3) == 37) {
            i++;
        }
        Mark mark2 = this.reader.getMark();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        while (this.reader.peek() == 37) {
            this.reader.forward();
            try {
                byteBufferAllocate.put((byte) Integer.parseInt(this.reader.prefix(2), 16));
                this.reader.forward(2);
            } catch (NumberFormatException e) {
                int iPeek = this.reader.peek();
                String strValueOf = String.valueOf(Character.toChars(iPeek));
                int iPeek2 = this.reader.peek(1);
                throw new ScannerException("while scanning a " + str, mark, "expected URI escape sequence of 2 hexadecimal numbers, but found " + strValueOf + "(" + iPeek + ") and " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
            }
        }
        byteBufferAllocate.flip();
        try {
            return UriEncoder.decode(byteBufferAllocate);
        } catch (CharacterCodingException e2) {
            throw new ScannerException("while scanning a " + str, mark, "expected URI in UTF-8: " + e2.getMessage(), mark2);
        }
    }

    private String scanLineBreak() {
        int iPeek = this.reader.peek();
        if (iPeek != 13 && iPeek != 10 && iPeek != 133) {
            if (iPeek != 8232 && iPeek != 8233) {
                return "";
            }
            this.reader.forward();
            return String.valueOf(Character.toChars(iPeek));
        }
        if (iPeek == 13 && 10 == this.reader.peek(1)) {
            this.reader.forward(2);
            return "\n";
        }
        this.reader.forward();
        return "\n";
    }

    private List<Token> makeTokenList(Token... tokenArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < tokenArr.length; i++) {
            if (tokenArr[i] != null && (this.parseComments || !(tokenArr[i] instanceof CommentToken))) {
                arrayList.add(tokenArr[i]);
            }
        }
        return arrayList;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.scanner.Scanner
    public void resetDocumentIndex() {
        this.reader.resetDocumentIndex();
    }

    static {
        ESCAPE_REPLACEMENTS.put('0', "\u0000");
        ESCAPE_REPLACEMENTS.put('a', "\u0007");
        ESCAPE_REPLACEMENTS.put('b', "\b");
        ESCAPE_REPLACEMENTS.put('t', "\t");
        ESCAPE_REPLACEMENTS.put('n', "\n");
        ESCAPE_REPLACEMENTS.put('v', "\u000b");
        ESCAPE_REPLACEMENTS.put('f', "\f");
        ESCAPE_REPLACEMENTS.put('r', "\r");
        ESCAPE_REPLACEMENTS.put('e', "\u001b");
        ESCAPE_REPLACEMENTS.put(' ', " ");
        ESCAPE_REPLACEMENTS.put('\"', "\"");
        ESCAPE_REPLACEMENTS.put('\\', "\\");
        ESCAPE_REPLACEMENTS.put('N', "\u0085");
        ESCAPE_REPLACEMENTS.put('_', " ");
        ESCAPE_REPLACEMENTS.put('L', "\u2028");
        ESCAPE_REPLACEMENTS.put('P', "\u2029");
        ESCAPE_CODES.put('x', 2);
        ESCAPE_CODES.put('u', 4);
        ESCAPE_CODES.put('U', 8);
    }
}

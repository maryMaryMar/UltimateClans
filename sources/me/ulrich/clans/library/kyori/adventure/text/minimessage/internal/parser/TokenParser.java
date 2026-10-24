package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.MatchedTokenConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.StringResolvingMatchedTokenConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.TokenListProducingMatchedTokenConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ElementNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.RootNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TagNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TagPart;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TextNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.ParserDirective;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/TokenParser.class */
@ApiStatus.Internal
public final class TokenParser {
    private static final int MAX_DEPTH = 16;
    public static final char TAG_START = '<';
    public static final char TAG_END = '>';
    public static final char CLOSE_TAG = '/';
    public static final char SEPARATOR = ':';
    public static final char ESCAPE = '\\';

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/TokenParser$FirstPassState.class */
    enum FirstPassState {
        NORMAL,
        TAG,
        STRING
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/TokenParser$SecondPassState.class */
    enum SecondPassState {
        NORMAL,
        STRING
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/TokenParser$TagProvider.class */
    @ApiStatus.Internal
    public interface TagProvider {
        @Nullable
        Tag resolve(@NotNull String str, @NotNull List<? extends Tag.Argument> list, @Nullable Token token);

        @Nullable
        default Tag resolve(@NotNull String str) {
            return resolve(str, Collections.emptyList(), null);
        }

        @Nullable
        default Tag resolve(@NotNull TagNode tagNode) {
            return resolve(sanitizePlaceholderName(tagNode.name()), tagNode.parts().subList(1, tagNode.parts().size()), tagNode.token());
        }

        @NotNull
        static String sanitizePlaceholderName(@NotNull String str) {
            return str.toLowerCase(Locale.ROOT);
        }
    }

    private TokenParser() {
    }

    public static RootNode parse(@NotNull TagProvider tagProvider, @NotNull Predicate<String> predicate, @NotNull String str, @NotNull String str2, boolean z) {
        return buildTree(tagProvider, predicate, tokenize(str, false), str, str2, z);
    }

    public static String resolvePreProcessTags(String str, TagProvider tagProvider) {
        String str2;
        int i = 0;
        String strResult = str;
        do {
            str2 = strResult;
            StringResolvingMatchedTokenConsumer stringResolvingMatchedTokenConsumer = new StringResolvingMatchedTokenConsumer(str2, tagProvider);
            parseString(str2, false, stringResolvingMatchedTokenConsumer);
            strResult = stringResolvingMatchedTokenConsumer.result();
            i++;
            if (i >= 16) {
                break;
            }
        } while (!str2.equals(strResult));
        return str2;
    }

    public static List<Token> tokenize(String str, boolean z) {
        TokenListProducingMatchedTokenConsumer tokenListProducingMatchedTokenConsumer = new TokenListProducingMatchedTokenConsumer(str);
        parseString(str, z, tokenListProducingMatchedTokenConsumer);
        List<Token> listResult = tokenListProducingMatchedTokenConsumer.result();
        parseSecondPass(str, listResult);
        return listResult;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x013b A[PHI: r18 r19
      0x013b: PHI (r18v3 me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser$FirstPassState) = 
      (r18v1 me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser$FirstPassState)
      (r18v1 me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser$FirstPassState)
      (r18v11 me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser$FirstPassState)
     binds: [B:33:0x00b3, B:35:0x00be, B:56:0x012c] A[DONT_GENERATE, DONT_INLINE]
      0x013b: PHI (r19v4 boolean) = (r19v1 boolean), (r19v1 boolean), (r19v5 boolean) binds: [B:33:0x00b3, B:35:0x00be, B:56:0x012c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x015c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0163  */
    /* JADX WARN: Code duplicated, block: B:65:0x016e  */
    /* JADX WARN: Code duplicated, block: B:67:0x019c  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:78:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x0215  */
    /* JADX WARN: Code duplicated, block: B:85:0x021c  */
    /* JADX WARN: Code duplicated, block: B:87:0x022f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0236  */
    /* JADX WARN: Code duplicated, block: B:91:0x023d  */
    public static void parseString(String str, boolean z, MatchedTokenConsumer<?> matchedTokenConsumer) {
        TokenType tokenType;
        int lowerCase;
        FirstPassState firstPassState = FirstPassState.NORMAL;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        char c = 0;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iCodePointAt = str.codePointAt(i3);
            if (!z && iCodePointAt == 167 && i3 + 1 < length && (((lowerCase = Character.toLowerCase(str.codePointAt(i3 + 1))) >= 48 && lowerCase <= 57) || ((lowerCase >= 97 && lowerCase <= 102) || lowerCase == 114 || (lowerCase >= 107 && lowerCase <= 111)))) {
                throw new ParsingExceptionImpl("Legacy formatting codes have been detected in a MiniMessage string - this is unsupported behaviour. Please refer to the Adventure documentation (https://docs.papermc.io/adventure/) for more information.", str, null, true, new Token(i3, i3 + 2, TokenType.TEXT));
            }
            if (!Character.isBmpCodePoint(iCodePointAt)) {
                i3++;
            }
            if (z2) {
                z2 = false;
            } else if (iCodePointAt != 92 || i3 + 1 >= str.length()) {
                switch (firstPassState) {
                    case 1:
                        if (iCodePointAt == 60) {
                            i2 = i3;
                            firstPassState = FirstPassState.TAG;
                        }
                        break;
                    case 2:
                        if (iCodePointAt == c) {
                            firstPassState = FirstPassState.TAG;
                        }
                        break;
                    case 3:
                        switch (iCodePointAt) {
                            case 34:
                            case 39:
                                c = (char) iCodePointAt;
                                if (str.indexOf(iCodePointAt, i3 + 1) != -1) {
                                    firstPassState = FirstPassState.STRING;
                                }
                                break;
                            case 60:
                                i2 = i3;
                                break;
                            case TAG_END /* 62 */:
                                if (i3 == i2 + 1) {
                                    if (i != i2) {
                                        matchedTokenConsumer.accept(i, i2, TokenType.TEXT);
                                    }
                                    i = i3 + 1;
                                    tokenType = TokenType.OPEN_TAG;
                                    if (!boundsCheck(str, i2, 1) && str.charAt(i2 + 1) == '/') {
                                        tokenType = TokenType.CLOSE_TAG;
                                    } else if (boundsCheck(str, i2, 2) && str.charAt(i3 - 1) == '/') {
                                        tokenType = TokenType.OPEN_CLOSE_TAG;
                                    }
                                    matchedTokenConsumer.accept(i2, i, tokenType);
                                    firstPassState = FirstPassState.NORMAL;
                                } else {
                                    firstPassState = FirstPassState.NORMAL;
                                }
                                break;
                        }
                        break;
                }
                if (i3 != length - 1 && firstPassState == FirstPassState.TAG) {
                    i3 = i2;
                    firstPassState = FirstPassState.NORMAL;
                }
            } else {
                int iCodePointAt2 = str.codePointAt(i3 + 1);
                switch (firstPassState) {
                    case NORMAL:
                        z2 = iCodePointAt2 == 60 || iCodePointAt2 == 92;
                        break;
                    case STRING:
                        z2 = c == iCodePointAt2 || iCodePointAt2 == 92;
                        break;
                    case TAG:
                        if (iCodePointAt2 == 60) {
                            z2 = true;
                            firstPassState = FirstPassState.NORMAL;
                        }
                        break;
                }
                if (!z2) {
                    switch (firstPassState) {
                        case NORMAL:
                            if (iCodePointAt == 60) {
                                i2 = i3;
                                firstPassState = FirstPassState.TAG;
                            }
                            break;
                        case STRING:
                            if (iCodePointAt == c) {
                                firstPassState = FirstPassState.TAG;
                            }
                            break;
                        case TAG:
                            switch (iCodePointAt) {
                                case 34:
                                case 39:
                                    c = (char) iCodePointAt;
                                    if (str.indexOf(iCodePointAt, i3 + 1) != -1) {
                                        firstPassState = FirstPassState.STRING;
                                    }
                                    break;
                                case 60:
                                    i2 = i3;
                                    break;
                                case TAG_END /* 62 */:
                                    if (i3 == i2 + 1) {
                                        if (i != i2) {
                                            matchedTokenConsumer.accept(i, i2, TokenType.TEXT);
                                        }
                                        i = i3 + 1;
                                        tokenType = TokenType.OPEN_TAG;
                                        if (!boundsCheck(str, i2, 1)) {
                                            if (boundsCheck(str, i2, 2)) {
                                                tokenType = TokenType.OPEN_CLOSE_TAG;
                                            }
                                        } else if (boundsCheck(str, i2, 2)) {
                                            tokenType = TokenType.OPEN_CLOSE_TAG;
                                        }
                                        matchedTokenConsumer.accept(i2, i, tokenType);
                                        firstPassState = FirstPassState.NORMAL;
                                    } else {
                                        firstPassState = FirstPassState.NORMAL;
                                    }
                                    break;
                            }
                            break;
                    }
                    if (i3 != length - 1) {
                    }
                }
            }
            i3++;
        }
        int iLastEndIndex = matchedTokenConsumer.lastEndIndex();
        if (iLastEndIndex == -1) {
            matchedTokenConsumer.accept(0, str.length(), TokenType.TEXT);
        } else if (iLastEndIndex != str.length()) {
            matchedTokenConsumer.accept(iLastEndIndex, str.length(), TokenType.TEXT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01cf A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x011e A[PHI: r15
      0x011e: PHI (r15v4 boolean) = (r15v1 boolean), (r15v1 boolean), (r15v5 boolean) binds: [B:29:0x00a3, B:31:0x00ae, B:49:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x0140  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    /* JADX WARN: Code duplicated, block: B:64:0x016e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0175  */
    /* JADX WARN: Code duplicated, block: B:67:0x018d  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ca  */
    private static void parseSecondPass(String str, List<Token> list) {
        for (Token token : list) {
            TokenType tokenTypeType = token.type();
            if (tokenTypeType == TokenType.OPEN_TAG || tokenTypeType == TokenType.OPEN_CLOSE_TAG || tokenTypeType == TokenType.CLOSE_TAG) {
                int iStartIndex = tokenTypeType == TokenType.CLOSE_TAG ? token.startIndex() + 2 : token.startIndex() + 1;
                int iEndIndex = tokenTypeType == TokenType.OPEN_CLOSE_TAG ? token.endIndex() - 2 : token.endIndex() - 1;
                SecondPassState secondPassState = SecondPassState.NORMAL;
                boolean z = false;
                char c = 0;
                int i = iStartIndex;
                int i2 = iStartIndex;
                while (i2 < iEndIndex) {
                    int iCodePointAt = str.codePointAt(i2);
                    if (!Character.isBmpCodePoint(i2)) {
                        i2++;
                    }
                    if (z) {
                        z = false;
                    } else if (iCodePointAt != 92 || i2 + 1 >= str.length()) {
                        switch (secondPassState) {
                            case 1:
                                if (iCodePointAt == 58) {
                                    if (boundsCheck(str, i2, 2) || str.charAt(i2 + 1) != '/' || str.charAt(i2 + 2) != '/') {
                                        if (i == i2) {
                                            insert(token, new Token(i2, i2, TokenType.TAG_VALUE));
                                            i++;
                                        } else {
                                            insert(token, new Token(i, i2, TokenType.TAG_VALUE));
                                            i = i2 + 1;
                                        }
                                    }
                                } else if (iCodePointAt != 39 || iCodePointAt == 34) {
                                    secondPassState = SecondPassState.STRING;
                                    c = (char) iCodePointAt;
                                }
                                break;
                            case 2:
                                if (iCodePointAt == c) {
                                    secondPassState = SecondPassState.NORMAL;
                                }
                                break;
                        }
                    } else {
                        int iCodePointAt2 = str.codePointAt(i2 + 1);
                        switch (secondPassState) {
                            case NORMAL:
                                z = iCodePointAt2 == 60 || iCodePointAt2 == 92;
                                break;
                            case STRING:
                                z = c == iCodePointAt2 || iCodePointAt2 == 92;
                                break;
                        }
                        if (!z) {
                            switch (secondPassState) {
                                case NORMAL:
                                    if (iCodePointAt == 58) {
                                        if (boundsCheck(str, i2, 2)) {
                                            if (i == i2) {
                                                insert(token, new Token(i2, i2, TokenType.TAG_VALUE));
                                                i++;
                                            } else {
                                                insert(token, new Token(i, i2, TokenType.TAG_VALUE));
                                                i = i2 + 1;
                                            }
                                        } else if (i == i2) {
                                            insert(token, new Token(i2, i2, TokenType.TAG_VALUE));
                                            i++;
                                        } else {
                                            insert(token, new Token(i, i2, TokenType.TAG_VALUE));
                                            i = i2 + 1;
                                        }
                                    } else if (iCodePointAt != 39) {
                                        secondPassState = SecondPassState.STRING;
                                        c = (char) iCodePointAt;
                                    } else {
                                        secondPassState = SecondPassState.STRING;
                                        c = (char) iCodePointAt;
                                    }
                                    break;
                                case STRING:
                                    if (iCodePointAt == c) {
                                        secondPassState = SecondPassState.NORMAL;
                                    }
                                    break;
                            }
                        }
                    }
                    i2++;
                }
                if (token.childTokens() == null || token.childTokens().isEmpty()) {
                    insert(token, new Token(iStartIndex, iEndIndex, TokenType.TAG_VALUE));
                } else {
                    int iEndIndex2 = token.childTokens().get(token.childTokens().size() - 1).endIndex();
                    if (iEndIndex2 != iEndIndex) {
                        insert(token, new Token(iEndIndex2 + 1, iEndIndex, TokenType.TAG_VALUE));
                    }
                }
            }
        }
    }

    private static RootNode buildTree(@NotNull TagProvider tagProvider, @NotNull Predicate<String> predicate, @NotNull List<Token> list, @NotNull String str, @NotNull String str2, boolean z) {
        ElementNode elementNode;
        RootNode rootNode = new RootNode(str, str2);
        ElementNode elementNode2 = rootNode;
        for (Token token : list) {
            TokenType tokenTypeType = token.type();
            switch (tokenTypeType) {
                case TEXT:
                    elementNode2.addChild(new TextNode(elementNode2, token, str));
                    break;
                case OPEN_TAG:
                case OPEN_CLOSE_TAG:
                    Token token2 = token.childTokens().get(0);
                    if (TagInternals.sanitizeAndCheckValidTagName(str.substring(token2.startIndex(), token2.endIndex()))) {
                        TagNode tagNode = new TagNode(elementNode2, token, str, tagProvider);
                        if (predicate.test(tagNode.name())) {
                            Tag tagResolve = tagProvider.resolve(tagNode);
                            if (tagResolve == null) {
                                elementNode2.addChild(new TextNode(elementNode2, token, str));
                            } else if (tagResolve != ParserDirective.RESET) {
                                tagNode.tag(tagResolve);
                                elementNode2.addChild(tagNode);
                                if (tokenTypeType != TokenType.OPEN_CLOSE_TAG && (!(tagResolve instanceof Inserting) || ((Inserting) tagResolve).allowsChildren())) {
                                    elementNode2 = tagNode;
                                }
                            } else {
                                if (z) {
                                    throw new ParsingExceptionImpl("<reset> tags are not allowed when strict mode is enabled", str, token);
                                }
                                elementNode2 = rootNode;
                            }
                        } else {
                            elementNode2.addChild(new TextNode(elementNode2, token, str));
                        }
                    } else {
                        elementNode2.addChild(new TextNode(elementNode2, token, str));
                    }
                    break;
                case CLOSE_TAG:
                    List<Token> listChildTokens = token.childTokens();
                    if (listChildTokens.isEmpty()) {
                        throw new IllegalStateException("CLOSE_TAG token somehow has no children - the parser should not allow this. Original text: " + str);
                    }
                    ArrayList arrayList = new ArrayList(listChildTokens.size());
                    for (Token token3 : listChildTokens) {
                        arrayList.add(TagPart.unquoteAndEscape(str, token3.startIndex(), token3.endIndex()));
                    }
                    String str3 = (String) arrayList.get(0);
                    if (!predicate.test(str3)) {
                        elementNode2.addChild(new TextNode(elementNode2, token, str));
                    } else if (tagProvider.resolve(str3) == ParserDirective.RESET) {
                        continue;
                    } else {
                        ElementNode elementNodeParent = elementNode2;
                        while (true) {
                            elementNode = elementNodeParent;
                            if (elementNode instanceof TagNode) {
                                if (!tagCloses(arrayList, ((TagNode) elementNode).parts())) {
                                    elementNodeParent = elementNode.parent();
                                } else {
                                    if (elementNode != elementNode2 && z) {
                                        throw new ParsingExceptionImpl("Unclosed tag encountered; " + ((TagNode) elementNode2).name() + " is not closed, because " + ((String) arrayList.get(0)) + " was closed first.", str, elementNode.token(), elementNode2.token(), token);
                                    }
                                    ElementNode elementNodeParent2 = elementNode.parent();
                                    if (elementNodeParent2 == null) {
                                        throw new IllegalStateException("Root node matched with close tag value, this should not be possible. Original text: " + str);
                                    }
                                    elementNode2 = elementNodeParent2;
                                }
                            }
                        }
                        if (elementNode == null || (elementNode instanceof RootNode)) {
                            elementNode2.addChild(new TextNode(elementNode2, token, str));
                        }
                    }
                    break;
                    break;
            }
        }
        if (!z || rootNode == elementNode2) {
            return rootNode;
        }
        ArrayList arrayList2 = new ArrayList();
        ElementNode elementNodeParent3 = elementNode2;
        while (true) {
            ElementNode elementNode3 = elementNodeParent3;
            if (elementNode3 != null && (elementNode3 instanceof TagNode)) {
                arrayList2.add((TagNode) elementNode3);
                elementNodeParent3 = elementNode3.parent();
            }
        }
        Token[] tokenArr = new Token[arrayList2.size()];
        StringBuilder sb = new StringBuilder("All tags must be explicitly closed while in strict mode. End of string found with open tags: ");
        int i = 0;
        ListIterator listIterator = arrayList2.listIterator(arrayList2.size());
        while (listIterator.hasPrevious()) {
            TagNode tagNode2 = (TagNode) listIterator.previous();
            int i2 = i;
            i++;
            tokenArr[i2] = tagNode2.token();
            sb.append(tagNode2.name());
            if (listIterator.hasPrevious()) {
                sb.append(", ");
            }
        }
        throw new ParsingExceptionImpl(sb.toString(), str, tokenArr);
    }

    private static boolean tagCloses(List<String> list, List<TagPart> list2) {
        if (list.size() > list2.size() || !list.get(0).equalsIgnoreCase(list2.get(0).value())) {
            return false;
        }
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i).value())) {
                return false;
            }
        }
        return true;
    }

    private static boolean boundsCheck(String str, int i, int i2) {
        return i + i2 < str.length();
    }

    private static void insert(Token token, Token token2) {
        if (token.childTokens() == null) {
            token.childTokens(Collections.singletonList(token2));
            return;
        }
        if (token.childTokens().size() != 1) {
            token.childTokens().add(token2);
            return;
        }
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(token.childTokens().get(0));
        arrayList.add(token2);
        token.childTokens(arrayList);
    }

    public static String unescape(String str, int i, int i2, IntPredicate intPredicate) {
        int i3;
        int i4 = i;
        int iIndexOf = str.indexOf(92, i4);
        if (iIndexOf == -1 || iIndexOf >= i2) {
            return str.substring(i4, i2);
        }
        StringBuilder sb = new StringBuilder(i2 - i);
        while (iIndexOf != -1 && iIndexOf + 1 < i2) {
            if (intPredicate.test(str.codePointAt(iIndexOf + 1))) {
                sb.append((CharSequence) str, i4, iIndexOf);
                int i5 = iIndexOf + 1;
                if (i5 >= i2) {
                    i4 = i2;
                    break;
                }
                int iCodePointAt = str.codePointAt(i5);
                sb.appendCodePoint(iCodePointAt);
                i3 = Character.isBmpCodePoint(iCodePointAt) ? i5 + 1 : i5 + 2;
                if (i3 >= i2) {
                    i4 = i2;
                    break;
                }
            } else {
                i3 = iIndexOf + 1;
                sb.append((CharSequence) str, i4, i3);
            }
            i4 = i3;
            iIndexOf = str.indexOf(92, i4);
        }
        sb.append((CharSequence) str, i4, i2);
        return sb.toString();
    }
}

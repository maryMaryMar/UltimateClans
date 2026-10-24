package org.json;

import java.io.Reader;
import java.util.HashMap;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/XMLTokener.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/XMLTokener.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/XMLTokener.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/XMLTokener.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/XMLTokener.class */
public class XMLTokener extends JSONTokener {
    public static final HashMap<String, Character> entity = new HashMap<>(8);
    private XMLParserConfiguration configuration;

    public XMLTokener(Reader reader) {
        super(reader);
        this.configuration = XMLParserConfiguration.ORIGINAL;
    }

    public XMLTokener(String str) {
        super(str);
        this.configuration = XMLParserConfiguration.ORIGINAL;
    }

    public XMLTokener(Reader reader, XMLParserConfiguration xMLParserConfiguration) {
        super(reader);
        this.configuration = XMLParserConfiguration.ORIGINAL;
        this.configuration = xMLParserConfiguration;
    }

    public String nextCDATA() {
        StringBuilder sb = new StringBuilder();
        while (more()) {
            sb.append(next());
            int length = sb.length() - 3;
            if (length >= 0 && sb.charAt(length) == ']' && sb.charAt(length + 1) == ']' && sb.charAt(length + 2) == '>') {
                sb.setLength(length);
                return sb.toString();
            }
        }
        throw syntaxError("Unclosed CDATA");
    }

    public Object nextContent() {
        char next;
        do {
            next = next();
            if (!Character.isWhitespace(next)) {
                break;
            }
        } while (this.configuration.shouldTrimWhiteSpace());
        if (next == 0) {
            return null;
        }
        if (next == '<') {
            return XML.LT;
        }
        StringBuilder sb = new StringBuilder();
        while (next != 0) {
            if (next == '<') {
                back();
                return this.configuration.shouldTrimWhiteSpace() ? sb.toString().trim() : sb.toString();
            }
            if (next == '&') {
                sb.append(nextEntity(next));
            } else {
                sb.append(next);
            }
            next = next();
        }
        return sb.toString().trim();
    }

    public Object nextEntity(char c) {
        char next;
        StringBuilder sb = new StringBuilder();
        while (true) {
            next = next();
            if (!Character.isLetterOrDigit(next) && next != '#') {
                break;
            }
            sb.append(Character.toLowerCase(next));
        }
        if (next == ';') {
            return unescapeEntity(sb.toString());
        }
        throw syntaxError("Missing ';' in XML entity: &" + ((Object) sb));
    }

    static String unescapeEntity(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.charAt(0) == '#') {
            return new String(new int[]{(str.charAt(1) == 'x' || str.charAt(1) == 'X') ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str.substring(1))}, 0, 1);
        }
        Character ch = entity.get(str);
        return ch == null ? '&' + str + ';' : ch.toString();
    }

    public Object nextMeta() {
        char next;
        char next2;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        switch (next) {
            case 0:
                throw syntaxError("Misshaped meta tag");
            case '!':
                return XML.BANG;
            case '\"':
            case '\'':
                do {
                    next2 = next();
                    if (next2 == 0) {
                        throw syntaxError("Unterminated string");
                    }
                } while (next2 != next);
                return Boolean.TRUE;
            case TokenParser.CLOSE_TAG /* 47 */:
                return XML.SLASH;
            case '<':
                return XML.LT;
            case '=':
                return XML.EQ;
            case TokenParser.TAG_END /* 62 */:
                return XML.GT;
            case '?':
                return XML.QUEST;
        }
        while (true) {
            char next3 = next();
            if (!Character.isWhitespace(next3)) {
                switch (next3) {
                    case 0:
                        throw syntaxError("Unterminated string");
                    case '!':
                    case '\"':
                    case '\'':
                    case TokenParser.CLOSE_TAG /* 47 */:
                    case '<':
                    case '=':
                    case TokenParser.TAG_END /* 62 */:
                    case '?':
                        back();
                        return Boolean.TRUE;
                    default:
                        break;
                }
            } else {
                return Boolean.TRUE;
            }
        }
    }

    public Object nextToken() {
        char next;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        switch (next) {
            case 0:
                throw syntaxError("Misshaped element");
            case '!':
                return XML.BANG;
            case '\"':
            case '\'':
                StringBuilder sb = new StringBuilder();
                while (true) {
                    char next2 = next();
                    if (next2 == 0) {
                        throw syntaxError("Unterminated string");
                    }
                    if (next2 == next) {
                        return sb.toString();
                    }
                    if (next2 == '&') {
                        sb.append(nextEntity(next2));
                    } else {
                        sb.append(next2);
                    }
                }
                break;
            case TokenParser.CLOSE_TAG /* 47 */:
                return XML.SLASH;
            case '<':
                throw syntaxError("Misplaced '<'");
            case '=':
                return XML.EQ;
            case TokenParser.TAG_END /* 62 */:
                return XML.GT;
            case '?':
                return XML.QUEST;
            default:
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    sb2.append(next);
                    next = next();
                    if (!Character.isWhitespace(next)) {
                        switch (next) {
                            case 0:
                                return sb2.toString();
                            case '!':
                            case TokenParser.CLOSE_TAG /* 47 */:
                            case '=':
                            case TokenParser.TAG_END /* 62 */:
                            case '?':
                            case '[':
                            case ']':
                                back();
                                return sb2.toString();
                            case '\"':
                            case '\'':
                            case '<':
                                throw syntaxError("Bad character in a name");
                            default:
                                break;
                        }
                    } else {
                        return sb2.toString();
                    }
                }
                break;
        }
    }

    public void skipPast(String str) {
        char next;
        int i = 0;
        int length = str.length();
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            char next2 = next();
            if (next2 == 0) {
                return;
            }
            cArr[i2] = next2;
        }
        while (true) {
            int i3 = i;
            boolean z = true;
            for (int i4 = 0; i4 < length; i4++) {
                if (cArr[i3] != str.charAt(i4)) {
                    z = false;
                    break;
                }
                i3++;
                if (i3 >= length) {
                    i3 -= length;
                }
            }
            if (z || (next = next()) == 0) {
                return;
            }
            cArr[i] = next;
            i++;
            if (i >= length) {
                i -= length;
            }
        }
    }

    static {
        entity.put("amp", XML.AMP);
        entity.put("apos", XML.APOS);
        entity.put("gt", XML.GT);
        entity.put("lt", XML.LT);
        entity.put("quot", XML.QUOT);
    }
}

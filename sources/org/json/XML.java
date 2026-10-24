package org.json;

import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/XML.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/XML.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/XML.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/XML.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/XML.class */
public class XML {
    public static final Character AMP = '&';
    public static final Character APOS = '\'';
    public static final Character BANG = '!';
    public static final Character EQ = '=';
    public static final Character GT = '>';
    public static final Character LT = '<';
    public static final Character QUEST = '?';
    public static final Character QUOT = '\"';
    public static final Character SLASH = '/';
    public static final String NULL_ATTR = "xsi:nil";
    public static final String TYPE_ATTR = "xsi:type";

    private static Iterable<Integer> codePointIterator(final String str) {
        return new Iterable<Integer>() { // from class: org.json.XML.1
            @Override // java.lang.Iterable
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() { // from class: org.json.XML.1.1
                    private int nextIndex = 0;
                    private int length;

                    {
                        this.length = str.length();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.nextIndex < this.length;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public Integer next() {
                        int iCodePointAt = str.codePointAt(this.nextIndex);
                        this.nextIndex += Character.charCount(iCodePointAt);
                        return Integer.valueOf(iCodePointAt);
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static String escape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        Iterator<Integer> it = codePointIterator(str).iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            switch (iIntValue) {
                case 34:
                    sb.append("&quot;");
                    break;
                case LegacyComponentSerializer.AMPERSAND_CHAR /* 38 */:
                    sb.append("&amp;");
                    break;
                case 39:
                    sb.append("&apos;");
                    break;
                case 60:
                    sb.append("&lt;");
                    break;
                case TokenParser.TAG_END /* 62 */:
                    sb.append("&gt;");
                    break;
                default:
                    if (!mustEscape(iIntValue)) {
                        sb.appendCodePoint(iIntValue);
                    } else {
                        sb.append("&#x");
                        sb.append(Integer.toHexString(iIntValue));
                        sb.append(';');
                    }
                    break;
            }
        }
        return sb.toString();
    }

    private static boolean mustEscape(int i) {
        return !(!Character.isISOControl(i) || i == 9 || i == 10 || i == 13) || ((i < 32 || i > 55295) && ((i < 57344 || i > 65533) && (i < 65536 || i > 1114111)));
    }

    public static String unescape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = 0;
        int length2 = str.length();
        while (length < length2) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '&') {
                int iIndexOf = str.indexOf(59, length);
                if (iIndexOf > length) {
                    String strSubstring = str.substring(length + 1, iIndexOf);
                    sb.append(XMLTokener.unescapeEntity(strSubstring));
                    length += strSubstring.length() + 1;
                } else {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
            length++;
        }
        return sb.toString();
    }

    public static void noSpace(String str) {
        int length = str.length();
        if (length == 0) {
            throw new JSONException("Empty string.");
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                throw new JSONException("'" + str + "' contains a space character.");
            }
        }
    }

    private static boolean parse(XMLTokener xMLTokener, JSONObject jSONObject, String str, XMLParserConfiguration xMLParserConfiguration, int i) {
        Object objNextToken = xMLTokener.nextToken();
        if (objNextToken == BANG) {
            char next = xMLTokener.next();
            if (next == '-') {
                if (xMLTokener.next() == '-') {
                    xMLTokener.skipPast("-->");
                    return false;
                }
                xMLTokener.back();
            } else if (next == '[') {
                if (!"CDATA".equals(xMLTokener.nextToken()) || xMLTokener.next() != '[') {
                    throw xMLTokener.syntaxError("Expected 'CDATA['");
                }
                String strNextCDATA = xMLTokener.nextCDATA();
                if (strNextCDATA.length() <= 0) {
                    return false;
                }
                jSONObject.accumulate(xMLParserConfiguration.getcDataTagName(), strNextCDATA);
                return false;
            }
            int i2 = 1;
            do {
                Object objNextMeta = xMLTokener.nextMeta();
                if (objNextMeta == null) {
                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                }
                if (objNextMeta == LT) {
                    i2++;
                } else if (objNextMeta == GT) {
                    i2--;
                }
            } while (i2 > 0);
            return false;
        }
        if (objNextToken == QUEST) {
            xMLTokener.skipPast("?>");
            return false;
        }
        if (objNextToken == SLASH) {
            Object objNextToken2 = xMLTokener.nextToken();
            if (str == null) {
                throw xMLTokener.syntaxError("Mismatched close tag " + objNextToken2);
            }
            if (!objNextToken2.equals(str)) {
                throw xMLTokener.syntaxError("Mismatched " + str + " and " + objNextToken2);
            }
            if (xMLTokener.nextToken() != GT) {
                throw xMLTokener.syntaxError("Misshaped close tag");
            }
            return true;
        }
        if (objNextToken instanceof Character) {
            throw xMLTokener.syntaxError("Misshaped tag");
        }
        String str2 = (String) objNextToken;
        Object objNextToken3 = null;
        JSONObject jSONObject2 = new JSONObject();
        boolean z = false;
        XMLXsiTypeConverter<?> xMLXsiTypeConverter = null;
        while (true) {
            if (objNextToken3 == null) {
                objNextToken3 = xMLTokener.nextToken();
            }
            if (objNextToken3 instanceof String) {
                String str3 = (String) objNextToken3;
                objNextToken3 = xMLTokener.nextToken();
                if (objNextToken3 == EQ) {
                    Object objNextToken4 = xMLTokener.nextToken();
                    if (!(objNextToken4 instanceof String)) {
                        throw xMLTokener.syntaxError("Missing value");
                    }
                    if (xMLParserConfiguration.isConvertNilAttributeToNull() && NULL_ATTR.equals(str3) && Boolean.parseBoolean((String) objNextToken4)) {
                        z = true;
                    } else if (xMLParserConfiguration.getXsiTypeMap() != null && !xMLParserConfiguration.getXsiTypeMap().isEmpty() && TYPE_ATTR.equals(str3)) {
                        xMLXsiTypeConverter = xMLParserConfiguration.getXsiTypeMap().get(objNextToken4);
                    } else if (!z) {
                        Object objStringToValue = stringToValue((String) objNextToken4);
                        if (objStringToValue instanceof Boolean) {
                            jSONObject2.accumulate(str3, xMLParserConfiguration.isKeepBooleanAsString() ? (String) objNextToken4 : objStringToValue);
                        } else if (objStringToValue instanceof Number) {
                            jSONObject2.accumulate(str3, xMLParserConfiguration.isKeepNumberAsString() ? (String) objNextToken4 : objStringToValue);
                        } else {
                            jSONObject2.accumulate(str3, stringToValue((String) objNextToken4));
                        }
                    }
                    objNextToken3 = null;
                } else {
                    jSONObject2.accumulate(str3, "");
                }
            } else {
                if (objNextToken3 == SLASH) {
                    if (xMLTokener.nextToken() != GT) {
                        throw xMLTokener.syntaxError("Misshaped tag");
                    }
                    if (xMLParserConfiguration.getForceList().contains(str2)) {
                        if (z) {
                            jSONObject.append(str2, JSONObject.NULL);
                            return false;
                        }
                        if (jSONObject2.length() > 0) {
                            jSONObject.append(str2, jSONObject2);
                            return false;
                        }
                        jSONObject.put(str2, new JSONArray());
                        return false;
                    }
                    if (z) {
                        jSONObject.accumulate(str2, JSONObject.NULL);
                        return false;
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.accumulate(str2, jSONObject2);
                        return false;
                    }
                    jSONObject.accumulate(str2, "");
                    return false;
                }
                if (objNextToken3 != GT) {
                    throw xMLTokener.syntaxError("Misshaped tag");
                }
                while (true) {
                    Object objNextContent = xMLTokener.nextContent();
                    if (objNextContent == null) {
                        if (str2 != null) {
                            throw xMLTokener.syntaxError("Unclosed tag " + str2);
                        }
                        return false;
                    }
                    if (objNextContent instanceof String) {
                        String str4 = (String) objNextContent;
                        if (str4.length() > 0) {
                            if (xMLXsiTypeConverter != null) {
                                jSONObject2.accumulate(xMLParserConfiguration.getcDataTagName(), stringToValue(str4, xMLXsiTypeConverter));
                            } else {
                                Object objStringToValue2 = stringToValue((String) objNextContent);
                                if (objStringToValue2 instanceof Boolean) {
                                    jSONObject2.accumulate(xMLParserConfiguration.getcDataTagName(), xMLParserConfiguration.isKeepBooleanAsString() ? (String) objNextContent : objStringToValue2);
                                } else if (objStringToValue2 instanceof Number) {
                                    jSONObject2.accumulate(xMLParserConfiguration.getcDataTagName(), xMLParserConfiguration.isKeepNumberAsString() ? (String) objNextContent : objStringToValue2);
                                } else if (objStringToValue2 == JSONObject.NULL) {
                                    jSONObject2.accumulate(xMLParserConfiguration.getcDataTagName(), xMLParserConfiguration.isKeepStrings() ? (String) objNextContent : objStringToValue2);
                                } else {
                                    jSONObject2.accumulate(xMLParserConfiguration.getcDataTagName(), stringToValue((String) objNextContent));
                                }
                            }
                        }
                    } else if (objNextContent != LT) {
                        continue;
                    } else {
                        if (i == xMLParserConfiguration.getMaxNestingDepth()) {
                            throw xMLTokener.syntaxError("Maximum nesting depth of " + xMLParserConfiguration.getMaxNestingDepth() + " reached");
                        }
                        if (parse(xMLTokener, jSONObject2, str2, xMLParserConfiguration, i + 1)) {
                            if (xMLParserConfiguration.getForceList().contains(str2)) {
                                if (jSONObject2.length() == 0) {
                                    jSONObject.put(str2, new JSONArray());
                                    return false;
                                }
                                if (jSONObject2.length() != 1 || jSONObject2.opt(xMLParserConfiguration.getcDataTagName()) == null) {
                                    jSONObject.append(str2, jSONObject2);
                                    return false;
                                }
                                jSONObject.append(str2, jSONObject2.opt(xMLParserConfiguration.getcDataTagName()));
                                return false;
                            }
                            if (jSONObject2.length() == 0) {
                                jSONObject.accumulate(str2, "");
                                return false;
                            }
                            if (jSONObject2.length() == 1 && jSONObject2.opt(xMLParserConfiguration.getcDataTagName()) != null) {
                                jSONObject.accumulate(str2, jSONObject2.opt(xMLParserConfiguration.getcDataTagName()));
                                return false;
                            }
                            if (!xMLParserConfiguration.shouldTrimWhiteSpace()) {
                                removeEmpty(jSONObject2, xMLParserConfiguration);
                            }
                            jSONObject.accumulate(str2, jSONObject2);
                            return false;
                        }
                    }
                }
            }
        }
    }

    private static void removeEmpty(JSONObject jSONObject, XMLParserConfiguration xMLParserConfiguration) {
        if (jSONObject.has(xMLParserConfiguration.getcDataTagName())) {
            Object obj = jSONObject.get(xMLParserConfiguration.getcDataTagName());
            if (obj instanceof String) {
                if (isStringAllWhiteSpace(obj.toString())) {
                    jSONObject.remove(xMLParserConfiguration.getcDataTagName());
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    Object obj2 = jSONArray.get(length);
                    if ((obj2 instanceof String) && isStringAllWhiteSpace((String) obj2)) {
                        jSONArray.remove(length);
                    }
                }
                if (jSONArray.isEmpty()) {
                    jSONObject.remove(xMLParserConfiguration.getcDataTagName());
                }
            }
        }
    }

    private static boolean isStringAllWhiteSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static Number stringToNumber(String str) {
        char cCharAt = str.charAt(0);
        if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '-') {
            throw new NumberFormatException("val [" + str + "] is not a valid number.");
        }
        if (isDecimalNotation(str)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(str);
                return (cCharAt == '-' && BigDecimal.ZERO.compareTo(bigDecimal) == 0) ? Double.valueOf(-0.0d) : bigDecimal;
            } catch (NumberFormatException e) {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isNaN() || dValueOf.isInfinite()) {
                        throw new NumberFormatException("val [" + str + "] is not a valid number.");
                    }
                    return dValueOf;
                } catch (NumberFormatException e2) {
                    throw new NumberFormatException("val [" + str + "] is not a valid number.");
                }
            }
        }
        if (cCharAt == '0' && str.length() > 1) {
            char cCharAt2 = str.charAt(1);
            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                throw new NumberFormatException("val [" + str + "] is not a valid number.");
            }
        } else if (cCharAt == '-' && str.length() > 2) {
            char cCharAt3 = str.charAt(1);
            char cCharAt4 = str.charAt(2);
            if (cCharAt3 == '0' && cCharAt4 >= '0' && cCharAt4 <= '9') {
                throw new NumberFormatException("val [" + str + "] is not a valid number.");
            }
        }
        BigInteger bigInteger = new BigInteger(str);
        if (bigInteger.bitLength() <= 31) {
            return Integer.valueOf(bigInteger.intValue());
        }
        return bigInteger.bitLength() <= 63 ? Long.valueOf(bigInteger.longValue()) : bigInteger;
    }

    private static boolean isDecimalNotation(String str) {
        return str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1 || "-0".equals(str);
    }

    public static Object stringToValue(String str, XMLXsiTypeConverter<?> xMLXsiTypeConverter) {
        return xMLXsiTypeConverter != null ? xMLXsiTypeConverter.convert(str) : stringToValue(str);
    }

    public static Object stringToValue(String str) {
        if ("".equals(str)) {
            return str;
        }
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(str)) {
            return JSONObject.NULL;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-') {
            try {
                return stringToNumber(str);
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static JSONObject toJSONObject(String str) {
        return toJSONObject(str, XMLParserConfiguration.ORIGINAL);
    }

    public static JSONObject toJSONObject(Reader reader) {
        return toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
    }

    public static JSONObject toJSONObject(Reader reader, boolean z) {
        return z ? toJSONObject(reader, XMLParserConfiguration.KEEP_STRINGS) : toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
    }

    public static JSONObject toJSONObject(Reader reader, boolean z, boolean z2) {
        XMLParserConfiguration xMLParserConfiguration = new XMLParserConfiguration();
        if (z) {
            xMLParserConfiguration = xMLParserConfiguration.withKeepNumberAsString(z);
        }
        if (z2) {
            xMLParserConfiguration = xMLParserConfiguration.withKeepBooleanAsString(z2);
        }
        return toJSONObject(reader, xMLParserConfiguration);
    }

    public static JSONObject toJSONObject(Reader reader, XMLParserConfiguration xMLParserConfiguration) {
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(reader, xMLParserConfiguration);
        while (xMLTokener.more()) {
            xMLTokener.skipPast("<");
            if (xMLTokener.more()) {
                parse(xMLTokener, jSONObject, null, xMLParserConfiguration, 0);
            }
        }
        return jSONObject;
    }

    public static JSONObject toJSONObject(String str, boolean z) {
        return toJSONObject(new StringReader(str), z);
    }

    public static JSONObject toJSONObject(String str, boolean z, boolean z2) {
        return toJSONObject(new StringReader(str), z, z2);
    }

    public static JSONObject toJSONObject(String str, XMLParserConfiguration xMLParserConfiguration) {
        return toJSONObject(new StringReader(str), xMLParserConfiguration);
    }

    public static String toString(Object obj) {
        return toString(obj, (String) null, XMLParserConfiguration.ORIGINAL);
    }

    public static String toString(Object obj, String str) {
        return toString(obj, str, XMLParserConfiguration.ORIGINAL);
    }

    public static String toString(Object obj, String str, XMLParserConfiguration xMLParserConfiguration) {
        return toString(obj, str, xMLParserConfiguration, 0, 0);
    }

    private static String toString(Object obj, String str, XMLParserConfiguration xMLParserConfiguration, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (!(obj instanceof JSONObject)) {
            if (obj == null || !((obj instanceof JSONArray) || obj.getClass().isArray())) {
                String strEscape = obj == null ? "null" : escape(obj.toString());
                String str2 = i > 0 ? "\n" : "";
                if (str == null) {
                    return indent(i2) + "\"" + strEscape + "\"" + str2;
                }
                return strEscape.length() == 0 ? indent(i2) + "<" + str + "/>" + str2 : indent(i2) + "<" + str + ">" + strEscape + "</" + str + ">" + str2;
            }
            JSONArray jSONArray = obj.getClass().isArray() ? new JSONArray(obj) : (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                sb.append(toString(jSONArray.opt(i3), str == null ? "array" : str, xMLParserConfiguration, i, i2));
            }
            return sb.toString();
        }
        if (str != null) {
            sb.append(indent(i2));
            sb.append('<');
            sb.append(str);
            sb.append('>');
            if (i > 0) {
                sb.append("\n");
                i2 += i;
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        for (String str3 : jSONObject.keySet()) {
            Object objOpt = jSONObject.opt(str3);
            if (objOpt == null) {
                objOpt = "";
            } else if (objOpt.getClass().isArray()) {
                objOpt = new JSONArray(objOpt);
            }
            if (str3.equals(xMLParserConfiguration.getcDataTagName())) {
                if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) objOpt;
                    int length2 = jSONArray2.length();
                    for (int i4 = 0; i4 < length2; i4++) {
                        if (i4 > 0) {
                            sb.append('\n');
                        }
                        sb.append(escape(jSONArray2.opt(i4).toString()));
                    }
                } else {
                    sb.append(escape(objOpt.toString()));
                }
            } else if (objOpt instanceof JSONArray) {
                JSONArray jSONArray3 = (JSONArray) objOpt;
                int length3 = jSONArray3.length();
                for (int i5 = 0; i5 < length3; i5++) {
                    Object objOpt2 = jSONArray3.opt(i5);
                    if (objOpt2 instanceof JSONArray) {
                        sb.append('<');
                        sb.append(str3);
                        sb.append('>');
                        sb.append(toString(objOpt2, null, xMLParserConfiguration, i, i2));
                        sb.append("</");
                        sb.append(str3);
                        sb.append('>');
                    } else {
                        sb.append(toString(objOpt2, str3, xMLParserConfiguration, i, i2));
                    }
                }
            } else if (!"".equals(objOpt)) {
                sb.append(toString(objOpt, str3, xMLParserConfiguration, i, i2));
            } else if (xMLParserConfiguration.isCloseEmptyTag()) {
                sb.append(indent(i2));
                sb.append('<');
                sb.append(str3);
                sb.append(">");
                sb.append("</");
                sb.append(str3);
                sb.append(">");
                if (i > 0) {
                    sb.append("\n");
                }
            } else {
                sb.append(indent(i2));
                sb.append('<');
                sb.append(str3);
                sb.append("/>");
                if (i > 0) {
                    sb.append("\n");
                }
            }
        }
        if (str != null) {
            sb.append(indent(i2 - i));
            sb.append("</");
            sb.append(str);
            sb.append('>');
            if (i > 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String toString(Object obj, int i) {
        return toString(obj, null, XMLParserConfiguration.ORIGINAL, i);
    }

    public static String toString(Object obj, String str, int i) {
        return toString(obj, str, XMLParserConfiguration.ORIGINAL, i);
    }

    public static String toString(Object obj, String str, XMLParserConfiguration xMLParserConfiguration, int i) {
        return toString(obj, str, xMLParserConfiguration, i, 0);
    }

    private static final String indent(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}

package org.json;


/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/JSONML.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/JSONML.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/JSONML.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONML.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONML.class */
public class JSONML {
    @Deprecated
    public JSONML() {
    }

    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray, boolean z2, int i) {
        return parse(xMLTokener, z, jSONArray, z2 ? JSONMLParserConfiguration.KEEP_STRINGS : JSONMLParserConfiguration.ORIGINAL, i);
    }

    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray, JSONMLParserConfiguration jSONMLParserConfiguration, int i) {
        Object objUnescape;
        while (xMLTokener.more()) {
            Object objNextContent = xMLTokener.nextContent();
            if (objNextContent == XML.LT) {
                Object objNextToken = xMLTokener.nextToken();
                if (objNextToken instanceof Character) {
                    if (objNextToken == XML.SLASH) {
                        Object objNextToken2 = xMLTokener.nextToken();
                        if (!(objNextToken2 instanceof String)) {
                            throw new JSONException("Expected a closing name instead of '" + objNextToken2 + "'.");
                        }
                        if (xMLTokener.nextToken() != XML.GT) {
                            throw xMLTokener.syntaxError("Misshaped close tag");
                        }
                        return objNextToken2;
                    }
                    if (objNextToken == XML.BANG) {
                        char next = xMLTokener.next();
                        if (next == '-') {
                            if (xMLTokener.next() == '-') {
                                xMLTokener.skipPast("-->");
                            } else {
                                xMLTokener.back();
                            }
                        } else if (next != '[') {
                            int i2 = 1;
                            do {
                                Object objNextMeta = xMLTokener.nextMeta();
                                if (objNextMeta == null) {
                                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                                }
                                if (objNextMeta == XML.LT) {
                                    i2++;
                                } else if (objNextMeta == XML.GT) {
                                    i2--;
                                }
                            } while (i2 > 0);
                        } else {
                            if (!"CDATA".equals(xMLTokener.nextToken()) || xMLTokener.next() != '[') {
                                throw xMLTokener.syntaxError("Expected 'CDATA['");
                            }
                            if (jSONArray != null) {
                                jSONArray.put(xMLTokener.nextCDATA());
                            }
                        }
                    } else {
                        if (objNextToken != XML.QUEST) {
                            throw xMLTokener.syntaxError("Misshaped tag");
                        }
                        xMLTokener.skipPast("?>");
                    }
                } else {
                    if (!(objNextToken instanceof String)) {
                        throw xMLTokener.syntaxError("Bad tagName '" + objNextToken + "'.");
                    }
                    String str = (String) objNextToken;
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        jSONArray2.put(str);
                        if (jSONArray != null) {
                            jSONArray.put(jSONArray2);
                        }
                    } else {
                        jSONObject.put("tagName", str);
                        if (jSONArray != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    Object objNextToken3 = null;
                    while (true) {
                        if (objNextToken3 == null) {
                            objNextToken3 = xMLTokener.nextToken();
                        }
                        if (objNextToken3 == null) {
                            throw xMLTokener.syntaxError("Misshaped tag");
                        }
                        if (!(objNextToken3 instanceof String)) {
                            if (z && jSONObject.length() > 0) {
                                jSONArray2.put(jSONObject);
                            }
                            if (objNextToken3 != XML.SLASH) {
                                if (objNextToken3 == XML.GT) {
                                    if (i != jSONMLParserConfiguration.getMaxNestingDepth()) {
                                        String str2 = (String) parse(xMLTokener, z, jSONArray2, jSONMLParserConfiguration, i + 1);
                                        if (str2 != null) {
                                            if (!str2.equals(str)) {
                                                throw xMLTokener.syntaxError("Mismatched '" + str + "' and '" + str2 + "'");
                                            }
                                            if (!z && jSONArray2.length() > 0) {
                                                jSONObject.put("childNodes", jSONArray2);
                                            }
                                            if (jSONArray != null) {
                                                break;
                                            }
                                            return z ? jSONArray2 : jSONObject;
                                        }
                                        break;
                                    }
                                    throw xMLTokener.syntaxError("Maximum nesting depth of " + jSONMLParserConfiguration.getMaxNestingDepth() + " reached");
                                }
                                throw xMLTokener.syntaxError("Misshaped tag");
                            }
                            if (xMLTokener.nextToken() == XML.GT) {
                                if (jSONArray != null) {
                                    break;
                                }
                                return z ? jSONArray2 : jSONObject;
                            }
                            throw xMLTokener.syntaxError("Misshaped tag");
                        }
                        String str3 = (String) objNextToken3;
                        if (!z && ("tagName".equals(str3) || "childNode".equals(str3))) {
                            throw xMLTokener.syntaxError("Reserved attribute.");
                        }
                        objNextToken3 = xMLTokener.nextToken();
                        if (objNextToken3 == XML.EQ) {
                            Object objNextToken4 = xMLTokener.nextToken();
                            if (!(objNextToken4 instanceof String)) {
                                throw xMLTokener.syntaxError("Missing value");
                            }
                            jSONObject.accumulate(str3, jSONMLParserConfiguration.isKeepStrings() ? (String) objNextToken4 : XML.stringToValue((String) objNextToken4));
                            objNextToken3 = null;
                        } else {
                            jSONObject.accumulate(str3, "");
                        }
                    }
                }
            } else if (jSONArray != null) {
                if (objNextContent instanceof String) {
                    String str4 = (String) objNextContent;
                    objUnescape = jSONMLParserConfiguration.isKeepStrings() ? XML.unescape(str4) : XML.stringToValue(str4);
                } else {
                    objUnescape = objNextContent;
                }
                jSONArray.put(objUnescape);
            }
        }
        throw xMLTokener.syntaxError("Bad XML");
    }

    public static JSONArray toJSONArray(String str) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, JSONMLParserConfiguration.ORIGINAL, 0);
    }

    public static JSONArray toJSONArray(String str, boolean z) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, z, 0);
    }

    public static JSONArray toJSONArray(String str, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener, boolean z) {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, z, 0);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, false, 0);
    }

    public static JSONObject toJSONObject(String str) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, false, 0);
    }

    public static JSONObject toJSONObject(String str, boolean z) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, z, 0);
    }

    public static JSONObject toJSONObject(String str, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, false, 0);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener, boolean z) {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, z, 0);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static String toString(JSONArray jSONArray) {
        int i;
        StringBuilder sb = new StringBuilder();
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String strEscape = XML.escape(string);
        sb.append('<');
        sb.append(strEscape);
        Object objOpt = jSONArray.opt(1);
        if (objOpt instanceof JSONObject) {
            i = 2;
            JSONObject jSONObject = (JSONObject) objOpt;
            for (String str : jSONObject.keySet()) {
                Object objOpt2 = jSONObject.opt(str);
                XML.noSpace(str);
                if (objOpt2 != null) {
                    sb.append(' ');
                    sb.append(XML.escape(str));
                    sb.append('=');
                    sb.append('\"');
                    sb.append(XML.escape(objOpt2.toString()));
                    sb.append('\"');
                }
            }
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            sb.append('/');
            sb.append('>');
        } else {
            sb.append('>');
            do {
                Object obj = jSONArray.get(i);
                i++;
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                    } else {
                        sb.append(obj.toString());
                    }
                }
            } while (i < length);
            sb.append('<');
            sb.append('/');
            sb.append(strEscape);
            sb.append('>');
        }
        return sb.toString();
    }

    public static String toString(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        String strOptString = jSONObject.optString("tagName");
        if (strOptString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(strOptString);
        String strEscape = XML.escape(strOptString);
        sb.append('<');
        sb.append(strEscape);
        for (String str : jSONObject.keySet()) {
            if (!"tagName".equals(str) && !"childNodes".equals(str)) {
                XML.noSpace(str);
                Object objOpt = jSONObject.opt(str);
                if (objOpt != null) {
                    sb.append(' ');
                    sb.append(XML.escape(str));
                    sb.append('=');
                    sb.append('\"');
                    sb.append(XML.escape(objOpt.toString()));
                    sb.append('\"');
                }
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childNodes");
        if (jSONArrayOptJSONArray == null) {
            sb.append('/');
            sb.append('>');
        } else {
            sb.append('>');
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArrayOptJSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                    } else {
                        sb.append(obj.toString());
                    }
                }
            }
            sb.append('<');
            sb.append('/');
            sb.append(strEscape);
            sb.append('>');
        }
        return sb.toString();
    }
}

package org.json;


/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/CDL.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/CDL.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/CDL.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/CDL.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/CDL.class */
public class CDL {
    @Deprecated
    public CDL() {
    }

    private static String getValue(JSONTokener jSONTokener, char c) {
        char next;
        char next2;
        while (true) {
            next = jSONTokener.next();
            if (next != ' ' && next != '\t') {
                break;
            }
        }
        if (next == 0) {
            return null;
        }
        if (next != '\"' && next != '\'') {
            if (next == c) {
                jSONTokener.back();
                return "";
            }
            jSONTokener.back();
            return jSONTokener.nextTo(c);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            char next3 = jSONTokener.next();
            if (next3 == next && (next2 = jSONTokener.next()) != '\"') {
                if (next2 > 0) {
                    jSONTokener.back();
                }
                return sb.toString();
            }
            if (next3 == 0 || next3 == '\n' || next3 == '\r') {
                throw jSONTokener.syntaxError("Missing close quote '" + next + "'.");
            }
            sb.append(next3);
        }
    }

    public static JSONArray rowToJSONArray(JSONTokener jSONTokener) {
        return rowToJSONArray(jSONTokener, ',');
    }

    public static JSONArray rowToJSONArray(JSONTokener jSONTokener, char c) {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String value = getValue(jSONTokener, c);
            char next = jSONTokener.next();
            if (value != null) {
                jSONArray.put(value);
            } else {
                if (jSONArray.length() == 0 && next != c) {
                    return null;
                }
                jSONArray.put("");
            }
            while (next != c) {
                if (next != ' ') {
                    if (next == '\n' || next == '\r' || next == 0) {
                        return jSONArray;
                    }
                    throw jSONTokener.syntaxError("Bad character '" + next + "' (" + ((int) next) + ").");
                }
                next = jSONTokener.next();
            }
        }
    }

    public static JSONObject rowToJSONObject(JSONArray jSONArray, JSONTokener jSONTokener) {
        return rowToJSONObject(jSONArray, jSONTokener, ',');
    }

    public static JSONObject rowToJSONObject(JSONArray jSONArray, JSONTokener jSONTokener, char c) {
        JSONArray jSONArrayRowToJSONArray = rowToJSONArray(jSONTokener, c);
        if (jSONArrayRowToJSONArray != null) {
            return jSONArrayRowToJSONArray.toJSONObject(jSONArray);
        }
        return null;
    }

    public static String rowToString(JSONArray jSONArray) {
        return rowToString(jSONArray, ',');
    }

    public static String rowToString(JSONArray jSONArray, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                sb.append(c);
            }
            Object objOpt = jSONArray.opt(i);
            if (objOpt != null) {
                String string = objOpt.toString();
                if (string.isEmpty() || (string.indexOf(c) < 0 && string.indexOf(10) < 0 && string.indexOf(13) < 0 && string.indexOf(0) < 0 && string.charAt(0) != '\"')) {
                    sb.append(string);
                } else {
                    sb.append('\"');
                    int length = string.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        char cCharAt = string.charAt(i2);
                        if (cCharAt >= ' ' && cCharAt != '\"') {
                            sb.append(cCharAt);
                        }
                    }
                    sb.append('\"');
                }
            }
        }
        sb.append('\n');
        return sb.toString();
    }

    public static JSONArray toJSONArray(String str) {
        return toJSONArray(str, ',');
    }

    public static JSONArray toJSONArray(String str, char c) {
        return toJSONArray(new JSONTokener(str), c);
    }

    public static JSONArray toJSONArray(JSONTokener jSONTokener) {
        return toJSONArray(jSONTokener, ',');
    }

    public static JSONArray toJSONArray(JSONTokener jSONTokener, char c) {
        return toJSONArray(rowToJSONArray(jSONTokener, c), jSONTokener, c);
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, String str) {
        return toJSONArray(jSONArray, str, ',');
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, String str, char c) {
        return toJSONArray(jSONArray, new JSONTokener(str), c);
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, JSONTokener jSONTokener) {
        return toJSONArray(jSONArray, jSONTokener, ',');
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, JSONTokener jSONTokener, char c) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        while (true) {
            JSONObject jSONObjectRowToJSONObject = rowToJSONObject(jSONArray, jSONTokener, c);
            if (jSONObjectRowToJSONObject == null) {
                break;
            }
            jSONArray2.put(jSONObjectRowToJSONObject);
        }
        if (jSONArray2.length() == 0) {
            return null;
        }
        if (jSONArray2.length() == 1) {
            JSONObject jSONObject = jSONArray2.getJSONObject(0);
            if (jSONObject.length() == 1) {
                String next = jSONObject.keys().next();
                if ("".equals(next) && "".equals(jSONObject.get(next))) {
                    return null;
                }
            }
        }
        return jSONArray2;
    }

    public static String toString(JSONArray jSONArray) {
        return toString(jSONArray, ',');
    }

    public static String toString(JSONArray jSONArray, char c) {
        JSONArray jSONArrayNames;
        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null || (jSONArrayNames = jSONObjectOptJSONObject.names()) == null) {
            return null;
        }
        return rowToString(jSONArrayNames, c) + toString(jSONArrayNames, jSONArray, c);
    }

    public static String toString(JSONArray jSONArray, JSONArray jSONArray2) {
        return toString(jSONArray, jSONArray2, ',');
    }

    public static String toString(JSONArray jSONArray, JSONArray jSONArray2, char c) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                sb.append(rowToString(jSONObjectOptJSONObject.toJSONArray(jSONArray), c));
            }
        }
        return sb.toString();
    }
}

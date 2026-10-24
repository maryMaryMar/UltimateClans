package org.json;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/JSONWriter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/JSONWriter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/JSONWriter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONWriter.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONWriter.class */
public class JSONWriter {
    private static final int maxdepth = 200;
    private boolean comma = false;
    protected char mode = 'i';
    private final JSONObject[] stack = new JSONObject[maxdepth];
    private int top = 0;
    protected Appendable writer;

    public JSONWriter(Appendable appendable) {
        this.writer = appendable;
    }

    private JSONWriter append(String str) {
        if (str == null) {
            throw new JSONException("Null pointer");
        }
        if (this.mode != 'o' && this.mode != 'a') {
            throw new JSONException("Value out of sequence.");
        }
        try {
            if (this.comma && this.mode == 'a') {
                this.writer.append(',');
            }
            this.writer.append(str);
            if (this.mode == 'o') {
                this.mode = 'k';
            }
            this.comma = true;
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONWriter array() {
        if (this.mode != 'i' && this.mode != 'o' && this.mode != 'a') {
            throw new JSONException("Misplaced array.");
        }
        push(null);
        append("[");
        this.comma = false;
        return this;
    }

    private JSONWriter end(char c, char c2) {
        if (this.mode != c) {
            throw new JSONException(c == 'a' ? "Misplaced endArray." : "Misplaced endObject.");
        }
        pop(c);
        try {
            this.writer.append(c2);
            this.comma = true;
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONWriter endArray() {
        return end('a', ']');
    }

    public JSONWriter endObject() {
        return end('k', '}');
    }

    public JSONWriter key(String str) {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (this.mode != 'k') {
            throw new JSONException("Misplaced key.");
        }
        try {
            JSONObject jSONObject = this.stack[this.top - 1];
            if (jSONObject.has(str)) {
                throw new JSONException("Duplicate key \"" + str + "\"");
            }
            jSONObject.put(str, true);
            if (this.comma) {
                this.writer.append(',');
            }
            this.writer.append(JSONObject.quote(str));
            this.writer.append(':');
            this.comma = false;
            this.mode = 'o';
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONWriter object() {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        if (this.mode != 'o' && this.mode != 'a') {
            throw new JSONException("Misplaced object.");
        }
        append("{");
        push(new JSONObject());
        this.comma = false;
        return this;
    }

    private void pop(char c) {
        char c2;
        if (this.top <= 0) {
            throw new JSONException("Nesting error.");
        }
        if ((this.stack[this.top - 1] == null ? 'a' : 'k') != c) {
            throw new JSONException("Nesting error.");
        }
        this.top--;
        if (this.top == 0) {
            c2 = 'd';
        } else {
            c2 = this.stack[this.top - 1] == null ? 'a' : 'k';
        }
        this.mode = c2;
    }

    private void push(JSONObject jSONObject) {
        if (this.top >= maxdepth) {
            throw new JSONException("Nesting too deep.");
        }
        this.stack[this.top] = jSONObject;
        this.mode = jSONObject == null ? 'a' : 'k';
        this.top++;
    }

    public static String valueToString(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString != null) {
                    return jSONString;
                }
                throw new JSONException("Bad value from toJSONString: " + jSONString);
            } catch (Exception e) {
                throw new JSONException(e);
            }
        }
        if (obj instanceof Number) {
            String strNumberToString = JSONObject.numberToString((Number) obj);
            return JSONObject.NUMBER_PATTERN.matcher(strNumberToString).matches() ? strNumberToString : JSONObject.quote(strNumberToString);
        }
        if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new JSONObject((Map<?, ?>) obj).toString();
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection<?>) obj).toString();
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj).toString();
        }
        return obj instanceof Enum ? JSONObject.quote(((Enum) obj).name()) : JSONObject.quote(obj.toString());
    }

    public JSONWriter value(boolean z) {
        return append(z ? "true" : "false");
    }

    public JSONWriter value(double d) {
        return value(Double.valueOf(d));
    }

    public JSONWriter value(long j) {
        return append(Long.toString(j));
    }

    public JSONWriter value(Object obj) {
        return append(valueToString(obj));
    }
}

package me.ulrich.clans.library.nbtapi.utils.metrics.json;

import java.util.Arrays;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/json/JsonObjectBuilder.class */
public class JsonObjectBuilder {
    private StringBuilder builder = new StringBuilder();
    private boolean hasAtLeastOneField = false;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/json/JsonObjectBuilder$JsonObject.class */
    public static class JsonObject {
        private final String value;

        private JsonObject(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public JsonObjectBuilder() {
        this.builder.append("{");
    }

    public JsonObjectBuilder appendNull(String str) {
        appendFieldUnescaped(str, "null");
        return this;
    }

    public JsonObjectBuilder appendField(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("JSON value must not be null");
        }
        appendFieldUnescaped(str, "\"" + escape(str2) + "\"");
        return this;
    }

    public JsonObjectBuilder appendField(String str, int i) {
        appendFieldUnescaped(str, String.valueOf(i));
        return this;
    }

    public JsonObjectBuilder appendField(String str, JsonObject jsonObject) {
        if (jsonObject == null) {
            throw new IllegalArgumentException("JSON object must not be null");
        }
        appendFieldUnescaped(str, jsonObject.toString());
        return this;
    }

    public JsonObjectBuilder appendField(String str, String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        appendFieldUnescaped(str, "[" + ((String) Arrays.stream(strArr).map(str2 -> {
            return "\"" + escape(str2) + "\"";
        }).collect(Collectors.joining(","))) + "]");
        return this;
    }

    public JsonObjectBuilder appendField(String str, int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        appendFieldUnescaped(str, "[" + ((String) Arrays.stream(iArr).mapToObj(String::valueOf).collect(Collectors.joining(","))) + "]");
        return this;
    }

    public JsonObjectBuilder appendField(String str, JsonObject[] jsonObjectArr) {
        if (jsonObjectArr == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        appendFieldUnescaped(str, "[" + ((String) Arrays.stream(jsonObjectArr).map((v0) -> {
            return v0.toString();
        }).collect(Collectors.joining(","))) + "]");
        return this;
    }

    private void appendFieldUnescaped(String str, String str2) {
        if (this.builder == null) {
            throw new IllegalStateException("JSON has already been built");
        }
        if (str == null) {
            throw new IllegalArgumentException("JSON key must not be null");
        }
        if (this.hasAtLeastOneField) {
            this.builder.append(",");
        }
        this.builder.append("\"").append(escape(str)).append("\":").append(str2);
        this.hasAtLeastOneField = true;
    }

    public JsonObject build() {
        if (this.builder == null) {
            throw new IllegalStateException("JSON has already been built");
        }
        JsonObject jsonObject = new JsonObject(this.builder.append("}").toString());
        this.builder = null;
        return jsonObject;
    }

    private static String escape(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt <= 15) {
                sb.append("\\u000").append(Integer.toHexString(cCharAt));
            } else if (cCharAt <= 31) {
                sb.append("\\u00").append(Integer.toHexString(cCharAt));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}

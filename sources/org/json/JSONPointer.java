package org.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/JSONPointer.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/JSONPointer.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/JSONPointer.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONPointer.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONPointer.class */
public class JSONPointer {
    private static final String ENCODING = "utf-8";
    private final List<String> refTokens;

    /* JADX WARN: Classes with same name are omitted, all sources:
      UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/JSONPointer$Builder.class
      UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/JSONPointer$Builder.class
      UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/JSONPointer$Builder.class
      UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONPointer$Builder.class
     */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONPointer$Builder.class */
    public static class Builder {
        private final List<String> refTokens = new ArrayList();

        public JSONPointer build() {
            return new JSONPointer(this.refTokens);
        }

        public Builder append(String str) {
            if (str == null) {
                throw new NullPointerException("token cannot be null");
            }
            this.refTokens.add(str);
            return this;
        }

        public Builder append(int i) {
            this.refTokens.add(String.valueOf(i));
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public JSONPointer(String str) {
        String strSubstring;
        if (str == null) {
            throw new NullPointerException("pointer cannot be null");
        }
        if (str.isEmpty() || TextColor.HEX_PREFIX.equals(str)) {
            this.refTokens = Collections.emptyList();
            return;
        }
        if (str.startsWith("#/")) {
            try {
                strSubstring = URLDecoder.decode(str.substring(2), ENCODING);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
            }
            strSubstring = str.substring(1);
        }
        this.refTokens = new ArrayList();
        int iIndexOf = -1;
        do {
            int i = iIndexOf + 1;
            iIndexOf = strSubstring.indexOf(47, i);
            if (i == iIndexOf || i == strSubstring.length()) {
                this.refTokens.add("");
            } else if (iIndexOf >= 0) {
                this.refTokens.add(unescape(strSubstring.substring(i, iIndexOf)));
            } else {
                this.refTokens.add(unescape(strSubstring.substring(i)));
            }
        } while (iIndexOf >= 0);
    }

    public JSONPointer(List<String> list) {
        this.refTokens = new ArrayList(list);
    }

    private static String unescape(String str) {
        return str.replace("~1", "/").replace("~0", "~");
    }

    public Object queryFrom(Object obj) {
        if (this.refTokens.isEmpty()) {
            return obj;
        }
        Object objOpt = obj;
        for (String str : this.refTokens) {
            if (objOpt instanceof JSONObject) {
                objOpt = ((JSONObject) objOpt).opt(unescape(str));
            } else {
                if (!(objOpt instanceof JSONArray)) {
                    throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", objOpt, str));
                }
                objOpt = readByIndexToken(objOpt, str);
            }
        }
        return objOpt;
    }

    private static Object readByIndexToken(Object obj, String str) {
        try {
            int i = Integer.parseInt(str);
            JSONArray jSONArray = (JSONArray) obj;
            if (i >= jSONArray.length()) {
                throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", str, Integer.valueOf(jSONArray.length())));
            }
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
                throw new JSONPointerException("Error reading value at index position " + i, e);
            }
        } catch (NumberFormatException e2) {
            throw new JSONPointerException(String.format("%s is not an array index", str), e2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.refTokens.iterator();
        while (it.hasNext()) {
            sb.append('/').append(escape(it.next()));
        }
        return sb.toString();
    }

    private static String escape(String str) {
        return str.replace("~", "~0").replace("/", "~1");
    }

    public String toURIFragment() {
        try {
            StringBuilder sb = new StringBuilder(TextColor.HEX_PREFIX);
            Iterator<String> it = this.refTokens.iterator();
            while (it.hasNext()) {
                sb.append('/').append(URLEncoder.encode(it.next(), ENCODING));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.json;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/CookieList.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/CookieList.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/CookieList.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/CookieList.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/CookieList.class */
public class CookieList {
    @Deprecated
    public CookieList() {
    }

    public static JSONObject toJSONObject(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONTokener jSONTokener = new JSONTokener(str);
        while (jSONTokener.more()) {
            String strUnescape = Cookie.unescape(jSONTokener.nextTo('='));
            jSONTokener.next('=');
            jSONObject.put(strUnescape, Cookie.unescape(jSONTokener.nextTo(';')));
            jSONTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) {
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        for (String str : jSONObject.keySet()) {
            Object objOpt = jSONObject.opt(str);
            if (!JSONObject.NULL.equals(objOpt)) {
                if (z) {
                    sb.append(';');
                }
                sb.append(Cookie.escape(str));
                sb.append("=");
                sb.append(Cookie.escape(objOpt.toString()));
                z = true;
            }
        }
        return sb.toString();
    }
}

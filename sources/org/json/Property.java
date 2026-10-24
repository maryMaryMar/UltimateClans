package org.json;

import java.util.Enumeration;
import java.util.Properties;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/Property.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/Property.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/Property.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/Property.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/Property.class */
public class Property {
    public static JSONObject toJSONObject(Properties properties) {
        JSONObject jSONObject = new JSONObject();
        if (properties != null && !properties.isEmpty()) {
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String str = (String) enumerationPropertyNames.nextElement();
                jSONObject.put(str, properties.getProperty(str));
            }
        }
        return jSONObject;
    }

    public static Properties toProperties(JSONObject jSONObject) {
        Properties properties = new Properties();
        if (jSONObject != null) {
            for (String str : jSONObject.keySet()) {
                Object objOpt = jSONObject.opt(str);
                if (!JSONObject.NULL.equals(objOpt)) {
                    properties.put(str, objOpt.toString());
                }
            }
        }
        return properties;
    }
}

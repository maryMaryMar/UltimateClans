package org.java_websocket.extensions;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/extensions/ExtensionRequestData.class */
public class ExtensionRequestData {
    public static final String EMPTY_VALUE = "";
    private Map<String, String> extensionParameters = new LinkedHashMap();
    private String extensionName;

    private ExtensionRequestData() {
    }

    public static ExtensionRequestData parseExtensionRequest(String str) {
        ExtensionRequestData extensionRequestData = new ExtensionRequestData();
        String[] strArrSplit = str.split(";");
        extensionRequestData.extensionName = strArrSplit[0].trim();
        for (int i = 1; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].split("=");
            String str2 = EMPTY_VALUE;
            if (strArrSplit2.length > 1) {
                String strTrim = strArrSplit2[1].trim();
                if ((strTrim.startsWith("\"") && strTrim.endsWith("\"")) || (strTrim.startsWith("'") && strTrim.endsWith("'") && strTrim.length() > 2)) {
                    strTrim = strTrim.substring(1, strTrim.length() - 1);
                }
                str2 = strTrim;
            }
            extensionRequestData.extensionParameters.put(strArrSplit2[0].trim(), str2);
        }
        return extensionRequestData;
    }

    public String getExtensionName() {
        return this.extensionName;
    }

    public Map<String, String> getExtensionParameters() {
        return this.extensionParameters;
    }
}

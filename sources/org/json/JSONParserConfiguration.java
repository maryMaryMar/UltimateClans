package org.json;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/JSONParserConfiguration.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/JSONParserConfiguration.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/JSONParserConfiguration.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONParserConfiguration.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONParserConfiguration.class */
public class JSONParserConfiguration extends ParserConfiguration {
    private boolean overwriteDuplicateKey = false;
    private boolean useNativeNulls;
    private boolean strictMode;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.json.ParserConfiguration
    /* JADX INFO: renamed from: clone */
    public JSONParserConfiguration mo1036clone() {
        JSONParserConfiguration jSONParserConfiguration = new JSONParserConfiguration();
        jSONParserConfiguration.overwriteDuplicateKey = this.overwriteDuplicateKey;
        jSONParserConfiguration.strictMode = this.strictMode;
        jSONParserConfiguration.maxNestingDepth = this.maxNestingDepth;
        jSONParserConfiguration.keepStrings = this.keepStrings;
        jSONParserConfiguration.useNativeNulls = this.useNativeNulls;
        return jSONParserConfiguration;
    }

    @Override // org.json.ParserConfiguration
    public JSONParserConfiguration withMaxNestingDepth(int i) {
        JSONParserConfiguration jSONParserConfigurationMo1036clone = mo1036clone();
        jSONParserConfigurationMo1036clone.maxNestingDepth = i;
        return jSONParserConfigurationMo1036clone;
    }

    public JSONParserConfiguration withOverwriteDuplicateKey(boolean z) {
        JSONParserConfiguration jSONParserConfigurationMo1036clone = mo1036clone();
        jSONParserConfigurationMo1036clone.overwriteDuplicateKey = z;
        return jSONParserConfigurationMo1036clone;
    }

    public JSONParserConfiguration withUseNativeNulls(boolean z) {
        JSONParserConfiguration jSONParserConfigurationMo1036clone = mo1036clone();
        jSONParserConfigurationMo1036clone.useNativeNulls = z;
        return jSONParserConfigurationMo1036clone;
    }

    public JSONParserConfiguration withStrictMode() {
        return withStrictMode(true);
    }

    public JSONParserConfiguration withStrictMode(boolean z) {
        JSONParserConfiguration jSONParserConfigurationMo1036clone = mo1036clone();
        jSONParserConfigurationMo1036clone.strictMode = z;
        return jSONParserConfigurationMo1036clone;
    }

    public boolean isOverwriteDuplicateKey() {
        return this.overwriteDuplicateKey;
    }

    public boolean isUseNativeNulls() {
        return this.useNativeNulls;
    }

    public boolean isStrictMode() {
        return this.strictMode;
    }
}

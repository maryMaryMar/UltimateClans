package org.json;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/XMLParserConfiguration.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/XMLParserConfiguration.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/XMLParserConfiguration.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/XMLParserConfiguration.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/XMLParserConfiguration.class */
public class XMLParserConfiguration extends ParserConfiguration {
    private boolean keepNumberAsString;
    private boolean keepBooleanAsString;
    public static final XMLParserConfiguration ORIGINAL = new XMLParserConfiguration();
    public static final XMLParserConfiguration KEEP_STRINGS = new XMLParserConfiguration().withKeepStrings(true);
    private String cDataTagName;
    private boolean convertNilAttributeToNull;
    private boolean closeEmptyTag;
    private Map<String, XMLXsiTypeConverter<?>> xsiTypeMap;
    private Set<String> forceList;
    private boolean shouldTrimWhiteSpace;

    public XMLParserConfiguration() {
        this.cDataTagName = "content";
        this.convertNilAttributeToNull = false;
        this.xsiTypeMap = Collections.emptyMap();
        this.forceList = Collections.emptySet();
        this.shouldTrimWhiteSpace = true;
    }

    @Deprecated
    public XMLParserConfiguration(boolean z) {
        this(z, "content", false);
    }

    @Deprecated
    public XMLParserConfiguration(String str) {
        this(false, str, false);
    }

    @Deprecated
    public XMLParserConfiguration(boolean z, String str) {
        super(z, 512);
        this.cDataTagName = str;
        this.convertNilAttributeToNull = false;
    }

    @Deprecated
    public XMLParserConfiguration(boolean z, String str, boolean z2) {
        super(false, 512);
        this.keepNumberAsString = z;
        this.keepBooleanAsString = z;
        this.cDataTagName = str;
        this.convertNilAttributeToNull = z2;
    }

    private XMLParserConfiguration(boolean z, String str, boolean z2, Map<String, XMLXsiTypeConverter<?>> map, Set<String> set, int i, boolean z3, boolean z4, boolean z5) {
        super(false, i);
        this.keepNumberAsString = z4;
        this.keepBooleanAsString = z5;
        this.cDataTagName = str;
        this.convertNilAttributeToNull = z2;
        this.xsiTypeMap = Collections.unmodifiableMap(map);
        this.forceList = Collections.unmodifiableSet(set);
        this.closeEmptyTag = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.json.ParserConfiguration
    /* JADX INFO: renamed from: clone */
    public XMLParserConfiguration mo1036clone() {
        XMLParserConfiguration xMLParserConfiguration = new XMLParserConfiguration(this.keepStrings, this.cDataTagName, this.convertNilAttributeToNull, this.xsiTypeMap, this.forceList, this.maxNestingDepth, this.closeEmptyTag, this.keepNumberAsString, this.keepBooleanAsString);
        xMLParserConfiguration.shouldTrimWhiteSpace = this.shouldTrimWhiteSpace;
        return xMLParserConfiguration;
    }

    @Override // org.json.ParserConfiguration
    public XMLParserConfiguration withKeepStrings(boolean z) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.keepStrings = z;
        xMLParserConfigurationMo1036clone.keepNumberAsString = z;
        xMLParserConfigurationMo1036clone.keepBooleanAsString = z;
        return xMLParserConfigurationMo1036clone;
    }

    public XMLParserConfiguration withKeepNumberAsString(boolean z) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.keepNumberAsString = z;
        xMLParserConfigurationMo1036clone.keepStrings = xMLParserConfigurationMo1036clone.keepBooleanAsString && xMLParserConfigurationMo1036clone.keepNumberAsString;
        return xMLParserConfigurationMo1036clone;
    }

    public XMLParserConfiguration withKeepBooleanAsString(boolean z) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.keepBooleanAsString = z;
        xMLParserConfigurationMo1036clone.keepStrings = xMLParserConfigurationMo1036clone.keepBooleanAsString && xMLParserConfigurationMo1036clone.keepNumberAsString;
        return xMLParserConfigurationMo1036clone;
    }

    public String getcDataTagName() {
        return this.cDataTagName;
    }

    public boolean isKeepNumberAsString() {
        return this.keepNumberAsString;
    }

    public boolean isKeepBooleanAsString() {
        return this.keepBooleanAsString;
    }

    public XMLParserConfiguration withcDataTagName(String str) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.cDataTagName = str;
        return xMLParserConfigurationMo1036clone;
    }

    public boolean isConvertNilAttributeToNull() {
        return this.convertNilAttributeToNull;
    }

    public XMLParserConfiguration withConvertNilAttributeToNull(boolean z) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.convertNilAttributeToNull = z;
        return xMLParserConfigurationMo1036clone;
    }

    public Map<String, XMLXsiTypeConverter<?>> getXsiTypeMap() {
        return this.xsiTypeMap;
    }

    public XMLParserConfiguration withXsiTypeMap(Map<String, XMLXsiTypeConverter<?>> map) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.xsiTypeMap = Collections.unmodifiableMap(new HashMap(map));
        return xMLParserConfigurationMo1036clone;
    }

    public Set<String> getForceList() {
        return this.forceList;
    }

    public XMLParserConfiguration withForceList(Set<String> set) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.forceList = Collections.unmodifiableSet(new HashSet(set));
        return xMLParserConfigurationMo1036clone;
    }

    @Override // org.json.ParserConfiguration
    public XMLParserConfiguration withMaxNestingDepth(int i) {
        return (XMLParserConfiguration) super.withMaxNestingDepth(i);
    }

    public XMLParserConfiguration withCloseEmptyTag(boolean z) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.closeEmptyTag = z;
        return xMLParserConfigurationMo1036clone;
    }

    public XMLParserConfiguration withShouldTrimWhitespace(boolean z) {
        XMLParserConfiguration xMLParserConfigurationMo1036clone = mo1036clone();
        xMLParserConfigurationMo1036clone.shouldTrimWhiteSpace = z;
        return xMLParserConfigurationMo1036clone;
    }

    public boolean isCloseEmptyTag() {
        return this.closeEmptyTag;
    }

    public boolean shouldTrimWhiteSpace() {
        return this.shouldTrimWhiteSpace;
    }
}

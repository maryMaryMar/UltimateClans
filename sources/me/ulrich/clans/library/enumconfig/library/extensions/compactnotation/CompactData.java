package me.ulrich.clans.library.enumconfig.library.extensions.compactnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/extensions/compactnotation/CompactData.class */
public class CompactData {
    private final String prefix;
    private final List<String> arguments = new ArrayList();
    private final Map<String, String> properties = new HashMap();

    public CompactData(String str) {
        this.prefix = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public List<String> getArguments() {
        return this.arguments;
    }

    public String toString() {
        return "CompactData: " + this.prefix + " " + this.properties;
    }
}

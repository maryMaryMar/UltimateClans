package me.ulrich.clans.library.enumconfig.library.parser;

import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/VersionTagsTuple.class */
class VersionTagsTuple {
    private final DumperOptions.Version version;
    private final Map<String, String> tags;

    public VersionTagsTuple(DumperOptions.Version version, Map<String, String> map) {
        this.version = version;
        this.tags = map;
    }

    public DumperOptions.Version getVersion() {
        return this.version;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public String toString() {
        return String.format("VersionTagsTuple<%s, %s>", this.version, this.tags);
    }
}

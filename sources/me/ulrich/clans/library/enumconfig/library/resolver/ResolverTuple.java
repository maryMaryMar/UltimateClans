package me.ulrich.clans.library.enumconfig.library.resolver;

import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/resolver/ResolverTuple.class */
final class ResolverTuple {
    private final Tag tag;
    private final Pattern regexp;
    private final int limit;

    public ResolverTuple(Tag tag, Pattern pattern, int i) {
        this.tag = tag;
        this.regexp = pattern;
        this.limit = i;
    }

    public Tag getTag() {
        return this.tag;
    }

    public Pattern getRegexp() {
        return this.regexp;
    }

    public int getLimit() {
        return this.limit;
    }

    public String toString() {
        return "Tuple tag=" + this.tag + " regexp=" + this.regexp + " limit=" + this.limit;
    }
}

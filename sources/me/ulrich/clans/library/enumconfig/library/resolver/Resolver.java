package me.ulrich.clans.library.enumconfig.library.resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeId;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/resolver/Resolver.class */
public class Resolver {
    public static final Pattern BOOL = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern FLOAT = Pattern.compile("^([-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+]?[0-9]+)?|[-+]?(?:[0-9][0-9_]*)(?:[eE][-+]?[0-9]+)|[-+]?\\.[0-9_]+(?:[eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern INT = Pattern.compile("^(?:[-+]?0b_*[0-1][0-1_]*|[-+]?0_*[0-7][0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F][0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern MERGE = Pattern.compile("^(?:<<)$");
    public static final Pattern NULL = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern EMPTY = Pattern.compile("^$");
    public static final Pattern TIMESTAMP = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern VALUE = Pattern.compile("^(?:=)$");
    public static final Pattern YAML = Pattern.compile("^(?:!|&|\\*)$");
    protected Map<Character, List<ResolverTuple>> yamlImplicitResolvers = new HashMap();

    protected void addImplicitResolvers() {
        addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO", 10);
        addImplicitResolver(Tag.INT, INT, "-+0123456789");
        addImplicitResolver(Tag.FLOAT, FLOAT, "-+0123456789.");
        addImplicitResolver(Tag.MERGE, MERGE, "<", 10);
        addImplicitResolver(Tag.NULL, NULL, "~nN\u0000", 10);
        addImplicitResolver(Tag.NULL, EMPTY, null, 10);
        addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789", 50);
        addImplicitResolver(Tag.YAML, YAML, "!&*", 10);
    }

    public Resolver() {
        addImplicitResolvers();
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str) {
        addImplicitResolver(tag, pattern, str, 1024);
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str, int i) {
        if (pattern == null) {
            throw new IllegalStateException("No pattern provided for Tag=" + tag);
        }
        if (str == null) {
            List<ResolverTuple> arrayList = this.yamlImplicitResolvers.get(null);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.yamlImplicitResolvers.put(null, arrayList);
            }
            arrayList.add(new ResolverTuple(tag, pattern, i));
            return;
        }
        for (char c : str.toCharArray()) {
            Character chValueOf = Character.valueOf(c);
            if (chValueOf.charValue() == 0) {
                chValueOf = null;
            }
            List<ResolverTuple> arrayList2 = this.yamlImplicitResolvers.get(chValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                this.yamlImplicitResolvers.put(chValueOf, arrayList2);
            }
            arrayList2.add(new ResolverTuple(tag, pattern, i));
        }
    }

    public Tag resolve(NodeId nodeId, String str, boolean z) {
        if (nodeId == NodeId.scalar && z) {
            List<ResolverTuple> list = str.isEmpty() ? this.yamlImplicitResolvers.get((char) 0) : this.yamlImplicitResolvers.get(Character.valueOf(str.charAt(0)));
            if (list != null) {
                for (ResolverTuple resolverTuple : list) {
                    Tag tag = resolverTuple.getTag();
                    Pattern regexp = resolverTuple.getRegexp();
                    if (str.length() <= resolverTuple.getLimit() && regexp.matcher(str).matches()) {
                        return tag;
                    }
                }
            }
            if (this.yamlImplicitResolvers.containsKey(null)) {
                for (ResolverTuple resolverTuple2 : this.yamlImplicitResolvers.get(null)) {
                    Tag tag2 = resolverTuple2.getTag();
                    Pattern regexp2 = resolverTuple2.getRegexp();
                    if (str.length() <= resolverTuple2.getLimit() && regexp2.matcher(str).matches()) {
                        return tag2;
                    }
                }
            }
        }
        switch (nodeId) {
            case scalar:
                return Tag.STR;
            case sequence:
                return Tag.SEQ;
            default:
                return Tag.MAP;
        }
    }
}

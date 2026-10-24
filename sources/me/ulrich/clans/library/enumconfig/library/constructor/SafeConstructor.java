package me.ulrich.clans.library.enumconfig.library.constructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.LoaderOptions;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.internal.Logger;
import me.ulrich.clans.library.enumconfig.library.nodes.MappingNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeId;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeTuple;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.SequenceNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor.class */
public class SafeConstructor extends BaseConstructor {
    private Logger log;
    private static final int[][] RADIX_MAX;
    private static final Pattern TIMESTAMP_REGEXP;
    private static final Pattern YMD_REGEXP;
    public static final ConstructUndefined undefinedConstructor = new ConstructUndefined();
    private static final Map<String, Boolean> BOOL_VALUES = new HashMap();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructUndefined.class */
    public static final class ConstructUndefined extends AbstractConstruct {
        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            throw new ConstructorException(null, null, "could not determine a constructor for the tag " + node.getTag(), node.getStartMark());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlBinary.class */
    public class ConstructYamlBinary extends AbstractConstruct {
        public ConstructYamlBinary() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            return Base64.getDecoder().decode(SafeConstructor.this.constructScalar((ScalarNode) node).replaceAll("\\s", ""));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlBool.class */
    public class ConstructYamlBool extends AbstractConstruct {
        public ConstructYamlBool() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            return SafeConstructor.BOOL_VALUES.get(SafeConstructor.this.constructScalar((ScalarNode) node).toLowerCase());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlFloat.class */
    public class ConstructYamlFloat extends AbstractConstruct {
        public ConstructYamlFloat() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            String strReplaceAll = SafeConstructor.this.constructScalar((ScalarNode) node).replaceAll("_", "");
            if (strReplaceAll.isEmpty()) {
                throw new ConstructorException("while constructing a float", node.getStartMark(), "found empty value", node.getStartMark());
            }
            int i = 1;
            char cCharAt = strReplaceAll.charAt(0);
            if (cCharAt == '-') {
                i = -1;
                strReplaceAll = strReplaceAll.substring(1);
            } else if (cCharAt == '+') {
                strReplaceAll = strReplaceAll.substring(1);
            }
            String lowerCase = strReplaceAll.toLowerCase();
            if (".inf".equals(lowerCase)) {
                return Double.valueOf(i == -1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            if (".nan".equals(lowerCase)) {
                return Double.valueOf(Double.NaN);
            }
            if (strReplaceAll.indexOf(58) == -1) {
                return Double.valueOf(Double.valueOf(strReplaceAll).doubleValue() * ((double) i));
            }
            String[] strArrSplit = strReplaceAll.split(":");
            int i2 = 1;
            double d = 0.0d;
            int length = strArrSplit.length;
            for (int i3 = 0; i3 < length; i3++) {
                d += Double.parseDouble(strArrSplit[(length - i3) - 1]) * ((double) i2);
                i2 *= 60;
            }
            return Double.valueOf(((double) i) * d);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlInt.class */
    public class ConstructYamlInt extends AbstractConstruct {
        public ConstructYamlInt() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            String strSubstring;
            int i;
            String strReplace = SafeConstructor.this.constructScalar((ScalarNode) node).replace("_", "");
            if (strReplace.isEmpty()) {
                throw new ConstructorException("while constructing an int", node.getStartMark(), "found empty value", node.getStartMark());
            }
            int i2 = 1;
            char cCharAt = strReplace.charAt(0);
            if (cCharAt == '-') {
                i2 = -1;
                strReplace = strReplace.substring(1);
            } else if (cCharAt == '+') {
                strReplace = strReplace.substring(1);
            }
            if ("0".equals(strReplace)) {
                return 0;
            }
            if (strReplace.startsWith("0b")) {
                strSubstring = strReplace.substring(2);
                i = 2;
            } else if (strReplace.startsWith("0x")) {
                strSubstring = strReplace.substring(2);
                i = 16;
            } else {
                if (!strReplace.startsWith("0")) {
                    if (strReplace.indexOf(58) == -1) {
                        return SafeConstructor.this.createNumber(i2, strReplace, 10);
                    }
                    String[] strArrSplit = strReplace.split(":");
                    int i3 = 1;
                    int i4 = 0;
                    int length = strArrSplit.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        i4 = (int) (((long) i4) + (Long.parseLong(strArrSplit[(length - i5) - 1]) * ((long) i3)));
                        i3 *= 60;
                    }
                    return SafeConstructor.this.createNumber(i2, String.valueOf(i4), 10);
                }
                strSubstring = strReplace.substring(1);
                i = 8;
            }
            return SafeConstructor.this.createNumber(i2, strSubstring, i);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlMap.class */
    public class ConstructYamlMap implements Construct {
        public ConstructYamlMap() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            return node.isTwoStepsConstruction() ? SafeConstructor.this.createDefaultMap(mappingNode.getValue().size()) : SafeConstructor.this.constructMapping(mappingNode);
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (!node.isTwoStepsConstruction()) {
                throw new YAMLException("Unexpected recursive mapping structure. Node: " + node);
            }
            SafeConstructor.this.constructMapping2ndStep((MappingNode) node, (Map) obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlNull.class */
    public class ConstructYamlNull extends AbstractConstruct {
        public ConstructYamlNull() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            if (node == null) {
                return null;
            }
            SafeConstructor.this.constructScalar((ScalarNode) node);
            return null;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlOmap.class */
    public class ConstructYamlOmap extends AbstractConstruct {
        public ConstructYamlOmap() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!(node instanceof SequenceNode)) {
                throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
            }
            for (Node node2 : ((SequenceNode) node).getValue()) {
                if (!(node2 instanceof MappingNode)) {
                    throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a mapping of length 1, but found " + node2.getNodeId(), node2.getStartMark());
                }
                MappingNode mappingNode = (MappingNode) node2;
                if (mappingNode.getValue().size() != 1) {
                    throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a single mapping item, but found " + mappingNode.getValue().size() + " items", mappingNode.getStartMark());
                }
                linkedHashMap.put(SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getKeyNode()), SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getValueNode()));
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlPairs.class */
    public class ConstructYamlPairs extends AbstractConstruct {
        public ConstructYamlPairs() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            if (!(node instanceof SequenceNode)) {
                throw new ConstructorException("while constructing pairs", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
            }
            SequenceNode sequenceNode = (SequenceNode) node;
            ArrayList arrayList = new ArrayList(sequenceNode.getValue().size());
            for (Node node2 : sequenceNode.getValue()) {
                if (!(node2 instanceof MappingNode)) {
                    throw new ConstructorException("while constructingpairs", node.getStartMark(), "expected a mapping of length 1, but found " + node2.getNodeId(), node2.getStartMark());
                }
                MappingNode mappingNode = (MappingNode) node2;
                if (mappingNode.getValue().size() != 1) {
                    throw new ConstructorException("while constructing pairs", node.getStartMark(), "expected a single mapping item, but found " + mappingNode.getValue().size() + " items", mappingNode.getStartMark());
                }
                arrayList.add(new Object[]{SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getKeyNode()), SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getValueNode())});
            }
            return arrayList;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlSeq.class */
    public class ConstructYamlSeq implements Construct {
        public ConstructYamlSeq() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            SequenceNode sequenceNode = (SequenceNode) node;
            return node.isTwoStepsConstruction() ? SafeConstructor.this.newList(sequenceNode) : SafeConstructor.this.constructSequence(sequenceNode);
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (!node.isTwoStepsConstruction()) {
                throw new YAMLException("Unexpected recursive sequence structure. Node: " + node);
            }
            SafeConstructor.this.constructSequenceStep2((SequenceNode) node, (List) obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlSet.class */
    public class ConstructYamlSet implements Construct {
        public ConstructYamlSet() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            if (node.isTwoStepsConstruction()) {
                return SafeConstructor.this.constructedObjects.containsKey(node) ? SafeConstructor.this.constructedObjects.get(node) : SafeConstructor.this.createDefaultSet(((MappingNode) node).getValue().size());
            }
            return SafeConstructor.this.constructSet((MappingNode) node);
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (!node.isTwoStepsConstruction()) {
                throw new YAMLException("Unexpected recursive set structure. Node: " + node);
            }
            SafeConstructor.this.constructSet2ndStep((MappingNode) node, (Set) obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlStr.class */
    public class ConstructYamlStr extends AbstractConstruct {
        public ConstructYamlStr() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            return SafeConstructor.this.constructScalar((ScalarNode) node);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/SafeConstructor$ConstructYamlTimestamp.class */
    public static class ConstructYamlTimestamp extends AbstractConstruct {
        private Calendar calendar;

        public Calendar getCalendar() {
            return this.calendar;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            TimeZone timeZone;
            String value = ((ScalarNode) node).getValue();
            Matcher matcher = SafeConstructor.YMD_REGEXP.matcher(value);
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                String strGroup2 = matcher.group(2);
                String strGroup3 = matcher.group(3);
                this.calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                this.calendar.clear();
                this.calendar.set(1, Integer.parseInt(strGroup));
                this.calendar.set(2, Integer.parseInt(strGroup2) - 1);
                this.calendar.set(5, Integer.parseInt(strGroup3));
                return this.calendar.getTime();
            }
            Matcher matcher2 = SafeConstructor.TIMESTAMP_REGEXP.matcher(value);
            if (!matcher2.matches()) {
                throw new YAMLException("Unexpected timestamp: " + value);
            }
            String strGroup4 = matcher2.group(1);
            String strGroup5 = matcher2.group(2);
            String strGroup6 = matcher2.group(3);
            String strGroup7 = matcher2.group(4);
            String strGroup8 = matcher2.group(5);
            String strGroup9 = matcher2.group(6);
            String strGroup10 = matcher2.group(7);
            if (strGroup10 != null) {
                strGroup9 = strGroup9 + "." + strGroup10;
            }
            double d = Double.parseDouble(strGroup9);
            int iRound = (int) Math.round(Math.floor(d));
            int iRound2 = (int) Math.round((d - ((double) iRound)) * 1000.0d);
            String strGroup11 = matcher2.group(8);
            String strGroup12 = matcher2.group(9);
            if (strGroup11 != null) {
                timeZone = TimeZone.getTimeZone("GMT" + strGroup11 + (strGroup12 != null ? ":" + strGroup12 : "00"));
            } else {
                timeZone = TimeZone.getTimeZone("UTC");
            }
            this.calendar = Calendar.getInstance(timeZone);
            this.calendar.set(1, Integer.parseInt(strGroup4));
            this.calendar.set(2, Integer.parseInt(strGroup5) - 1);
            this.calendar.set(5, Integer.parseInt(strGroup6));
            this.calendar.set(11, Integer.parseInt(strGroup7));
            this.calendar.set(12, Integer.parseInt(strGroup8));
            this.calendar.set(13, iRound);
            this.calendar.set(14, iRound2);
            return this.calendar.getTime();
        }
    }

    public SafeConstructor(LoaderOptions loaderOptions) {
        super(loaderOptions);
        this.log = Logger.getLogger(getClass().getName());
        this.yamlConstructors.put(Tag.NULL, new ConstructYamlNull());
        this.yamlConstructors.put(Tag.BOOL, new ConstructYamlBool());
        this.yamlConstructors.put(Tag.INT, new ConstructYamlInt());
        this.yamlConstructors.put(Tag.FLOAT, new ConstructYamlFloat());
        this.yamlConstructors.put(Tag.BINARY, new ConstructYamlBinary());
        this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructYamlTimestamp());
        this.yamlConstructors.put(Tag.OMAP, new ConstructYamlOmap());
        this.yamlConstructors.put(Tag.PAIRS, new ConstructYamlPairs());
        this.yamlConstructors.put(Tag.SET, new ConstructYamlSet());
        this.yamlConstructors.put(Tag.STR, new ConstructYamlStr());
        this.yamlConstructors.put(Tag.SEQ, new ConstructYamlSeq());
        this.yamlConstructors.put(Tag.MAP, new ConstructYamlMap());
        this.yamlConstructors.put(null, undefinedConstructor);
        this.yamlClassConstructors.put(NodeId.scalar, undefinedConstructor);
        this.yamlClassConstructors.put(NodeId.sequence, undefinedConstructor);
        this.yamlClassConstructors.put(NodeId.mapping, undefinedConstructor);
    }

    protected void flattenMapping(MappingNode mappingNode) {
        flattenMapping(mappingNode, false);
    }

    protected void flattenMapping(MappingNode mappingNode, boolean z) {
        processDuplicateKeys(mappingNode, z);
        if (mappingNode.isMerged()) {
            mappingNode.setValue(mergeNode(mappingNode, true, new HashMap(), new ArrayList(), z));
        }
    }

    protected void processDuplicateKeys(MappingNode mappingNode) {
        processDuplicateKeys(mappingNode, false);
    }

    protected void processDuplicateKeys(MappingNode mappingNode, boolean z) {
        List<NodeTuple> value = mappingNode.getValue();
        HashMap map = new HashMap(value.size());
        TreeSet treeSet = new TreeSet();
        int i = 0;
        for (NodeTuple nodeTuple : value) {
            Node keyNode = nodeTuple.getKeyNode();
            if (!keyNode.getTag().equals(Tag.MERGE)) {
                if (z) {
                    if (!(keyNode instanceof ScalarNode)) {
                        throw new YAMLException("Keys must be scalars but found: " + keyNode);
                    }
                    keyNode.setType(String.class);
                    keyNode.setTag(Tag.STR);
                }
                Object objConstructObject = constructObject(keyNode);
                if (objConstructObject != null && !z && keyNode.isTwoStepsConstruction()) {
                    if (!this.loadingConfig.getAllowRecursiveKeys()) {
                        throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                    }
                    try {
                        objConstructObject.hashCode();
                    } catch (Exception e) {
                        throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e);
                    }
                }
                Integer num = (Integer) map.put(objConstructObject, Integer.valueOf(i));
                if (num == null) {
                    continue;
                } else {
                    if (!isAllowDuplicateKeys()) {
                        throw new DuplicateKeyException(mappingNode.getStartMark(), objConstructObject, nodeTuple.getKeyNode().getStartMark());
                    }
                    if (isWarnOnDuplicateKeys() && this.log.isLoggable(Logger.Level.WARNING)) {
                        this.log.warn(String.format("duplicate keys found : %s", objConstructObject));
                    }
                    treeSet.add(num);
                }
            }
            i++;
        }
        Iterator itDescendingIterator = treeSet.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            value.remove(((Integer) itDescendingIterator.next()).intValue());
        }
    }

    private List<NodeTuple> mergeNode(MappingNode mappingNode, boolean z, Map<Object, Integer> map, List<NodeTuple> list, boolean z2) {
        Iterator<NodeTuple> it = mappingNode.getValue().iterator();
        while (it.hasNext()) {
            NodeTuple next = it.next();
            Node keyNode = next.getKeyNode();
            Node valueNode = next.getValueNode();
            if (keyNode.getTag().equals(Tag.MERGE)) {
                it.remove();
                switch (valueNode.getNodeId()) {
                    case mapping:
                        mergeNode((MappingNode) valueNode, false, map, list, z2);
                        break;
                    case sequence:
                        for (Node node : ((SequenceNode) valueNode).getValue()) {
                            if (!(node instanceof MappingNode)) {
                                throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "expected a mapping for merging, but found " + node.getNodeId(), node.getStartMark());
                            }
                            mergeNode((MappingNode) node, false, map, list, z2);
                        }
                        break;
                    default:
                        throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "expected a mapping or list of mappings for merging, but found " + valueNode.getNodeId(), valueNode.getStartMark());
                }
            } else {
                if (z2) {
                    if (!(keyNode instanceof ScalarNode)) {
                        throw new YAMLException("Keys must be scalars but found: " + keyNode);
                    }
                    keyNode.setType(String.class);
                    keyNode.setTag(Tag.STR);
                }
                Object objConstructObject = constructObject(keyNode);
                if (!map.containsKey(objConstructObject)) {
                    list.add(next);
                    map.put(objConstructObject, Integer.valueOf(list.size() - 1));
                } else if (z) {
                    list.set(map.get(objConstructObject).intValue(), next);
                }
            }
        }
        return list;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.constructor.BaseConstructor
    protected void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        flattenMapping(mappingNode);
        super.constructMapping2ndStep(mappingNode, map);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.constructor.BaseConstructor
    protected void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        flattenMapping(mappingNode);
        super.constructSet2ndStep(mappingNode, set);
    }

    private static int maxLen(int i, int i2) {
        return Integer.toString(i, i2).length();
    }

    private static int maxLen(long j, int i) {
        return Long.toString(j, i).length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Number createNumber(int i, String str, int i2) {
        Number numberCreateLongOrBigInteger;
        int length = str != null ? str.length() : 0;
        if (i < 0) {
            str = "-" + str;
        }
        int[] iArr = i2 < RADIX_MAX.length ? RADIX_MAX[i2] : null;
        if (iArr != null) {
            if (length > iArr[0]) {
                return length > iArr[1] ? new BigInteger(str, i2) : createLongOrBigInteger(str, i2);
            }
        }
        try {
            numberCreateLongOrBigInteger = Integer.valueOf(str, i2);
        } catch (NumberFormatException e) {
            numberCreateLongOrBigInteger = createLongOrBigInteger(str, i2);
        }
        return numberCreateLongOrBigInteger;
    }

    protected static Number createLongOrBigInteger(String str, int i) {
        try {
            return Long.valueOf(str, i);
        } catch (NumberFormatException e) {
            return new BigInteger(str, i);
        }
    }

    static {
        BOOL_VALUES.put("yes", Boolean.TRUE);
        BOOL_VALUES.put("no", Boolean.FALSE);
        BOOL_VALUES.put("true", Boolean.TRUE);
        BOOL_VALUES.put("false", Boolean.FALSE);
        BOOL_VALUES.put("on", Boolean.TRUE);
        BOOL_VALUES.put("off", Boolean.FALSE);
        RADIX_MAX = new int[17][2];
        for (int i : new int[]{2, 8, 10, 16}) {
            RADIX_MAX[i] = new int[]{maxLen(Integer.MAX_VALUE, i), maxLen(Long.MAX_VALUE, i)};
        }
        TIMESTAMP_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
        YMD_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
    }
}

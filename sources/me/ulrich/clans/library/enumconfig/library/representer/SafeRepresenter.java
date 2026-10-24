package me.ulrich.clans.library.enumconfig.library.representer;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;
import me.ulrich.clans.library.enumconfig.library.reader.StreamReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter.class */
public class SafeRepresenter extends BaseRepresenter {
    protected Map<Class<? extends Object>, Tag> classTags;
    protected TimeZone timeZone = null;
    protected DumperOptions.NonPrintableStyle nonPrintableStyle;
    private static final Pattern MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$IteratorWrapper.class */
    private static class IteratorWrapper implements Iterable<Object> {
        private final Iterator<Object> iter;

        public IteratorWrapper(Iterator<Object> it) {
            this.iter = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.iter;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentArray.class */
    protected class RepresentArray implements Represent {
        protected RepresentArray() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(Tag.SEQ, Arrays.asList((Object[]) obj), DumperOptions.FlowStyle.AUTO);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentBoolean.class */
    protected class RepresentBoolean implements Represent {
        protected RepresentBoolean() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BOOL, Boolean.TRUE.equals(obj) ? "true" : "false");
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentByteArray.class */
    protected class RepresentByteArray implements Represent {
        protected RepresentByteArray() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(Base64.getEncoder().encodeToString((byte[]) obj)), DumperOptions.ScalarStyle.LITERAL);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentDate.class */
    protected class RepresentDate implements Represent {
        protected RepresentDate() {
        }

        public Tag getDefaultTag() {
            return Tag.TIMESTAMP;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            Calendar calendar;
            if (obj instanceof Calendar) {
                calendar = (Calendar) obj;
            } else {
                calendar = Calendar.getInstance(SafeRepresenter.this.getTimeZone() == null ? TimeZone.getTimeZone("UTC") : SafeRepresenter.this.timeZone);
                calendar.setTime((Date) obj);
            }
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            int i3 = calendar.get(5);
            int i4 = calendar.get(11);
            int i5 = calendar.get(12);
            int i6 = calendar.get(13);
            int i7 = calendar.get(14);
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            while (sb.length() < 4) {
                sb.insert(0, "0");
            }
            sb.append("-");
            if (i2 < 10) {
                sb.append("0");
            }
            sb.append(i2);
            sb.append("-");
            if (i3 < 10) {
                sb.append("0");
            }
            sb.append(i3);
            sb.append("T");
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(i4);
            sb.append(":");
            if (i5 < 10) {
                sb.append("0");
            }
            sb.append(i5);
            sb.append(":");
            if (i6 < 10) {
                sb.append("0");
            }
            sb.append(i6);
            if (i7 > 0) {
                if (i7 < 10) {
                    sb.append(".00");
                } else if (i7 < 100) {
                    sb.append(".0");
                } else {
                    sb.append(".");
                }
                sb.append(i7);
            }
            int offset = calendar.getTimeZone().getOffset(calendar.getTime().getTime());
            if (offset == 0) {
                sb.append('Z');
            } else {
                if (offset < 0) {
                    sb.append('-');
                    offset *= -1;
                } else {
                    sb.append('+');
                }
                int i8 = offset / 60000;
                int i9 = i8 / 60;
                int i10 = i8 % 60;
                if (i9 < 10) {
                    sb.append('0');
                }
                sb.append(i9);
                sb.append(':');
                if (i10 < 10) {
                    sb.append('0');
                }
                sb.append(i10);
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), getDefaultTag()), sb.toString());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentEnum.class */
    protected class RepresentEnum implements Represent {
        protected RepresentEnum() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), new Tag((Class<? extends Object>) obj.getClass())), ((Enum) obj).name());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentIterator.class */
    protected class RepresentIterator implements Represent {
        protected RepresentIterator() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(obj.getClass(), Tag.SEQ), new IteratorWrapper((Iterator) obj), DumperOptions.FlowStyle.AUTO);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentList.class */
    protected class RepresentList implements Represent {
        protected RepresentList() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(obj.getClass(), Tag.SEQ), (List) obj, DumperOptions.FlowStyle.AUTO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentMap.class */
    public class RepresentMap implements Represent {
        protected RepresentMap() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(obj.getClass(), Tag.MAP), (Map) obj, DumperOptions.FlowStyle.AUTO);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentNull.class */
    protected class RepresentNull implements Represent {
        protected RepresentNull() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.NULL, "null");
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentNumber.class */
    protected class RepresentNumber implements Represent {
        protected RepresentNumber() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            Tag tag;
            String string;
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                tag = Tag.INT;
                string = obj.toString();
            } else {
                Number number = (Number) obj;
                tag = Tag.FLOAT;
                if (number.equals(Double.valueOf(Double.NaN))) {
                    string = ".NaN";
                } else if (number.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                    string = ".inf";
                } else {
                    string = number.equals(Double.valueOf(Double.NEGATIVE_INFINITY)) ? "-.inf" : number.toString();
                }
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), tag), string);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentPrimitiveArray.class */
    protected class RepresentPrimitiveArray implements Represent {
        protected RepresentPrimitiveArray() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (Byte.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asByteList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Short.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asShortList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Integer.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asIntList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Long.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asLongList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Float.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asFloatList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Double.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asDoubleList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Character.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asCharList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Boolean.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asBooleanList(obj), DumperOptions.FlowStyle.AUTO);
            }
            throw new YAMLException("Unexpected primitive '" + componentType.getCanonicalName() + "'");
        }

        private List<Byte> asByteList(Object obj) {
            byte[] bArr = (byte[]) obj;
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte b : bArr) {
                arrayList.add(Byte.valueOf(b));
            }
            return arrayList;
        }

        private List<Short> asShortList(Object obj) {
            short[] sArr = (short[]) obj;
            ArrayList arrayList = new ArrayList(sArr.length);
            for (short s : sArr) {
                arrayList.add(Short.valueOf(s));
            }
            return arrayList;
        }

        private List<Integer> asIntList(Object obj) {
            int[] iArr = (int[]) obj;
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(i));
            }
            return arrayList;
        }

        private List<Long> asLongList(Object obj) {
            long[] jArr = (long[]) obj;
            ArrayList arrayList = new ArrayList(jArr.length);
            for (long j : jArr) {
                arrayList.add(Long.valueOf(j));
            }
            return arrayList;
        }

        private List<Float> asFloatList(Object obj) {
            float[] fArr = (float[]) obj;
            ArrayList arrayList = new ArrayList(fArr.length);
            for (float f : fArr) {
                arrayList.add(Float.valueOf(f));
            }
            return arrayList;
        }

        private List<Double> asDoubleList(Object obj) {
            double[] dArr = (double[]) obj;
            ArrayList arrayList = new ArrayList(dArr.length);
            for (double d : dArr) {
                arrayList.add(Double.valueOf(d));
            }
            return arrayList;
        }

        private List<Character> asCharList(Object obj) {
            char[] cArr = (char[]) obj;
            ArrayList arrayList = new ArrayList(cArr.length);
            for (char c : cArr) {
                arrayList.add(Character.valueOf(c));
            }
            return arrayList;
        }

        private List<Boolean> asBooleanList(Object obj) {
            boolean[] zArr = (boolean[]) obj;
            ArrayList arrayList = new ArrayList(zArr.length);
            for (boolean z : zArr) {
                arrayList.add(Boolean.valueOf(z));
            }
            return arrayList;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentSet.class */
    protected class RepresentSet implements Represent {
        protected RepresentSet() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), null);
            }
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(obj.getClass(), Tag.SET), linkedHashMap, DumperOptions.FlowStyle.AUTO);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentString.class */
    protected class RepresentString implements Represent {
        protected RepresentString() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            Tag tag = Tag.STR;
            DumperOptions.ScalarStyle scalarStyle = SafeRepresenter.this.defaultScalarStyle;
            String string = obj.toString();
            if (SafeRepresenter.this.nonPrintableStyle == DumperOptions.NonPrintableStyle.BINARY && !StreamReader.isPrintable(string)) {
                tag = Tag.BINARY;
                byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
                if (!new String(bytes, StandardCharsets.UTF_8).equals(string)) {
                    throw new YAMLException("invalid string value has occurred");
                }
                string = Base64.getEncoder().encodeToString(bytes);
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            if (SafeRepresenter.this.defaultScalarStyle == DumperOptions.ScalarStyle.PLAIN && SafeRepresenter.MULTILINE_PATTERN.matcher(string).find()) {
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            return SafeRepresenter.this.representScalar(tag, string, scalarStyle);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/SafeRepresenter$RepresentUuid.class */
    protected class RepresentUuid implements Represent {
        protected RepresentUuid() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), new Tag((Class<? extends Object>) UUID.class)), obj.toString());
        }
    }

    public SafeRepresenter(DumperOptions dumperOptions) {
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.nullRepresenter = new RepresentNull();
        this.representers.put(String.class, new RepresentString());
        this.representers.put(Boolean.class, new RepresentBoolean());
        this.representers.put(Character.class, new RepresentString());
        this.representers.put(UUID.class, new RepresentUuid());
        this.representers.put(byte[].class, new RepresentByteArray());
        RepresentPrimitiveArray representPrimitiveArray = new RepresentPrimitiveArray();
        this.representers.put(short[].class, representPrimitiveArray);
        this.representers.put(int[].class, representPrimitiveArray);
        this.representers.put(long[].class, representPrimitiveArray);
        this.representers.put(float[].class, representPrimitiveArray);
        this.representers.put(double[].class, representPrimitiveArray);
        this.representers.put(char[].class, representPrimitiveArray);
        this.representers.put(boolean[].class, representPrimitiveArray);
        this.multiRepresenters.put(Number.class, new RepresentNumber());
        this.multiRepresenters.put(List.class, new RepresentList());
        this.multiRepresenters.put(Map.class, new RepresentMap());
        this.multiRepresenters.put(Set.class, new RepresentSet());
        this.multiRepresenters.put(Iterator.class, new RepresentIterator());
        this.multiRepresenters.put(new Object[0].getClass(), new RepresentArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        this.multiRepresenters.put(Enum.class, new RepresentEnum());
        this.multiRepresenters.put(Calendar.class, new RepresentDate());
        this.classTags = new HashMap();
        this.nonPrintableStyle = dumperOptions.getNonPrintableStyle();
        setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
        setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
    }

    protected Tag getTag(Class<?> cls, Tag tag) {
        return this.classTags.containsKey(cls) ? this.classTags.get(cls) : tag;
    }

    public Tag addClassTag(Class<? extends Object> cls, Tag tag) {
        if (tag == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        return this.classTags.put(cls, tag);
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}

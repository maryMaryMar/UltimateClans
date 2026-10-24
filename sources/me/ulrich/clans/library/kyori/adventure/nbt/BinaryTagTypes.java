package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagTypes.class */
public final class BinaryTagTypes {
    public static final BinaryTagType<EndBinaryTag> END = BinaryTagType.register(EndBinaryTag.class, (byte) 0, dataInput -> {
        return EndBinaryTag.endBinaryTag();
    }, null);
    public static final BinaryTagType<ByteBinaryTag> BYTE = BinaryTagType.registerNumeric(ByteBinaryTag.class, (byte) 1, dataInput -> {
        return ByteBinaryTag.byteBinaryTag(dataInput.readByte());
    }, (byteBinaryTag, dataOutput) -> {
        dataOutput.writeByte(byteBinaryTag.value());
    });
    public static final BinaryTagType<ShortBinaryTag> SHORT = BinaryTagType.registerNumeric(ShortBinaryTag.class, (byte) 2, dataInput -> {
        return ShortBinaryTag.shortBinaryTag(dataInput.readShort());
    }, (shortBinaryTag, dataOutput) -> {
        dataOutput.writeShort(shortBinaryTag.value());
    });
    public static final BinaryTagType<IntBinaryTag> INT = BinaryTagType.registerNumeric(IntBinaryTag.class, (byte) 3, dataInput -> {
        return IntBinaryTag.intBinaryTag(dataInput.readInt());
    }, (intBinaryTag, dataOutput) -> {
        dataOutput.writeInt(intBinaryTag.value());
    });
    public static final BinaryTagType<LongBinaryTag> LONG = BinaryTagType.registerNumeric(LongBinaryTag.class, (byte) 4, dataInput -> {
        return LongBinaryTag.longBinaryTag(dataInput.readLong());
    }, (longBinaryTag, dataOutput) -> {
        dataOutput.writeLong(longBinaryTag.value());
    });
    public static final BinaryTagType<FloatBinaryTag> FLOAT = BinaryTagType.registerNumeric(FloatBinaryTag.class, (byte) 5, dataInput -> {
        return FloatBinaryTag.floatBinaryTag(dataInput.readFloat());
    }, (floatBinaryTag, dataOutput) -> {
        dataOutput.writeFloat(floatBinaryTag.value());
    });
    public static final BinaryTagType<DoubleBinaryTag> DOUBLE = BinaryTagType.registerNumeric(DoubleBinaryTag.class, (byte) 6, dataInput -> {
        return DoubleBinaryTag.doubleBinaryTag(dataInput.readDouble());
    }, (doubleBinaryTag, dataOutput) -> {
        dataOutput.writeDouble(doubleBinaryTag.value());
    });
    public static final BinaryTagType<ByteArrayBinaryTag> BYTE_ARRAY = BinaryTagType.register(ByteArrayBinaryTag.class, (byte) 7, dataInput -> {
        int i = dataInput.readInt();
        BinaryTagScope binaryTagScopeEnter = TrackingDataInput.enter(dataInput, i);
        try {
            byte[] bArr = new byte[i];
            dataInput.readFully(bArr);
            ByteArrayBinaryTag byteArrayBinaryTag = ByteArrayBinaryTag.byteArrayBinaryTag(bArr);
            if (binaryTagScopeEnter != null) {
                binaryTagScopeEnter.close();
            }
            return byteArrayBinaryTag;
        } catch (Throwable th) {
            if (binaryTagScopeEnter != null) {
                try {
                    binaryTagScopeEnter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }, (byteArrayBinaryTag, dataOutput) -> {
        byte[] bArrValue = ByteArrayBinaryTagImpl.value(byteArrayBinaryTag);
        dataOutput.writeInt(bArrValue.length);
        dataOutput.write(bArrValue);
    });
    public static final BinaryTagType<StringBinaryTag> STRING = BinaryTagType.register(StringBinaryTag.class, (byte) 8, dataInput -> {
        return StringBinaryTag.stringBinaryTag(dataInput.readUTF());
    }, (stringBinaryTag, dataOutput) -> {
        dataOutput.writeUTF(stringBinaryTag.value());
    });
    public static final BinaryTagType<ListBinaryTag> LIST = BinaryTagType.register(ListBinaryTag.class, (byte) 9, dataInput -> {
        BinaryTagType<? extends BinaryTag> binaryTagType = BinaryTagType.binaryTagType(dataInput.readByte());
        int i = dataInput.readInt();
        BinaryTagScope binaryTagScopeEnter = TrackingDataInput.enter(dataInput, ((long) i) * 8);
        try {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(binaryTagType.read(dataInput));
            }
            ListBinaryTag listBinaryTag = ListBinaryTag.listBinaryTag(binaryTagType, arrayList);
            if (binaryTagScopeEnter != null) {
                binaryTagScopeEnter.close();
            }
            return listBinaryTag;
        } catch (Throwable th) {
            if (binaryTagScopeEnter != null) {
                try {
                    binaryTagScopeEnter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }, (listBinaryTag, dataOutput) -> {
        ListBinaryTag listBinaryTagWrapHeterogeneity = listBinaryTag.wrapHeterogeneity();
        dataOutput.writeByte(listBinaryTagWrapHeterogeneity.elementType().id());
        dataOutput.writeInt(listBinaryTagWrapHeterogeneity.size());
        for (BinaryTag binaryTag : listBinaryTagWrapHeterogeneity) {
            BinaryTagType.writeUntyped(binaryTag.type(), binaryTag, dataOutput);
        }
    });
    public static final BinaryTagType<CompoundBinaryTag> COMPOUND = BinaryTagType.register(CompoundBinaryTag.class, (byte) 10, dataInput -> {
        BinaryTagScope binaryTagScopeEnter = TrackingDataInput.enter(dataInput);
        try {
            HashMap map = new HashMap();
            while (true) {
                BinaryTagType<? extends BinaryTag> binaryTagType = BinaryTagType.binaryTagType(dataInput.readByte());
                if (binaryTagType == END) {
                    break;
                }
                map.put(dataInput.readUTF(), binaryTagType.read(dataInput));
            }
            CompoundBinaryTagImpl compoundBinaryTagImpl = new CompoundBinaryTagImpl(map);
            if (binaryTagScopeEnter != null) {
                binaryTagScopeEnter.close();
            }
            return compoundBinaryTagImpl;
        } catch (Throwable th) {
            if (binaryTagScopeEnter != null) {
                try {
                    binaryTagScopeEnter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }, (compoundBinaryTag, dataOutput) -> {
        for (Map.Entry<String, ? extends BinaryTag> entry : compoundBinaryTag) {
            BinaryTag value = entry.getValue();
            if (value != null) {
                BinaryTagType<? extends BinaryTag> binaryTagTypeType = value.type();
                dataOutput.writeByte(binaryTagTypeType.id());
                if (binaryTagTypeType != END) {
                    dataOutput.writeUTF(entry.getKey());
                    BinaryTagType.writeUntyped(binaryTagTypeType, value, dataOutput);
                }
            }
        }
        dataOutput.writeByte(END.id());
    });
    public static final BinaryTagType<IntArrayBinaryTag> INT_ARRAY = BinaryTagType.register(IntArrayBinaryTag.class, (byte) 11, dataInput -> {
        int i = dataInput.readInt();
        BinaryTagScope binaryTagScopeEnter = TrackingDataInput.enter(dataInput, ((long) i) * 4);
        try {
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = dataInput.readInt();
            }
            IntArrayBinaryTag intArrayBinaryTag = IntArrayBinaryTag.intArrayBinaryTag(iArr);
            if (binaryTagScopeEnter != null) {
                binaryTagScopeEnter.close();
            }
            return intArrayBinaryTag;
        } catch (Throwable th) {
            if (binaryTagScopeEnter != null) {
                try {
                    binaryTagScopeEnter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }, (intArrayBinaryTag, dataOutput) -> {
        int[] iArrValue = IntArrayBinaryTagImpl.value(intArrayBinaryTag);
        dataOutput.writeInt(iArrValue.length);
        for (int i : iArrValue) {
            dataOutput.writeInt(i);
        }
    });
    public static final BinaryTagType<LongArrayBinaryTag> LONG_ARRAY = BinaryTagType.register(LongArrayBinaryTag.class, (byte) 12, dataInput -> {
        int i = dataInput.readInt();
        BinaryTagScope binaryTagScopeEnter = TrackingDataInput.enter(dataInput, ((long) i) * 8);
        try {
            long[] jArr = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                jArr[i2] = dataInput.readLong();
            }
            LongArrayBinaryTag longArrayBinaryTag = LongArrayBinaryTag.longArrayBinaryTag(jArr);
            if (binaryTagScopeEnter != null) {
                binaryTagScopeEnter.close();
            }
            return longArrayBinaryTag;
        } catch (Throwable th) {
            if (binaryTagScopeEnter != null) {
                try {
                    binaryTagScopeEnter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }, (longArrayBinaryTag, dataOutput) -> {
        long[] jArrValue = LongArrayBinaryTagImpl.value(longArrayBinaryTag);
        dataOutput.writeInt(jArrValue.length);
        for (long j : jArrValue) {
            dataOutput.writeLong(j);
        }
    });
    public static final BinaryTagType<BinaryTag> LIST_WILDCARD = new BinaryTagType.Impl(BinaryTag.class, (byte) 127, dataInput -> {
        throw new IllegalArgumentException("Unable to read values of placeholder type. This tag type exists only to indicate heterogeneous lists");
    }, (binaryTag, dataOutput) -> {
        throw new IllegalArgumentException("Unable to write values of placeholder type. This tag type exists only to indicate heterogeneous lists");
    });

    private BinaryTagTypes() {
    }
}

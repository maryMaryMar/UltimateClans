package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ListBinaryTag.class */
public interface ListBinaryTag extends Iterable<BinaryTag>, BinaryTag, ListTagSetter<ListBinaryTag, BinaryTag> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ListBinaryTag$Builder.class */
    public interface Builder<T extends BinaryTag> extends ListTagSetter<Builder<T>, T> {
        @NotNull
        ListBinaryTag build();
    }

    @NotNull
    static ListBinaryTag empty() {
        return ListBinaryTagImpl.EMPTY;
    }

    @NotNull
    static ListBinaryTag from(@NotNull Iterable<? extends BinaryTag> iterable) {
        return builder().add(iterable).build();
    }

    @NotNull
    static Builder<BinaryTag> builder() {
        return new ListTagBuilder(false);
    }

    @NotNull
    static Builder<BinaryTag> heterogeneousListBinaryTag() {
        return new ListTagBuilder(true);
    }

    @NotNull
    static <T extends BinaryTag> Builder<T> builder(@NotNull BinaryTagType<T> binaryTagType) {
        if (binaryTagType == BinaryTagTypes.END) {
            throw new IllegalArgumentException("Cannot create a list of " + BinaryTagTypes.END);
        }
        return new ListTagBuilder(false, binaryTagType);
    }

    @NotNull
    static ListBinaryTag listBinaryTag(@NotNull BinaryTagType<? extends BinaryTag> binaryTagType, @NotNull List<BinaryTag> list) {
        if (list.isEmpty()) {
            return empty();
        }
        if (binaryTagType == BinaryTagTypes.END) {
            throw new IllegalArgumentException("Cannot create a list of " + BinaryTagTypes.END);
        }
        ListBinaryTagImpl.validateTagType(list, binaryTagType == BinaryTagTypes.LIST_WILDCARD);
        return new ListBinaryTagImpl(binaryTagType, binaryTagType == BinaryTagTypes.LIST_WILDCARD, new ArrayList(list));
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static ListBinaryTag of(@NotNull BinaryTagType<? extends BinaryTag> binaryTagType, @NotNull List<BinaryTag> list) {
        return listBinaryTag(binaryTagType, list);
    }

    @NotNull
    static Collector<BinaryTag, ?, ListBinaryTag> toListTag() {
        return toListTag(null);
    }

    @NotNull
    static Collector<BinaryTag, ?, ListBinaryTag> toListTag(@Nullable ListBinaryTag listBinaryTag) {
        return Collector.of(listBinaryTag == null ? ListBinaryTag::builder : () -> {
            return builder().add((Iterable) listBinaryTag);
        }, (v0, v1) -> {
            v0.add(v1);
        }, (builder, builder2) -> {
            return builder.add((Iterable) builder2.build());
        }, (v0) -> {
            return v0.build();
        }, new Collector.Characteristics[0]);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<ListBinaryTag> type() {
        return BinaryTagTypes.LIST;
    }

    @Deprecated
    @NotNull
    default BinaryTagType<? extends BinaryTag> listType() {
        return elementType();
    }

    @NotNull
    BinaryTagType<? extends BinaryTag> elementType();

    int size();

    boolean isEmpty();

    @NotNull
    BinaryTag get(int i);

    @NotNull
    ListBinaryTag set(int i, @NotNull BinaryTag binaryTag, @Nullable Consumer<? super BinaryTag> consumer);

    @NotNull
    ListBinaryTag remove(int i, @Nullable Consumer<? super BinaryTag> consumer);

    default byte getByte(int i) {
        return getByte(i, (byte) 0);
    }

    default byte getByte(int i, byte b) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type().numeric() ? ((NumberBinaryTag) binaryTag).byteValue() : b;
    }

    default short getShort(int i) {
        return getShort(i, (short) 0);
    }

    default short getShort(int i, short s) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type().numeric() ? ((NumberBinaryTag) binaryTag).shortValue() : s;
    }

    default int getInt(int i) {
        return getInt(i, 0);
    }

    default int getInt(int i, int i2) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type().numeric() ? ((NumberBinaryTag) binaryTag).intValue() : i2;
    }

    default long getLong(int i) {
        return getLong(i, 0L);
    }

    default long getLong(int i, long j) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type().numeric() ? ((NumberBinaryTag) binaryTag).longValue() : j;
    }

    default float getFloat(int i) {
        return getFloat(i, 0.0f);
    }

    default float getFloat(int i, float f) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type().numeric() ? ((NumberBinaryTag) binaryTag).floatValue() : f;
    }

    default double getDouble(int i) {
        return getDouble(i, 0.0d);
    }

    default double getDouble(int i, double d) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type().numeric() ? ((NumberBinaryTag) binaryTag).doubleValue() : d;
    }

    default byte[] getByteArray(int i) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.BYTE_ARRAY ? ((ByteArrayBinaryTag) binaryTag).value() : new byte[0];
    }

    default byte[] getByteArray(int i, byte[] bArr) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.BYTE_ARRAY ? ((ByteArrayBinaryTag) binaryTag).value() : bArr;
    }

    @NotNull
    default String getString(int i) {
        return getString(i, "");
    }

    @NotNull
    default String getString(int i, @NotNull String str) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.STRING ? ((StringBinaryTag) binaryTag).value() : str;
    }

    @NotNull
    default ListBinaryTag getList(int i) {
        return getList(i, null, empty());
    }

    @NotNull
    default ListBinaryTag getList(int i, @Nullable BinaryTagType<?> binaryTagType) {
        return getList(i, binaryTagType, empty());
    }

    @NotNull
    default ListBinaryTag getList(int i, @NotNull ListBinaryTag listBinaryTag) {
        return getList(i, null, listBinaryTag);
    }

    @NotNull
    default ListBinaryTag getList(int i, @Nullable BinaryTagType<?> binaryTagType, @NotNull ListBinaryTag listBinaryTag) {
        BinaryTag binaryTag = get(i);
        if (binaryTag.type() == BinaryTagTypes.LIST) {
            ListBinaryTag listBinaryTag2 = (ListBinaryTag) binaryTag;
            if (binaryTagType == null || listBinaryTag2.elementType() == binaryTagType) {
                return listBinaryTag2;
            }
        }
        return listBinaryTag;
    }

    @NotNull
    default CompoundBinaryTag getCompound(int i) {
        return getCompound(i, CompoundBinaryTag.empty());
    }

    @NotNull
    default CompoundBinaryTag getCompound(int i, @NotNull CompoundBinaryTag compoundBinaryTag) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.COMPOUND ? (CompoundBinaryTag) binaryTag : compoundBinaryTag;
    }

    default int[] getIntArray(int i) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.INT_ARRAY ? ((IntArrayBinaryTag) binaryTag).value() : new int[0];
    }

    default int[] getIntArray(int i, int[] iArr) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.INT_ARRAY ? ((IntArrayBinaryTag) binaryTag).value() : iArr;
    }

    default long[] getLongArray(int i) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.LONG_ARRAY ? ((LongArrayBinaryTag) binaryTag).value() : new long[0];
    }

    default long[] getLongArray(int i, long[] jArr) {
        BinaryTag binaryTag = get(i);
        return binaryTag.type() == BinaryTagTypes.LONG_ARRAY ? ((LongArrayBinaryTag) binaryTag).value() : jArr;
    }

    @NotNull
    Stream<BinaryTag> stream();

    @NotNull
    ListBinaryTag unwrapHeterogeneity();

    @NotNull
    ListBinaryTag wrapHeterogeneity();
}

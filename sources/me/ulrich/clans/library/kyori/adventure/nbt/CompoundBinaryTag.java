package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/CompoundBinaryTag.class */
public interface CompoundBinaryTag extends Iterable<Map.Entry<String, ? extends BinaryTag>>, BinaryTag, CompoundTagSetter<CompoundBinaryTag> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/CompoundBinaryTag$Builder.class */
    public interface Builder extends CompoundTagSetter<Builder> {
        @NotNull
        CompoundBinaryTag build();
    }

    @NotNull
    static CompoundBinaryTag empty() {
        return CompoundBinaryTagImpl.EMPTY;
    }

    @NotNull
    static CompoundBinaryTag from(@NotNull Map<String, ? extends BinaryTag> map) {
        return map.isEmpty() ? empty() : new CompoundBinaryTagImpl(new HashMap(map));
    }

    @NotNull
    static Collector<Map.Entry<String, ? extends BinaryTag>, ?, CompoundBinaryTag> toCompoundTag() {
        return toCompoundTag((v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        });
    }

    @NotNull
    static <T> Collector<T, ?, CompoundBinaryTag> toCompoundTag(@NotNull Function<T, String> function, @NotNull Function<T, ? extends BinaryTag> function2) {
        Objects.requireNonNull(function, "keyLens");
        Objects.requireNonNull(function2, "valueLens");
        return Collector.of(CompoundBinaryTag::builder, (builder, obj) -> {
            builder.put((String) function.apply(obj), (BinaryTag) function2.apply(obj));
        }, (builder2, builder3) -> {
            return builder2.put(builder3.build());
        }, (v0) -> {
            return v0.build();
        }, Collector.Characteristics.UNORDERED);
    }

    @NotNull
    static Collector<Map.Entry<String, ? extends BinaryTag>, ?, CompoundBinaryTag> toCompoundTag(@NotNull CompoundBinaryTag compoundBinaryTag) {
        return toCompoundTag(compoundBinaryTag, (v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        });
    }

    @NotNull
    static <T> Collector<T, ?, CompoundBinaryTag> toCompoundTag(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Function<T, String> function, @NotNull Function<T, ? extends BinaryTag> function2) {
        Objects.requireNonNull(compoundBinaryTag, "initial");
        Objects.requireNonNull(function, "keyLens");
        Objects.requireNonNull(function2, "valueLens");
        return Collector.of(() -> {
            return builder().put(compoundBinaryTag);
        }, (builder, obj) -> {
            builder.put((String) function.apply(obj), (BinaryTag) function2.apply(obj));
        }, (builder2, builder3) -> {
            return builder2.put(builder3.build());
        }, (v0) -> {
            return v0.build();
        }, Collector.Characteristics.UNORDERED);
    }

    @NotNull
    static Builder builder() {
        return new CompoundTagBuilder();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<CompoundBinaryTag> type() {
        return BinaryTagTypes.COMPOUND;
    }

    @NotNull
    Set<String> keySet();

    @Nullable
    BinaryTag get(String str);

    int size();

    boolean isEmpty();

    default boolean getBoolean(@NotNull String str) {
        return getBoolean(str, false);
    }

    default boolean getBoolean(@NotNull String str, boolean z) {
        BinaryTag binaryTag = get(str);
        if (binaryTag instanceof ByteBinaryTag) {
            return ((ByteBinaryTag) binaryTag).value() != 0;
        }
        return z;
    }

    default byte getByte(@NotNull String str) {
        return getByte(str, (byte) 0);
    }

    byte getByte(@NotNull String str, byte b);

    default short getShort(@NotNull String str) {
        return getShort(str, (short) 0);
    }

    short getShort(@NotNull String str, short s);

    default int getInt(@NotNull String str) {
        return getInt(str, 0);
    }

    int getInt(@NotNull String str, int i);

    default long getLong(@NotNull String str) {
        return getLong(str, 0L);
    }

    long getLong(@NotNull String str, long j);

    default float getFloat(@NotNull String str) {
        return getFloat(str, 0.0f);
    }

    float getFloat(@NotNull String str, float f);

    default double getDouble(@NotNull String str) {
        return getDouble(str, 0.0d);
    }

    double getDouble(@NotNull String str, double d);

    byte[] getByteArray(@NotNull String str);

    byte[] getByteArray(@NotNull String str, byte[] bArr);

    @NotNull
    default String getString(@NotNull String str) {
        return getString(str, "");
    }

    @NotNull
    String getString(@NotNull String str, @NotNull String str2);

    @NotNull
    default ListBinaryTag getList(@NotNull String str) {
        return getList(str, ListBinaryTag.empty());
    }

    @NotNull
    ListBinaryTag getList(@NotNull String str, @NotNull ListBinaryTag listBinaryTag);

    @NotNull
    default ListBinaryTag getList(@NotNull String str, @NotNull BinaryTagType<? extends BinaryTag> binaryTagType) {
        return getList(str, binaryTagType, ListBinaryTag.empty());
    }

    @NotNull
    ListBinaryTag getList(@NotNull String str, @NotNull BinaryTagType<? extends BinaryTag> binaryTagType, @NotNull ListBinaryTag listBinaryTag);

    @NotNull
    default CompoundBinaryTag getCompound(@NotNull String str) {
        return getCompound(str, empty());
    }

    @NotNull
    CompoundBinaryTag getCompound(@NotNull String str, @NotNull CompoundBinaryTag compoundBinaryTag);

    int[] getIntArray(@NotNull String str);

    int[] getIntArray(@NotNull String str, int[] iArr);

    long[] getLongArray(@NotNull String str);

    long[] getLongArray(@NotNull String str, long[] jArr);

    Stream<Map.Entry<String, ? extends BinaryTag>> stream();
}

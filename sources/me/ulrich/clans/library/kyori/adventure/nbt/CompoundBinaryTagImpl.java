package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/CompoundBinaryTagImpl.class */
@Debug.Renderer(text = "\"CompoundBinaryTag[length=\" + this.tags.size() + \"]\"", childrenArray = "this.tags.entrySet().toArray()", hasChildren = "!this.tags.isEmpty()")
final class CompoundBinaryTagImpl extends AbstractBinaryTag implements CompoundBinaryTag {
    static final CompoundBinaryTag EMPTY = new CompoundBinaryTagImpl(Collections.emptyMap());
    private final Map<String, BinaryTag> tags;
    private final int hashCode;

    CompoundBinaryTagImpl(Map<String, BinaryTag> map) {
        this.tags = Collections.unmodifiableMap(map);
        this.hashCode = map.hashCode();
    }

    public boolean contains(@NotNull String str, @NotNull BinaryTagType<?> binaryTagType) {
        BinaryTag binaryTag = this.tags.get(str);
        return binaryTag != null && binaryTagType.test(binaryTag.type());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    @NotNull
    public Set<String> keySet() {
        return Collections.unmodifiableSet(this.tags.keySet());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    @Nullable
    public BinaryTag get(String str) {
        return this.tags.get(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public int size() {
        return this.tags.size();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public boolean isEmpty() {
        return this.tags.isEmpty();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    @NotNull
    public CompoundBinaryTag put(@NotNull String str, @NotNull BinaryTag binaryTag) {
        return edit(map -> {
            map.put(str, binaryTag);
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    @NotNull
    public CompoundBinaryTag put(@NotNull CompoundBinaryTag compoundBinaryTag) {
        return edit(map -> {
            for (String str : compoundBinaryTag.keySet()) {
                map.put(str, compoundBinaryTag.get(str));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    @NotNull
    public CompoundBinaryTag put(@NotNull Map<String, ? extends BinaryTag> map) {
        return edit(map2 -> {
            map2.putAll(map);
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    @NotNull
    public CompoundBinaryTag remove(@NotNull String str, @Nullable Consumer<? super BinaryTag> consumer) {
        return !this.tags.containsKey(str) ? this : edit(map -> {
            BinaryTag binaryTag = (BinaryTag) map.remove(str);
            if (consumer != null) {
                consumer.accept(binaryTag);
            }
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public byte getByte(@NotNull String str, byte b) {
        return contains(str, BinaryTagTypes.BYTE) ? ((NumberBinaryTag) this.tags.get(str)).byteValue() : b;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public short getShort(@NotNull String str, short s) {
        return contains(str, BinaryTagTypes.SHORT) ? ((NumberBinaryTag) this.tags.get(str)).shortValue() : s;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public int getInt(@NotNull String str, int i) {
        return contains(str, BinaryTagTypes.INT) ? ((NumberBinaryTag) this.tags.get(str)).intValue() : i;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public long getLong(@NotNull String str, long j) {
        return contains(str, BinaryTagTypes.LONG) ? ((NumberBinaryTag) this.tags.get(str)).longValue() : j;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public float getFloat(@NotNull String str, float f) {
        return contains(str, BinaryTagTypes.FLOAT) ? ((NumberBinaryTag) this.tags.get(str)).floatValue() : f;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public double getDouble(@NotNull String str, double d) {
        return contains(str, BinaryTagTypes.DOUBLE) ? ((NumberBinaryTag) this.tags.get(str)).doubleValue() : d;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public byte[] getByteArray(@NotNull String str) {
        return contains(str, BinaryTagTypes.BYTE_ARRAY) ? ((ByteArrayBinaryTag) this.tags.get(str)).value() : new byte[0];
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public byte[] getByteArray(@NotNull String str, byte[] bArr) {
        return contains(str, BinaryTagTypes.BYTE_ARRAY) ? ((ByteArrayBinaryTag) this.tags.get(str)).value() : bArr;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    @NotNull
    public String getString(@NotNull String str, @NotNull String str2) {
        return contains(str, BinaryTagTypes.STRING) ? ((StringBinaryTag) this.tags.get(str)).value() : str2;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    @NotNull
    public ListBinaryTag getList(@NotNull String str, @NotNull ListBinaryTag listBinaryTag) {
        return contains(str, BinaryTagTypes.LIST) ? (ListBinaryTag) this.tags.get(str) : listBinaryTag;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    @NotNull
    public ListBinaryTag getList(@NotNull String str, @NotNull BinaryTagType<? extends BinaryTag> binaryTagType, @NotNull ListBinaryTag listBinaryTag) {
        if (contains(str, BinaryTagTypes.LIST)) {
            ListBinaryTag listBinaryTag2 = (ListBinaryTag) this.tags.get(str);
            if (binaryTagType.test(listBinaryTag2.elementType())) {
                return listBinaryTag2;
            }
        }
        return listBinaryTag;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    @NotNull
    public CompoundBinaryTag getCompound(@NotNull String str, @NotNull CompoundBinaryTag compoundBinaryTag) {
        return contains(str, BinaryTagTypes.COMPOUND) ? (CompoundBinaryTag) this.tags.get(str) : compoundBinaryTag;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public int[] getIntArray(@NotNull String str) {
        return contains(str, BinaryTagTypes.INT_ARRAY) ? ((IntArrayBinaryTag) this.tags.get(str)).value() : new int[0];
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public int[] getIntArray(@NotNull String str, int[] iArr) {
        return contains(str, BinaryTagTypes.INT_ARRAY) ? ((IntArrayBinaryTag) this.tags.get(str)).value() : iArr;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public long[] getLongArray(@NotNull String str) {
        return contains(str, BinaryTagTypes.LONG_ARRAY) ? ((LongArrayBinaryTag) this.tags.get(str)).value() : new long[0];
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public long[] getLongArray(@NotNull String str, long[] jArr) {
        return contains(str, BinaryTagTypes.LONG_ARRAY) ? ((LongArrayBinaryTag) this.tags.get(str)).value() : jArr;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag
    public Stream<Map.Entry<String, ? extends BinaryTag>> stream() {
        return this.tags.entrySet().stream();
    }

    private CompoundBinaryTag edit(Consumer<Map<String, BinaryTag>> consumer) {
        HashMap map = new HashMap(this.tags);
        consumer.accept(map);
        return new CompoundBinaryTagImpl(new HashMap(map));
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof CompoundBinaryTagImpl) && this.tags.equals(((CompoundBinaryTagImpl) obj).tags));
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("tags", this.tags));
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Map.Entry<String, ? extends BinaryTag>> iterator() {
        return this.tags.entrySet().iterator();
    }

    @Override // java.lang.Iterable
    public void forEach(@NotNull Consumer<? super Map.Entry<String, ? extends BinaryTag>> consumer) {
        this.tags.entrySet().forEach((Consumer) Objects.requireNonNull(consumer, "action"));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    @NotNull
    public /* bridge */ /* synthetic */ CompoundBinaryTag remove(@NotNull String str, @Nullable Consumer consumer) {
        return remove(str, (Consumer<? super BinaryTag>) consumer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    @NotNull
    public /* bridge */ /* synthetic */ CompoundBinaryTag put(@NotNull Map map) {
        return put((Map<String, ? extends BinaryTag>) map);
    }
}

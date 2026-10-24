package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ByteArrayBinaryTagImpl.class */
@Debug.Renderer(text = "\"byte[\" + this.value.length + \"]\"", childrenArray = "this.value", hasChildren = "this.value.length > 0")
final class ByteArrayBinaryTagImpl extends ArrayBinaryTagImpl implements ByteArrayBinaryTag {
    final byte[] value;

    ByteArrayBinaryTagImpl(byte[] bArr) {
        this.value = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ByteArrayBinaryTag
    public byte[] value() {
        return Arrays.copyOf(this.value, this.value.length);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ByteArrayBinaryTag
    public int size() {
        return this.value.length;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ByteArrayBinaryTag
    public byte get(int i) {
        checkIndex(i, this.value.length);
        return this.value[i];
    }

    static byte[] value(ByteArrayBinaryTag byteArrayBinaryTag) {
        return byteArrayBinaryTag instanceof ByteArrayBinaryTagImpl ? ((ByteArrayBinaryTagImpl) byteArrayBinaryTag).value : byteArrayBinaryTag.value();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.value, ((ByteArrayBinaryTagImpl) obj).value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new Iterator<Byte>() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.ByteArrayBinaryTagImpl.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < ByteArrayBinaryTagImpl.this.value.length - 1;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Byte next() {
                byte[] bArr = ByteArrayBinaryTagImpl.this.value;
                int i = this.index;
                this.index = i + 1;
                return Byte.valueOf(bArr[i]);
            }
        };
    }
}

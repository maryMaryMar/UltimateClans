package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/IntArrayBinaryTagImpl.class */
@Debug.Renderer(text = "\"int[\" + this.value.length + \"]\"", childrenArray = "this.value", hasChildren = "this.value.length > 0")
final class IntArrayBinaryTagImpl extends ArrayBinaryTagImpl implements IntArrayBinaryTag {
    final int[] value;

    IntArrayBinaryTagImpl(int... iArr) {
        this.value = Arrays.copyOf(iArr, iArr.length);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag
    public int[] value() {
        return Arrays.copyOf(this.value, this.value.length);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag
    public int size() {
        return this.value.length;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag
    public int get(int i) {
        checkIndex(i, this.value.length);
        return this.value[i];
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Integer> iterator2() {
        return new PrimitiveIterator.OfInt() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTagImpl.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < IntArrayBinaryTagImpl.this.value.length - 1;
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int[] iArr = IntArrayBinaryTagImpl.this.value;
                int i = this.index;
                this.index = i + 1;
                return iArr[i];
            }
        };
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag, java.lang.Iterable
    /* JADX INFO: renamed from: spliterator, reason: merged with bridge method [inline-methods] */
    public Spliterator<Integer> spliterator2() {
        return Arrays.spliterator(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag
    @NotNull
    public IntStream stream() {
        return Arrays.stream(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.IntArrayBinaryTag
    public void forEachInt(@NotNull IntConsumer intConsumer) {
        int length = this.value.length;
        for (int i = 0; i < length; i++) {
            intConsumer.accept(this.value[i]);
        }
    }

    static int[] value(IntArrayBinaryTag intArrayBinaryTag) {
        return intArrayBinaryTag instanceof IntArrayBinaryTagImpl ? ((IntArrayBinaryTagImpl) intArrayBinaryTag).value : intArrayBinaryTag.value();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.value, ((IntArrayBinaryTagImpl) obj).value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}

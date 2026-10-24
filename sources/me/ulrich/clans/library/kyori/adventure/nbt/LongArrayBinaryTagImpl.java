package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/LongArrayBinaryTagImpl.class */
@Debug.Renderer(text = "\"long[\" + this.value.length + \"]\"", childrenArray = "this.value", hasChildren = "this.value.length > 0")
final class LongArrayBinaryTagImpl extends ArrayBinaryTagImpl implements LongArrayBinaryTag {
    final long[] value;

    LongArrayBinaryTagImpl(long[] jArr) {
        this.value = Arrays.copyOf(jArr, jArr.length);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag
    public long[] value() {
        return Arrays.copyOf(this.value, this.value.length);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag
    public int size() {
        return this.value.length;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag
    public long get(int i) {
        checkIndex(i, this.value.length);
        return this.value[i];
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Long> iterator2() {
        return new PrimitiveIterator.OfLong() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTagImpl.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < LongArrayBinaryTagImpl.this.value.length - 1;
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongArrayBinaryTagImpl.this.value;
                int i = this.index;
                this.index = i + 1;
                return jArr[i];
            }
        };
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag, java.lang.Iterable
    /* JADX INFO: renamed from: spliterator, reason: merged with bridge method [inline-methods] */
    public Spliterator<Long> spliterator2() {
        return Arrays.spliterator(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag
    @NotNull
    public LongStream stream() {
        return Arrays.stream(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongArrayBinaryTag
    public void forEachLong(@NotNull LongConsumer longConsumer) {
        int length = this.value.length;
        for (int i = 0; i < length; i++) {
            longConsumer.accept(this.value[i]);
        }
    }

    static long[] value(LongArrayBinaryTag longArrayBinaryTag) {
        return longArrayBinaryTag instanceof LongArrayBinaryTagImpl ? ((LongArrayBinaryTagImpl) longArrayBinaryTag).value : longArrayBinaryTag.value();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.value, ((LongArrayBinaryTagImpl) obj).value);
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

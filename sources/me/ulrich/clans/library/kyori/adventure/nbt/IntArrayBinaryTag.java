package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/IntArrayBinaryTag.class */
public interface IntArrayBinaryTag extends Iterable<Integer>, ArrayBinaryTag {
    @NotNull
    static IntArrayBinaryTag intArrayBinaryTag(int... iArr) {
        return new IntArrayBinaryTagImpl(iArr);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static IntArrayBinaryTag of(int... iArr) {
        return new IntArrayBinaryTagImpl(iArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ArrayBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<IntArrayBinaryTag> type() {
        return BinaryTagTypes.INT_ARRAY;
    }

    int[] value();

    int size();

    int get(int i);

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    Iterator<Integer> iterator2();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: spliterator */
    Spliterator<Integer> spliterator2();

    @NotNull
    IntStream stream();

    void forEachInt(@NotNull IntConsumer intConsumer);
}

package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/LongArrayBinaryTag.class */
public interface LongArrayBinaryTag extends Iterable<Long>, ArrayBinaryTag {
    @NotNull
    static LongArrayBinaryTag longArrayBinaryTag(long... jArr) {
        return new LongArrayBinaryTagImpl(jArr);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static LongArrayBinaryTag of(long... jArr) {
        return new LongArrayBinaryTagImpl(jArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ArrayBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<LongArrayBinaryTag> type() {
        return BinaryTagTypes.LONG_ARRAY;
    }

    long[] value();

    int size();

    long get(int i);

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    Iterator<Long> iterator2();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: spliterator */
    Spliterator<Long> spliterator2();

    @NotNull
    LongStream stream();

    void forEachLong(@NotNull LongConsumer longConsumer);
}

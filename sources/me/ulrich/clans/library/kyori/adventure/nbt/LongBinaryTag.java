package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/LongBinaryTag.class */
public interface LongBinaryTag extends NumberBinaryTag {
    @NotNull
    static LongBinaryTag longBinaryTag(long j) {
        return new LongBinaryTagImpl(j);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static LongBinaryTag of(long j) {
        return new LongBinaryTagImpl(j);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<LongBinaryTag> type() {
        return BinaryTagTypes.LONG;
    }

    long value();
}

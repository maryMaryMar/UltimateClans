package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/IntBinaryTag.class */
public interface IntBinaryTag extends NumberBinaryTag {
    @NotNull
    static IntBinaryTag intBinaryTag(int i) {
        return new IntBinaryTagImpl(i);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static IntBinaryTag of(int i) {
        return new IntBinaryTagImpl(i);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<IntBinaryTag> type() {
        return BinaryTagTypes.INT;
    }

    int value();
}

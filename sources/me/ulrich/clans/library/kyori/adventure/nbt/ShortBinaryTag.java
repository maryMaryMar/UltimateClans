package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ShortBinaryTag.class */
public interface ShortBinaryTag extends NumberBinaryTag {
    @NotNull
    static ShortBinaryTag shortBinaryTag(short s) {
        return new ShortBinaryTagImpl(s);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static ShortBinaryTag of(short s) {
        return new ShortBinaryTagImpl(s);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<ShortBinaryTag> type() {
        return BinaryTagTypes.SHORT;
    }

    short value();
}

package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/FloatBinaryTag.class */
public interface FloatBinaryTag extends NumberBinaryTag {
    @NotNull
    static FloatBinaryTag floatBinaryTag(float f) {
        return new FloatBinaryTagImpl(f);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static FloatBinaryTag of(float f) {
        return new FloatBinaryTagImpl(f);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<FloatBinaryTag> type() {
        return BinaryTagTypes.FLOAT;
    }

    float value();
}

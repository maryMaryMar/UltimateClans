package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ByteBinaryTag.class */
public interface ByteBinaryTag extends NumberBinaryTag {
    public static final ByteBinaryTag ZERO = new ByteBinaryTagImpl((byte) 0);
    public static final ByteBinaryTag ONE = new ByteBinaryTagImpl((byte) 1);

    @NotNull
    static ByteBinaryTag byteBinaryTag(byte b) {
        if (b == 0) {
            return ZERO;
        }
        return b == 1 ? ONE : new ByteBinaryTagImpl(b);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static ByteBinaryTag of(byte b) {
        return byteBinaryTag(b);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<ByteBinaryTag> type() {
        return BinaryTagTypes.BYTE;
    }

    byte value();
}

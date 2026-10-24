package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/EndBinaryTag.class */
public interface EndBinaryTag extends BinaryTag {
    @NotNull
    static EndBinaryTag endBinaryTag() {
        return EndBinaryTagImpl.INSTANCE;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static EndBinaryTag get() {
        return EndBinaryTagImpl.INSTANCE;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<EndBinaryTag> type() {
        return BinaryTagTypes.END;
    }
}

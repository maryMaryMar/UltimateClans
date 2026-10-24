package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/StringBinaryTag.class */
public interface StringBinaryTag extends BinaryTag {
    @NotNull
    static StringBinaryTag stringBinaryTag(@NotNull String str) {
        return new StringBinaryTagImpl(str);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static StringBinaryTag of(@NotNull String str) {
        return new StringBinaryTagImpl(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<StringBinaryTag> type() {
        return BinaryTagTypes.STRING;
    }

    @NotNull
    String value();
}

package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ByteArrayBinaryTag.class */
public interface ByteArrayBinaryTag extends Iterable<Byte>, ArrayBinaryTag {
    @NotNull
    static ByteArrayBinaryTag byteArrayBinaryTag(byte... bArr) {
        return new ByteArrayBinaryTagImpl(bArr);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static ByteArrayBinaryTag of(byte... bArr) {
        return new ByteArrayBinaryTagImpl(bArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ArrayBinaryTag, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    default BinaryTagType<ByteArrayBinaryTag> type() {
        return BinaryTagTypes.BYTE_ARRAY;
    }

    byte[] value();

    int size();

    byte get(int i);
}

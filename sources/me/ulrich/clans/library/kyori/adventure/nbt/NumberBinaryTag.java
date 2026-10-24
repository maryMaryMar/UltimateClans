package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/NumberBinaryTag.class */
public interface NumberBinaryTag extends BinaryTag {
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    BinaryTagType<? extends NumberBinaryTag> type();

    byte byteValue();

    double doubleValue();

    float floatValue();

    int intValue();

    long longValue();

    short shortValue();

    @NotNull
    Number numberValue();
}

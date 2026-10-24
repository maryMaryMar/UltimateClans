package me.ulrich.clans.library.kyori.adventure.nbt;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ArrayBinaryTag.class */
public interface ArrayBinaryTag extends BinaryTag {
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag
    @NotNull
    BinaryTagType<? extends ArrayBinaryTag> type();
}

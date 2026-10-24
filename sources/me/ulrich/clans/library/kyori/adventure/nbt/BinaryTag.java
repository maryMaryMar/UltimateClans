package me.ulrich.clans.library.kyori.adventure.nbt;

import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTag.class */
public interface BinaryTag extends BinaryTagLike, Examinable {
    @NotNull
    BinaryTagType<? extends BinaryTag> type();

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagLike
    @NotNull
    default BinaryTag asBinaryTag() {
        return this;
    }
}

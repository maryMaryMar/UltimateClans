package me.ulrich.clans.library.kyori.adventure.nbt;

import me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ListTagSetter.class */
public interface ListTagSetter<R, T extends BinaryTag> {
    @NotNull
    R add(T t);

    @NotNull
    R add(Iterable<? extends T> iterable);
}

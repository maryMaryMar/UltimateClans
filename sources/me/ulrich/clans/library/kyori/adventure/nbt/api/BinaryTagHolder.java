package me.ulrich.clans.library.kyori.adventure.nbt.api;

import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue;
import me.ulrich.clans.library.kyori.adventure.util.Codec;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/api/BinaryTagHolder.class */
public interface BinaryTagHolder extends DataComponentValue.TagSerializable {
    @NotNull
    static <T, EX extends Exception> BinaryTagHolder encode(@NotNull T t, @NotNull Codec<? super T, String, ?, EX> codec) {
        return new BinaryTagHolderImpl(codec.encode(t));
    }

    @NotNull
    static BinaryTagHolder binaryTagHolder(@NotNull String str) {
        return new BinaryTagHolderImpl(str);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static BinaryTagHolder of(@NotNull String str) {
        return new BinaryTagHolderImpl(str);
    }

    @NotNull
    String string();

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue.TagSerializable
    @NotNull
    default BinaryTagHolder asBinaryTag() {
        return this;
    }

    @NotNull
    <T, DX extends Exception> T get(@NotNull Codec<T, String, DX, ?> codec);
}

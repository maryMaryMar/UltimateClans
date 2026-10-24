package me.ulrich.clans.library.kyori.adventure.nbt.api;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.util.Codec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/api/BinaryTagHolderImpl.class */
final class BinaryTagHolderImpl implements BinaryTagHolder {
    private final String string;

    BinaryTagHolderImpl(String str) {
        this.string = (String) Objects.requireNonNull(str, "string");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder
    @NotNull
    public String string() {
        return this.string;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder
    @NotNull
    public <T, DX extends Exception> T get(@NotNull Codec<T, String, DX, ?> codec) {
        return codec.decode(this.string);
    }

    public int hashCode() {
        return 31 * this.string.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof BinaryTagHolderImpl) {
            return this.string.equals(((BinaryTagHolderImpl) obj).string);
        }
        return false;
    }

    public String toString() {
        return this.string;
    }
}

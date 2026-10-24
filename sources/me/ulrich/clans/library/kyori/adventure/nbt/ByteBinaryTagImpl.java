package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ByteBinaryTagImpl.class */
@Debug.Renderer(text = "\"0x\" + Integer.toString(this.value, 16)", hasChildren = "false")
final class ByteBinaryTagImpl extends AbstractBinaryTag implements ByteBinaryTag {
    private final byte value;

    ByteBinaryTagImpl(byte b) {
        this.value = b;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ByteBinaryTag
    public byte value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public byte byteValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public double doubleValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public float floatValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public int intValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public long longValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public short shortValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    @NotNull
    public Number numberValue() {
        return Byte.valueOf(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((ByteBinaryTagImpl) obj).value;
    }

    public int hashCode() {
        return Byte.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}

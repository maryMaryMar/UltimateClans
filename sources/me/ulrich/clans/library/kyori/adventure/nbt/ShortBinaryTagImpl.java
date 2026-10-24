package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ShortBinaryTagImpl.class */
@Debug.Renderer(text = "String.valueOf(this.value) + \"s\"", hasChildren = "false")
final class ShortBinaryTagImpl extends AbstractBinaryTag implements ShortBinaryTag {
    private final short value;

    ShortBinaryTagImpl(short s) {
        this.value = s;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ShortBinaryTag
    public short value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public byte byteValue() {
        return (byte) (this.value & 255);
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
        return Short.valueOf(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((ShortBinaryTagImpl) obj).value;
    }

    public int hashCode() {
        return Short.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}

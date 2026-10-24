package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/DoubleBinaryTagImpl.class */
@Debug.Renderer(text = "String.valueOf(this.value) + \"d\"", hasChildren = "false")
final class DoubleBinaryTagImpl extends AbstractBinaryTag implements DoubleBinaryTag {
    private final double value;

    DoubleBinaryTagImpl(double d) {
        this.value = d;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.DoubleBinaryTag
    public double value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public byte byteValue() {
        return (byte) (ShadyPines.floor(this.value) & 255);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public double doubleValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public float floatValue() {
        return (float) this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public int intValue() {
        return ShadyPines.floor(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public long longValue() {
        return (long) Math.floor(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public short shortValue() {
        return (short) (ShadyPines.floor(this.value) & 65535);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    @NotNull
    public Number numberValue() {
        return Double.valueOf(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((DoubleBinaryTagImpl) obj).value);
    }

    public int hashCode() {
        return Double.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}

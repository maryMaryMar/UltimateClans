package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/LongBinaryTagImpl.class */
@Debug.Renderer(text = "String.valueOf(this.value) + \"l\"", hasChildren = "false")
final class LongBinaryTagImpl extends AbstractBinaryTag implements LongBinaryTag {
    private final long value;

    LongBinaryTagImpl(long j) {
        this.value = j;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.LongBinaryTag
    public long value() {
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
        return (int) this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public long longValue() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    public short shortValue() {
        return (short) (this.value & 65535);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.NumberBinaryTag
    @NotNull
    public Number numberValue() {
        return Long.valueOf(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((LongBinaryTagImpl) obj).value;
    }

    public int hashCode() {
        return Long.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}

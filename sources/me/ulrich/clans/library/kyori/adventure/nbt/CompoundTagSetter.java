package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Map;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/CompoundTagSetter.class */
public interface CompoundTagSetter<R> {
    @NotNull
    R put(@NotNull String str, @NotNull BinaryTag binaryTag);

    @NotNull
    R put(@NotNull CompoundBinaryTag compoundBinaryTag);

    @NotNull
    R put(@NotNull Map<String, ? extends BinaryTag> map);

    @NotNull
    default R remove(@NotNull String str) {
        return remove(str, null);
    }

    @NotNull
    R remove(@NotNull String str, @Nullable Consumer<? super BinaryTag> consumer);

    @NotNull
    default R putBoolean(@NotNull String str, boolean z) {
        return put(str, z ? ByteBinaryTag.ONE : ByteBinaryTag.ZERO);
    }

    @NotNull
    default R putByte(@NotNull String str, byte b) {
        return put(str, ByteBinaryTag.byteBinaryTag(b));
    }

    @NotNull
    default R putShort(@NotNull String str, short s) {
        return put(str, ShortBinaryTag.shortBinaryTag(s));
    }

    @NotNull
    default R putInt(@NotNull String str, int i) {
        return put(str, IntBinaryTag.intBinaryTag(i));
    }

    @NotNull
    default R putLong(@NotNull String str, long j) {
        return put(str, LongBinaryTag.longBinaryTag(j));
    }

    @NotNull
    default R putFloat(@NotNull String str, float f) {
        return put(str, FloatBinaryTag.floatBinaryTag(f));
    }

    @NotNull
    default R putDouble(@NotNull String str, double d) {
        return put(str, DoubleBinaryTag.doubleBinaryTag(d));
    }

    @NotNull
    default R putByteArray(@NotNull String str, byte[] bArr) {
        return put(str, ByteArrayBinaryTag.byteArrayBinaryTag(bArr));
    }

    @NotNull
    default R putString(@NotNull String str, @NotNull String str2) {
        return put(str, StringBinaryTag.stringBinaryTag(str2));
    }

    @NotNull
    default R putIntArray(@NotNull String str, int[] iArr) {
        return put(str, IntArrayBinaryTag.intArrayBinaryTag(iArr));
    }

    @NotNull
    default R putLongArray(@NotNull String str, long[] jArr) {
        return put(str, LongArrayBinaryTag.longArrayBinaryTag(jArr));
    }
}

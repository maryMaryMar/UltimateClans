package me.ulrich.clans.library.kyori.examination;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/Examiner.class */
public interface Examiner<R> {
    @NotNull
    default R examine(@NotNull Examinable examinable) {
        return examine(examinable.examinableName(), examinable.examinableProperties());
    }

    @NotNull
    R examine(@NotNull String str, @NotNull Stream<? extends ExaminableProperty> stream);

    @NotNull
    R examine(@Nullable Object obj);

    @NotNull
    R examine(boolean z);

    @NotNull
    R examine(boolean[] zArr);

    @NotNull
    R examine(byte b);

    @NotNull
    R examine(byte[] bArr);

    @NotNull
    R examine(char c);

    @NotNull
    R examine(char[] cArr);

    @NotNull
    R examine(double d);

    @NotNull
    R examine(double[] dArr);

    @NotNull
    R examine(float f);

    @NotNull
    R examine(float[] fArr);

    @NotNull
    R examine(int i);

    @NotNull
    R examine(int[] iArr);

    @NotNull
    R examine(long j);

    @NotNull
    R examine(long[] jArr);

    @NotNull
    R examine(short s);

    @NotNull
    R examine(short[] sArr);

    @NotNull
    R examine(@Nullable String str);
}

package me.ulrich.clans.library.kyori.examination;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/ExaminableProperty.class */
public abstract class ExaminableProperty {
    private ExaminableProperty() {
    }

    @NotNull
    public abstract String name();

    @NotNull
    public abstract <R> R examine(@NotNull Examiner<? extends R> examiner);

    public String toString() {
        return "ExaminableProperty{" + name() + "}";
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, @Nullable final Object obj) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(obj);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, @Nullable final String str2) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(str2);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final boolean z) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(z);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final boolean[] zArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(zArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final byte b) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(b);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final byte[] bArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(bArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final char c) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(c);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final char[] cArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(cArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final double d) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(d);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final double[] dArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(dArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final float f) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(f);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final float[] fArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(fArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final int i) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(i);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final int[] iArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(iArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final long j) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(j);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final long[] jArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(jArr);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final short s) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(s);
            }
        };
    }

    @NotNull
    public static ExaminableProperty of(@NotNull final String str, final short[] sArr) {
        return new ExaminableProperty() { // from class: me.ulrich.clans.library.kyori.examination.ExaminableProperty.18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public String name() {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.examination.ExaminableProperty
            @NotNull
            public <R> R examine(@NotNull Examiner<? extends R> examiner) {
                return examiner.examine(sArr);
            }
        };
    }
}

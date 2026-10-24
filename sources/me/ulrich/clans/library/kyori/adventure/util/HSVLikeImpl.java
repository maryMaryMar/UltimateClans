package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/HSVLikeImpl.class */
final class HSVLikeImpl implements HSVLike {
    private final float h;
    private final float s;
    private final float v;

    HSVLikeImpl(float f, float f2, float f3) {
        requireInsideRange(f, "h");
        requireInsideRange(f2, "s");
        requireInsideRange(f3, "v");
        this.h = f;
        this.s = f2;
        this.v = f3;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.HSVLike
    public float h() {
        return this.h;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.HSVLike
    public float s() {
        return this.s;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.HSVLike
    public float v() {
        return this.v;
    }

    private static void requireInsideRange(float f, String str) {
        if (f < 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(str + " (" + f + ") is not inside the required range: [0,1]");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HSVLikeImpl)) {
            return false;
        }
        HSVLikeImpl hSVLikeImpl = (HSVLikeImpl) obj;
        return ShadyPines.equals(hSVLikeImpl.h, this.h) && ShadyPines.equals(hSVLikeImpl.s, this.s) && ShadyPines.equals(hSVLikeImpl.v, this.v);
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.h), Float.valueOf(this.s), Float.valueOf(this.v));
    }

    public String toString() {
        return Internals.toString(this);
    }
}

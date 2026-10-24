package me.ulrich.clans.library.kyori.adventure.util;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/HSVLike.class */
public interface HSVLike extends Examinable {
    @NotNull
    static HSVLike hsvLike(float f, float f2, float f3) {
        return new HSVLikeImpl(f, f2, f3);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static HSVLike of(float f, float f2, float f3) {
        return new HSVLikeImpl(f, f2, f3);
    }

    @NotNull
    static HSVLike fromRGB(int i, int i2, int i3) {
        float f;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMin = Math.min(f2, Math.min(f3, f4));
        float fMax = Math.max(f2, Math.max(f3, f4));
        float f5 = fMax - fMin;
        float f6 = fMax != 0.0f ? f5 / fMax : 0.0f;
        if (f6 == 0.0f) {
            return new HSVLikeImpl(0.0f, f6, fMax);
        }
        if (f2 == fMax) {
            f = (f3 - f4) / f5;
        } else {
            f = f3 == fMax ? 2.0f + ((f4 - f2) / f5) : 4.0f + ((f2 - f3) / f5);
        }
        float f7 = f * 60.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        return new HSVLikeImpl(f7 / 360.0f, f6, fMax);
    }

    float h();

    float s();

    float v();

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("h", h()), ExaminableProperty.of("s", s()), ExaminableProperty.of("v", v())});
    }
}

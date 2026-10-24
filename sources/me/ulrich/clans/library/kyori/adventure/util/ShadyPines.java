package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Set;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/ShadyPines.class */
public final class ShadyPines {
    private ShadyPines() {
    }

    @Deprecated
    @NotNull
    @SafeVarargs
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    public static <E extends Enum<E>> Set<E> enumSet(Class<E> cls, E... eArr) {
        return MonkeyBars.enumSet(cls, eArr);
    }

    public static boolean equals(double d, double d2) {
        return Double.doubleToLongBits(d) == Double.doubleToLongBits(d2);
    }

    public static boolean equals(float f, float f2) {
        return Float.floatToIntBits(f) == Float.floatToIntBits(f2);
    }
}

package me.ulrich.clans.library.kyori.adventure.util;

import java.time.Duration;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Ticks.class */
public interface Ticks {
    public static final int TICKS_PER_SECOND = 20;
    public static final long SINGLE_TICK_DURATION_MS = 50;

    @NotNull
    static Duration duration(long j) {
        return Duration.ofMillis(j * 50);
    }
}

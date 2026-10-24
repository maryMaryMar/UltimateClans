package me.ulrich.clans.library.kyori.adventure.bossbar;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBarViewer.class */
public interface BossBarViewer {
    @NotNull
    Iterable<? extends BossBar> activeBossBars();
}

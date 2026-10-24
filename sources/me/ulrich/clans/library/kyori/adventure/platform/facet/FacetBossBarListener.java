package me.ulrich.clans.library.kyori.adventure.platform.facet;

import java.util.Set;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetBossBarListener.class */
class FacetBossBarListener<V> implements Facet.BossBar<V> {
    private final Facet.BossBar<V> facet;
    private final Function<Component, Component> translator;

    FacetBossBarListener(Facet.BossBar<V> bossBar, @NotNull Function<Component, Component> function) {
        this.facet = bossBar;
        this.translator = function;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
    public void bossBarInitialized(@NotNull BossBar bossBar) {
        this.facet.bossBarInitialized(bossBar);
        bossBarNameChanged(bossBar, bossBar.name(), bossBar.name());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
    public void bossBarNameChanged(@NotNull BossBar bossBar, @NotNull Component component, @NotNull Component component2) {
        this.facet.bossBarNameChanged(bossBar, component, this.translator.apply(component2));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
    public void bossBarProgressChanged(@NotNull BossBar bossBar, float f, float f2) {
        this.facet.bossBarProgressChanged(bossBar, f, f2);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
    public void bossBarColorChanged(@NotNull BossBar bossBar, BossBar.Color color, BossBar.Color color2) {
        this.facet.bossBarColorChanged(bossBar, color, color2);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
    public void bossBarOverlayChanged(@NotNull BossBar bossBar, BossBar.Overlay overlay, BossBar.Overlay overlay2) {
        this.facet.bossBarOverlayChanged(bossBar, overlay, overlay2);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
    public void bossBarFlagsChanged(@NotNull BossBar bossBar, @NotNull Set<BossBar.Flag> set, @NotNull Set<BossBar.Flag> set2) {
        this.facet.bossBarFlagsChanged(bossBar, set, set2);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
    public void addViewer(@NotNull V v) {
        this.facet.addViewer(v);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
    public void removeViewer(@NotNull V v) {
        this.facet.removeViewer(v);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
    public boolean isEmpty() {
        return this.facet.isEmpty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.facet.close();
    }
}

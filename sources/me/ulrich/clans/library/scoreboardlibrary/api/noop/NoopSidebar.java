package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopSidebar.class */
class NoopSidebar implements Sidebar {
    private final int maxLines;
    private final String objectiveName;
    private final Locale locale;
    private final Component[] lines;
    private boolean closed;
    private final Set<Player> players = new HashSet();
    private Component title = Component.empty();

    NoopSidebar(int i, String str, @Nullable Locale locale) {
        this.maxLines = i;
        this.locale = locale;
        this.objectiveName = str;
        this.lines = new Component[i];
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void close() {
        this.closed = true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public boolean closed() {
        return this.closed;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @NotNull
    public Collection<Player> players() {
        return this.closed ? Collections.emptySet() : Collections.unmodifiableSet(this.players);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public boolean addPlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        return this.players.add(player);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public boolean removePlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        return this.players.remove(player);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public int maxLines() {
        return this.maxLines;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @NotNull
    public String objectiveName() {
        return this.objectiveName;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @Nullable
    public Locale locale() {
        return this.locale;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void line(int i, @Nullable ComponentLike componentLike, @Nullable ScoreFormat scoreFormat) {
        checkLineBounds(i);
        checkClosed();
        this.lines[i] = componentLike == null ? null : componentLike.asComponent();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void refreshLine(int i) {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @Nullable
    public Component line(int i) {
        checkLineBounds(i);
        checkClosed();
        return this.lines[i];
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @NotNull
    public Component title() {
        return this.title;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void title(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        checkClosed();
        this.title = componentLike.asComponent();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void refreshTitle() {
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("NoopSidebar is closed");
        }
    }

    private void checkLineBounds(int i) {
        if (i >= this.maxLines || i < 0) {
            throw new IndexOutOfBoundsException("invalid line " + i);
        }
    }
}

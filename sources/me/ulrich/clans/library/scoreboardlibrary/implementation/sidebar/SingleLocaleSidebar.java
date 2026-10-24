package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.LocaleLineHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SingleLocaleSidebar.class */
public final class SingleLocaleSidebar extends AbstractSidebar {
    private final Locale locale;
    private final LocaleLineHandler sidebar;
    private final Set<Player> internalPlayers;

    public SingleLocaleSidebar(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl, int i, @NotNull String str, @NotNull Locale locale) {
        super(scoreboardLibraryImpl, i, str);
        this.internalPlayers = new HashSet(8);
        this.locale = locale;
        this.sidebar = new LocaleLineHandler(this, locale);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @Nullable
    public Locale locale() {
        return this.locale;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    @NotNull
    protected Set<Player> internalPlayers() {
        return this.internalPlayers;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    @Nullable
    protected LocaleLineHandler addPlayer0(@NotNull Player player) {
        if (this.internalPlayers.add(player)) {
            return this.sidebar;
        }
        return null;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    @Nullable
    protected LocaleLineHandler removePlayer0(@NotNull Player player) {
        if (this.internalPlayers.remove(player)) {
            return this.sidebar;
        }
        return null;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    protected void forEachLineHandler(@NotNull Consumer<LocaleLineHandler> consumer) {
        consumer.accept(this.sidebar);
    }
}

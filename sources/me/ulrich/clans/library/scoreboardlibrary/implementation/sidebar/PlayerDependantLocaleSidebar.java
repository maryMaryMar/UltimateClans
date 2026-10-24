package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LocaleProvider;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.LocaleLineHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/PlayerDependantLocaleSidebar.class */
public final class PlayerDependantLocaleSidebar extends AbstractSidebar {
    private final Map<Player, LocaleLineHandler> playerMap;
    private final Map<Locale, LocaleLineHandler> localeMap;

    public PlayerDependantLocaleSidebar(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl, int i, @NotNull String str) {
        super(scoreboardLibraryImpl, i, str);
        this.playerMap = new HashMap();
        this.localeMap = new HashMap();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @Nullable
    public Locale locale() {
        return null;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    @NotNull
    protected Set<Player> internalPlayers() {
        return this.playerMap.keySet();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    protected void forEachLineHandler(@NotNull Consumer<LocaleLineHandler> consumer) {
        if (this.localeMap != null) {
            Iterator<LocaleLineHandler> it = this.localeMap.values().iterator();
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    @Nullable
    protected LocaleLineHandler addPlayer0(@NotNull Player player) {
        if (this.playerMap.get(player) != null) {
            return null;
        }
        Locale locale = LocaleProvider.locale(player);
        LocaleLineHandler localeLineHandler = this.localeMap.get(locale);
        if (localeLineHandler != null) {
            this.playerMap.put(player, localeLineHandler);
            return localeLineHandler;
        }
        LocaleLineHandler localeLineHandler2 = new LocaleLineHandler(this, locale);
        this.localeMap.put(locale, localeLineHandler2);
        this.playerMap.put(player, localeLineHandler2);
        return localeLineHandler2;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar
    @Nullable
    protected LocaleLineHandler removePlayer0(@NotNull Player player) {
        LocaleLineHandler localeLineHandlerRemove;
        if (this.playerMap == null || (localeLineHandlerRemove = this.playerMap.remove(player)) == null) {
            return null;
        }
        if (!localeLineHandlerRemove.hasPlayers() && this.localeMap != null) {
            this.localeMap.remove(localeLineHandlerRemove.locale());
        }
        return localeLineHandlerRemove;
    }
}

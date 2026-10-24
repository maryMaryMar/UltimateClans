package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line;

import java.util.Collections;
import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LineRenderingStrategy;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/LocaleLineHandler.class */
public final class LocaleLineHandler {
    private final AbstractSidebar sidebar;
    private final Locale locale;
    private final SidebarLineHandler[] lineHandlers = new SidebarLineHandler[LineRenderingStrategy.values().length];

    public LocaleLineHandler(@NotNull AbstractSidebar abstractSidebar, @NotNull Locale locale) {
        this.sidebar = abstractSidebar;
        this.locale = locale;
    }

    @NotNull
    public AbstractSidebar sidebar() {
        return this.sidebar;
    }

    @NotNull
    public Locale locale() {
        return this.locale;
    }

    public boolean hasPlayers() {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null && !sidebarLineHandler.players().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void addPlayer(@NotNull Player player) {
        lineHandler(this.sidebar.scoreboardLibrary().packetAdapter().lineRenderingStrategy(player)).players().add(player);
    }

    public void removePlayer(@NotNull Player player) {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null && sidebarLineHandler.players().remove(player)) {
                return;
            }
        }
    }

    @NotNull
    public SidebarLineHandler lineHandler(@NotNull LineRenderingStrategy lineRenderingStrategy) {
        SidebarLineHandler sidebarLineHandler = this.lineHandlers[lineRenderingStrategy.ordinal()];
        if (sidebarLineHandler == null) {
            SidebarLineHandler[] sidebarLineHandlerArr = this.lineHandlers;
            int iOrdinal = lineRenderingStrategy.ordinal();
            SidebarLineHandler sidebarLineHandler2 = new SidebarLineHandler(lineRenderingStrategy, this);
            sidebarLineHandlerArr[iOrdinal] = sidebarLineHandler2;
            sidebarLineHandler = sidebarLineHandler2;
        }
        return sidebarLineHandler;
    }

    public void updateScoreFormat(int i) {
        SidebarLineHandler sidebarLineHandler = this.lineHandlers[LineRenderingStrategy.MODERN.ordinal()];
        if (sidebarLineHandler != null) {
            sidebarLineHandler.updateScore(i);
        }
    }

    public void updateLine(int i, Component component) {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null) {
                sidebarLineHandler.setLine(i, component);
            }
        }
    }

    public void updateScores() {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null) {
                sidebarLineHandler.updateScores();
            }
        }
    }

    public void show(Player player) {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null && sidebarLineHandler.players().contains(player)) {
                sidebarLineHandler.show(Collections.singleton(player));
                return;
            }
        }
    }

    public void hide(Player player) {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null && sidebarLineHandler.players().contains(player)) {
                sidebarLineHandler.hide(Collections.singleton(player));
                return;
            }
        }
    }

    public void hide() {
        for (SidebarLineHandler sidebarLineHandler : this.lineHandlers) {
            if (sidebarLineHandler != null) {
                sidebarLineHandler.hide(sidebarLineHandler.players());
            }
        }
    }
}

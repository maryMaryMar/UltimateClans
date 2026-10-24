package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LineRenderingStrategy;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LegacyLocaleLine;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.ModernLocaleLine;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.PostModernLocaleLine;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/SidebarLineHandler.class */
public final class SidebarLineHandler {
    private final LineRenderingStrategy strategy;
    private final LocaleLineHandler localeLineHandler;
    private final Set<Player> players = new HashSet(1);
    private final LocaleLine[] lines;

    public SidebarLineHandler(@NotNull LineRenderingStrategy lineRenderingStrategy, @NotNull LocaleLineHandler localeLineHandler) {
        Component componentValue;
        this.strategy = lineRenderingStrategy;
        this.localeLineHandler = localeLineHandler;
        this.lines = new LocaleLine[localeLineHandler.sidebar().maxLines()];
        for (GlobalLineInfo globalLineInfo : localeLineHandler.sidebar().lines()) {
            if (globalLineInfo != null && (componentValue = globalLineInfo.value()) != null) {
                setLine(globalLineInfo.line(), GlobalTranslator.render(componentValue, localeLineHandler.locale()));
            }
        }
    }

    @NotNull
    public LocaleLineHandler localeLineHandler() {
        return this.localeLineHandler;
    }

    @NotNull
    public Set<Player> players() {
        return this.players;
    }

    public void updateScores() {
        for (LocaleLine localeLine : this.lines) {
            if (localeLine != null && localeLine.info().updateScore()) {
                localeLine.sendScore(this.players);
            }
        }
    }

    public void updateScore(int i) {
        LocaleLine localeLine = this.lines[i];
        if (localeLine != null) {
            localeLine.sendScore(this.players);
        }
    }

    public void setLine(int i, Component component) {
        LocaleLine localeLine = this.lines[i];
        if (component == null && localeLine == null) {
            return;
        }
        boolean z = false;
        if (localeLine == null) {
            LocaleLine[] localeLineArr = this.lines;
            LocaleLine localeLineCreateLine = createLine(this.strategy, this.localeLineHandler.sidebar().lines()[i]);
            localeLine = localeLineCreateLine;
            localeLineArr[i] = localeLineCreateLine;
            z = true;
        }
        if (component == null) {
            this.lines[i] = null;
        } else {
            localeLine.value(component);
        }
        if (component == null) {
            localeLine.hide(this.players);
        } else if (!z) {
            localeLine.updateTeam();
        } else {
            localeLine.resetOldPlayer();
            localeLine.show(this.players);
        }
    }

    public void show(Collection<Player> collection) {
        for (LocaleLine localeLine : this.lines) {
            if (localeLine != null) {
                localeLine.show(collection);
            }
        }
    }

    public void hide(Collection<Player> collection) {
        for (LocaleLine localeLine : this.lines) {
            if (localeLine != null) {
                localeLine.hide(collection);
            }
        }
    }

    @NotNull
    private LocaleLine createLine(@NotNull LineRenderingStrategy lineRenderingStrategy, @NotNull GlobalLineInfo globalLineInfo) {
        switch (lineRenderingStrategy) {
            case LEGACY:
                return new LegacyLocaleLine(globalLineInfo, this);
            case MODERN:
                return new ModernLocaleLine(globalLineInfo, this);
            case POST_MODERN:
                return new PostModernLocaleLine(globalLineInfo, this);
            default:
                throw new IllegalArgumentException();
        }
    }
}

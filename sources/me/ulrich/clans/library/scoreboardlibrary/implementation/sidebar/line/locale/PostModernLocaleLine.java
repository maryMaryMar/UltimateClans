package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale;

import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.GlobalLineInfo;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.SidebarLineHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/locale/PostModernLocaleLine.class */
public final class PostModernLocaleLine implements LocaleLine {
    private final GlobalLineInfo info;
    private final SidebarLineHandler handler;

    public PostModernLocaleLine(GlobalLineInfo globalLineInfo, SidebarLineHandler sidebarLineHandler) {
        this.info = globalLineInfo;
        this.handler = sidebarLineHandler;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    @NotNull
    public GlobalLineInfo info() {
        return this.info;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void value(@NotNull Component component) {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void updateTeam() {
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void sendScore(@NotNull Collection<Player> collection) {
        this.handler.localeLineHandler().sidebar().packetAdapter().sendScore(collection, this.info.player(), this.info.objectiveScore(), this.info.value(), this.info.scoreFormat());
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void show(@NotNull Collection<Player> collection) {
        sendScore(collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void hide(@NotNull Collection<Player> collection) {
        this.handler.localeLineHandler().sidebar().packetAdapter().removeScore(collection, this.info.player());
    }
}

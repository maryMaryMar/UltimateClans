package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.GlobalLineInfo;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.SidebarLineHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/locale/ModernLocaleLine.class */
public final class ModernLocaleLine implements ImmutableTeamProperties<Component>, LocaleLine {
    private final GlobalLineInfo info;
    private final SidebarLineHandler handler;
    private final Collection<String> entries;
    private final TeamDisplayPacketAdapter packetAdapter;

    public ModernLocaleLine(GlobalLineInfo globalLineInfo, SidebarLineHandler sidebarLineHandler) {
        this.info = globalLineInfo;
        this.handler = sidebarLineHandler;
        this.entries = ImmutableList.of(globalLineInfo.player());
        this.packetAdapter = globalLineInfo.packetAdapter().createTeamDisplayAdapter(this);
        this.packetAdapter.updateTeamPackets();
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
        this.packetAdapter.updateTeamPackets();
        this.packetAdapter.sendProperties(PropertiesPacketType.UPDATE, this.handler.players());
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void sendScore(@NotNull Collection<Player> collection) {
        this.handler.localeLineHandler().sidebar().packetAdapter().sendScore(collection, this.info.player(), this.info.objectiveScore(), null, this.info.scoreFormat());
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void show(@NotNull Collection<Player> collection) {
        sendScore(collection);
        this.packetAdapter.sendProperties(PropertiesPacketType.CREATE, collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void hide(@NotNull Collection<Player> collection) {
        this.handler.localeLineHandler().sidebar().packetAdapter().removeScore(collection, this.info.player());
        this.packetAdapter.removeTeam(collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    public Collection<String> syncedEntries() {
        return this.entries;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: displayName */
    public Component mo890displayName() {
        return Component.empty();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: prefix */
    public Component mo889prefix() {
        Component componentValue = this.info.value();
        return componentValue == null ? Component.empty() : componentValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: suffix */
    public Component mo888suffix() {
        return Component.empty();
    }
}

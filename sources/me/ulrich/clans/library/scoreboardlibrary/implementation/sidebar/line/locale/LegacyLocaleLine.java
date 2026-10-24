package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.EntriesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.GlobalLineInfo;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.SidebarLineHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/locale/LegacyLocaleLine.class */
public final class LegacyLocaleLine implements ImmutableTeamProperties<String>, LocaleLine {
    private final GlobalLineInfo info;
    private final SidebarLineHandler handler;
    private final TeamDisplayPacketAdapter packetAdapter;
    private String player;
    private String oldPlayer;
    private String prefix;
    private String suffix;
    private String currentValue;
    static final /* synthetic */ boolean $assertionsDisabled;

    public LegacyLocaleLine(GlobalLineInfo globalLineInfo, SidebarLineHandler sidebarLineHandler) {
        this.info = globalLineInfo;
        this.handler = sidebarLineHandler;
        this.player = globalLineInfo.player();
        this.packetAdapter = globalLineInfo.packetAdapter().createLegacyTeamDisplayAdapter(this);
        this.packetAdapter.updateTeamPackets();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    @NotNull
    public GlobalLineInfo info() {
        return this.info;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: displayName */
    public String mo890displayName() {
        return "";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: prefix */
    public String mo889prefix() {
        return this.prefix;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: suffix */
    public String mo888suffix() {
        return this.suffix;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    public Collection<String> syncedEntries() {
        return ImmutableList.of(this.player);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void value(@NotNull Component component) {
        String strSerialize = LegacyComponentSerializer.legacySection().serialize(component);
        String str = this.player;
        if (strSerialize.length() <= 16) {
            this.prefix = strSerialize;
            this.suffix = "";
            if (this.currentValue != null && this.currentValue.length() > 32) {
                this.player = this.info.player();
            }
        } else {
            boolean z = strSerialize.charAt(15) == 167;
            int i = z ? 15 : 16;
            this.prefix = strSerialize.substring(0, i);
            this.player = this.info.player() + ChatColor.getLastColors(this.prefix + (char) 167 + (z ? Character.valueOf(strSerialize.charAt(16)) : ""));
            int i2 = i;
            if (strSerialize.length() > 32) {
                int length = 16 - this.player.length();
                if (!$assertionsDisabled && length <= 0) {
                    throw new AssertionError();
                }
                i2 += length;
                this.player += strSerialize.substring(i, i2);
            }
            this.suffix = ChatColor.getLastColors(this.player) + strSerialize.substring(i2 + (z ? 2 : 0));
            if (this.suffix.length() > 16) {
                String strSubstring = this.suffix.substring(0, 16);
                if (strSubstring.endsWith(String.valueOf((char) 167))) {
                    strSubstring = strSubstring.substring(0, 15);
                }
                this.suffix = strSubstring;
            }
        }
        this.currentValue = strSerialize;
        if (this.player.equals(str)) {
            return;
        }
        this.oldPlayer = str;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void updateTeam() {
        Set<Player> setPlayers = this.handler.players();
        if (this.oldPlayer != null) {
            ObjectivePacketAdapter objectivePacketAdapterPacketAdapter = this.handler.localeLineHandler().sidebar().packetAdapter();
            this.packetAdapter.sendEntries(EntriesPacketType.REMOVE, setPlayers, Collections.singleton(this.oldPlayer));
            objectivePacketAdapterPacketAdapter.removeScore(setPlayers, this.oldPlayer);
            this.oldPlayer = null;
            this.packetAdapter.sendEntries(EntriesPacketType.ADD, setPlayers, Collections.singleton(this.player));
            objectivePacketAdapterPacketAdapter.sendScore(setPlayers, this.player, this.info.objectiveScore(), null, null);
        }
        this.packetAdapter.sendProperties(PropertiesPacketType.UPDATE, setPlayers);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void resetOldPlayer() {
        this.oldPlayer = null;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void sendScore(@NotNull Collection<Player> collection) {
        ObjectivePacketAdapter objectivePacketAdapterPacketAdapter = this.handler.localeLineHandler().sidebar().packetAdapter();
        if (this.oldPlayer != null) {
            objectivePacketAdapterPacketAdapter.removeScore(collection, this.oldPlayer);
        }
        objectivePacketAdapterPacketAdapter.sendScore(collection, this.player, this.info.objectiveScore(), null, null);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void show(@NotNull Collection<Player> collection) {
        sendScore(collection);
        this.packetAdapter.sendProperties(PropertiesPacketType.CREATE, collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale.LocaleLine
    public void hide(@NotNull Collection<Player> collection) {
        ObjectivePacketAdapter objectivePacketAdapterPacketAdapter = this.handler.localeLineHandler().sidebar().packetAdapter();
        if (this.oldPlayer != null) {
            objectivePacketAdapterPacketAdapter.removeScore(collection, this.oldPlayer);
        }
        objectivePacketAdapterPacketAdapter.removeScore(collection, this.player);
        this.packetAdapter.removeTeam(collection);
    }

    static {
        $assertionsDisabled = !LegacyLocaleLine.class.desiredAssertionStatus();
    }
}

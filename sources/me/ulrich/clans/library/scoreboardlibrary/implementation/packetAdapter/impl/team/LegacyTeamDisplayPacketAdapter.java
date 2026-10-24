package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team;

import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.util.Collection;
import java.util.Iterator;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LegacyFormatUtil;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.ViaConnectionGuard;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.EntriesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamConstants;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/LegacyTeamDisplayPacketAdapter.class */
public final class LegacyTeamDisplayPacketAdapter implements TeamDisplayPacketAdapter {
    private final PacketAdapterProviderImpl provider;
    private final String teamName;
    private final ImmutableTeamProperties<String> properties;
    static final /* synthetic */ boolean $assertionsDisabled;

    public LegacyTeamDisplayPacketAdapter(PacketAdapterProviderImpl packetAdapterProviderImpl, String str, ImmutableTeamProperties<String> immutableTeamProperties) {
        this.provider = packetAdapterProviderImpl;
        this.teamName = str;
        this.properties = immutableTeamProperties;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
    public void removeTeam(@NotNull Iterable<Player> iterable) {
        ViaAPI<Player> viaAPIVia = this.provider.via();
        if (!$assertionsDisabled && viaAPIVia == null) {
            throw new AssertionError();
        }
        for (Player player : iterable) {
            UserConnection connection = viaAPIVia.getConnection(player.getUniqueId());
            if (connection != null && ViaConnectionGuard.isCurrentPlayConnection(viaAPIVia, player, connection)) {
                ByteBuf byteBufBuffer = Unpooled.buffer(128);
                Types.VAR_INT.writePrimitive(byteBufBuffer, teamsPacketId(player, connection).intValue());
                Types.STRING.write(byteBufBuffer, this.teamName);
                Types.BYTE.writePrimitive(byteBufBuffer, (byte) 1);
                sendRawPacket(viaAPIVia, player, connection, byteBufBuffer);
            }
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
    public void sendEntries(@NotNull EntriesPacketType entriesPacketType, @NotNull Collection<Player> collection, @NotNull Collection<String> collection2) {
        ViaAPI<Player> viaAPIVia = this.provider.via();
        if (!$assertionsDisabled && viaAPIVia == null) {
            throw new AssertionError();
        }
        for (Player player : collection) {
            UserConnection connection = viaAPIVia.getConnection(player.getUniqueId());
            if (connection != null && ViaConnectionGuard.isCurrentPlayConnection(viaAPIVia, player, connection)) {
                ByteBuf byteBufBuffer = Unpooled.buffer(128);
                Types.VAR_INT.writePrimitive(byteBufBuffer, teamsPacketId(player, connection).intValue());
                Types.STRING.write(byteBufBuffer, this.teamName);
                Types.BYTE.writePrimitive(byteBufBuffer, (byte) TeamConstants.mode(entriesPacketType));
                if (connection.getProtocolInfo().protocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_7_6)) {
                    Types.SHORT.writePrimitive(byteBufBuffer, (short) this.properties.syncedEntries().size());
                } else {
                    Types.VAR_INT.writePrimitive(byteBufBuffer, this.properties.syncedEntries().size());
                }
                Iterator<String> it = collection2.iterator();
                while (it.hasNext()) {
                    Types.STRING.write(byteBufBuffer, it.next());
                }
                sendRawPacket(viaAPIVia, player, connection, byteBufBuffer);
            }
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
    public void sendProperties(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Collection<Player> collection) {
        ViaAPI<Player> viaAPIVia = this.provider.via();
        if (!$assertionsDisabled && viaAPIVia == null) {
            throw new AssertionError();
        }
        for (Player player : collection) {
            UserConnection connection = viaAPIVia.getConnection(player.getUniqueId());
            if (connection != null && ViaConnectionGuard.isCurrentPlayConnection(viaAPIVia, player, connection)) {
                ByteBuf byteBufBuffer = Unpooled.buffer(128);
                Types.VAR_INT.writePrimitive(byteBufBuffer, teamsPacketId(player, connection).intValue());
                Types.STRING.write(byteBufBuffer, this.teamName);
                Types.BYTE.writePrimitive(byteBufBuffer, (byte) TeamConstants.mode(propertiesPacketType));
                String strLimitLegacyText = LegacyFormatUtil.limitLegacyText(this.properties.mo890displayName(), 32);
                String strLimitLegacyText2 = LegacyFormatUtil.limitLegacyText(this.properties.mo889prefix(), 16);
                String strLimitLegacyText3 = LegacyFormatUtil.limitLegacyText(this.properties.mo888suffix(), 16);
                Types.STRING.write(byteBufBuffer, strLimitLegacyText);
                Types.STRING.write(byteBufBuffer, strLimitLegacyText2);
                Types.STRING.write(byteBufBuffer, strLimitLegacyText3);
                Types.BYTE.writePrimitive(byteBufBuffer, (byte) this.properties.packOptions());
                boolean zOlderThanOrEqualTo = connection.getProtocolInfo().protocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_7_6);
                if (!zOlderThanOrEqualTo) {
                    Types.STRING.write(byteBufBuffer, this.properties.nameTagVisibility().key());
                }
                if (connection.getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_9)) {
                    Types.STRING.write(byteBufBuffer, this.properties.collisionRule().key());
                }
                if (!zOlderThanOrEqualTo) {
                    Types.BYTE.writePrimitive(byteBufBuffer, (byte) LegacyFormatUtil.getIndex(this.properties.playerColor()));
                }
                if (propertiesPacketType == PropertiesPacketType.CREATE) {
                    if (zOlderThanOrEqualTo) {
                        Types.SHORT.writePrimitive(byteBufBuffer, (short) this.properties.syncedEntries().size());
                    } else {
                        Types.VAR_INT.writePrimitive(byteBufBuffer, this.properties.syncedEntries().size());
                    }
                    Iterator<String> it = this.properties.syncedEntries().iterator();
                    while (it.hasNext()) {
                        Types.STRING.write(byteBufBuffer, it.next());
                    }
                }
                sendRawPacket(viaAPIVia, player, connection, byteBufBuffer);
            }
        }
    }

    private static void sendRawPacket(ViaAPI<Player> viaAPI, Player player, UserConnection userConnection, ByteBuf byteBuf) {
        Channel channel = userConnection.getChannel();
        if (!$assertionsDisabled && channel == null) {
            throw new AssertionError();
        }
        channel.eventLoop().execute(() -> {
            if (ViaConnectionGuard.isCurrentPlayConnection(viaAPI, player, userConnection)) {
                userConnection.sendRawPacket(byteBuf);
            }
        });
    }

    @NotNull
    private Integer teamsPacketId(Player player, UserConnection userConnection) {
        PacketType packetTypeTypeByName;
        ViaAPI<Player> viaAPIVia = this.provider.via();
        if (!$assertionsDisabled && viaAPIVia == null) {
            throw new AssertionError();
        }
        Integer numValueOf = this.provider.viaTeamPacketIds().get(player);
        if (numValueOf != null) {
            return numValueOf;
        }
        Iterator it = userConnection.getProtocolInfo().getPipeline().pipes().iterator();
        while (it.hasNext()) {
            PacketTypeMap packetTypeMap = (PacketTypeMap) ((Protocol) it.next()).getPacketTypesProvider().mappedClientboundPacketTypes().get(State.PLAY);
            if (packetTypeMap != null && (packetTypeTypeByName = packetTypeMap.typeByName("SET_PLAYER_TEAM")) != null) {
                numValueOf = Integer.valueOf(packetTypeTypeByName.getId());
                break;
            }
        }
        if (numValueOf == null) {
            throw new IllegalStateException("team packet id for " + userConnection.getProtocolInfo().protocolVersion() + " not found");
        }
        this.provider.viaTeamPacketIds().put(player, numValueOf);
        return numValueOf;
    }

    static {
        $assertionsDisabled = !LegacyTeamDisplayPacketAdapter.class.desiredAssertionStatus();
    }
}

package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl;

import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.State;
import io.netty.channel.Channel;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/ViaConnectionGuard.class */
public final class ViaConnectionGuard {
    private ViaConnectionGuard() {
    }

    public static boolean isCurrentPlayConnection(ViaAPI<Player> viaAPI, Player player, UserConnection userConnection) {
        Channel channel = userConnection.getChannel();
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        return channel != null && player.isOnline() && channel.isActive() && !userConnection.isPendingDisconnect() && protocolInfo != null && protocolInfo.getServerState() == State.PLAY && protocolInfo.getClientState() == State.PLAY && viaAPI.getConnection(player.getUniqueId()) == userConnection;
    }
}

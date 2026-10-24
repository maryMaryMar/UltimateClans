package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team;

import java.util.Collection;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/team/TeamDisplayPacketAdapter.class */
public interface TeamDisplayPacketAdapter {
    void removeTeam(@NotNull Iterable<Player> iterable);

    default void updateTeamPackets() {
    }

    void sendEntries(@NotNull EntriesPacketType entriesPacketType, @NotNull Collection<Player> collection, @NotNull Collection<String> collection2);

    void sendProperties(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Collection<Player> collection);
}

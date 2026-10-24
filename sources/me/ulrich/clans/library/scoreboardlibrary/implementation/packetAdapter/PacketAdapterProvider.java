package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter;

import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LineRenderingStrategy;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/PacketAdapterProvider.class */
public interface PacketAdapterProvider {
    @NotNull
    ObjectivePacketAdapter createObjectiveAdapter(@NotNull String str);

    @NotNull
    TeamsPacketAdapter createTeamPacketAdapter(@NotNull String str);

    @NotNull
    LineRenderingStrategy lineRenderingStrategy(@NotNull Player player);
}

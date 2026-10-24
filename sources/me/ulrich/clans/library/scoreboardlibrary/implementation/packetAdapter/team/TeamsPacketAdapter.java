package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/team/TeamsPacketAdapter.class */
public interface TeamsPacketAdapter {
    @NotNull
    TeamDisplayPacketAdapter createTeamDisplayAdapter(@NotNull ImmutableTeamProperties<Component> immutableTeamProperties);

    @NotNull
    default TeamDisplayPacketAdapter createLegacyTeamDisplayAdapter(@NotNull ImmutableTeamProperties<String> immutableTeamProperties) {
        throw new UnsupportedOperationException();
    }
}

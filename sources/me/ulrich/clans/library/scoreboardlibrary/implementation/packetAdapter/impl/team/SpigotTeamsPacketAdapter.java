package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsClasses;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsComponent;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsTeams;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamConstants;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.LocalePacketUtil;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/SpigotTeamsPacketAdapter.class */
public final class SpigotTeamsPacketAdapter extends AbstractTeamsPacketAdapterImpl {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/SpigotTeamsPacketAdapter$TeamDisplayPacketAdapterImpl.class */
    private class TeamDisplayPacketAdapterImpl extends AbstractTeamsPacketAdapterImpl.TeamDisplayPacketAdapterImpl {
        static final /* synthetic */ boolean $assertionsDisabled;

        public TeamDisplayPacketAdapterImpl(ImmutableTeamProperties<Component> immutableTeamProperties) {
            super(immutableTeamProperties);
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void sendProperties(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Collection<Player> collection) {
            ArrayList arrayList = new ArrayList(this.properties.syncedEntries());
            LocalePacketUtil.sendLocalePackets(SpigotTeamsPacketAdapter.this.provider.packetSender(), collection, locale -> {
                Object objFromAdventure = NmsComponent.fromAdventure(this.properties.mo890displayName(), locale);
                Object objFromAdventure2 = NmsComponent.fromAdventure(this.properties.mo889prefix(), locale);
                Object objFromAdventure3 = NmsComponent.fromAdventure(this.properties.mo888suffix(), locale);
                if (NmsClasses.IS_1_17_OR_ABOVE) {
                    if (!$assertionsDisabled && NmsTeams.PARAMETERS_CONSTRUCTOR == null) {
                        throw new AssertionError();
                    }
                    return NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(SpigotTeamsPacketAdapter.this.teamName, Integer.valueOf(TeamConstants.mode(propertiesPacketType)), Optional.of(NmsTeams.createTeamParameters(objFromAdventure, objFromAdventure2, objFromAdventure3, this.properties)), arrayList);
                }
                if (!$assertionsDisabled && NmsTeams.TEAM_NAME_FIELD == null) {
                    throw new AssertionError();
                }
                if (!$assertionsDisabled && NmsTeams.TEAM_MODE_FIELD == null) {
                    throw new AssertionError();
                }
                if (!$assertionsDisabled && NmsTeams.TEAM_ENTRIES_FIELD == null) {
                    throw new AssertionError();
                }
                Object objInvoke = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(new Object[0]);
                NmsTeams.TEAM_NAME_FIELD.set(objInvoke, SpigotTeamsPacketAdapter.this.teamName);
                NmsTeams.TEAM_MODE_FIELD.set(objInvoke, Integer.valueOf(TeamConstants.mode(propertiesPacketType)));
                NmsTeams.TEAM_ENTRIES_FIELD.set(objInvoke, arrayList);
                NmsTeams.setupOldTeamPropertiesFields(objInvoke, objFromAdventure, objFromAdventure2, objFromAdventure3, this.properties);
                return objInvoke;
            });
        }

        static {
            $assertionsDisabled = !SpigotTeamsPacketAdapter.class.desiredAssertionStatus();
        }
    }

    public SpigotTeamsPacketAdapter(PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
        super(packetAdapterProviderImpl, str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter
    @NotNull
    public TeamDisplayPacketAdapter createTeamDisplayAdapter(@NotNull ImmutableTeamProperties<Component> immutableTeamProperties) {
        return new TeamDisplayPacketAdapterImpl(immutableTeamProperties);
    }
}

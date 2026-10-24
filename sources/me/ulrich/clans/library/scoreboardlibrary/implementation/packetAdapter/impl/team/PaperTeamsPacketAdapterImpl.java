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
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/PaperTeamsPacketAdapterImpl.class */
public final class PaperTeamsPacketAdapterImpl extends AbstractTeamsPacketAdapterImpl {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/PaperTeamsPacketAdapterImpl$TeamDisplayPacketAdapterImpl.class */
    private class TeamDisplayPacketAdapterImpl extends AbstractTeamsPacketAdapterImpl.TeamDisplayPacketAdapterImpl {
        static final /* synthetic */ boolean $assertionsDisabled;

        public TeamDisplayPacketAdapterImpl(ImmutableTeamProperties<Component> immutableTeamProperties) {
            super(immutableTeamProperties);
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void sendProperties(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Collection<Player> collection) {
            Object objInvoke;
            ArrayList arrayList = new ArrayList(this.properties.syncedEntries());
            Object objFromAdventureComponent = NmsComponent.fromAdventureComponent(this.properties.mo890displayName());
            Object objFromAdventureComponent2 = NmsComponent.fromAdventureComponent(this.properties.mo889prefix());
            Object objFromAdventureComponent3 = NmsComponent.fromAdventureComponent(this.properties.mo888suffix());
            if (NmsClasses.IS_1_17_OR_ABOVE) {
                if (!$assertionsDisabled && NmsTeams.PARAMETERS_CONSTRUCTOR == null) {
                    throw new AssertionError();
                }
                objInvoke = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(PaperTeamsPacketAdapterImpl.this.teamName, Integer.valueOf(TeamConstants.mode(propertiesPacketType)), Optional.of(NmsTeams.createTeamParameters(objFromAdventureComponent, objFromAdventureComponent2, objFromAdventureComponent3, this.properties)), arrayList);
            } else {
                if (!$assertionsDisabled && NmsTeams.TEAM_NAME_FIELD == null) {
                    throw new AssertionError();
                }
                if (!$assertionsDisabled && NmsTeams.TEAM_MODE_FIELD == null) {
                    throw new AssertionError();
                }
                if (!$assertionsDisabled && NmsTeams.TEAM_ENTRIES_FIELD == null) {
                    throw new AssertionError();
                }
                objInvoke = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(new Object[0]);
                NmsTeams.TEAM_NAME_FIELD.set(objInvoke, PaperTeamsPacketAdapterImpl.this.teamName);
                NmsTeams.TEAM_MODE_FIELD.set(objInvoke, Integer.valueOf(TeamConstants.mode(propertiesPacketType)));
                NmsTeams.TEAM_ENTRIES_FIELD.set(objInvoke, arrayList);
                NmsTeams.setupOldTeamPropertiesFields(objInvoke, objFromAdventureComponent, objFromAdventureComponent2, objFromAdventureComponent3, this.properties);
            }
            PaperTeamsPacketAdapterImpl.this.provider.packetSender().sendPacket(collection, objInvoke);
        }

        static {
            $assertionsDisabled = !PaperTeamsPacketAdapterImpl.class.desiredAssertionStatus();
        }
    }

    public PaperTeamsPacketAdapterImpl(PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
        super(packetAdapterProviderImpl, str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter
    @NotNull
    public TeamDisplayPacketAdapter createTeamDisplayAdapter(@NotNull ImmutableTeamProperties<Component> immutableTeamProperties) {
        return new TeamDisplayPacketAdapterImpl(immutableTeamProperties);
    }
}

package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsClasses;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsTeams;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.EntriesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamConstants;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/AbstractTeamsPacketAdapterImpl.class */
public abstract class AbstractTeamsPacketAdapterImpl implements TeamsPacketAdapter {
    protected final PacketAdapterProviderImpl provider;
    protected final String teamName;
    private Object removePacket;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/AbstractTeamsPacketAdapterImpl$TeamDisplayPacketAdapterImpl.class */
    public abstract class TeamDisplayPacketAdapterImpl implements TeamDisplayPacketAdapter {
        protected final ImmutableTeamProperties<Component> properties;
        static final /* synthetic */ boolean $assertionsDisabled;

        public TeamDisplayPacketAdapterImpl(ImmutableTeamProperties<Component> immutableTeamProperties) {
            this.properties = immutableTeamProperties;
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void removeTeam(@NotNull Iterable<Player> iterable) {
            if (AbstractTeamsPacketAdapterImpl.this.removePacket == null) {
                if (NmsClasses.IS_1_17_OR_ABOVE) {
                    AbstractTeamsPacketAdapterImpl.this.removePacket = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(AbstractTeamsPacketAdapterImpl.this.teamName, 1, null, Collections.emptyList());
                } else {
                    if (!$assertionsDisabled && NmsTeams.TEAM_NAME_FIELD == null) {
                        throw new AssertionError();
                    }
                    if (!$assertionsDisabled && NmsTeams.TEAM_MODE_FIELD == null) {
                        throw new AssertionError();
                    }
                    AbstractTeamsPacketAdapterImpl.this.removePacket = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(new Object[0]);
                    NmsTeams.TEAM_NAME_FIELD.set(AbstractTeamsPacketAdapterImpl.this.removePacket, AbstractTeamsPacketAdapterImpl.this.teamName);
                    NmsTeams.TEAM_MODE_FIELD.set(AbstractTeamsPacketAdapterImpl.this.removePacket, 1);
                }
            }
            AbstractTeamsPacketAdapterImpl.this.provider.packetSender().sendPacket(iterable, AbstractTeamsPacketAdapterImpl.this.removePacket);
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void sendEntries(@NotNull EntriesPacketType entriesPacketType, @NotNull Collection<Player> collection, @NotNull Collection<String> collection2) {
            if (NmsClasses.IS_1_17_OR_ABOVE) {
                AbstractTeamsPacketAdapterImpl.this.provider.packetSender().sendPacket(collection, NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(AbstractTeamsPacketAdapterImpl.this.teamName, Integer.valueOf(TeamConstants.mode(entriesPacketType)), Optional.empty(), collection2));
                return;
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
            NmsTeams.TEAM_NAME_FIELD.set(objInvoke, AbstractTeamsPacketAdapterImpl.this.teamName);
            NmsTeams.TEAM_MODE_FIELD.set(objInvoke, Integer.valueOf(TeamConstants.mode(entriesPacketType)));
            NmsTeams.TEAM_ENTRIES_FIELD.set(objInvoke, collection2);
            AbstractTeamsPacketAdapterImpl.this.provider.packetSender().sendPacket(collection, objInvoke);
        }

        static {
            $assertionsDisabled = !AbstractTeamsPacketAdapterImpl.class.desiredAssertionStatus();
        }
    }

    public AbstractTeamsPacketAdapterImpl(@NotNull PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
        this.provider = packetAdapterProviderImpl;
        this.teamName = str;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter
    @NotNull
    public TeamDisplayPacketAdapter createLegacyTeamDisplayAdapter(@NotNull ImmutableTeamProperties<String> immutableTeamProperties) {
        return new LegacyTeamDisplayPacketAdapter(this.provider, this.teamName, immutableTeamProperties);
    }
}

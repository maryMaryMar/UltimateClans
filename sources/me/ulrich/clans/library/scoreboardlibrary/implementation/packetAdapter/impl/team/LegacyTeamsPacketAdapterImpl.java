package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LegacyFormatUtil;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsEnums;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsTeams;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.EntriesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamConstants;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.LocalePacketUtil;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.FieldAccessor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/LegacyTeamsPacketAdapterImpl.class */
public final class LegacyTeamsPacketAdapterImpl implements TeamsPacketAdapter {
    private final PacketAdapterProviderImpl provider;
    private final String teamName;
    private Object removePacket;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/LegacyTeamsPacketAdapterImpl$AbstractTeamDisplayPacketAdapter.class */
    private abstract class AbstractTeamDisplayPacketAdapter<C> implements TeamDisplayPacketAdapter {
        protected final ImmutableTeamProperties<C> properties;

        public AbstractTeamDisplayPacketAdapter(ImmutableTeamProperties<C> immutableTeamProperties) {
            this.properties = immutableTeamProperties;
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void removeTeam(@NotNull Iterable<Player> iterable) {
            if (LegacyTeamsPacketAdapterImpl.this.removePacket == null) {
                LegacyTeamsPacketAdapterImpl.this.removePacket = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(new Object[0]);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_NAME_FIELD)).set(LegacyTeamsPacketAdapterImpl.this.removePacket, LegacyTeamsPacketAdapterImpl.this.teamName);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_MODE_FIELD)).set(LegacyTeamsPacketAdapterImpl.this.removePacket, 1);
            }
            LegacyTeamsPacketAdapterImpl.this.provider.packetSender().sendPacket(iterable, LegacyTeamsPacketAdapterImpl.this.removePacket);
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void sendEntries(@NotNull EntriesPacketType entriesPacketType, @NotNull Collection<Player> collection, @NotNull Collection<String> collection2) {
            Object objInvoke = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(new Object[0]);
            ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_NAME_FIELD)).set(objInvoke, LegacyTeamsPacketAdapterImpl.this.teamName);
            ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_MODE_FIELD)).set(objInvoke, Integer.valueOf(TeamConstants.mode(entriesPacketType)));
            ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_ENTRIES_FIELD)).set(objInvoke, collection2);
            LegacyTeamsPacketAdapterImpl.this.provider.packetSender().sendPacket(collection, objInvoke);
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter
        public void sendProperties(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Collection<Player> collection) {
            LocalePacketUtil.sendLocalePackets(LegacyTeamsPacketAdapterImpl.this.provider.packetSender(), collection, locale -> {
                String strLimitLegacyText = LegacyFormatUtil.limitLegacyText(toLegacy(this.properties.mo890displayName(), locale), 32);
                String strLimitLegacyText2 = LegacyFormatUtil.limitLegacyText(toLegacy(this.properties.mo889prefix(), locale), 16);
                String strLimitLegacyText3 = LegacyFormatUtil.limitLegacyText(toLegacy(this.properties.mo888suffix(), locale), 16);
                Object objInvoke = NmsTeams.TEAM_PACKET_CONSTRUCTOR.invoke(new Object[0]);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_NAME_FIELD)).set(objInvoke, LegacyTeamsPacketAdapterImpl.this.teamName);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_MODE_FIELD)).set(objInvoke, Integer.valueOf(TeamConstants.mode(propertiesPacketType)));
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.DISPLAY_NAME_FIELD)).set(objInvoke, strLimitLegacyText);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.PREFIX_FIELD)).set(objInvoke, strLimitLegacyText2);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.SUFFIX_FIELD)).set(objInvoke, strLimitLegacyText3);
                ((FieldAccessor) Objects.requireNonNull(NmsTeams.OPTIONS_FIELD)).set(objInvoke, Integer.valueOf(this.properties.packOptions()));
                if (NmsTeams.NAME_TAG_VISIBILITY_FIELD != null) {
                    NmsTeams.NAME_TAG_VISIBILITY_FIELD.set(objInvoke, this.properties.nameTagVisibility().key());
                }
                NamedTextColor namedTextColorPlayerColor = this.properties.playerColor();
                if (NmsTeams.COLOR_FIELD != null && namedTextColorPlayerColor != null) {
                    NmsTeams.COLOR_FIELD.set(objInvoke, Integer.valueOf(NmsEnums.ADVENTURE_TO_NMS_CHAT_FORMATTING.get(namedTextColorPlayerColor).ordinal()));
                }
                if (NmsTeams.COLLISION_RULE_FIELD != null) {
                    NmsTeams.COLLISION_RULE_FIELD.set(objInvoke, this.properties.collisionRule().key());
                }
                if (propertiesPacketType == PropertiesPacketType.CREATE) {
                    ((FieldAccessor) Objects.requireNonNull(NmsTeams.TEAM_ENTRIES_FIELD)).set(objInvoke, ImmutableList.copyOf(this.properties.syncedEntries()));
                }
                return objInvoke;
            });
        }

        @NotNull
        protected abstract String toLegacy(@NotNull C c, @NotNull Locale locale);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/LegacyTeamsPacketAdapterImpl$AdventureTeamDisplayPacketAdapter.class */
    private class AdventureTeamDisplayPacketAdapter extends AbstractTeamDisplayPacketAdapter<Component> {
        public AdventureTeamDisplayPacketAdapter(ImmutableTeamProperties<Component> immutableTeamProperties) {
            super(immutableTeamProperties);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team.LegacyTeamsPacketAdapterImpl.AbstractTeamDisplayPacketAdapter
        @NotNull
        public String toLegacy(@NotNull Component component, @NotNull Locale locale) {
            return LegacyFormatUtil.serialize(component, locale);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/team/LegacyTeamsPacketAdapterImpl$LegacyTeamDisplayPacketAdapter.class */
    private class LegacyTeamDisplayPacketAdapter extends AbstractTeamDisplayPacketAdapter<String> {
        public LegacyTeamDisplayPacketAdapter(ImmutableTeamProperties<String> immutableTeamProperties) {
            super(immutableTeamProperties);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team.LegacyTeamsPacketAdapterImpl.AbstractTeamDisplayPacketAdapter
        @NotNull
        public String toLegacy(@NotNull String str, @NotNull Locale locale) {
            return str;
        }
    }

    public LegacyTeamsPacketAdapterImpl(PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
        this.provider = packetAdapterProviderImpl;
        this.teamName = str;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter
    @NotNull
    public TeamDisplayPacketAdapter createTeamDisplayAdapter(@NotNull ImmutableTeamProperties<Component> immutableTeamProperties) {
        return new AdventureTeamDisplayPacketAdapter(immutableTeamProperties);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter
    @NotNull
    public TeamDisplayPacketAdapter createLegacyTeamDisplayAdapter(@NotNull ImmutableTeamProperties<String> immutableTeamProperties) {
        return new LegacyTeamDisplayPacketAdapter(immutableTeamProperties);
    }
}

package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.WeakHashMap;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LineRenderingStrategy;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PacketAdapterProvider;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsClasses;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsComponent;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsPacketSender;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.objective.LegacyObjectivePacketAdapterImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.objective.PaperObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.objective.SpigotObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team.LegacyTeamsPacketAdapterImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team.PaperTeamsPacketAdapterImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.team.SpigotTeamsPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/PacketAdapterProviderImpl.class */
public final class PacketAdapterProviderImpl implements PacketAdapterProvider {
    private final ViaAPI<Player> via;
    private final NmsPacketSender packetSender;
    private final WeakHashMap<Player, Integer> viaTeamPacketIds = new WeakHashMap<>();

    public PacketAdapterProviderImpl(Plugin plugin) {
        boolean zIsPluginEnabled = plugin.getServer().getPluginManager().isPluginEnabled("ViaVersion");
        boolean z = plugin.getDescription().getSoftDepend().contains("ViaVersion") || plugin.getDescription().getDepend().contains("ViaVersion");
        if (NmsClasses.IS_1_13_OR_ABOVE && zIsPluginEnabled && z) {
            this.via = Via.getAPI();
        } else {
            this.via = null;
        }
        this.packetSender = new NmsPacketSender(this.via);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PacketAdapterProvider
    @NotNull
    public ObjectivePacketAdapter createObjectiveAdapter(@NotNull String str) {
        if (NmsClasses.IS_1_13_OR_ABOVE) {
            return NmsComponent.IS_NATIVE_ADVENTURE ? new PaperObjectivePacketAdapter(this, str) : new SpigotObjectivePacketAdapter(this, str);
        }
        return new LegacyObjectivePacketAdapterImpl(this, str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PacketAdapterProvider
    @NotNull
    public TeamsPacketAdapter createTeamPacketAdapter(@NotNull String str) {
        if (NmsClasses.IS_1_13_OR_ABOVE) {
            return NmsComponent.IS_NATIVE_ADVENTURE ? new PaperTeamsPacketAdapterImpl(this, str) : new SpigotTeamsPacketAdapter(this, str);
        }
        return new LegacyTeamsPacketAdapterImpl(this, str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PacketAdapterProvider
    @NotNull
    public LineRenderingStrategy lineRenderingStrategy(@NotNull Player player) {
        if (NmsClasses.IS_1_13_OR_ABOVE) {
            return (this.via == null || !this.via.getPlayerProtocolVersion(player).olderThan(ProtocolVersion.v1_13)) ? LineRenderingStrategy.MODERN : LineRenderingStrategy.LEGACY;
        }
        return LineRenderingStrategy.LEGACY;
    }

    @Nullable
    public ViaAPI<Player> via() {
        return this.via;
    }

    @NotNull
    public NmsPacketSender packetSender() {
        return this.packetSender;
    }

    @NotNull
    public WeakHashMap<Player, Integer> viaTeamPacketIds() {
        return this.viaTeamPacketIds;
    }
}

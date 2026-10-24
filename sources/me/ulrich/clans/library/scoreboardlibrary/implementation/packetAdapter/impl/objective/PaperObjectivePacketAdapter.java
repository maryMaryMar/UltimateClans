package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.objective;

import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsComponent;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsScoreFormat;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/objective/PaperObjectivePacketAdapter.class */
public final class PaperObjectivePacketAdapter extends AbstractObjectivePacketAdapter {
    public PaperObjectivePacketAdapter(@NotNull PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
        super(packetAdapterProviderImpl, str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void sendScore(@NotNull Collection<Player> collection, @NotNull String str, int i, @Nullable Component component, @Nullable ScoreFormat scoreFormat) {
        this.provider.packetSender().sendPacket(collection, createScorePacket(str, i, component == null ? null : NmsComponent.fromAdventure(component, null), NmsScoreFormat.convert(null, scoreFormat)));
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void sendProperties(@NotNull Collection<Player> collection, @NotNull PropertiesPacketType propertiesPacketType, @NotNull Component component, @NotNull ObjectiveRenderType objectiveRenderType, @Nullable ScoreFormat scoreFormat) {
        this.provider.packetSender().sendPacket(collection, createObjectivePacket(propertiesPacketType, NmsComponent.fromAdventureComponent(component), objectiveRenderType, NmsScoreFormat.convert(null, scoreFormat)));
    }
}

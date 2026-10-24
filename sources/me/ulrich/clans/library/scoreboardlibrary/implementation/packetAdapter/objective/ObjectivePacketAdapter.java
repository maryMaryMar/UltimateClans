package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective;

import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/objective/ObjectivePacketAdapter.class */
public interface ObjectivePacketAdapter {
    @NotNull
    String objectiveName();

    void display(@NotNull Collection<Player> collection, @NotNull ObjectiveDisplaySlot objectiveDisplaySlot);

    void sendProperties(@NotNull Collection<Player> collection, @NotNull PropertiesPacketType propertiesPacketType, @NotNull Component component, @NotNull ObjectiveRenderType objectiveRenderType, @Nullable ScoreFormat scoreFormat);

    void remove(@NotNull Collection<Player> collection);

    void sendScore(@NotNull Collection<Player> collection, @NotNull String str, int i, @Nullable Component component, @Nullable ScoreFormat scoreFormat);

    void removeScore(@NotNull Collection<Player> collection, @NotNull String str);
}

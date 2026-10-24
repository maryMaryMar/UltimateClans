package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.locale;

import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.GlobalLineInfo;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/locale/LocaleLine.class */
public interface LocaleLine {
    @NotNull
    GlobalLineInfo info();

    void value(@NotNull Component component);

    void updateTeam();

    default void resetOldPlayer() {
    }

    void sendScore(@NotNull Collection<Player> collection);

    void show(@NotNull Collection<Player> collection);

    void hide(@NotNull Collection<Player> collection);
}

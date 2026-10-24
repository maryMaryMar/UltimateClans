package me.ulrich.clans.interfaces;

import java.util.Optional;
import me.ulrich.clans.data.MapData;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/MapImplement.class */
public interface MapImplement {
    boolean removeMap(String str);

    boolean createMap(String str, Player player, MapData mapData);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

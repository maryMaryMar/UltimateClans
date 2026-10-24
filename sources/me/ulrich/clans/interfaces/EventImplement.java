package me.ulrich.clans.interfaces;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/EventImplement.class */
public interface EventImplement {
    boolean playerInEvent(Player player);

    boolean playerInEvent(UUID uuid);

    boolean locationIsEvent(Location location);

    Optional<String> getLocationEventName(Location location);

    Optional<String> getPlayerEventName(Player player);

    Optional<String> getPlayerEventName(UUID uuid);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

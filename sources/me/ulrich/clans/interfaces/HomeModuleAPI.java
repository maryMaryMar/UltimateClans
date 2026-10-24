package me.ulrich.clans.interfaces;

import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.HomesData;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/HomeModuleAPI.class */
public interface HomeModuleAPI {
    boolean deleteHome(UUID uuid, String str);

    boolean setHome(UUID uuid, Location location, String str);

    boolean setHome(UUID uuid, Location location, String str, Optional<String> optional);

    boolean hasHome(UUID uuid, String str);

    Optional<Location> getHomeLocation(UUID uuid, String str);

    Optional<EncodedLocationData> getEncodedHomeLocation(UUID uuid, String str);

    Optional<HomesData> getHomeData(UUID uuid, String str);

    int homeCount(ClanData clanData);

    String parseText(UUID uuid, String str);
}

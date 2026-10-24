package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import me.ulrich.clans.data.HoloData;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/HologramImplement.class */
public interface HologramImplement {
    boolean hasHologram(String str);

    Optional<HoloData> createHologram(String str, Location location, List<String> list, Object... objArr);

    void createHologramTimed(Long l, String str, Location location, List<String> list, Object... objArr);

    boolean deleteHolo(String str);

    Optional<HoloData> getHologram(String str);

    Optional<HoloData> updateHologram(String str, List<String> list, Object... objArr);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

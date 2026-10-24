package me.ext.cmiholograms.interfaces;

import me.ulrich.clans.Clans;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Cmiholograms.jar:me/ext/cmiholograms/interfaces/HologramAPI.class */
public interface HologramAPI {
    Hologram createHologram(Clans clans, Location location, String str, Object obj);

    boolean removeIfPreset(Clans clans, String str);

    void setLine(Hologram hologram, int i, Line line);

    void updateLine(Hologram hologram, int i, Line line);

    void appendLine(Hologram hologram, Line line);

    void teleport(Hologram hologram, Location location);

    void delete(Hologram hologram);

    void showTo(VisibilityManager visibilityManager, Player player);

    void hideTo(VisibilityManager visibilityManager, Player player);
}

package me.ext.holograms.interfaces;

import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holograms.jar:me/ext/holograms/interfaces/VisibilityManager.class */
public interface VisibilityManager {
    Hologram getHologram();

    boolean isVisibleByDefault();

    void setVisibleByDefault(boolean z);

    void showTo(Player player);

    void hideTo(Player player);

    boolean isVisibleTo(Player player);

    void resetVisibility(Player player);

    void resetVisibilityAll();
}

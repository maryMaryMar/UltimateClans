package me.ext.decentholograms.interfaces;

import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Decentholograms.jar:me/ext/decentholograms/interfaces/VisibilityManager.class */
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

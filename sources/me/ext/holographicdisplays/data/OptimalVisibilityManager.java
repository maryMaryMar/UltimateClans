package me.ext.holographicdisplays.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.ext.holographicdisplays.interfaces.Hologram;
import me.ext.holographicdisplays.interfaces.VisibilityManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holographicdisplays.jar:me/ext/holographicdisplays/data/OptimalVisibilityManager.class */
public class OptimalVisibilityManager implements VisibilityManager {
    private final Hologram hologram;
    private final List<UUID> viewers = new ArrayList();
    private boolean visibleByDefault = true;

    public OptimalVisibilityManager(Hologram hologram) {
        this.hologram = hologram;
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public Hologram getHologram() {
        return this.hologram;
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public boolean isVisibleByDefault() {
        return this.visibleByDefault;
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public void setVisibleByDefault(boolean visibleByDefault) {
        this.visibleByDefault = visibleByDefault;
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public void showTo(Player player) {
        this.viewers.add(player.getUniqueId());
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public void hideTo(Player player) {
        this.viewers.remove(player.getUniqueId());
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public boolean isVisibleTo(Player player) {
        return this.viewers.contains(player.getUniqueId());
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public void resetVisibility(Player player) {
        if (this.visibleByDefault) {
            this.viewers.add(player.getUniqueId());
        } else {
            this.viewers.remove(player.getUniqueId());
        }
    }

    @Override // me.ext.holographicdisplays.interfaces.VisibilityManager
    public void resetVisibilityAll() {
        Bukkit.getOnlinePlayers().forEach(this::resetVisibility);
    }
}

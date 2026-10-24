package me.ulrich.clans.data.addons;

import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusPlayerMapData.class */
public class NexusPlayerMapData {
    private Player player;
    private long time;

    public NexusPlayerMapData(Player player, long j) {
        setPlayer(player);
        setTime(j);
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

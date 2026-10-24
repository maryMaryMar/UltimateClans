package me.ulrich.clans.interfaces;

import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/AnvilClickContext.class */
public class AnvilClickContext {
    private final Player player;
    private final String text;
    private final int slot;

    public AnvilClickContext(Player player, String str, int i) {
        this.player = player;
        this.text = str;
        this.slot = i;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getText() {
        return this.text;
    }

    public int getSlot() {
        return this.slot;
    }
}

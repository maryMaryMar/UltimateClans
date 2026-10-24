package me.ext.holograms.data;

import me.ext.holograms.interfaces.TextLine;
import org.bukkit.ChatColor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holograms.jar:me/ext/holograms/data/OptimalTextLine.class */
public final class OptimalTextLine implements TextLine {
    private final OptimalHologram hologram;
    private String text;

    public OptimalTextLine(OptimalHologram hologram, String text) {
        this.hologram = hologram;
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    @Override // me.ext.holograms.interfaces.TextLine
    public String getText() {
        return this.text;
    }

    @Override // me.ext.holograms.interfaces.TextLine
    public void setText(String text) {
        this.text = ChatColor.translateAlternateColorCodes('&', text);
        updateHologram(this.hologram);
    }
}

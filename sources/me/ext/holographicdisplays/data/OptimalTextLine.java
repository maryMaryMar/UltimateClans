package me.ext.holographicdisplays.data;

import me.ext.holographicdisplays.interfaces.TextLine;
import org.bukkit.ChatColor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holographicdisplays.jar:me/ext/holographicdisplays/data/OptimalTextLine.class */
public final class OptimalTextLine implements TextLine {
    private final OptimalHologram hologram;
    private String text;

    public OptimalTextLine(OptimalHologram hologram, String text) {
        this.hologram = hologram;
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    @Override // me.ext.holographicdisplays.interfaces.TextLine
    public String getText() {
        return this.text;
    }

    @Override // me.ext.holographicdisplays.interfaces.TextLine
    public void setText(String text) {
        this.text = ChatColor.translateAlternateColorCodes('&', text);
        updateHologram(this.hologram);
    }
}

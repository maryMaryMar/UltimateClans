package me.ext.cmiholograms.data;

import me.ext.cmiholograms.interfaces.TextLine;
import org.bukkit.ChatColor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Cmiholograms.jar:me/ext/cmiholograms/data/OptimalTextLine.class */
public final class OptimalTextLine implements TextLine {
    private final OptimalHologram hologram;
    private String text;

    public OptimalTextLine(OptimalHologram hologram, String text) {
        this.hologram = hologram;
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    @Override // me.ext.cmiholograms.interfaces.TextLine
    public String getText() {
        return this.text;
    }

    @Override // me.ext.cmiholograms.interfaces.TextLine
    public void setText(String text) {
        this.text = ChatColor.translateAlternateColorCodes('&', text);
        updateHologram(this.hologram);
    }
}

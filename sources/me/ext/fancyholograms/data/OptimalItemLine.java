package me.ext.fancyholograms.data;

import me.ext.fancyholograms.interfaces.ItemLine;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Fancyholograms.jar:me/ext/fancyholograms/data/OptimalItemLine.class */
public final class OptimalItemLine implements ItemLine {
    private final OptimalHologram hologram;
    private ItemStack itemStack;

    public OptimalItemLine(OptimalHologram hologram, ItemStack itemStack) {
        this.hologram = hologram;
        this.itemStack = itemStack;
    }

    @Override // me.ext.fancyholograms.interfaces.ItemLine
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Override // me.ext.fancyholograms.interfaces.ItemLine
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        updateHologram(this.hologram);
    }
}

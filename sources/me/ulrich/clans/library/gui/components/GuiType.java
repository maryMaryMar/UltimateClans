package me.ulrich.clans.library.gui.components;

import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/GuiType.class */
public enum GuiType {
    CHEST(InventoryType.CHEST, 9, 9),
    WORKBENCH(InventoryType.WORKBENCH, 9, 10),
    HOPPER(InventoryType.HOPPER, 5, 5),
    DISPENSER(InventoryType.DISPENSER, 8, 9),
    BREWING(InventoryType.BREWING, 4, 5);


    @NotNull
    private final InventoryType inventoryType;
    private final int limit;
    private final int fillSize;

    GuiType(InventoryType inventoryType, int i, int i2) {
        this.inventoryType = inventoryType;
        this.limit = i;
        this.fillSize = i2;
    }

    @NotNull
    public InventoryType getInventoryType() {
        return this.inventoryType;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getFillSize() {
        return this.fillSize;
    }
}

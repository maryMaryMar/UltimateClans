package me.ulrich.clans.library.gui.components;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/InventoryProvider.class */
public final class InventoryProvider {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/InventoryProvider$Chest.class */
    @FunctionalInterface
    public interface Chest {
        @NotNull
        Inventory getInventory(@NotNull Component component, @NotNull InventoryHolder inventoryHolder, int i);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/InventoryProvider$Typed.class */
    @FunctionalInterface
    public interface Typed {
        @NotNull
        Inventory getInventory(@NotNull Component component, @NotNull InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType);
    }
}

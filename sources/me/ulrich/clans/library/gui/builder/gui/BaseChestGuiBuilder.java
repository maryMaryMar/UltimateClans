package me.ulrich.clans.library.gui.builder.gui;

import me.ulrich.clans.library.gui.builder.gui.BaseChestGuiBuilder;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.InventoryProvider;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.gui.guis.BaseGui;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/BaseChestGuiBuilder.class */
public abstract class BaseChestGuiBuilder<G extends BaseGui, B extends BaseChestGuiBuilder<G, B>> extends BaseGuiBuilder<G, B> {
    private int rows = 1;
    private InventoryProvider.Chest inventoryProvider = (component, inventoryHolder, i) -> {
        return Bukkit.createInventory(inventoryHolder, i, Legacy.SERIALIZER.serialize(component));
    };

    @Contract("_ -> this")
    @NotNull
    public B rows(int i) {
        this.rows = i;
        return this;
    }

    public B inventory(@NotNull InventoryProvider.Chest chest) {
        this.inventoryProvider = chest;
        return this;
    }

    protected int getRows() {
        return this.rows;
    }

    @NotNull
    protected InventoryProvider.Chest getInventoryProvider() {
        return this.inventoryProvider;
    }

    @NotNull
    protected GuiContainer.Chest createContainer() {
        return new GuiContainer.Chest(getTitle(), this.inventoryProvider, getRows());
    }
}

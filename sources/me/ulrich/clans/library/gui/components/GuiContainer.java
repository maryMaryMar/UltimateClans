package me.ulrich.clans.library.gui.components;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/GuiContainer.class */
public interface GuiContainer {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/GuiContainer$Chest.class */
    public static class Chest implements GuiContainer {
        private final InventoryProvider.Chest inventoryProvider;
        private int rows;
        private Component title;

        public Chest(@NotNull Component component, @NotNull InventoryProvider.Chest chest, int i) {
            this.inventoryProvider = chest;
            this.title = component;
            this.rows = i;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        @NotNull
        public Component title() {
            return this.title;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        public void title(@NotNull Component component) {
            this.title = component;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        public int inventorySize() {
            return this.rows * 9;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        @NotNull
        public GuiType guiType() {
            return GuiType.CHEST;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        public int rows() {
            return this.rows;
        }

        public void rows(int i) {
            this.rows = i;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        @NotNull
        public Inventory createInventory(@NotNull InventoryHolder inventoryHolder) {
            return this.inventoryProvider.getInventory(this.title, inventoryHolder, inventorySize());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/GuiContainer$Typed.class */
    public static class Typed implements GuiContainer {
        private final InventoryProvider.Typed inventoryProvider;
        private final GuiType guiType;
        private Component title;

        public Typed(@NotNull Component component, @NotNull InventoryProvider.Typed typed, @NotNull GuiType guiType) {
            this.inventoryProvider = typed;
            this.title = component;
            this.guiType = guiType;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        @NotNull
        public Component title() {
            return this.title;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        public void title(@NotNull Component component) {
            this.title = component;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        public int inventorySize() {
            return this.guiType.getLimit();
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        @NotNull
        public GuiType guiType() {
            return this.guiType;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        public int rows() {
            return 1;
        }

        @Override // me.ulrich.clans.library.gui.components.GuiContainer
        @NotNull
        public Inventory createInventory(@NotNull InventoryHolder inventoryHolder) {
            return this.inventoryProvider.getInventory(this.title, inventoryHolder, this.guiType.getInventoryType());
        }
    }

    @NotNull
    Component title();

    void title(@NotNull Component component);

    @NotNull
    Inventory createInventory(@NotNull InventoryHolder inventoryHolder);

    @NotNull
    GuiType guiType();

    int inventorySize();

    int rows();
}

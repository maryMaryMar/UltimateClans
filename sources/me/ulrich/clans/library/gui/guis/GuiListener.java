package me.ulrich.clans.library.gui.guis;

import me.ulrich.clans.library.gui.components.GuiAction;
import me.ulrich.clans.library.gui.components.util.ItemNbt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/GuiListener.class */
public final class GuiListener implements Listener {
    @EventHandler
    public void onGuiClick(InventoryClickEvent inventoryClickEvent) {
        GuiItem guiItem;
        GuiAction<InventoryClickEvent> action;
        if (inventoryClickEvent.getInventory().getHolder() instanceof BaseGui) {
            BaseGui baseGui = (BaseGui) inventoryClickEvent.getInventory().getHolder();
            GuiAction<InventoryClickEvent> outsideClickAction = baseGui.getOutsideClickAction();
            if (outsideClickAction != null && inventoryClickEvent.getClickedInventory() == null) {
                outsideClickAction.execute(inventoryClickEvent);
                return;
            }
            if (inventoryClickEvent.getClickedInventory() == null) {
                return;
            }
            GuiAction<InventoryClickEvent> defaultTopClickAction = baseGui.getDefaultTopClickAction();
            if (defaultTopClickAction != null && inventoryClickEvent.getClickedInventory().getType() != InventoryType.PLAYER) {
                defaultTopClickAction.execute(inventoryClickEvent);
            }
            GuiAction<InventoryClickEvent> playerInventoryAction = baseGui.getPlayerInventoryAction();
            if (playerInventoryAction != null && inventoryClickEvent.getClickedInventory().getType() == InventoryType.PLAYER) {
                playerInventoryAction.execute(inventoryClickEvent);
            }
            GuiAction<InventoryClickEvent> defaultClickAction = baseGui.getDefaultClickAction();
            if (defaultClickAction != null) {
                defaultClickAction.execute(inventoryClickEvent);
            }
            GuiAction<InventoryClickEvent> slotAction = baseGui.getSlotAction(inventoryClickEvent.getSlot());
            if (slotAction != null && inventoryClickEvent.getClickedInventory().getType() != InventoryType.PLAYER) {
                slotAction.execute(inventoryClickEvent);
            }
            if (baseGui instanceof PaginatedGui) {
                PaginatedGui paginatedGui = (PaginatedGui) baseGui;
                guiItem = paginatedGui.getGuiItem(inventoryClickEvent.getSlot());
                if (guiItem == null) {
                    guiItem = paginatedGui.getPageItem(inventoryClickEvent.getSlot());
                }
            } else {
                guiItem = baseGui.getGuiItem(inventoryClickEvent.getSlot());
            }
            if (isGuiItem(inventoryClickEvent.getCurrentItem(), guiItem) && (action = guiItem.getAction()) != null) {
                action.execute(inventoryClickEvent);
            }
        }
    }

    @EventHandler
    public void onGuiDrag(InventoryDragEvent inventoryDragEvent) {
        GuiAction<InventoryDragEvent> dragAction;
        if ((inventoryDragEvent.getInventory().getHolder() instanceof BaseGui) && (dragAction = ((BaseGui) inventoryDragEvent.getInventory().getHolder()).getDragAction()) != null) {
            dragAction.execute(inventoryDragEvent);
        }
    }

    @EventHandler
    public void onGuiClose(InventoryCloseEvent inventoryCloseEvent) {
        BaseGui baseGui;
        GuiAction<InventoryCloseEvent> closeGuiAction;
        if ((inventoryCloseEvent.getInventory().getHolder() instanceof BaseGui) && (closeGuiAction = (baseGui = (BaseGui) inventoryCloseEvent.getInventory().getHolder()).getCloseGuiAction()) != null && !baseGui.isUpdating() && baseGui.shouldRunCloseAction()) {
            closeGuiAction.execute(inventoryCloseEvent);
        }
    }

    @EventHandler
    public void onGuiOpen(InventoryOpenEvent inventoryOpenEvent) {
        BaseGui baseGui;
        GuiAction<InventoryOpenEvent> openGuiAction;
        if (!(inventoryOpenEvent.getInventory().getHolder() instanceof BaseGui) || (openGuiAction = (baseGui = (BaseGui) inventoryOpenEvent.getInventory().getHolder()).getOpenGuiAction()) == null || baseGui.isUpdating()) {
            return;
        }
        openGuiAction.execute(inventoryOpenEvent);
    }

    private boolean isGuiItem(@Nullable ItemStack itemStack, @Nullable GuiItem guiItem) {
        String string;
        if (itemStack == null || guiItem == null || (string = ItemNbt.getString(itemStack, "mf-gui")) == null) {
            return false;
        }
        return string.equals(guiItem.getUuid().toString());
    }
}

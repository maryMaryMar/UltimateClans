package me.ulrich.clans.library.gui.guis;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/InteractionModifierListener.class */
public final class InteractionModifierListener implements Listener {
    private static final Set<InventoryAction> ITEM_TAKE_ACTIONS = Collections.unmodifiableSet(EnumSet.of(InventoryAction.PICKUP_ONE, InventoryAction.PICKUP_SOME, InventoryAction.PICKUP_HALF, InventoryAction.PICKUP_ALL, InventoryAction.COLLECT_TO_CURSOR, InventoryAction.HOTBAR_SWAP, InventoryAction.MOVE_TO_OTHER_INVENTORY));
    private static final Set<InventoryAction> ITEM_PLACE_ACTIONS = Collections.unmodifiableSet(EnumSet.of(InventoryAction.PLACE_ONE, InventoryAction.PLACE_SOME, InventoryAction.PLACE_ALL));
    private static final Set<InventoryAction> ITEM_SWAP_ACTIONS = Collections.unmodifiableSet(EnumSet.of(InventoryAction.HOTBAR_SWAP, InventoryAction.SWAP_WITH_CURSOR, InventoryAction.HOTBAR_MOVE_AND_READD));
    private static final Set<InventoryAction> ITEM_DROP_ACTIONS = Collections.unmodifiableSet(EnumSet.of(InventoryAction.DROP_ONE_SLOT, InventoryAction.DROP_ALL_SLOT, InventoryAction.DROP_ONE_CURSOR, InventoryAction.DROP_ALL_CURSOR));

    @EventHandler
    public void onGuiClick(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getHolder() instanceof BaseGui) {
            BaseGui baseGui = (BaseGui) inventoryClickEvent.getInventory().getHolder();
            if (baseGui.allInteractionsDisabled()) {
                inventoryClickEvent.setCancelled(true);
                inventoryClickEvent.setResult(Event.Result.DENY);
                return;
            }
            if ((baseGui.canPlaceItems() || !isPlaceItemEvent(inventoryClickEvent)) && ((baseGui.canTakeItems() || !isTakeItemEvent(inventoryClickEvent)) && ((baseGui.canSwapItems() || !isSwapItemEvent(inventoryClickEvent)) && ((baseGui.canDropItems() || !isDropItemEvent(inventoryClickEvent)) && (baseGui.allowsOtherActions() || !isOtherEvent(inventoryClickEvent)))))) {
                return;
            }
            inventoryClickEvent.setCancelled(true);
            inventoryClickEvent.setResult(Event.Result.DENY);
        }
    }

    @EventHandler
    public void onGuiDrag(InventoryDragEvent inventoryDragEvent) {
        if (inventoryDragEvent.getInventory().getHolder() instanceof BaseGui) {
            BaseGui baseGui = (BaseGui) inventoryDragEvent.getInventory().getHolder();
            if (baseGui.allInteractionsDisabled()) {
                inventoryDragEvent.setCancelled(true);
                inventoryDragEvent.setResult(Event.Result.DENY);
            } else {
                if (baseGui.canPlaceItems() || !isDraggingOnGui(inventoryDragEvent)) {
                    return;
                }
                inventoryDragEvent.setCancelled(true);
                inventoryDragEvent.setResult(Event.Result.DENY);
            }
        }
    }

    private boolean isTakeItemEvent(InventoryClickEvent inventoryClickEvent) {
        Preconditions.checkNotNull(inventoryClickEvent, "event cannot be null");
        Inventory inventory = inventoryClickEvent.getInventory();
        Inventory clickedInventory = inventoryClickEvent.getClickedInventory();
        InventoryAction action = inventoryClickEvent.getAction();
        if ((clickedInventory == null || clickedInventory.getType() != InventoryType.PLAYER) && inventory.getType() != InventoryType.PLAYER) {
            return action == InventoryAction.MOVE_TO_OTHER_INVENTORY || isTakeAction(action);
        }
        return false;
    }

    private boolean isPlaceItemEvent(InventoryClickEvent inventoryClickEvent) {
        Preconditions.checkNotNull(inventoryClickEvent, "event cannot be null");
        Inventory inventory = inventoryClickEvent.getInventory();
        Inventory clickedInventory = inventoryClickEvent.getClickedInventory();
        InventoryAction action = inventoryClickEvent.getAction();
        if (action != InventoryAction.MOVE_TO_OTHER_INVENTORY || clickedInventory == null || clickedInventory.getType() != InventoryType.PLAYER || inventory.getType() == clickedInventory.getType()) {
            return isPlaceAction(action) && (clickedInventory == null || clickedInventory.getType() != InventoryType.PLAYER) && inventory.getType() != InventoryType.PLAYER;
        }
        return true;
    }

    private boolean isSwapItemEvent(InventoryClickEvent inventoryClickEvent) {
        Preconditions.checkNotNull(inventoryClickEvent, "event cannot be null");
        Inventory inventory = inventoryClickEvent.getInventory();
        Inventory clickedInventory = inventoryClickEvent.getClickedInventory();
        return isSwapAction(inventoryClickEvent.getAction()) && (clickedInventory == null || clickedInventory.getType() != InventoryType.PLAYER) && inventory.getType() != InventoryType.PLAYER;
    }

    private boolean isDropItemEvent(InventoryClickEvent inventoryClickEvent) {
        Preconditions.checkNotNull(inventoryClickEvent, "event cannot be null");
        return isDropAction(inventoryClickEvent.getAction()) && !(inventoryClickEvent.getClickedInventory() == null && inventoryClickEvent.getInventory().getType() == InventoryType.PLAYER);
    }

    private boolean isOtherEvent(InventoryClickEvent inventoryClickEvent) {
        Preconditions.checkNotNull(inventoryClickEvent, "event cannot be null");
        return isOtherAction(inventoryClickEvent.getAction()) && !(inventoryClickEvent.getClickedInventory() == null && inventoryClickEvent.getInventory().getType() == InventoryType.PLAYER);
    }

    private boolean isDraggingOnGui(InventoryDragEvent inventoryDragEvent) {
        Preconditions.checkNotNull(inventoryDragEvent, "event cannot be null");
        int size = inventoryDragEvent.getView().getTopInventory().getSize();
        return inventoryDragEvent.getRawSlots().stream().anyMatch(num -> {
            return num.intValue() < size;
        });
    }

    private boolean isTakeAction(InventoryAction inventoryAction) {
        Preconditions.checkNotNull(inventoryAction, "action cannot be null");
        return ITEM_TAKE_ACTIONS.contains(inventoryAction);
    }

    private boolean isPlaceAction(InventoryAction inventoryAction) {
        Preconditions.checkNotNull(inventoryAction, "action cannot be null");
        return ITEM_PLACE_ACTIONS.contains(inventoryAction);
    }

    private boolean isSwapAction(InventoryAction inventoryAction) {
        Preconditions.checkNotNull(inventoryAction, "action cannot be null");
        return ITEM_SWAP_ACTIONS.contains(inventoryAction);
    }

    private boolean isDropAction(InventoryAction inventoryAction) {
        Preconditions.checkNotNull(inventoryAction, "action cannot be null");
        return ITEM_DROP_ACTIONS.contains(inventoryAction);
    }

    private boolean isOtherAction(InventoryAction inventoryAction) {
        Preconditions.checkNotNull(inventoryAction, "action cannot be null");
        return inventoryAction == InventoryAction.CLONE_STACK || inventoryAction == InventoryAction.UNKNOWN;
    }
}

package me.ulrich.clans.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ChestSortEvent.class */
public class ChestSortEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    final Inventory inv;
    Map<ItemStack, Map<String, String>> invSortableMaps;
    Location loc;
    HumanEntity p;
    boolean cancelled = false;
    List<ItemStack> unmovableItemStacks = new ArrayList();
    List<Integer> unmovableSlots = new ArrayList();

    public List<ItemStack> getUnmovableItemStacks() {
        return this.unmovableItemStacks;
    }

    public List<Integer> getUnmovableSlots() {
        return this.unmovableSlots;
    }

    public ChestSortEvent(Inventory inventory) {
        this.inv = inventory;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Location getLocation() {
        return this.loc;
    }

    public void setLocation(Location location) {
        this.loc = location;
    }

    public Inventory getInventory() {
        return this.inv;
    }

    public Map<ItemStack, Map<String, String>> getSortableMaps() {
        return this.invSortableMaps;
    }

    public void setSortableMaps(Map<ItemStack, Map<String, String>> map) {
        this.invSortableMaps = map;
    }

    public HumanEntity getPlayer() {
        return this.p;
    }

    public void setPlayer(HumanEntity humanEntity) {
        this.p = humanEntity;
    }

    public void setUnmovable(int i) {
        this.unmovableSlots.add(Integer.valueOf(i));
    }

    public void setUnmovable(ItemStack itemStack) {
        this.unmovableItemStacks.add(itemStack);
    }

    public void removeUnmovable(int i) {
        this.unmovableSlots.remove(i);
    }

    public void removeUnmovable(ItemStack itemStack) {
        this.unmovableItemStacks.remove(itemStack);
    }

    public boolean isUnmovable(int i) {
        return this.unmovableSlots.contains(Integer.valueOf(i));
    }

    public boolean isUnmovable(ItemStack itemStack) {
        return this.unmovableItemStacks.contains(itemStack);
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean z) {
        this.cancelled = z;
    }
}

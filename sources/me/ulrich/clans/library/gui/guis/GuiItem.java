package me.ulrich.clans.library.gui.guis;

import com.google.common.base.Preconditions;
import java.util.UUID;
import me.ulrich.clans.library.gui.components.GuiAction;
import me.ulrich.clans.library.gui.components.util.ItemNbt;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/GuiItem.class */
public class GuiItem {
    private final UUID uuid;
    private GuiAction<InventoryClickEvent> action;
    private ItemStack itemStack;

    public GuiItem(@NotNull ItemStack itemStack, @Nullable GuiAction<InventoryClickEvent> guiAction) {
        this.uuid = UUID.randomUUID();
        Preconditions.checkNotNull(itemStack, "The ItemStack for the GUI Item cannot be null!");
        this.action = guiAction;
        setItemStack(itemStack);
    }

    public GuiItem(@NotNull ItemStack itemStack) {
        this(itemStack, (GuiAction<InventoryClickEvent>) null);
    }

    public GuiItem(@NotNull Material material) {
        this(new ItemStack(material), (GuiAction<InventoryClickEvent>) null);
    }

    public GuiItem(@NotNull Material material, @Nullable GuiAction<InventoryClickEvent> guiAction) {
        this(new ItemStack(material), guiAction);
    }

    @NotNull
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public void setItemStack(@NotNull ItemStack itemStack) {
        Preconditions.checkNotNull(itemStack, "The ItemStack for the GUI Item cannot be null!");
        if (itemStack.getType() != Material.AIR) {
            this.itemStack = ItemNbt.setString(itemStack.clone(), "mf-gui", this.uuid.toString());
        } else {
            this.itemStack = itemStack.clone();
        }
    }

    @Nullable
    public GuiAction<InventoryClickEvent> getAction() {
        return this.action;
    }

    public void setAction(@Nullable GuiAction<InventoryClickEvent> guiAction) {
        this.action = guiAction;
    }

    @NotNull
    UUID getUuid() {
        return this.uuid;
    }
}

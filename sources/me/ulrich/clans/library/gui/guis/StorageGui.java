package me.ulrich.clans.library.gui.guis;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.InteractionModifier;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/StorageGui.class */
public class StorageGui extends BaseGui {
    public StorageGui(@NotNull GuiContainer guiContainer, @NotNull Set<InteractionModifier> set) {
        super(guiContainer, set);
    }

    @NotNull
    public Map<Integer, ItemStack> addItem(@NotNull ItemStack... itemStackArr) {
        return Collections.unmodifiableMap(getInventory().addItem(itemStackArr));
    }

    public Map<Integer, ItemStack> addItem(@NotNull List<ItemStack> list) {
        return addItem((ItemStack[]) list.toArray(new ItemStack[0]));
    }

    @Override // me.ulrich.clans.library.gui.guis.BaseGui
    public void open(@NotNull HumanEntity humanEntity) {
        if (humanEntity.isSleeping()) {
            return;
        }
        populateGui();
        humanEntity.openInventory(getInventory());
    }
}

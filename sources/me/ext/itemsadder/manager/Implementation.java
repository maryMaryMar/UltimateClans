package me.ext.itemsadder.manager;

import dev.lone.itemsadder.api.CustomStack;
import java.util.Optional;
import me.ext.itemsadder.ItemsAdder;
import me.ulrich.clans.interfaces.ItemParseImplement;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Itemsadder.jar:me/ext/itemsadder/manager/Implementation.class */
public final class Implementation implements ItemParseImplement {
    @Override // me.ulrich.clans.interfaces.ItemParseImplement
    public ItemStack getItem(String itemName) {
        CustomStack stack = CustomStack.getInstance(itemName);
        if (stack != null) {
            return stack.getItemStack();
        }
        return null;
    }

    @Override // me.ulrich.clans.interfaces.ItemParseImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(ItemsAdder.getExtensionCore().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ItemParseImplement
    public Optional<String> getPluginName() {
        return Optional.of(ItemsAdder.getExtensionCore().getName());
    }
}

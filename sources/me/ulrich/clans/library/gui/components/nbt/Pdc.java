package me.ulrich.clans.library.gui.components.nbt;

import me.ulrich.clans.library.gui.TriumphGui;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/nbt/Pdc.class */
public final class Pdc implements NbtWrapper {
    private static final Plugin PLUGIN = TriumphGui.getPlugin();

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    public ItemStack setString(@NotNull ItemStack itemStack, String str, String str2) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return itemStack;
        }
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(PLUGIN, str), PersistentDataType.STRING, str2);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    public ItemStack removeTag(@NotNull ItemStack itemStack, String str) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return itemStack;
        }
        itemMeta.getPersistentDataContainer().remove(new NamespacedKey(PLUGIN, str));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    public ItemStack setBoolean(@NotNull ItemStack itemStack, String str, boolean z) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return itemStack;
        }
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(PLUGIN, str), PersistentDataType.BYTE, Byte.valueOf(z ? (byte) 1 : (byte) 0));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    @Nullable
    public String getString(@NotNull ItemStack itemStack, String str) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return null;
        }
        return (String) itemMeta.getPersistentDataContainer().get(new NamespacedKey(PLUGIN, str), PersistentDataType.STRING);
    }
}

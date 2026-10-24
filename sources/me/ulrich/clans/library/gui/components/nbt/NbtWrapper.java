package me.ulrich.clans.library.gui.components.nbt;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/nbt/NbtWrapper.class */
public interface NbtWrapper {
    ItemStack setString(@NotNull ItemStack itemStack, String str, String str2);

    ItemStack removeTag(@NotNull ItemStack itemStack, String str);

    ItemStack setBoolean(@NotNull ItemStack itemStack, String str, boolean z);

    @Nullable
    String getString(@NotNull ItemStack itemStack, String str);
}

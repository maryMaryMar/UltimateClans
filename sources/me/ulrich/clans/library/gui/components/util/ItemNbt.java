package me.ulrich.clans.library.gui.components.util;

import me.ulrich.clans.library.gui.components.nbt.LegacyNbt;
import me.ulrich.clans.library.gui.components.nbt.NbtWrapper;
import me.ulrich.clans.library.gui.components.nbt.Pdc;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/util/ItemNbt.class */
public final class ItemNbt {
    private static final NbtWrapper nbt = selectNbt();

    public static ItemStack setString(@NotNull ItemStack itemStack, @NotNull String str, @NotNull String str2) {
        return nbt.setString(itemStack, str, str2);
    }

    public static String getString(@NotNull ItemStack itemStack, @NotNull String str) {
        return nbt.getString(itemStack, str);
    }

    public static ItemStack setBoolean(@NotNull ItemStack itemStack, @NotNull String str, boolean z) {
        return nbt.setBoolean(itemStack, str, z);
    }

    public static ItemStack removeTag(@NotNull ItemStack itemStack, @NotNull String str) {
        return nbt.removeTag(itemStack, str);
    }

    private static NbtWrapper selectNbt() {
        return VersionHelper.IS_PDC_VERSION ? new Pdc() : new LegacyNbt();
    }
}

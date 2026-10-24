package me.ulrich.clans.library.gui.builder.item;

import java.util.List;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/NameLoreHandler.class */
public interface NameLoreHandler {
    void name(@NotNull ItemMeta itemMeta, @NotNull Component component);

    void lore(@NotNull ItemMeta itemMeta, @NotNull List<Component> list);

    void lore(@NotNull ItemMeta itemMeta, @NotNull Consumer<List<Component>> consumer);
}

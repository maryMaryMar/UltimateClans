package me.ulrich.clans.library.gui.builder.item;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import me.ulrich.clans.library.gui.builder.item.BaseItemBuilder;
import me.ulrich.clans.library.gui.components.GuiAction;
import me.ulrich.clans.library.gui.components.util.ItemNbt;
import me.ulrich.clans.library.gui.components.util.VersionHelper;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/BaseItemBuilder.class */
public abstract class BaseItemBuilder<B extends BaseItemBuilder<B>> {
    private static final EnumSet<Material> LEATHER_ARMOR = EnumSet.of(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
    private ItemStack itemStack;
    private ItemMeta meta;
    private final NameLoreHandler nameLoreHandler;

    protected BaseItemBuilder(@NotNull ItemStack itemStack, @NotNull NameLoreHandler nameLoreHandler) {
        Preconditions.checkNotNull(itemStack, "Item can't be null!");
        this.itemStack = itemStack;
        this.nameLoreHandler = nameLoreHandler;
        this.meta = itemStack.hasItemMeta() ? itemStack.getItemMeta() : Bukkit.getItemFactory().getItemMeta(itemStack.getType());
    }

    @Contract("_ -> this")
    @NotNull
    public B name(@NotNull Component component) {
        this.nameLoreHandler.name(this.meta, component);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B amount(int i) {
        this.itemStack.setAmount(i);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B lore(@Nullable Component... componentArr) {
        return (B) lore(Arrays.asList(componentArr));
    }

    @Contract("_ -> this")
    @NotNull
    public B lore(@NotNull List<Component> list) {
        this.nameLoreHandler.lore(this.meta, list);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B lore(@NotNull Consumer<List<Component>> consumer) {
        this.nameLoreHandler.lore(this.meta, consumer);
        return this;
    }

    @Contract("_, _, _ -> this")
    @NotNull
    public B enchant(@NotNull Enchantment enchantment, int i, boolean z) {
        this.meta.addEnchant(enchantment, i, z);
        return this;
    }

    @Contract("_, _ -> this")
    @NotNull
    public B enchant(@NotNull Enchantment enchantment, int i) {
        return (B) enchant(enchantment, i, true);
    }

    @Contract("_ -> this")
    @NotNull
    public B enchant(@NotNull Enchantment enchantment) {
        return (B) enchant(enchantment, 1, true);
    }

    @Contract("_, _ -> this")
    @NotNull
    public B enchant(@NotNull Map<Enchantment, Integer> map, boolean z) {
        map.forEach((enchantment, num) -> {
            enchant(enchantment, num.intValue(), z);
        });
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B enchant(@NotNull Map<Enchantment, Integer> map) {
        return (B) enchant(map, true);
    }

    @Contract("_ -> this")
    @NotNull
    public B disenchant(@NotNull Enchantment enchantment) {
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B flags(@NotNull ItemFlag... itemFlagArr) {
        this.meta.addItemFlags(itemFlagArr);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B unbreakable() {
        return (B) unbreakable(true);
    }

    @Contract("_ -> this")
    @NotNull
    public B unbreakable(boolean z) {
        if (VersionHelper.IS_UNBREAKABLE_LEGACY) {
            return (B) setNbt("Unbreakable", z);
        }
        this.meta.setUnbreakable(z);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B glow() {
        return (B) glow(true);
    }

    @Contract("_ -> this")
    @NotNull
    public B glow(boolean z) {
        if (z) {
            this.meta.addEnchant(Enchantment.LURE, 1, false);
            this.meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
            return this;
        }
        Iterator it = this.meta.getEnchants().keySet().iterator();
        while (it.hasNext()) {
            this.meta.removeEnchant((Enchantment) it.next());
        }
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B pdc(@NotNull Consumer<PersistentDataContainer> consumer) {
        consumer.accept(this.meta.getPersistentDataContainer());
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B model(int i) {
        if (VersionHelper.IS_CUSTOM_MODEL_DATA) {
            this.meta.setCustomModelData(Integer.valueOf(i));
        }
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B color(@NotNull Color color) {
        if (LEATHER_ARMOR.contains(this.itemStack.getType())) {
            LeatherArmorMeta meta = getMeta();
            meta.setColor(color);
            setMeta(meta);
        }
        return this;
    }

    @Contract("_, _ -> this")
    @NotNull
    public B setNbt(@NotNull String str, @NotNull String str2) {
        this.itemStack.setItemMeta(this.meta);
        this.itemStack = ItemNbt.setString(this.itemStack, str, str2);
        this.meta = this.itemStack.getItemMeta();
        return this;
    }

    @Contract("_, _ -> this")
    @NotNull
    public B setNbt(@NotNull String str, boolean z) {
        this.itemStack.setItemMeta(this.meta);
        this.itemStack = ItemNbt.setBoolean(this.itemStack, str, z);
        this.meta = this.itemStack.getItemMeta();
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B removeNbt(@NotNull String str) {
        this.itemStack.setItemMeta(this.meta);
        this.itemStack = ItemNbt.removeTag(this.itemStack, str);
        this.meta = this.itemStack.getItemMeta();
        return this;
    }

    @NotNull
    public ItemStack build() {
        this.itemStack.setItemMeta(this.meta);
        return this.itemStack;
    }

    @Contract(" -> new")
    @NotNull
    public GuiItem asGuiItem() {
        return new GuiItem(build());
    }

    @Contract("_ -> new")
    @NotNull
    public GuiItem asGuiItem(@NotNull GuiAction<InventoryClickEvent> guiAction) {
        return new GuiItem(build(), guiAction);
    }

    @NotNull
    protected ItemStack getItemStack() {
        return this.itemStack;
    }

    protected void setItemStack(@NotNull ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @NotNull
    protected ItemMeta getMeta() {
        return this.meta;
    }

    protected void setMeta(@NotNull ItemMeta itemMeta) {
        this.meta = itemMeta;
    }

    @Deprecated
    public B setName(@NotNull String str) {
        getMeta().setDisplayName(str);
        return this;
    }

    @Deprecated
    public B setAmount(int i) {
        getItemStack().setAmount(i);
        return this;
    }

    @Deprecated
    public B addLore(@NotNull String... strArr) {
        return (B) addLore(Arrays.asList(strArr));
    }

    @Deprecated
    public B addLore(@NotNull List<String> list) {
        List<String> lore = getMeta().hasLore() ? getMeta().getLore() : new ArrayList<>();
        lore.addAll(list);
        return (B) setLore(lore);
    }

    @Deprecated
    public B setLore(@NotNull String... strArr) {
        return (B) setLore(Arrays.asList(strArr));
    }

    @Deprecated
    public B setLore(@NotNull List<String> list) {
        getMeta().setLore(list);
        return this;
    }

    @Deprecated
    public B addEnchantment(@NotNull Enchantment enchantment, int i, boolean z) {
        getMeta().addEnchant(enchantment, i, z);
        return this;
    }

    @Deprecated
    public B addEnchantment(@NotNull Enchantment enchantment, int i) {
        return (B) addEnchantment(enchantment, i, true);
    }

    @Deprecated
    public B addEnchantment(@NotNull Enchantment enchantment) {
        return (B) addEnchantment(enchantment, 1, true);
    }

    @Deprecated
    public B removeEnchantment(@NotNull Enchantment enchantment) {
        getItemStack().removeEnchantment(enchantment);
        return this;
    }

    @Deprecated
    public B addItemFlags(@NotNull ItemFlag... itemFlagArr) {
        getMeta().addItemFlags(itemFlagArr);
        return this;
    }

    @Deprecated
    public B setUnbreakable(boolean z) {
        return (B) unbreakable(z);
    }
}

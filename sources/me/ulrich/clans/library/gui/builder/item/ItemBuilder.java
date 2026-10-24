package me.ulrich.clans.library.gui.builder.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.UUID;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.components.util.SkullUtil;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/ItemBuilder.class */
public class ItemBuilder extends BaseItemBuilder<ItemBuilder> {
    ItemBuilder(@NotNull ItemStack itemStack) {
        super(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static ItemBuilder from(@NotNull ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    @Contract("_ -> new")
    @NotNull
    public static ItemBuilder from(@NotNull Material material) {
        return new ItemBuilder(new ItemStack(material));
    }

    @Contract(" -> new")
    @NotNull
    public static BannerBuilder banner() {
        return new BannerBuilder(BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static BannerBuilder banner(@NotNull ItemStack itemStack) {
        return new BannerBuilder(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static BookBuilder book(@NotNull ItemStack itemStack) {
        return new BookBuilder(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Contract(" -> new")
    @NotNull
    public static FireworkBuilder firework() {
        return new FireworkBuilder(new ItemStack(Material.FIREWORK_ROCKET), BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static FireworkBuilder firework(@NotNull ItemStack itemStack) {
        return new FireworkBuilder(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Contract(" -> new")
    @NotNull
    public static MapBuilder map() {
        return new MapBuilder(BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static MapBuilder map(@NotNull ItemStack itemStack) {
        return new MapBuilder(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Contract(" -> new")
    @NotNull
    public static SkullBuilder skull() {
        return new SkullBuilder(BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static SkullBuilder skull(@NotNull ItemStack itemStack) {
        return new SkullBuilder(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Contract(" -> new")
    @NotNull
    public static FireworkBuilder star() {
        return new FireworkBuilder(new ItemStack(Material.FIREWORK_STAR), BukkitNameLoreHandler.getInstance());
    }

    @Contract("_ -> new")
    @NotNull
    public static FireworkBuilder star(@NotNull ItemStack itemStack) {
        return new FireworkBuilder(itemStack, BukkitNameLoreHandler.getInstance());
    }

    @Deprecated
    public ItemBuilder setSkullTexture(@NotNull String str) {
        if (!SkullUtil.isPlayerSkull(getItemStack())) {
            return this;
        }
        SkullMeta meta = getMeta();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), (String) null);
        gameProfile.getProperties().put("textures", new Property("textures", str));
        try {
            Field declaredField = meta.getClass().getDeclaredField("profile");
            declaredField.setAccessible(true);
            declaredField.set(meta, gameProfile);
            setMeta(meta);
            return this;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            throw new GuiException("Failed to set profile field!", e);
        }
    }

    @Deprecated
    public ItemBuilder setSkullOwner(@NotNull OfflinePlayer offlinePlayer) {
        if (!SkullUtil.isPlayerSkull(getItemStack())) {
            return this;
        }
        SkullMeta meta = getMeta();
        meta.setOwningPlayer(offlinePlayer);
        setMeta(meta);
        return this;
    }
}

package me.ulrich.clans.library.gui.builder.item;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.gui.components.util.VersionHelper;
import me.ulrich.clans.library.kyori.adventure.platform.bukkit.MinecraftComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/BukkitNameLoreHandler.class */
public final class BukkitNameLoreHandler implements NameLoreHandler {
    private static final Field DISPLAY_NAME_FIELD;
    private static final Field LORE_FIELD;
    private static final BukkitNameLoreHandler INSTANCE = new BukkitNameLoreHandler();

    @NotNull
    public static BukkitNameLoreHandler getInstance() {
        return INSTANCE;
    }

    @Override // me.ulrich.clans.library.gui.builder.item.NameLoreHandler
    public void name(@NotNull ItemMeta itemMeta, @NotNull Component component) {
        if (VersionHelper.IS_COMPONENT_LEGACY) {
            itemMeta.setDisplayName(Legacy.SERIALIZER.serialize(component));
            return;
        }
        try {
            DISPLAY_NAME_FIELD.set(itemMeta, serializeComponent(component));
        } catch (IllegalAccessException e) {
            throw new GuiException("Could not set display name for ItemBuilder.", e);
        }
    }

    @Override // me.ulrich.clans.library.gui.builder.item.NameLoreHandler
    public void lore(@NotNull ItemMeta itemMeta, @NotNull List<Component> list) {
        if (VersionHelper.IS_COMPONENT_LEGACY) {
            Stream<Component> streamFilter = list.stream().filter((v0) -> {
                return Objects.nonNull(v0);
            });
            LegacyComponentSerializer legacyComponentSerializer = Legacy.SERIALIZER;
            Objects.requireNonNull(legacyComponentSerializer);
            itemMeta.setLore((List) streamFilter.map(legacyComponentSerializer::serialize).collect(Collectors.toList()));
            return;
        }
        try {
            LORE_FIELD.set(itemMeta, (List) list.stream().filter((v0) -> {
                return Objects.nonNull(v0);
            }).map(this::serializeComponent).collect(Collectors.toList()));
        } catch (IllegalAccessException e) {
            throw new GuiException("Could not set lore for ItemBuilder.", e);
        }
    }

    @Override // me.ulrich.clans.library.gui.builder.item.NameLoreHandler
    public void lore(@NotNull ItemMeta itemMeta, @NotNull Consumer<List<Component>> consumer) {
        List<Component> arrayList;
        List<Component> arrayList2;
        if (VersionHelper.IS_COMPONENT_LEGACY) {
            List lore = itemMeta.getLore();
            if (lore == null) {
                arrayList2 = new ArrayList<>();
            } else {
                Stream stream = lore.stream();
                LegacyComponentSerializer legacyComponentSerializer = Legacy.SERIALIZER;
                Objects.requireNonNull(legacyComponentSerializer);
                arrayList2 = (List) stream.map(legacyComponentSerializer::deserialize).collect(Collectors.toList());
            }
            arrayList = arrayList2;
        } else {
            try {
                List list = (List) LORE_FIELD.get(itemMeta);
                arrayList = list == null ? new ArrayList<>() : (List) list.stream().map(this::deserializeComponent).collect(Collectors.toList());
            } catch (IllegalAccessException e) {
                throw new GuiException("Could not get lore for ItemBuilder.", e);
            }
        }
        consumer.accept(arrayList);
        lore(itemMeta, arrayList);
    }

    @NotNull
    private Object serializeComponent(@NotNull Component component) {
        return VersionHelper.IS_ITEM_NAME_COMPONENT ? MinecraftComponentSerializer.get().serialize(component) : GsonComponentSerializer.gson().serialize(component);
    }

    @NotNull
    private Component deserializeComponent(@NotNull Object obj) {
        return VersionHelper.IS_ITEM_NAME_COMPONENT ? MinecraftComponentSerializer.get().deserialize(obj) : GsonComponentSerializer.gson().deserialize((String) obj);
    }

    static {
        try {
            Class<?> clsCraftClass = VersionHelper.craftClass("inventory.CraftMetaItem");
            DISPLAY_NAME_FIELD = clsCraftClass.getDeclaredField("displayName");
            DISPLAY_NAME_FIELD.setAccessible(true);
            LORE_FIELD = clsCraftClass.getDeclaredField("lore");
            LORE_FIELD.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            throw new GuiException("Could not retrieve displayName nor lore field for ItemBuilder.", e);
        }
    }
}

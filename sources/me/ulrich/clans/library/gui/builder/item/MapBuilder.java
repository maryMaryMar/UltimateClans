package me.ulrich.clans.library.gui.builder.item;

import me.ulrich.clans.library.gui.components.exception.GuiException;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/MapBuilder.class */
public class MapBuilder extends BaseItemBuilder<MapBuilder> {
    private static final Material MAP = Material.MAP;

    MapBuilder(@NotNull NameLoreHandler nameLoreHandler) {
        super(new ItemStack(MAP), nameLoreHandler);
    }

    MapBuilder(@NotNull ItemStack itemStack, @NotNull NameLoreHandler nameLoreHandler) {
        super(itemStack, nameLoreHandler);
        if (itemStack.getType() != MAP) {
            throw new GuiException("MapBuilder requires the material to be a MAP!");
        }
    }

    @Override // me.ulrich.clans.library.gui.builder.item.BaseItemBuilder
    @Contract("_ -> this")
    @NotNull
    public MapBuilder color(@Nullable Color color) {
        MapMeta meta = getMeta();
        meta.setColor(color);
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public MapBuilder locationName(@Nullable String str) {
        MapMeta meta = getMeta();
        meta.setLocationName(str);
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public MapBuilder scaling(boolean z) {
        MapMeta meta = getMeta();
        meta.setScaling(z);
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public MapBuilder view(@NotNull MapView mapView) {
        MapMeta meta = getMeta();
        meta.setMapView(mapView);
        setMeta(meta);
        return this;
    }
}

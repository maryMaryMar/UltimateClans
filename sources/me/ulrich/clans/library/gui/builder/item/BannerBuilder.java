package me.ulrich.clans.library.gui.builder.item;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.components.util.VersionHelper;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/BannerBuilder.class */
public final class BannerBuilder extends BaseItemBuilder<BannerBuilder> {
    private static final Material DEFAULT_BANNER;
    private static final EnumSet<Material> BANNERS;

    BannerBuilder(@NotNull NameLoreHandler nameLoreHandler) {
        super(new ItemStack(DEFAULT_BANNER), nameLoreHandler);
    }

    BannerBuilder(@NotNull ItemStack itemStack, @NotNull NameLoreHandler nameLoreHandler) {
        super(itemStack, nameLoreHandler);
        if (!BANNERS.contains(itemStack.getType())) {
            throw new GuiException("BannerBuilder requires the material to be a banner!");
        }
    }

    @Contract("_ -> this")
    @NotNull
    public BannerBuilder baseColor(@NotNull DyeColor dyeColor) {
        BannerMeta meta = getMeta();
        meta.setBaseColor(dyeColor);
        setMeta(meta);
        return this;
    }

    @Contract("_, _ -> this")
    @NotNull
    public BannerBuilder pattern(@NotNull DyeColor dyeColor, @NotNull PatternType patternType) {
        BannerMeta meta = getMeta();
        meta.addPattern(new Pattern(dyeColor, patternType));
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public BannerBuilder pattern(@NotNull Pattern... patternArr) {
        return pattern(Arrays.asList(patternArr));
    }

    @Contract("_ -> this")
    @NotNull
    public BannerBuilder pattern(@NotNull List<Pattern> list) {
        BannerMeta meta = getMeta();
        Iterator<Pattern> it = list.iterator();
        while (it.hasNext()) {
            meta.addPattern(it.next());
        }
        setMeta(meta);
        return this;
    }

    @Contract("_, _, _ -> this")
    @NotNull
    public BannerBuilder pattern(int i, @NotNull DyeColor dyeColor, @NotNull PatternType patternType) {
        return pattern(i, new Pattern(dyeColor, patternType));
    }

    @Contract("_, _ -> this")
    @NotNull
    public BannerBuilder pattern(int i, @NotNull Pattern pattern) {
        BannerMeta meta = getMeta();
        meta.setPattern(i, pattern);
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public BannerBuilder setPatterns(@NotNull List<Pattern> list) {
        BannerMeta meta = getMeta();
        meta.setPatterns(list);
        setMeta(meta);
        return this;
    }

    static {
        if (VersionHelper.IS_ITEM_LEGACY) {
            DEFAULT_BANNER = Material.valueOf("BANNER");
            BANNERS = EnumSet.of(Material.valueOf("BANNER"));
        } else {
            DEFAULT_BANNER = Material.WHITE_BANNER;
            BANNERS = EnumSet.copyOf((Collection) Tag.BANNERS.getValues());
        }
    }
}

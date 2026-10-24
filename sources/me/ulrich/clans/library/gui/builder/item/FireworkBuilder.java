package me.ulrich.clans.library.gui.builder.item;

import java.util.Arrays;
import java.util.List;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/FireworkBuilder.class */
public class FireworkBuilder extends BaseItemBuilder<FireworkBuilder> {
    private static final Material STAR = Material.FIREWORK_STAR;
    private static final Material ROCKET = Material.FIREWORK_ROCKET;

    FireworkBuilder(@NotNull ItemStack itemStack, @NotNull NameLoreHandler nameLoreHandler) {
        super(itemStack, nameLoreHandler);
        if (itemStack.getType() != STAR && itemStack.getType() != ROCKET) {
            throw new GuiException("FireworkBuilder requires the material to be a FIREWORK_STAR/FIREWORK_ROCKET!");
        }
    }

    @Contract("_ -> this")
    @NotNull
    public FireworkBuilder effect(@NotNull FireworkEffect... fireworkEffectArr) {
        return effect(Arrays.asList(fireworkEffectArr));
    }

    @Contract("_ -> this")
    @NotNull
    public FireworkBuilder effect(@NotNull List<FireworkEffect> list) {
        if (list.isEmpty()) {
            return this;
        }
        if (getItemStack().getType() == STAR) {
            FireworkEffectMeta meta = getMeta();
            meta.setEffect(list.get(0));
            setMeta(meta);
            return this;
        }
        FireworkMeta meta2 = getMeta();
        meta2.addEffects(list);
        setMeta(meta2);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public FireworkBuilder power(int i) {
        if (getItemStack().getType() == ROCKET) {
            FireworkMeta meta = getMeta();
            meta.setPower(i);
            setMeta(meta);
        }
        return this;
    }
}

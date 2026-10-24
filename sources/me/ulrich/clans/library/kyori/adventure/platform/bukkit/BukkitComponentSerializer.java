package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Facet;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.legacyimpl.NBTLegacyHoverEventSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitComponentSerializer.class */
public final class BukkitComponentSerializer {
    private static final boolean IS_1_13;
    private static final boolean IS_1_16;
    private static final Collection<FacetComponentFlattener.Translator<Server>> TRANSLATORS;
    private static final LegacyComponentSerializer LEGACY_SERIALIZER;
    private static final GsonComponentSerializer GSON_SERIALIZER;
    static final ComponentFlattener FLATTENER;

    private BukkitComponentSerializer() {
    }

    @NotNull
    public static LegacyComponentSerializer legacy() {
        return LEGACY_SERIALIZER;
    }

    @NotNull
    public static GsonComponentSerializer gson() {
        return GSON_SERIALIZER;
    }

    static {
        IS_1_13 = MinecraftReflection.findEnum(Material.class, "BLUE_ICE") != null;
        IS_1_16 = MinecraftReflection.findEnum(Material.class, "NETHERITE_PICKAXE") != null;
        TRANSLATORS = Facet.of(SpigotFacet.Translator::new, CraftBukkitFacet.Translator::new);
        FLATTENER = FacetComponentFlattener.get(Bukkit.getServer(), TRANSLATORS);
        if (IS_1_13) {
            GSON_SERIALIZER = GsonComponentSerializer.builder().options((OptionState) JSONOptions.byDataVersion().at(Bukkit.getUnsafe().getDataVersion())).build2();
        } else {
            GSON_SERIALIZER = GsonComponentSerializer.builder().legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.get()).options((OptionState) JSONOptions.byDataVersion().at(0)).build2();
        }
        if (IS_1_16) {
            LEGACY_SERIALIZER = LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().flattener(FLATTENER).build2();
        } else {
            LEGACY_SERIALIZER = LegacyComponentSerializer.builder().character((char) 167).flattener(FLATTENER).build2();
        }
    }
}

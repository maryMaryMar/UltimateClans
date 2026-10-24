package me.ulrich.clans.library.kyori.adventure.text.serializer.craftbukkit;

import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/craftbukkit/BukkitComponentSerializer.class */
@Deprecated
public final class BukkitComponentSerializer {
    private BukkitComponentSerializer() {
    }

    @NotNull
    public static LegacyComponentSerializer legacy() {
        return me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitComponentSerializer.legacy();
    }

    @NotNull
    public static GsonComponentSerializer gson() {
        return me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitComponentSerializer.gson();
    }
}

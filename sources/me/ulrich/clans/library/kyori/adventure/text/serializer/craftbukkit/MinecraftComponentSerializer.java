package me.ulrich.clans.library.kyori.adventure.text.serializer.craftbukkit;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/craftbukkit/MinecraftComponentSerializer.class */
@Deprecated
public final class MinecraftComponentSerializer implements ComponentSerializer<Component, Component, Object> {
    private static final MinecraftComponentSerializer INSTANCE = new MinecraftComponentSerializer();
    private final me.ulrich.clans.library.kyori.adventure.platform.bukkit.MinecraftComponentSerializer realSerial = me.ulrich.clans.library.kyori.adventure.platform.bukkit.MinecraftComponentSerializer.get();

    public static boolean isSupported() {
        return me.ulrich.clans.library.kyori.adventure.platform.bukkit.MinecraftComponentSerializer.isSupported();
    }

    @NotNull
    public static MinecraftComponentSerializer get() {
        return INSTANCE;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public Component deserialize(@NotNull Object obj) {
        return this.realSerial.deserialize(obj);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public Object serialize(@NotNull Component component) {
        return this.realSerial.serialize(component);
    }
}

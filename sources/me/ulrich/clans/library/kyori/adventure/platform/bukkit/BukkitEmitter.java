package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import org.bukkit.entity.Entity;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitEmitter.class */
final class BukkitEmitter implements Sound.Emitter {
    final Entity entity;

    BukkitEmitter(Entity entity) {
        this.entity = entity;
    }
}

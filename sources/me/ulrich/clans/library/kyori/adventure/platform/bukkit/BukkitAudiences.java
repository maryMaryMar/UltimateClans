package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider;
import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitAudiences.class */
public interface BukkitAudiences extends AudienceProvider {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitAudiences$Builder.class */
    public interface Builder extends AudienceProvider.Builder<BukkitAudiences, Builder> {
    }

    @NotNull
    static BukkitAudiences create(@NotNull Plugin plugin) {
        return BukkitAudiencesImpl.instanceFor(plugin);
    }

    @NotNull
    static Builder builder(@NotNull Plugin plugin) {
        return BukkitAudiencesImpl.builder(plugin);
    }

    static Sound.Emitter asEmitter(@NotNull Entity entity) {
        return new BukkitEmitter(entity);
    }

    @NotNull
    Audience sender(@NotNull CommandSender commandSender);

    @NotNull
    Audience player(@NotNull Player player);

    @NotNull
    Audience filter(@NotNull Predicate<CommandSender> predicate);
}

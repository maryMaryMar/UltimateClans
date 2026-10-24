package me.ulrich.clans.interfaces;

import java.util.Optional;
import me.ulrich.clans.data.AnvilSession;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/AnvilModuleAPI.class */
public interface AnvilModuleAPI {
    boolean supports();

    AnvilSession open(Player player, String str, Optional<String> optional, Optional<ItemStack> optional2, Optional<ItemStack> optional3, Optional<ItemStack> optional4, AnvilClickHandler anvilClickHandler);

    boolean isInternal();

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

package me.ulrich.clans.interfaces;

import java.util.Optional;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ItemParseImplement.class */
public interface ItemParseImplement {
    ItemStack getItem(String str);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();
}

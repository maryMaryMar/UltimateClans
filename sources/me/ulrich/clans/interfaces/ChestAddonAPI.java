package me.ulrich.clans.interfaces;

import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ChestAddonAPI.class */
public interface ChestAddonAPI {
    String parseText(UUID uuid, String str);

    Optional<String> consultInUse_REAL(UUID uuid);

    ClanEnum.BuyChestResponse buyExtra(Player player, UUID uuid);

    int chestCount(ClanData clanData, Player player);

    boolean testPutNbt(ItemStack itemStack);

    boolean hasModelData(ItemStack itemStack, int i);
}

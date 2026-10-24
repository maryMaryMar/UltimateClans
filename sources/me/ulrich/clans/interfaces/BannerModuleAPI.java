package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.BannerGroupData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/BannerModuleAPI.class */
public interface BannerModuleAPI {
    boolean canUploadMaterial(UUID uuid, ItemStack itemStack);

    List<Material> getAllBannerEnabledListDistict(UUID uuid);

    List<ItemStack> getAllBannerEnabledList(UUID uuid);

    List<ItemStack> getBannerEnabledList(UUID uuid, ClanEnum.BannerFilter bannerFilter);

    Optional<BannerGroupData> getConvertedBanners(String... strArr);

    Optional<ItemStack> loadBanner(JSONObject jSONObject, String str);

    Optional<ItemStack> getSkinBlock(String str);

    List<Material> collectItemsByPrefixSuffix(String str, String str2);

    List<Material> collectItemsByAll();

    boolean deleteBanner(UUID uuid, Player player);

    boolean setBanner(UUID uuid, Player player, ItemStack itemStack);

    Optional<ItemStack> getBanner(UUID uuid);

    Optional<BannerGroupData> bannerCount(ClanData clanData);
}

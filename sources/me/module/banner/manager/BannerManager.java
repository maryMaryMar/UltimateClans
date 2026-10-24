package me.module.banner.manager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.BannerGroupData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.interfaces.BannerModuleAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/BannerManager.class */
public class BannerManager implements BannerModuleAPI {
    public BannerManager() {
        b.a();
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public boolean canUploadMaterial(UUID uuid, ItemStack itemStack) {
        return b.a(uuid, itemStack);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public List<Material> getAllBannerEnabledListDistict(UUID uuid) {
        return b.a(uuid);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public List<ItemStack> getAllBannerEnabledList(UUID uuid) {
        return b.b(uuid);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public List<ItemStack> getBannerEnabledList(UUID uuid, ClanEnum.BannerFilter bannerFilter) {
        return b.a(uuid, bannerFilter);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public Optional<BannerGroupData> getConvertedBanners(String... strArr) {
        return b.a(strArr);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public Optional<ItemStack> loadBanner(JSONObject jSONObject, String str) {
        return b.a(jSONObject, str);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public Optional<ItemStack> getSkinBlock(String str) {
        return b.a(str);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public List<Material> collectItemsByPrefixSuffix(String str, String str2) {
        return b.a(str, str2);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public List<Material> collectItemsByAll() {
        return b.b();
    }

    public Optional<ItemStack> loadBanner(Object obj, String str) {
        return loadBanner((JSONObject) obj, str);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public boolean deleteBanner(UUID uuid, Player player) {
        return b.a(uuid, player);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public boolean setBanner(UUID uuid, Player player, ItemStack itemStack) {
        return b.a(uuid, player, itemStack);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public Optional<ItemStack> getBanner(UUID uuid) {
        return b.c(uuid);
    }

    @Override // me.ulrich.clans.interfaces.BannerModuleAPI
    public Optional<BannerGroupData> bannerCount(ClanData clanData) {
        return b.a(clanData);
    }
}

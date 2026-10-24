package me.module.rewards.manager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.RewardsData;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/RewardsManager.class */
public class RewardsManager implements RewardsModuleAPI {
    public RewardsManager() {
        f.a();
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public String parseText(UUID uuid, String str) {
        return f.a(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public void SaveRewardsData(RewardsData rewardsData) {
        f.a(rewardsData);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public void DeleteRewardsData(UUID uuid) {
        f.a(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public void ReloadRewardsData(UUID uuid) {
        f.b(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public void ClearRewardsData(UUID uuid) {
        f.c(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public void LoadAllRewardsData() {
        f.b();
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public boolean hasClanRewards(UUID uuid) {
        return f.d(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public List<RewardsData> getClanRewards(UUID uuid) {
        return f.e(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public boolean hasClanCollectedSurprise(UUID uuid, int i) {
        return f.a(uuid, i);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public boolean hasPlayerRewards(UUID uuid) {
        return f.f(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public List<RewardsData> getPlayerRewards(UUID uuid) {
        return f.g(uuid);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public boolean playerCollectReward(UUID uuid, UUID uuid2) {
        return f.a(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public boolean addClanReward(UUID uuid, UUID uuid2, Optional<String> optional, Optional<Material> optional2, List<String> list, Optional<String> optional3) {
        return f.a(uuid, uuid2, optional, optional2, list, optional3);
    }

    @Override // me.ulrich.clans.interfaces.RewardsModuleAPI
    public ConcurrentHashMap<UUID, RewardsData> getRewardsData() {
        return f.f();
    }
}

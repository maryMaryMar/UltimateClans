package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.RewardsData;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/RewardsModuleAPI.class */
public interface RewardsModuleAPI {
    String parseText(UUID uuid, String str);

    void SaveRewardsData(RewardsData rewardsData);

    void DeleteRewardsData(UUID uuid);

    void ReloadRewardsData(UUID uuid);

    void ClearRewardsData(UUID uuid);

    void LoadAllRewardsData();

    boolean hasClanRewards(UUID uuid);

    List<RewardsData> getClanRewards(UUID uuid);

    boolean hasClanCollectedSurprise(UUID uuid, int i);

    boolean hasPlayerRewards(UUID uuid);

    List<RewardsData> getPlayerRewards(UUID uuid);

    boolean playerCollectReward(UUID uuid, UUID uuid2);

    boolean addClanReward(UUID uuid, UUID uuid2, Optional<String> optional, Optional<Material> optional2, List<String> list, Optional<String> optional3);

    ConcurrentHashMap<UUID, RewardsData> getRewardsData();
}

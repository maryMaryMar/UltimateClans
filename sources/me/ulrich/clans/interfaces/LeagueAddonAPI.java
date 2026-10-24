package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.LeagueData;
import me.ulrich.clans.data.addons.LeaguePointsRecordData;
import me.ulrich.clans.data.addons.LeagueSeasonData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/LeagueAddonAPI.class */
public interface LeagueAddonAPI {
    String parseText(UUID uuid, String str);

    void SaveLeagueData(LeagueData leagueData, boolean z);

    void DeleteLeagueData(UUID uuid, boolean z);

    void ReloadLeagueData(UUID uuid, boolean z);

    void ClearLeagueData(UUID uuid, boolean z);

    void LoadAllLeagueData(boolean z);

    boolean hasClanLeague(UUID uuid);

    List<LeagueData> getClanLeague(UUID uuid);

    Optional<LeagueData> getLeagueById(UUID uuid);

    List<LeagueData> getClanLeagueSeason(UUID uuid, UUID uuid2);

    double getMergedClanPoints(UUID uuid, UUID uuid2);

    double getMergedClanPointsOLD(UUID uuid, UUID uuid2);

    Map<UUID, LeaguePointsRecordData> getAllLeagueTimed(UUID uuid);

    HashMap<UUID, Double> getAllLeagueTimedOLD(UUID uuid);

    boolean removeClanLeague(UUID uuid, UUID uuid2);

    List<LeagueSeasonData> findUnclaimed(UUID uuid);

    boolean clearClanLeague(UUID uuid);

    boolean addClanLeague(UUID uuid, double d, String str, AddonEnum.LeagueEventAction leagueEventAction);

    boolean compareEvent(AddonEnum.LeagueTime leagueTime, long j);

    ConcurrentHashMap<UUID, List<LeagueData>> getLeagueData();

    void SaveLeagueSeasonData(LeagueSeasonData leagueSeasonData);

    void DeleteLeagueSeasonData(UUID uuid);

    void ReloadLeagueSeasonData(UUID uuid);

    void LoadAllLeagueSeasonData();

    boolean hasSeason(String str);

    boolean hasSeason(UUID uuid);

    Optional<LeagueSeasonData> getSeason(String str);

    Optional<LeagueSeasonData> getSeason(UUID uuid);

    List<LeagueSeasonData> findSeasonsPeriod(long j);

    boolean hasSeasonInDates(long j, long j2);

    Optional<LeagueSeasonData> getSeasonsCurrent(long j);

    List<LeagueSeasonData> getSeasonsCurrentOrGreater(long j);

    List<LeagueSeasonData> getSeasonsByStatus(AddonEnum.LeagueStatus leagueStatus);

    boolean deleteSeason(UUID uuid);

    Optional<LeagueSeasonData> createNewSeason(String str, long j, long j2);

    boolean setSeasonIcon(UUID uuid, Material material);

    boolean setSeasonStatus(UUID uuid, AddonEnum.LeagueStatus leagueStatus);

    boolean setSeasonDesc(UUID uuid, String str);

    boolean setSeasonWinner(UUID uuid, Optional<UUID> optional);

    boolean setSeasonStart(UUID uuid, long j);

    boolean setSeasonStop(UUID uuid, long j);

    boolean addSeasonItem(UUID uuid, ItemStack itemStack);

    boolean isSeasonCollectedPlayer(UUID uuid, UUID uuid2);

    boolean addSeasonCollectedPlayer(UUID uuid, UUID uuid2);

    boolean removeSeasonItem(UUID uuid, int i);

    boolean addSeasonCommand(UUID uuid, String str);

    boolean removeSeasonCommand(UUID uuid, int i);

    void initializeSeason(UUID uuid, long j);

    void finalizeSeason(UUID uuid, long j);

    ConcurrentHashMap<UUID, LeagueSeasonData> getLeagueSeasonData();
}

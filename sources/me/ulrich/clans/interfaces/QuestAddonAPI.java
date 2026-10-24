package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.ClanQuestData;
import me.ulrich.clans.data.addons.QuestData;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/QuestAddonAPI.class */
public interface QuestAddonAPI {
    String parseText(UUID uuid, String str);

    void saveAllQueue();

    Optional<UUID> getPlayerMode(UUID uuid);

    boolean removePlayerCourse(Player player);

    boolean removePlayerCourse(UUID uuid);

    boolean addPlayerCourse(Player player, QuestData questData);

    boolean islandInQuest(UUID uuid);

    boolean islandInQuest(UUID uuid, String str);

    Optional<ClanQuestData> getIslandInQuest(UUID uuid, String str);

    boolean playerIsInQUest(Player player, String str);

    AddonEnum.QuestMissionType getPlayerQuestType(Player player);

    AddonEnum.QuestMissionType getPlayerQuestType(UUID uuid);

    Optional<ClanQuestData> getPlayerQuest(Player player);

    Optional<ClanQuestData> getPlayerQuest(UUID uuid);

    Optional<ClanQuestData> getPlayerQuest(UUID uuid, String str);

    Optional<ClanQuestData> isPlayerFinishedQuest(UUID uuid, String str);

    Optional<ClanQuestData> getPlayerClanQuest(UUID uuid, String str);

    void finishQuest(Player player, String str);

    void updatePlayerQuest(Player player, String str, int i);

    boolean questExists(String str);

    boolean questHasType(String str, AddonEnum.QuestType questType);

    boolean questHasTypeWhitelist(String str, AddonEnum.QuestType questType, String str2);

    QuestData getQuestByName(String str);

    boolean checkWhitelistItem(String str, AddonEnum.QuestType questType);

    void sendWarning(AddonEnum.QuestWarn questWarn, List<Player> list, QuestData questData, int i);

    HashMap<Player, Location> getLocFly();

    void loadAllQuests();

    void loadQuest(String str);

    String translateOptional(AddonEnum.QuestType questType, String str);

    Optional<ClanEnum.TranslatableKey> findTranslateType(AddonEnum.QuestType questType);

    HashMap<String, QuestData> getQuestData();

    HashMap<UUID, List<ClanQuestData>> getIslandQuest();

    HashMap<UUID, String> getRemoveDaily();

    HashMap<AddonEnum.QuestType, List<String>> getQuestFollow();

    HashMap<Player, List<Location>> getQuestFollower();

    HashMap<Player, Location> getLocWalk();

    HashMap<Player, ClanQuestData> getQuestToSave();
}

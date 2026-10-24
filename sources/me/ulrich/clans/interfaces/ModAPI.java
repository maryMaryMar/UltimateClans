package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ModerationData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ModAPI.class */
public interface ModAPI {
    void saveModerationData(UUID uuid, HashMap<String, HashMap<String, Boolean>> map);

    void deleteModerationData(UUID uuid);

    void loadModerationData(UUID uuid);

    void loadAllModerationData(boolean z);

    Optional<ModerationData> getLeaderRole();

    Optional<ModerationData> getFirstRoleId();

    HashMap<String, HashMap<String, Boolean>> getClanModeration(UUID uuid);

    boolean playerHasPermission(UUID uuid, String str);

    Optional<ModerationData> getPlayerRole(UUID uuid);

    Optional<ModerationData> getPlayerNextRole(UUID uuid);

    Optional<ModerationData> getPlayerPreviousRole(UUID uuid);

    HashMap<String, ModerationData> getDefaultModerationData();

    HashMap<UUID, HashMap<String, HashMap<String, Boolean>>> getModerationData();

    HashMap<String, HashMap<String, Boolean>> syncClanModeration(UUID uuid);
}

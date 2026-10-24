package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PatentData;
import me.ulrich.clans.data.RequerimentData;
import me.ulrich.clans.data.RequerimentData_Return;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/LevelupModuleAPI.class */
public interface LevelupModuleAPI {
    String parseText(UUID uuid, String str);

    void LoadRequeriments();

    boolean hasRequeriment(int i);

    Optional<RequerimentData> getRequeriment(int i);

    boolean isRequerimentSurprise(int i);

    Optional<Integer> clanCurrentLevel(UUID uuid);

    Optional<Integer> clanNextLevel(UUID uuid);

    boolean clanInLevelSurprise(UUID uuid);

    boolean clanIsLevelPassed(UUID uuid, int i);

    Optional<Integer> clanMaxLevelReached(UUID uuid);

    List<RequerimentData_Return> getClanRequeriments(UUID uuid);

    List<RequerimentData_Return> getPlayerClanRequeriments(UUID uuid);

    boolean hasPlayerClanRequeriments(UUID uuid);

    boolean hasClanRequeriments(UUID uuid);

    boolean checkUpgradeLevel(UUID uuid);

    boolean checkDowngradeLevel(UUID uuid);

    void LoadAllPatents();

    boolean patentExists(String str);

    Optional<PatentData> getPatent(String str);

    Optional<PatentData> getFirstPatent();

    Optional<PatentData> getLevelCurrentPatent(int i);

    Optional<PatentData> getClanCurrentPatent(UUID uuid);

    double calcXpForLevel(int i);

    int calculateFullTargetXp(int i);

    int calculateLevel(double d);

    int getPointsNextLevel(ClanData clanData);

    void check_actions(ClanEnum.ClanActions clanActions, UUID uuid);

    boolean addPoint(UUID uuid, int i, CommandSender commandSender, StringBuilder sb);

    boolean removePoint(UUID uuid, int i, CommandSender commandSender, StringBuilder sb);

    boolean setPoint(UUID uuid, int i, CommandSender commandSender, StringBuilder sb);

    ConcurrentHashMap<String, PatentData> getPatentData();

    ConcurrentHashMap<Integer, RequerimentData> getRequerimentData();
}

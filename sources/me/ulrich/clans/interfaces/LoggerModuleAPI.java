package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/LoggerModuleAPI.class */
public interface LoggerModuleAPI {
    String parseText(UUID uuid, String str);

    void SaveLoggerData(LoggerData loggerData);

    void DeleteLoggerData(LoggerData loggerData);

    void ReloadLoggerData(UUID uuid);

    void ClearLoggerData(UUID uuid);

    void LoadAllLoggerData();

    boolean hasClanLogger(UUID uuid);

    List<LoggerData> getClanLogger(UUID uuid);

    List<LoggerData> getClanLoggerTimed(UUID uuid, ClanEnum.LoggerTime loggerTime);

    List<LoggerData> getPluginLogger(UUID uuid, String str);

    Optional<LoggerData> getPluginLogger(UUID uuid, UUID uuid2);

    boolean removeClanLogger(UUID uuid, UUID uuid2);

    boolean removeClanPluginLogger(UUID uuid, String str);

    boolean clearClanLogger(UUID uuid);

    boolean addClanLogger(UUID uuid, String str, String str2, Material material);

    boolean compareEvent(ClanEnum.LoggerTime loggerTime, long j);

    ConcurrentHashMap<UUID, List<LoggerData>> getLoggerData();
}

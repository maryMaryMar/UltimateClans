package me.module.logger.manager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.interfaces.LoggerModuleAPI;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/LoggerManager.class */
public class LoggerManager implements LoggerModuleAPI {
    public LoggerManager() {
        e.a();
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public ConcurrentHashMap<UUID, List<LoggerData>> getLoggerData() {
        return e.b();
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public void SaveLoggerData(LoggerData loggerData) {
        e.a(loggerData);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public void DeleteLoggerData(LoggerData loggerData) {
        e.b(loggerData);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public void ReloadLoggerData(UUID uuid) {
        e.a(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public void ClearLoggerData(UUID uuid) {
        e.b(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public void LoadAllLoggerData() {
        e.c();
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public boolean hasClanLogger(UUID uuid) {
        return e.c(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public List<LoggerData> getClanLogger(UUID uuid) {
        return e.d(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public List<LoggerData> getClanLoggerTimed(UUID uuid, ClanEnum.LoggerTime loggerTime) {
        return e.a(uuid, loggerTime);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public List<LoggerData> getPluginLogger(UUID uuid, String str) {
        return e.a(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public Optional<LoggerData> getPluginLogger(UUID uuid, UUID uuid2) {
        return e.a(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public boolean removeClanLogger(UUID uuid, UUID uuid2) {
        return e.b(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public boolean removeClanPluginLogger(UUID uuid, String str) {
        return e.b(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public boolean clearClanLogger(UUID uuid) {
        return e.e(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public boolean addClanLogger(UUID uuid, String str, String str2, Material material) {
        return e.a(uuid, str, str2, material);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public boolean compareEvent(ClanEnum.LoggerTime loggerTime, long j) {
        return e.a(loggerTime, j);
    }

    @Override // me.ulrich.clans.interfaces.LoggerModuleAPI
    public String parseText(UUID uuid, String str) {
        return e.c(uuid, str);
    }
}

package me.module.levelup.manager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PatentData;
import me.ulrich.clans.data.RequerimentData;
import me.ulrich.clans.data.RequerimentData_Return;
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/LevelupManager.class */
public class LevelupManager implements LevelupModuleAPI {
    public LevelupManager() {
        c.a();
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public String parseText(UUID uuid, String str) {
        return c.a(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public void LoadRequeriments() {
        c.b();
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean hasRequeriment(int i) {
        return c.a(i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<RequerimentData> getRequeriment(int i) {
        return c.b(i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean isRequerimentSurprise(int i) {
        return c.c(i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<Integer> clanCurrentLevel(UUID uuid) {
        return c.a(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<Integer> clanNextLevel(UUID uuid) {
        return c.b(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean clanInLevelSurprise(UUID uuid) {
        return c.c(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean clanIsLevelPassed(UUID uuid, int i) {
        return c.a(uuid, i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<Integer> clanMaxLevelReached(UUID uuid) {
        return c.d(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public List<RequerimentData_Return> getClanRequeriments(UUID uuid) {
        return c.e(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public List<RequerimentData_Return> getPlayerClanRequeriments(UUID uuid) {
        return c.f(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean hasPlayerClanRequeriments(UUID uuid) {
        return c.g(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean hasClanRequeriments(UUID uuid) {
        return c.h(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean checkUpgradeLevel(UUID uuid) {
        return c.i(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean checkDowngradeLevel(UUID uuid) {
        return c.j(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public void LoadAllPatents() {
        c.c();
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean patentExists(String str) {
        return c.a(str);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<PatentData> getPatent(String str) {
        return c.b(str);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<PatentData> getFirstPatent() {
        return c.d();
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<PatentData> getLevelCurrentPatent(int i) {
        return c.d(i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public Optional<PatentData> getClanCurrentPatent(UUID uuid) {
        return c.k(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public double calcXpForLevel(int i) {
        return c.e(i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public int calculateFullTargetXp(int i) {
        return c.f(i);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public int calculateLevel(double d) {
        return c.a(d);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public int getPointsNextLevel(ClanData clanData) {
        return c.a(clanData);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public void check_actions(ClanEnum.ClanActions clanActions, UUID uuid) {
        c.a(clanActions, uuid);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean addPoint(UUID uuid, int i, CommandSender commandSender, StringBuilder sb) {
        return c.a(uuid, i, commandSender, sb);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean removePoint(UUID uuid, int i, CommandSender commandSender, StringBuilder sb) {
        return c.b(uuid, i, commandSender, sb);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public boolean setPoint(UUID uuid, int i, CommandSender commandSender, StringBuilder sb) {
        return c.c(uuid, i, commandSender, sb);
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public ConcurrentHashMap<String, PatentData> getPatentData() {
        return c.h();
    }

    @Override // me.ulrich.clans.interfaces.LevelupModuleAPI
    public ConcurrentHashMap<Integer, RequerimentData> getRequerimentData() {
        return c.i();
    }
}

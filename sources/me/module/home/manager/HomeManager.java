package me.module.home.manager;

import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.interfaces.HomeModuleAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/HomeManager.class */
public class HomeManager implements HomeModuleAPI {
    public HomeManager() {
        d.a();
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public boolean deleteHome(UUID uuid, String str) {
        return d.a(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public boolean setHome(UUID uuid, Location location, String str) {
        return d.a(uuid, location, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public boolean setHome(UUID uuid, Location location, String str, Optional<String> optional) {
        return d.a(uuid, location, str, optional);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public boolean hasHome(UUID uuid, String str) {
        return d.c(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public Optional<Location> getHomeLocation(UUID uuid, String str) {
        return d.d(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public Optional<EncodedLocationData> getEncodedHomeLocation(UUID uuid, String str) {
        return d.e(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public Optional<HomesData> getHomeData(UUID uuid, String str) {
        return d.f(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public String parseText(UUID uuid, String str) {
        return d.b(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.HomeModuleAPI
    public int homeCount(ClanData clanData) {
        return d.a(clanData);
    }

    public boolean tryCreateHome(Player player, String str) {
        return d.b(player, str);
    }

    public boolean createOfflineHome(UUID uuid, Location location, String str, Optional<String> optional) {
        return d.b(uuid, location, str, optional);
    }

    public boolean tryCreateHome(Player player, String str, Optional<String> optional) {
        return d.a(player, str, optional);
    }
}

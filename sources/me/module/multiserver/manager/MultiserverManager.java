package me.module.multiserver.manager;

import java.util.UUID;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.interfaces.MultiserverModuleAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/manager/MultiserverManager.class */
public class MultiserverManager implements MultiserverModuleAPI {
    public MultiserverManager() {
        b.a();
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public boolean syncEnabled() {
        return b.c();
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void sendSync(String str, String str2) {
        b.a(str, str2);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void sendSync(String str, UUID uuid) {
        b.a(str, uuid);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void serverConnector(Player player, String str) {
        b.a(player, str);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void debugMessage(ClanEnum.DebugType debugType, String str) {
        b.a(debugType, str);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public String getServerName() {
        return b.e();
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void addPendingLocation(UUID uuid, String str, double d, double d2, double d3, float f, float f2) {
        b.a(uuid, str, d, d2, d3, f, f2);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void teleportOrQueue(UUID uuid, Location location) {
        b.a(uuid, location);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public void runPendingTeleport(Player player) {
        b.a(player);
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public String getOutGoindChannel() {
        return b.f();
    }

    @Override // me.ulrich.clans.interfaces.MultiserverModuleAPI
    public String getInComingChannel() {
        return b.g();
    }
}

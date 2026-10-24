package me.ulrich.clans.interfaces;

import java.util.UUID;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/MultiserverModuleAPI.class */
public interface MultiserverModuleAPI {
    boolean syncEnabled();

    void sendSync(String str, String str2);

    void sendSync(String str, UUID uuid);

    void serverConnector(Player player, String str);

    void debugMessage(ClanEnum.DebugType debugType, String str);

    void addPendingLocation(UUID uuid, String str, double d, double d2, double d3, float f, float f2);

    void teleportOrQueue(UUID uuid, Location location);

    void runPendingTeleport(Player player);

    String getOutGoindChannel();

    String getInComingChannel();

    String getServerName();
}

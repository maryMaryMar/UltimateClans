package me.ulrich.clans.manager.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.java_websocket.framing.CloseFrame;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/CooldownAPI.class */
public class CooldownAPI {
    private static Map<String, CooldownAPI> cooldowns = new HashMap();
    private long start;
    private final int timeInSeconds;
    private final UUID id;
    private final String cooldownName;

    public CooldownAPI(UUID uuid, String str, int i) {
        this.id = uuid;
        this.cooldownName = str;
        this.timeInSeconds = i;
    }

    public static boolean isInCooldown(UUID uuid, String str) {
        if (getTimeLeft(uuid, str) >= 1) {
            return true;
        }
        stop(uuid, str);
        return false;
    }

    private static void stop(UUID uuid, String str) {
        cooldowns.remove(String.valueOf(uuid) + str);
    }

    private static CooldownAPI getCooldown(UUID uuid, String str) {
        return cooldowns.get(uuid.toString() + str);
    }

    public static int getTimeLeft(UUID uuid, String str) {
        CooldownAPI cooldown = getCooldown(uuid, str);
        int iCurrentTimeMillis = -1;
        if (cooldown != null) {
            iCurrentTimeMillis = ((((int) (System.currentTimeMillis() - cooldown.start)) / CloseFrame.NORMAL) - cooldown.timeInSeconds) * (-1);
        }
        return iCurrentTimeMillis;
    }

    public void start() {
        this.start = System.currentTimeMillis();
        cooldowns.put(this.id.toString() + this.cooldownName, this);
    }
}

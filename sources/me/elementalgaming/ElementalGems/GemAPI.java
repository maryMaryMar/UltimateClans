package me.elementalgaming.ElementalGems;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Elementalgems.jar:me/elementalgaming/ElementalGems/GemAPI.class */
public class GemAPI {
    private static ElementalGems instance;

    public static HashMap<UUID, Long> getRegisteredPlayers() {
        instance.getGemAPI();
        return getRegisteredPlayers();
    }

    public static double getGems(UUID uuid) {
        instance.getGemAPI();
        return getGems(uuid);
    }

    public static void setGems(UUID uuid, double newBalance) {
        instance.getGemAPI();
        setGems(uuid, newBalance);
    }

    public static void addGems(UUID uuid, double depositAmount) {
        instance.getGemAPI();
        addGems(uuid, depositAmount);
    }

    public static void removeGems(UUID uuid, double withdrawAmount) {
        instance.getGemAPI();
        removeGems(uuid, withdrawAmount);
    }

    public static boolean playerExists(UUID uuid) {
        instance.getGemAPI();
        return playerExists(uuid);
    }

    public static ItemStack getGemItem() {
        instance.getGemAPI();
        return getGemItem();
    }

    public static void registerNewPlayer(UUID uuid) {
        instance.getGemAPI();
        registerNewPlayer(uuid);
    }
}

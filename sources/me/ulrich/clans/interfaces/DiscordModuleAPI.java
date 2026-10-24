package me.ulrich.clans.interfaces;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/DiscordModuleAPI.class */
public interface DiscordModuleAPI {
    boolean sendDiscordNotification(UUID uuid, String str);

    boolean registerClan(UUID uuid);

    boolean unregisterClan(UUID uuid);

    void unlinkDiscordChannel(UUID uuid);

    boolean sendDiscordChat(UUID uuid, UUID uuid2, String str, boolean z);

    boolean isConnectedClan(UUID uuid);

    String parseText(UUID uuid, String str);
}

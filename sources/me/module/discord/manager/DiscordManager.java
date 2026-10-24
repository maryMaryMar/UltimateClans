package me.module.discord.manager;

import java.util.UUID;
import me.ulrich.clans.interfaces.DiscordModuleAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/DiscordManager.class */
public class DiscordManager implements DiscordModuleAPI {
    public DiscordManager() {
        DiscordPublicManager.initiate();
    }

    public ClanWebSocketClient getClanConnection(UUID uuid) {
        return DiscordPublicManager.getClanConnection(uuid);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public boolean isConnectedClan(UUID uuid) {
        return DiscordPublicManager.isConnectedClan(uuid);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public boolean sendDiscordChat(UUID uuid, UUID uuid2, String str, boolean z) {
        return DiscordPublicManager.sendDiscordChat(uuid, uuid2, str, z);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public boolean sendDiscordNotification(UUID uuid, String str) {
        return DiscordPublicManager.sendDiscordNotification(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public boolean registerClan(UUID uuid) {
        return DiscordPublicManager.registerClan(uuid);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public void unlinkDiscordChannel(UUID uuid) {
        DiscordPublicManager.unlinkDiscordChannel(uuid);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public boolean unregisterClan(UUID uuid) {
        return DiscordPublicManager.unregisterClan(uuid);
    }

    @Override // me.ulrich.clans.interfaces.DiscordModuleAPI
    public String parseText(UUID uuid, String str) {
        return DiscordPublicManager.parseText(uuid, str);
    }
}

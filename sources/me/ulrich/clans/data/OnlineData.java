package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/OnlineData.class */
public class OnlineData {
    private UUID playerUUID;
    private String playerName;
    private String server;

    public OnlineData(UUID uuid, String str, String str2) {
        setPlayerUUID(uuid);
        setPlayerName(str);
        setServer(str2);
    }

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    public void setPlayerUUID(UUID uuid) {
        this.playerUUID = uuid;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String str) {
        this.playerName = str;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String str) {
        this.server = str;
    }
}

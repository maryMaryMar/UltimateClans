package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/PlayerData.class */
public class PlayerData {
    private UUID id;
    private String name;
    private UUID uuid;
    private int kills;
    private int deaths;
    private int souls;
    private double kdr;
    private long joinDate;
    private long lastSeen;
    private String cache;
    private String nickname;
    private String customSkin;
    private PlayerData_Settings settings;
    private String role;
    private long loadCache;
    private boolean lockedChat;
    private boolean clan;
    private String lang;

    public PlayerData(UUID uuid, String str, UUID uuid2, int i, int i2, int i3, double d, long j, long j2, String str2, String str3, String str4, PlayerData_Settings playerData_Settings, String str5, long j3, boolean z, String str6) {
        setId(uuid);
        setName(str);
        setUuid(uuid2);
        setKills(i);
        setDeaths(i2);
        setSouls(i3);
        setKdr(d);
        setJoinDate(j);
        setLastSeen(j2);
        setCache(str2);
        setNickname(str3);
        setCustomSkin(str4);
        setSettings(playerData_Settings);
        setRole(str5);
        setLoadCache(j3);
        setLockedChat(z);
        setClan(false);
        setLang(str6);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getKills() {
        return this.kills;
    }

    public void setKills(int i) {
        this.kills = i;
    }

    public int getDeaths() {
        return this.deaths;
    }

    public void setDeaths(int i) {
        this.deaths = i;
    }

    public int getSouls() {
        return this.souls;
    }

    public void setSouls(int i) {
        this.souls = i;
    }

    public double getKdr() {
        return this.kdr;
    }

    public void setKdr(double d) {
        this.kdr = d;
    }

    public long getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(long j) {
        this.joinDate = j;
    }

    public long getLastSeen() {
        return this.lastSeen;
    }

    public void setLastSeen(long j) {
        this.lastSeen = j;
    }

    public String getCache() {
        return this.cache;
    }

    public void setCache(String str) {
        this.cache = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getCustomSkin() {
        return this.customSkin;
    }

    public void setCustomSkin(String str) {
        this.customSkin = str;
    }

    public PlayerData_Settings getSettings() {
        return this.settings;
    }

    public void setSettings(PlayerData_Settings playerData_Settings) {
        this.settings = playerData_Settings;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public long getLoadCache() {
        return this.loadCache;
    }

    public void setLoadCache(long j) {
        this.loadCache = j;
    }

    public boolean isLockedChat() {
        return this.lockedChat;
    }

    public void setLockedChat(boolean z) {
        this.lockedChat = z;
    }

    public boolean hasClan() {
        return this.clan;
    }

    public void setClan(boolean z) {
        this.clan = z;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}

package me.ulrich.clans.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanData.class */
public class ClanData {
    private UUID id;
    private String tag;
    private String desc;
    private UUID leader;
    private boolean verified;
    private List<HomesData> home;
    private long creationDate;
    private ClanStats stats;
    private List<UUID> members;
    private List<UUID> onlineMembers;
    private boolean ff;
    private double kdr;
    private String tagNoColor;
    private List<UUID> mods;
    private ClanRivalAlly rivalAlly;
    private Double bank;
    private int level;
    private ClanQuestInfoData quest;
    private SettingsData settings;
    private ChestSettingsData chestSettings;
    private String banner;
    private int maxlevel;
    private int extraSlots;
    private List<UUID> banned;
    private String patent;
    private String webhook;
    private long loadCache;

    public ClanData(UUID uuid, String str, String str2, UUID uuid2, boolean z, List<HomesData> list, long j, ClanStats clanStats, List<UUID> list2, List<UUID> list3, boolean z2, double d, String str3, List<UUID> list4, List<UUID> list5, ClanRivalAlly clanRivalAlly, Double d2, int i, ClanQuestInfoData clanQuestInfoData, SettingsData settingsData, ChestSettingsData chestSettingsData, String str4, int i2, int i3, String str5, String str6, long j2) {
        setId(uuid);
        setTag(str);
        setDesc(str2);
        setLeader(uuid2);
        setVerified(z);
        setHome(list);
        setCreationDate(j);
        setStats(clanStats);
        setMembers(list2);
        setOnlineMembers(list3);
        setFf(z2);
        setKdr(d);
        setTagNoColor(str3);
        setMods(list4);
        setRivalAlly(clanRivalAlly);
        setBank(d2);
        setLevel(i);
        setQuest(clanQuestInfoData);
        setSettings(settingsData);
        setChestSettings(chestSettingsData);
        setBanner(str4);
        setMaxlevel(i2);
        setExtraSlots(i3);
        setBanned(list5);
        setPatent(str5);
        setWebhook(str6);
        setLoadCache(j2);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public UUID getLeader() {
        return this.leader;
    }

    public void setLeader(UUID uuid) {
        this.leader = uuid;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }

    public List<HomesData> getHome() {
        return this.home;
    }

    public long getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(long j) {
        this.creationDate = j;
    }

    public ClanStats getStats() {
        return this.stats;
    }

    public void setStats(ClanStats clanStats) {
        this.stats = clanStats;
    }

    public List<UUID> getMembers() {
        return this.members;
    }

    public void setMembers(List<UUID> list) {
        this.members = list == null ? new ArrayList() : new ArrayList(list);
    }

    public void setHome(List<HomesData> list) {
        this.home = list == null ? new ArrayList() : new ArrayList(list);
    }

    public void setMods(List<UUID> list) {
        this.mods = list == null ? new ArrayList() : new ArrayList(list);
    }

    public void setBanned(List<UUID> list) {
        this.banned = list == null ? new ArrayList() : new ArrayList(list);
    }

    public boolean isFf() {
        return this.ff;
    }

    public void setFf(boolean z) {
        this.ff = z;
    }

    public double getKdr() {
        return this.kdr;
    }

    public void setKdr(double d) {
        this.kdr = d;
    }

    public String getTagNoColor() {
        return this.tagNoColor;
    }

    public void setTagNoColor(String str) {
        this.tagNoColor = str;
    }

    public List<UUID> getMods() {
        return this.mods;
    }

    public ClanRivalAlly getRivalAlly() {
        return this.rivalAlly;
    }

    public void setRivalAlly(ClanRivalAlly clanRivalAlly) {
        this.rivalAlly = clanRivalAlly;
    }

    public Double getBank() {
        return this.bank;
    }

    public void setBank(Double d) {
        this.bank = d;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public ClanQuestInfoData getQuest() {
        return this.quest;
    }

    public void setQuest(ClanQuestInfoData clanQuestInfoData) {
        this.quest = clanQuestInfoData;
    }

    public SettingsData getSettings() {
        return this.settings;
    }

    public void setSettings(SettingsData settingsData) {
        this.settings = settingsData;
    }

    public ChestSettingsData getChestSettings() {
        return this.chestSettings;
    }

    public void setChestSettings(ChestSettingsData chestSettingsData) {
        this.chestSettings = chestSettingsData;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public int getMaxlevel() {
        return this.maxlevel;
    }

    public void setMaxlevel(int i) {
        this.maxlevel = i;
    }

    public int getExtraSlots() {
        return this.extraSlots;
    }

    public void setExtraSlots(int i) {
        this.extraSlots = i;
    }

    public List<UUID> getBanned() {
        return this.banned;
    }

    public String getPatent() {
        return this.patent;
    }

    public void setPatent(String str) {
        this.patent = str;
    }

    public String getWebhook() {
        return this.webhook;
    }

    public void setWebhook(String str) {
        this.webhook = str;
    }

    public long getLoadCache() {
        return this.loadCache;
    }

    public void setLoadCache(long j) {
        this.loadCache = j;
    }

    public List<UUID> getOnlineMembers() {
        return this.onlineMembers;
    }

    public void setOnlineMembers(List<UUID> list) {
        this.onlineMembers = list == null ? new ArrayList() : new ArrayList(list);
    }
}

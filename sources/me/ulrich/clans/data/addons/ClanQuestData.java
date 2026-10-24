package me.ulrich.clans.data.addons;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/ClanQuestData.class */
public class ClanQuestData {
    private UUID islandUuid;
    private String quest;
    private AddonEnum.QuestStatus status;
    private UUID player;
    private Long start;
    private int earned;

    public ClanQuestData(UUID uuid, String str, AddonEnum.QuestStatus questStatus, UUID uuid2, Long l, int i) {
        setIslandUuid(uuid);
        setQuest(str);
        setStatus(questStatus);
        setPlayer(uuid2);
        setStart(l);
        setEarned(i);
    }

    public String getQuest() {
        return this.quest;
    }

    public void setQuest(String str) {
        this.quest = str;
    }

    public AddonEnum.QuestStatus getStatus() {
        return this.status;
    }

    public void setStatus(AddonEnum.QuestStatus questStatus) {
        this.status = questStatus;
    }

    public UUID getPlayer() {
        return this.player;
    }

    public void setPlayer(UUID uuid) {
        this.player = uuid;
    }

    public Long getStart() {
        return this.start;
    }

    public void setStart(Long l) {
        this.start = l;
    }

    public UUID getIslandUuid() {
        return this.islandUuid;
    }

    public void setIslandUuid(UUID uuid) {
        this.islandUuid = uuid;
    }

    public int getEarned() {
        return this.earned;
    }

    public void setEarned(int i) {
        this.earned = i;
    }
}

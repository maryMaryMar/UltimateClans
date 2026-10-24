package me.ulrich.clans.data.addons;

import java.util.HashMap;
import java.util.List;
import me.ulrich.clans.data.AddonGuiItemsData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/QuestData.class */
public class QuestData {
    private String id;
    private boolean status;
    private AddonGuiItemsData item;
    private HashMap<AddonEnum.QuestType, QuestData_mission> mission;
    private AddonEnum.QuestMissionType missiontype;
    private QuestData_rewards rewards;
    private List<String> messages;
    private List<AddonEnum.WeekDayType> weekdays;

    public QuestData(String str, boolean z, AddonGuiItemsData addonGuiItemsData, AddonEnum.QuestMissionType questMissionType, HashMap<AddonEnum.QuestType, QuestData_mission> map, QuestData_rewards questData_rewards, List<String> list, List<AddonEnum.WeekDayType> list2) {
        setId(str);
        setStatus(z);
        setItem(addonGuiItemsData);
        setTypes(map);
        setMissiontype(questMissionType);
        setRewards(questData_rewards);
        setMessages(list);
        setWeekdays(list2);
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public AddonGuiItemsData getItem() {
        return this.item;
    }

    public void setItem(AddonGuiItemsData addonGuiItemsData) {
        this.item = addonGuiItemsData;
    }

    public HashMap<AddonEnum.QuestType, QuestData_mission> getTypes() {
        return this.mission;
    }

    public void setTypes(HashMap<AddonEnum.QuestType, QuestData_mission> map) {
        this.mission = map;
    }

    public AddonEnum.QuestMissionType getMissiontype() {
        return this.missiontype;
    }

    public void setMissiontype(AddonEnum.QuestMissionType questMissionType) {
        this.missiontype = questMissionType;
    }

    public QuestData_rewards getRewards() {
        return this.rewards;
    }

    public void setRewards(QuestData_rewards questData_rewards) {
        this.rewards = questData_rewards;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public void setMessages(List<String> list) {
        this.messages = list;
    }

    public List<AddonEnum.WeekDayType> getWeekdays() {
        return this.weekdays;
    }

    public void setWeekdays(List<AddonEnum.WeekDayType> list) {
        this.weekdays = list;
    }
}

package me.ulrich.clans.data.addons;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/QuestData_mission.class */
public class QuestData_mission {
    private AddonEnum.QuestType type;
    private int amount;
    private List<String> whitelist;

    public QuestData_mission(AddonEnum.QuestType questType, int i, List<String> list) {
        setType(questType);
        setAmount(i);
        setWhitelist(list);
    }

    public AddonEnum.QuestType getType() {
        return this.type;
    }

    public void setType(AddonEnum.QuestType questType) {
        this.type = questType;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public List<String> getWhitelist() {
        return this.whitelist;
    }

    public void setWhitelist(List<String> list) {
        this.whitelist = list;
    }
}

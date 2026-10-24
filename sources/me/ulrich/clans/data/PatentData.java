package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/PatentData.class */
public class PatentData {
    private String id;
    private String name;
    private int requiredlevel;
    private List<String> rewards;
    private boolean rewardsOnlyOnce;
    private List<String> rewardsDisabledWorld;

    public PatentData(String str, String str2, int i, List<String> list, boolean z, List<String> list2) {
        setId(str);
        setName(str2);
        setRequiredlevel(i);
        setRewards(list);
        setRewardsOnlyOnce(z);
        setRewardsDisabledWorld(list2);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getRequiredlevel() {
        return this.requiredlevel;
    }

    public void setRequiredlevel(int i) {
        this.requiredlevel = i;
    }

    public List<String> getRewards() {
        return this.rewards;
    }

    public void setRewards(List<String> list) {
        this.rewards = list;
    }

    public boolean isRewardsOnlyOnce() {
        return this.rewardsOnlyOnce;
    }

    public void setRewardsOnlyOnce(boolean z) {
        this.rewardsOnlyOnce = z;
    }

    public List<String> getRewardsDisabledWorld() {
        return this.rewardsDisabledWorld;
    }

    public void setRewardsDisabledWorld(List<String> list) {
        this.rewardsDisabledWorld = list;
    }
}

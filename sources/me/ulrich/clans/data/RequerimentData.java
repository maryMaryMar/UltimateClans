package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/RequerimentData.class */
public class RequerimentData {
    private List<String> rewards;
    private List<String> surprise;
    private String points;
    private List<String> requires;
    private int level;
    private List<String> cost;
    private List<String> description;

    public RequerimentData(int i, String str, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        setLevel(i);
        setRewards(list);
        setSurprise(list2);
        setPoints(str);
        setRequires(list3);
        setCost(list4);
        setDescription(list5);
    }

    public List<String> getRewards() {
        return this.rewards;
    }

    public void setRewards(List<String> list) {
        this.rewards = list;
    }

    public List<String> getSurprise() {
        return this.surprise;
    }

    public void setSurprise(List<String> list) {
        this.surprise = list;
    }

    public String getPoints() {
        return this.points;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public List<String> getRequires() {
        return this.requires;
    }

    public void setRequires(List<String> list) {
        this.requires = list;
    }

    public List<String> getCost() {
        return this.cost;
    }

    public void setCost(List<String> list) {
        this.cost = list;
    }

    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(List<String> list) {
        this.description = list;
    }
}

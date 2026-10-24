package me.ulrich.clans.data.addons;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/QuestData_rewards.class */
public class QuestData_rewards {
    private List<String> commands;
    private int points;
    private int exp;
    private double leaguePoints;

    public QuestData_rewards(List<String> list, int i, int i2, double d) {
        setCommands(list);
        setPoints(i);
        setExp(i2);
        setLeaguePoints(d);
    }

    public List<String> getCommands() {
        return this.commands;
    }

    public void setCommands(List<String> list) {
        this.commands = list;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int i) {
        this.points = i;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int i) {
        this.exp = i;
    }

    public double getLeaguePoints() {
        return this.leaguePoints;
    }

    public void setLeaguePoints(double d) {
        this.leaguePoints = d;
    }
}

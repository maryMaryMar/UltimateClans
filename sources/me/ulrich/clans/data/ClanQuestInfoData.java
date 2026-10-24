package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanQuestInfoData.class */
public class ClanQuestInfoData {
    private int points;
    private int finished;

    public ClanQuestInfoData(int i, int i2) {
        setPoints(i);
        setFinished(i2);
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int i) {
        this.points = i;
    }

    public int getFinished() {
        return this.finished;
    }

    public void setFinished(int i) {
        this.finished = i;
    }
}

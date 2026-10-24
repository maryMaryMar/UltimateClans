package me.ulrich.clans.data.addons;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LeaguePointsRecordData.class */
public class LeaguePointsRecordData {
    private double added;
    private double removed;

    public LeaguePointsRecordData(double d, double d2) {
        this.added = d;
        this.removed = d2;
    }

    public double getAdded() {
        return this.added;
    }

    public double getRemoved() {
        return this.removed;
    }

    public double getTotal() {
        return this.added - this.removed;
    }
}

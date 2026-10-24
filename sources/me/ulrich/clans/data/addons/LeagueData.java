package me.ulrich.clans.data.addons;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LeagueData.class */
public class LeagueData {
    private UUID clanUUID;
    private double points;
    private String logger;
    private long date;
    private UUID id;
    private UUID season;
    private AddonEnum.LeagueEventAction type;

    public LeagueData(UUID uuid, UUID uuid2, double d, long j, String str, UUID uuid3, AddonEnum.LeagueEventAction leagueEventAction) {
        setId(uuid);
        setClanUUID(uuid2);
        setPoints(d);
        setDate(j);
        setLogger(str);
        setSeason(uuid3);
        setType(leagueEventAction);
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public void setClanUUID(UUID uuid) {
        this.clanUUID = uuid;
    }

    public double getPoints() {
        return this.points;
    }

    public void setPoints(double d) {
        this.points = d;
    }

    public String getLogger() {
        return this.logger;
    }

    public void setLogger(String str) {
        this.logger = str;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public UUID getSeason() {
        return this.season;
    }

    public void setSeason(UUID uuid) {
        this.season = uuid;
    }

    public AddonEnum.LeagueEventAction getType() {
        return this.type;
    }

    public void setType(AddonEnum.LeagueEventAction leagueEventAction) {
        this.type = leagueEventAction;
    }
}

package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanStats.class */
public class ClanStats {
    private int kills;
    private int deaths;
    private int souls;
    private int memberJoined;
    private int memberLeft;
    private int warWin;
    private int warLose;
    private int tagChanged;
    private int memberKicked;
    private int gladWin;
    private int gladLose;
    private int leagueWin;
    private int leagueLose;

    public ClanStats(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        setKills(i);
        setDeaths(i2);
        setSouls(i3);
        setMemberJoined(i4);
        setMemberLeft(i5);
        setWarWin(i6);
        setWarLose(i7);
        setTagChanged(i8);
        setMemberKicked(i9);
        setGladWin(i10);
        setGladLose(i11);
        setLeagueWin(i12);
        setLeagueLose(i13);
    }

    public int getKills() {
        return this.kills;
    }

    public void setKills(int i) {
        this.kills = i;
    }

    public int getDeaths() {
        return this.deaths;
    }

    public void setDeaths(int i) {
        this.deaths = i;
    }

    public int getSouls() {
        return this.souls;
    }

    public void setSouls(int i) {
        this.souls = i;
    }

    public int getMemberJoined() {
        return this.memberJoined;
    }

    public void setMemberJoined(int i) {
        this.memberJoined = i;
    }

    public int getMemberLeft() {
        return this.memberLeft;
    }

    public void setMemberLeft(int i) {
        this.memberLeft = i;
    }

    public int getWarWin() {
        return this.warWin;
    }

    public void setWarWin(int i) {
        this.warWin = i;
    }

    public int getWarLose() {
        return this.warLose;
    }

    public void setWarLose(int i) {
        this.warLose = i;
    }

    public int getTagChanged() {
        return this.tagChanged;
    }

    public void setTagChanged(int i) {
        this.tagChanged = i;
    }

    public int getMemberKicked() {
        return this.memberKicked;
    }

    public void setMemberKicked(int i) {
        this.memberKicked = i;
    }

    public int getGladWin() {
        return this.gladWin;
    }

    public void setGladWin(int i) {
        this.gladWin = i;
    }

    public int getGladLose() {
        return this.gladLose;
    }

    public void setGladLose(int i) {
        this.gladLose = i;
    }

    public int getLeagueWin() {
        return this.leagueWin;
    }

    public void setLeagueWin(int i) {
        this.leagueWin = i;
    }

    public int getLeagueLose() {
        return this.leagueLose;
    }

    public void setLeagueLose(int i) {
        this.leagueLose = i;
    }
}

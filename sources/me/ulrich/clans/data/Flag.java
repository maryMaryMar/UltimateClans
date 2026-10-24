package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/Flag.class */
public enum Flag {
    NAME("%name"),
    TAG("%tag"),
    PLAYER("%player"),
    EXTRA("%extra"),
    AMOUNT("%amount");

    private String flag;

    Flag(String str) {
        this.flag = str;
    }

    public String getFlag() {
        return this.flag;
    }
}

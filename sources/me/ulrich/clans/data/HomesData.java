package me.ulrich.clans.data;

import java.util.Optional;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/HomesData.class */
public class HomesData {
    private String server;
    private String loc;
    private String name;
    private Optional<String> password;

    public HomesData(String str, String str2, String str3, Optional<String> optional) {
        setServer(str);
        setName(str2);
        setLoc(str3);
        setPassword(optional);
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String str) {
        this.loc = str;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Optional<String> getPassword() {
        return this.password;
    }

    public void setPassword(Optional<String> optional) {
        this.password = optional;
    }
}

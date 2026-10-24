package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/PlayerActions.class */
public class PlayerActions {
    private int id;
    private String name;
    private String Uui;
    private String returns;

    public PlayerActions(int i, String str, String str2, String str3) {
        setId(i);
        setName(str);
        setUui(str2);
        setReturns(str3);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUui() {
        return this.Uui;
    }

    public void setUui(String str) {
        this.Uui = str;
    }

    public String getReturns() {
        return this.returns;
    }

    public void setReturns(String str) {
        this.returns = str;
    }
}

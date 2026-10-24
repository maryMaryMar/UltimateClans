package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanData_show_json.class */
public class ClanData_show_json {
    private String hover_text;
    private String click_type;
    private String click_action;

    public ClanData_show_json(String str, String str2, String str3) {
        setHover_text(str);
        setClick_type(str2);
        setClick_action(str3);
    }

    public String getHover_text() {
        return this.hover_text;
    }

    public void setHover_text(String str) {
        this.hover_text = str;
    }

    public String getClick_type() {
        return this.click_type;
    }

    public void setClick_type(String str) {
        this.click_type = str;
    }

    public String getClick_action() {
        return this.click_action;
    }

    public void setClick_action(String str) {
        this.click_action = str;
    }
}

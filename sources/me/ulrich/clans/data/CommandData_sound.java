package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CommandData_sound.class */
public class CommandData_sound {
    private String on_help;
    private String on_success;
    private String on_error;

    public CommandData_sound(String str, String str2, String str3) {
        setOn_help(str);
        setOn_success(str2);
        setOn_error(str3);
    }

    public String getOn_help() {
        return this.on_help;
    }

    public void setOn_help(String str) {
        this.on_help = str;
    }

    public String getOn_success() {
        return this.on_success;
    }

    public void setOn_success(String str) {
        this.on_success = str;
    }

    public String getOn_error() {
        return this.on_error;
    }

    public void setOn_error(String str) {
        this.on_error = str;
    }
}

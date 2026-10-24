package me.ulrich.clans.data;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CommandData_show.class */
public class CommandData_show {
    private String on_help;
    private ClanData_show_json on_help_json;
    private String on_success;
    private String on_error;
    private String on_usage;
    private Map<String, CommandData_show> localized = new HashMap();

    public CommandData_show(String str, String str2, String str3, String str4) {
        setOn_help(str);
        setOn_help_json(this.on_help_json);
        setOn_success(str2);
        setOn_error(str3);
        setOn_usage(str4);
    }

    public String getOn_help() {
        return this.on_help;
    }

    public void setOn_help(String str) {
        this.on_help = str;
    }

    public ClanData_show_json getOn_help_json() {
        return this.on_help_json;
    }

    public void setOn_help_json(ClanData_show_json clanData_show_json) {
        this.on_help_json = clanData_show_json;
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

    public String getOn_usage() {
        return this.on_usage;
    }

    public void setOn_usage(String str) {
        this.on_usage = str;
    }

    public Map<String, CommandData_show> getLocalized() {
        return this.localized;
    }

    public void setLocalized(Map<String, CommandData_show> map) {
        this.localized = map != null ? new HashMap(map) : new HashMap();
    }

    public void putLocalized(String str, CommandData_show commandData_show) {
        if (str == null || commandData_show == null) {
            return;
        }
        this.localized.put(str.toUpperCase(), commandData_show);
    }
}

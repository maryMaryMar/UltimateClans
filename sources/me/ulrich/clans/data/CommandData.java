package me.ulrich.clans.data;

import java.util.HashMap;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CommandData.class */
public class CommandData {
    private String id;
    private String permission;
    private String alias;
    private int cooldown;
    private CommandData_show show;
    private CommandData_title title;
    private CommandData_actionbar actionbar;
    private double value;
    private HashMap<String, CommandData_show> subcommands;
    private CommandData_disable disable;
    private CommandData_sound sound;

    public CommandData(String str, String str2, String str3, double d, int i, CommandData_show commandData_show, CommandData_title commandData_title, CommandData_actionbar commandData_actionbar, CommandData_sound commandData_sound, HashMap<String, CommandData_show> map, CommandData_disable commandData_disable) {
        setId(str);
        setPermission(str2);
        setAlias(str3);
        setValue(d);
        setCooldown(i);
        setShow(commandData_show);
        setTitle(commandData_title);
        setActionbar(commandData_actionbar);
        setSound(commandData_sound);
        setSubcommands(map);
        setDisable(commandData_disable);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String str) {
        this.permission = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(int i) {
        this.cooldown = i;
    }

    public CommandData_show getShow() {
        return this.show;
    }

    public void setShow(CommandData_show commandData_show) {
        this.show = commandData_show;
    }

    public CommandData_title getTitle() {
        return this.title;
    }

    public void setTitle(CommandData_title commandData_title) {
        this.title = commandData_title;
    }

    public CommandData_actionbar getActionbar() {
        return this.actionbar;
    }

    public void setActionbar(CommandData_actionbar commandData_actionbar) {
        this.actionbar = commandData_actionbar;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double d) {
        this.value = d;
    }

    public HashMap<String, CommandData_show> getSubcommands() {
        return this.subcommands;
    }

    public void setSubcommands(HashMap<String, CommandData_show> map) {
        this.subcommands = map;
    }

    public CommandData_disable getDisable() {
        return this.disable;
    }

    public void setDisable(CommandData_disable commandData_disable) {
        this.disable = commandData_disable;
    }

    public CommandData_sound getSound() {
        return this.sound;
    }

    public void setSound(CommandData_sound commandData_sound) {
        this.sound = commandData_sound;
    }
}

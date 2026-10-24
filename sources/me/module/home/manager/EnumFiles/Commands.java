package me.module.home.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player("Commands.player", "", " "),
    COMMANDS_player_permission("Commands.player.permission", "uclans.player.home", "# Use empty for don't need permissions"),
    COMMANDS_player_alias("Commands.player.alias", "home", "# Alias for command."),
    COMMANDS_player_cooldown("Commands.player.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_value("Commands.player.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_disabled_worlds("Commands.player.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_disabled_regions("Commands.player.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_home("Commands.home", "", " ", "# home command"),
    COMMANDS_home_help("Commands.home.help", "", new String[0]),
    COMMANDS_home_help_aliases("Commands.home.help.aliases", "home", new String[0]),
    COMMANDS_home_help_show("Commands.home.help.show", "", new String[0]),
    COMMANDS_home_help_usage("Commands.home.help.usage", "", new String[0]),
    COMMANDS_home_help_error("Commands.home.help.error", "", new String[0]),
    COMMANDS_home_help_success("Commands.home.help.success", "", new String[0]),
    COMMANDS_home_create("Commands.home.create", "", new String[0]),
    COMMANDS_home_create_aliases("Commands.home.create.aliases", "create", new String[0]),
    COMMANDS_home_create_show("Commands.home.create.show", "", new String[0]),
    COMMANDS_home_create_usage("Commands.home.create.usage", "", new String[0]),
    COMMANDS_home_create_error("Commands.home.create.error", "", new String[0]),
    COMMANDS_home_create_success("Commands.home.create.success", "", new String[0]),
    COMMANDS_home_delete("Commands.home.delete", "", new String[0]),
    COMMANDS_home_delete_aliases("Commands.home.delete.aliases", "delete", new String[0]),
    COMMANDS_home_delete_show("Commands.home.delete.show", "", new String[0]),
    COMMANDS_home_delete_usage("Commands.home.delete.usage", "", new String[0]),
    COMMANDS_home_delete_error("Commands.home.delete.error", "", new String[0]),
    COMMANDS_home_delete_success("Commands.home.delete.success", "", new String[0]),
    COMMANDS_home_list("Commands.home.list", "", new String[0]),
    COMMANDS_home_list_aliases("Commands.home.list.aliases", "list", new String[0]),
    COMMANDS_home_list_show("Commands.home.list.show", "", new String[0]),
    COMMANDS_home_list_usage("Commands.home.list.usage", "", new String[0]),
    COMMANDS_home_list_error("Commands.home.list.error", "", new String[0]),
    COMMANDS_home_list_success("Commands.home.list.success", "", new String[0]),
    COMMANDS_home_teleport("Commands.home.teleport", "", new String[0]),
    COMMANDS_home_teleport_aliases("Commands.home.teleport.aliases", "teleport", new String[0]),
    COMMANDS_home_teleport_show("Commands.home.teleport.show", "", new String[0]),
    COMMANDS_home_teleport_usage("Commands.home.teleport.usage", "", new String[0]),
    COMMANDS_home_teleport_error("Commands.home.teleport.error", "", new String[0]),
    COMMANDS_home_teleport_success("Commands.home.teleport.success", "", new String[0]),
    COMMANDS_home_view("Commands.home.view", "", new String[0]),
    COMMANDS_home_view_aliases("Commands.home.view.aliases", "view", new String[0]),
    COMMANDS_home_view_show("Commands.home.view.show", "", new String[0]),
    COMMANDS_home_view_usage("Commands.home.view.usage", "", new String[0]),
    COMMANDS_home_view_error("Commands.home.view.error", "", new String[0]),
    COMMANDS_home_view_success("Commands.home.view.success", "", new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Commands(String str, Object obj, String... strArr) {
        this.path = str;
        this.defaultValue = obj;
        this.comments = strArr;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public String getPath() {
        return this.path;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public String[] getComments() {
        return this.comments;
    }
}

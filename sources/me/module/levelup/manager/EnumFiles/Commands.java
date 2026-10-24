package me.module.levelup.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player_level("Commands.player.level", "", " ", "# Clan Level"),
    COMMANDS_player_level_permission("Commands.player.level.permission", "uclans.player.level", new String[0]),
    COMMANDS_player_level_alias("Commands.player.level.alias", "levelup", "# Alias for command."),
    COMMANDS_player_level_cooldown("Commands.player.level.cooldown", 0, "# in seconds"),
    COMMANDS_player_level_value("Commands.player.level.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_level_disabled_worlds("Commands.player.level.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_playe_levelr_disabled_regions("Commands.player.level.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_level_help("Commands.level.help", "", new String[0]),
    COMMANDS_level_help_aliases("Commands.level.help.aliases", "help", new String[0]),
    COMMANDS_level_help_show("Commands.level.help.show", "", new String[0]),
    COMMANDS_level_help_usage("Commands.level.help.usage", "", new String[0]),
    COMMANDS_level_help_error("Commands.level.help.error", "", new String[0]),
    COMMANDS_level_help_success("Commands.level.help.success", "", new String[0]),
    COMMANDS_level_view("Commands.level.view", "", new String[0]),
    COMMANDS_level_view_aliases("Commands.level.view.aliases", "view", new String[0]),
    COMMANDS_level_view_show("Commands.level.view.show", "", new String[0]),
    COMMANDS_level_view_usage("Commands.level.view.usage", "", new String[0]),
    COMMANDS_level_view_error("Commands.level.view.error", "", new String[0]),
    COMMANDS_level_view_success("Commands.level.view.success", "", new String[0]),
    COMMANDS_level_up("Commands.level.up", "", new String[0]),
    COMMANDS_level_up_aliases("Commands.level.up.aliases", "up", new String[0]),
    COMMANDS_level_up_show("Commands.level.up.show", "", new String[0]),
    COMMANDS_level_up_usage("Commands.level.up.usage", "", new String[0]),
    COMMANDS_level_up_error("Commands.level.up.error", "", new String[0]),
    COMMANDS_level_up_success("Commands.level.up.success", "", new String[0]);

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

package me.module.logger.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player("Commands.player", "", " "),
    COMMANDS_player_permission("Commands.player.permission", "uclans.player.logger", "# Use empty for don't need permissions"),
    COMMANDS_player_alias("Commands.player.alias", "logger", "# Alias for command."),
    COMMANDS_player_cooldown("Commands.player.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_value("Commands.player.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_disabled_worlds("Commands.player.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_disabled_regions("Commands.player.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_logger("Commands.logger", "", " ", "# Logger command"),
    COMMANDS_logger_help("Commands.logger.help", "", new String[0]),
    COMMANDS_logger_help_aliases("Commands.logger.help.aliases", "logger", new String[0]),
    COMMANDS_logger_help_show("Commands.logger.help.show", "", new String[0]),
    COMMANDS_logger_help_usage("Commands.logger.help.usage", "", new String[0]),
    COMMANDS_logger_help_error("Commands.logger.help.error", "", new String[0]),
    COMMANDS_logger_help_success("Commands.logger.help.success", "", new String[0]),
    COMMANDS_logger_clear("Commands.logger.clear", "", new String[0]),
    COMMANDS_logger_clear_aliases("Commands.logger.clear.aliases", "clear", new String[0]),
    COMMANDS_logger_clear_show("Commands.logger.clear.show", "", new String[0]),
    COMMANDS_logger_clear_usage("Commands.logger.clear.usage", "", new String[0]),
    COMMANDS_logger_clear_error("Commands.logger.clear.error", "", new String[0]),
    COMMANDS_logger_clear_success("Commands.logger.clear.success", "", new String[0]),
    COMMANDS_logger_view("Commands.logger.view", "", new String[0]),
    COMMANDS_logger_view_aliases("Commands.logger.view.aliases", "view", new String[0]),
    COMMANDS_logger_view_show("Commands.logger.view.show", "", new String[0]),
    COMMANDS_logger_view_usage("Commands.logger.view.usage", "", new String[0]),
    COMMANDS_logger_view_error("Commands.logger.view.error", "", new String[0]),
    COMMANDS_logger_view_success("Commands.logger.view.success", "", new String[0]);

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

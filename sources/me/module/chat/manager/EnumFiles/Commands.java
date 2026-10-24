package me.module.chat.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player("Commands.player", "", " "),
    COMMANDS_player_permission("Commands.player.permission", "uclans.player.chat", "# Use empty for don't need permissions"),
    COMMANDS_player_alias("Commands.player.alias", "chat", "# Alias for command."),
    COMMANDS_player_cooldown("Commands.player.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_value("Commands.player.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_disabled_worlds("Commands.player.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_disabled_regions("Commands.player.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_chat("Commands.chat", "", " ", "# player command"),
    COMMANDS_chat_help("Commands.chat.help", "", new String[0]),
    COMMANDS_chat_help_aliases("Commands.chat.help.aliases", "help", new String[0]),
    COMMANDS_chat_help_show("Commands.chat.help.show", "<click:suggest_command:\"/{_clan} {_chat} \"><hover:show_text:'<green>Click to toggle clan chat.'> <aqua>/{_clan} {_chat} <gray>-<yellow> Toggle clan chat.</hover></click>", new String[0]),
    COMMANDS_chat_help_usage("Commands.chat.help.usage", "%tag% <red>Use <aqua>/{_clan} {_chat}", new String[0]),
    COMMANDS_chat_help_error("Commands.chat.help.error", "%tag% <red>Error to use chat.", new String[0]),
    COMMANDS_chat_help_success("Commands.chat.help.success", "%tag% <green>Clan locked chat as now: <aqua>{locked_chat}", new String[0]);

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

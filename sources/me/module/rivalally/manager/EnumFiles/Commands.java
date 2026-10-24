package me.module.rivalally.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player_rival("Commands.player.rival", "", " "),
    COMMANDS_player_rival_permission("Commands.player.rival.permission", "uclans.player.rival", "# Use empty for don't need permissions"),
    COMMANDS_player_rival_alias("Commands.player.rival.alias", "rival", "# Alias for command."),
    COMMANDS_player_rival_cooldown("Commands.player.rival.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_rival_value("Commands.player.rival.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_rival_disabled_worlds("Commands.player.rival.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_rival_disabled_regions("Commands.player.rival.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_ally("Commands.player.ally", "", " "),
    COMMANDS_player_ally_permission("Commands.player.ally.permission", "uclans.player.ally", "# Use empty for don't need permissions"),
    COMMANDS_player_ally_alias("Commands.player.ally.alias", "ally", "# Alias for command."),
    COMMANDS_player_ally_cooldown("Commands.player.ally.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_ally_value("Commands.player.ally.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_ally_disabled_worlds("Commands.player.ally.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_ally_disabled_regions("Commands.player.ally.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_rival("Commands.rival", "", " ", "# RivalAlly command"),
    COMMANDS_rival_permission("Commands.rival.permission", "uclans.player.rival", new String[0]),
    COMMANDS_rival_cooldown("Commands.rival.cooldown", 0, "# in seconds"),
    COMMANDS_rival_subcommands("Commands.rival.subcommands", Arrays.asList("add", "remove", "list", "deny", "accept"), new String[0]),
    COMMANDS_rival_help("Commands.rival.help", "", new String[0]),
    COMMANDS_rival_help_aliases("Commands.rival.help.aliases", "help", new String[0]),
    COMMANDS_rival_help_show("Commands.rival.help.show", "", new String[0]),
    COMMANDS_rival_help_usage("Commands.rival.help.usage", "", new String[0]),
    COMMANDS_rival_help_error("Commands.rival.help.error", "", new String[0]),
    COMMANDS_rival_help_success("Commands.rival.help.success", "", new String[0]),
    COMMANDS_rival_add("Commands.rival.add", "", new String[0]),
    COMMANDS_rival_add_aliases("Commands.rival.add.aliases", "add", new String[0]),
    COMMANDS_rival_add_show("Commands.rival.add.show", "", new String[0]),
    COMMANDS_rival_add_usage("Commands.rival.add.usage", "", new String[0]),
    COMMANDS_rival_add_error("Commands.rival.add.error", "", new String[0]),
    COMMANDS_rival_add_success("Commands.rival.add.success", "", new String[0]),
    COMMANDS_rival_remove("Commands.rival.remove", "", new String[0]),
    COMMANDS_rival_remove_aliases("Commands.rival.remove.aliases", "remove", new String[0]),
    COMMANDS_rival_remove_show("Commands.rival.remove.show", "", new String[0]),
    COMMANDS_rival_remove_usage("Commands.rival.remove.usage", "", new String[0]),
    COMMANDS_rival_remove_error("Commands.rival.remove.error", "", new String[0]),
    COMMANDS_rival_remove_success("Commands.rival.remove.success", "", new String[0]),
    COMMANDS_rival_list("Commands.rival.list", "", new String[0]),
    COMMANDS_rival_list_aliases("Commands.rival.list.aliases", "list", new String[0]),
    COMMANDS_rival_list_show("Commands.rival.list.show", "", new String[0]),
    COMMANDS_rival_list_usage("Commands.rival.list.usage", "", new String[0]),
    COMMANDS_rival_list_error("Commands.rival.list.error", "", new String[0]),
    COMMANDS_rival_list_success("Commands.rival.list.success", "", new String[0]),
    COMMANDS_rival_deny("Commands.rival.deny", "", new String[0]),
    COMMANDS_rival_deny_aliases("Commands.rival.deny.aliases", "deny", new String[0]),
    COMMANDS_rival_deny_show("Commands.rival.deny.show", "", new String[0]),
    COMMANDS_rival_deny_usage("Commands.rival.deny.usage", "", new String[0]),
    COMMANDS_rival_deny_error("Commands.rival.deny.error", "", new String[0]),
    COMMANDS_rival_deny_success("Commands.rival.deny.success", "", new String[0]),
    COMMANDS_rival_accept("Commands.rival.accept", "", new String[0]),
    COMMANDS_rival_accept_aliases("Commands.rival.accept.aliases", "accept", new String[0]),
    COMMANDS_rival_accept_show("Commands.rival.accept.show", "", new String[0]),
    COMMANDS_rival_accept_usage("Commands.rival.accept.usage", "", new String[0]),
    COMMANDS_rival_accept_error("Commands.rival.accept.error", "", new String[0]),
    COMMANDS_rival_accept_success("Commands.rival.accept.success", "", new String[0]),
    COMMANDS_ally("Commands.ally", "", " ", "# Clan alliances"),
    COMMANDS_ally_permission("Commands.ally.permission", "uclans.player.ally", new String[0]),
    COMMANDS_ally_cooldown("Commands.ally.cooldown", 0, "# in seconds"),
    COMMANDS_ally_subcommands("Commands.ally.subcommands", Arrays.asList("add", "remove", "list", "accept", "deny"), new String[0]),
    COMMANDS_ally_help("Commands.ally.help", "", new String[0]),
    COMMANDS_ally_help_aliases("Commands.ally.help.aliases", "help", new String[0]),
    COMMANDS_ally_help_show("Commands.ally.help.show", "", new String[0]),
    COMMANDS_ally_help_usage("Commands.ally.help.usage", "", new String[0]),
    COMMANDS_ally_help_error("Commands.ally.help.error", "", new String[0]),
    COMMANDS_ally_help_success("Commands.ally.help.success", "", new String[0]),
    COMMANDS_ally_add("Commands.ally.add", "", new String[0]),
    COMMANDS_ally_add_aliases("Commands.ally.add.aliases", "add", new String[0]),
    COMMANDS_ally_add_show("Commands.ally.add.show", "", new String[0]),
    COMMANDS_ally_add_usage("Commands.ally.add.usage", "", new String[0]),
    COMMANDS_ally_add_error("Commands.ally.add.error", "", new String[0]),
    COMMANDS_ally_add_success("Commands.ally.add.success", "", new String[0]),
    COMMANDS_ally_remove("Commands.ally.remove", "", new String[0]),
    COMMANDS_ally_remove_aliases("Commands.ally.remove.aliases", "remove", new String[0]),
    COMMANDS_ally_remove_show("Commands.ally.remove.show", "", new String[0]),
    COMMANDS_ally_remove_usage("Commands.ally.remove.usage", "", new String[0]),
    COMMANDS_ally_remove_error("Commands.ally.remove.error", "", new String[0]),
    COMMANDS_ally_remove_success("Commands.ally.remove.success", "", new String[0]),
    COMMANDS_ally_list("Commands.ally.list", "", new String[0]),
    COMMANDS_ally_list_aliases("Commands.ally.list.aliases", "list", new String[0]),
    COMMANDS_ally_list_show("Commands.ally.list.show", "", new String[0]),
    COMMANDS_ally_list_usage("Commands.ally.list.usage", "", new String[0]),
    COMMANDS_ally_list_error("Commands.ally.list.error", "", new String[0]),
    COMMANDS_ally_list_success("Commands.ally.list.success", "", new String[0]),
    COMMANDS_ally_accept("Commands.ally.accept", "", new String[0]),
    COMMANDS_ally_accept_aliases("Commands.ally.accept.aliases", "accept", new String[0]),
    COMMANDS_ally_accept_show("Commands.ally.accept.show", "", new String[0]),
    COMMANDS_ally_accept_usage("Commands.ally.accept.usage", "", new String[0]),
    COMMANDS_ally_accept_error("Commands.ally.accept.error", "", new String[0]),
    COMMANDS_ally_accept_success("Commands.ally.accept.success", "", new String[0]),
    COMMANDS_ally_deny("Commands.ally.deny", "", new String[0]),
    COMMANDS_ally_deny_aliases("Commands.ally.deny.aliases", "deny", new String[0]),
    COMMANDS_ally_deny_show("Commands.ally.deny.show", "", new String[0]),
    COMMANDS_ally_deny_usage("Commands.ally.deny.usage", "", new String[0]),
    COMMANDS_ally_deny_error("Commands.ally.deny.error", "", new String[0]),
    COMMANDS_ally_deny_success("Commands.ally.deny.success", "", new String[0]);

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

package me.module.home.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/EnumFiles/Lang.class */
public enum Lang implements ConfigurationEnum {
    DISABLED_FUNCTION("LANGUAGE.disabled function", "%tag% <red>This function/addon appears to be off.", new String[0]),
    HELP_CLAN_HEADER_SUBCOMMAND("COMUM.help clan header subcommand", "<newline><blue><bold>Help with subcommands:</bold> <newline> <green>[!] <gray>subcmd <gray>| <red><> <gray>obligatory <gray>| <light_purple>() <gray>optional <newline> ", new String[0]),
    HELP_LIST_EMPTY("COMUM.help list empty", " <red>- There is nothing on this list.", new String[0]),
    PLAYER_DONT_PERMISSION_ROLE("COMUM.clan dont permission role", "%tag% <red>Your current role you cannot do this.", new String[0]),
    PLAYER_DONT_HAVE_CLAN("LANGUAGE.player donthave clan", "%tag% <red>This player does not have a clan.", new String[0]),
    STATE_TRUE("LANGUAGE.state true", "<green>ENABLED", new String[0]),
    STATE_FALSE("LANGUAGE.state false", "<red>DISABLED", new String[0]),
    CLAN_DONT_ALLY("LANGUAGE.clan dont ally", "%tag% <red>This Clan is not an ally.", new String[0]),
    CLAN_DELETED_SMALL("LANGUAGE.clan deleted small", "<red><strikethrough>Deleted", new String[0]),
    TRANSLACTION_CONSOLE("LANGUAGE.translaction console", "<red>Console", new String[0]),
    GUI_ERROR("LANGUAGE.gui error", "%tag% <red>This menu contains an error and cannot be opened", new String[0]),
    ERROR_CHARACTER("LANGUAGE.error character", "%tag% <red>This contains invalid characters.", new String[0]),
    DISABLED_WORLD_COMMAND("LANGUAGE.disabled world command", "%tag% <red>Clan commands are turned off in this world.", new String[0]),
    DISABLED_REGION_COMMAND("LANGUAGE.disabled region command", "%tag% <red>Clan commands are turned off in this region.", new String[0]),
    PLAYER_TELEPORT_FALSE("LANGUAGE.player teleport false", "%tag% <red>You have not been teleported for any mistake!", new String[0]),
    CLAN_LIST_EMPTY("LANGUAGE.clan list empty", " <red>No Clan in this list.", new String[0]),
    CLAN_DOES_NOT_EXISTS("LANGUAGE.chan does not exists", "%tag% <red>This clan does not exist", new String[0]),
    PLAYER_DONT_MOD_AND_LEADER_GUI("LANGUAGE.clan dont mod and leader gui", "<red>Requires <dark_red>Leader <red>or <dark_red>Mod<red>!", new String[0]),
    TEXT_EMPTY("LANGUAGE.text empty", "<red>The text is empty.", new String[0]),
    TRANSLACTION_NONE("LANGUAGE.translaction none", "None", new String[0]),
    TRANSLACTION_NOYES_TRUE("LANGUAGE.translaction yes", "<aqua>YES", new String[0]),
    TRANSLACTION_NOYES_FALSE("LANGUAGE.translaction no", "<red>NO", new String[0]),
    TRANSLACTION_NOCLAN("LANGUAGE.translaction no clan", "<red>No Clan", new String[0]),
    CLAN_ACTIONS_EXPIRED("LANGUAGE.clan actions expired", "%tag% <red>The time for action is over.", new String[0]),
    HELP_CLAN_HOME_LIST_HEADER("LANGUAGE.help clan home list header", "<newline>%uclans_tag_color% <blue><bold>home list:", new String[0]),
    HELP_CLAN_HOME_LIST_FORMAT("LANGUAGE.help clan home list format", "<click:run_command:\"/{_clan} {_home} {_teleport} %uclans_home:{name}:name%\"><hover:show_text:'<green>Click to teleport.'> <gray>- <green>{num} <gray>| <white>Name: <green>%uclans_home:{name}:name% <gray>| <white>Server: <green>%uclans_home:{name}:server% <gray>| <white>Location: <green>%uclans_home:{name}:location%</hover></click>", new String[0]),
    HELP_CLAN_HOME_LIST_FORMAT_VISIT("LANGUAGE.help clan home list format visit", " <gray>- <green>{num} <gray>| <white>Name: <green>%uclans_home:{name}:name% <gray>| <white>Server: <green>%uclans_home:{name}:server%", new String[0]),
    HELP_CLAN_HOME_VIEW_HEADER("LANGUAGE.help clan home view header", "<newline><blue><bold>Home Info:", new String[0]),
    HELP_CLAN_HOME_VIEW_FORMAT("LANGUAGE.help clan home view format", Arrays.asList("<blue><bold>|</bold> <blue>Info:", " <white>Name: <aqua>%uclans_home:{name}:name%", " <white>Server: <aqua>%uclans_home:{name}:server%", " <white>Location: <aqua>%uclans_home:{name}:location%", " <white>Requires Passwd: <aqua>%uclans_home:{name}:has_passwd%", "", "<click:suggest_command:\"/{_clan} {_home} {_teleport} %uclans_home:{name}:name%\"><hover:show_text:'<green>Click to teleport.'><aqua>[Teleport]</hover></click>"), new String[0]),
    HELP_CLAN_HOME_REQUIRES_PASSWD("LANGUAGE.help clan requires passwd", "%tag% <red>This Home requires a password to use.", new String[0]),
    HELP_CLAN_HOME_REQUIRES_PASSWD_GUI("LANGUAGE.help clan requires passwd gui", "<red>Requires a password", new String[0]),
    HELP_CLAN_HOME_WRONG_PASSWD("LANGUAGE.help clan wrong passwd", "%tag% <red>The password appears to be wrong...", new String[0]),
    HELP_CLAN_HOME_WRONG_PASSWD_GUI("LANGUAGE.help clan wrong passwd gui", "<red>Wrong password.", new String[0]),
    HOME_NAME_WITHOUT_SPACE("LANGUAGE.home name without space", "%tag% <red>Name cannot contain spaces.", new String[0]),
    HOME_ALREADY_EXISTS("LANGUAGE.home already exists", "%tag% <red>There is already a man with this name.", new String[0]),
    HOME_CREATE_SUCCESS_GUI("LANGUAGE.home create success gui", "<green>New home created!", new String[0]),
    HOME_CREATE_ERROR_GUI("LANGUAGE.home create error gui", "<red>Error creating!", new String[0]),
    HOME_NOT_EXISTS_GUI("LANGUAGE.home no exists gui", "<red>This home has an error.", new String[0]),
    HOME_DELETE_ERROR_GUI("LANGUAGE.home delete error gui", "<red>There was an error deleting.", new String[0]),
    HOME_DELETE_SUCCESS("LANGUAGE.home delete success", "%tag% <green>The clan home <red>{deleted_home} <green>has been deleted.", new String[0]),
    HOME_DELETE_SUCCESS_GUI("LANGUAGE.home delete success gui", "<green>Successfully deleted!", new String[0]),
    HOME_NEW_CREATE("LANGUAGE.new create home", "%tag% <green>A new clan home has been created on the server <aqua>%uclans_home:{name}:server% <green>with the name <aqua>%uclans_home:{name}:name%", new String[0]),
    HOME_LIMIT("LANGUAGE.home limit", "<red>This is the limit (%limit%) for your Clan!", new String[0]),
    HOME_LIMIT_REACHED("LANGUAGE.home limit reached", "%tag% <red>The limit for your clan is %homes% homes.", new String[0]),
    General_common("GUI.Common", "", "# Common and repetitive translation items are clustered in this excerpt"),
    General_common_back_name("GUI.Common back name", "<red>Come back", new String[0]),
    General_common_back_lore("GUI.Common back lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_next_name("GUI.Common next name", "<green>Next page", new String[0]),
    General_common_next_lore("GUI.Common next lore", Arrays.asList("", " <yellow>Click to proceed."), new String[0]),
    General_common_previous_name("GUI.Common previous name", "<green>Previous page", new String[0]),
    General_common_previous_lore("GUI.Common previous lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_fill_name("GUI.Common fill name", " ", new String[0]),
    General_common_fill_lore("GUI.Common fill lore", Arrays.asList(new Object[0]), new String[0]),
    General_clan_delhome_confirm_title("GUI.General clan_delhome_confirm title", "<red>Confirm delhome <dark_red>%home_name% <red>?", new String[0]),
    General_clan_delhome_confirm_items_confirm_name("GUI.General clan_delhome_confirm items confirm name", "<green>Click to confirm", new String[0]),
    General_clan_delhome_confirm_items_confirm_lore("GUI.General clan_delhome_confirm items confirm lore", Arrays.asList(" ", " <yellow>Click to go confirm."), new String[0]),
    General_clan_delhome_confirm_items_cancel_name("GUI.General clan_delhome_confirm items cancel name", "<green>Click to cancel", new String[0]),
    General_clan_delhome_confirm_items_cancel_lore("GUI.General clan_delhome_confirm items cancel lore", Arrays.asList(" ", " <yellow>Click to go cancel."), new String[0]),
    General_clan_allyhome_title("GUI.General clan_allyhome title", "<blue>Allied Homes", new String[0]),
    General_clan_allyhome_items_current_name("GUI.General clan_allyhome items current name", "<green>Home %uclans_home:{name}:name% of clan %uclans_tag_color%.", new String[0]),
    General_clan_allyhome_items_current_lore("GUI.General clan_allyhome items current lore", Arrays.asList("", " <yellow>Home Information", " <gray>", " <gray>Clan: <aqua>%uclans_tag_color%", " <gray>Server: <green>%uclans_home:{name}:server%", " <gray>Name: <aqua>%uclans_home:{name}:name%", "", " <yellow>Left-Click to teleport."), new String[0]),
    General_clan_homes_title("GUI.General clan_homes title", "<blue>Clan Home", new String[0]),
    General_clan_homes_items_ally_homes_name("GUI.General clan_homes items ally_homes name", "<green>View Ally homes", new String[0]),
    General_clan_homes_items_ally_homes_lore("GUI.General clan_homes items ally_homes lore", Arrays.asList("", " <yellow>Click to open."), new String[0]),
    General_clan_homes_items_create_name("GUI.General clan_homes items create name", "<green>Create a new Home", new String[0]),
    General_clan_homes_items_create_lore("GUI.General clan_homes items create lore", Arrays.asList("", " <yellow>Click to create."), new String[0]),
    General_clan_homes_items_current_name("GUI.General clan_homes items current name", "<green>Home %uclans_home:{name}:name%", new String[0]),
    General_clan_homes_items_current_lore("GUI.General clan_homes items current lore", Arrays.asList("", " <yellow>Home Information", " <gray>", " <gray>Server: <green>%uclans_home:{name}:server%", " <gray>Name: <aqua>%uclans_home:{name}:name%", " <gray>Location: <aqua>%uclans_home:{name}:location%", " <white>Requires Passwd: <aqua>%uclans_home:{name}:has_passwd%", "", " <yellow>Left-Click to teleport ", " <red>Right-Click to delete."), new String[0]),
    General_clan_homes_items_current_visit_name("GUI.General clan_homes items current visit name", "<green>Home %uclans_home:{name}:name%", new String[0]),
    General_clan_homes_items_current_visit_lore("GUI.General clan_homes items current visit lore", Arrays.asList("", " <yellow>Home Information", " <gray>", " <gray>Server: <green>%uclans_home:{name}:server%", " <gray>Name: <aqua>%uclans_home:{name}:name%", " <white>Requires Passwd: <aqua>%uclans_home:{name}:has_passwd%"), new String[0]),
    General_listhomes_title("GUI.General listhomes title", "<blue>Home List <gray>| %uclans_tag_nocolor%", new String[0]),
    General_listhomes_items_current_name("GUI.General listhomes items current name", "<green>Home %uclans_home:{name}:name%", new String[0]),
    General_listhomes_items_current_lore("GUI.General listhomes items current lore", Arrays.asList("", " <yellow>Home Information", " <gray>", " <gray>Server: <green>%uclans_home:{name}:server%", " <gray>Name: <aqua>%uclans_home:{name}:name%", " <gray>Location: <aqua>%uclans_home:{name}:location%"), new String[0]),
    CHAT_clanhomecreate_message("CHAT.clanhomecreate.message", Arrays.asList(" ", "<red><strikethrough>-<gray><strikethrough>---------------------------------------------<red><strikethrough>-", "<red><bold>!</bold> <yellow>Write in the chat the name of the new <aqua>Clan Home<yellow>.", " <gray>- Type <red>cancel</red> <gray>or <click:run_command:\"/{_clan} {_cancel}\"><hover:show_text:\"<red>Click to cancel.\"><red>[CLICK HERE]</red></hover></click> to cancel.", "<red><strikethrough>-<gray><strikethrough>---------------------------------------------<red><strikethrough>-", " "), new String[0]),
    CHAT_clanhomecreate_actionbar("CHAT.clanhomecreate.actionbar", "<red><bold>!</bold> <yellow>Type your new clan home in the chat!", new String[0]),
    CHAT_clanhomecreate_title_line("CHAT.clanhomecreate.title.line", "<red>! <yellow>New Home", new String[0]),
    CHAT_clanhomecreate_title_subline("CHAT.clanhomecreate.title.subline", "<yellow>Type in the chat!", new String[0]),
    CHAT_clanhomecreate_bossbar("CHAT.clanhomecreate.bossbar", "<red><bold>!</bold> <yellow>Type your new clan home in the chat! <red>({time})", new String[0]),
    General_anvil_home_create_title("GUI.General anvil_home_create title", "<blue>Create a clan home!", new String[0]),
    General_anvil_home_create_items_left_name("GUI.General anvil_home_create items left name", "<white>Write your text above", new String[0]),
    General_anvil_home_create_items_left_lore("GUI.General anvil_home_create items left lore", Arrays.asList(" <white>Write your text above"), new String[0]),
    General_anvil_home_create_items_right_name("GUI.General anvil_home_create items right name", "<red>Go back", new String[0]),
    General_anvil_home_create_items_right_lore("GUI.General anvil_home_create items right lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_anvil_home_create_items_output_name("GUI.General anvil_home_create items output name", " ", new String[0]),
    General_anvil_home_create_items_output_lore("GUI.General anvil_home_create items output lore", Arrays.asList("", " <yellow>Create a new home."), new String[0]),
    CONFIG_icon_name("GUI.Config.Icon.name", "<green>Clan Home.", new String[0]),
    CONFIG_icon_lore("GUI.Config.Icon.lore", Arrays.asList(" ", " <gray>Homes: <aqua>%uclans_homes_amount%", " ", " <yellow>Click to open home menu."), new String[0]),
    COMMANDS_home_help_show("COMMANDS.home.help.show", "<click:run_command:\"/{_clan} {_home} \"><hover:show_text:'<green>Click to expand home commands.'> <aqua>/{_clan} {_home} <gray>-<yellow> Clan homes.</hover></click> <hover:show_text:'<green>With sub commands.'><green>[!]</hover>", new String[0]),
    COMMANDS_home_help_usage("COMMANDS.home.help.usage", "%tag% <red>Use <aqua>/{_clan} {_home}", new String[0]),
    COMMANDS_home_help_error("COMMANDS.home.help.error", "%tag% <red>Error when using command.", new String[0]),
    COMMANDS_home_help_success("COMMANDS.home.help.success", "%tag% <green>Success!", new String[0]),
    COMMANDS_home_create_show("COMMANDS.home.create.show", "<click:suggest_command:\"/{_clan} {_home} {_create} \"><hover:show_text:'<green>Click to create.'> <aqua>/{_clan} {_home} {_create} <red><name> <light_purple>(password)<gray>-<yellow> Create a home.</hover></click>", new String[0]),
    COMMANDS_home_create_usage("COMMANDS.home.create.usage", "%tag% <red>Use <aqua>/{_clan} {_home} {_create} <red><name> <light_purple>(password)", new String[0]),
    COMMANDS_home_create_error("COMMANDS.home.create.error", "%tag% <red>An error occurred while creating.", new String[0]),
    COMMANDS_home_create_success("COMMANDS.home.create.success", "%tag% <green>The new clan home has been successfully created.", new String[0]),
    COMMANDS_home_delete_show("COMMANDS.home.delete.show", "<click:suggest_command:\"/{_clan} {_home} {_delete} \"><hover:show_text:'<green>Click to delete a home.'> <aqua>/{_clan} {_home} {_delete} <red><name> <gray>-<yellow> Delete a home.</hover></click>", new String[0]),
    COMMANDS_home_delete_usage("COMMANDS.home.delete.usage", "%tag% <red>Use <aqua>/{_clan} {_home} {_delete} <red><name>", new String[0]),
    COMMANDS_home_delete_error("COMMANDS.home.delete.error", "%tag% <red>An error occurred while deleting.", new String[0]),
    COMMANDS_home_delete_success("COMMANDS.home.delete.success", "%tag% <green>The new clan home has been successfully deleted.", new String[0]),
    COMMANDS_home_list_show("COMMANDS.home.list.show", "<click:suggest_command:\"/{_clan} {_home} {_list} \"><hover:show_text:'<green>Click to list all homes.'> <aqua>/{_clan} {_home} {_list} <light_purple>(tag) <light_purple>(-gui) <gray>-<yellow> List all homes.</hover></click>", new String[0]),
    COMMANDS_home_list_usage("COMMANDS.home.list.usage", "%tag% <red>Use <aqua>/{_clan} {_home} {_list} <light_purple>(tag) <light_purple>(-gui)", new String[0]),
    COMMANDS_home_list_error("COMMANDS.home.list.error", "%tag% <red>An error occurred while listing.", new String[0]),
    COMMANDS_home_list_success("COMMANDS.home.list.success", "%tag% <green>Success.", new String[0]),
    COMMANDS_home_teleport_show("COMMANDS.home.teleport.show", "<click:suggest_command:\"/{_clan} {_home} {_teleport} \"><hover:show_text:'<green>Click to teleport to home.'> <aqua>/{_clan} {_home} {_teleport} <red><name> <light_purple>(password) <gray>-<yellow> Teleport to home.</hover></click>", new String[0]),
    COMMANDS_home_teleport_usage("COMMANDS.home.teleport.usage", "%tag% <red>Use <aqua>/{_clan} {_home} {_teleport} <red><name>", new String[0]),
    COMMANDS_home_teleport_error("COMMANDS.home.teleport.error", "%tag% <red>An error occurred while teleport.", new String[0]),
    COMMANDS_home_teleport_success("COMMANDS.home.teleport.success", "%tag% <green>Success.", new String[0]),
    COMMANDS_home_view_show("COMMANDS.home.view.show", "<click:suggest_command:\"/{_clan} {_home} {_view} \"><hover:show_text:'<green>Click to view a home.'> <aqua>/{_clan} {_home} {_view} <red><name> <gray>-<yellow> View a home.</hover></click>", new String[0]),
    COMMANDS_home_view_usage("COMMANDS.home.view.usage", "%tag% <red>Use <aqua>/{_clan} {_home} {_view} <red><name>", new String[0]),
    COMMANDS_home_view_error("COMMANDS.home.view.error", "%tag% <red>An error occurred while view.", new String[0]),
    COMMANDS_home_view_success("COMMANDS.home.view.success", "%tag% <green>Success.", new String[0]);

    public String LanguageTag = "LANGUAGE";
    private String path;
    private Object defaultValue;
    private String[] comments;

    Lang(String str, Object obj, String... strArr) {
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

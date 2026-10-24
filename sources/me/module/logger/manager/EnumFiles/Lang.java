package me.module.logger.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/EnumFiles/Lang.class */
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
    TRANSLACTION_ALL("LANGUAGE.translaction all", "All", new String[0]),
    TRANSLACTION_DAILY("LANGUAGE.translaction daily", "Daily", new String[0]),
    TRANSLACTION_WEEKLY("LANGUAGE.translaction weekly", "Weekly", new String[0]),
    TRANSLACTION_MONTHLY("LANGUAGE.translaction monthly", "Monthly", new String[0]),
    TRANSLACTION_YEARLY("LANGUAGE.translaction yearly", "Yearly", new String[0]),
    TRANSLACTION_NONE("LANGUAGE.translaction none", "None", new String[0]),
    TRANSLACTION_READ("LANGUAGE.translaction read", "Read", new String[0]),
    TRANSLACTION_UNREAD("LANGUAGE.translaction unread", "Unread", new String[0]),
    HELP_LOGGER_HEADER("LANGUAGE.help logger header", "<blue><bold>Clan Logger:</bold> <gray>%time% <gray>| <gray>(%page%/%pages%)", new String[0]),
    HELP_LOGGER_FORMAT("LANGUAGE.help logger format", "<hover:show_text:'<green>%uclans_logger:{id}:text%'><gray>- <white>Origin: <aqua>%uclans_logger:{id}:plugin%<gray> | <white>Date: <aqua>%uclans_logger:{id}:date% <dark_gray>(Expires: %uclans_logger:{id}:expires%)<newline>  <aqua>%uclans_logger:{id}:text%</hover>", new String[0]),
    LOGGER_CLEAR_SUCCESS_GUI("LANGUAGE.help logger clear success gui", "<green>Successfully cleared log", new String[0]),
    LOGGER_CLEAR_ERROR_GUI("LANGUAGE.help logger clear error gui", "<red>Error clearing the log", new String[0]),
    HELP_PLAYER_LOGGER_PREV("LANGUAGE.help player logger prev", "<click:run_command:\"/{_clan} {_logger} {_view} %time% %page%\"><hover:show_text:'<green>Click to go back.'><aqua><< Previous</hover></click>", new String[0]),
    HELP_PLAYER_LOGGER_NEXT("LANGUAGE.help player logger next", "<click:run_command:\"/{_clan} {_logger} {_view} %time% %page%\"><hover:show_text:'<green>Click to advance.'><aqua>Next >></hover></click>", new String[0]),
    HELP_PLAYER_LOGGER_SEPARER("LANGUAGE.help player logger separer", "<gray>|", new String[0]),
    LOGGER("LOGGER", " ", " ", " ", " # TRANSLATIONS OF THE LOGGER ACTIONS", " ", "#Variables: {player_other}, {clan_other}, {home} and uclans placeholders"),
    LOGGER_CLANBANNERCHANGEEVENT("LOGGER.CLANBANNERCHANGEEVENT", "<yellow>Clan Banner changed to <green>%uclans_banner_material%<yellow>.", new String[0]),
    LOGGER_CLANHOMEDELETEEVENT("LOGGER.CLANHOMEDELETEEVENT", "<yellow>Clan Home <green>{home} <yellow>has been deleted.", new String[0]),
    LOGGER_CLANHOMECREATEEVENT("LOGGER.CLANHOMECREATEEVENT", "<yellow>Clan Home called <green>%uclans_home:{home}:name% <yellow>has been created.", new String[0]),
    LOGGER_CLANRIVALADDEVENT("LOGGER.CLANRIVALADDEVENT", "<yellow>A new rivalry was created with the clan <green>{clan_other}<yellow>.", new String[0]),
    LOGGER_CLANRIVALREMOVEEVENT("LOGGER.CLANRIVALREMOVEEVENT", "<yellow>Rivalry with clan <green>{clan_other} <yellow>has been dissolved.", new String[0]),
    LOGGER_CLANALLYREMOVEEVENT("LOGGER.CLANALLYREMOVEEVENT", "<yellow>Alliance with clan <green>{clan_other} <yellow>has been removed.", new String[0]),
    LOGGER_CLANALLYADDEVENT("LOGGER.CLANALLYADDEVENT", "<yellow>A new alliance was formed with clan <green>{clan_other}<yellow>.", new String[0]),
    LOGGER_CLANLEADERCHANGEEVENT("LOGGER.CLANLEADERCHANGEEVENT", "<yellow>%uclans_leader_formated% <yellow>is now the new clan leader.", new String[0]),
    LOGGER_CLANVERIFYCHANGEEVENT("LOGGER.CLANVERIFYCHANGEEVENT", "<yellow>Clan verification is now: <white>%uclans_verified%", new String[0]),
    LOGGER_PATENT_CLANLEVELEVENT("LOGGER.PATENT_CLANLEVELEVENT", "<yellow>Clan patent has now been changed to <green>%uclans_patent_formated%", new String[0]),
    LOGGER_CLANLEVELEVENT("LOGGER.CLANLEVELEVENT", "<yellow>Clan level changed to <green>%uclans_level% <dark_gray>(max: %uclans_max_level_reached%)", new String[0]),
    LOGGER_CLANPOINTCHANGEEVENT("LOGGER.CLANPOINTCHANGEEVENT", "<yellow>Clan points have been changed to <green>%uclans_points%", new String[0]),
    LOGGER_CLANMODDESCEVENT("LOGGER.CLANMODDESCEVENT", "<yellow>Clan description has been changed to <green>%uclans_desc_nocolor%", new String[0]),
    LOGGER_CLANMODTAGEVENT("LOGGER.CLANMODTAGEVENT", "<yellow>Clan tag has been changed to <green>%uclans_tag_color%", new String[0]),
    LOGGER_CLANCREATEEVENT("LOGGER.CLANCREATEEVENT", "<yellow>Clan was created.", new String[0]),
    LOGGER_CLANPLAYERLEAVEEVENT("LOGGER.CLANPLAYERLEAVEEVENT", "<yellow>Player <green>%uclans_player_name% <yellow>has left the clan.", new String[0]),
    LOGGER_CLANPLAYERKICKEDEVENT("LOGGER.CLANPLAYERKICKEDEVENT", "<yellow>Player <red>%uclans_player_name% <yellow>was kicked from the clan by <green>{player_kicker}.", new String[0]),
    LOGGER_CLANPLAYERJOINEVENT("LOGGER.CLANPLAYERJOINEVENT", "<yellow>Player <green>%uclans_player_name% <yellow>has joined the clan.", new String[0]),
    LOGGER_CLANPLAYERROLECHANGE("LOGGER.CLANPLAYERROLECHANGE", "<yellow>Player <green>%uclans_player_name% <yellow>Role has now been changed to <green>%uclans_player_role_formated%", new String[0]),
    LOGGER_CLANPLAYERINVITERECEIVE("LOGGER.CLANPLAYERINVITERECEIVE", "<yellow>Player <green>{player_other} <yellow>was invited to the clan by <green>%uclans_player_name%", new String[0]),
    LOGGER_CLANALLYINVITEEVENT("LOGGER.CLANALLYINVITEEVENT", "<yellow>Your clan has sent an ally request to clan <green>{clan_other}", new String[0]),
    LOGGER_CLANRIVALINVITEEVENT("LOGGER.CLANRIVALINVITEEVENT", "<yellow>New rivalry against clan <green>{clan_other}", new String[0]),
    LOGGER_CLANPLAYERBANEVENT("LOGGER.CLANPLAYERBANEVENT", "<yellow>The player <green>{player_other} <yellow>has been banned from the clan.", new String[0]),
    LOGGER_CLANPLAYERUNBANEVENT("LOGGER.CLANPLAYERUNBANEVENT", "<yellow>The player <green>{player_other} <yellow>has been unbaned from the clan.", new String[0]),
    LOGGER_CLANFFCHANGEEVENT("LOGGER.CLANFFCHANGEEVENT", "<yellow>Clan friendly fire changed to <green>{status}", new String[0]),
    LOGGER_CLANREGROUPSENDEVENT("LOGGER.CLANREGROUPSENDEVENT", "<yellow>A request to regroup the clan has been sent by <green>{player_other}", new String[0]),
    LOGGER_CLANREWARDSEVENT("LOGGER.CLANREWARDSEVENT", "<yellow>The clan has unlocked rewards, check the list if you also received them!", new String[0]),
    General_common("GUI.Common", "", "# Common and repetitive translation items are clustered in this excerpt"),
    General_common_back_name("GUI.Common back name", "<red>Come back", new String[0]),
    General_common_back_lore("GUI.Common back lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_next_name("GUI.Common next name", "<green>Next page", new String[0]),
    General_common_next_lore("GUI.Common next lore", Arrays.asList("", " <yellow>Click to proceed."), new String[0]),
    General_common_previous_name("GUI.Common previous name", "<green>Previous page", new String[0]),
    General_common_previous_lore("GUI.Common previous lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_fill_name("GUI.Common fill name", " ", new String[0]),
    General_common_fill_lore("GUI.Common fill lore", Arrays.asList(new Object[0]), new String[0]),
    General_clan_logger_title("GUI.General clan_logger title", "<blue>Clan Logger <gray>| <green>{timer}", new String[0]),
    General_clan_logger_items_current_name("GUI.General clan_logger items current name", "<white>Origin:  <green>%uclans_logger:{id}:plugin%", new String[0]),
    General_clan_logger_items_current_lore("GUI.General clan_logger items current lore", Arrays.asList(" ", " <white>Date: <aqua>%uclans_logger:{id}:date% <dark_gray>(Expires: %uclans_logger:{id}:expires%)", " ", " <gray>- <yellow>%uclans_logger:{id}:text%"), new String[0]),
    General_clan_logger_items_clear_name("GUI.General clan_logger items clear name", "<green>Clear all log", new String[0]),
    General_clan_logger_items_clear_lore("GUI.General clan_logger items clear lore", Arrays.asList("", " <yellow>Click to clear.", "", "<red>! This cannot be undone"), new String[0]),
    General_clan_logger_items_filter_all_name("GUI.General clan_logger items filter_all name", "<green>Filter: <aqua>All", new String[0]),
    General_clan_logger_items_filter_all_lore("GUI.General clan_logger items filter_all lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_logger_items_filter_all_current_name("GUI.General clan_logger items filter_all_current name", "<green>Filter: <aqua>All", new String[0]),
    General_clan_logger_items_filter_all_current_lore("GUI.General clan_logger items filter_all_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clan_logger_items_filter_daily_name("GUI.General clan_logger items filter_daily name", "<green>Filter: <aqua>Daily", new String[0]),
    General_clan_logger_items_filter_daily_lore("GUI.General clan_logger items filter_daily lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_logger_items_filter_daily_current_name("GUI.General clan_logger items filter_daily_current name", "<green>Filter: <aqua>Daily", new String[0]),
    General_clan_logger_items_filter_daily_current_lore("GUI.General clan_logger items filter_daily_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clan_logger_items_filter_weekly_name("GUI.General clan_logger items filter_weekly name", "<green>Filter: <aqua>Weekly", new String[0]),
    General_clan_logger_items_filter_weekly_lore("GUI.General clan_logger items filter_weekly lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_logger_items_filter_weekly_current_name("GUI.General clan_logger items filter_weekly_current name", "<green>Filter: <aqua>Weekly", new String[0]),
    General_clan_logger_items_filter_weekly_current_lore("GUI.General clan_logger items filter_weekly_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clan_logger_items_filter_monthly_name("GUI.General clan_logger items filter_monthly name", "<green>Filter: <aqua>Monthly", new String[0]),
    General_clan_logger_items_filter_monthly_lore("GUI.General clan_logger items filter_monthly lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_logger_items_filter_monthly_current_name("GUI.General clan_logger items filter_monthly_current name", "<green>Filter: <aqua>Monthly", new String[0]),
    General_clan_logger_items_filter_monthly_current_lore("GUI.General clan_logger items filter_monthly_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clan_logger_items_filter_yearly_name("GUI.General clan_logger items filter_yearly name", "<green>Filter: <aqua>Yearly", new String[0]),
    General_clan_logger_items_filter_yearly_lore("GUI.General clan_logger items filter_yearly lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_logger_items_filter_yearly_current_name("GUI.General clan_logger items filter_yearly_current name", "<green>Filter: <aqua>Yearly", new String[0]),
    General_clan_logger_items_filter_yearly_current_lore("GUI.General clan_logger items filter_yearly_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clear_logger_confirm_title("GUI.General clear_logger_confirm title", "<red>Confirm clear clan log?", new String[0]),
    General_clear_logger_confirm_items_confirm_name("GUI.General clear_logger_confirm items confirm name", "<green>Confirm", new String[0]),
    General_clear_logger_confirm_items_confirm_lore("GUI.General clear_logger_confirm items confirm lore", Arrays.asList("", " <red>Click to confirm."), new String[0]),
    General_clear_logger_confirm_items_cancel_name("GUI.General clear_logger_confirm items cancel name", "<green>Cancel", new String[0]),
    General_clear_logger_confirm_items_cancel_lore("GUI.General clear_logger_confirm items cancel lore", Arrays.asList("", " <yellow>Click to cancel."), new String[0]),
    CONFIG_icon_name("GUI.Config.Icon.name", "<green>Clan Logger.", new String[0]),
    CONFIG_icon_lore("GUI.Config.Icon.lore", Arrays.asList(" <yellow>Clan happenings", " <gray>", " <gray>Amount: <green>%uclans_logger_amount%", " ", " <yellow>Click to open."), new String[0]),
    COMMANDS_logger_help_show("COMMANDS.logger.help.show", "<click:run_command:\"/{_clan} {_logger} \"><hover:show_text:'<green>Click to expand logger commands.'> <aqua>/{_clan} {_logger} <gray>-<yellow> Clan Logger.</hover></click> <hover:show_text:'<green>With sub commands.'><green>[!]</hover>", new String[0]),
    COMMANDS_logger_help_usage("COMMANDS.logger.help.usage", "%tag% <red>Use <aqua>/{_clan} {_logger}", new String[0]),
    COMMANDS_logger_help_error("COMMANDS.logger.help.error", "%tag% <red>Error.", new String[0]),
    COMMANDS_logger_help_success("COMMANDS.logger.help.success", "%tag% <green>Success.", new String[0]),
    COMMANDS_logger_clear_show("COMMANDS.logger.clear.show", "<click:suggest_command:\"/{_clan} {_logger} {_clear} \"><hover:show_text:'<green>Click to clean clan log'> <aqua>/{_clan} {_logger} {_clear} <gray>-<yellow> Clear clan logger.</hover></click>", new String[0]),
    COMMANDS_logger_clear_usage("COMMANDS.logger.clear.usage", "%tag% <red>Use <aqua>/{_clan} {_logger} {_clear}", new String[0]),
    COMMANDS_logger_clear_error("COMMANDS.logger.clear.error", "%tag% <red>There was an error clearing the clan log.", new String[0]),
    COMMANDS_logger_clear_success("COMMANDS.logger.clear.success", "%tag% <green>The clan log has been successfully cleared.", new String[0]),
    COMMANDS_logger_view_show("COMMANDS.logger.view.show", "<click:suggest_command:\"/{_clan} {_logger} {_view} \"><hover:show_text:'<green>Click to view clan logger'> <aqua>/{_clan} {_logger} {_view} <light_purple>(time) <light_purple>(page) <light_purple>(-gui) <gray>-<yellow> View clan logger.</hover></click>", new String[0]),
    COMMANDS_logger_view_usage("COMMANDS.logger.view.usage", "%tag% <red>Use <aqua>/{_clan} {_logger} {_view} <light_purple>(time) <light_purple>(page) <light_purple>(-gui)", new String[0]),
    COMMANDS_logger_view_error("COMMANDS.logger.view.error", "%tag% <red>Error", new String[0]),
    COMMANDS_logger_view_success("COMMANDS.logger.view.success", "%tag% <green>Success", new String[0]);

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

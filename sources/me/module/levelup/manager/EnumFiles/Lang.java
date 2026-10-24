package me.module.levelup.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/EnumFiles/Lang.class */
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
    CLAN_PATENT_CHANGE("LANGUAGE.clan patent change", "%tag% <yellow>The <aqua>%uclans_tag_color% <yellow>clan changed patent to <aqua>%uclans_patent_formated%", new String[0]),
    PLAYER_DONT_PERMISSION_ROLE_GUI("LANGUAGE.clan dont permission role gui", "<red>Current role cannot do this.", new String[0]),
    CLAN_IS_YOUR_CLAN("LANGUAGE.clan is your clan", "%tag% <red>This is your Clan.", new String[0]),
    GUI_ERROR("LANGUAGE.gui error", "%tag% <red>This menu contains an error and cannot be opened", new String[0]),
    TRANSLACTION_NOYES_TRUE("LANGUAGE.translaction yes", "<aqua>YES", new String[0]),
    TRANSLACTION_NOYES_FALSE("LANGUAGE.translaction no", "<red>NO", new String[0]),
    TRANSLACTION_NOCLAN("LANGUAGE.translaction no clan", "<red>No Clan", new String[0]),
    REQUIRES_DEFAULT_TRUE("LANGUAGE.requires default true", "<white>Requeriment <green><bold>OK</bold> <gray>(%value%)", new String[0]),
    REQUIRES_DEFAULT_FALSE("LANGUAGE.requires default false", "<white>Requeriment <red><bold>NO</bold> <gray>(%value%)", new String[0]),
    REQUIRES_POINTS_TRUE("LANGUAGE.requires points true", "<white>Clan Points: <green><bold>OK</bold> <gray>(%value%)", new String[0]),
    REQUIRES_POINTS_FALSE("LANGUAGE.requires points false", "<white>Clan Points: <red><bold>NO</bold> <gray>(need: %value%)", new String[0]),
    HELP_REQUIRES_HEADER("LANGUAGE.help requires header", "<blue><bold>Clan Level:</bold> <newline> <white>Current Level: <aqua>%uclans_level%<gray> | <white>Max Level: <aqua>%uclans_max_level%<newline> ", new String[0]),
    HELP_REQUIRES_FORMAT("LANGUAGE.help requires format", " <yellow><bold>Levelup requirements: ", new String[0]),
    HELP_REQUIRES_REWARDS_HEADER("LANGUAGE.help requires rewards header", "<blue><bold>Rewards Center:</bold> <newline> <white>To claim: <aqua>%uclans_player_rewards_amount%<newline> ", new String[0]),
    HELP_REQUIRES_REWARDS_FORMAT("LANGUAGE.help requires rewards format", " <click:suggest_command:\"/{_clan} {_level} {_rewards} {_collect} {id} \"><hover:show_text:'<green>Click to collect.'><gray>- <aqua>{description} <gray>({date})  <yellow><bold>[Click to Collect]</bold><newline>  <white>Sender: <aqua>{sender} <gray>| <white>Rewards: <aqua>{rewards_amount}</hover></click>", new String[0]),
    CLAN_POINT_REASON_LEVEL_CHANGE("LANGUAGE.clan point reason level change", "Clan level change", new String[0]),
    CLAN_POINT_REASON_NO_REASON("LANGUAGE.clan point reason no reason", "No reason", new String[0]),
    NEW_POINT_RECEIVED("LANGUAGE.new point received", "%tag% <green>Your clan received <aqua>%points% points<green>, and now has <aqua>%totalpoints% points (%reason%)", new String[0]),
    NEW_POINT_REMOVED("LANGUAGE.new point removed", "%tag% <red>Your clan lost <aqua>%points% points<red>, and now has <aqua>%totalpoints% points (%reason%)", new String[0]),
    NEW_POINT_SET("LANGUAGE.new point set", "%tag% <green>Your clan points have been changed to <aqua>%totalpoints% points (%reason%)", new String[0]),
    HELP_REQUIRES_LEVELUP("LANGUAGE.help requires levelup", " <click:suggest_command:\"/{_clan} {_level} {_up} \"><hover:show_text:'<green>Click to levelup.'> <green>New Level up available <yellow>[Click <aqua><bold>%uclans_level% -> %uclans_next_level%</bold></aqua><yellow>]</hover></click>", new String[0]),
    HELP_REQUIRES_LEVELUP_GUI("LANGUAGE.help requires levelup gui", "<green>Levelup available <yellow>[Click <aqua><bold>%uclans_level% -> %uclans_next_level%</bold></aqua><yellow>]", new String[0]),
    HELP_REQUIRES_LEVELUP_NEED_GUI("LANGUAGE.help requires levelup need gui", "<red>There are no requirements to meet!", new String[0]),
    HELP_REQUIRES_LEVELUP_ADVANCE_REQUIRES_GUI("LANGUAGE.help requires levelup advance_requires gui", " <gray>[Hidden Requirements]", new String[0]),
    HELP_REQUIRES_LEVELUP_ADVANCE_ACTION_GUI("LANGUAGE.help requires levelup advance gui", " <red>Advance level to view.", new String[0]),
    HELP_REQUIRES_LEVELUP_SUCCESS_GUI("LANGUAGE.help requires levelup success gui", "<green>Successfully leveled up", new String[0]),
    HELP_REQUIRES_LEVELUP_ERROR_GUI("LANGUAGE.help requires levelup error gui", "<red>Error when leveling up!", new String[0]),
    HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_SUCCESS_GUI("LANGUAGE.help requires levelup surprise collected success gui", "<green>Surprises successfully collected.", new String[0]),
    HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_SUCCESS("LANGUAGE.help requires levelup surprise collected success", "%tag% <green>You have successfully collected the surprise reward for your clan!", new String[0]),
    HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_ERROR_GUI("LANGUAGE.help requires levelup surprise collected error gui", "<red>Error collecting surprise.", new String[0]),
    HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_ERROR("LANGUAGE.help requires levelup surprise collected error", "%tag% <red>An error occurred while collecting the surprise reward for your clan.", new String[0]),
    HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_SUCCESS_GUI("LANGUAGE.help requires levelup reward collected success gui", "<green>Reward successfully collected.", new String[0]),
    HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_SUCCESS("LANGUAGE.help requires levelup reward collected success", "%tag% <green>You have successfully collected the reward!", new String[0]),
    HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_ERROR_GUI("LANGUAGE.help requires levelup reward collected error gui", "<red>Error collecting reward.", new String[0]),
    HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_ERROR("LANGUAGE.help requires levelup reward collected error", "%tag% <red>An error occurred while collecting the surprise reward.", new String[0]),
    HELP_REQUIRES_REWARD_ALREADY_COLLECTED("LANGUAGE.help requires reward already collected", "<red><bold>Already collected!", new String[0]),
    HELP_REQUIRES_MAX_REACHED("LANGUAGE.help requires max reached", "<green>Your clan has reached the maximum level. <aqua><bold>Congratulations!!!</bold> ", new String[0]),
    HELP_REWARDS_DEFAULT_TEXT("LANGUAGE.help rewards default text", "<green>Common reward", new String[0]),
    HELP_REWARDS_LEVELUP("LANGUAGE.help rewards levelup", "<green>Clan levelup to level <aqua><bold>{level}</bold></aqua>", new String[0]),
    HELP_REWARDS_SURPRISE("LANGUAGE.help rewards surprise", "<green>Surprise reward level <aqua><bold>{level}</bold></aqua>", new String[0]),
    TRANSLACTION_OK("LANGUAGE.translaction ok", "<green>OK", new String[0]),
    General_common("GUI.Common", "", "# Common and repetitive translation items are clustered in this excerpt"),
    General_common_back_name("GUI.Common back name", "<red>Come back", new String[0]),
    General_common_back_lore("GUI.Common back lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_next_name("GUI.Common next name", "<green>Next page", new String[0]),
    General_common_next_lore("GUI.Common next lore", Arrays.asList("", " <yellow>Click to proceed."), new String[0]),
    General_common_previous_name("GUI.Common previous name", "<green>Previous page", new String[0]),
    General_common_previous_lore("GUI.Common previous lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_fill_name("GUI.Common fill name", " ", new String[0]),
    General_common_fill_lore("GUI.Common fill lore", Arrays.asList(new Object[0]), new String[0]),
    General_levelup_confirm_title("GUI.General levelup_confirm title", "<red>Confirm Levelup?", new String[0]),
    General_levelup_confirm_items_confirm_name("GUI.General levelup_confirm items confirm name", "<green>Confirm", new String[0]),
    General_levelup_confirm_items_confirm_lore("GUI.General levelup_confirm items confirm lore", Arrays.asList("", " <red>Click to confirm."), new String[0]),
    General_levelup_confirm_items_cancel_name("GUI.General levelup_confirm items cancel name", "<green>Cancel", new String[0]),
    General_levelup_confirm_items_cancel_lore("GUI.General levelup_confirm items cancel lore", Arrays.asList("", " <yellow>Click to cancel."), new String[0]),
    General_levelup_home_title("GUI.General levelup_home title", "<blue>Clan Levelup <gray>| <aqua>%uclans_level%<gray>/<aqua>%uclans_max_level%", new String[0]),
    General_levelup_home_items_current_name("GUI.General levelup_home items current name", "<green>Level: <aqua>{level}", new String[0]),
    General_levelup_home_items_current_lore("GUI.General levelup_home items current lore", Arrays.asList(" ", " <white>Contains rewards: <aqua>{has_rewards}", "{REWARDS}", "{DESCRIPTION}", " <Yellow>Levelup Requeriments:", "{REQUERIMENTS}", "", "{ACTION}"), new String[0]),
    General_levelup_home_items_levelup_name("GUI.General levelup_home items levelup name", "<green>Level: <aqua>{level}", new String[0]),
    General_levelup_home_items_levelup_lore("GUI.General levelup_home items levelup lore", Arrays.asList(" ", " <green>Level passed successfully!", " <yellow>Rewards have been sent to", "<yellow>the collection box."), new String[0]),
    General_levelup_home_items_surprise_name("GUI.General levelup_home items surprise name", "<green><bold>Surprise</bold></green> <gray>(<green>Level: <aqua>{level}<gray>)", new String[0]),
    General_levelup_home_items_surprise_lore("GUI.General levelup_home items surprise lore", Arrays.asList(" ", " <green>Level passed successfully!", " <yellow>Your clan will receive a surprise reward!", "", " <green><bold>Click to collect!"), new String[0]),
    General_levelup_home_items_surprise_collected_name("GUI.General levelup_home items surprise_collected name", "<red><bold>Surprise</bold></red> <gray>(<green>Level: <aqua>{level}<gray>)", new String[0]),
    General_levelup_home_items_surprise_collected_lore("GUI.General levelup_home items surprise_collected lore", Arrays.asList(" ", " <green>Level passed successfully!", " <yellow>Surprise reward!", "", " <red>Already collected!"), new String[0]),
    General_levelup_home_items_finallist_name("GUI.General levelup_home items finallist name", "<red><bold>End Level</bold></red> <gray>(<green>Level: <aqua>{level}<gray>)", new String[0]),
    General_levelup_home_items_finallist_lore("GUI.General levelup_home items finallist lore", Arrays.asList(" ", " <yellow>This is the end. Your clan has ", "<yellow>reached the maximum level, collect", "<yellow>all the rewards.", "", " <green><bold>Congratulations!"), new String[0]),
    CONFIG_levelup_icon_name("GUI.Config.Levelup.Icon.name", "<green>Clan Levelup.", new String[0]),
    CONFIG_levelup_icon_lore("GUI.Config.Levelup.Icon.lore", Arrays.asList(" ", " <gray>Current: <aqua>%uclans_level%<gray>/<aqua>%uclans_max_level%", " <gray>Requirements for the next: <aqua>%uclans_has_next_requeriments_level_formated%", " ", " <yellow>Click to open."), new String[0]),
    COMMANDS_level_help_show("COMMANDS.level.help.show", "<click:run_command:\"/{_clan} {_level} \"><hover:show_text:'<green>Click to expand level commands.'> <aqua>/{_clan} {_level} <gray>-<yellow> Clan Level.</hover></click> <hover:show_text:'<green>With sub commands.'><green>[!]</hover>", new String[0]),
    COMMANDS_level_help_usage("COMMANDS.level.help.usage", "%tag% <red>Use <aqua>/{_clan} {_level}", new String[0]),
    COMMANDS_level_help_error("COMMANDS.level.help.error", "%tag% <red>Error.", new String[0]),
    COMMANDS_level_help_success("COMMANDS.level.help.success", "%tag% <green>Success.", new String[0]),
    COMMANDS_level_view_show("COMMANDS.level.view.show", "<click:suggest_command:\"/{_clan} {_level} {_view} \"><hover:show_text:'<green>Click to view clan level'> <aqua>/{_clan} {_level} {_view} <light_purple>(-gui) <gray>-<yellow> View clan level.</hover></click>", new String[0]),
    COMMANDS_level_view_usage("COMMANDS.level.view.usage", "%tag% <red>Use <aqua>/{_clan} {_level} {_view} <light_purple>(-gui)", new String[0]),
    COMMANDS_level_view_error("COMMANDS.level.view.error", "%tag% <red>You still have requirements to meet before leveling up.", new String[0]),
    COMMANDS_level_view_success("COMMANDS.level.view.success", "%tag% <click:suggest_command:\"/{_clan} {_level} {_up} \"><hover:show_text:'<green>Click to levelup.'> <green>New Level up available <yellow>[CLick <aqua><bold>%uclans_level% -> %uclans_next_level%</bold></aqua><yellow>]</hover></click>", new String[0]),
    COMMANDS_level_up_show("COMMANDS.level.up.show", "<click:suggest_command:\"/{_clan} {_level} {_up} \"><hover:show_text:'<green>Click to up clan level'> <aqua>/{_clan} {_level} {_up} <light_purple>(-gui) <gray>-<yellow> Up clan level.</hover></click>", new String[0]),
    COMMANDS_level_up_usage("COMMANDS.level.up.usage", "%tag% <red>Use <aqua>/{_clan} {_level} {_up} <light_purple>(-gui)", new String[0]),
    COMMANDS_level_up_error("COMMANDS.level.up.error", "%tag% <red>It was not possible to level up, see the requirements <click:suggest_command:\"/{_clan} {_level} {_view} \"><hover:show_text:'<green>Click to view.'><green><bold>[CLICKING HERE]</hover></click>", new String[0]),
    COMMANDS_level_up_success("COMMANDS.level.up.success", "%tag% <green>You have successfully leveled up your clan. Congratulations!", new String[0]);

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

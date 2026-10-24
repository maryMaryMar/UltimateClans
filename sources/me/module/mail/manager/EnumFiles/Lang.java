package me.module.mail.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/EnumFiles/Lang.class */
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
    TEXT_EMPTY("LANGUAGE.text empty", "<red>The text is empty.", new String[0]),
    CLAN_IS_YOUR_CLAN("LANGUAGE.clan is your clan", "%tag% <red>This is your Clan.", new String[0]),
    GUI_ERROR("LANGUAGE.gui error", "%tag% <red>This menu contains an error and cannot be opened", new String[0]),
    MAIL_SEND_SUCCESS("LANGUAGE.mail send success", "%tag% <green>New mail sent successfully.", new String[0]),
    MAIL_SEND_SUCCESS_GUI("LANGUAGE.mail send success gui", "%tag% <green>Successfully sent.", new String[0]),
    MAIL_SEND_ERROR_GUI("LANGUAGE.mail send error gui", "%tag% <red>Error sending.", new String[0]),
    ACCEPTED_VALUES("LANGUAGE.accept type", "%tag% <red>The type is invalid, use: <aqua>%types%", new String[0]),
    HELP_LIST_NO_NEW_MESSAGES("LANGUAGE.help no new messages", " <red>- There are no new messages.", new String[0]),
    MAIL_NEW_RECEIVED("LANGUAGE.mail new received", "%tag% <green>Your clan has received a new mail.", new String[0]),
    MAIL_ALLIE_DISABLED("LANGUAGE.mail allie disabled", "%tag% <red>The allies clan has disabled this option.", new String[0]),
    MAIL_ALL_DISABLED("LANGUAGE.mail all disabled", "%tag% <red>The clan has disabled this option.", new String[0]),
    MAIL_READSTATE_TRUE("LANGUAGE.mail readstate true", Marker.ANY_MARKER, new String[0]),
    MAIL_READSTATE_FALSE("LANGUAGE.mail readstate false", DecorationTag.REVERT, new String[0]),
    MAIL_READSTATE_FORMATED_TRUE("LANGUAGE.mail readstate formated true", "<green>*</green>", new String[0]),
    MAIL_READSTATE_FORMATED_FALSE("LANGUAGE.mail readstate formated false", "<red>!</red>", new String[0]),
    HELP_MAIL_HEADER("LANGUAGE.help mail header", "<blue><bold>Clan Mail:</bold> <gray>%time% <gray>| <gray>(%page%/%pages%)", new String[0]),
    HELP_MAIL_FORMAT("LANGUAGE.help mail format", "%uclans_mail:{id}:readstate_formated% <hover:show_text:'<green>%uclans_mail:{id}:text%'><gray>- <white>Origin: <aqua>%uclans_mail:{id}:from%<gray> | <white>Date: <aqua>%uclans_mail:{id}:date% <dark_gray>(Expires: %uclans_mail:{id}:expires%)<newline>  <aqua>%uclans_mail:{id}:text%</hover>", new String[0]),
    MAIL_CLEAR_SUCCESS_GUI("LANGUAGE.mail clear success gui", "<green>Successfully cleared mail", new String[0]),
    MAIL_CLEAR_ERROR_GUI("LANGUAGE.mail clear error gui", "<red>Error clearing the mail", new String[0]),
    MAIL_MIN_CHARS("LANGUAGE.mail min chars", "%tag% <red>Tour message must contain at least <aqua>{chars} <red>characters.", new String[0]),
    MAIL_MAX_CHARS("LANGUAGE.mail max chars", "%tag% <red>Your text appears to be very large!", new String[0]),
    MAIL_MAX_STORAGE("LANGUAGE.mail max storage", "%tag% <red>This clan mailbox is full now!", new String[0]),
    MAIL_MAX_UNREAD("LANGUAGE.mail max unread", "%tag% <red>This clan has a lot of unread messages!", new String[0]),
    HELP_PLAYER_MAIL_PREV("LANGUAGE.help player mail prev", "<click:run_command:\"/{_clan} {_mail} {_read} %time% %page%\"><hover:show_text:'<green>Click to go back.'><aqua><< Previous</hover></click>", new String[0]),
    HELP_PLAYER_MAIL_NEXT("LANGUAGE.help player mail next", "<click:run_command:\"/{_clan} {_mail} {_read} %time% %page%\"><hover:show_text:'<green>Click to advance.'><aqua>Next >></hover></click>", new String[0]),
    HELP_PLAYER_MAIL_SEPARER("LANGUAGE.help player mail separer", "<gray>|", new String[0]),
    TRANSLACTION_ALL("LANGUAGE.translaction all", "All", new String[0]),
    TRANSLACTION_READ("LANGUAGE.translaction read", "Read", new String[0]),
    TRANSLACTION_UNREAD("LANGUAGE.translaction unread", "Unread", new String[0]),
    General_common("GUI.Common", "", "# Common and repetitive translation items are clustered in this excerpt"),
    General_common_back_name("GUI.Common back name", "<red>Come back", new String[0]),
    General_common_back_lore("GUI.Common back lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_next_name("GUI.Common next name", "<green>Next page", new String[0]),
    General_common_next_lore("GUI.Common next lore", Arrays.asList("", " <yellow>Click to proceed."), new String[0]),
    General_common_previous_name("GUI.Common previous name", "<green>Previous page", new String[0]),
    General_common_previous_lore("GUI.Common previous lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_fill_name("GUI.Common fill name", " ", new String[0]),
    General_common_fill_lore("GUI.Common fill lore", Arrays.asList(new Object[0]), new String[0]),
    General_common_fill2_name("GUI.Common fill2 name", " ", new String[0]),
    General_common_fill2_lore("GUI.Common fill2 lore", Arrays.asList(new Object[0]), new String[0]),
    General_clan_mail_title("GUI.General clan_mail title", "<blue>Clan Mailbox <gray>| <green>{timer}", new String[0]),
    General_clan_mail_items_current_name("GUI.General clan_mail items current name", "<white>Origin:  <green>%uclans_mail:{id}:from%", new String[0]),
    General_clan_mail_items_current_lore("GUI.General clan_mail items current lore", Arrays.asList(" ", " <white>Date: <aqua>%uclans_mail:{id}:date% <dark_gray>(Expires: %uclans_mail:{id}:expires%)", " ", " <gray>- <yellow>%uclans_mail:{id}:text%"), new String[0]),
    General_clan_mail_items_new_name("GUI.General clan_mail items new name", "<green>Send new mail.", new String[0]),
    General_clan_mail_items_new_lore("GUI.General clan_mail items new lore", Arrays.asList("", " <yellow>Click to send."), new String[0]),
    General_clan_mail_items_clear_name("GUI.General clan_mail items clear name", "<green>Clear all mailbox", new String[0]),
    General_clan_mail_items_clear_lore("GUI.General clan_mail items clear lore", Arrays.asList("", " <yellow>Click to clear.", "", "<red>! This cannot be undone"), new String[0]),
    General_clan_mail_items_filter_all_name("GUI.General clan_mail items filter_all name", "<green>Filter: <aqua>All", new String[0]),
    General_clan_mail_items_filter_all_lore("GUI.General clan_mail items filter_all lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_mail_items_filter_all_current_name("GUI.General clan_mail items filter_all_current name", "<green>Filter: <aqua>All", new String[0]),
    General_clan_mail_items_filter_all_current_lore("GUI.General clan_mail items filter_all_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clan_mail_items_filter_unread_name("GUI.General clan_mail items filter_unread name", "<green>Filter: <aqua>Unread", new String[0]),
    General_clan_mail_items_filter_unread_lore("GUI.General clan_mail items filter_unread lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_mail_items_filter_unread_current_name("GUI.General clan_mail items filter_unread_current name", "<green>Filter: <aqua>Unread", new String[0]),
    General_clan_mail_items_filter_unread_current_lore("GUI.General clan_mail items filter_unread_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clan_mail_items_filter_read_name("GUI.General clan_mail items filter_read name", "<green>Filter: <aqua>Read", new String[0]),
    General_clan_mail_items_filter_read_lore("GUI.General clan_mail items filter_read lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_clan_mail_items_filter_read_current_name("GUI.General clan_mail items filter_read_current name", "<green>Filter: <aqua>Read", new String[0]),
    General_clan_mail_items_filter_read_current_lore("GUI.General clan_mail items filter_read_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_clear_mail_confirm_title("GUI.General clear_mail_confirm title", "<red>Confirm clear mailbox?", new String[0]),
    General_clear_mail_confirm_items_confirm_name("GUI.General clear_mail_confirm items confirm name", "<green>Confirm", new String[0]),
    General_clear_mail_confirm_items_confirm_lore("GUI.General clear_mail_confirm items confirm lore", Arrays.asList("", " <red>Click to confirm."), new String[0]),
    General_clear_mail_confirm_items_cancel_name("GUI.General clear_mail_confirm items cancel name", "<green>Cancel", new String[0]),
    General_clear_mail_confirm_items_cancel_lore("GUI.General clear_mail_confirm items cancel lore", Arrays.asList("", " <yellow>Click to cancel."), new String[0]),
    General_new_mail_title("GUI.General new_mail title", "<green>New Mail.", new String[0]),
    General_new_mail_items_my_name("GUI.General new_mail items my name", "<green>Your Clan", new String[0]),
    General_new_mail_items_my_lore("GUI.General new_mail items my lore", Arrays.asList("", " <yellow>Click to select."), new String[0]),
    General_new_mail_items_current_name("GUI.General new_mail items current name", "<green>Clan %uclans_tag_color%", new String[0]),
    General_new_mail_items_current_lore("GUI.General new_mail items current lore", Arrays.asList("", " <yellow>Clan Information", " ", " <gray>Level: <green>%uclans_level%", " <gray>Tag: <aqua>%uclans_tag_color%", " <gray>Leader: <aqua>%uclans_leader%", " <gray>Members: <aqua>%uclans_count_members%", "", " <yellow>Click to select."), new String[0]),
    General_anvil_new_mail_title("GUI.General anvil_new_mail title", "<blue>New mail for <aqua>%uclans_tag_color%", new String[0]),
    General_anvil_new_mail_items_left_name("GUI.General anvil_new_mail items left name", "<white>Write your text above", new String[0]),
    General_anvil_new_mail_items_left_lore("GUI.General anvil_new_mail items left lore", Arrays.asList(" <white>Write your text above"), new String[0]),
    General_anvil_new_mail_items_right_name("GUI.General anvil_new_mail items right name", "<red>Go back", new String[0]),
    General_anvil_new_mail_items_right_lore("GUI.General anvil_new_mail items right lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_anvil_new_mail_items_output_name("GUI.General anvil_new_mail items output name", " ", new String[0]),
    General_anvil_new_mail_items_output_lore("GUI.General anvil_new_mail items output lore", Arrays.asList("", " <yellow>Create a new home."), new String[0]),
    CONFIG_icon_name("GUI.Config.Icon.name", "<green>Clan mailbox.", new String[0]),
    CONFIG_icon_lore("GUI.Config.Icon.lore", Arrays.asList(" <yellow>Mail received", " <gray>", " <gray>Total: <green>%uclans_mail_amount%", " <gray>Unread: <green>%uclans_mail_amount_unread%", " ", " <yellow>Click to open."), new String[0]),
    COMMANDS_mail_help_show("COMMANDS.mail.help.show", "<click:run_command:\"/{_clan} {_mail} \"><hover:show_text:'<green>Click to expand mail commands.'> <aqua>/{_clan} {_mail} <gray>-<yellow> Clan Mail.</hover></click> <hover:show_text:'<green>With sub commands.'><green>[!]</hover>", new String[0]),
    COMMANDS_mail_help_usage("COMMANDS.mail.help.usage", "%tag% <red>Use <aqua>/{_clan} {_mail}", new String[0]),
    COMMANDS_mail_help_error("COMMANDS.mail.help.error", "%tag% <red>Error.", new String[0]),
    COMMANDS_mail_help_success("COMMANDS.mail.help.success", "%tag% <green>Success.", new String[0]),
    COMMANDS_mail_clear_show("COMMANDS.mail.clear.show", "<click:suggest_command:\"/{_clan} {_mail} {_clear} \"><hover:show_text:'<green>Click to clean clan mail'> <aqua>/{_clan} {_mail} {_clear} <gray>-<yellow> Clear clan mail box.</hover></click>", new String[0]),
    COMMANDS_mail_clear_usage("COMMANDS.mail.clear.usage", "%tag% <red>Use <aqua>/{_clan} {_mail} {_clear}", new String[0]),
    COMMANDS_mail_clear_error("COMMANDS.mail.clear.error", "%tag% <red>There was an error clearing the clan mail box.", new String[0]),
    COMMANDS_mail_clear_success("COMMANDS.mail.clear.success", "%tag% <green>The clan mail box has been successfully cleared.", new String[0]),
    COMMANDS_mail_read_show("COMMANDS.mail.read.show", "<click:suggest_command:\"/{_clan} {_mail} {_read} \"><hover:show_text:'<green>Click to read clan mail'> <aqua>/{_clan} {_mail} {_read} <light_purple>(time) <light_purple>(page) <light_purple>(-gui) <gray>-<yellow> View clan mail.</hover></click>", new String[0]),
    COMMANDS_mail_read_usage("COMMANDS.mail.read.usage", "%tag% <red>Use <aqua>/{_clan} {_mail} {_read} <light_purple>(time) <light_purple>(page) <light_purple>(-gui)", new String[0]),
    COMMANDS_mail_read_error("COMMANDS.mail.read.error", "%tag% <red>Error", new String[0]),
    COMMANDS_mail_read_success("COMMANDS.mail.read.success", "%tag% <green>Success", new String[0]),
    COMMANDS_mail_send_show("COMMANDS.mail.send.show", "<click:suggest_command:\"/{_clan} {_mail} {_send} \"><hover:show_text:'<green>Click to send clan mail'> <aqua>/{_clan} {_mail} {_send} <red><to> <red><text> <gray>-<yellow> Send a Mail.</hover></click>", new String[0]),
    COMMANDS_mail_send_usage("COMMANDS.mail.send.usage", "%tag% <red>Use <aqua>/{_clan} {_mail} {_send} <red><to> <red><text>", new String[0]),
    COMMANDS_mail_send_error("COMMANDS.mail.send.error", "%tag% <red>An error occurred while sending the mail.", new String[0]),
    COMMANDS_mail_send_success("COMMANDS.mail.send.success", "%tag% <green>Mail sent successfully.", new String[0]);

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

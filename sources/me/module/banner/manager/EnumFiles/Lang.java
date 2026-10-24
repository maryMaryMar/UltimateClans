package me.module.banner.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/EnumFiles/Lang.class */
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
    BANNER_DELETE_ERROR_GUI("LANGUAGE.banner delete error gui", "<red>Error deleting!", new String[0]),
    BANNER_DELETE_SUCCESS_GUI("LANGUAGE.banner delete success gui", "<aqua>Successfully deleted!", new String[0]),
    BANNER_DELETE_ERROR("LANGUAGE.banner delete error", "%tag% <red>An error occurred when deleting.", new String[0]),
    BANNER_DELETE_SUCCESS("LANGUAGE.banner delete success", "%tag% <green>Banner successfully deleted!", new String[0]),
    BANNER_EMPTY("LANGUAGE.banner empty", "%tag% <red>Your Clan has no Banner!", new String[0]),
    BANNER_EMPTY_GUI("LANGUAGE.banner empty gui", "<red>Your Clan has no Banner!", new String[0]),
    BANNER_EMPTY_ITEM("LANGUAGE.banner empty item", "<red>The item must be a banner!", new String[0]),
    BANNER_NOT_ACCEPTABLE("LANGUAGE.banner not acceptable", "%tag% <red>This item is not acceptable as a Clan banner.", new String[0]),
    BANNER_ACCEPTABLE_LIST("LANGUAGE.banner acceptable list", " <red>Acceptable types: <aqua>%uclans_banner_upload_acceptable%", new String[0]),
    BANNER_NOT_ACCEPTABLE_GUI("LANGUAGE.banner not acceptable gui", "<red>Item is not acceptable.", new String[0]),
    BANNER_NOT_BANNER("LANGUAGE.banner not banner", "%tag% <red>The item you are holding must be a banner", new String[0]),
    BANNER_HAND_EMPTY("LANGUAGE.banner hand empty", "%tag% <red>You need to be holding an item.", new String[0]),
    BANNER_UPLOAD_ERROR_GUI("LANGUAGE.banner upload error gui", "<red>Error saving banner.", new String[0]),
    BANNER_UPLOAD_SUCCESS_GUI("LANGUAGE.banner upload success gui", "<aqua>New banner saved!", new String[0]),
    BANNER_UPLOAD_SUCCESS("LANGUAGE.banner upload success", "%tag% <aqua>The new clan banner has been saved!", new String[0]),
    CLAN_FEATURE_NOT_UNLOCKED("LANGUAGE.clan feature not unlocked", "%tag% <red>Your clan does not have this feature available, this requires level <aqua>%uclans_required_level:{type}%", new String[0]),
    CLAN_FEATURE_NOT_UNLOCKED_GUI("LANGUAGE.clan feature not unlocked gui", "<red>Requires level <aqua>%uclans_required_level:{type}%", new String[0]),
    HELP_CLAN_BANNER_LIST_HEADER("LANGUAGE.help clan banner list header", "<newline>%uclans_tag_color%<blue><bold> banner:", new String[0]),
    HELP_CLAN_BANNER_LIST_FORMAT("LANGUAGE.help clan banner list format", Arrays.asList("<blue><bold>|</bold> <blue>Info:", " <white>Has Banner: <aqua>%uclans_hasbanner_formated%", " <white>Banner: <aqua>%uclans_banner_material%"), new String[0]),
    CONFIG_icon_name("GUI.Config.Icon.name", "<green>Clan Banner.", new String[0]),
    CONFIG_icon_lore("GUI.Config.Icon.lore", Arrays.asList(" ", " <yellow>Banner Information:", "", " <white>Has Banner: <aqua>%uclans_hasbanner_formated%", " <white>Banner: <aqua>%uclans_banner_material%", " ", " <yellow>The clan banner is your brand!"), new String[0]),
    COMMANDS_banner_help_show("COMMANDS.banner.help.show", "<click:run_command:\"/{_clan} {_banner} \"><hover:show_text:'<green>Click to expand banner commands.'> <aqua>/{_clan} {_banner} <gray>-<yellow> Change clan banner.</hover></click> <hover:show_text:'<green>With sub commands.'><green>[!]</hover>", new String[0]),
    COMMANDS_banner_help_usage("COMMANDS.banner.help.usage", "%tag% <red>Use <aqua>/{_clan} {_banner}", new String[0]),
    COMMANDS_banner_help_error("COMMANDS.banner.help.error", "%tag% <red>An error occurred while changing clan banner.", new String[0]),
    COMMANDS_banner_help_success("COMMANDS.banner.help.success", "%tag% <green>Success", new String[0]),
    COMMANDS_banner_upload_show("COMMANDS.banner.upload.show", "<click:suggest_command:\"/{_clan} {_banner} {_upload} \"><hover:show_text:'<green>Click to upload a banner.'> <aqua>/{_clan} {_banner} {_upload} <light_purple>(-gui) <gray>-<yellow> Upload a clan banner.</hover></click>", new String[0]),
    COMMANDS_banner_upload_usage("COMMANDS.banner.upload.usage", "%tag% <red>Use <aqua>/{_clan} {_banner} {_upload} <light_purple>(-gui)", new String[0]),
    COMMANDS_banner_upload_error("COMMANDS.banner.upload.error", "%tag% <red>An error occurred while uploading banner.", new String[0]),
    COMMANDS_banner_upload_success("COMMANDS.banner.upload.success", "%tag% <green>New clan banner successfully saved.", new String[0]),
    COMMANDS_banner_delete_show("COMMANDS.banner.delete.show", "<click:suggest_command:\"/{_clan} {_banner} {_delete} \"><hover:show_text:'<green>Click to delete the banner.'> <aqua>/{_clan} {_banner} {_delete} <gray>-<yellow> Delete the clan banner.</hover></click>", new String[0]),
    COMMANDS_banner_delete_usage("COMMANDS.banner.delete.usage", "%tag% <red>Use <aqua>/{_clan} {_banner} {_delete}", new String[0]),
    COMMANDS_banner_delete_error("COMMANDS.banner.delete.error", "%tag% <red>There was an error deleting the clan banner.", new String[0]),
    COMMANDS_banner_delete_success("COMMANDS.banner.delete.success", "%tag% <green>The banner has been successfully deleted.", new String[0]),
    COMMANDS_banner_view_show("COMMANDS.banner.view.show", "<click:suggest_command:\"/{_clan} {_banner} {_view} \"><hover:show_text:'<green>Click to view banner information.'> <aqua>/{_clan} {_banner} {_view} <light_purple>(-gui) <gray>-<yellow> View banner information.</hover></click>", new String[0]),
    COMMANDS_banner_view_usage("COMMANDS.banner.view.usage", "%tag% <red>Use <aqua>/{_clan} {_banner} {_view} <light_purple>(-gui)", new String[0]),
    COMMANDS_banner_view_error("COMMANDS.banner.view.error", "%tag% <red>An error occurred while viewing clan banner.", new String[0]),
    COMMANDS_banner_view_success("COMMANDS.banner.view.success", "%tag% <green>Success.", new String[0]),
    General_common("GUI.Common", "", "# Common and repetitive translation items are clustered in this excerpt"),
    General_common_back_name("GUI.Common back name", "<red>Come back", new String[0]),
    General_common_back_lore("GUI.Common back lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_next_name("GUI.Common next name", "<green>Next page", new String[0]),
    General_common_next_lore("GUI.Common next lore", Arrays.asList("", " <yellow>Click to proceed."), new String[0]),
    General_common_previous_name("GUI.Common previous name", "<green>Previous page", new String[0]),
    General_common_previous_lore("GUI.Common previous lore", Arrays.asList("", " <yellow>Click to Come back."), new String[0]),
    General_common_fill_name("GUI.Common fill name", " ", new String[0]),
    General_common_fill_lore("GUI.Common fill lore", Arrays.asList(new Object[0]), new String[0]),
    General_banner_home_title("GUI.General banner_home title", "<blue>Banner menu", new String[0]),
    General_banner_home_items_current_name("GUI.General banner_home items current name", "<green>Current Banner", new String[0]),
    General_banner_home_items_current_lore("GUI.General banner_home items current lore", Arrays.asList(" ", " <yellow>The clan banner is your brand.", "", " <aqua><bold><< <red>Use the buttons on the sides <aqua><bold>>>"), new String[0]),
    General_banner_home_items_upload_name("GUI.General banner_home items upload name", "<green>Upload", new String[0]),
    General_banner_home_items_upload_lore("GUI.General banner_home items upload lore", Arrays.asList("", " <yellow>Click to open upload menu."), new String[0]),
    General_banner_home_items_delete_name("GUI.General banner_home items delete name", "<green>Delete a Banner", new String[0]),
    General_banner_home_items_delete_lore("GUI.General banner_home items delete lore", Arrays.asList("", " <yellow>Click to delete the current banner."), new String[0]),
    General_banner_home_items_pre_name("GUI.General banner_home items pre name", "<green>Pre created banners.", new String[0]),
    General_banner_home_items_pre_lore("GUI.General banner_home items pre lore", Arrays.asList("", " <yellow>Click to open list."), new String[0]),
    General_banner_home_pre_title("GUI.General banner_home_pre title", "<blue>Select banner icon", new String[0]),
    General_banner_home_pre_items_current_name("GUI.General banner_home_pre items current name", "<green>%name%.", new String[0]),
    General_banner_home_pre_items_current_lore("GUI.General banner_home_pre items current lore", Arrays.asList("", " <yellow>Click to select."), new String[0]),
    General_banner_home_pre_items_common_name("GUI.General banner_home_pre items common name", "<green>Filter: <aqua>Common", new String[0]),
    General_banner_home_pre_items_common_lore("GUI.General banner_home_pre items common lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_banner_home_pre_items_common_current_name("GUI.General banner_home_pre items common_current name", "<green>Filter: <aqua>Common", new String[0]),
    General_banner_home_pre_items_common_current_lore("GUI.General banner_home_pre items common_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_banner_home_pre_items_head_name("GUI.General banner_home_pre items head name", "<green>Filter: <aqua>Heads", new String[0]),
    General_banner_home_pre_items_head_lore("GUI.General banner_home_pre items head lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_banner_home_pre_items_head_current_name("GUI.General banner_home_pre items head_current name", "<green>Filter: <aqua>Heads", new String[0]),
    General_banner_home_pre_items_head_current_lore("GUI.General banner_home_pre items head_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_banner_home_pre_items_banner_name("GUI.General banner_home_pre items banner name", "<green>Filter: <aqua>Banners", new String[0]),
    General_banner_home_pre_items_banner_lore("GUI.General banner_home_pre items banner lore", Arrays.asList("", " <yellow>Click to apply filter."), new String[0]),
    General_banner_home_pre_items_banner_current_name("GUI.General banner_home_pre items banner_current name", "<green>Filter: <aqua>Banners", new String[0]),
    General_banner_home_pre_items_banner_current_lore("GUI.General banner_home_pre items banner_current lore", Arrays.asList("", " <green>Current filter"), new String[0]),
    General_banner_delete_title("GUI.General banner_delete title", "<red>Confirm delete current banner?", new String[0]),
    General_banner_delete_items_confirm_name("GUI.General banner_delete items confirm name", "<green>Confirm", new String[0]),
    General_banner_delete_items_confirm_lore("GUI.General banner_delete items confirm lore", Arrays.asList("", " <red>Click to confirm."), new String[0]),
    General_banner_delete_items_cancel_name("GUI.General banner_delete items cancel name", "<green>Cancel", new String[0]),
    General_banner_delete_items_cancel_lore("GUI.General banner_delete items cancel lore", Arrays.asList("", " <yellow>Click to cancel."), new String[0]),
    General_banner_upload_title("GUI.General banner_upload title", "<blue>Banner Upload", new String[0]),
    General_banner_upload_items_fill2_name("GUI.General banner_upload items fill2 name", "<red>Place your new banner here!", new String[0]),
    General_banner_upload_items_fill2_lore("GUI.General banner_upload items fill2 lore", Arrays.asList(" ", " <red>Place your new banner here!"), new String[0]),
    General_banner_upload_items_upload_slot_name("GUI.General banner_upload items upload_slot name", "", new String[0]),
    General_banner_upload_items_upload_slot_lore("GUI.General banner_upload items upload_slot lore", Arrays.asList(new Object[0]), new String[0]),
    General_banner_upload_items_confirm_name("GUI.General banner_upload items confirm name", "<green>Click to save.", new String[0]),
    General_banner_upload_items_confirm_lore("GUI.General banner_upload items confirm lore", Arrays.asList("", " <yellow>Click here to save."), new String[0]);

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

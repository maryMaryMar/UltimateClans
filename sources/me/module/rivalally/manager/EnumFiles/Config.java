package me.module.rivalally.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CONFIG_rival("Config.Rival", " ", ""),
    CONFIG_rival_remove_need_confirmation("Config.Rival.remove.need_confirmation", true, new String[0]),
    CONFIG_rival_remove_max_time_seconds("Config.Rival.remove.max_time_seconds", 60, " # IN SECONDS"),
    CONFIG_rival_default_limit("Config.Rival.default_limit", 3, new String[0]),
    CONFIG_rival_icon("Config.Rival.Icon", "", " "),
    CONFIG_rival_icon_click_sound("Config.Rival.Icon.click_sound", "", new String[0]),
    CONFIG_rival_icon_material("Config.Rival.Icon.material", "GOLDEN_HELMET", new String[0]),
    CONFIG_rival_icon_name("Config.Rival.Icon.name", "", new String[0]),
    CONFIG_rival_icon_texture("Config.Rival.Icon.texture", "", new String[0]),
    CONFIG_rival_icon_lore("Config.Rival.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_rival_icon_glow("Config.Rival.Icon.glow", false, new String[0]),
    CONFIG_rival_icon_slot("Config.Rival.Icon.slot", 31, new String[0]),
    CONFIG_rival_icon_page("Config.Rival.Icon.page", "clan_home", new String[0]),
    CONFIG_rival_icon_mimeslots("Config.Rival.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_rival_icon_nbt_string("Config.Rival.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_rival_icon_nbt_integer("Config.Rival.Icon.model", 0, new String[0]),
    CONFIG_rival_icon_left_click_action("Config.Rival.Icon.left_click_action", Arrays.asList("/{_clan} {_rival} {_list} -gui"), new String[0]),
    CONFIG_rival_icon_right_click_action("Config.Rival.Icon.right_click_action", Arrays.asList("/{_clan} {_rival} {_list} -gui"), new String[0]),
    CONFIG_ally("Config.Ally", " ", ""),
    CONFIG_ally_invite_need_confirmation("Config.Ally.invite.need_confirmation", true, new String[0]),
    CONFIG_ally_invite_max_time_seconds("Config.Ally.invite.max_time_seconds", 60, " # IN SECONDS"),
    CONFIG_ally_default_limit("Config.Ally.default_limit", 3, new String[0]),
    CONFIG_ally_icon("Config.Ally.Icon", "", " "),
    CONFIG_ally_icon_click_sound("Config.Ally.Icon.click_sound", "", new String[0]),
    CONFIG_ally_icon_material("Config.Ally.Icon.material", "DIAMOND_HELMET", new String[0]),
    CONFIG_ally_icon_name("Config.Ally.Icon.name", "", new String[0]),
    CONFIG_ally_icon_texture("Config.Ally.Icon.texture", "", new String[0]),
    CONFIG_ally_icon_lore("Config.Ally.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_ally_icon_glow("Config.Ally.Icon.glow", false, new String[0]),
    CONFIG_ally_icon_slot("Config.Ally.Icon.slot", 32, new String[0]),
    CONFIG_ally_icon_page("Config.Ally.Icon.page", "clan_home", new String[0]),
    CONFIG_ally_icon_mimeslots("Config.Ally.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_ally_icon_nbt_string("Config.Ally.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_ally_icon_nbt_integer("Config.Ally.Icon.model", 0, new String[0]),
    CONFIG_ally_icon_left_click_action("Config.Ally.Icon.left_click_action", Arrays.asList("/{_clan} {_ally} {_list} -gui"), new String[0]),
    CONFIG_ally_icon_right_click_action("Config.Ally.Icon.right_click_action", Arrays.asList("/{_clan} {_ally} {_list} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_ally_manager("Config.Permissions.ally-manager", "", new String[0]),
    CONFIG_permissions_ally_manager_name("Config.Permissions.ally-manager.name", "Ally-Manager", new String[0]),
    CONFIG_permissions_ally_manager_default_value("Config.Permissions.ally-manager.default_value", true, new String[0]),
    CONFIG_permissions_ally_manager_applicable_roles("Config.Permissions.ally-manager.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    CONFIG_permissions_rival_manager("Config.Permissions.rival-manager", "", new String[0]),
    CONFIG_permissions_rival_manager_name("Config.Permissions.rival-manager.name", "Rival-Manager", new String[0]),
    CONFIG_permissions_rival_manager_default_value("Config.Permissions.rival-manager.default_value", true, new String[0]),
    CONFIG_permissions_rival_manager_applicable_roles("Config.Permissions.rival-manager.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    LEVEL_unlocker_ally("Config.unlocker.ally", Arrays.asList("1:1", "5:10", "10:20"), " ", " ", "# format: CLAN_ALLIED/REQUIRED_LEVEL", "#You can add multiple allys for various clan levels.", "#example:", "#    ally:", "#      - '1:1' #The clan can have 1 ally if it is level 1", "#      - '5:10' #The clan can have 5 ally if it is level 10", "#      - '10:20' #The clan can have 10 ally if it is level 20"),
    LEVEL_unlocker_rival("Config.unlocker.rival", Arrays.asList("1:1", "5:10", "10:20"), " ", " ", "# format: CLAN_RIVALRIES/REQUIRED_LEVEL", "#You can add multiple rivals for various clan levels.", "#example:", "#    rival:", "#      - '1:1' #The clan can have 1 rival if it is level 1", "#      - '5:10' #The clan can have 5 rival if it is level 10", "#      - '10:20' #The clan can have 10 rival if it is level 20");

    private String path;
    private Object defaultValue;
    private String[] comments;

    Config(String str, Object obj, String... strArr) {
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

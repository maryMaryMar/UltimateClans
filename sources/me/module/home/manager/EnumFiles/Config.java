package me.module.home.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CLAN_HOME("Config.Home", "", " "),
    LEVEL_default_homes("Config.Home.default_amount", 3, new String[0]),
    CLAN_HOME_enabled("Config.Home.enabled", true, "#If disabled this does not appear in the menu and the command is marked as disabled."),
    CLAN_HOME_guiclick_teleport_as_command("Config.Home.guiclick_teleport_as_command", false, new String[0]),
    CLAN_HOME_allowed_chars("Config.Home.allowed_chars", "[0-9a-zA-Z_-]*", new String[0]),
    CLAN_HOME_public("Config.Home.public", false, new String[0]),
    CLAN_HOME_can_toggle_view("Config.Home.can_toggle_view", true, new String[0]),
    CLAN_HOME_disabled_region("Config.Home.disabled_regions", Arrays.asList(new Object[0]), "# wg region"),
    CLAN_HOME_disabled_worlds("Config.Home.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    CLAN_HOME_terrain("Config.Home.terrain", "", "# This option allows you to enable or disable the creation of clan homes inside and outside land.", "#Addons available: ClanLand, ClanNexus", "#Plugins available: HuskClaims", "# If you need more land implementations open a support ticket"),
    CLAN_HOME_terrain_verify_enabled("Config.Home.terrain.verify_enabled", true, new String[0]),
    CLAN_HOME_terrain_disabled_plugin("Config.Home.terrain.disabled_plugin", Arrays.asList(new Object[0]), "# Plugins added here will be disabled from creating homes inside terrain"),
    CLAN_HOME_terrain_enabled_plugin("Config.Home.terrain.enabled_plugin", Arrays.asList(new Object[0]), "# Plugins added here will be able to create home only inside the terrain"),
    CONFIG_specialpermissions_bypass_home_regions("Config.special_permissions.bypass_home_regions", "uclans.bypass_home_regions", new String[0]),
    CONFIG_specialpermissions_bypass_home_worlds("Config.special_permissions.bypass_home_worlds", "uclans.bypass_home_worlds", new String[0]),
    CONFIG_icon("Config.Icon", "", " "),
    CONFIG_icon_click_sound("Config.Icon.click_sound", "", new String[0]),
    CONFIG_icon_material("Config.Icon.material", "BOW", new String[0]),
    CONFIG_icon_name("Config.Icon.name", "", new String[0]),
    CONFIG_icon_texture("Config.Icon.texture", "", new String[0]),
    CONFIG_icon_lore("Config.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_glow("Config.Icon.glow", false, new String[0]),
    CONFIG_icon_slot("Config.Icon.slot", 39, new String[0]),
    CONFIG_icon_mimeslots("Config.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_icon_nbt_string("Config.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_nbt_integer("Config.Icon.model", 0, new String[0]),
    CONFIG_icon_left_click_action("Config.Icon.left_click_action", Arrays.asList("/{_clan} {_home} {_list} -gui"), new String[0]),
    CONFIG_icon_right_click_action("Config.Icon.right_click_action", Arrays.asList("/{_clan} {_home} {_list} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_manager("Config.Permissions.manager", "", new String[0]),
    CONFIG_permissions_manager_name("Config.Permissions.manager.name", "Home-manager", new String[0]),
    CONFIG_permissions_manager_default_value("Config.Permissions.manager.default_value", true, new String[0]),
    CONFIG_permissions_manager_applicable_roles("Config.Permissions.manager.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    LEVEL_unlocker_home("Config.Unlocker.home", Arrays.asList("1:1", "5:10", "10:20"), " ", " ", "# format: CLAN_HOMES/REQUIRED_LEVEL", "#You can add multiple homes for various clan levels.", "#example:", "#    home:", "#      - '1:1' #The clan can have 1 home if it is level 1", "#      - '5:10' #The clan can have 5 home if it is level 10", "#      - '10:20' #The clan can have 10 home if it is level 30");

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

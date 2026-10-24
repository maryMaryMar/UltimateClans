package me.module.banner.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;
import org.bukkit.DyeColor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CONFIG_icon("Config.Icon", "", " "),
    CONFIG_icon_click_sound("Config.Icon.click_sound", "", new String[0]),
    CONFIG_icon_material("Config.Icon.material", "", new String[0]),
    CONFIG_icon_name("Config.Icon.name", "", new String[0]),
    CONFIG_icon_texture("Config.Icon.texture", "%uclans_banner%", new String[0]),
    CONFIG_icon_lore("Config.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_glow("Config.Icon.glow", false, new String[0]),
    CONFIG_icon_slot("Config.Icon.slot", 4, new String[0]),
    CONFIG_icon_mimeslots("Config.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_icon_nbt_string("Config.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_nbt_integer("Config.Icon.model", 0, new String[0]),
    CONFIG_icon_left_click_action("Config.Icon.left_click_action", Arrays.asList("/{_clan} {_banner} {_view} -gui"), new String[0]),
    CONFIG_icon_right_click_action("Config.Icon.right_click_action", Arrays.asList("/{_clan} {_banner} {_view} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_manager("Config.Permissions.manager", "", new String[0]),
    CONFIG_permissions_manager_name("Config.Permissions.manager.name", "Banner-manager", new String[0]),
    CONFIG_permissions_manager_default_value("Config.Permissions.manager.default_value", true, new String[0]),
    CONFIG_permissions_manager_applicable_roles("Config.Permissions.manager.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    LEVEL_unlocker_banner("Config.Unlocker.banner", Arrays.asList("GROUP_1:0", "HEAD_GROUP_1:10", "BANNER_GROUP_1:20"), " ", " ", "# format: BANNER_GROUP/REQUIRED_LEVEL", "#You can add multiple slots for various clan levels.", "#example:", "#    banner:", "#      - 'GROUP_1:0' # Clan can use these groups if it is level 0", "#      - 'GROUP_1,HEAD_GROUP_1:10' # Clan can use these groups if it is level 10", "#      - 'GROUP_1,HEAD_GROUP_1,BANNER_GROUP_1:20' # Clan can use these groups if it is level 20"),
    BANNER("Config.Banner", " ", new String[0]),
    BANNER_defaut("Config.Banner.default_material", "ARMOR_STAND", new String[0]),
    BANNER_ucfirst_id("Config.Banner.ucfirst_id", true, new String[0]),
    BANNER_groups("Config.Banner.groups", "", " "),
    BANNER_groups_common("Config.Banner.groups.common", "", " ", "# Use ALL to enable all materials.", "# Filters are always required to show specific groups or items.", "# PREFIX_ can be used as ex PREFIX_DIAMOND, results in all items starting with DIAMOND", "# SUFFIX_ can be used as ex SUFFIX_BANNER, results in all items ending with BANNER", "# Item MATERIAL can be used like ANVIL, IRON_CHESTPLATE, APPLE etc.", ""),
    BANNER_groups_GROUP_1("Config.Banner.groups.common.GROUP_1", Arrays.asList("BLACK_BANNER", "RED_BANNER", "GREEN_BANNER", "BROWN_BANNER", "BLUE_BANNER", "PURPLE_BANNER", "CYAN_BANNER", "LIGHT_GRAY_BANNER", "GRAY_BANNER", "PINK_BANNER", "LIME_BANNER", "YELLOW_BANNER", "LIGHT_BLUE_BANNER", "MAGENTA_BANNER", "ORANGE_BANNER", "WHITE_BANNER"), new String[0]),
    BANNER_groups_GROUP_2("Config.Banner.groups.common.GROUP_2", Arrays.asList("ALL"), "# New custom groups can be created such as GROUP_3, MyGroup etc..."),
    BANNER_special_head("Config.Banner.groups.head", "", " ", "# The head groups only receive the texture in base64 format", "# try to always use lowercase for the ids"),
    BANNER_special_head_HEAD_GROUP_1("Config.Banner.groups.head.HEAD_GROUP_1", "", new String[0]),
    BANNER_special_head_HEAD_GROUP_1_brasil("Config.Banner.groups.head.HEAD_GROUP_1.brasil", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE0NjQ3NWQ1ZGNjODE1ZjZjNWYyODU5ZWRiYjEwNjExZjNlODYxYzBlYjE0ZjA4ODE2MWIzYzBjY2IyYjBkOSJ9fX0=", new String[0]),
    BANNER_special_head_HEAD_GROUP_1_bunny("Config.Banner.groups.head.HEAD_GROUP_1.bunny", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjMzODlhMzI0M2EyOWRiZjg4OTkwYmQ0MmM4OTQ1ZWMyMDFmNjk4MTQ5OWU3OGU1MWQwMTU3MjQzMGU5Mzk4YSJ9fX0=", new String[0]),
    BANNER_special_head_HEAD_GROUP_1_eye("Config.Banner.groups.head.HEAD_GROUP_1.eye", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzAwY2U1MjBmMjY3YTBkMDI1OGQwYmM2NWY0N2U4ZTMxYTVkNmFkMzI2ZjcwNTE3Yjg2NjNmNTJkZGEyNjcwYyJ9fX0=", new String[0]),
    BANNER_special_banner("Config.Banner.groups.banner", "", " ", "# Banner groups must have pattern and color specifications.", "# The banner groups only receive the banners in JSON format", "# Available colors: " + Arrays.asList(DyeColor.values()).toString(), "# try to always use lowercase for the ids", "# Pattern group example \"Patterns\": [{Pattern:creeper, Color:BLACK},{Pattern:MOJANG, Color:YELLOW}]"),
    BANNER_special_banner_BANNER_GROUP_1_creeper("Config.Banner.groups.banner.BANNER_GROUP_1.creeper", "{\"Color\": \"GREEN\",\"Patterns\": [{Pattern: \"CREEPER\", Color: \"BLACK\"}]}", new String[0]),
    BANNER_special_banner_BANNER_GROUP_1_mojang("Config.Banner.groups.banner.BANNER_GROUP_1.mojang", "{\"Color\": \"WHITE\",\"Patterns\": [{Pattern: \"MOJANG\", Color: \"YELLOW\"}]}", new String[0]);

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

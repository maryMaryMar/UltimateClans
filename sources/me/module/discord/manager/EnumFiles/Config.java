package me.module.discord.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CLAN_Discord("Config.Discord", "", " "),
    CLAN_Discord_message_format("Config.Discord.message_format", "<hover:show_text:\"<green>Origin: <aqua>Discord<newline><newline><white> Sender: <aqua>{player} <newline><white> Discord user ID: <aqua>{uuid}\"><green>[Discord] <light_purple>> <dark_purple>{player}<light_purple>: <light_purple>{message}</hover>", new String[0]),
    CONFIG_icon("Config.Icon", "", " "),
    CONFIG_icon_click_sound("Config.Icon.click_sound", "", new String[0]),
    CONFIG_icon_material("Config.Icon.material", "PLAYER_HEAD", new String[0]),
    CONFIG_icon_name("Config.Icon.name", "", new String[0]),
    CONFIG_icon_texture("Config.Icon.texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYyYTFiNDczYmEzYzI1ZTZlYjE0NThkZmM5NTM5MjFmNWQ5MTQ3OGFmOWQ2ZGRhMDdjMDMyZjkyOGMifX19", new String[0]),
    CONFIG_icon_lore("Config.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_glow("Config.Icon.glow", false, new String[0]),
    CONFIG_icon_slot("Config.Icon.slot", 15, new String[0]),
    CONFIG_icon_page("Config.Icon.page", "clan_settings", new String[0]),
    CONFIG_icon_mimeslots("Config.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_icon_nbt_string("Config.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_nbt_integer("Config.Icon.model", 0, new String[0]),
    CONFIG_icon_left_click_action("Config.Icon.left_click_action", Arrays.asList("/{_clan} {_discord}"), new String[0]),
    CONFIG_icon_right_click_action("Config.Icon.right_click_action", Arrays.asList("/{_clan} {_discord}"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_edit("Config.Permissions.edit", "", new String[0]),
    CONFIG_permissions_edit_name("Config.Permissions.edit.name", "Discord-Edit", new String[0]),
    CONFIG_permissions_edit_default_value("Config.Permissions.edit.default_value", true, new String[0]),
    CONFIG_permissions_edit_applicable_roles("Config.Permissions.edit.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]);

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

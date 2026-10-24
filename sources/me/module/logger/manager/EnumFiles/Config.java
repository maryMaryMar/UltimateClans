package me.module.logger.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CONFIG_timezone("Config.timezone", "America/Sao_Paulo", " ", "# Timezone is the definition of times by locations and countries. you can choose which timezone best fits your schedule", "# https://en.wikipedia.org/wiki/List_of_tz_database_time_zones"),
    CLAN_LOGGER("Config.Logger", "", " "),
    CLAN_LOGGER_enable_colors("Config.Logger.enable_colors", true, new String[0]),
    CLAN_LOGGER_time_expires("Config.Logger.time_expires", 2880, "# in minutes, 2880 minutes = 2 days"),
    CLAN_LOGGER_plugin_material("Config.Logger.plugin_material", "IRON_AXE", new String[0]),
    CLAN_LOGGER_plugin_namel("Config.Logger.plugin_name", "Clan", new String[0]),
    CLAN_LOGGER_events("Config.Logger.events", "", new String[0]),
    CLAN_LOGGER_events_ClanPlayerInviteReceive("Config.Logger.events.ClanPlayerInviteReceive", true, new String[0]),
    CLAN_LOGGER_events_ClanPlayerRoleChangeEvent("Config.Logger.events.ClanPlayerRoleChangeEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanPlayerJoinEvent("Config.Logger.events.ClanPlayerJoinEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanPlayerLeaveEvent("Config.Logger.events.ClanPlayerLeaveEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanPlayerKickedEvent("Config.Logger.events.ClanPlayerKickedEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanCreateEvent("Config.Logger.events.ClanCreateEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanModTagEvent("Config.Logger.events.ClanModTagEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanModDescEvent("Config.Logger.events.ClanModDescEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanPointChangeEvent("Config.Logger.events.ClanPointChangeEvent", false, new String[0]),
    CLAN_LOGGER_events_ClanLevelEvent("Config.Logger.events.ClanLevelEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanVerifyChangeEvent("Config.Logger.events.ClanVerifyChangeEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanLeaderChangeEvent("Config.Logger.events.ClanLeaderChangeEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanAllyAddEvent("Config.Logger.events.ClanAllyAddEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanAllyRemoveEvent("Config.Logger.events.ClanAllyRemoveEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanRivalRemoveEvent("Config.Logger.events.ClanRivalRemoveEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanRivalAddEvent("Config.Logger.events.ClanRivalAddEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanHomeCreateEvent("Config.Logger.events.ClanHomeCreateEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanHomeDeleteEvent("Config.Logger.events.ClanHomeDeleteEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanBannerChangeEvent("Config.Logger.events.ClanBannerChangeEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanAllyInviteEvent("Config.Logger.events.ClanAllyInviteEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanRivalInviteEvent("Config.Logger.events.ClanRivalInviteEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanPlayerBanEvent("Config.Logger.events.ClanPlayerBanEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanPlayerUnbanEvent("Config.Logger.events.ClanPlayerUnbanEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanFFChangeEvent("Config.Logger.events.ClanFFChangeEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanRegroupSendEvent("Config.Logger.events.ClanRegroupSendEvent", true, new String[0]),
    CLAN_LOGGER_events_ClanRewardsEvent("Config.Logger.events.ClanRewardsEvent", true, new String[0]),
    CONFIG_icon("Config.Icon", "", " "),
    CONFIG_icon_click_sound("Config.Icon.click_sound", "", new String[0]),
    CONFIG_icon_material("Config.Icon.material", "CLOCK", new String[0]),
    CONFIG_icon_name("Config.Icon.name", "", new String[0]),
    CONFIG_icon_texture("Config.Icon.texture", "", new String[0]),
    CONFIG_icon_lore("Config.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_glow("Config.Icon.glow", false, new String[0]),
    CONFIG_icon_slot("Config.Icon.slot", 1, new String[0]),
    CONFIG_icon_mimeslots("Config.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_icon_nbt_string("Config.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_nbt_integer("Config.Icon.model", 0, new String[0]),
    CONFIG_icon_left_click_action("Config.Icon.left_click_action", Arrays.asList("/{_clan} {_logger} {_view} -gui"), new String[0]),
    CONFIG_icon_right_click_action("Config.Icon.right_click_action", Arrays.asList("/{_clan} {_logger} {_view} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_edit("Config.Permissions.edit", "", new String[0]),
    CONFIG_permissions_edit_name("Config.Permissions.edit.name", "Mail-Edit", new String[0]),
    CONFIG_permissions_edit_default_value("Config.Permissions.edit.default_value", true, new String[0]),
    CONFIG_permissions_edit_applicable_roles("Config.Permissions.edit.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    CONFIG_permissions_view("Config.Permissions.view", "", new String[0]),
    CONFIG_permissions_view_name("Config.Permissions.view.name", "Mail-View", new String[0]),
    CONFIG_permissions_view_default_value("Config.Permissions.view.default_value", true, new String[0]),
    CONFIG_permissions_view_applicable_roles("Config.Permissions.view.applicable_roles", Arrays.asList("member", "moderator", "admin"), new String[0]),
    STORAGE("Storage", "", " ", "# MAIL STORAGE"),
    STORAGE_type("Storage.type", "sqlite", "#yaml/mysql/sqlite (It is highly recommended to use mysql for better performance!!!)"),
    STORAGE_mysql("Storage.mysql", "", new String[0]),
    STORAGE_mysql_host("Storage.mysql.host", "localhost", new String[0]),
    STORAGE_mysql_port("Storage.mysql.port", 3306, new String[0]),
    STORAGE_mysql_base("Storage.mysql.base", "YOUR-BASE-PRE-CREATED", new String[0]),
    STORAGE_mysql_ssl("Storage.mysql.useSSL", false, "#SSL is only valid for MYSQL, most servers are not necessary to use it as true."),
    STORAGE_mysql_user("Storage.user", "root", "# Used for Mysql mandatory and optional for H2 and Sqlite (default: root)"),
    STORAGE_mysql_pass("Storage.pass", "", "# Used for Mysql mandatory and optional for H2 and Sqlite (default is empty)"),
    STORAGE_databases("Storage.databases", "", new String[0]),
    STORAGE_databases_mail_table("Storage.databases.logger_table", "uclans-logger", new String[0]),
    STORAGE_datasource("Storage.datasource", " ", "# https://github.com/brettwooldridge/HikariCP#popular-datasource-class-names"),
    STORAGE_datasource_mysql("Storage.datasource.mysql", "jdbc:mysql://", new String[0]),
    STORAGE_datasource_mysql_class("Storage.datasource.mysql_class", "", new String[0]),
    STORAGE_datasource_sqlite("Storage.datasource.sqlite", "jdbc:sqlite:", new String[0]),
    STORAGE_datasource_sqlite_class("Storage.datasource.sqlite_class", "org.sqlite.JDBC", new String[0]);

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

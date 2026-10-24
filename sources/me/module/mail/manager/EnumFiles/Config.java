package me.module.mail.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CLAN_MAIL("Config.Mail", "", " "),
    CLAN_MAIL_enabled("Config.Mail.enabled", true, new String[0]),
    CLAN_MAIL_enable_colors("Config.Mail.enable_colors", true, new String[0]),
    CLAN_MAIL_enabled_for_all_clans("Config.Mail.enabled_for_all_clans", false, new String[0]),
    CLAN_MAIL_time_expires("Config.Mail.time_expires", 1440, "# in minutes, 1440 minutes = 1 day"),
    CLAN_MAIL_max_storage("Config.Mail.max_storage", 70, new String[0]),
    CLAN_MAIL_max_unread("Config.Mail.max_unread", 14, new String[0]),
    CLAN_MAIL_max_chars("Config.Mail.max_chars", 50, new String[0]),
    CLAN_MAIL_min_chars("Config.Mail.min_chars", 1, new String[0]),
    CONFIG_icon("Config.Icon", "", " "),
    CONFIG_icon_click_sound("Config.Icon.click_sound", "", new String[0]),
    CONFIG_icon_material("Config.Icon.material", "BOOKSHELF", new String[0]),
    CONFIG_icon_name("Config.Icon.name", "", new String[0]),
    CONFIG_icon_texture("Config.Icon.texture", "", new String[0]),
    CONFIG_icon_lore("Config.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_glow("Config.Icon.glow", false, new String[0]),
    CONFIG_icon_slot("Config.Icon.slot", 2, new String[0]),
    CONFIG_icon_mimeslots("Config.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_icon_nbt_string("Config.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_icon_nbt_integer("Config.Icon.model", 0, new String[0]),
    CONFIG_icon_left_click_action("Config.Icon.left_click_action", Arrays.asList("/{_clan} {_mail} {_read} -gui"), new String[0]),
    CONFIG_icon_right_click_action("Config.Icon.right_click_action", Arrays.asList("/{_clan} {_mail} {_read} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_read("Config.Permissions.read", "", new String[0]),
    CONFIG_permissions_read_name("Config.Permissions.read.name", "Mail-Read", new String[0]),
    CONFIG_permissions_read_default_value("Config.Permissions.read.default_value", true, new String[0]),
    CONFIG_permissions_read_applicable_roles("Config.Permissions.read.applicable_roles", Arrays.asList("member", "moderator", "admin"), new String[0]),
    CONFIG_permissions_send("Config.Permissions.send", "", new String[0]),
    CONFIG_permissions_send_name("Config.Permissions.send.name", "Mail-Send", new String[0]),
    CONFIG_permissions_send_default_value("Config.Permissions.send.default_value", true, new String[0]),
    CONFIG_permissions_send_applicable_roles("Config.Permissions.send.applicable_roles", Arrays.asList("member", "moderator", "admin"), new String[0]),
    CONFIG_permissions_clear("Config.Permissions.clear", "", new String[0]),
    CONFIG_permissions_clear_name("Config.Permissions.clear.name", "Mail-Clear", new String[0]),
    CONFIG_permissions_clear_default_value("Config.Permissions.clear.default_value", false, new String[0]),
    CONFIG_permissions_clear_applicable_roles("Config.Permissions.clear.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    CONFIG_permissions_edit("Config.Permissions.edit", "", new String[0]),
    CONFIG_permissions_edit_name("Config.Permissions.edit.name", "Mail-Edit", new String[0]),
    CONFIG_permissions_edit_default_value("Config.Permissions.edit.default_value", false, new String[0]),
    CONFIG_permissions_edit_applicable_roles("Config.Permissions.edit.applicable_roles", Arrays.asList("moderator", "admin"), new String[0]),
    CONFIG_LOGGER("Config.logger", "", " "),
    CONFIG_LOGGER_enable_colors("Config.logger.enable_colors", true, new String[0]),
    CONFIG_LOGGER_plugin_material("Config.logger.plugin_material", "BOOKSHELF", new String[0]),
    CONFIG_LOGGER_plugin_namel("Config.logger.plugin_name", "Mail", new String[0]),
    CONFIG_LOGGER_events("Config.logger.events", "", new String[0]),
    CONFIG_LOGGER_events_ClanPlayerInviteReceive("Config.logger.events.ClanBankAddEvent", true, new String[0]),
    CONFIG_LOGGER_events_ClanPlayerRoleChangeEvent("Config.logger.events.ClanBankWithdrawEvent", true, new String[0]),
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
    STORAGE_databases_mail_table("Storage.databases.mail_table", "uclans-mail", new String[0]),
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

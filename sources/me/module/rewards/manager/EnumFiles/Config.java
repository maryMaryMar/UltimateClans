package me.module.rewards.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CONFIG_rewards_icon("Config.Rewards.Icon", "", " "),
    CONFIG_rewards_icon_click_sound("Config.Rewards.Icon.click_sound", "", new String[0]),
    CONFIG_rewards_icon_material("Config.Rewards.Icon.material", "HOPPER_MINECART", new String[0]),
    CONFIG_rewards_icon_name("Config.Rewards.Icon.name", "", new String[0]),
    CONFIG_rewards_icon_texture("Config.Rewards.Icon.texture", "", new String[0]),
    CONFIG_rewards_icon_lore("Config.Rewards.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_rewards_icon_glow("Config.Rewards.Icon.glow", false, new String[0]),
    CONFIG_rewards_icon_slot("Config.Rewards.Icon.slot", 38, new String[0]),
    CONFIG_rewards_icon_page("Config.Rewards.Icon.page", "clan_home", new String[0]),
    CONFIG_rewards_icon_mimeslots("Config.Rewards.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_rewards_icon_nbt_string("Config.Rewards.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_rewards_icon_nbt_integer("Config.Rewards.Icon.model", 0, new String[0]),
    CONFIG_rewards_icon_left_click_action("Config.Rewards.Icon.left_click_action", Arrays.asList("/{_clan} {_rewards} {_list} -gui"), new String[0]),
    CONFIG_rewards_icon_right_click_action("Config.Rewards.Icon.right_click_action", Arrays.asList("/{_clan} {_rewards} {_list} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_use("Config.Permissions.use", "", new String[0]),
    CONFIG_permissions_use_name("Config.Permissions.use.name", "Rewards-Use", new String[0]),
    CONFIG_permissions_use_default_value("Config.Permissions.use.default_value", true, new String[0]),
    CONFIG_permissions_use_applicable_roles("Config.Permissions.use.applicable_roles", Arrays.asList("member", "moderator", "admin"), new String[0]),
    STORAGE("Storage", "", " ", "# REWARDS STORAGE"),
    STORAGE_type("Storage.type", "sqlite", "#yaml/mysql/sqlite (It is highly recommended to use mysql for better performance!!!)"),
    STORAGE_mysql("Storage.mysql", "", new String[0]),
    STORAGE_mysql_host("Storage.mysql.host", "localhost", new String[0]),
    STORAGE_mysql_port("Storage.mysql.port", 3306, new String[0]),
    STORAGE_mysql_base("Storage.mysql.base", "YOUR-BASE-PRE-CREATED", new String[0]),
    STORAGE_mysql_ssl("Storage.mysql.useSSL", false, "#SSL is only valid for MYSQL, most servers are not necessary to use it as true."),
    STORAGE_mysql_user("Storage.user", "root", "# Used for Mysql mandatory and optional for H2 and Sqlite (default: root)"),
    STORAGE_mysql_pass("Storage.pass", "", "# Used for Mysql mandatory and optional for H2 and Sqlite (default is empty)"),
    STORAGE_databases("Storage.databases", "", new String[0]),
    STORAGE_databases_rewards_table("Storage.databases.rewards_table", "uclans-rewards", new String[0]),
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

package me.ulrich.clans.manager.EnumFiles;

import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/EnumFiles/Storage.class */
public enum Storage implements ConfigurationEnum {
    STORAGE("Storage", "", new String[0]),
    STORAGE_type("Storage.type", "sqlite", "# sqlite/mysql/yaml", "# For better performance it is recommended to use MYSQL as storage."),
    STORAGE_mysql_host("Storage.mysql.host", "localhost", "# Only mysql"),
    STORAGE_mysql_port("Storage.mysql.port", 3306, "# Only mysql"),
    STORAGE_mysql_base("Storage.mysql.base", "YOUR-BASE-PRE-CREATED", "# Only mysql"),
    STORAGE_mysql_ssl("Storage.mysql.useSSL", false, "#SSL is only valid for MYSQL, most servers are not necessary to use it as true."),
    STORAGE_mysql_args("Storage.mysql.args", "?useUnicode=true&characterEncoding=UTF-8", new String[0]),
    STORAGE_mysql_maximumPoolSize("Storage.mysql.maximumPoolSize", 10, "# maximum size that the (mysql) pool is allowed to reach. (https://github.com/brettwooldridge/HikariCP/wiki/About-Pool-Sizing)"),
    STORAGE_mysql_user("Storage.user", "root", "# Used for Mysql mandatory and optional for H2 and Sqlite (default: root)"),
    STORAGE_mysql_pass("Storage.pass", "", "# Used for Mysql mandatory and optional for H2 and Sqlite (default is empty)"),
    STORAGE_databases("Storage.databases", "", new String[0]),
    STORAGE_databases_clan_table("Storage.databases.clan_table", "uclans-clans", new String[0]),
    STORAGE_databases_player_table("Storage.databases.player_table", "uclans-players", new String[0]),
    STORAGE_databases_invite_table("Storage.databases.invite_table", "uclans-invite", new String[0]),
    STORAGE_databases_moderation_table("Storage.databases.moderation_table", "uclans-moderation", new String[0]),
    STORAGE_datasource("Storage.datasource", " ", "# https://github.com/brettwooldridge/HikariCP#popular-datasource-class-names"),
    STORAGE_datasource_mysql("Storage.datasource.mysql", "jdbc:mysql://", new String[0]),
    STORAGE_datasource_mysql_class("Storage.datasource.mysql_class", "", new String[0]),
    STORAGE_datasource_sqlite("Storage.datasource.sqlite", "jdbc:sqlite:", new String[0]),
    STORAGE_datasource_sqlite_class("Storage.datasource.sqlite_class", "org.sqlite.JDBC", new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Storage(String str, Object obj, String... strArr) {
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

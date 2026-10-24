package me.module.logger.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/c.class */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f127a;
    private ClanEnum.ClanStorage b = ClanEnum.ClanStorage.SQLITE;
    private static byte[] __aes_key_n8BaO26P = {(byte) 243, (byte) 120, (byte) 62, (byte) 83, (byte) 60, (byte) 22, (byte) 157, (byte) 163, (byte) 87, (byte) 120, (byte) 73, (byte) 52, (byte) 73, (byte) 166, (byte) 213, (byte) 10, (byte) 123, (byte) 8, (byte) 44, (byte) 123, (byte) 187, (byte) 128, (byte) 133, (byte) 58, (byte) 152, (byte) 44, (byte) 222, (byte) 127, (byte) 200, (byte) 80, (byte) 255, (byte) 50};
    private static byte[] __aes_iv_mYjscKXs = {(byte) 61, (byte) 198, (byte) 236, (byte) 225, (byte) 116, (byte) 250, (byte) 11, (byte) 157, (byte) 165, (byte) 150, (byte) 192, (byte) 234, (byte) 139, (byte) 101, (byte) 213, (byte) 18};
    private static String __s_cache_lDfGLXQg_0;
    private static String __s_cache_ee2UjijY_1;
    private static String __s_cache_t6hUYbWO_2;
    private static String __s_cache_2L66L07O_3;
    private static String __s_cache_aX2K01IJ_4;
    private static String __s_cache_PzSdAlNQ_5;
    private static String __s_cache_8FmXOdZR_6;
    private static String __s_cache_F3PgRFxK_7;
    private static String __s_cache_DviHNY2d_8;
    private static String __s_cache_7xTlxqZf_9;
    private static String __s_cache_TUk4mk9L_10;
    private static String __s_cache_LtQuovEp_11;
    private static String __s_cache_aWeBuBbV_12;
    private static String __s_cache_BE9o5mUT_13;

    public c() {
        a();
        e();
    }

    private void e() {
        String string = Logger.getModuleCore().c().i().getString("Storage.type");
        ClanEnum.ClanStorage clanStorageValueOf = ClanEnum.ClanStorage.SQLITE;
        try {
            clanStorageValueOf = ClanEnum.ClanStorage.valueOf(string.toUpperCase());
        } catch (Exception e) {
            Logger.a().getLogger().info(" - Invalid type found in configuration (" + string.toUpperCase() + "), using default...");
        }
        this.b = clanStorageValueOf;
        String str = String.valueOf(Logger.getModuleCore().getExtensionDataFolder()) + "/storage/";
        String string2 = Logger.getModuleCore().c().i().getString("Storage.mysql.host");
        String string3 = Logger.getModuleCore().c().i().getString("Storage.user");
        String string4 = Logger.getModuleCore().c().i().getString("Storage.pass");
        int i = Logger.getModuleCore().c().i().getInt("Storage.mysql.port");
        String string5 = Logger.getModuleCore().c().i().getString("Storage.mysql.base");
        boolean z = Logger.getModuleCore().c().i().getBoolean("Storage.mysql.useSSL");
        Logger.getModuleCore().c().a(str);
        String string6 = Logger.getModuleCore().c().i().getString("Storage.datasource.mysql");
        String string7 = Logger.getModuleCore().c().i().getString("Storage.datasource.sqlite");
        String string8 = Logger.getModuleCore().c().i().getString("Storage.datasource.mysql_class");
        String string9 = Logger.getModuleCore().c().i().getString("Storage.datasource.sqlite_class");
        switch (clanStorageValueOf) {
            case MYSQL:
                this.f127a = new b(ClanEnum.ClanStorage.MYSQL, string8, string6 + string2 + ":" + i + "/" + string5 + "?useSSL=" + String.valueOf(z), string3, string4);
                break;
            case SQLITE:
                String str2 = str + "/sqlite/";
                if (Logger.getModuleCore().c().a(str2)) {
                    this.f127a = new b(ClanEnum.ClanStorage.SQLITE, string9, string7 + str2 + "logger.db", "", "");
                }
                break;
        }
        f();
    }

    private void f() {
        if (this.b.equals(ClanEnum.ClanStorage.YAML) || b().c() == null) {
            return;
        }
        String string = Logger.getModuleCore().c().i().getString("Storage.databases.logger_table");
        if (!b().d()) {
            Logger.a().getLogger().warning("The database is not connected, check the fields...");
            return;
        }
        String str = "CREATE TABLE IF NOT EXISTS `" + string + "` (`id` VARCHAR(120) NOT NULL, `clan_id` VARCHAR(36) DEFAULT NULL, `text` TEXT, `plugin` VARCHAR(36) NOT NULL, `material` VARCHAR(36) NOT NULL, `date` BIGINT(11) DEFAULT NULL , UNIQUE(id), PRIMARY KEY (id));";
        try {
            Connection connectionC = b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    preparedStatementPrepareStatement.execute();
                    Logger.getModuleCore().b().info(" - Logger database [OK]");
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionC != null) {
                    try {
                        connectionC.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        if (this.f127a != null) {
            this.f127a.b();
        }
    }

    public b b() {
        return this.f127a;
    }

    public ClanEnum.ClanStorage c() {
        return this.b;
    }

    public boolean d() {
        try {
            java.sql.Connection conn = b().c();
            if (conn == null) {
                return false;
            }
            conn.close();
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public void a(Consumer<ResultSet> consumer, String str) {
        try {
            Connection connectionC = b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    consumer.accept(preparedStatementPrepareStatement.executeQuery());
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionC != null) {
                    try {
                        connectionC.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(Consumer<ResultSet> consumer, String str) {
        try {
            Connection connectionC = b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    consumer.accept(preparedStatementPrepareStatement.executeQuery());
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionC != null) {
                    try {
                        connectionC.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_37() {
        return "Storage.type";
    }

    private static String __unused_38() {
        return "Storage.mysql.host";
    }

    private static String __unused_39() {
        return "Storage.user";
    }

    private static String __unused_40() {
        return "Storage.pass";
    }

    private static String __unused_41() {
        return "Storage.mysql.port";
    }

    private static String __unused_42() {
        return "Storage.mysql.base";
    }

    private static String __unused_43() {
        return "Storage.mysql.useSSL";
    }

    private static String __unused_44() {
        return "Storage.datasource.mysql";
    }

    private static String __unused_45() {
        return "Storage.datasource.sqlite";
    }

    private static String __unused_46() {
        return "Storage.datasource.mysql_class";
    }

    private static String __unused_47() {
        return "Storage.datasource.sqlite_class";
    }

    private static String __unused_48() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_49() {
        return "The database is not connected, check the fields...";
    }

    private static String __unused_50() {
        return " - Logger database [OK]";
    }
}

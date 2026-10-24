package me.module.logger.manager;

import java.sql.Connection;
import java.sql.SQLException;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.HikariDataSource;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/b.class */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HikariDataSource f125a;
    private static byte[] __aes_key_H3aooGZp = {(byte) 105, (byte) 55, (byte) 69, (byte) 26, (byte) 247, (byte) 240, (byte) 141, (byte) 123, (byte) 32, (byte) 42, (byte) 29, (byte) 194, (byte) 138, (byte) 221, (byte) 227, (byte) 3, (byte) 195, (byte) 99, (byte) 229, (byte) 139, (byte) 167, (byte) 92, (byte) 221, (byte) 255, (byte) 250, (byte) 176, (byte) 113, (byte) 104, (byte) 238, (byte) 248, (byte) 135, (byte) 240};
    private static byte[] __aes_iv_HvkekbvA = {(byte) 192, (byte) 125, (byte) 155, (byte) 234, (byte) 214, (byte) 196, (byte) 141, (byte) 237, (byte) 111, (byte) 73, (byte) 108, (byte) 217, (byte) 191, (byte) 212, (byte) 104, (byte) 168};
    private static String __s_cache_bTQFltCz_0;
    private static String __s_cache_lsKsQXSC_1;
    private static String __s_cache_ArB4tHew_2;
    private static String __s_cache_DcmmpfpH_3;
    private static String __s_cache_Xn7RiS2C_4;
    private static String __s_cache_byeW5wBK_5;
    private static String __s_cache_iaincxOO_6;
    private static String __s_cache_ROvwuq4t_7;

    public b(ClanEnum.ClanStorage clanStorage, String str, String str2, String str3, String str4) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(str3);
        hikariConfig.setPassword(str4);
        if (!str.isEmpty()) {
            hikariConfig.setDriverClassName(str);
        }
        switch (clanStorage) {
            case MYSQL:
                hikariConfig.setJdbcUrl(str2);
                hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
                hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
                hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
                break;
            case SQLITE:
                hikariConfig.setJdbcUrl(str2);
                hikariConfig.setConnectionTestQuery("SELECT 1;");
                break;
        }
        hikariConfig.setConnectionTimeout(300000L);
        try {
            this.f125a = new HikariDataSource(hikariConfig);
        } catch (Exception e) {
            Logger.a().getLogger().warning(" - Connection error: " + e.getMessage());
        }
    }

    public void a() {
        d();
    }

    public void b() {
        if (this.f125a == null) {
            Logger.a().getLogger().info(" - Connection is null...");
        } else {
            this.f125a.close();
        }
    }

    public Connection c() {
        try {
            if (this.f125a != null) {
                return this.f125a.getConnection();
            }
            return null;
        } catch (SQLException e) {
            Logger.a().getLogger().warning(" - Connection error: " + e.getMessage());
            return null;
        }
    }

    public boolean d() {
        try {
            if (this.f125a != null) {
                this.f125a.getConnection();
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static String __unused_29() {
        return "cachePrepStmts";
    }

    private static String __unused_30() {
        return "true";
    }

    private static String __unused_31() {
        return "prepStmtCacheSize";
    }

    private static String __unused_32() {
        return "250";
    }

    private static String __unused_33() {
        return "prepStmtCacheSqlLimit";
    }

    private static String __unused_34() {
        return "2048";
    }

    private static String __unused_35() {
        return "SELECT 1;";
    }

    private static String __unused_36() {
        return " - Connection is null...";
    }
}

package me.module.rewards.manager;

import java.sql.Connection;
import java.sql.SQLException;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.HikariDataSource;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/b.class */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HikariDataSource f152a;
    private static byte[] __aes_key_Gjq25Aoa = {(byte) 210, (byte) 166, (byte) 203, (byte) 41, (byte) 220, (byte) 219, (byte) 246, (byte) 190, (byte) 180, (byte) 176, (byte) 146, (byte) 156, (byte) 68, (byte) 21, (byte) 148, (byte) 185, (byte) 237, (byte) 80, (byte) 117, (byte) 58, (byte) 246, (byte) 103, (byte) 203, (byte) 122, (byte) 73, (byte) 220, (byte) 221, (byte) 80, (byte) 79, (byte) 70, (byte) 199, (byte) 208};
    private static byte[] __aes_iv_93Q6VBKQ = {(byte) 113, (byte) 29, (byte) 206, (byte) 87, (byte) 87, (byte) 123, (byte) 223, (byte) 225, (byte) 164, (byte) 147, (byte) 207, (byte) 74, (byte) 153, (byte) 231, (byte) 178, (byte) 42};
    private static String __s_cache_DI2vrBRC_0;
    private static String __s_cache_Tt1aLiqC_1;
    private static String __s_cache_JqDY2Ciw_2;
    private static String __s_cache_OivmCRtW_3;
    private static String __s_cache_JSHkmiKr_4;
    private static String __s_cache_YVW2AYjs_5;
    private static String __s_cache_QORSHH4s_6;
    private static String __s_cache_2X3aNjHh_7;

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
            this.f152a = new HikariDataSource(hikariConfig);
        } catch (Exception e) {
            Rewards.a().getLogger().warning(" - Connection error: " + e.getMessage());
        }
    }

    public void a() {
        d();
    }

    public void b() {
        if (this.f152a == null) {
            Rewards.a().getLogger().info(" - Connection is null...");
        } else {
            this.f152a.close();
        }
    }

    public Connection c() {
        try {
            if (this.f152a != null) {
                return this.f152a.getConnection();
            }
            return null;
        } catch (SQLException e) {
            Rewards.a().getLogger().warning(" - Connection error: " + e.getMessage());
            return null;
        }
    }

    public boolean d() {
        try {
            if (this.f152a != null) {
                this.f152a.getConnection();
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static String __unused_1326() {
        return "cachePrepStmts";
    }

    private static String __unused_1327() {
        return "true";
    }

    private static String __unused_1328() {
        return "prepStmtCacheSize";
    }

    private static String __unused_1329() {
        return "250";
    }

    private static String __unused_1330() {
        return "prepStmtCacheSqlLimit";
    }

    private static String __unused_1331() {
        return "2048";
    }

    private static String __unused_1332() {
        return "SELECT 1;";
    }

    private static String __unused_1333() {
        return " - Connection is null...";
    }
}

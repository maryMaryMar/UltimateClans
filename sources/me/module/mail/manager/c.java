package me.module.mail.manager;

import java.sql.Connection;
import java.sql.SQLException;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.HikariDataSource;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/c.class */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HikariDataSource f135a;
    private static byte[] __aes_key_6zyscyrr = {(byte) 133, (byte) 211, (byte) 147, (byte) 124, (byte) 33, (byte) 223, (byte) 3, (byte) 10, (byte) 103, (byte) 55, (byte) 90, (byte) 126, (byte) 97, (byte) 192, (byte) 45, (byte) 185, (byte) 184, (byte) 189, (byte) 9, (byte) 93, (byte) 210, (byte) 60, (byte) 77, (byte) 158, (byte) 198, (byte) 60, (byte) 18, (byte) 245, (byte) 206, (byte) 2, (byte) 175, (byte) 61};
    private static byte[] __aes_iv_REBNFxGp = {(byte) 109, (byte) 92, (byte) 208, (byte) 146, (byte) 124, (byte) 85, (byte) 57, (byte) 121, (byte) 119, (byte) 161, (byte) 162, (byte) 201, (byte) 144, (byte) 46, (byte) 245, (byte) 162};
    private static String __s_cache_4n12cTxE_0;
    private static String __s_cache_eduIrXAr_1;
    private static String __s_cache_d1FV4ENC_2;
    private static String __s_cache_V2EqMw5Q_3;
    private static String __s_cache_Q7xrDpTn_4;
    private static String __s_cache_L1ZcMtaz_5;
    private static String __s_cache_JT0YyjLH_6;
    private static String __s_cache_k4XIfmP7_7;

    public c(ClanEnum.ClanStorage clanStorage, String str, String str2, String str3, String str4) {
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
            this.f135a = new HikariDataSource(hikariConfig);
        } catch (Exception e) {
            Mail.a().getLogger().warning(" - Connection error: " + e.getMessage());
        }
    }

    public void a() {
        d();
    }

    public void b() {
        if (this.f135a == null) {
            Mail.a().getLogger().info(" - Connection is null...");
        } else {
            this.f135a.close();
        }
    }

    public Connection c() {
        try {
            if (this.f135a != null) {
                return this.f135a.getConnection();
            }
            return null;
        } catch (SQLException e) {
            Mail.a().getLogger().warning(" - Connection error: " + e.getMessage());
            return null;
        }
    }

    public boolean d() {
        try {
            if (this.f135a != null) {
                this.f135a.getConnection();
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static String __unused_635() {
        return "cachePrepStmts";
    }

    private static String __unused_636() {
        return "true";
    }

    private static String __unused_637() {
        return "prepStmtCacheSize";
    }

    private static String __unused_638() {
        return "250";
    }

    private static String __unused_639() {
        return "prepStmtCacheSqlLimit";
    }

    private static String __unused_640() {
        return "2048";
    }

    private static String __unused_641() {
        return "SELECT 1;";
    }

    private static String __unused_642() {
        return " - Connection is null...";
    }
}

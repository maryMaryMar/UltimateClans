package me.module.mail.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/d.class */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f137a;
    private ClanEnum.ClanStorage b = ClanEnum.ClanStorage.SQLITE;
    private static byte[] __aes_key_FUglmB88 = {(byte) 96, (byte) 156, (byte) 69, (byte) 172, (byte) 41, (byte) 57, (byte) 98, (byte) 206, (byte) 17, (byte) 248, (byte) 172, (byte) 100, (byte) 105, (byte) 240, (byte) 116, (byte) 124, (byte) 213, (byte) 67, (byte) 80, (byte) 51, (byte) 221, (byte) 140, (byte) 122, (byte) 215, (byte) 117, (byte) 14, (byte) 24, (byte) 88, (byte) 46, (byte) 190, (byte) 152, (byte) 94};
    private static byte[] __aes_iv_XflcWsHJ = {(byte) 61, (byte) 166, (byte) 95, (byte) 80, (byte) 227, (byte) 187, (byte) 130, (byte) 229, (byte) 132, (byte) 244, (byte) 46, (byte) 167, (byte) 59, (byte) 223, (byte) 154, (byte) 93};
    private static String __s_cache_16JmzUv2_0;
    private static String __s_cache_Pdy7m6wg_1;
    private static String __s_cache_OxiTk6Ra_2;
    private static String __s_cache_rjdvXIhr_3;
    private static String __s_cache_RP8GF83Y_4;
    private static String __s_cache_lZCs0yPj_5;
    private static String __s_cache_N7FgT2PA_6;
    private static String __s_cache_OCItraOn_7;
    private static String __s_cache_zFNOql6r_8;
    private static String __s_cache_fMr6nd2v_9;
    private static String __s_cache_AhehTyB0_10;
    private static String __s_cache_BKUSm4oh_11;
    private static String __s_cache_lFXAdlQV_12;
    private static String __s_cache_wjI9rWhY_13;

    public d() {
        a();
        e();
    }

    private void e() {
        String string = Mail.getModuleCore().c().j().getString("Storage.type");
        ClanEnum.ClanStorage clanStorageValueOf = ClanEnum.ClanStorage.SQLITE;
        try {
            clanStorageValueOf = ClanEnum.ClanStorage.valueOf(string.toUpperCase());
        } catch (Exception e) {
            Mail.a().getLogger().info(" - Invalid type found in configuration (" + string.toUpperCase() + "), using default...");
        }
        this.b = clanStorageValueOf;
        String str = String.valueOf(Mail.getModuleCore().getExtensionDataFolder()) + "/storage/";
        String string2 = Mail.getModuleCore().c().j().getString("Storage.mysql.host");
        String string3 = Mail.getModuleCore().c().j().getString("Storage.user");
        String string4 = Mail.getModuleCore().c().j().getString("Storage.pass");
        int i = Mail.getModuleCore().c().j().getInt("Storage.mysql.port");
        String string5 = Mail.getModuleCore().c().j().getString("Storage.mysql.base");
        boolean z = Mail.getModuleCore().c().j().getBoolean("Storage.mysql.useSSL");
        Mail.getModuleCore().c().a(str);
        String string6 = Mail.getModuleCore().c().j().getString("Storage.datasource.mysql");
        String string7 = Mail.getModuleCore().c().j().getString("Storage.datasource.sqlite");
        String string8 = Mail.getModuleCore().c().j().getString("Storage.datasource.mysql_class");
        String string9 = Mail.getModuleCore().c().j().getString("Storage.datasource.sqlite_class");
        switch (clanStorageValueOf) {
            case MYSQL:
                this.f137a = new c(ClanEnum.ClanStorage.MYSQL, string8, string6 + string2 + ":" + i + "/" + string5 + "?useSSL=" + String.valueOf(z), string3, string4);
                break;
            case SQLITE:
                String str2 = str + "/sqlite/";
                if (Mail.getModuleCore().c().a(str2)) {
                    this.f137a = new c(ClanEnum.ClanStorage.SQLITE, string9, string7 + str2 + "mail.db", "", "");
                }
                break;
        }
        f();
    }

    private void f() {
        if (this.b.equals(ClanEnum.ClanStorage.YAML) || b().c() == null) {
            return;
        }
        String string = Mail.getModuleCore().c().j().getString("Storage.databases.mail_table");
        if (!b().d()) {
            Mail.a().getLogger().warning("The database is not connected, check the fields...");
            return;
        }
        String str = "CREATE TABLE IF NOT EXISTS `" + string + "` (`id` VARCHAR(36) NOT NULL, `from` VARCHAR(36) DEFAULT NULL, `to` VARCHAR(36) NOT NULL, `sender` VARCHAR(36) NOT NULL, `text` TEXT, `date` BIGINT(11) DEFAULT NULL, `read_by` TEXT , UNIQUE(id), PRIMARY KEY (id));";
        try {
            Connection connectionC = b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    preparedStatementPrepareStatement.execute();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    int i = 0;
                    try {
                        Connection connectionC2 = b().c();
                        try {
                            PreparedStatement preparedStatementPrepareStatement2 = connectionC2.prepareStatement("ALTER TABLE `" + string + "` ADD `read_by` TEXT NULL");
                            try {
                                preparedStatementPrepareStatement2.execute();
                                i = 0 + 1;
                                Mail.a().getLogger().info(" - Mail database [OK]");
                                if (preparedStatementPrepareStatement2 != null) {
                                    preparedStatementPrepareStatement2.close();
                                }
                                if (connectionC2 != null) {
                                    connectionC2.close();
                                }
                                if (i > 0) {
                                    Mail.a().getLogger().warning(" + applied paths: " + String.valueOf(i));
                                }
                            } catch (Throwable th) {
                                if (preparedStatementPrepareStatement2 != null) {
                                    try {
                                        preparedStatementPrepareStatement2.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (connectionC2 != null) {
                                try {
                                    connectionC2.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Exception e) {
                    }
                } catch (Throwable th5) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                if (connectionC != null) {
                    try {
                        connectionC.close();
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                    }
                }
                throw th7;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        if (this.f137a != null) {
            this.f137a.b();
        }
    }

    public c b() {
        return this.f137a;
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

    private static String __unused_557() {
        return "Storage.type";
    }

    private static String __unused_558() {
        return "Storage.mysql.host";
    }

    private static String __unused_559() {
        return "Storage.user";
    }

    private static String __unused_560() {
        return "Storage.pass";
    }

    private static String __unused_561() {
        return "Storage.mysql.port";
    }

    private static String __unused_562() {
        return "Storage.mysql.base";
    }

    private static String __unused_563() {
        return "Storage.mysql.useSSL";
    }

    private static String __unused_564() {
        return "Storage.datasource.mysql";
    }

    private static String __unused_565() {
        return "Storage.datasource.sqlite";
    }

    private static String __unused_566() {
        return "Storage.datasource.mysql_class";
    }

    private static String __unused_567() {
        return "Storage.datasource.sqlite_class";
    }

    private static String __unused_568() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_569() {
        return "The database is not connected, check the fields...";
    }

    private static String __unused_570() {
        return " - Mail database [OK]";
    }
}

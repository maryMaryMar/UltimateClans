package me.module.rewards.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/c.class */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f154a;
    private ClanEnum.ClanStorage b = ClanEnum.ClanStorage.SQLITE;
    private static byte[] __aes_key_z1xckTmF = {(byte) 70, (byte) 213, (byte) 69, (byte) 238, (byte) 64, (byte) 51, (byte) 3, (byte) 48, (byte) 33, (byte) 144, (byte) 201, (byte) 229, (byte) 132, (byte) 161, (byte) 134, (byte) 238, (byte) 178, (byte) 44, (byte) 80, (byte) 156, (byte) 148, (byte) 225, (byte) 3, (byte) 35, (byte) 251, (byte) 161, (byte) 66, (byte) 115, (byte) 13, (byte) 76, (byte) 38, (byte) 103};
    private static byte[] __aes_iv_tPoOu89N = {(byte) 60, (byte) 217, (byte) 43, (byte) 138, (byte) 179, (byte) 244, (byte) 249, (byte) 92, (byte) 66, (byte) 45, (byte) 61, (byte) 225, (byte) 245, (byte) 252, (byte) 213, (byte) 22};
    private static String __s_cache_Z9zQi01q_0;
    private static String __s_cache_1UIiebx8_1;
    private static String __s_cache_8mbIIrgF_2;
    private static String __s_cache_zIYUQbpf_3;
    private static String __s_cache_ap2CmVB9_4;
    private static String __s_cache_zLofBclP_5;
    private static String __s_cache_xNw4dErJ_6;
    private static String __s_cache_FcuUGFOp_7;
    private static String __s_cache_50mk3I6V_8;
    private static String __s_cache_ppiWxY7k_9;
    private static String __s_cache_ZMjQmYC7_10;
    private static String __s_cache_KAkc8cMO_11;
    private static String __s_cache_HtrChfFA_12;

    public c() {
        a();
        e();
    }

    private void e() {
        String string = Rewards.getModuleCore().c().j().getString("Storage.type");
        ClanEnum.ClanStorage clanStorageValueOf = ClanEnum.ClanStorage.SQLITE;
        try {
            clanStorageValueOf = ClanEnum.ClanStorage.valueOf(string.toUpperCase());
        } catch (Exception e) {
            Rewards.a().getLogger().info(" - Invalid type found in configuration (" + string.toUpperCase() + "), using default...");
        }
        this.b = clanStorageValueOf;
        String str = String.valueOf(Rewards.getModuleCore().getExtensionDataFolder()) + "/storage/";
        String string2 = Rewards.getModuleCore().c().j().getString("Storage.mysql.host");
        String string3 = Rewards.getModuleCore().c().j().getString("Storage.user");
        String string4 = Rewards.getModuleCore().c().j().getString("Storage.pass");
        int i = Rewards.getModuleCore().c().j().getInt("Storage.mysql.port");
        String string5 = Rewards.getModuleCore().c().j().getString("Storage.mysql.base");
        boolean z = Rewards.getModuleCore().c().j().getBoolean("Storage.mysql.useSSL");
        Rewards.getModuleCore().c().a(str);
        String string6 = Rewards.getModuleCore().c().j().getString("Storage.datasource.mysql");
        String string7 = Rewards.getModuleCore().c().j().getString("Storage.datasource.sqlite");
        String string8 = Rewards.getModuleCore().c().j().getString("Storage.datasource.mysql_class");
        String string9 = Rewards.getModuleCore().c().j().getString("Storage.datasource.sqlite_class");
        switch (clanStorageValueOf) {
            case MYSQL:
                this.f154a = new b(ClanEnum.ClanStorage.MYSQL, string8, string6 + string2 + ":" + i + "/" + string5 + "?useSSL=" + String.valueOf(z), string3, string4);
                break;
            case SQLITE:
                String str2 = str + "/sqlite/";
                if (Rewards.getModuleCore().c().a(str2)) {
                    this.f154a = new b(ClanEnum.ClanStorage.SQLITE, string9, string7 + str2 + "rewards.db", "", "");
                }
                break;
        }
        f();
    }

    private void f() {
        if (this.b.equals(ClanEnum.ClanStorage.YAML) || b().c() == null) {
            return;
        }
        String string = Rewards.getModuleCore().c().j().getString("Storage.databases.rewards_table");
        if (!b().d()) {
            Rewards.a().getLogger().warning("The database is not connected, check the fields...");
            return;
        }
        String str = "CREATE TABLE IF NOT EXISTS `" + string + "` (`id` VARCHAR(36) NOT NULL, `clan_id` VARCHAR(36) DEFAULT NULL, `sender` VARCHAR(36) NOT NULL, `rewards` TEXT, `collected_by` TEXT, `description` TEXT, `complement` VARCHAR(36) NOT NULL, `icon` VARCHAR(36) NOT NULL, `date` BIGINT(11) DEFAULT NULL , UNIQUE(id), PRIMARY KEY (id));";
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
        if (this.f154a != null) {
            this.f154a.b();
        }
    }

    public b b() {
        return this.f154a;
    }

    public ClanEnum.ClanStorage c() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 8, instructions: 12 */
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

    private static String __unused_1334() {
        return "Storage.type";
    }

    private static String __unused_1335() {
        return "Storage.mysql.host";
    }

    private static String __unused_1336() {
        return "Storage.user";
    }

    private static String __unused_1337() {
        return "Storage.pass";
    }

    private static String __unused_1338() {
        return "Storage.mysql.port";
    }

    private static String __unused_1339() {
        return "Storage.mysql.base";
    }

    private static String __unused_1340() {
        return "Storage.mysql.useSSL";
    }

    private static String __unused_1341() {
        return "Storage.datasource.mysql";
    }

    private static String __unused_1342() {
        return "Storage.datasource.sqlite";
    }

    private static String __unused_1343() {
        return "Storage.datasource.mysql_class";
    }

    private static String __unused_1344() {
        return "Storage.datasource.sqlite_class";
    }

    private static String __unused_1345() {
        return "Storage.databases.rewards_table";
    }

    private static String __unused_1346() {
        return "The database is not connected, check the fields...";
    }
}

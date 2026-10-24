package me.module.multiserver.manager;

import java.util.Objects;
import me.module.multiserver.Multiserver;
import me.module.multiserver.library.redis.jedis.Jedis;
import me.module.multiserver.library.redis.jedis.JedisPool;
import me.module.multiserver.library.redis.jedis.JedisPoolConfig;
import me.module.multiserver.library.redis.jedis.JedisPubSub;
import me.module.multiserver.library.redis.jedis.Protocol;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/manager/c.class */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JedisPool f147a = null;
    private boolean b = false;
    private final a c = new a();
    private String d = Multiserver.getModuleCore().c().g().getString("Sync.high.redis.channel");
    private String e;
    private int f;
    private String g;
    private String h;
    private int i;
    private boolean j;
    private static byte[] __aes_key_ITs7MK4Y = {(byte) 7, (byte) 119, (byte) 114, (byte) 241, (byte) 29, (byte) 136, (byte) 32, (byte) 93, (byte) 22, (byte) 70, (byte) 15, (byte) 225, (byte) 6, (byte) 123, (byte) 161, (byte) 165, (byte) 216, (byte) 197, (byte) 212, (byte) 65, (byte) 150, (byte) 155, (byte) 60, (byte) 53, (byte) 151, (byte) 71, (byte) 191, (byte) 49, (byte) 118, (byte) 94, (byte) 82, (byte) 79};
    private static byte[] __aes_iv_n6pUjeyR = {(byte) 125, (byte) 56, (byte) 117, (byte) 50, (byte) 161, (byte) 55, (byte) 204, (byte) 244, (byte) 94, (byte) 165, (byte) 59, (byte) 160, (byte) 249, (byte) 198, (byte) 94, (byte) 6};
    private static String __s_cache_R53tL9Pa_0;
    private static String __s_cache_x0mCt9Sp_1;
    private static String __s_cache_NHwewmTO_2;
    private static String __s_cache_8UZTegEs_3;
    private static String __s_cache_sjyzPMV7_4;
    private static String __s_cache_HaOWrvck_5;
    private static String __s_cache_BtwsGVQY_6;
    private static String __s_cache_j1BiCQ2s_7;
    private static String __s_cache_FXBiGe2Q_8;
    private static String __s_cache_9r9PwtnV_9;
    private static String __s_cache_1UwmTbMb_10;
    private static String __s_cache_pb5mIfcm_11;
    private static String __s_cache_yYwgMjNx_12;
    private static String __s_cache_dBm1R1oo_13;
    private static String __s_cache_2fAqLC8A_14;
    private static String __s_cache_DcytVyTk_15;
    private static String __s_cache_DadCyopX_16;
    private static String __s_cache_y2ZjNw96_17;
    private static String __s_cache_nbAoN9D0_18;
    private static String __s_cache_hYFMzmnG_19;
    private static String __s_cache_4nzGHVGU_20;
    private static String __s_cache_vvgk6cMm_21;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/manager/c$a.class */
    private class a extends JedisPubSub {
        private static byte[] __aes_key_ChIm08P3 = {(byte) 104, (byte) 194, (byte) 43, (byte) 8, (byte) 143, (byte) 159, (byte) 13, (byte) 147, (byte) 9, (byte) 60, (byte) 44, (byte) 32, (byte) 10, (byte) 31, (byte) 51, (byte) 241, (byte) 156, (byte) 174, (byte) 246, (byte) 219, (byte) 178, (byte) 187, (byte) 18, (byte) 96, (byte) 119, (byte) 36, (byte) 97, (byte) 74, (byte) 160, (byte) 228, (byte) 12, (byte) 222};
        private static byte[] __aes_iv_L5FMaXHU = {(byte) 243, (byte) 203, (byte) 197, (byte) 7, (byte) 59, (byte) 138, (byte) 255, (byte) 139, (byte) 55, (byte) 197, (byte) 160, (byte) 174, (byte) 82, (byte) 78, (byte) 21, (byte) 151};
        private static String __s_cache_NF47pJ4N_0;

        private a() {
        }

        @Override // me.module.multiserver.library.redis.jedis.JedisPubSub
        public void onMessage(String str, String str2) {
            if (c.this.d().equals(str)) {
                a(str2);
            }
        }

        private void a(String str) {
            Multiserver.getModuleCore().d().runTaskLater(() -> {
                b.a(str);
            }, Multiserver.getModuleCore().c().g().getInt("Sync.high.sync_delay"));
        }

        @Override // me.module.multiserver.library.redis.jedis.JedisPubSub
        public void onSubscribe(String str, int i) {
            Multiserver.getModuleCore().b().info("Redis subscribed to channel '" + str + "'");
        }

        @Override // me.module.multiserver.library.redis.jedis.JedisPubSub
        public void onUnsubscribe(String str, int i) {
            Multiserver.getModuleCore().b().info("Redis unsubscribed from channel '" + str + "'");
        }

        private static String __unused_1796() {
        return "Sync.high.sync_delay";
    }
    }

    private void a(String str, int i, String str2, String str3, int i2, boolean z) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    if (str3 != null && str3.trim().isEmpty()) {
                        str3 = null;
                    }
                    if (str2 != null && str2.trim().isEmpty()) {
                        str2 = null;
                    }
                    this.e = str;
                    this.f = i;
                    this.g = str2;
                    this.h = str3;
                    this.i = i2;
                    this.j = z;
                    this.f147a = new JedisPool(new JedisPoolConfig(), str, i, 5000, str3, i2, z);
                    Multiserver.getModuleCore().b().info("Redis connected -> " + str + ":" + i + " | DB: " + i2 + (str2 != null ? " | User: " + str2 : "") + (str3 != null ? " | Auth: yes" : " | Auth: no") + (z ? " | SSL: enabled" : ""));
                    g();
                    return;
                }
            } catch (Exception e) {
                Multiserver.getModuleCore().b().severe("Failed to configure Redis: " + e.getMessage());
                e.printStackTrace();
                return;
            }
        }
        throw new IllegalArgumentException("The Redis host cannot be empty.");
    }

    private void g() {
        this.b = true;
        new Thread(() -> {
            h();
        }).start();
    }

    public void a() {
        try {
            FileConfiguration fileConfigurationG = Multiserver.getModuleCore().c().g();
            String string = fileConfigurationG.getString("Sync.high.redis.host");
            int i = fileConfigurationG.getInt("Sync.high.redis.port", Protocol.DEFAULT_PORT);
            String string2 = fileConfigurationG.getString("Sync.high.redis.user");
            String string3 = fileConfigurationG.getString("Sync.high.redis.password");
            int i2 = fileConfigurationG.getInt("Sync.high.redis.database", 0);
            boolean z = fileConfigurationG.getBoolean("Sync.high.redis.ssl", false);
            if (string == null || string.trim().isEmpty()) {
                throw new IllegalArgumentException("Redis host can't be null or empty in the configuration.");
            }
            a(string, i, string2, string3, i2, z);
        } catch (Exception e) {
            Multiserver.getModuleCore().b().severe("Failed to initialize Redis pool during startup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            this.b = false;
            this.c.unsubscribe();
            if (this.f147a != null) {
                this.f147a.destroy();
                this.f147a = null;
            }
        } catch (Exception | NoClassDefFoundError e) {
        }
    }

    public void c() {
        FileConfiguration fileConfigurationG = Multiserver.getModuleCore().c().g();
        String string = fileConfigurationG.getString("Sync.high.redis.host");
        int i = fileConfigurationG.getInt("Sync.high.redis.port", Protocol.DEFAULT_PORT);
        String string2 = fileConfigurationG.getString("Sync.high.redis.user");
        String string3 = fileConfigurationG.getString("Sync.high.redis.password");
        int i2 = fileConfigurationG.getInt("Sync.high.redis.database", 0);
        boolean z = fileConfigurationG.getBoolean("Sync.high.redis.ssl", false);
        String string4 = fileConfigurationG.getString("Sync.high.redis.channel");
        if (string == null || string.trim().isEmpty()) {
            b();
            throw new IllegalArgumentException("Redis host can't be null or empty in the configuration.");
        }
        if (this.f147a != null) {
            if (!((Objects.equals(this.e, string) && this.f == i && Objects.equals(this.g, string2) && Objects.equals(this.h, string3) && this.i == i2 && this.j == z) ? false : true)) {
                if (Objects.equals(d(), string4)) {
                    return;
                }
                this.b = false;
                this.c.unsubscribe();
                b(string4);
                g();
                return;
            }
            this.b = false;
            this.c.unsubscribe();
            this.f147a.destroy();
            this.f147a = null;
        }
        b(string4);
        a(string, i, string2, string3, i2, z);
    }

    public void a(String str) {
        if (this.f147a == null) {
            return;
        }
        try {
            Jedis resource = this.f147a.getResource();
            try {
                resource.publish(d(), str);
                if (resource != null) {
                    resource.close();
                }
            } catch (Throwable th) {
                if (resource != null) {
                    try {
                        resource.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
        }
    }

    private void h() {
        boolean z = false;
        while (this.b && !Thread.interrupted() && this.f147a != null && !this.f147a.isClosed()) {
            try {
                Jedis resource = this.f147a.getResource();
                if (z) {
                    try {
                        Multiserver.getModuleCore().b().info("Redis connection is alive again");
                    } catch (Throwable th) {
                        if (resource != null) {
                            try {
                                resource.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                resource.subscribe(this.c, d());
                if (resource != null) {
                    resource.close();
                }
            } catch (Throwable th3) {
                if (!this.b) {
                    return;
                }
                Multiserver.getModuleCore().b().info("Redis connection dropped, reconnection in 5 seconds...");
                try {
                    this.c.unsubscribe();
                } catch (Throwable th4) {
                }
                z = true;
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public String d() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public JedisPool e() {
        return this.f147a;
    }

    public boolean f() {
        return this.b;
    }

    private static String __unused_1797() {
        return "Sync.high.redis.channel";
    }

    private static String __unused_1798() {
        return "The Redis host cannot be empty.";
    }

    private static String __unused_1799() {
        return " | Auth: yes";
    }

    private static String __unused_1800() {
        return " | Auth: no";
    }

    private static String __unused_1801() {
        return " | SSL: enabled";
    }

    private static String __unused_1802() {
        return "Sync.high.redis.host";
    }

    private static String __unused_1803() {
        return "Sync.high.redis.port";
    }

    private static String __unused_1804() {
        return "Sync.high.redis.user";
    }

    private static String __unused_1805() {
        return "Sync.high.redis.password";
    }

    private static String __unused_1806() {
        return "Sync.high.redis.database";
    }

    private static String __unused_1807() {
        return "Sync.high.redis.ssl";
    }

    private static String __unused_1808() {
        return "Redis host can't be null or empty in the configuration.";
    }

    private static String __unused_1809() {
        return "Sync.high.redis.host";
    }

    private static String __unused_1810() {
        return "Sync.high.redis.port";
    }

    private static String __unused_1811() {
        return "Sync.high.redis.user";
    }

    private static String __unused_1812() {
        return "Sync.high.redis.password";
    }

    private static String __unused_1813() {
        return "Sync.high.redis.database";
    }

    private static String __unused_1814() {
        return "Sync.high.redis.ssl";
    }

    private static String __unused_1815() {
        return "Sync.high.redis.channel";
    }

    private static String __unused_1816() {
        return "Redis host can't be null or empty in the configuration.";
    }

    private static String __unused_1817() {
        return "Redis connection is alive again";
    }

    private static String __unused_1818() {
        return "Redis connection dropped, reconnection in 5 seconds...";
    }
}

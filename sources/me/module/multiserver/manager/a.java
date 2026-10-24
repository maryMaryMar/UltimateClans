package me.module.multiserver.manager;

import java.io.File;
import java.util.HashMap;
import me.module.multiserver.Multiserver;
import me.module.multiserver.manager.EnumFiles.Config;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/manager/a.class */
public class a {
    private static byte[] __aes_key_m5wkjym9 = {(byte) 213, (byte) 215, (byte) 251, (byte) 163, (byte) 96, (byte) 64, (byte) 139, (byte) 231, (byte) 223, (byte) 2, (byte) 3, (byte) 44, (byte) 189, (byte) 141, (byte) 211, (byte) 206, (byte) 106, (byte) 180, (byte) 161, (byte) 77, (byte) 162, (byte) 144, (byte) 188, (byte) 132, (byte) 172, (byte) 193, (byte) 251, (byte) 18, (byte) 10, (byte) 149, (byte) 26, (byte) 67};
    private static byte[] __aes_iv_Z0j6qsdl = {(byte) 70, (byte) 101, (byte) 49, (byte) 59, (byte) 241, (byte) 95, (byte) 29, (byte) 45, (byte) 198, (byte) 97, (byte) 75, (byte) 14, (byte) 7, (byte) 96, (byte) 126, (byte) 162};
    private static String __s_cache_hOLodwNc_0;
    private static String __s_cache_ses0iHDf_1;
    private static String __s_cache_IxhyVPtN_2;
    private static String __s_cache_H9mqru5X_3;
    private static String __s_cache_mqX6jddZ_4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f144a = null;
    private HashMap<String, Files> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();

    public a() {
        a();
        b();
    }

    public void a() {
        this.c.put("config", new EnumConfigurationBuilder(new File(Multiserver.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Multiserver.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.b.put("config", new Files(Multiserver.a(), Multiserver.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
    }

    public void c() {
    }

    public boolean a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    public void d() {
        e().clear();
        f().clear();
    }

    public HashMap<String, EnumConfiguration> e() {
        return this.c;
    }

    public HashMap<String, Files> f() {
        return this.b;
    }

    public FileConfiguration g() {
        return f().get("config").get();
    }

    public String h() {
        return this.f144a;
    }

    private static String __unused_1791() {
        return "config";
    }

    private static String __unused_1792() {
        return "config";
    }

    private static String __unused_1793() {
        return "config";
    }

    private static String __unused_1794() {
        return "config";
    }

    private static String __unused_1795() {
        return "config";
    }
}

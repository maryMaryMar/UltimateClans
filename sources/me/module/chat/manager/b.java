package me.module.chat.manager;

import java.io.File;
import java.util.HashMap;
import me.module.chat.Chat;
import me.module.chat.manager.EnumFiles.Commands;
import me.module.chat.manager.EnumFiles.Config;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/manager/b.class */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f104a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private static byte[] __aes_key_Iq6pxzix = {(byte) 46, (byte) 150, (byte) 26, (byte) 72, (byte) 247, (byte) 247, (byte) 16, (byte) 200, (byte) 9, (byte) 78, (byte) 157, (byte) 92, (byte) 123, (byte) 210, (byte) 124, (byte) 239, (byte) 62, (byte) 70, (byte) 174, (byte) 140, (byte) 22, (byte) 168, (byte) 220, (byte) 195, (byte) 218, (byte) 228, (byte) 153, (byte) 103, (byte) 123, (byte) 240, (byte) 176, (byte) 64};
    private static byte[] __aes_iv_1DQw4GzS = {(byte) 0, (byte) 134, (byte) 55, (byte) 133, (byte) 115, (byte) 188, (byte) 29, (byte) 129, (byte) 47, (byte) 134, (byte) 206, (byte) 230, (byte) 127, (byte) 239, (byte) 254, (byte) 92};
    private static String __s_cache_WV7bVrt5_0;
    private static String __s_cache_2nFJcv0T_1;
    private static String __s_cache_DrLUw5Eu_2;
    private static String __s_cache_3rUqRc2T_3;
    private static String __s_cache_Ch6Mqzhx_4;
    private static String __s_cache_qzJvJStA_5;
    private static String __s_cache_TIYUTvAP_6;
    private static String __s_cache_kzABf4wY_7;
    private static String __s_cache_yjYwXxEb_8;
    private static String __s_cache_cGPOlfNP_9;
    private static String __s_cache_wqNSSA6w_10;

    public b() {
        a();
        b();
    }

    public void a() {
        this.b.put("config", new EnumConfigurationBuilder(new File(Chat.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Chat.b().getLibAPI().getPluginTag()));
        this.b.put("commands", new EnumConfigurationBuilder(new File(Chat.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Chat.b().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f104a.put("config", new Files(Chat.b(), Chat.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f104a.put("commands", new Files(Chat.b(), Chat.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
    }

    public void c() {
        d().clear();
        e().clear();
    }

    public HashMap<String, EnumConfiguration> d() {
        return this.b;
    }

    public HashMap<String, Files> e() {
        return this.f104a;
    }

    public EnumConfiguration f() {
        return d().get("lang");
    }

    public FileConfiguration g() {
        return e().get("config").get();
    }

    public FileConfiguration h() {
        return e().get("commands").get();
    }

    private static String __unused_516() {
        return "config";
    }

    private static String __unused_517() {
        return "commands";
    }

    private static String __unused_518() {
        return "config";
    }

    private static String __unused_519() {
        return "config";
    }

    private static String __unused_520() {
        return "config";
    }

    private static String __unused_521() {
        return "commands";
    }

    private static String __unused_522() {
        return "commands";
    }

    private static String __unused_523() {
        return "commands";
    }

    private static String __unused_524() {
        return "lang";
    }

    private static String __unused_525() {
        return "config";
    }

    private static String __unused_526() {
        return "commands";
    }
}

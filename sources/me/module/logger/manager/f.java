package me.module.logger.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.logger.Logger;
import me.module.logger.manager.EnumFiles.Blank;
import me.module.logger.manager.EnumFiles.Commands;
import me.module.logger.manager.EnumFiles.Config;
import me.module.logger.manager.EnumFiles.Gui;
import me.module.logger.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/f.class */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f130a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_yB2uGYvq = {(byte) 42, (byte) 179, (byte) 161, (byte) 65, (byte) 111, (byte) 81, (byte) 2, (byte) 200, (byte) 215, (byte) 42, (byte) 105, (byte) 139, (byte) 91, (byte) 224, (byte) 4, (byte) 168, (byte) 134, (byte) 67, (byte) 203, (byte) 48, (byte) 110, (byte) 179, (byte) 136, (byte) 53, (byte) 162, (byte) 10, (byte) 68, (byte) 240, (byte) 194, (byte) 93, (byte) 25, (byte) 224};
    private static byte[] __aes_iv_IMjlujy7 = {(byte) 251, (byte) 138, (byte) 131, (byte) 104, (byte) 85, (byte) 80, (byte) 106, (byte) 134, (byte) 24, (byte) 28, (byte) 64, (byte) 99, (byte) 66, (byte) 159, (byte) 128, (byte) 82};
    private static String __s_cache_qkQy5BK8_0;
    private static String __s_cache_4YrY7h1q_1;
    private static String __s_cache_g9ujg9fR_2;
    private static String __s_cache_B3h4ZnUW_3;
    private static String __s_cache_TNOzCHDS_4;
    private static String __s_cache_RKlQhWOz_5;
    private static String __s_cache_qwHJmg8u_6;
    private static String __s_cache_vh8NFp7X_7;
    private static String __s_cache_6MISKza0_8;
    private static String __s_cache_J9HIqWD0_9;
    private static String __s_cache_mwyDsFtS_10;
    private static String __s_cache_kNp7WF6L_11;
    private static String __s_cache_AowJkD5F_12;
    private static String __s_cache_O3gjhkDI_13;
    private static String __s_cache_s5qqrGag_14;
    private static String __s_cache_Ts5q2CPE_15;
    private static String __s_cache_tU3Yh5hn_16;
    private static String __s_cache_AcFR9Fgu_17;
    private static String __s_cache_mc5z7hUV_18;
    private static String __s_cache_jNHHYW4a_19;
    private static String __s_cache_KSGz1Nna_20;
    private static String __s_cache_ClzW7XMm_21;
    private static String __s_cache_mTd15m19_22;
    private static String __s_cache_XT02CH9E_23;
    private static String __s_cache_Ke722kMw_24;
    private static String __s_cache_E6WOsZvB_25;

    public f() {
        a();
        b();
        m();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Logger.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Logger.a().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Logger.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Logger.a().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_clear_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_clear_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_clear_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_clear_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_view_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_view_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_view_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_logger_view_success, null);
        this.b.put("gui", new EnumConfigurationBuilder(new File(Logger.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Logger.a().getLibAPI().getPluginTag()));
        this.b.put("logger", new EnumConfigurationBuilder(new File(Logger.getModuleCore().getExtensionDataFolder(), "storage/yaml/logger.yml"), Blank.class).build(Logger.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f130a.put("config", new Files(Logger.a(), Logger.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f130a.put("commands", new Files(Logger.a(), Logger.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.f130a.put("gui", new Files(Logger.a(), Logger.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
        this.f130a.put("logger", new Files(Logger.a(), Logger.getModuleCore().getExtensionDataFolder(), "/storage/yaml/", "logger", "logger", "yml"));
    }

    private void m() {
        File[] fileArrListFiles;
        File file = new File(Logger.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Logger.a().getLibAPI().getPluginTag()));
            }
        }
    }

    public EnumConfiguration a(CommandSender commandSender) {
        return commandSender instanceof Player ? b(Optional.of(((Player) commandSender).getUniqueId())) : b(Optional.empty());
    }

    public EnumConfiguration c() {
        return d();
    }

    public EnumConfiguration d() {
        return b(Optional.empty());
    }

    public String a(Optional<UUID> optional) {
        String language = Logger.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = me.module.logger.a.a.EnumC0005a.f122a.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Logger.a().getPlayerAPI().getPlayerData(optional.get());
                if (playerData.isPresent() && playerData.get().getLang() != null && !playerData.get().getLang().trim().isEmpty()) {
                    lang = playerData.get().getLang();
                }
            } catch (Exception e) {
            }
        }
        String upperCase = lang.toUpperCase(Locale.ROOT);
        if (this.c.containsKey(upperCase)) {
            return upperCase;
        }
        String upperCase2 = language.toUpperCase(Locale.ROOT);
        if (this.c.containsKey(upperCase2)) {
            return upperCase2;
        }
        return this.c.containsKey("EN") ? "EN" : this.c.keySet().stream().findFirst().orElse(upperCase2);
    }

    public EnumConfiguration b(Optional<UUID> optional) {
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.get(a(optional));
    }

    public HashMap<String, EnumConfiguration> e() {
        return this.c;
    }

    public boolean a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    public void f() {
        g().clear();
        h().clear();
    }

    public HashMap<String, EnumConfiguration> g() {
        return this.b;
    }

    public HashMap<String, Files> h() {
        return this.f130a;
    }

    public FileConfiguration i() {
        return h().get("config").get();
    }

    public FileConfiguration j() {
        return h().get("commands").get();
    }

    public FileConfiguration k() {
        return h().get("logger").get();
    }

    public FileConfiguration l() {
        return h().get("gui").get();
    }

    private static String __unused_3() {
        return "config";
    }

    private static String __unused_4() {
        return "commands";
    }

    private static String __unused_5() {
        return "gui";
    }

    private static String __unused_6() {
        return "logger";
    }

    private static String __unused_7() {
        return "config";
    }

    private static String __unused_8() {
        return "config";
    }

    private static String __unused_9() {
        return "config";
    }

    private static String __unused_10() {
        return "commands";
    }

    private static String __unused_11() {
        return "commands";
    }

    private static String __unused_12() {
        return "commands";
    }

    private static String __unused_13() {
        return "gui";
    }

    private static String __unused_14() {
        return "gui";
    }

    private static String __unused_15() {
        return "gui";
    }

    private static String __unused_16() {
        return "/storage/yaml/";
    }

    private static String __unused_17() {
        return "logger";
    }

    private static String __unused_18() {
        return "logger";
    }

    private static String __unused_19() {
        return "logger";
    }

    private static String __unused_20() {
        return "language";
    }

    private static String __unused_21() {
        return "Lang_";
    }

    private static String __unused_22() {
        return "EN";
    }

    private static String __unused_23() {
        return "EN";
    }

    private static String __unused_24() {
        return "config";
    }

    private static String __unused_25() {
        return "commands";
    }

    private static String __unused_26() {
        return "logger";
    }

    private static String __unused_27() {
        return "gui";
    }

    private static String __unused_28() {
        return "Lang_";
    }
}

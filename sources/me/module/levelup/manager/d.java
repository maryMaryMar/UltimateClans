package me.module.levelup.manager;

import java.io.File;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.levelup.Levelup;
import me.module.levelup.manager.EnumFiles.Blank;
import me.module.levelup.manager.EnumFiles.Commands;
import me.module.levelup.manager.EnumFiles.Config;
import me.module.levelup.manager.EnumFiles.Gui;
import me.module.levelup.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/d.class */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f120a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_Zdzwxp4q = {(byte) 199, (byte) 89, (byte) 171, (byte) 70, (byte) 25, (byte) 244, (byte) 206, (byte) 15, (byte) 242, (byte) 160, (byte) 162, (byte) 16, (byte) 0, (byte) 240, (byte) 227, (byte) 55, (byte) 136, (byte) 73, (byte) 127, (byte) 53, (byte) 192, (byte) 0, (byte) 211, (byte) 16, (byte) 33, (byte) 158, (byte) 239, (byte) 171, (byte) 21, (byte) 237, (byte) 153, (byte) 86};
    private static byte[] __aes_iv_Tb08JG0p = {(byte) 169, (byte) 230, (byte) 155, (byte) 126, (byte) 77, (byte) 3, (byte) 112, (byte) 99, (byte) 88, (byte) 52, (byte) 88, (byte) 170, (byte) 199, (byte) 208, (byte) 222, (byte) 183};
    private static String __s_cache_yhm7vY5A_0;
    private static String __s_cache_q4uNcVR1_1;
    private static String __s_cache_SKwuRVLs_2;
    private static String __s_cache_gwCe6PZm_3;
    private static String __s_cache_1t4NdyXT_4;
    private static String __s_cache_OJPPVFuP_5;
    private static String __s_cache_m0csFvHt_6;
    private static String __s_cache_psfxvdpf_7;
    private static String __s_cache_RnTLar36_8;
    private static String __s_cache_LYuv0fgf_9;
    private static String __s_cache_4vkY4HQv_10;
    private static String __s_cache_2WYYxj16_11;
    private static String __s_cache_XOa9ngu5_12;
    private static String __s_cache_uWy07w5p_13;
    private static String __s_cache_6XiBEF16_14;
    private static String __s_cache_nApC8EwU_15;
    private static String __s_cache_9EF7yAIs_16;
    private static String __s_cache_asIFEdD2_17;
    private static String __s_cache_3691uY0f_18;
    private static String __s_cache_5Kng3i11_19;
    private static String __s_cache_IyrsvCZ6_20;
    private static String __s_cache_cWaH2giB_21;
    private static String __s_cache_5QZRFmHe_22;
    private static String __s_cache_qLuGzafn_23;
    private static String __s_cache_wKAj3djp_24;
    private static String __s_cache_SSzSXZxq_25;
    private static String __s_cache_cmYMCPlP_26;

    public d() {
        a();
        b();
        m();
    }

    public void a() {
        File file = new File(Levelup.getModuleCore().getExtensionDataFolder(), "config.yml");
        boolean zIsFile = file.isFile();
        EnumMap enumMap = new EnumMap(Config.class);
        if (zIsFile) {
            YamlConfiguration yamlConfigurationLoadConfiguration = YamlConfiguration.loadConfiguration(file);
            for (Config config : Config.values()) {
                if (config.getPath().startsWith("Level.requeriments.list.")) {
                    enumMap.put(config, Boolean.valueOf(yamlConfigurationLoadConfiguration.contains(config.getPath())));
                }
            }
        }
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(file, Config.class).build(Levelup.a().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        if (zIsFile) {
            enumMap.forEach((config2, bool) -> {
                if (bool.booleanValue()) {
                    return;
                }
                enumConfigurationBuild.set(config2, null);
            });
        }
        enumConfigurationBuild.set(Config.CONFIG_levelup_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_levelup_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Levelup.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Levelup.a().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_view_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_view_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_view_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_view_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_up_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_up_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_up_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_level_up_success, null);
        this.b.put("gui", new EnumConfigurationBuilder(new File(Levelup.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Levelup.a().getLibAPI().getPluginTag()));
        this.b.put("rewards", new EnumConfigurationBuilder(new File(Levelup.getModuleCore().getExtensionDataFolder(), "storage/yaml/rewards.yml"), Blank.class).build(Levelup.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f120a.put("config", new Files(Levelup.a(), Levelup.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f120a.put("commands", new Files(Levelup.a(), Levelup.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.f120a.put("gui", new Files(Levelup.a(), Levelup.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
        this.f120a.put("rewards", new Files(Levelup.a(), Levelup.getModuleCore().getExtensionDataFolder(), "/storage/yaml/", "rewards", "rewards", "yml"));
    }

    private void m() {
        File[] fileArrListFiles;
        File file = new File(Levelup.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Levelup.a().getLibAPI().getPluginTag()));
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
        String language = Levelup.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = me.module.levelup.a.a.EnumC0004a.f115a.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Levelup.a().getPlayerAPI().getPlayerData(optional.get());
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
        return this.f120a;
    }

    public FileConfiguration i() {
        return h().get("config").get();
    }

    public FileConfiguration j() {
        return h().get("commands").get();
    }

    public FileConfiguration k() {
        return h().get("rewards").get();
    }

    public FileConfiguration l() {
        return h().get("gui").get();
    }

    private static String __unused_890() {
        return "Level.requeriments.list.";
    }

    private static String __unused_891() {
        return "config";
    }

    private static String __unused_892() {
        return "commands";
    }

    private static String __unused_893() {
        return "gui";
    }

    private static String __unused_894() {
        return "rewards";
    }

    private static String __unused_895() {
        return "config";
    }

    private static String __unused_896() {
        return "config";
    }

    private static String __unused_897() {
        return "config";
    }

    private static String __unused_898() {
        return "commands";
    }

    private static String __unused_899() {
        return "commands";
    }

    private static String __unused_900() {
        return "commands";
    }

    private static String __unused_901() {
        return "gui";
    }

    private static String __unused_902() {
        return "gui";
    }

    private static String __unused_903() {
        return "gui";
    }

    private static String __unused_904() {
        return "/storage/yaml/";
    }

    private static String __unused_905() {
        return "rewards";
    }

    private static String __unused_906() {
        return "rewards";
    }

    private static String __unused_907() {
        return "rewards";
    }

    private static String __unused_908() {
        return "language";
    }

    private static String __unused_909() {
        return "Lang_";
    }

    private static String __unused_910() {
        return "EN";
    }

    private static String __unused_911() {
        return "EN";
    }

    private static String __unused_912() {
        return "config";
    }

    private static String __unused_913() {
        return "commands";
    }

    private static String __unused_914() {
        return "rewards";
    }

    private static String __unused_915() {
        return "gui";
    }

    private static String __unused_916() {
        return "Lang_";
    }
}

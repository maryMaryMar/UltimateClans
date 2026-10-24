package me.module.rewards.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.rewards.Rewards;
import me.module.rewards.data.ModuleEnum;
import me.module.rewards.manager.EnumFiles.Blank;
import me.module.rewards.manager.EnumFiles.Commands;
import me.module.rewards.manager.EnumFiles.Config;
import me.module.rewards.manager.EnumFiles.Gui;
import me.module.rewards.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/d.class */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f157a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_R5XNNrQP = {(byte) 93, (byte) 25, (byte) 239, (byte) 231, (byte) 125, (byte) 0, (byte) 11, (byte) 175, (byte) 18, (byte) 95, (byte) 61, (byte) 211, (byte) 215, (byte) 180, (byte) 126, (byte) 56, (byte) 37, (byte) 26, (byte) 112, (byte) 199, (byte) 152, (byte) 6, (byte) 92, (byte) 38, (byte) 56, (byte) 60, (byte) 227, (byte) 41, (byte) 85, (byte) 34, (byte) 90, (byte) 15};
    private static byte[] __aes_iv_njViv6i9 = {(byte) 197, (byte) 25, (byte) 40, (byte) 212, (byte) 114, (byte) 146, (byte) 45, (byte) 241, (byte) 38, (byte) 116, (byte) 192, (byte) 216, (byte) 133, (byte) 235, (byte) 35, (byte) 44};
    private static String __s_cache_2ndI0YbA_0;
    private static String __s_cache_c0FHclGo_1;
    private static String __s_cache_YbOU5oqn_2;
    private static String __s_cache_y6unVeXG_3;
    private static String __s_cache_Zyy8FOOj_4;
    private static String __s_cache_KHZdkJAj_5;
    private static String __s_cache_94dvW0MF_6;
    private static String __s_cache_RvsruKBI_7;
    private static String __s_cache_ON6aC2m8_8;
    private static String __s_cache_cVoZv4dO_9;
    private static String __s_cache_6rvGNl5O_10;
    private static String __s_cache_YzT4bh9Y_11;
    private static String __s_cache_WJ8iAtSV_12;
    private static String __s_cache_CTzadtQS_13;
    private static String __s_cache_hI22x2R4_14;
    private static String __s_cache_fhh0SJb9_15;
    private static String __s_cache_iSNvO5xn_16;
    private static String __s_cache_pJEkxq9b_17;
    private static String __s_cache_yOUrlAOa_18;
    private static String __s_cache_l0i1paHZ_19;
    private static String __s_cache_1vyAOruJ_20;
    private static String __s_cache_5pcX9S1w_21;
    private static String __s_cache_5rYIK2or_22;
    private static String __s_cache_jHTW9eKM_23;
    private static String __s_cache_ATkRHUgf_24;
    private static String __s_cache_uayUjnMN_25;

    public d() {
        a();
        b();
        n();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Rewards.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Rewards.a().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_rewards_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_rewards_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Rewards.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Rewards.a().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_list_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_list_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_list_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_list_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_collect_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_collect_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_collect_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rewards_collect_success, null);
        this.b.put("gui", new EnumConfigurationBuilder(new File(Rewards.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Rewards.a().getLibAPI().getPluginTag()));
        this.b.put("rewards", new EnumConfigurationBuilder(new File(Rewards.getModuleCore().getExtensionDataFolder(), "storage/yaml/rewards.yml"), Blank.class).build(Rewards.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f157a.put("config", new Files(Rewards.a(), Rewards.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f157a.put("commands", new Files(Rewards.a(), Rewards.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.f157a.put("gui", new Files(Rewards.a(), Rewards.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
        this.f157a.put("rewards", new Files(Rewards.a(), Rewards.getModuleCore().getExtensionDataFolder(), "/storage/yaml/", "rewards", "rewards", "yml"));
    }

    public void c() {
    }

    private void n() {
        File[] fileArrListFiles;
        File file = new File(Rewards.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Rewards.a().getLibAPI().getPluginTag()));
            }
        }
    }

    public EnumConfiguration a(CommandSender commandSender) {
        return commandSender instanceof Player ? b(Optional.of(((Player) commandSender).getUniqueId())) : b(Optional.empty());
    }

    public EnumConfiguration d() {
        return e();
    }

    public EnumConfiguration e() {
        return b(Optional.empty());
    }

    public String a(Optional<UUID> optional) {
        String language = Rewards.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = ModuleEnum.ModuleLang.EN.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Rewards.a().getPlayerAPI().getPlayerData(optional.get());
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

    public HashMap<String, EnumConfiguration> f() {
        return this.c;
    }

    public boolean a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    public void g() {
        h().clear();
        i().clear();
    }

    public HashMap<String, EnumConfiguration> h() {
        return this.b;
    }

    public HashMap<String, Files> i() {
        return this.f157a;
    }

    public FileConfiguration j() {
        return i().get("config").get();
    }

    public FileConfiguration k() {
        return i().get("commands").get();
    }

    public FileConfiguration l() {
        return i().get("rewards").get();
    }

    public FileConfiguration m() {
        return i().get("gui").get();
    }

    private static String __unused_1347() {
        return "config";
    }

    private static String __unused_1348() {
        return "commands";
    }

    private static String __unused_1349() {
        return "gui";
    }

    private static String __unused_1350() {
        return "rewards";
    }

    private static String __unused_1351() {
        return "config";
    }

    private static String __unused_1352() {
        return "config";
    }

    private static String __unused_1353() {
        return "config";
    }

    private static String __unused_1354() {
        return "commands";
    }

    private static String __unused_1355() {
        return "commands";
    }

    private static String __unused_1356() {
        return "commands";
    }

    private static String __unused_1357() {
        return "gui";
    }

    private static String __unused_1358() {
        return "gui";
    }

    private static String __unused_1359() {
        return "gui";
    }

    private static String __unused_1360() {
        return "/storage/yaml/";
    }

    private static String __unused_1361() {
        return "rewards";
    }

    private static String __unused_1362() {
        return "rewards";
    }

    private static String __unused_1363() {
        return "rewards";
    }

    private static String __unused_1364() {
        return "language";
    }

    private static String __unused_1365() {
        return "Lang_";
    }

    private static String __unused_1366() {
        return "EN";
    }

    private static String __unused_1367() {
        return "EN";
    }

    private static String __unused_1368() {
        return "config";
    }

    private static String __unused_1369() {
        return "commands";
    }

    private static String __unused_1370() {
        return "rewards";
    }

    private static String __unused_1371() {
        return "gui";
    }

    private static String __unused_1372() {
        return "Lang_";
    }
}

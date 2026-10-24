package me.module.home.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.home.Home;
import me.module.home.manager.EnumFiles.Chat;
import me.module.home.manager.EnumFiles.Commands;
import me.module.home.manager.EnumFiles.Config;
import me.module.home.manager.EnumFiles.Gui;
import me.module.home.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/e.class */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f113a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_3z60MWaL = {(byte) 99, (byte) 75, (byte) 87, (byte) 97, (byte) 152, (byte) 151, (byte) 13, (byte) 219, (byte) 181, (byte) 233, (byte) 122, (byte) 252, (byte) 215, (byte) 22, (byte) 131, (byte) 190, (byte) 160, (byte) 150, (byte) 20, (byte) 60, (byte) 84, (byte) 4, (byte) 162, (byte) 56, (byte) 34, (byte) 177, (byte) 116, (byte) 4, (byte) 77, (byte) 195, (byte) 213, (byte) 127};
    private static byte[] __aes_iv_i8mXarG4 = {(byte) 114, (byte) 27, (byte) 6, (byte) 64, (byte) 162, (byte) 36, (byte) 52, (byte) 250, (byte) 237, (byte) 53, (byte) 192, (byte) 120, (byte) 238, (byte) 131, (byte) 3, (byte) 244};
    private static String __s_cache_M260VqA3_0;
    private static String __s_cache_a3VOtKhJ_1;
    private static String __s_cache_vECno0U7_2;
    private static String __s_cache_HO3BlQmN_3;
    private static String __s_cache_x5QypHqK_4;
    private static String __s_cache_UiX8Ym5p_5;
    private static String __s_cache_tfUi6ET7_6;
    private static String __s_cache_s0Y7wml1_7;
    private static String __s_cache_eyQXzdXD_8;
    private static String __s_cache_P7Ruy9oY_9;
    private static String __s_cache_qGqR19Gs_10;
    private static String __s_cache_1HnwKNBU_11;
    private static String __s_cache_F3sp5mm1_12;
    private static String __s_cache_zQgSzAKU_13;
    private static String __s_cache_GQFjzHCT_14;
    private static String __s_cache_mzL21moA_15;
    private static String __s_cache_9Y48Zkig_16;
    private static String __s_cache_yWGcl7oU_17;
    private static String __s_cache_F8MAaYxc_18;
    private static String __s_cache_zsB9zMCT_19;
    private static String __s_cache_QhGPaGPp_20;
    private static String __s_cache_RrJ6DJEs_21;
    private static String __s_cache_j7XJYtbN_22;
    private static String __s_cache_X6or2pv4_23;
    private static String __s_cache_910OadoI_24;

    public e() {
        a();
        b();
        m();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Home.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Home.a().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Home.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Home.a().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_create_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_create_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_create_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_create_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_delete_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_delete_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_delete_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_delete_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_list_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_list_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_list_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_list_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_teleport_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_teleport_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_teleport_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_teleport_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_view_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_view_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_view_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_home_view_success, null);
        this.b.put("gui", new EnumConfigurationBuilder(new File(Home.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Home.a().getLibAPI().getPluginTag()));
        this.b.put("chat", new EnumConfigurationBuilder(new File(Home.getModuleCore().getExtensionDataFolder(), "chat.yml"), Chat.class).build(Home.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f113a.put("config", new Files(Home.a(), Home.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f113a.put("commands", new Files(Home.a(), Home.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.f113a.put("gui", new Files(Home.a(), Home.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
        this.f113a.put("chat", new Files(Home.a(), Home.getModuleCore().getExtensionDataFolder(), "", "chat", "chat", "yml"));
    }

    private void m() {
        File[] fileArrListFiles;
        File file = new File(Home.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Home.a().getLibAPI().getPluginTag()));
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
        String language = Home.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = me.module.home.a.a.EnumC0003a.f109a.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Home.a().getPlayerAPI().getPlayerData(optional.get());
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
        return this.f113a;
    }

    public FileConfiguration i() {
        return h().get("config").get();
    }

    public FileConfiguration j() {
        return h().get("commands").get();
    }

    public FileConfiguration k() {
        return h().get("gui").get();
    }

    public FileConfiguration l() {
        return h().get("chat").get();
    }

    private static String __unused_368() {
        return "config";
    }

    private static String __unused_369() {
        return "commands";
    }

    private static String __unused_370() {
        return "gui";
    }

    private static String __unused_371() {
        return "chat";
    }

    private static String __unused_372() {
        return "config";
    }

    private static String __unused_373() {
        return "config";
    }

    private static String __unused_374() {
        return "config";
    }

    private static String __unused_375() {
        return "commands";
    }

    private static String __unused_376() {
        return "commands";
    }

    private static String __unused_377() {
        return "commands";
    }

    private static String __unused_378() {
        return "gui";
    }

    private static String __unused_379() {
        return "gui";
    }

    private static String __unused_380() {
        return "gui";
    }

    private static String __unused_381() {
        return "chat";
    }

    private static String __unused_382() {
        return "chat";
    }

    private static String __unused_383() {
        return "chat";
    }

    private static String __unused_384() {
        return "language";
    }

    private static String __unused_385() {
        return "Lang_";
    }

    private static String __unused_386() {
        return "EN";
    }

    private static String __unused_387() {
        return "EN";
    }

    private static String __unused_388() {
        return "config";
    }

    private static String __unused_389() {
        return "commands";
    }

    private static String __unused_390() {
        return "gui";
    }

    private static String __unused_391() {
        return "chat";
    }

    private static String __unused_392() {
        return "Lang_";
    }
}

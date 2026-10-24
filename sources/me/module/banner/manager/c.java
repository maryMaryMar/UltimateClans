package me.module.banner.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.banner.Banner;
import me.module.banner.manager.EnumFiles.Commands;
import me.module.banner.manager.EnumFiles.Config;
import me.module.banner.manager.EnumFiles.Gui;
import me.module.banner.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/c.class */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f102a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_Sk301DYg = {(byte) 165, (byte) 125, (byte) 249, (byte) 109, (byte) 68, (byte) 218, (byte) 95, (byte) 187, (byte) 33, (byte) 40, (byte) 11, (byte) 254, (byte) 166, (byte) 20, (byte) 16, (byte) 130, (byte) 145, (byte) 72, (byte) 63, (byte) 184, (byte) 67, (byte) 118, (byte) 88, (byte) 146, (byte) 185, (byte) 201, (byte) 191, (byte) 248, (byte) 65, (byte) 58, (byte) 164, (byte) 194};
    private static byte[] __aes_iv_e0KoIVCq = {(byte) 140, (byte) 251, (byte) 86, (byte) 46, (byte) 140, (byte) 203, (byte) 28, (byte) 39, (byte) 186, (byte) 15, (byte) 203, (byte) 93, (byte) 127, (byte) 41, (byte) 10, (byte) 85};
    private static String __s_cache_ya4fd7pq_0;
    private static String __s_cache_BVn5mf6w_1;
    private static String __s_cache_kb5ZqVZR_2;
    private static String __s_cache_y6nA84US_3;
    private static String __s_cache_U0KpKRRC_4;
    private static String __s_cache_bgOFUKxK_5;
    private static String __s_cache_PE6t2yCq_6;
    private static String __s_cache_CetbG1JX_7;
    private static String __s_cache_9A8PaQvJ_8;
    private static String __s_cache_AoB20LTp_9;
    private static String __s_cache_zb7t43tM_10;
    private static String __s_cache_eeF3bEX6_11;
    private static String __s_cache_NZkQjugp_12;
    private static String __s_cache_h9L0YVMJ_13;
    private static String __s_cache_s0ufsQFj_14;
    private static String __s_cache_SGwThys0_15;
    private static String __s_cache_yeb0VE7C_16;
    private static String __s_cache_ALihCht7_17;
    private static String __s_cache_GWrxn22m_18;
    private static String __s_cache_lXmBA28v_19;

    public c() {
        a();
        b();
        k();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Banner.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Banner.a().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Banner.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Banner.a().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_upload_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_upload_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_upload_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_upload_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_delete_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_delete_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_delete_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_delete_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_view_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_view_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_view_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_banner_view_success, null);
        this.b.put("gui", new EnumConfigurationBuilder(new File(Banner.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Banner.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f102a.put("config", new Files(Banner.a(), Banner.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f102a.put("commands", new Files(Banner.a(), Banner.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.f102a.put("gui", new Files(Banner.a(), Banner.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
    }

    private void k() {
        File[] fileArrListFiles;
        File file = new File(Banner.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Banner.a().getLibAPI().getPluginTag()));
            }
        }
    }

    public EnumConfiguration a(CommandSender commandSender) {
        return commandSender instanceof Player ? b(Optional.of(((Player) commandSender).getUniqueId())) : b(Optional.empty());
    }

    public EnumConfiguration c() {
        return b(Optional.empty());
    }

    public String a(Optional<UUID> optional) {
        String language = Banner.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = me.module.banner.a.a.EnumC0002a.f99a.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Banner.a().getPlayerAPI().getPlayerData(optional.get());
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

    public HashMap<String, EnumConfiguration> d() {
        return this.c;
    }

    public boolean a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    public void e() {
        f().clear();
        g().clear();
    }

    public HashMap<String, EnumConfiguration> f() {
        return this.b;
    }

    public HashMap<String, Files> g() {
        return this.f102a;
    }

    public FileConfiguration h() {
        return g().get("config").get();
    }

    public FileConfiguration i() {
        return g().get("commands").get();
    }

    public FileConfiguration j() {
        return g().get("gui").get();
    }

    private static String __unused_1622() {
        return "config";
    }

    private static String __unused_1623() {
        return "commands";
    }

    private static String __unused_1624() {
        return "gui";
    }

    private static String __unused_1625() {
        return "config";
    }

    private static String __unused_1626() {
        return "config";
    }

    private static String __unused_1627() {
        return "config";
    }

    private static String __unused_1628() {
        return "commands";
    }

    private static String __unused_1629() {
        return "commands";
    }

    private static String __unused_1630() {
        return "commands";
    }

    private static String __unused_1631() {
        return "gui";
    }

    private static String __unused_1632() {
        return "gui";
    }

    private static String __unused_1633() {
        return "gui";
    }

    private static String __unused_1634() {
        return "language";
    }

    private static String __unused_1635() {
        return "Lang_";
    }

    private static String __unused_1636() {
        return "EN";
    }

    private static String __unused_1637() {
        return "EN";
    }

    private static String __unused_1638() {
        return "config";
    }

    private static String __unused_1639() {
        return "commands";
    }

    private static String __unused_1640() {
        return "gui";
    }

    private static String __unused_1641() {
        return "Lang_";
    }
}

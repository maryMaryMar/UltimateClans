package me.module.rivalally.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.rivalally.Rivalally;
import me.module.rivalally.data.ModuleEnum;
import me.module.rivalally.manager.EnumFiles.Commands;
import me.module.rivalally.manager.EnumFiles.Config;
import me.module.rivalally.manager.EnumFiles.Gui;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/b.class */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f163a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_Si3R08aZ = {(byte) 100, (byte) 128, (byte) 123, (byte) 252, (byte) 53, (byte) 24, (byte) 172, (byte) 57, (byte) 146, (byte) 122, (byte) 207, (byte) 195, (byte) 193, (byte) 217, (byte) 1, (byte) 185, (byte) 160, (byte) 209, (byte) 33, (byte) 152, (byte) 139, (byte) 224, (byte) 79, (byte) 32, (byte) 47, (byte) 3, (byte) 112, (byte) 35, (byte) 158, (byte) 121, (byte) 219, (byte) 58};
    private static byte[] __aes_iv_QaYjWQmh = {(byte) 68, (byte) 213, (byte) 164, (byte) 204, (byte) 222, (byte) 130, (byte) 17, (byte) 226, (byte) 176, (byte) 240, (byte) 143, (byte) 249, (byte) 130, (byte) 193, (byte) 240, (byte) 140};
    private static String __s_cache_8Oe9u0Xs_0;
    private static String __s_cache_ALFeHgqO_1;
    private static String __s_cache_BN1NzfAt_2;
    private static String __s_cache_PujuppdW_3;
    private static String __s_cache_Ds7llogW_4;
    private static String __s_cache_ybD0hGnR_5;
    private static String __s_cache_Yx4ewrLN_6;
    private static String __s_cache_iuL6wIji_7;
    private static String __s_cache_EYNxAeM5_8;
    private static String __s_cache_R678uoil_9;
    private static String __s_cache_RmsPbNYF_10;
    private static String __s_cache_O72vR1A8_11;
    private static String __s_cache_sBMrBN7z_12;
    private static String __s_cache_RzSHdBG8_13;
    private static String __s_cache_NTLQamoX_14;
    private static String __s_cache_QRnCjhYx_15;
    private static String __s_cache_zhyXq302_16;
    private static String __s_cache_HX9UjGNL_17;
    private static String __s_cache_8qUYUHsi_18;
    private static String __s_cache_R3vVyP0s_19;

    public b() {
        a();
        b();
        l();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Rivalally.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Rivalally.a().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_ally_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_ally_icon_lore, null);
        enumConfigurationBuild.set(Config.CONFIG_rival_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_rival_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Rivalally.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Rivalally.a().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_add_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_add_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_add_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_add_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_remove_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_remove_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_remove_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_remove_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_list_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_list_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_list_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_list_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_deny_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_deny_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_deny_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_deny_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_accept_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_accept_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_accept_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_rival_accept_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_add_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_add_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_add_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_add_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_remove_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_remove_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_remove_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_remove_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_list_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_list_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_list_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_list_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_accept_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_accept_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_accept_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_accept_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_deny_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_deny_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_deny_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_ally_deny_success, null);
        this.b.put("gui", new EnumConfigurationBuilder(new File(Rivalally.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Rivalally.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.f163a.put("config", new Files(Rivalally.a(), Rivalally.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f163a.put("commands", new Files(Rivalally.a(), Rivalally.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.f163a.put("gui", new Files(Rivalally.a(), Rivalally.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
    }

    private void l() {
        File[] fileArrListFiles;
        File file = new File(Rivalally.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Rivalally.a().getLibAPI().getPluginTag()));
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
        String language = Rivalally.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = ModuleEnum.ModuleLang.EN.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Rivalally.a().getPlayerAPI().getPlayerData(optional.get());
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
        this.c.clear();
    }

    public HashMap<String, EnumConfiguration> g() {
        return this.b;
    }

    public HashMap<String, Files> h() {
        return this.f163a;
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

    private static String __unused_1189() {
        return "config";
    }

    private static String __unused_1190() {
        return "commands";
    }

    private static String __unused_1191() {
        return "gui";
    }

    private static String __unused_1192() {
        return "config";
    }

    private static String __unused_1193() {
        return "config";
    }

    private static String __unused_1194() {
        return "config";
    }

    private static String __unused_1195() {
        return "commands";
    }

    private static String __unused_1196() {
        return "commands";
    }

    private static String __unused_1197() {
        return "commands";
    }

    private static String __unused_1198() {
        return "gui";
    }

    private static String __unused_1199() {
        return "gui";
    }

    private static String __unused_1200() {
        return "gui";
    }

    private static String __unused_1201() {
        return "language";
    }

    private static String __unused_1202() {
        return "Lang_";
    }

    private static String __unused_1203() {
        return "EN";
    }

    private static String __unused_1204() {
        return "EN";
    }

    private static String __unused_1205() {
        return "config";
    }

    private static String __unused_1206() {
        return "commands";
    }

    private static String __unused_1207() {
        return "gui";
    }

    private static String __unused_1208() {
        return "Lang_";
    }
}

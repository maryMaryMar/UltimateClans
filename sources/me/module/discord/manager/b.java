package me.module.discord.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.discord.Discord;
import me.module.discord.data.ModuleEnum;
import me.module.discord.manager.EnumFiles.Commands;
import me.module.discord.manager.EnumFiles.Config;
import me.module.discord.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/b.class */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Files> f107a = new HashMap<>();
    private HashMap<String, EnumConfiguration> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private static byte[] __aes_key_qkbcGX2B = {(byte) 209, (byte) 129, (byte) 220, (byte) 0, (byte) 23, (byte) 174, (byte) 174, (byte) 196, (byte) 14, (byte) 177, (byte) 174, (byte) 236, (byte) 116, (byte) 198, (byte) 212, (byte) 28, (byte) 119, (byte) 241, (byte) 142, (byte) 20, (byte) 222, (byte) 16, (byte) 15, (byte) 30, (byte) 68, (byte) 247, (byte) 40, (byte) 31, (byte) 186, (byte) 46, (byte) 119, (byte) 21};
    private static byte[] __aes_iv_NAHgSA4z = {(byte) 77, (byte) 45, (byte) 223, (byte) 23, (byte) 249, (byte) 228, (byte) 72, (byte) 88, (byte) 248, (byte) 40, (byte) 233, (byte) 199, (byte) 71, (byte) 166, (byte) 24, (byte) 156};
    private static String __s_cache_fCw1WDlF_0;
    private static String __s_cache_KyqNVzOm_1;
    private static String __s_cache_Mh1dWKMi_2;
    private static String __s_cache_6zYIBMXW_3;
    private static String __s_cache_WbL9avt5_4;
    private static String __s_cache_dw3FjwDd_5;
    private static String __s_cache_YuEamvbk_6;
    private static String __s_cache_Pu0ktQvt_7;
    private static String __s_cache_Lgg3hjbZ_8;
    private static String __s_cache_1BF6MjQC_9;
    private static String __s_cache_7qWvcIVc_10;
    private static String __s_cache_XsNVGUBq_11;
    private static String __s_cache_iad5kAZc_12;
    private static String __s_cache_DaCYcuLb_13;
    private static String __s_cache_qFm67bOo_14;

    public b() {
        a();
        b();
        k();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Discord.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Discord.b().getLibAPI().getPluginTag());
        this.b.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Discord.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Discord.b().getLibAPI().getPluginTag());
        this.b.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_client_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_client_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_client_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_client_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_register_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_unregister_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_unregister_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_unregister_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_discord_unregister_success, null);
    }

    public void b() {
        this.f107a.put("config", new Files(Discord.b(), Discord.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.f107a.put("commands", new Files(Discord.b(), Discord.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
    }

    private void k() {
        File[] fileArrListFiles;
        File file = new File(Discord.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.c.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Discord.b().getLibAPI().getPluginTag()));
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
        String language = Discord.b().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = ModuleEnum.ModuleLang.EN.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Discord.b().getPlayerAPI().getPlayerData(optional.get());
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
        return this.f107a;
    }

    public FileConfiguration i() {
        return h().get("config").get();
    }

    public FileConfiguration j() {
        return h().get("commands").get();
    }

    private static String __unused_1511() {
        return "config";
    }

    private static String __unused_1512() {
        return "commands";
    }

    private static String __unused_1513() {
        return "config";
    }

    private static String __unused_1514() {
        return "config";
    }

    private static String __unused_1515() {
        return "config";
    }

    private static String __unused_1516() {
        return "commands";
    }

    private static String __unused_1517() {
        return "commands";
    }

    private static String __unused_1518() {
        return "commands";
    }

    private static String __unused_1519() {
        return "language";
    }

    private static String __unused_1520() {
        return "Lang_";
    }

    private static String __unused_1521() {
        return "EN";
    }

    private static String __unused_1522() {
        return "EN";
    }

    private static String __unused_1523() {
        return "config";
    }

    private static String __unused_1524() {
        return "commands";
    }

    private static String __unused_1525() {
        return "Lang_";
    }
}

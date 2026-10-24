package me.module.mail.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import me.module.mail.Mail;
import me.module.mail.manager.EnumFiles.Blank;
import me.module.mail.manager.EnumFiles.Commands;
import me.module.mail.manager.EnumFiles.Config;
import me.module.mail.manager.EnumFiles.Gui;
import me.module.mail.manager.EnumFiles.Lang;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.utils.Files;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/g.class */
public class g {
    private static byte[] __aes_key_e5w0E1lz = {(byte) 209, (byte) 8, (byte) 191, (byte) 49, (byte) 66, (byte) 161, (byte) 176, (byte) 128, (byte) 43, (byte) 98, (byte) 179, (byte) 133, (byte) 85, (byte) 224, (byte) 164, (byte) 37, (byte) 229, (byte) 73, (byte) 74, (byte) 4, (byte) 213, (byte) 62, (byte) 199, (byte) 171, (byte) 56, (byte) 75, (byte) 247, (byte) 203, (byte) 157, (byte) 149, (byte) 91, (byte) 204};
    private static byte[] __aes_iv_QCPmSmnt = {(byte) 70, (byte) 43, (byte) 203, (byte) 87, (byte) 157, (byte) 34, (byte) 80, (byte) 145, (byte) 184, (byte) 80, (byte) 93, (byte) 248, (byte) 160, (byte) 162, (byte) 66, (byte) 13};
    private static String __s_cache_Jxqd843l_0;
    private static String __s_cache_mpHCEtMw_1;
    private static String __s_cache_EjepzDNh_2;
    private static String __s_cache_gBt0lojB_3;
    private static String __s_cache_mtwJnfQx_4;
    private static String __s_cache_JCVezrwz_5;
    private static String __s_cache_AoB3kxD7_6;
    private static String __s_cache_3aAiJ1u4_7;
    private static String __s_cache_LJvFNaVY_8;
    private static String __s_cache_8etKUMvf_9;
    private static String __s_cache_FX4bdaa6_10;
    private static String __s_cache_mnTIN3bz_11;
    private static String __s_cache_MkPCrUC0_12;
    private static String __s_cache_x2UGs6fq_13;
    private static String __s_cache_AWpe4HRT_14;
    private static String __s_cache_VnRKqHaX_15;
    private static String __s_cache_cJ60XVhq_16;
    private static String __s_cache_4IfIuN0y_17;
    private static String __s_cache_MYz2I1vO_18;
    private static String __s_cache_NknPkPGa_19;
    private static String __s_cache_pGXZ1WYg_20;
    private static String __s_cache_4HAUEqU1_21;
    private static String __s_cache_4LZF938a_22;
    private static String __s_cache_3D6tUlcl_23;
    private static String __s_cache_OAnUL0n3_24;
    private static String __s_cache_MwOoT1pT_25;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f140a = null;
    private HashMap<String, Files> b = new HashMap<>();
    private HashMap<String, EnumConfiguration> c = new HashMap<>();
    private HashMap<String, EnumConfiguration> d = new HashMap<>();

    public g() {
        a();
        b();
        o();
    }

    public void a() {
        EnumConfiguration enumConfigurationBuild = new EnumConfigurationBuilder(new File(Mail.getModuleCore().getExtensionDataFolder(), "config.yml"), Config.class).build(Mail.a().getLibAPI().getPluginTag());
        this.c.put("config", enumConfigurationBuild);
        enumConfigurationBuild.set(Config.CONFIG_icon_name, null);
        enumConfigurationBuild.set(Config.CONFIG_icon_lore, null);
        EnumConfiguration enumConfigurationBuild2 = new EnumConfigurationBuilder(new File(Mail.getModuleCore().getExtensionDataFolder(), "commands.yml"), Commands.class).build(Mail.a().getLibAPI().getPluginTag());
        this.c.put("commands", enumConfigurationBuild2);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_help_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_help_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_help_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_help_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_clear_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_clear_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_clear_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_clear_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_read_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_read_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_read_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_read_success, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_send_show, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_send_usage, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_send_error, null);
        enumConfigurationBuild2.set(Commands.COMMANDS_mail_send_success, null);
        this.c.put("gui", new EnumConfigurationBuilder(new File(Mail.getModuleCore().getExtensionDataFolder(), "gui.yml"), Gui.class).build(Mail.a().getLibAPI().getPluginTag()));
        this.c.put("mail", new EnumConfigurationBuilder(new File(Mail.getModuleCore().getExtensionDataFolder(), "storage/yaml/mail.yml"), Blank.class).build(Mail.a().getLibAPI().getPluginTag()));
    }

    public void b() {
        this.b.put("config", new Files(Mail.a(), Mail.getModuleCore().getExtensionDataFolder(), "", "config", "config", "yml"));
        this.b.put("commands", new Files(Mail.a(), Mail.getModuleCore().getExtensionDataFolder(), "", "commands", "commands", "yml"));
        this.b.put("gui", new Files(Mail.a(), Mail.getModuleCore().getExtensionDataFolder(), "", "gui", "gui", "yml"));
        this.b.put("mail", new Files(Mail.a(), Mail.getModuleCore().getExtensionDataFolder(), "/storage/yaml/", "mail", "mail", "yml"));
    }

    public void c() {
    }

    private void o() {
        File[] fileArrListFiles;
        File file = new File(Mail.getModuleCore().getExtensionDataFolder(), "language");
        if (file.exists() && (fileArrListFiles = file.listFiles((file2, str) -> {
            return str.endsWith(".yml") && str.startsWith("Lang_");
        })) != null) {
            for (File file3 : fileArrListFiles) {
                this.d.put(file3.getName().replace("Lang_", "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(Mail.a().getLibAPI().getPluginTag()));
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
        String language = Mail.a().getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = me.module.mail.a.a.EnumC0006a.f132a.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> playerData = Mail.a().getPlayerAPI().getPlayerData(optional.get());
                if (playerData.isPresent() && playerData.get().getLang() != null && !playerData.get().getLang().trim().isEmpty()) {
                    lang = playerData.get().getLang();
                }
            } catch (Exception e) {
            }
        }
        String upperCase = lang.toUpperCase(Locale.ROOT);
        if (this.d.containsKey(upperCase)) {
            return upperCase;
        }
        String upperCase2 = language.toUpperCase(Locale.ROOT);
        if (this.d.containsKey(upperCase2)) {
            return upperCase2;
        }
        return this.d.containsKey("EN") ? "EN" : this.d.keySet().stream().findFirst().orElse(upperCase2);
    }

    public EnumConfiguration b(Optional<UUID> optional) {
        if (this.d.isEmpty()) {
            return null;
        }
        return this.d.get(a(optional));
    }

    public HashMap<String, EnumConfiguration> f() {
        return this.d;
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
        return this.c;
    }

    public HashMap<String, Files> i() {
        return this.b;
    }

    public FileConfiguration j() {
        return i().get("config").get();
    }

    public FileConfiguration k() {
        return i().get("commands").get();
    }

    public FileConfiguration l() {
        return i().get("mail").get();
    }

    public FileConfiguration m() {
        return i().get("gui").get();
    }

    public String n() {
        return this.f140a;
    }

    private static String __unused_643() {
        return "config";
    }

    private static String __unused_644() {
        return "commands";
    }

    private static String __unused_645() {
        return "gui";
    }

    private static String __unused_646() {
        return "mail";
    }

    private static String __unused_647() {
        return "config";
    }

    private static String __unused_648() {
        return "config";
    }

    private static String __unused_649() {
        return "config";
    }

    private static String __unused_650() {
        return "commands";
    }

    private static String __unused_651() {
        return "commands";
    }

    private static String __unused_652() {
        return "commands";
    }

    private static String __unused_653() {
        return "gui";
    }

    private static String __unused_654() {
        return "gui";
    }

    private static String __unused_655() {
        return "gui";
    }

    private static String __unused_656() {
        return "/storage/yaml/";
    }

    private static String __unused_657() {
        return "mail";
    }

    private static String __unused_658() {
        return "mail";
    }

    private static String __unused_659() {
        return "mail";
    }

    private static String __unused_660() {
        return "language";
    }

    private static String __unused_661() {
        return "Lang_";
    }

    private static String __unused_662() {
        return "EN";
    }

    private static String __unused_663() {
        return "EN";
    }

    private static String __unused_664() {
        return "config";
    }

    private static String __unused_665() {
        return "commands";
    }

    private static String __unused_666() {
        return "mail";
    }

    private static String __unused_667() {
        return "gui";
    }

    private static String __unused_668() {
        return "Lang_";
    }
}

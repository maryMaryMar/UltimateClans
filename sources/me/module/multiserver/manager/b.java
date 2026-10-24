package me.module.multiserver.manager;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import me.module.multiserver.Multiserver;
import me.module.multiserver.listeners.ProxyListeners;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanSyncReceivedMessageEvent;
import me.ulrich.clans.interfaces.LoggerModuleAPI;
import me.ulrich.clans.interfaces.MailModuleAPI;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import me.ulrich.clans.library.paperlib.PaperLib;
import me.ulrich.clans.library.udojava.evalex.Expression;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/manager/b.class */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f145a;
    private static String b;
    private static final String e = "bclans:tp-in";
    private static final String f = "bclans:tp-out";
    private static final long g = 1000;
    private static String __s_cache_uPoDCrtz_0;
    private static String __s_cache_pFPw2Eri_1;
    private static String __s_cache_AH07Lqzk_2;
    private static String __s_cache_pjqKt4SH_3;
    private static String __s_cache_I6dKB5tw_4;
    private static String __s_cache_XPbOyLlV_5;
    private static String __s_cache_KuwqpBgx_6;
    private static String __s_cache_MDl28ouD_7;
    private static String __s_cache_FNPzUxax_8;
    private static String __s_cache_RtO2PHSf_9;
    private static String __s_cache_4HY6vMeg_10;
    private static String __s_cache_S4zKYpZA_11;
    private static String __s_cache_2om6x9aq_12;
    private static String __s_cache_K6lEIY2I_13;
    private static String __s_cache_ydA7bR3h_14;
    private static String __s_cache_O89QhLeM_15;
    private static String __s_cache_uGBkRLvc_16;
    private static String __s_cache_XuGZUgDk_17;
    private static String __s_cache_mWBYBy4S_18;
    private static String __s_cache_AxKUFpYr_19;
    private static String __s_cache_Da5QQOxJ_20;
    private static String __s_cache_30e2rO9v_21;
    private static String __s_cache_WHEdlDDv_22;
    private static String __s_cache_gixC7Oyp_23;
    private static String __s_cache_INA5taHG_24;
    private static String __s_cache_0JsWjhT2_25;
    private static String __s_cache_lAtvDUSi_26;
    private static String __s_cache_6zi6v2Er_27;
    private static String __s_cache_7wb1Ke9X_28;
    private static String __s_cache_58uWvQCl_29;
    private static String __s_cache_n9tBuiJt_30;
    private static String __s_cache_Nl2lgXcN_31;
    private static String __s_cache_MCEtsg0n_32;
    private static String __s_cache_0oBrIteL_33;
    private static String __s_cache_NwQVCPyU_34;
    private static String __s_cache_FxqGbjk0_35;
    private static String __s_cache_Wqpc1MCC_36;
    private static String __s_cache_KPeXCMlN_37;
    private static String __s_cache_7OGfyHWL_38;
    private static String __s_cache_i8DTlSoA_39;
    private static String __s_cache_U8dNQ0ij_40;
    private static String __s_cache_KSDbV8BD_41;
    private static String __s_cache_Fm5A8xGQ_42;
    private static String __s_cache_40snB1W3_43;
    private static String __s_cache_gPJYWYh1_44;
    private static String __s_cache_M98tLl4U_45;
    private static String __s_cache_opAWxqLl_46;
    private static String __s_cache_nnJEHxjP_47;
    private static byte[] __aes_key_eqePa4JO = {(byte) 43, (byte) 195, (byte) 209, (byte) 185, (byte) 144, (byte) 56, (byte) 56, (byte) 183, (byte) 19, (byte) 122, (byte) 192, (byte) 82, (byte) 116, (byte) 173, (byte) 23, (byte) 88, (byte) 230, (byte) 236, (byte) 96, (byte) 114, (byte) 166, (byte) 204, (byte) 134, (byte) 208, (byte) 140, (byte) 61, (byte) 235, (byte) 59, (byte) 108, (byte) 13, (byte) 7, (byte) 187};
    private static byte[] __aes_iv_pe4KqMsc = {(byte) 236, (byte) 40, (byte) 170, (byte) 70, (byte) 171, (byte) 249, (byte) 228, (byte) 92, (byte) 215, (byte) 105, (byte) 33, (byte) 122, (byte) 7, (byte) 202, (byte) 158, (byte) 64};
    private static final Map<UUID, Location> c = new ConcurrentHashMap();
    private static final Map<String, Long> d = new ConcurrentHashMap();

    public static void a() {
        b = Multiserver.getModuleCore().c().g().getString("Sync.high.server_name");
        Multiserver.a().setServerName(b);
        h();
    }

    private static void h() {
        Multiserver.getModuleCore().b().info("Setup multiserver:");
        if (!c()) {
            Multiserver.getModuleCore().b().info(" - Disabled");
            return;
        }
        Multiserver.getModuleCore().b().info(" - Mode: REDIS");
        f145a = new c();
        f145a.a();
        if (f145a.f()) {
            b();
            i();
            Multiserver.getModuleCore().b().info(" - Redis connected");
        }
    }

    public static void b() {
        if (Bukkit.getServer().getMessenger().isOutgoingChannelRegistered(Multiserver.a(), "BungeeCord")) {
            return;
        }
        Multiserver.getModuleCore().b().info(" - Registering proxy...");
        Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(Multiserver.a(), "BungeeCord");
    }

    private static void i() {
        Multiserver.getModuleCore().b().info(" - Registering (optional) plugin channels...");
        Bukkit.getMessenger().registerIncomingPluginChannel(Multiserver.a(), g(), new ProxyListeners(null));
        Bukkit.getMessenger().registerOutgoingPluginChannel(Multiserver.a(), f());
    }

    public static boolean c() {
        return Multiserver.getModuleCore().c().g().getBoolean("Sync.high.enabled") && Multiserver.a().getDatabaseType().equals(ClanEnum.ClanStorage.MYSQL);
    }

    public static void d() {
        if (f145a != null) {
            f145a.b();
        }
    }

    public static void a(String str, UUID uuid) {
        a(str, uuid.toString());
    }

    public static void a(String str, String str2) {
        if (f145a == null || !f145a.f()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", str);
        jSONObject.put("server", b);
        jSONObject.put("content", str2);
        f145a.a(jSONObject.toString());
        a(ClanEnum.DebugType.SENT, jSONObject.toString());
    }

    public static void a(String str) {
        if (c()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("event", null);
                String strOptString2 = jSONObject.optString("server", null);
                if (strOptString == null || strOptString2 == null) {
                    return;
                }
                try {
                    String upperCase = strOptString.toUpperCase();
                    if (!strOptString2.equals(b) || upperCase.equals("PLAYERTELEPORT")) {
                        a(ClanEnum.DebugType.RECEIVED, str);
                        byte b2 = -1;
                        switch (upperCase.hashCode()) {
                            case -1666374426:
                                if (upperCase.equals("CLANMAILS")) {
                                    b2 = 3;
                                }
                                break;
                            case -133764250:
                                if (upperCase.equals("CLANLOGGER")) {
                                    b2 = 2;
                                }
                                break;
                            case 305309098:
                                if (upperCase.equals("MODERATIONUPDATEUUID")) {
                                    b2 = 4;
                                }
                                break;
                            case 906648558:
                                if (upperCase.equals("CLANREWARDS")) {
                                    b2 = 6;
                                }
                                break;
                            case 1057928613:
                                if (upperCase.equals("PLAYERUPDATEUUID")) {
                                    b2 = 5;
                                }
                                break;
                            case 1225831130:
                                if (upperCase.equals("CLANUPDATEUUID")) {
                                    b2 = 0;
                                }
                                break;
                            case 1251293133:
                                if (upperCase.equals("INVITEUPDATEUUID")) {
                                    b2 = 1;
                                }
                                break;
                            case 1327236364:
                                if (upperCase.equals("PLAYERTELEPORT")) {
                                    b2 = 7;
                                }
                                break;
                        }
                        switch (b2) {
                            case 0:
                                a(jSONObject);
                                break;
                            case 1:
                                b(jSONObject);
                                break;
                            case 2:
                                d(jSONObject);
                                break;
                            case 3:
                                e(jSONObject);
                                break;
                            case 4:
                                c(jSONObject);
                                break;
                            case 5:
                                f(jSONObject);
                                break;
                            case 6:
                                g(jSONObject);
                                break;
                            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                                h(jSONObject);
                                break;
                        }
                    }
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
            }
        }
    }

    private static void a(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("clan:" + String.valueOf(uuidI))) {
            return;
        }
        a(() -> {
            Multiserver.a().getClanAPI().reloadClanData(uuidI);
        });
    }

    private static void b(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("invite:" + String.valueOf(uuidI))) {
            return;
        }
        a(() -> {
            Multiserver.a().getInviteAPI().reloadInviteData(uuidI);
        });
    }

    private static void c(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("mod:" + String.valueOf(uuidI))) {
            return;
        }
        a(() -> {
            Multiserver.a().getModAPI().loadModerationData(uuidI);
        });
    }

    private static void d(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("logger:" + String.valueOf(uuidI))) {
            return;
        }
        Optional<LoggerModuleAPI> logger = Multiserver.a().getIntegrationAPI().getLogger();
        if (logger.isPresent()) {
            a(() -> {
                ((LoggerModuleAPI) logger.get()).ReloadLoggerData(uuidI);
            });
        }
    }

    private static void e(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("mail:" + String.valueOf(uuidI))) {
            return;
        }
        Optional<MailModuleAPI> mail = Multiserver.a().getIntegrationAPI().getMail();
        if (mail.isPresent()) {
            a(() -> {
                ((MailModuleAPI) mail.get()).ReloadMailData(uuidI);
            });
        }
    }

    private static void f(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("player:" + String.valueOf(uuidI))) {
            return;
        }
        a(() -> {
            Multiserver.a().getPlayerAPI().loadPlayerData(uuidI);
        });
    }

    private static void g(JSONObject jSONObject) {
        UUID uuidI = i(jSONObject);
        if (uuidI == null || b("rewards:" + String.valueOf(uuidI))) {
            return;
        }
        Optional<RewardsModuleAPI> rewards = Multiserver.a().getIntegrationAPI().getRewards();
        if (rewards.isPresent()) {
            a(() -> {
                ((RewardsModuleAPI) rewards.get()).ReloadRewardsData(uuidI);
            });
        }
    }

    private static void h(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("content", "{}"));
        try {
            a(UUID.fromString(jSONObject2.getString("player")), new Location(Bukkit.getWorld(jSONObject2.getString("world")), jSONObject2.getDouble("x"), jSONObject2.getDouble("y"), jSONObject2.getDouble("z"), jSONObject2.getFloat("yaw"), jSONObject2.getFloat("pitch")));
        } catch (Exception e2) {
        }
    }

    private static UUID i(JSONObject jSONObject) {
        try {
            return UUID.fromString(jSONObject.optString("content", ""));
        } catch (Exception e2) {
            return null;
        }
    }

    private static boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - d.getOrDefault(str, 0L).longValue() < g) {
            return true;
        }
        d.put(str, Long.valueOf(jCurrentTimeMillis));
        return false;
    }

    private static void a(Runnable runnable) {
        Multiserver.getModuleCore().d().runTaskLater(runnable, Multiserver.getModuleCore().c().g().getInt("Sync.high.sync_delay"));
    }

    public static void a(UUID uuid, String str, double d2, double d3, double d4, float f2, float f3) {
        World world = Bukkit.getWorld(str);
        if (world == null) {
            return;
        }
        a(uuid, new Location(world, d2, d3, d4, f2, f3));
    }

    public static void a(UUID uuid, Location location) {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            a(player, location);
        } else {
            c.put(uuid, location);
            Multiserver.getModuleCore().d().runTaskLaterAsynchronously(() -> {
                c.remove(uuid);
            }, 200L);
        }
    }

    public static void a(Player player) {
        Location locationRemove = c.remove(player.getUniqueId());
        if (locationRemove != null) {
            a(player, locationRemove);
        }
    }

    private static void a(Player player, Location location) {
        if (Multiserver.a().getLibAPI().isFolia()) {
            PaperLib.teleportAsync(player, location);
        } else {
            player.teleport(location);
        }
    }

    public static void a(Player player, String str) {
        if (player == null || !player.isOnline()) {
            return;
        }
        ByteArrayDataOutput byteArrayDataOutputNewDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutputNewDataOutput.writeUTF("Connect");
        byteArrayDataOutputNewDataOutput.writeUTF(str);
        player.sendPluginMessage(Multiserver.a(), "BungeeCord", byteArrayDataOutputNewDataOutput.toByteArray());
    }

    public static void a(ClanEnum.DebugType debugType, String str) {
        if (debugType == null) {
            return;
        }
        FileConfiguration fileConfigurationG = Multiserver.getModuleCore().c().g();
        Logger loggerB = Multiserver.getModuleCore().b();
        switch (debugType) {
            case RECEIVED:
                if (fileConfigurationG.getBoolean("Sync.high.debug.console_received_messages")) {
                    loggerB.info("[Sync debug - received] " + str);
                }
                if (fileConfigurationG.getBoolean("Sync.high.debug.file_received_messages")) {
                    b(str, "sync_debug_received");
                }
                break;
            case SENT:
                if (fileConfigurationG.getBoolean("Sync.high.debug.console_messages_sent")) {
                    loggerB.info("[Sync debug - sent] " + str);
                }
                if (fileConfigurationG.getBoolean("Sync.high.debug.file_messages_sent")) {
                    b(str, "sync_debug_sent");
                }
                break;
            case DISPATCH:
                if (fileConfigurationG.getBoolean("Sync.high.debug.dispatch")) {
                    loggerB.info("[Sync debug - dispatch] " + str);
                }
                if (fileConfigurationG.getBoolean("Sync.high.debug.file_dispatch")) {
                    b(str, "sync_debug_dispatch");
                }
                break;
        }
        try {
            Bukkit.getPluginManager().callEvent(new ClanSyncReceivedMessageEvent(debugType, str));
        } catch (Exception e2) {
            Multiserver.getModuleCore().b().warning("Failed to dispatch ClanSyncReceivedMessageEvent: " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private static void b(String str, String str2) {
    }

    public static String e() {
        return b;
    }

    public static String f() {
        return "bclans:tp-in";
    }

    public static String g() {
        return "bclans:tp-out";
    }

    private static String __unused_1743() {
        return "Sync.high.server_name";
    }

    private static String __unused_1744() {
        return "Setup multiserver:";
    }

    private static String __unused_1745() {
        return " - Disabled";
    }

    private static String __unused_1746() {
        return " - Mode: REDIS";
    }

    private static String __unused_1747() {
        return " - Redis connected";
    }

    private static String __unused_1748() {
        return "BungeeCord";
    }

    private static String __unused_1749() {
        return " - Registering proxy...";
    }

    private static String __unused_1750() {
        return "BungeeCord";
    }

    private static String __unused_1751() {
        return " - Registering (optional) plugin channels...";
    }

    private static String __unused_1752() {
        return "Sync.high.enabled";
    }

    private static String __unused_1753() {
        return "event";
    }

    private static String __unused_1754() {
        return "server";
    }

    private static String __unused_1755() {
        return "content";
    }

    private static String __unused_1756() {
        return "event";
    }

    private static String __unused_1757() {
        return "server";
    }

    private static String __unused_1758() {
        return "PLAYERTELEPORT";
    }

    private static String __unused_1759() {
        return "CLANUPDATEUUID";
    }

    private static String __unused_1760() {
        return "INVITEUPDATEUUID";
    }

    private static String __unused_1761() {
        return "CLANLOGGER";
    }

    private static String __unused_1762() {
        return "CLANMAILS";
    }

    private static String __unused_1763() {
        return "MODERATIONUPDATEUUID";
    }

    private static String __unused_1764() {
        return "PLAYERUPDATEUUID";
    }

    private static String __unused_1765() {
        return "CLANREWARDS";
    }

    private static String __unused_1766() {
        return "PLAYERTELEPORT";
    }

    private static String __unused_1767() {
        return "content";
    }

    private static String __unused_1768() {
        return "{}";
    }

    private static String __unused_1769() {
        return "player";
    }

    private static String __unused_1770() {
        return "world";
    }

    private static String __unused_1771() {
        return "x";
    }

    private static String __unused_1772() {
        return "y";
    }

    private static String __unused_1773() {
        return "z";
    }

    private static String __unused_1774() {
        return "yaw";
    }

    private static String __unused_1775() {
        return "pitch";
    }

    private static String __unused_1776() {
        return "content";
    }

    private static String __unused_1777() {
        return "Sync.high.sync_delay";
    }

    private static String __unused_1778() {
        return "Connect";
    }

    private static String __unused_1779() {
        return "BungeeCord";
    }

    private static String __unused_1780() {
        return "Sync.high.debug.console_received_messages";
    }

    private static String __unused_1781() {
        return "Sync.high.debug.file_received_messages";
    }

    private static String __unused_1782() {
        return "sync_debug_received";
    }

    private static String __unused_1783() {
        return "Sync.high.debug.console_messages_sent";
    }

    private static String __unused_1784() {
        return "Sync.high.debug.file_messages_sent";
    }

    private static String __unused_1785() {
        return "sync_debug_sent";
    }

    private static String __unused_1786() {
        return "Sync.high.debug.dispatch";
    }

    private static String __unused_1787() {
        return "Sync.high.debug.file_dispatch";
    }

    private static String __unused_1788() {
        return "sync_debug_dispatch";
    }

    private static String __unused_1789() {
        return "bclans:tp-in";
    }

    private static String __unused_1790() {
        return "bclans:tp-out";
    }
}

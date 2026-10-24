package me.module.chat.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.chat.Chat;
import me.module.chat.commands.ChatCommand;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanChatEvent;
import me.ulrich.clans.interfaces.MultiserverModuleAPI;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.StandardTags;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/manager/a.class */
public class a {
    private static byte[] __aes_key_d4ZddiDo = {(byte) 87, (byte) 240, (byte) 3, (byte) 48, (byte) 44, (byte) 28, (byte) 130, (byte) 186, (byte) 67, (byte) 233, (byte) 190, (byte) 140, (byte) 114, (byte) 3, (byte) 117, (byte) 192, (byte) 67, (byte) 178, (byte) 231, (byte) 235, (byte) 254, (byte) 3, (byte) 148, (byte) 194, (byte) 90, (byte) 2, (byte) 18, (byte) 227, (byte) 121, (byte) 51, (byte) 199, (byte) 46};
    private static byte[] __aes_iv_RZoxRQBF = {(byte) 225, (byte) 40, (byte) 90, (byte) 152, (byte) 34, (byte) 88, (byte) 74, (byte) 66, (byte) 106, (byte) 14, (byte) 221, (byte) 243, (byte) 109, (byte) 234, (byte) 73, (byte) 42};
    private static String __s_cache_gJHs4ZyC_0;
    private static String __s_cache_8wpgpNGk_1;
    private static String __s_cache_5APsStO9_2;
    private static String __s_cache_O8EvhGQq_3;
    private static String __s_cache_UKiLcaRU_4;
    private static String __s_cache_fKuLejAF_5;
    private static String __s_cache_WaXq3QTl_6;
    private static String __s_cache_BLj7GH8N_7;
    private static String __s_cache_V5q1fcDy_8;
    private static String __s_cache_AYfoHZwv_9;
    private static String __s_cache_zhCQb0pW_10;
    private static String __s_cache_cRDlIHNT_11;
    private static String __s_cache_EdCzcAqw_12;
    private static String __s_cache_Y1BDTMZO_13;
    private static String __s_cache_ZmrL6PUd_14;
    private static String __s_cache_FgTKedXB_15;
    private static String __s_cache_9jafbUzx_16;
    private static String __s_cache_kCMbOkcZ_17;
    private static String __s_cache_6KsIuiGq_18;
    private static String __s_cache_Ls9SOoy9_19;
    private static String __s_cache_mOnJ42SU_20;
    private static String __s_cache_JxC32lEj_21;
    private static String __s_cache_iaTDQrGL_22;
    private static String __s_cache_Qal9uaZc_23;
    private static String __s_cache_yDN1M89c_24;
    private static String __s_cache_KTvwANHg_25;
    private static String __s_cache_4V5whrUN_26;

    public static void a(Player player, String str, boolean z) {
        a(player.getUniqueId(), str, z);
    }

    public static void a(UUID uuid, String str, boolean z) {
        String legacytoCode = Chat.b().getColorAPI().parseLegacytoCode(str);
        Chat.getModuleCore().e().runTask(() -> {
            Optional<ClanData> playerClan = Chat.b().getPlayerAPI().getPlayerClan(uuid);
            if (playerClan.isPresent()) {
                ClanData clanData = playerClan.get();
                ArrayList arrayList = new ArrayList();
                ArrayList<Player> arrayList2 = new ArrayList();
                try {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        if (Chat.b().getClanAPI().getChatspy().contains(player.getUniqueId())) {
                            arrayList2.add(player);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (clanData.getSettings().isAllySharedChat()) {
                        List<UUID> ally = clanData.getRivalAlly().getAlly();
                        if (!ally.isEmpty()) {
                            for (UUID uuid2 : ally) {
                                if (Chat.b().getClanAPI().clanExists(uuid2)) {
                                    Optional<ClanData> clan = Chat.b().getClanAPI().getClan(uuid2);
                                    if (clan.isPresent() && clan.get().getSettings().isAllySharedChat()) {
                                        arrayList.addAll(clan.get().getMembers());
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                arrayList.addAll(clanData.getOnlineMembers());
                String strA = "";
                if (!arrayList.isEmpty()) {
                    strA = a(uuid, legacytoCode);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        MessageUtils.sendText((UUID) it.next(), strA);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String string = Chat.getModuleCore().d().g().getString("Clan.chat.spy_tag", "[Spy] ");
                    String strA2 = a(uuid, legacytoCode);
                    for (Player player2 : arrayList2) {
                        if (!arrayList.contains(player2.getUniqueId())) {
                            MessageUtils.sendText((CommandSender) player2, string + strA2);
                        }
                    }
                }
                if (strA.isEmpty()) {
                    return;
                }
                FileConfiguration fileConfigurationG = Chat.getModuleCore().d().g();
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("clan_id", clanData.getId().toString());
                    jSONObject.put("sender", uuid.toString());
                    jSONObject.put("message", legacytoCode);
                    Optional<MultiserverModuleAPI> multiserverAPI = Chat.b().getIntegrationAPI().getMultiserverAPI();
                    if (multiserverAPI.isPresent()) {
                        multiserverAPI.get().sendSync(ClanEnum.RedisType.CLANCHAT.toString(), jSONObject.toString());
                    }
                }
                if (fileConfigurationG.getBoolean("Clan.chat.console_chat")) {
                    MessageUtils.sendText((CommandSender) Bukkit.getConsoleSender(), strA);
                }
                Bukkit.getPluginManager().callEvent(new ClanChatEvent(clanData.getId(), uuid, strA, legacytoCode));
            }
        });
    }

    public static String a(UUID uuid, String str) {
        FileConfiguration fileConfigurationG = Chat.getModuleCore().d().g();
        String string = fileConfigurationG.getString("Clan.chat.format");
        if (string != null) {
            string = string.replace("<reset>", "");
        }
        if (fileConfigurationG.getStringList("Clan.chat.disabled_decoration").size() > 0) {
            string = Chat.b().getColorAPI().removeDecoration(string, fileConfigurationG.getStringList("Clan.chat.disabled_decoration"));
        }
        if (!fileConfigurationG.getBoolean("Clan.chat.enable_colors")) {
            str = Chat.b().getColorAPI().removeColor(str);
        } else if (str != null) {
            str = MiniMessage.miniMessage().serialize(MiniMessage.builder().tags(TagResolver.builder().resolver(StandardTags.color()).resolver(StandardTags.decorations()).build()).build2().deserialize(str));
        }
        Optional<PlayerData> playerData = Chat.b().getPlayerAPI().getPlayerData(uuid);
        if (playerData.isPresent()) {
            string = string.replace("%player%", playerData.get().getName());
        }
        if (str != null) {
            string = string.replace("%chat_message%", str);
        }
        return Chat.b().getClanAPI().parseText(uuid, string);
    }

    public static void a() {
        FileConfiguration fileConfigurationH = Chat.getModuleCore().d().h();
        String string = fileConfigurationH.getString("Commands.player.alias");
        Chat.b().getCommandAPI().unRegisterCommand("chat");
        Chat.b().getCommandAPI().unRegisterCommand(string);
        Chat.b().getCommandAPI().registerCommand("chat", new ChatCommand());
        Chat.b().getCommandAPI().registerCommand(string, new ChatCommand());
        Chat.b().getCommandAPI().getCommandAliases().put("chat", string);
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList(new String[0])) {
                if (fileConfigurationH.contains("Commands.chat." + str)) {
                    if (!Chat.b().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Chat.b().getCommandAPI().getCommandAliases().put(str, fileConfigurationH.getString("Commands.chat." + str + ".aliases"));
                    }
                    map.put(str, new CommandData_show(a(fileConfigurationH.getString("Commands.chat." + str + ".show")), a(fileConfigurationH.getString("Commands.chat." + str + ".success")), a(fileConfigurationH.getString("Commands.chat." + str + ".error")), a(fileConfigurationH.getString("Commands.chat." + str + ".usage"))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Chat.b().getCommandAPI().insertCommand("chat", fileConfigurationH.getString("Commands.player.permission"), string, fileConfigurationH.getDouble("Commands.player.value"), fileConfigurationH.getInt("Commands.player.cooldown"), new CommandData_show(a(fileConfigurationH.getString("Commands.chat.help.show")), a(fileConfigurationH.getString("Commands.chat.help.success")), a(fileConfigurationH.getString("Commands.chat.help.error")), a(fileConfigurationH.getString("Commands.chat.help.usage"))), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(fileConfigurationH.getStringList("Commands.player.disabled_worlds"), fileConfigurationH.getStringList("Commands.player.disabled_regions")));
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        return Chat.b().getCommandAPI().replaceCmd(Chat.b().getCommandAPI().replaceMainCmd(str));
    }

    private static String __unused_527() {
        return "Clan.chat.format";
    }

    private static String __unused_528() {
        return "<reset>";
    }

    private static String __unused_529() {
        return "Clan.chat.disabled_decoration";
    }

    private static String __unused_530() {
        return "Clan.chat.disabled_decoration";
    }

    private static String __unused_531() {
        return "Clan.chat.enable_colors";
    }

    private static String __unused_532() {
        return "%player%";
    }

    private static String __unused_533() {
        return "%chat_message%";
    }

    private static String __unused_534() {
        return "Commands.player.alias";
    }

    private static String __unused_535() {
        return "chat";
    }

    private static String __unused_536() {
        return "chat";
    }

    private static String __unused_537() {
        return "chat";
    }

    private static String __unused_538() {
        return "chat";
    }

    private static String __unused_539() {
        return "Commands.player.permission";
    }

    private static String __unused_540() {
        return "Commands.player.value";
    }

    private static String __unused_541() {
        return "Commands.player.cooldown";
    }

    private static String __unused_542() {
        return "Commands.chat.help.show";
    }

    private static String __unused_543() {
        return "Commands.chat.help.success";
    }

    private static String __unused_544() {
        return "Commands.chat.help.error";
    }

    private static String __unused_545() {
        return "Commands.chat.help.usage";
    }

    private static String __unused_546() {
        return "Commands.player.disabled_worlds";
    }

    private static String __unused_547() {
        return "Commands.player.disabled_regions";
    }

    private static String __unused_548() {
        return "Clan.chat.spy_tag";
    }

    private static String __unused_549() {
        return "[Spy] ";
    }

    private static String __unused_550() {
        return "clan_id";
    }

    private static String __unused_551() {
        return "sender";
    }

    private static String __unused_552() {
        return "message";
    }

    private static String __unused_553() {
        return "Clan.chat.console_chat";
    }
}

package me.module.discord.manager;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.discord.Discord;
import me.module.discord.commands.AdminCommand;
import me.module.discord.commands.DiscordCommand;
import me.module.discord.data.ChatMessageDTO;
import me.module.discord.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/DiscordPublicManager.class */
public class DiscordPublicManager {
    private static Map<UUID, ClanWebSocketClient> conexoesDosClas = new ConcurrentHashMap();
    private static final Pattern UCLANS_PATTERN = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static void initiate() {
        registerIcon();
        registerCommand();
        applyPermissions();
    }

    public static ClanWebSocketClient getClienteDoCla(UUID uuid) {
        return conexoesDosClas.get(uuid);
    }

    public static void adicionarConexao(UUID uuid, ClanWebSocketClient clanWebSocketClient) {
        conexoesDosClas.put(uuid, clanWebSocketClient);
    }

    public static void removerConexao(UUID uuid) {
        ClanWebSocketClient clanWebSocketClientRemove = conexoesDosClas.remove(uuid);
        if (clanWebSocketClientRemove != null) {
            clanWebSocketClientRemove.setDesconexaoIntencional(true);
            if (clanWebSocketClientRemove.isOpen()) {
                clanWebSocketClientRemove.close();
            }
        }
    }

    public static Map<UUID, ClanWebSocketClient> getConexoesDosClas() {
        return conexoesDosClas;
    }

    public static ClanWebSocketClient getClanConnection(UUID uuid) {
        ClanWebSocketClient clienteDoCla = getClienteDoCla(uuid);
        if (clienteDoCla == null || !clienteDoCla.isOpen()) {
            return null;
        }
        return clienteDoCla;
    }

    public static boolean isConnectedClan(UUID uuid) {
        ClanWebSocketClient clienteDoCla = getClienteDoCla(uuid);
        return clienteDoCla != null && clienteDoCla.isOpen();
    }

    public static boolean sendDiscordChat(UUID uuid, UUID uuid2, String str, boolean z) {
        ClanWebSocketClient clienteDoCla;
        if (uuid == null || (clienteDoCla = getClienteDoCla(uuid)) == null || !clienteDoCla.isOpen()) {
            return false;
        }
        Optional<ClanData> clan = Discord.b().getClanAPI().getClan(uuid);
        Optional<PlayerData> playerData = Discord.b().getPlayerAPI().getPlayerData(uuid2);
        if (!clan.isPresent() || !playerData.isPresent()) {
            return false;
        }
        if (z && !playerData.get().isLockedChat()) {
            return false;
        }
        clienteDoCla.send("DISCORD_CHAT|" + new Gson().toJson(new ChatMessageDTO(playerData.get().getId().toString(), playerData.get().getName(), (String) Discord.b().getModAPI().getPlayerRole(uuid2).map(moderationData -> {
            return Discord.b().getColorAPI().removeColor(moderationData.getName());
        }).orElse(""), Discord.b().getColorAPI().removeColor(str), Discord.b().getServerName())));
        return true;
    }

    public static boolean sendDiscordNotification(UUID uuid, String str) {
        ClanWebSocketClient clienteDoCla = getClienteDoCla(uuid);
        if (clienteDoCla == null || !clienteDoCla.isOpen()) {
            return false;
        }
        clienteDoCla.send("SEND_NOTIFICATION|" + uuid.toString() + "|" + Discord.b().getColorAPI().removeColor(str));
        return true;
    }

    public static boolean registerClan(UUID uuid) {
        return registerClan(uuid, false);
    }

    public static boolean registerClan(UUID uuid, boolean z) {
        if (uuid == null) {
            return false;
        }
        synchronized (uuid.toString().intern()) {
            ClanWebSocketClient clanWebSocketClient = getConexoesDosClas().get(uuid);
            if (clanWebSocketClient != null) {
                String strName = clanWebSocketClient.getReadyState() != null ? clanWebSocketClient.getReadyState().name() : "UNKNOWN";
                if (clanWebSocketClient.isOpen() || strName.equals("CONNECTING")) {
                    return false;
                }
                clanWebSocketClient.fecharIntencionalmente();
                getConexoesDosClas().remove(uuid);
            }
            String string = uuid.toString();
            HashMap map = new HashMap();
            map.put("Server-Client", Discord.b().getResourceAgent() + "-" + Discord.b().getResourceUid());
            map.put("Clan-Token", string);
            ClanWebSocketClient clanWebSocketClient2 = new ClanWebSocketClient(c.a(), map, string);
            clanWebSocketClient2.setConexaoSilenciosa(z);
            getConexoesDosClas().put(uuid, clanWebSocketClient2);
            clanWebSocketClient2.connect();
            return true;
        }
    }

    public static void unlinkDiscordChannel(UUID uuid) {
        ClanWebSocketClient clienteDoCla = getClienteDoCla(uuid);
        if (clienteDoCla == null || !clienteDoCla.isOpen()) {
            return;
        }
        clienteDoCla.send("UNLINK_CLAN|" + uuid.toString());
        clienteDoCla.setVinculado(false);
    }

    public static boolean unregisterClan(UUID uuid) {
        if (uuid == null) {
            return false;
        }
        synchronized (uuid.toString().intern()) {
            ClanWebSocketClient clienteDoCla = getClienteDoCla(uuid);
            if (clienteDoCla == null) {
                return false;
            }
            if (clienteDoCla.isOpen()) {
                clienteDoCla.send("DELETE_VINCULO|" + uuid.toString());
            }
            clienteDoCla.setDesconexaoIntencional(true);
            clienteDoCla.close();
            getConexoesDosClas().remove(uuid);
            return true;
        }
    }

    public static boolean registerClient(final String str, final Consumer<String> consumer) {
        if (str == null || !str.matches("\\d{17,20}")) {
            if (consumer == null) {
                return false;
            }
            consumer.accept("CLIENT_REGISTER_ERROR|INVALID_DISCORD_ID");
            return false;
        }
        final String str2 = Discord.b().getResourceAgent() + "-" + Discord.b().getResourceUid();
        HashMap map = new HashMap();
        map.put("Server-Client", str2);
        try {
            new WebSocketClient(c.a(), map) { // from class: me.module.discord.manager.DiscordPublicManager.1
                @Override // org.java_websocket.client.WebSocketClient
                public void onOpen(ServerHandshake serverHandshake) {
                    send("REGISTER_CLIENT|" + str + "|" + str2);
                }

                @Override // org.java_websocket.client.WebSocketClient
                public void onMessage(String str3) {
                    if (consumer != null) {
                        consumer.accept(str3);
                    }
                    close();
                }

                @Override // org.java_websocket.client.WebSocketClient
                public void onClose(int i, String str3, boolean z) {
                }

                @Override // org.java_websocket.client.WebSocketClient
                public void onError(Exception exc) {
                    if (consumer != null) {
                        consumer.accept("CLIENT_REGISTER_ERROR|CONNECTION_ERROR");
                    }
                    try {
                        close();
                    } catch (Exception e) {
                    }
                }
            }.connect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (consumer == null) {
                return false;
            }
            consumer.accept("CLIENT_REGISTER_ERROR|CONNECTION_ERROR");
            return false;
        }
    }

    public static String parseText(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Discord.getModuleCore().i().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = UCLANS_PATTERN.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Discord.getModuleCore().i().a(uuid, matcher.group(3));
                if (strA2 != null) {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strA2));
                } else {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(matcher.group(0)));
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static CommandData_show buildLocalizedCommandShow(String str, String str2) {
        HashMap map = new HashMap();
        String str3 = "COMMANDS_" + str + "_" + str2 + "_";
        Discord.getModuleCore().d().e().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(replaceCmd(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), replaceCmd(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), replaceCmd(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), replaceCmd(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Discord.getModuleCore().d().a(Optional.empty()));
        if (commandData_show == null) {
            commandData_show = (CommandData_show) map.get("EN");
        }
        if (commandData_show == null && !map.isEmpty()) {
            commandData_show = (CommandData_show) map.values().iterator().next();
        }
        if (commandData_show == null) {
            commandData_show = new CommandData_show("", "", "", "");
        }
        CommandData_show commandData_show2 = new CommandData_show(commandData_show.getOn_help(), commandData_show.getOn_success(), commandData_show.getOn_error(), commandData_show.getOn_usage());
        MessageUtils.registerLocalizedCommandShow(commandData_show2, map);
        return commandData_show2;
    }

    public static void registerCommand() {
        AdminCommand.getInstance();
        Discord.b().getCommandAPI().unRegisterCommand("discord");
        Discord.b().getCommandAPI().unRegisterCommand(Discord.getModuleCore().d().j().getString("Commands.player.alias"));
        Discord.b().getCommandAPI().registerCommand("discord", new DiscordCommand());
        Discord.b().getCommandAPI().registerCommand(Discord.getModuleCore().d().j().getString("Commands.player.alias"), new DiscordCommand());
        Discord.b().getCommandAPI().getCommandAliases().put("discord", Discord.getModuleCore().d().j().getString("Commands.player.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("register", "unregister", "register_client")) {
                if (Discord.getModuleCore().d().j().contains("Commands.discord." + str)) {
                    if (!Discord.b().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Discord.b().getCommandAPI().getCommandAliases().put(str, Discord.getModuleCore().d().j().getString("Commands.discord." + str + ".aliases"));
                    }
                    map.put(str, buildLocalizedCommandShow("discord", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Discord.b().getCommandAPI().insertCommand("discord", Discord.getModuleCore().d().j().getString("Commands.player.permission"), Discord.getModuleCore().d().j().getString("Commands.player.alias"), Discord.getModuleCore().d().j().getDouble("Commands.player.value"), Discord.getModuleCore().d().j().getInt("Commands.player.cooldown"), buildLocalizedCommandShow("discord", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Discord.getModuleCore().d().j().getStringList("Commands.player.disabled_worlds"), Discord.getModuleCore().d().j().getStringList("Commands.player.disabled_regions")));
    }

    public static void registerIcon() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Discord.b());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Discord.getModuleCore().d().i().contains("Config.Icon.mimeslots")) {
                if (Discord.getModuleCore().d().i().getStringList("Config.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Discord.getModuleCore().d().i().getStringList("Config.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Discord.getModuleCore().d().i().getStringList("Config.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Discord.getModuleCore().d().i().getStringList("Config.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Discord.getModuleCore().d().i().getIntegerList("Config.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Discord.getModuleCore().d().i().contains("Config.Icon.left_click_action")) {
                Discord.getModuleCore().d().i().getStringList("Config.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(replaceCmd(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Discord.getModuleCore().d().i().contains("Config.Icon.right_click_action")) {
                Discord.getModuleCore().d().i().getStringList("Config.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(replaceCmd(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Discord.getModuleCore().d().e().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Discord.getModuleCore().d().a(Optional.empty());
        map.put("module_discord_item", new GuiItemsData(Discord.getModuleCore().d().i().getString("Config.Icon.page"), Discord.getModuleCore().d().i().getString("Config.Icon.click_sound"), Discord.getModuleCore().d().i().getString("Config.Icon.material"), 1, Discord.getModuleCore().d().i().getBoolean("Config.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Discord webhook.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Discord.getModuleCore().d().i().getString("Config.Icon.texture"), new NbtData(Discord.getModuleCore().d().i().getStringList("Config.Icon.nbt.string"), Discord.getModuleCore().d().i().getInt("Config.Icon.model")), Discord.getModuleCore().d().i().getInt("Config.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Discord.b().getGuiAPI().registerLocalizedInsertItem("General", "module_discord_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    private static String replaceCmd(String str) {
        return Discord.b().getCommandAPI().replaceCmd(Discord.b().getCommandAPI().replaceMainCmd(str));
    }

    public static void disconnectALL() {
        if (getConexoesDosClas() != null) {
            for (ClanWebSocketClient clanWebSocketClient : getConexoesDosClas().values()) {
                if (clanWebSocketClient != null) {
                    clanWebSocketClient.setDesconexaoIntencional(true);
                    try {
                        clanWebSocketClient.close();
                    } catch (Exception e) {
                    }
                }
            }
            getConexoesDosClas().clear();
        }
        if (ClanWebSocketClient.reconnectTimer != null) {
            ClanWebSocketClient.reconnectTimer.shutdownNow();
        }
        if (getConexoesDosClas() == null || getConexoesDosClas().isEmpty()) {
            return;
        }
        getConexoesDosClas().values().forEach(clanWebSocketClient2 -> {
            if (clanWebSocketClient2 != null) {
                try {
                    clanWebSocketClient2.fecharIntencionalmente();
                } catch (Exception e2) {
                }
            }
        });
        getConexoesDosClas().clear();
    }

    public static void applyPermissions() {
        ConfigurationSection configurationSection = Discord.getModuleCore().d().i().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Discord.getModuleCore().d().i().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Discord.getModuleCore().d().i().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Discord.getModuleCore().d().i().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Discord.b().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Discord.b().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }
}

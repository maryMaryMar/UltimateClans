package me.module.discord.manager;

import com.google.gson.Gson;
import java.net.URI;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import me.module.discord.Discord;
import me.module.discord.data.ChatMessageDTO;
import me.module.discord.data.ModuleEnum;
import me.module.discord.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.handshake.ServerHandshake;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/ClanWebSocketClient.class */
public class ClanWebSocketClient extends WebSocketClient {
    private String tokenUtilizado;
    private boolean tentouRegistrar;
    private boolean vinculado;
    private boolean desconexaoIntencional;
    private boolean conexaoSilenciosa;
    private volatile boolean planoSuspenso;
    private volatile boolean avisoPlanoEnviado;
    private volatile boolean retryPlanoAgendado;
    private static final long PLAN_RETRY_SECONDS = 60;
    private int tentativas;
    private static final Map<String, Long> lastLogTimestamp = new ConcurrentHashMap();
    public static ScheduledExecutorService reconnectTimer = Executors.newSingleThreadScheduledExecutor();

    private static synchronized ScheduledExecutorService getReconnectTimer() {
        if (reconnectTimer == null || reconnectTimer.isShutdown() || reconnectTimer.isTerminated()) {
            reconnectTimer = Executors.newSingleThreadScheduledExecutor();
        }
        return reconnectTimer;
    }

    public void setConexaoSilenciosa(boolean z) {
        this.conexaoSilenciosa = z;
    }

    public void setDesconexaoIntencional(boolean z) {
        this.desconexaoIntencional = z;
    }

    public void setVinculado(boolean z) {
        this.vinculado = z;
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        this.tentativas = 0;
        send("AUTH_TOKEN|" + this.tokenUtilizado);
        lastLogTimestamp.remove(this.tokenUtilizado);
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(String str) {
        String string;
        String string2;
        if (Discord.getModuleCore() == null || !Discord.getModuleCore().isEnabled()) {
            this.desconexaoIntencional = true;
            try {
                close();
            } catch (Exception e) {
            }
            try {
                UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
                if (Discord.b().getClanAPI().clanExists(uuidFromString)) {
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString, Discord.getModuleCore().d().c().getString(Lang.CLAN_WAIT_ENABLE));
                }
                return;
            } catch (Exception e2) {
                return;
            }
        }
        if (str.equals("AUTH_SUCCESS")) {
            boolean z = this.planoSuspenso;
            limparSuspensaoPlano();
            this.vinculado = true;
            if (z) {
                avisarPlanoRestaurado();
            }
            if (this.conexaoSilenciosa) {
                try {
                    Optional<ClanData> clan = Discord.b().getClanAPI().getClan(UUID.fromString(this.tokenUtilizado));
                    if (clan.isPresent()) {
                        clan.get().setWebhook(ModuleEnum.Webhook.CONNECTED.toString());
                        Discord.b().getClanAPI().saveClanData(clan.get());
                    }
                    return;
                } catch (Exception e3) {
                    return;
                }
            }
            try {
                UUID uuidFromString2 = UUID.fromString(this.tokenUtilizado);
                Optional<ClanData> clan2 = Discord.b().getClanAPI().getClan(uuidFromString2);
                if (clan2.isPresent()) {
                    clan2.get().setWebhook(ModuleEnum.Webhook.CONNECTED.toString());
                    Discord.b().getClanAPI().saveClanData(clan2.get());
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString2, Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ALREADY_CONNECTED).replace("%UUID%", uuidFromString2.toString()));
                }
                return;
            } catch (Exception e4) {
                return;
            }
        }
        if (str.equals("WAITING_DISCORD_LINK")) {
            boolean z2 = this.planoSuspenso;
            limparSuspensaoPlano();
            this.vinculado = false;
            if (z2) {
                avisarPlanoRestaurado();
            }
            if (this.conexaoSilenciosa) {
                try {
                    Optional<ClanData> clan3 = Discord.b().getClanAPI().getClan(UUID.fromString(this.tokenUtilizado));
                    if (clan3.isPresent()) {
                        clan3.get().setWebhook(ModuleEnum.Webhook.CONNECTED.toString());
                        Discord.b().getClanAPI().saveClanData(clan3.get());
                    }
                    return;
                } catch (Exception e5) {
                    return;
                }
            }
            try {
                UUID uuidFromString3 = UUID.fromString(this.tokenUtilizado);
                Optional<ClanData> clan4 = Discord.b().getClanAPI().getClan(uuidFromString3);
                if (clan4.isPresent()) {
                    clan4.get().setWebhook(ModuleEnum.Webhook.CONNECTED.toString());
                    Discord.b().getClanAPI().saveClanData(clan4.get());
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString3, Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_GETLINK).replace("%UUID%", uuidFromString3.toString()));
                }
                return;
            } catch (Exception e6) {
                return;
            }
        }
        if (str.startsWith("CLAN_LIMIT_REACHED|") || str.startsWith("CLAN_ACCESS_SUSPENDED|")) {
            tratarSuspensaoPlano(str);
            return;
        }
        if (str.equals("DELETE_SUCCESS")) {
            UUID uuidFromString4 = UUID.fromString(this.tokenUtilizado);
            if (Discord.b().getClanAPI().clanExists(uuidFromString4)) {
                Discord.b().getClanAPI().clanMessageSend(uuidFromString4, Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_INTEGRATION_REMOVED));
            }
            setDesconexaoIntencional(true);
            close(CloseFrame.NORMAL, "Unlinked successfully");
            return;
        }
        if (str.startsWith("DISCORD_CHAT|")) {
            try {
                ChatMessageDTO chatMessageDTO = (ChatMessageDTO) new Gson().fromJson(str.substring("DISCORD_CHAT|".length()), ChatMessageDTO.class);
                UUID uuidFromString5 = null;
                try {
                    uuidFromString5 = UUID.fromString(this.tokenUtilizado);
                } catch (Exception e7) {
                }
                if (uuidFromString5 != null && Discord.b().getClanAPI().getClan(uuidFromString5).isPresent()) {
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString5, Discord.getModuleCore().d().i().getString("Config.Discord.message_format").replace("{player}", chatMessageDTO.getNickname()).replace("{message}", chatMessageDTO.getMessage()).replace("{role}", chatMessageDTO.getRole()).replace("{server}", chatMessageDTO.getServer()).replace("{uuid}", chatMessageDTO.getUuid()));
                }
                return;
            } catch (Exception e8) {
                return;
            }
        }
        if (str.startsWith("COOLDOWN_WARNING|")) {
            String str2 = str.split("\\|")[1];
            UUID uuidFromString6 = UUID.fromString(this.tokenUtilizado);
            if (Discord.b().getClanAPI().clanExists(uuidFromString6)) {
                Discord.b().getClanAPI().clanMessageSend(uuidFromString6, Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_MESSAGE_BLOCKED, Arrays.asList("{seconds};" + str2)));
                return;
            }
            return;
        }
        if (str.startsWith("LINK_SUCCESSFUL")) {
            this.vinculado = true;
            String[] strArrSplit = str.split("\\|");
            String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "DESCONHECIDO";
            try {
                UUID uuidFromString7 = UUID.fromString(this.tokenUtilizado);
                if (Discord.b().getClanAPI().clanExists(uuidFromString7)) {
                    if (str3.equals("NOTIFICATION")) {
                        string2 = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_LINK_NOTIFICATION_SUCCESS);
                    } else {
                        string2 = str3.equals("CHAT") ? Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_LINK_CHAT_SUCCESS) : Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_LINK_GENERAL_SUCCESS);
                    }
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString7, string2);
                }
                return;
            } catch (Exception e9) {
                return;
            }
        }
        if (str.startsWith("UNLINK_SUCCESS")) {
            this.vinculado = false;
            String[] strArrSplit2 = str.split("\\|");
            String str4 = strArrSplit2.length > 1 ? strArrSplit2[1] : "DESCONHECIDO";
            try {
                UUID uuidFromString8 = UUID.fromString(this.tokenUtilizado);
                if (Discord.b().getClanAPI().clanExists(uuidFromString8)) {
                    if (str4.equals("NOTIFICATION")) {
                        string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_UNLINK_NOTIFICATION_SUCCESS);
                    } else {
                        string = str4.equals("CHAT") ? Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_UNLINK_CHAT_SUCCESS) : Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_UNLINK_GENERAL_SUCCESS);
                    }
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString8, string);
                }
            } catch (Exception e10) {
            }
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        if (i != 4003) {
            if (this.desconexaoIntencional) {
                return;
            }
            if (i != 4008 && !this.planoSuspenso) {
                iniciarTentativaDeReconexao();
                return;
            }
            this.planoSuspenso = true;
            this.vinculado = false;
            if (!this.avisoPlanoEnviado) {
                avisarPlanoSuspenso("?");
            }
            iniciarTentativaDeReconexaoPlano();
            return;
        }
        setDesconexaoIntencional(true);
        try {
            UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
            if (Discord.b().getClanAPI().clanExists(uuidFromString)) {
                String string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ERROR_CONNECTION_REFUSED);
                if (str != null) {
                    if (str.contains("Unauthorized Client ID.")) {
                        string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ERROR_CONNECTION_NOT_REGISTERED);
                    } else if (str.contains("Connection limit per IP exceeded.")) {
                        string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ERROR_CONNECTION_IP_LIMIT);
                    } else if (str.contains("IP temporarily banned for abuse.")) {
                        string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ERROR_CONNECTION_IP_BANNED);
                    } else if (str.contains("Required headers are missing.")) {
                        string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ERROR_CONNECTION_INTERNAL);
                    } else if (str.contains("Client unregistered")) {
                        string = Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_ERROR_CONNECTION_DEREGISTERED);
                    }
                }
                Discord.b().getClanAPI().clanMessageSend(uuidFromString, string);
                Optional<ClanData> clan = Discord.b().getClanAPI().getClan(uuidFromString);
                if (clan.isPresent()) {
                    clan.get().setWebhook(ModuleEnum.Webhook.DISCONNECTED.toString());
                    Discord.b().getClanAPI().saveClanData(clan.get());
                }
                DiscordPublicManager.unregisterClan(uuidFromString);
            }
        } catch (Exception e) {
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onError(Exception exc) {
        if (exc.getMessage() == null || !exc.getMessage().contains("zip file closed")) {
            try {
                UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
                if (Discord.b().getClanAPI().clanExists(uuidFromString)) {
                    Discord.b().getClanAPI().clanMessageSend(uuidFromString, Discord.getModuleCore().d().c().getString(Lang.HELP_CLAN_DISCORD_LINK_SEND_ERROR));
                }
            } catch (Exception e) {
            }
        }
    }

    public ClanWebSocketClient(URI uri, Map<String, String> map, String str) {
        super(uri, map);
        this.tentouRegistrar = false;
        this.vinculado = false;
        this.desconexaoIntencional = false;
        this.conexaoSilenciosa = false;
        this.planoSuspenso = false;
        this.avisoPlanoEnviado = false;
        this.retryPlanoAgendado = false;
        this.tentativas = 0;
        this.tokenUtilizado = str;
    }

    private void iniciarTentativaDeReconexao() {
        if (Discord.getModuleCore().isEnabled()) {
            try {
                UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
                if (!Discord.b().getClanAPI().clanExists(uuidFromString)) {
                    DiscordPublicManager.removerConexao(uuidFromString);
                    return;
                }
                ClanWebSocketClient clienteDoCla = DiscordPublicManager.getClienteDoCla(uuidFromString);
                if (clienteDoCla == null || clienteDoCla == this) {
                    long jMin = (long) Math.min(Math.pow(2.0d, this.tentativas) * 5.0d, 60.0d);
                    this.tentativas++;
                    getReconnectTimer().schedule(() -> {
                        if (isOpen()) {
                            return;
                        }
                        try {
                            ClanWebSocketClient clienteDoCla2 = DiscordPublicManager.getClienteDoCla(UUID.fromString(this.tokenUtilizado));
                            if (clienteDoCla2 == null || clienteDoCla2 == this) {
                                reconnect();
                            }
                        } catch (Exception e) {
                        }
                    }, jMin, TimeUnit.SECONDS);
                }
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void tratarSuspensaoPlano(String str) {
        this.planoSuspenso = true;
        this.vinculado = false;
        String strTrim = "?";
        try {
            String[] strArrSplit = str.split("\\|", 2);
            if (strArrSplit.length > 1 && !strArrSplit[1].trim().isEmpty()) {
                strTrim = strArrSplit[1].trim();
            }
        } catch (Exception e) {
        }
        if (this.avisoPlanoEnviado) {
            return;
        }
        avisarPlanoSuspenso(strTrim);
    }

    private void avisarPlanoSuspenso(String str) {
        this.avisoPlanoEnviado = true;
        try {
            UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
            if (Discord.b().getClanAPI().clanExists(uuidFromString)) {
                Discord.b().getClanAPI().clanMessageSend(uuidFromString, "<green>[TribeSync Webhook] <red>Integration suspended: the subscription is not active or this clan is outside the current plan limit.<newline> <gray>- Current free clan limit: <aqua>" + str + "<red>.<newline> <gray>- The connection will be checked again automatically.");
            }
            Discord.getModuleCore().c().warning("[Discord] Clan " + this.tokenUtilizado + " suspended by WebSocket plan limit. Free limit: " + str);
        } catch (Exception e) {
        }
    }

    private void avisarPlanoRestaurado() {
        try {
            UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
            if (Discord.b().getClanAPI().clanExists(uuidFromString)) {
                Discord.b().getClanAPI().clanMessageSend(uuidFromString, "§a[Discord] TribeSync Webhook access restored. The clan connection is active again.");
            }
            Discord.getModuleCore().c().info("[Discord] Clan " + this.tokenUtilizado + " WebSocket access restored.");
        } catch (Exception e) {
        }
    }

    private void limparSuspensaoPlano() {
        this.planoSuspenso = false;
        this.retryPlanoAgendado = false;
        this.avisoPlanoEnviado = false;
    }

    private void iniciarTentativaDeReconexaoPlano() {
        if (Discord.getModuleCore() == null || !Discord.getModuleCore().isEnabled() || this.desconexaoIntencional || this.retryPlanoAgendado) {
            return;
        }
        this.retryPlanoAgendado = true;
        getReconnectTimer().schedule(() -> {
            this.retryPlanoAgendado = false;
            if (Discord.getModuleCore() == null || !Discord.getModuleCore().isEnabled() || this.desconexaoIntencional || isOpen()) {
                return;
            }
            try {
                UUID uuidFromString = UUID.fromString(this.tokenUtilizado);
                if (!Discord.b().getClanAPI().clanExists(uuidFromString)) {
                    DiscordPublicManager.removerConexao(uuidFromString);
                    return;
                }
                ClanWebSocketClient clienteDoCla = DiscordPublicManager.getClienteDoCla(uuidFromString);
                if (clienteDoCla == null || clienteDoCla == this) {
                    reconnect();
                }
            } catch (Exception e) {
                iniciarTentativaDeReconexaoPlano();
            }
        }, PLAN_RETRY_SECONDS, TimeUnit.SECONDS);
    }

    public boolean isTentouRegistrar() {
        return this.tentouRegistrar;
    }

    public boolean isVinculado() {
        return isOpen() && this.vinculado;
    }

    public void fecharIntencionalmente() {
        this.desconexaoIntencional = true;
        close();
    }
}

package me.module.multiserver.listeners;

import java.util.Optional;
import me.module.multiserver.Multiserver;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanMessageEvent;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/listeners/MultiserverListener.class */
public class MultiserverListener implements Listener {
    public MultiserverListener() {
        Multiserver.getModuleCore().f().add(this);
    }

    @EventHandler
    public void onClanMessageEvent(ClanMessageEvent clanMessageEvent) {
        if (clanMessageEvent.getMessage() == null || clanMessageEvent.getMessage().isEmpty()) {
            return;
        }
        if (clanMessageEvent.isToBroadcast()) {
            MessageUtils.sendBroadcast(clanMessageEvent.getMessage());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("toClan", "false");
            jSONObject.put("toBroadcast", "true");
            jSONObject.put("toPlayer", "false");
            jSONObject.put(ComponentTreeConstants.SHOW_ENTITY_UUID, "");
            jSONObject.put("message", clanMessageEvent.getMessage());
            Multiserver.getModuleCore().e().sendSync(ClanEnum.RedisType.EVENTMESSAGES.toString(), jSONObject.toString());
            return;
        }
        if (clanMessageEvent.isToClan()) {
            Optional<ClanData> clan = Multiserver.a().getClanAPI().getClan(clanMessageEvent.getUuid());
            if (clan.isPresent()) {
                MessageUtils.clanMessageSend(clan.get(), clanMessageEvent.getMessage());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("toClan", "true");
                jSONObject2.put("toBroadcast", "false");
                jSONObject2.put("toPlayer", "false");
                jSONObject2.put(ComponentTreeConstants.SHOW_ENTITY_UUID, clan.get().getId().toString());
                jSONObject2.put("message", clanMessageEvent.getMessage());
                Multiserver.getModuleCore().e().sendSync(ClanEnum.RedisType.EVENTMESSAGES.toString(), jSONObject2.toString());
                return;
            }
            return;
        }
        if (clanMessageEvent.isToPlayer()) {
            Optional<PlayerData> playerData = Multiserver.a().getPlayerAPI().getPlayerData(clanMessageEvent.getUuid());
            if (playerData.isPresent()) {
                MessageUtils.sendText(clanMessageEvent.getUuid(), clanMessageEvent.getMessage());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("toClan", "false");
                jSONObject3.put("toBroadcast", "false");
                jSONObject3.put("toPlayer", "true");
                jSONObject3.put(ComponentTreeConstants.SHOW_ENTITY_UUID, playerData.get().getId().toString());
                jSONObject3.put("message", clanMessageEvent.getMessage());
                Multiserver.getModuleCore().e().sendSync(ClanEnum.RedisType.EVENTMESSAGES.toString(), jSONObject3.toString());
            }
        }
    }
}

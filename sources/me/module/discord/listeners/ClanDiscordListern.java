package me.module.discord.listeners;

import java.util.Iterator;
import java.util.List;
import me.module.discord.Discord;
import me.module.discord.data.ModuleEnum;
import me.module.discord.manager.DiscordPublicManager;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.events.ClanChatEvent;
import me.ulrich.clans.events.ClanDeleteEvent;
import me.ulrich.clans.events.ClanPluginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/listeners/ClanDiscordListern.class */
public class ClanDiscordListern implements Listener {
    public ClanDiscordListern() {
        Discord.getModuleCore().g().add(this);
    }

    @EventHandler
    public void onClanPluginEvent(ClanPluginEvent clanPluginEvent) {
        List<ClanData> allClansData = Discord.b().getClanAPI().getAllClansData();
        Discord.getModuleCore().e().runTaskAsynchronously(() -> {
            int i = 0;
            Iterator it = allClansData.iterator();
            while (it.hasNext()) {
                ClanData clanData = (ClanData) it.next();
                if (clanData.getWebhook() != null && ModuleEnum.Webhook.fromString(clanData.getWebhook()) == ModuleEnum.Webhook.CONNECTED) {
                    DiscordPublicManager.registerClan(clanData.getId(), true);
                    i++;
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
    }

    @EventHandler
    public void onClanChat(ClanChatEvent clanChatEvent) {
        DiscordPublicManager.sendDiscordChat(clanChatEvent.getClanID(), clanChatEvent.getSender(), clanChatEvent.getRawMessage(), true);
    }

    @EventHandler
    public void onDelete(ClanDeleteEvent clanDeleteEvent) {
        DiscordPublicManager.unregisterClan(clanDeleteEvent.getClanID());
    }
}

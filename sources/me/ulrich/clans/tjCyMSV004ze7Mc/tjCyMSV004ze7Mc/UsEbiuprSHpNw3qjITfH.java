package me.ulrich.clans.tjCyMSV004ze7Mc.tjCyMSV004ze7Mc;

import me.ulrich.clans.Clans;
import net.essentialsx.api.v2.events.chat.GlobalChatEvent;
import net.essentialsx.api.v2.events.chat.LocalChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/tjCyMSV004ze7Mc/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void v8qP8fE86HMhvNuYPFjqY(GlobalChatEvent globalChatEvent) {
        globalChatEvent.setFormat(Clans.getClanCore().getColorManager().b4i2FbOkaKeg91LiAe6l(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(globalChatEvent.getPlayer().getUniqueId(), globalChatEvent.getFormat())));
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void v8qP8fE86HMhvNuYPFjqY(LocalChatEvent localChatEvent) {
        localChatEvent.setFormat(Clans.getClanCore().getColorManager().b4i2FbOkaKeg91LiAe6l(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(localChatEvent.getPlayer().getUniqueId(), localChatEvent.getFormat())));
    }
}

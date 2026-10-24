package me.ulrich.clans.tjCyMSV004ze7Mc.tjCyMSV004ze7Mc;

import me.ulrich.clans.Clans;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/tjCyMSV004ze7Mc/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements Listener {
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void v8qP8fE86HMhvNuYPFjqY(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        asyncPlayerChatEvent.setFormat(Clans.getClanCore().getColorManager().b4i2FbOkaKeg91LiAe6l(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(asyncPlayerChatEvent.getPlayer().getUniqueId(), asyncPlayerChatEvent.getFormat())));
    }
}

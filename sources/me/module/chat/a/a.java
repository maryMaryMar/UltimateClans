package me.module.chat.a;

import me.module.chat.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.EventExecutor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/a/a.class */
public class a implements Listener, EventExecutor {
    private static byte[] __aes_key_3BhfH1yA = {(byte) 111, (byte) 215, (byte) 148, (byte) 137, (byte) 72, (byte) 229, (byte) 8, (byte) 213, (byte) 179, (byte) 194, (byte) 85, (byte) 182, (byte) 12, (byte) 107, (byte) 37, (byte) 143, (byte) 154, (byte) 88, (byte) 210, (byte) 139, (byte) 253, (byte) 165, (byte) 160, (byte) 23, (byte) 38, (byte) 108, (byte) 157, (byte) 122, (byte) 27, (byte) 41, (byte) 253, (byte) 51};
    private static byte[] __aes_iv_WmLglSdm = {(byte) 197, (byte) 114, (byte) 25, (byte) 201, (byte) 46, (byte) 103, (byte) 135, (byte) 19, (byte) 110, (byte) 146, (byte) 87, (byte) 27, (byte) 122, (byte) 236, (byte) 177, (byte) 22};
    private static String __s_cache_Ah8MIFA6_0;
    private static String __s_cache_m2P43nra_1;
    private static String __s_cache_3I8M5R3c_2;

    public a() {
        Chat.getModuleCore().a().add(this);
    }

    private void a(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        if (asyncPlayerChatEvent.getPlayer() instanceof Player) {
            Player player = asyncPlayerChatEvent.getPlayer();
            if (Chat.b().getPlayerAPI().hasClan(player.getUniqueId())) {
                if (Chat.b().getPlayerAPI().isLockedChat(player) || (!Chat.getModuleCore().d().g().getString("Clan.chat.shortcut").isEmpty() && asyncPlayerChatEvent.getMessage().startsWith(Chat.getModuleCore().d().g().getString("Clan.chat.shortcut")))) {
                    String message = asyncPlayerChatEvent.getMessage();
                    asyncPlayerChatEvent.setMessage("");
                    asyncPlayerChatEvent.setFormat("");
                    asyncPlayerChatEvent.setCancelled(true);
                    me.module.chat.manager.a.a(player, message.replaceFirst(Chat.getModuleCore().d().g().getString("Clan.chat.shortcut"), ""), false);
                }
            }
        }
    }

    public void execute(Listener listener, Event event) {
        if (listener == this && (event instanceof AsyncPlayerChatEvent)) {
            a((AsyncPlayerChatEvent) event);
        }
    }

    private static String __unused_554() {
        return "Clan.chat.shortcut";
    }

    private static String __unused_555() {
        return "Clan.chat.shortcut";
    }

    private static String __unused_556() {
        return "Clan.chat.shortcut";
    }
}

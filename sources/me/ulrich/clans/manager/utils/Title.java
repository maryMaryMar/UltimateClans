package me.ulrich.clans.manager.utils;

import java.time.Duration;
import me.ulrich.clans.Clans;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Title.class */
public class Title {
    public static void showTitle(Player player, String str, String str2) {
        if ((str == null || str.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return;
        }
        MiniMessage miniMessage = MiniMessage.miniMessage();
        Audience audiencePlayer = Clans.getClanCore().getAdventure().player(player);
        if (audiencePlayer == null || miniMessage == null) {
            return;
        }
        try {
            Component componentText = Component.text("");
            Component componentText2 = Component.text("");
            try {
                componentText = Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getHooksManager().parsePapi(player, Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str)));
            } catch (Exception e) {
            }
            try {
                componentText2 = Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getHooksManager().parsePapi(player, Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str2)));
            } catch (Exception e2) {
            }
            audiencePlayer.showTitle(me.ulrich.clans.library.kyori.adventure.title.Title.title(componentText, componentText2));
        } catch (Exception e3) {
        }
    }

    public static void showTimedTitle(Player player, String str, String str2, int i) {
        if ((str == null || str.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return;
        }
        me.ulrich.clans.library.kyori.adventure.title.Title.Times times = me.ulrich.clans.library.kyori.adventure.title.Title.Times.times(Duration.ofMillis(500L), Duration.ofMillis(((long) i) * 50), Duration.ofMillis(1000L));
        MiniMessage miniMessage = MiniMessage.miniMessage();
        Audience audiencePlayer = Clans.getClanCore().getAdventure().player(player);
        if (audiencePlayer == null || miniMessage == null) {
            return;
        }
        try {
            Component componentText = Component.text("");
            Component componentText2 = Component.text("");
            try {
                componentText = Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getHooksManager().parsePapi(player, Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str)));
            } catch (Exception e) {
            }
            try {
                componentText2 = Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getHooksManager().parsePapi(player, Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str2)));
            } catch (Exception e2) {
            }
            audiencePlayer.showTitle(me.ulrich.clans.library.kyori.adventure.title.Title.title(componentText, componentText2, times));
        } catch (Exception e3) {
        }
    }

    public static void resetTitle(Player player) {
        Audience audiencePlayer = Clans.getClanCore().getAdventure().player(player);
        if (audiencePlayer != null) {
            try {
                audiencePlayer.clearTitle();
            } catch (Exception e) {
            }
        }
    }
}

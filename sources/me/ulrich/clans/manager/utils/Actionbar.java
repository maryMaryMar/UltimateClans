package me.ulrich.clans.manager.utils;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Actionbar.class */
public class Actionbar {
    private static final Map<UUID, MyScheduledTask> ACTIONBAR_TASKS = new ConcurrentHashMap();

    public static void showActionbar(Player player, String str) {
        Audience audiencePlayer;
        if (player == null || !player.isOnline() || str == null || str.isEmpty() || (audiencePlayer = Clans.getClanCore().getAdventure().player(player)) == null) {
            return;
        }
        try {
            audiencePlayer.sendActionBar(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getHooksManager().parsePapi(player, Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showTimedActionbar(Player player, String str, int i) {
        if (player == null || !player.isOnline() || str == null || str.isEmpty() || i <= 0) {
            return;
        }
        MyScheduledTask myScheduledTaskRemove = ACTIONBAR_TASKS.remove(player.getUniqueId());
        if (myScheduledTaskRemove != null) {
            myScheduledTaskRemove.cancel();
        }
        int[] iArr = {i};
        ACTIONBAR_TASKS.put(player.getUniqueId(), Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskTimer((Entity) player, () -> {
            if (player.isOnline() && iArr[0] > 0) {
                showActionbar(player, str);
                iArr[0] = iArr[0] - 1;
            } else {
                MyScheduledTask myScheduledTaskRemove2 = ACTIONBAR_TASKS.remove(player.getUniqueId());
                if (myScheduledTaskRemove2 != null) {
                    myScheduledTaskRemove2.cancel();
                }
            }
        }, 0L, 20L));
    }

    public static void resetActionbar(Player player) {
        if (player == null) {
            return;
        }
        MyScheduledTask myScheduledTaskRemove = ACTIONBAR_TASKS.remove(player.getUniqueId());
        if (myScheduledTaskRemove != null) {
            myScheduledTaskRemove.cancel();
        }
        if (player.isOnline()) {
            Clans.getClanCore().getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player, () -> {
                Audience audiencePlayer = Clans.getClanCore().getAdventure().player(player);
                if (audiencePlayer != null) {
                    audiencePlayer.sendActionBar((Component) Component.empty());
                }
            });
        }
    }
}

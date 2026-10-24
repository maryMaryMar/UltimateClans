package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.BossBarData;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 {
    private final ConcurrentHashMap<UUID, BossBarData> v8qP8fE86HMhvNuYPFjqY = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UUID, MyScheduledTask> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private static final byte[] u1e7uZprkjwAms = {(byte) 170, (byte) 106, (byte) 46, (byte) 68, (byte) 47, (byte) 126, (byte) 98, (byte) 3, (byte) 64, (byte) 0, (byte) 229, (byte) 77, (byte) 251, (byte) 73, (byte) 133, (byte) 230, (byte) 3, (byte) 211, (byte) 64, (byte) 102, (byte) 153, (byte) 54, (byte) 207, (byte) 5, (byte) 144, (byte) 65, (byte) 223, (byte) 237, (byte) 58, (byte) 177, (byte) 170, (byte) 11};
    private static final byte[] WU4aKmKXqiwzkMjqODyZ = {(byte) 18, (byte) 172, (byte) 229, (byte) 21, (byte) 89, (byte) 222, (byte) 63, (byte) 154, (byte) 185, (byte) 66, (byte) 246, (byte) 28, (byte) 89, (byte) 196, (byte) 221, (byte) 253};
    private static String nMeGcvNxeoNiAdGj6k93s;
    private static String OlUZ4L6erhMpHxeCd;

    public HashMap<UUID, BossBarData> v8qP8fE86HMhvNuYPFjqY() {
        return new HashMap<>(this.v8qP8fE86HMhvNuYPFjqY);
    }

    public HashMap<UUID, MyScheduledTask> jBUuLP0sWwaPyPOmogdX7l() {
        return new HashMap<>(this.jBUuLP0sWwaPyPOmogdX7l);
    }

    private String v8qP8fE86HMhvNuYPFjqY(String str, int i) {
        return str.replace(N6iM7bzvw7JkFU(), String.valueOf(i));
    }

    private void ZwrsrwOCXRUscW6Q(UUID uuid) {
        MyScheduledTask myScheduledTaskRemove = this.jBUuLP0sWwaPyPOmogdX7l.remove(uuid);
        if (myScheduledTaskRemove != null) {
            myScheduledTaskRemove.cancel();
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        BossBarData bossBarDataRemove = this.v8qP8fE86HMhvNuYPFjqY.remove(uuid);
        if (bossBarDataRemove == null) {
            return;
        }
        ZwrsrwOCXRUscW6Q(uuid);
        Iterator<Player> it = bossBarDataRemove.getSender().iterator();
        while (it.hasNext()) {
            Player entity = (Player) it.next();
            if (entity != null && entity.isOnline()) {
                Clans.getClanCore().getTaskManager().v8qP8fE86HMhvNuYPFjqY(entity, () -> {
                    Audience audiencePlayer = Clans.getClanCore().getAdventure().player(entity);
                    if (audiencePlayer != null) {
                        bossBarDataRemove.getBossbar().progress(0.0f);
                        audiencePlayer.hideBossBar(bossBarDataRemove.getBossbar());
                    }
                });
            }
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return;
        }
        v8qP8fE86HMhvNuYPFjqY(player);
    }

    public void v8qP8fE86HMhvNuYPFjqY(Player player) {
        if (player == null) {
            return;
        }
        ArrayList<UUID> arrayList = new ArrayList<>();
        for (Map.Entry<UUID, BossBarData> entry : this.v8qP8fE86HMhvNuYPFjqY.entrySet()) {
            if (entry.getValue().getSender().contains(player)) {
                arrayList.add(entry.getKey());
            }
        }
        arrayList.forEach(this::v8qP8fE86HMhvNuYPFjqY);
    }

    public void ZwrsrwOCXRUscW6Q() {
        new ArrayList<UUID>(this.v8qP8fE86HMhvNuYPFjqY.keySet()).forEach(this::v8qP8fE86HMhvNuYPFjqY);
    }

    public UUID v8qP8fE86HMhvNuYPFjqY(Player player, BossBar.Color color, BossBar.Overlay overlay, List<BossBar.Flag> list, String str, int i, boolean z, List<String> list2) {
        MyScheduledTask myScheduledTaskRunTaskLater;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(YPu7SBwokrJbJG());
                if (strArrSplit.length >= 2) {
                    str = str.replace(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        String strJBUuLP0sWwaPyPOmogdX7l = Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str);
        UUID uuidRandomUUID = UUID.randomUUID();
        Audience audiencePlayer = Clans.getClanCore().getAdventure().player(player);
        BossBar bossBar = BossBar.bossBar(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(v8qP8fE86HMhvNuYPFjqY(strJBUuLP0sWwaPyPOmogdX7l, i)), 1.0f, color, overlay);
        if (list != null) {
            Iterator<BossBar.Flag> it2 = list.iterator();
            while (it2.hasNext()) {
                bossBar.addFlag(it2.next());
            }
        }
        Clans.getClanCore().getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player, () -> {
            audiencePlayer.showBossBar(bossBar);
        });
        this.v8qP8fE86HMhvNuYPFjqY.put(uuidRandomUUID, new BossBarData(Arrays.asList(player), bossBar));
        if (z) {
            int[] iArr = {i * 20};
            myScheduledTaskRunTaskLater = Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskTimer((Entity) player, () -> {
                if (iArr[0] <= 0) {
                    audiencePlayer.hideBossBar(bossBar);
                    bossBar.progress(0.0f);
                    v8qP8fE86HMhvNuYPFjqY(uuidRandomUUID);
                } else {
                    bossBar.progress(iArr[0] / (i * 20));
                    if (iArr[0] % 20 == 0) {
                        bossBar.name(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(v8qP8fE86HMhvNuYPFjqY(strJBUuLP0sWwaPyPOmogdX7l, iArr[0] / 20)));
                    }
                    iArr[0] = iArr[0] - 1;
                }
            }, 1L, 1L);
        } else {
            myScheduledTaskRunTaskLater = Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                audiencePlayer.hideBossBar(bossBar);
                bossBar.progress(0.0f);
                v8qP8fE86HMhvNuYPFjqY(uuidRandomUUID);
            }, ((long) i) * 20);
        }
        this.jBUuLP0sWwaPyPOmogdX7l.put(uuidRandomUUID, myScheduledTaskRunTaskLater);
        return uuidRandomUUID;
    }

    private static String N6iM7bzvw7JkFU() {
        return "{time}";
    }

    private static String YPu7SBwokrJbJG() {
        return ";";
    }
}

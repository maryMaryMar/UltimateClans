package me.ulrich.clans.qjkRaOgynIj1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 {
    private Scoreboard jBUuLP0sWwaPyPOmogdX7l;
    private Objective ZwrsrwOCXRUscW6Q;
    private static volatile String hfYApnoyLDdWmOewTP;
    private static volatile String Ud2f9JoWc2CmAhBoaBbkJy;
    private static String kja54aebjmznT9l;
    private static final byte[] mOx3Se2h8o8qpC = {(byte) 235, (byte) 250, (byte) 223, (byte) 229, (byte) 116, (byte) 145, (byte) 217, (byte) 171, (byte) 66, (byte) 131, (byte) 135, (byte) 148, (byte) 103, (byte) 208, (byte) 124, (byte) 146};
    private static final byte[] yobj6yYW48YLzc0DjJc4 = {(byte) 235, (byte) 250, (byte) 223, (byte) 229, (byte) 116, (byte) 145, (byte) 217, (byte) 171, (byte) 66, (byte) 131, (byte) 135, (byte) 148, (byte) 103, (byte) 208, (byte) 124, (byte) 146};
    private static final byte[] FhHirDoZ8lKfAERpDoAY = {(byte) 71, (byte) 133, (byte) 243, (byte) 186, (byte) 17, (byte) 214, (byte) 61, (byte) 135, (byte) 82, (byte) 134, (byte) 113, (byte) 29, (byte) 36, (byte) 178, (byte) 199, (byte) 35, (byte) 71, (byte) 248, (byte) 190, (byte) 200, (byte) 47, (byte) 154, (byte) 84, (byte) 169, (byte) 176, (byte) 255, (byte) 164, (byte) 236, (byte) 91, (byte) 186, (byte) 160, (byte) 86};
    private static final byte[] XxqlOA1Tl28koIYnQDsn = {(byte) 216, (byte) 110, (byte) 14, (byte) 93, (byte) 236, (byte) 48, (byte) 250, (byte) 91, (byte) 5, (byte) 145, (byte) 21, (byte) 242, (byte) 140, (byte) 250, (byte) 154, (byte) 205};
    public static HashMap<UUID, zTcC5XsAfoa1Tc1> v8qP8fE86HMhvNuYPFjqY = new HashMap<>();

    private zTcC5XsAfoa1Tc1(Player player) {
        if (v8qP8fE86HMhvNuYPFjqY(player)) {
            this.jBUuLP0sWwaPyPOmogdX7l = player.getScoreboard();
            this.ZwrsrwOCXRUscW6Q = this.jBUuLP0sWwaPyPOmogdX7l.getObjective(BFFzjIwP0dfAY3bS());
            return;
        }
        this.jBUuLP0sWwaPyPOmogdX7l = Bukkit.getScoreboardManager().getNewScoreboard();
        this.ZwrsrwOCXRUscW6Q = this.jBUuLP0sWwaPyPOmogdX7l.registerNewObjective(dJVjopKbNnvUMDrDHO1s(), G3WRDc6HtmsPcZDkDAcZh3());
        this.ZwrsrwOCXRUscW6Q.setDisplaySlot(DisplaySlot.SIDEBAR);
        for (int i = 1; i <= 15; i++) {
            this.jBUuLP0sWwaPyPOmogdX7l.registerNewTeam("SLOT_" + i).addEntry(jBUuLP0sWwaPyPOmogdX7l(i));
        }
        player.setScoreboard(this.jBUuLP0sWwaPyPOmogdX7l);
        v8qP8fE86HMhvNuYPFjqY.put(player.getUniqueId(), this);
    }

    public static boolean v8qP8fE86HMhvNuYPFjqY(Player player) {
        return v8qP8fE86HMhvNuYPFjqY.containsKey(player.getUniqueId());
    }

    public static boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        return v8qP8fE86HMhvNuYPFjqY.containsKey(uuid);
    }

    public static zTcC5XsAfoa1Tc1 jBUuLP0sWwaPyPOmogdX7l(Player player) {
        return new zTcC5XsAfoa1Tc1(player);
    }

    public static zTcC5XsAfoa1Tc1 jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        if (v8qP8fE86HMhvNuYPFjqY(uuid)) {
            return v8qP8fE86HMhvNuYPFjqY.get(uuid);
        }
        return null;
    }

    public static zTcC5XsAfoa1Tc1 ZwrsrwOCXRUscW6Q(UUID uuid) {
        return v8qP8fE86HMhvNuYPFjqY.remove(uuid);
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str) {
        try {
            this.ZwrsrwOCXRUscW6Q.setDisplayName(str.length() > 32 ? str.substring(0, 32) : str);
        } catch (Exception e) {
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, String str) {
        Team team = this.jBUuLP0sWwaPyPOmogdX7l.getTeam("SLOT_" + i);
        String strJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(i);
        if (!this.jBUuLP0sWwaPyPOmogdX7l.getEntries().contains(strJBUuLP0sWwaPyPOmogdX7l)) {
            this.ZwrsrwOCXRUscW6Q.getScore(strJBUuLP0sWwaPyPOmogdX7l).setScore(i);
        }
        String strJBUuLP0sWwaPyPOmogdX7l2 = jBUuLP0sWwaPyPOmogdX7l(str);
        String strJBUuLP0sWwaPyPOmogdX7l3 = jBUuLP0sWwaPyPOmogdX7l(ChatColor.getLastColors(strJBUuLP0sWwaPyPOmogdX7l2) + ZwrsrwOCXRUscW6Q(str));
        try {
            team.setPrefix(strJBUuLP0sWwaPyPOmogdX7l2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            team.setSuffix(strJBUuLP0sWwaPyPOmogdX7l3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i) {
        String strJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(i);
        if (this.jBUuLP0sWwaPyPOmogdX7l.getEntries().contains(strJBUuLP0sWwaPyPOmogdX7l)) {
            this.jBUuLP0sWwaPyPOmogdX7l.resetScores(strJBUuLP0sWwaPyPOmogdX7l);
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(List<String> list) {
        while (list.size() > 15) {
            list.remove(list.size() - 1);
        }
        int size = list.size();
        if (size < 15) {
            for (int i = size + 1; i <= 15; i++) {
                v8qP8fE86HMhvNuYPFjqY(i);
            }
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            v8qP8fE86HMhvNuYPFjqY(size, it.next());
            size--;
        }
    }

    private String jBUuLP0sWwaPyPOmogdX7l(int i) {
        return ChatColor.values()[i].toString();
    }

    private String jBUuLP0sWwaPyPOmogdX7l(String str) {
        return str.length() > 16 ? str.substring(0, 16) : str;
    }

    private String ZwrsrwOCXRUscW6Q(String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        return str.length() > 16 ? str.substring(16) : "";
    }

    private static String BFFzjIwP0dfAY3bS() {
        return "sidebar";
    }

    private static String dJVjopKbNnvUMDrDHO1s() {
        return "sidebar";
    }

    private static String G3WRDc6HtmsPcZDkDAcZh3() {
        return "dummy";
    }
}
